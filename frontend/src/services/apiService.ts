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
            headers: authHeader(endPoint),
        };


        const promise = await fetch('/api/' + endPoint, requestOptions);

        if (promise.ok) {
            console.log(endPoint + ' fetched');
            return promise
        } else {
            throw new Error('Something went wrong when fetching data from ' + '/api/' + endPoint)
        }
    },
    postDataTo: async function (endPoint: string, body: unknown, headers?: Headers): Promise<Response> {

        const myHeaders = getHeaders();

        const requestOptions = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                Authorization: authHeader(endPoint)
            },
            body: JSON.stringify(body)
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

        const promise = await fetch('/api/' + endPoint, requestOptions)

        if (promise.ok) {
            console.log(endPoint + ' deleted');
            return promise
        } else {
            throw new Error('Something went wrong when deleting data')
        }
    },
}


function authHeader(url: string) {
    // return auth header with jwt if user is logged in and request is to the api url
    const { user } = useAuthStore();
    const isLoggedIn = !!user?.token;
    const isApiUrl = url.startsWith("auth");
    if (isLoggedIn && isApiUrl) {
        console.log("isLoggedIn && isApiUrl");
        return `Bearer ${user.token}`;
    } else {
        console.log("NOT isLoggedIn && isApiUrl");
        return {};
    }
}

export default ApiService
