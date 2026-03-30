document.addEventListener("DOMContentLoaded", function () {

    loadTour();

    const bookingForm = document.getElementById("bookingForm");

    bookingForm.addEventListener("submit", async function(e){

        e.preventDefault();

        document.getElementById("nameError").innerText = "";
        document.getElementById("phoneError").innerText = "";
        document.getElementById("adultError").innerText = "";
        document.getElementById("emailError").innerText = "";
        document.getElementById("message").innerText = "";

        const name = document.getElementById("customerName").value.trim();
        const phone = document.getElementById("phone").value.trim();
        const email = document.getElementById("bookingEmail").value.trim();

        const adultQuantity = parseInt(document.getElementById("adultQuantity").value) || 0;
        const childQuantity = parseInt(document.getElementById("childQuantity").value) || 0;

        let hasError = false;

        if(name === ""){
            document.getElementById("nameError").innerText =
            "Vui lòng nhập họ và tên";
            hasError = true;
        }

        const phoneRegex = /^0\d{9}$/;

        if(!phoneRegex.test(phone)){
            document.getElementById("phoneError").innerText =
            "Vui lòng kiểm tra lại số điện thoại";
            hasError = true;
        }

        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if(!emailRegex.test(email)){
            document.getElementById("emailError").innerText =
            "Email không đúng định dạng";
            hasError = true;
        }

        if(adultQuantity < 1){
            document.getElementById("adultError").innerText =
            "Vui lòng nhập ít nhất 1 người lớn";
            hasError = true;
        }

        if(hasError){
            return;
        }

        const totalPeople = adultQuantity + childQuantity;

        const bookingData = {

            customerName: name,
            email: email,
            phone: phone,

            tourId: parseInt(document.getElementById("tourId").value),

            numberOfPeople: totalPeople,

            adultQuantity: adultQuantity,
            childQuantity: childQuantity,

            specialRequest: document.getElementById("specialRequest").value,

            departureDate: document.getElementById("departureDate").value

        };

        console.log("Data gửi đi:", bookingData);

        try{

            const response = await fetch("http://localhost:8080/api/bookings",{

                method:"POST",

                headers:{
                    "Content-Type":"application/json"
                },

                body: JSON.stringify(bookingData)

            });

            if(!response.ok){
                const errorData = await response.json();
                document.getElementById("message").innerText =
                    errorData.message || "Lỗi từ server";
                return;
            }

            const result = await response.json();

            console.log("Booking created:", result);

            window.location.href =
            "../pages/payment.html?bookingId=" + result.id;

        }
        catch(error){

            console.error("Lỗi:",error);

            document.getElementById("message").innerText =
            "Lỗi khi gọi API";

        }

    });

});

function loadTour(){

    const today = new Date();
    today.setDate(today.getDate() + 1);

    const minDate = today.toISOString().split("T")[0];
    document.getElementById("departureDate").min = minDate;

    const urlParams = new URLSearchParams(window.location.search);
    const tourId = urlParams.get("id");

    if(!tourId) return;

    fetch("http://localhost:8080/api/admin/tours/" + tourId)

    .then(response => {
        if (!response.ok) {
            throw new Error("Lỗi load tour");
        }
        return response.json();
    })

    .then(data => {

        document.getElementById("tourCode").innerText = data.id;
        document.getElementById("duration").innerText = data.duration;
        document.getElementById("location").innerText = data.departure;
        document.getElementById("tourDescription").innerText = data.description;

        document.getElementById("price").innerText =
        new Intl.NumberFormat('vi-VN').format(data.adultPrice) + " VNĐ";

        document.getElementById("adultPrice").innerText =
        new Intl.NumberFormat('vi-VN').format(data.adultPrice) + " VNĐ";

        document.getElementById("childPrice").innerText =
        new Intl.NumberFormat('vi-VN').format(data.childPrice) + " VNĐ";

        document.getElementById("tourImage").src = data.imageUrl;

        document.querySelector("h2").innerText = data.title;

        document.getElementById("tourId").value = data.id;

    })

    .catch(error => console.error("Lỗi load tour:", error));

}