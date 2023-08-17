document.addEventListener("DOMContentLoaded", function () {
    fetchSubjects();
});

function fetchSubjects() {
    fetch("/subjects")
        .then(response => response.json())
        .then(subjects => displaySubjects(subjects))
        .catch(error => console.error("Error fetching subjects:", error));
}

function displaySubjects(subjects) {
    const subjectsTable = document.getElementById("subjectsTable");
    subjectsTable.innerHTML = "";

    if (subjects.length === 0) {
        subjectsTable.innerHTML = "<p>No subjects available.</p>";
        return;
    }

    const table = document.createElement("table");
    table.className = "table table-bordered";
    table.innerHTML = `
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            ${subjects.map(subject => `
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.name}</td>
                </tr>
            `).join("")}
        </tbody>
    `;

    subjectsTable.appendChild(table);
}

