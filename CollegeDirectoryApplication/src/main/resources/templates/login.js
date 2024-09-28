document.getElementById("loginForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;

    fetch("/api/auth", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password, role })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Invalid login credentials");
        }
        return response.json();
    })
    .then(data => {
        if (role === "STUDENT") {
            window.location.href = "/student-dashboard";
        } else if (role === "FACULTY_MEMBER") {
            window.location.href = "/faculty-dashboard";
        } else if (role === "ADMINISTRATOR") {
            window.location.href = "/admin-dashboard";
        }
    })
    .catch(error => {
        document.getElementById("errorMessage").textContent = error.message;
    });
});