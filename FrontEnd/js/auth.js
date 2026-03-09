//login
const loginForm = document.getElementById("login-form");

loginForm.addEventListener("submit", function (event) {
    event.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: email,
            password: password
        })
    }).then(response => {
        if (!response.ok) {
            throw new Error("Đăng nhập thất bại");
        }
        return response.json();
    }).then(data => {
        console.log("Đăng nhập thành công: ", data);

        localStorage.setItem("user", JSON.stringify(data));

        alert("Đăng nhập thành công");

        window.location.href = "#";
    }).catch(error => {
        alert("Sai email hoặc mật khẩu");
        console.log(error);
    });
});

//register
const registerForm = document.getElementById("register-form");

registerForm.addEventListener("submit", async function (e) {
    e.preventDefault();

    const fullName = document.getElementById("fullName").value.trim();
    const email = document.getElementById("email").value.trim();
    const phone = document.getElementById("phone").value.trim();
    const password = document.getElementById("password").value.trim();
    const cfPassword = document.getElementById("cfPassword").value.trim();

    if(password !== cfPassword){
        alert("Mật khẩu không khớp");
        return;
    }

    const data = {
        fullName: fullName,
        email: email,
        phone: phone,
        password: password
    };

    try{
        const response = await fetch("http://localhost:8080/api/auth/register",{
            method: "POST",
            headers:{
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        const result = await response.json();

        if(response.ok){
            alert("Đăng ký thành công");
            window.location.href="../pages/login.html";
        }else{
            alert(result.message || "Đăng ký thất bại");
        }
    }catch(error){
        console.error(error);
        alert("Không thể kết nối server");
    }
});   