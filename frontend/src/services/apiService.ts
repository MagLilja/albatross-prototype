const ApiService = {
    getDataFrom: async function (endPoint: string, headers?: Headers): Promise<unknown> {

        var myHeaders = new Headers();
        myHeaders.append("cache", "no-cache");
        myHeaders.append("Content-Type", "application/json");


        var requestOptions = {
            method: 'GET',
            headers: headers ? headers : myHeaders,
        };


        const promise = await fetch('/api/' + endPoint, requestOptions)

        if (promise.ok) {
            console.log(endPoint + ' fetched');
            return await promise.json()
        } else {
            throw new Error('Something went wrong when fetching data')
        }
    }
}

export default ApiService
