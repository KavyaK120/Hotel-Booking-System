// ===========================
// auth.js
// ===========================

// Check if user is logged in
function isLoggedIn() {
    return localStorage.getItem("loggedInUser") !== null;
}

// Get logged in user
function getLoggedInUser() {
    return JSON.parse(localStorage.getItem("loggedInUser"));
}

// Logout
function logout() {

    localStorage.removeItem("loggedInUser");

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