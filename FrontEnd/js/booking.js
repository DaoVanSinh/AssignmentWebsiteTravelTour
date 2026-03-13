document.getElementById("bookingForm").addEventListener("submit", async function(e){

// Lấy id tour từ URL
const urlParams = new URLSearchParams(window.location.search);
const tourId = urlParams.get("id");

if(tourId){

fetch("http://localhost:8080/api/tours/" + tourId)
.then(response => response.json())
.then(data => {

document.getElementById("tourCode").innerText = data.id;
document.getElementById("duration").innerText = data.duration;
document.getElementById("date").innerText = data.startDate;
document.getElementById("location").innerText = data.departure;

document.getElementById("price").innerText =
new Intl.NumberFormat('vi-VN').format(data.adultPrice) + " VND";

document.getElementById("adultPrice").innerText =
new Intl.NumberFormat('vi-VN').format(data.adultPrice) + " VND";

document.getElementById("childPrice").innerText =
new Intl.NumberFormat('vi-VN').format(data.childPrice) + " VND";

document.getElementById("tourImage").src = "../images/" + data.imageUrl;

document.querySelector("h2").innerText = data.title;

// gán tourId vào form booking
document.getElementById("tourId").value = data.id;

})
.catch(error => console.error("Lỗi load tour:", error));

}

e.preventDefault();

const bookingData = {

customerName: document.getElementById("customerName").value,
email: document.getElementById("email").value,
phone: document.getElementById("phone").value,
tourId: parseInt(document.getElementById("tourId").value),
numberOfPeople: parseInt(document.getElementById("quantity").value),
specialRequest: document.getElementById("specialRequest").value


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
throw new Error("API lỗi");
}

const result = await response.json();

console.log("Booking created:", result);

document.getElementById("message").innerText="Đặt tour thành công!";

}catch(error){

console.error("Lỗi:",error);

document.getElementById("message").innerText="Lỗi khi gọi API";

}

});