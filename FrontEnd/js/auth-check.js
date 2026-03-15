
const user = JSON.parse(localStorage.getItem("user"));

const loginBtn = document.getElementById("login-btn");
const logoutBtn = document.getElementById("logout-btn");
const userName = document.getElementById("user-name");

if (user) {

    if (loginBtn) {
        loginBtn.style.display = "none";
    }

    if (logoutBtn) {
        logoutBtn.style.display = "inline-block";
    }

    if (userName) {
        userName.style.display = "inline-block";
        userName.innerText = "Xin chào, " + user.fullName;
    }

} else {

    if (loginBtn) {
        loginBtn.style.display = "inline-block";
    }

    if (logoutBtn) {
        logoutBtn.style.display = "none";
    }

}

const logoutButton = document.getElementById("logout-btn");

if (logoutButton) {

    logoutButton.addEventListener("click", function () {

        localStorage.removeItem("user");

        alert("Đã đăng xuất");

        window.location.href = "../pages/login.html";

    });

}