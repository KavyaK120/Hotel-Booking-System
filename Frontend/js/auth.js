// ===========================
// auth.js
// ===========================

// Check if user is logged in
function isLoggedIn() {

    return localStorage.getItem("user") !== null;

}


// Get logged in user
function getLoggedInUser() {

    return JSON.parse(
        localStorage.getItem("user")
    );

}


// Logout
function logout() {

    localStorage.removeItem("user");

    localStorage.removeItem("userId");

    localStorage.removeItem("booking");

    alert("Logged out successfully!");

    window.location.href = "login.html";

}


// Protect pages
function protectPage() {

    if (!isLoggedIn()) {

        alert("Please login first.");

        window.location.href = "login.html";

    }

}