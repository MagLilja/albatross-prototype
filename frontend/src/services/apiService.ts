import {useAuthStore} from "../stores/auth.store";

function getHeaders() {
    const myHeaders = new Headers();
    myHeaders.append("cache", "no-cache");
    myHeaders.append("Content-Type", "application/json");
    return myHeaders;
}

const ApiService = {
    getDataFrom: async function (endPoint: string, headers?: Headers): Promise<Response> {

        const myHeaders = getHeaders();


        const requestOptions = {
            method: 'GET',
            headers: headers ? headers : myHeaders,
        };


        const promise = await fetch('/api/' + endPoint, requestOptions)

        if (promise.ok) {
            console.log(endPoint + ' fetched');
            return promise
        } else {
            throw new Error('Something went wrong when fetching data from ' + '/api/' + endPoint)
        }
    },
    postDataTo: async function (endPoint: string, data: unknown, headers?: Headers): Promise<Response> {

        const myHeaders = getHeaders();

        const requestOptions = {
            method: 'POST',
            headers: headers ? headers : myHeaders,
            body: JSON.stringify(data)
        };

        const promise = await fetch('/api/' + endPoint, requestOptions)

        if (promise.ok) {
            console.log(endPoint + ' posted');
            return promise
        } else {
            throw new Error('Something went wrong when posting data')
        }
    },
    deleteData: async function (endPoint: string, headers?: Headers): Promise<Response> {

        const myHeaders = getHeaders();

        const requestOptions = {
            method: 'DELETE',
            headers: headers ? headers : myHeaders,
        };



function authHeader(url: string) {
    // return auth header with jwt if user is logged in and request is to the api url
    const { user } = useAuthStore();
    const isLoggedIn = !!user?.token;
    const isApiUrl = url.startsWith("api");
    if (isLoggedIn && isApiUrl) {
        return { Authorization: `Bearer ${user.token}` };
    } else {
        return {};
    }
}

function handleResponse(response: Response) {
    return response.text().then(text => {
        const data = text && JSON.parse(text);

        if (!response.ok) {
            const { user, logout } = useAuthStore();
            if ([401, 403].includes(response.status) && user) {
                // auto logout if 401 Unauthorized or 403 Forbidden response returned from api
                logout();
            }

            const error = (data && data.message) || response.statusText;
            return Promise.reject(error);
        }

        return data;
    });
}


export default ApiService
