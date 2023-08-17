// Fetch teachers data from the API
fetch('/teachers/with-subjects')
    .then(response => response.json())
    .then(teachers => {
        const teacherTableBody = document.getElementById('teacher-table-body');

        teachers.forEach(teacher => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${teacher.id}</td>
                <td>${teacher.lastname}</td>
                <td>${teacher.name}</td>
                <td>
                    <ul>
                        ${teacher.subjects.map(subject => `<li>${subject.name}</li>`).join('')}
                    </ul>
                </td>
            `;
            teacherTableBody.appendChild(row);
        });
    })
    .catch(error => console.error('Error fetching teachers:', error));
