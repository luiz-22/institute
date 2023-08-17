// DOM elements
const studentNameElement = document.getElementById("studentName");
const studentLastnameElement = document.getElementById("studentLastname");
const studentDniElement = document.getElementById("studentDni");
const studentBirthdateElement = document.getElementById("studentBirthdate");
const addressStreetElement = document.getElementById("addressStreet");
const addressNumberElement = document.getElementById("addressNumber");
const addressCityElement = document.getElementById("addressCity");
const addressStateElement = document.getElementById("addressState");
const coursesListElement = document.getElementById("coursesList");
const updateFormContainer = document.getElementById("updateFormContainer");
const updateForm = document.getElementById("updateForm");
const cancelUpdateBtn = document.getElementById("cancelUpdateBtn");
const addCourseFormContainer = document.getElementById("addCourseFormContainer");
const addCourseForm = document.getElementById("addCourseForm");
const cancelAddCourseBtn = document.getElementById("cancelAddCourseBtn");

// Function to fetch and populate student and address details
async function fetchStudentAndAddress() {
    // Replace with actual API endpoint and logic
    const urlParams = new URLSearchParams(window.location.search);
    const studentId = urlParams.get("id"); // Replace with the actual student ID
    const response = await fetch(`/students/${studentId}`);
    const studentData = await response.json();

    studentNameElement.textContent = studentData.name;
    studentLastnameElement.textContent = studentData.lastname;
    studentDniElement.textContent = studentData.dni;
    studentBirthdateElement.textContent = studentData.birthdate;
    addressStreetElement.textContent = studentData.address.street;
    addressNumberElement.textContent = studentData.address.number;
    addressCityElement.textContent = studentData.address.city;
    addressStateElement.textContent = studentData.address.state;
}
