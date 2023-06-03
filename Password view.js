function togglePassword() {
    const passwordInput = document.querySelector('#password');
    const togglePasswordBtn = document.querySelector('#toggle-passic');
    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        togglePasswordBtn.textContent = 'Hide';
    } 
    else {
        passwordInput.type = 'password';
        togglePasswordBtn.textContent = 'Show';
    }
}