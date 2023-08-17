// Fetch subjects data from the API
fetch('/subjects')
    .then(response => response.json())
    .then(subjects => {
        const subjectsSelect = document.getElementById('subjects');

        subjects.forEach(subject => {
            const option = document.createElement('option');
            option.value = subject.id;
            option.textContent = subject.name;
            subjectsSelect.appendChild(option);
        });
    })
    .catch(error => console.error('Error fetching subjects:', error));

// Handle form submission
const teacherForm = document.getElementById('teacherForm');

teacherForm.addEventListener('submit', event => {
    event.preventDefault();

    const name = teacherForm.name.value;
    const lastname = teacherForm.lastname.value;
    const selectedSubjects = Array.from(teacherForm.subjects.selectedOptions).map(option => parseInt(option.value));

    const teacherData = {
        name: name,
        lastname: lastname
    };

    // Send teacher data to the API for creation
    fetch('/teachers', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(teacherData)
    })
    .then(response => response.json())
    .then(teacher => {
        // After successful teacher creation, establish subject relations
        const teacherId = teacher.id;
        const subjectRelations = selectedSubjects.map(subjectId => {
            return {
                teacherId: teacherId,
                subjectId: subjectId
            };
        });

        // Send subject relations data to the API for creation
        return Promise.all(subjectRelations.map(relation => {
            return fetch('/teaches', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(relation)
            });
        }));
    })
    .then(responses => {
        // Redirect to teachers.html after successful creation of teacher and relations
        window.location.href = '/teachers.html';
    })
    .catch(error => console.error('Error creating teacher and subject relations:', error));
});
