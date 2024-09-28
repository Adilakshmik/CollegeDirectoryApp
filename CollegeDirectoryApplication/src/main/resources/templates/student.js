document.addEventListener("DOMContentLoaded", function() {
    fetch("/api/student/profile")
    .then(response => response.json())
    .then(data => {
        document.getElementById("studentPhoto").src = data.photo;
        document.getElementById("studentName").textContent = data.name;
        document.getElementById("studentEmail").textContent = data.email;
        document.getElementById("studentPhone").textContent = data.phone;

        const coursesList = document.getElementById("studentCourses");
        data.courses.forEach(course => {
            let li = document.createElement("li");
            li.textContent = course.title;
            coursesList.appendChild(li);
        });
    })
    .catch(error => {
        console.error("Error fetching student profile:", error);
    });
});