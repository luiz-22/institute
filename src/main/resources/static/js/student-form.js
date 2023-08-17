document.addEventListener("DOMContentLoaded", function () {
    const studentForm = document.getElementById("studentForm");

    studentForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const studentData = {
            name: document.getElementById("name").value,
            lastname: document.getElementById("lastname").value,
            dni: parseInt(document.getElementById("dni").value),
            birthdate: document.getElementById("birthdate").value,
            address: {
                street: document.getElementById("street").value,
                number: parseInt(document.getElementById("number").value),
                city: document.getElementById("city").value,
                state: document.getElementById("state").value
            }
        };

        createStudent(studentData);
    });
});

async function createStudent(studentData) {
    const response = await fetch("/students", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(studentData)
    });

    if (response.ok) {
        window.location.href = "/students.html";
    } else {
        console.error("Error creating student:", response.statusText);
    }
}
