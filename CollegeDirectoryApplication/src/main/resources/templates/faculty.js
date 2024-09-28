document.addEventListener("DOMContentLoaded", function() {
    // Fetch the class data from the API
    fetch("/api/faculty/classes")
    .then(response => {
        // Check if the response status is OK
        if (!response.ok) {
            throw new Error("Network response was not ok " + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        // Check if the classList element exists
        const classList = document.getElementById("classList");
        if (!classList) {
            throw new Error("Class list element not found");
        }
        // Iterate through each student and create table rows
        data.forEach(student => {
            let row = document.createElement("tr");
            row.innerHTML = `
                <td><img src="${student.photo}" alt="Student Photo" class="student-photo"></td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.phone}</td>
            `;
            classList.appendChild(row);
        });
    })
    .catch(error => {
        // Handle any errors that occurred during the fetch
        console.error("Error fetching class list:", error);
    });
});
