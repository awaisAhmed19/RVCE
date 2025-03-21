document
  .getElementById("registrationForm")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form submission

    let isValid = true;

    // Get form fields
    let name = document.getElementById("name").value.trim();
    let email = document.getElementById("email").value.trim();
    let phone = document.getElementById("phone").value.trim();
    let password = document.getElementById("password").value.trim();
    let confirmPassword = document
      .getElementById("confirmPassword")
      .value.trim();

    // Regex Patterns
    const namePattern = /^[A-Za-z\s]{3,30}$/;
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const phonePattern = /^\d{3}\d{3}\d{4}$/;
    const passwordPattern =
      /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    if (!namePattern.test(name)) {
      document.getElementById("nameError").style.display = "block";
      isValid = false;
    } else {
      document.getElementById("nameError").style.display = "none";
    }

    if (!emailPattern.test(email)) {
      document.getElementById("emailError").style.display = "block";
      isValid = false;
    } else {
      document.getElementById("emailError").style.display = "none";
    }

    if (!phonePattern.test(phone)) {
      document.getElementById("phoneError").style.display = "block";
      isValid = false;
    } else {
      document.getElementById("phoneError").style.display = "none";
    }

    if (!passwordPattern.test(password)) {
      document.getElementById("passwordError").style.display = "block";
      isValid = false;
    } else {
      document.getElementById("passwordError").style.display = "none";
    }

    if (password !== confirmPassword) {
      document.getElementById("confirmPasswordError").style.display = "block";
      isValid = false;
    } else {
      document.getElementById("confirmPasswordError").style.display = "none";
    }

    // If all fields are valid, submit the form
    if (isValid) {
      alert("Registration successful!");
      this.submit();
    }
  });
