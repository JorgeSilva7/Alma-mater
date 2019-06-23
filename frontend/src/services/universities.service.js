export const universitiesServices = {
    getAll,
};

const apiUrl = "http://almamater.softultra.cl:8080";

function getAll() {
    const requestOptions = {
        method: 'GET',
    };

    return fetch(apiUrl+'/universities', requestOptions).then(handleResponse);
}

function handleResponse(response) {
    return response.text().then(text => {
        const data = text && JSON.parse(text);
        if (!response.ok) {
            if (response.status === 406) {
                // auto logout if 406 response returned from api
                logout();
                location.reload(true);
                const error = (data && data.error) || response.statusText;
                return Promise.reject(error);
            }

            const error = (data && data.error) || response.statusText;
            return Promise.reject(error);
        }

        return data;
    });
}