//login
const loginForm = document.getElementById("login-form");
if (loginForm) {
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
}


//register
const registerForm = document.getElementById("register-form");

if (registerForm) {
    registerForm.addEventListener("submit", async function (e) {
        e.preventDefault();

        const fullName = document.getElementById("fullName").value.trim();
        const email = document.getElementById("email").value.trim();
        const phone = document.getElementById("phone").value.trim();
        const password = document.getElementById("password").value.trim();
        const cfPassword = document.getElementById("cfPassword").value.trim();
        const agree = document.getElementById("agree").checked;


        if (password !== cfPassword) {
            alert("Mật khẩu không khớp");
            return;
        }

        if(!agree){
            alert("Vui lòng chấp nhận điều khoản");
            return;
        }

        const data = {
            fullName: fullName,
            email: email,
            phone: phone,
            password: password
        };

        try {
            const response = await fetch("http://localhost:8080/api/auth/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            });

            const result = await response.json();

            if (response.ok) {
                alert("Đăng ký thành công");
                window.location.href = "../pages/login.html";
            } else {
                alert(result.message || "Đăng ký thất bại");
            }
        } catch (error) {
            console.error(error);
            alert("Không thể kết nối server");
        }
    });
}

//forgot-password
const forgotForm = document.getElementById("forgot-password-form");

if(forgotForm){
    forgotForm.addEventListener("submit",function(e){
        e.preventDefault();

        const email = document.getElementById("email").value.trim();

        if(!email){
            alert("Vui lòng nhập email");
            return;
        }

        localStorage.setItem("resetEmail",email);

        window.location.href = "../pages/reset-password.html";
    })
}

//reset-password
const resetForm = document.getElementById("reset-password-form");

if(resetForm){
    resetForm.addEventListener("submit",async function (e){
        e.preventDefault();

        const email = localStorage.getItem("resetEmail");
        const newPassword = document.getElementById("newPassword").value.trim();
        const cfPassword = document.getElementById("cfPassword").value.trim();

        if(newPassword !== cfPassword){
            alert("Mật khẩu không khớp! Vui lòng nhập lại");
            return;
        }

        try{
            const response = await fetch("http://localhost:8080/api/auth/forgot-password",{
                method: "POST",
                headers:{
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    email: email,
                    newPassword: newPassword
                })
            });

            const result = await response.json();

            if(response.ok){
                alert("Đổi mật khẩu thành công!");
                window.location.href="../pages/login.html";
            }else{
                console.error(error);
                alert(result.message || "Đổi mật khẩu thất bại");
            }
        }catch{
            console.error(error);
            alert("Không thể kết nối server");
        }
    });
}