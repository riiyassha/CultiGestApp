// script.js
document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.getElementById("login-form");
    const registerForm = document.getElementById("register-form");
    const toggleLogin = document.getElementById("toggle-login");
    const toggleRegister = document.getElementById("toggle-register");

    toggleLogin.addEventListener("click", function (e) {
        e.preventDefault();
        loginForm.style.display = "block";
        registerForm.style.display = "none";
    });

    toggleRegister.addEventListener("click", function (e) {
        e.preventDefault();
        loginForm.style.display = "none";
        registerForm.style.display = "block";
    });

    const loginFormFields = document.getElementById("login-form-fields");
    const registerFormFields = document.getElementById("register-form-fields");

});
