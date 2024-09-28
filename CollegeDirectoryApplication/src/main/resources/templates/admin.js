document.addEventListener("DOMContentLoaded", function() {
    fetch("/api/admin/records")
    .then(response => response.json())
    .then(data => {
        const recordsList = document.getElementById("recordsList");
        data.forEach(record => {
            let row = document.createElement("tr");
            row.innerHTML = `
                <td><img src="${record.photo}" alt="Record Photo" class="record-photo"></td>
                <td>${record.name}</td>
                <td>${record.email}</td>
                <td>${record.phone}</td>
                <td>${record.role}</td>
                <td>
                    <button onclick="editRecord(${record.id})">Edit</button>
                    <button onclick="deleteRecord(${record.id})">Delete</button>
                </td>
            `;
            recordsList.appendChild(row);
        });
    })
    .catch(error => {
        console.error("Error fetching records:", error);
    });
});

function addNewRecord() {
    window.location.href = "/admin/add-record";
}

function editRecord(recordId) {
    window.location.href = '/admin/edit-record/${recordId}';
}

function deleteRecord(recordId) {
    fetch('/api/admin/delete-record/${recordId}', { method: "DELETE" })
        .then(() => {
            location.reload();
        })
        .catch(error => {
            console.error("Error deleting record:", error);
        });
}