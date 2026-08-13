document.getElementById("loginForm").addEventListener("submit", async function (event) {

    event.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const loginData = {

        email: email,
        password: password

    };

    try {

        const result = await postData("/auth/login", loginData);

        if (result) {

            alert("Login successful!");

            // Store logged-in user
            localStorage.setItem("user", JSON.stringify(result));

            // Store logged-in user's ID
            localStorage.setItem("userId", result.id);

            // Go to hotels page
            window.location.href = "hotels.html";

        }

    } catch (error) {

        console.error("Login error:", error);

        alert("Invalid email or password.");

    }

});