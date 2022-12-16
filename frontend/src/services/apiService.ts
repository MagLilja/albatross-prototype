import {useAuthStore} from "../stores/authStore";

function getHeaders() {
    const myHeaders = new Headers();
    myHeaders.append("cache", "no-cache");
    myHeaders.append("Content-Type", "application/json");
    return myHeaders;
}

const ApiService = {
    get: request('GET'),
    post: request('POST'),
    put: request('PUT'),
    delete: request('DELETE')
};

function request(method: string) {
    return (url: string, body?: unknown) => {
        const requestOptions = {
            method,
            headers: authHeader(url)
        };
        if (body) {
            requestOptions.headers['Content-Type'] = 'application/json';
            requestOptions.body = JSON.stringify(body);
        }
        return fetch(url, requestOptions).then(handleResponse);
    }
}



function authHeader(url: string) {
    // return auth header with jwt if user is logged in and request is to the api url
    const { user } = useAuthStore();
    let boolean = !!user?.accessToken;
    const isLoggedIn = boolean;
    const isApiUrl = url.startsWith("/api");
    if (isLoggedIn && isApiUrl) {
        let authorizationToken = `Bearer ${user.accessToken}`;
        return { Authorization: authorizationToken };
    } else {
        return {};
    }
}

function handleResponse(response: Response) {
    return response.text().then(text => {
        const data = text

        if (!response.ok) {
            const { user, logout } = useAuthStore();
            if ([401, 403].includes(response.status) && user) {
                // auto logout if 401 Unauthorized or 403 Forbidden response returned from api
                logout();
            }

            const error = (data) || response.statusText;
            return Promise.resolve(error);
        }

        return text && JSON.parse(text);
    });
}


export default ApiService
