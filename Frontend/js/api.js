// =============================
// Backend Base URL
// =============================

const BASE_URL = "http://localhost:8082/api";


// =============================
// GET Request
// =============================

async function getData(endpoint) {

    const response = await fetch(`${BASE_URL}${endpoint}`);

    if (!response.ok) {
        throw new Error(`GET Error: ${response.status}`);
    }

    return await response.json();
}


// =============================
// POST Request
// =============================

async function postData(endpoint, data) {

    const response = await fetch(`${BASE_URL}${endpoint}`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(data)

    });

    if (!response.ok) {

        const errorText = await response.text();

        throw new Error(
            `POST Error: ${response.status} - ${errorText}`
        );
    }

    return await response.json();
}


// =============================
// PUT Request
// =============================

async function updateData(endpoint, data) {

    const response = await fetch(`${BASE_URL}${endpoint}`, {

        method: "PUT",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(data)

    });

    if (!response.ok) {

        const errorText = await response.text();

        throw new Error(
            `PUT Error: ${response.status} - ${errorText}`
        );
    }

    return await response.json();
}


// =============================
// DELETE Request
// =============================

async function deleteData(endpoint) {

    const response = await fetch(`${BASE_URL}${endpoint}`, {

        method: "DELETE"

    });

    if (!response.ok) {

        const errorText = await response.text();

        throw new Error(
            `DELETE Error: ${response.status} - ${errorText}`
        );
    }

    return await response.text();
}