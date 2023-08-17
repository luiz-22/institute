document.addEventListener("DOMContentLoaded", function() {
    fetchStudents();
});

async function fetchStudents() {
    const response = await fetch("/students");
    const students = await response.json();
    const studentTableBody = document.getElementById("student-table-body");

    students.forEach(student => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${student.id}</td>
            <td>${student.lastname}</td>
            <td>${student.name}</td>
            <td>${student.dni}</td>
        `;

        // Add 'pointer' class to make the row clickable
        row.classList.add("pointer");

        row.addEventListener("click", function() {
            window.location.href = `student.html?id=${student.id}`;
        });

        studentTableBody.appendChild(row);
    });
}
