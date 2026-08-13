document.getElementById("registerForm").addEventListener("submit", async function (event) {

    event.preventDefault();

    // Get form values
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    // Check passwords
    if (password !== confirmPassword) {

        alert("Passwords do not match!");
        return;
    }

    // Create user object
    const user = {

        name: name,
        email: email,
        phone: phone,
        password: password

    };

    try {

        // Send data to Spring Boot
        const result = await postData("/auth/register", user);

        if (result) {

            alert("Registration successful!");

            // Go to login page
            window.location.href = "login.html";
        }

    } catch (error) {

        console.error("Registration error:", error);

        alert("Registration failed. Please try again.");

    }

});