function getHeaders() {
    const myHeaders = new Headers();
    myHeaders.append("cache", "no-cache");
    myHeaders.append("Content-Type", "application/json");
    return myHeaders;
}

const ApiService = {
    getDataFrom: async function (endPoint: string, headers?: Headers): Promise<unknown> {

        const myHeaders = getHeaders();


        const requestOptions = {
            method: 'GET',
            headers: headers ? headers : myHeaders,
        };


        const promise = await fetch('/api/' + endPoint, requestOptions)

        if (promise.ok) {
            console.log(endPoint + ' fetched');
            return  promise
        } else {
            throw new Error('Something went wrong when fetching data')
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
    }
}

export default ApiService
