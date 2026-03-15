const urlParams = new URLSearchParams(window.location.search);
const bookingId = urlParams.get("bookingId");

let amount = 0;

fetch(`http://localhost:8080/api/bookings/${bookingId}`)
.then(res => res.json())
.then(async data => {

document.getElementById("customerName").innerText = data.customerName;
document.getElementById("phone").innerText = data.phone;
document.getElementById("email").innerText = data.email;
document.getElementById("adultQuantity").innerText = data.adultQuantity;
document.getElementById("childQuantity").innerText = data.childQuantity;
document.getElementById("quantity").innerText =
data.adultQuantity + data.childQuantity;

document.getElementById("quantity").innerText =data.adultQuantity + data.childQuantity;
document.getElementById("date").innerText = data.departureDate;
document.getElementById("specialRequest").innerText = data.specialRequest;


const tourRes = await fetch(`http://localhost:8080/api/admin/tours/${data.tourId}`);
const tour = await tourRes.json();

document.getElementById("tourCode").innerText = tour.id;
document.getElementById("duration").innerText = tour.duration;
document.getElementById("location").innerText = tour.departure;

document.getElementById("price").innerText =
new Intl.NumberFormat('vi-VN').format(tour.adultPrice) + " VND";


amount =(data.adultQuantity * tour.adultPrice) +(data.childQuantity * tour.childPrice);

document.getElementById("totalPrice").innerText =
new Intl.NumberFormat('vi-VN').format(amount) + " VND";

});
document.getElementById("buy").addEventListener("click", async function(){

const paymentData = {

bookingId: parseInt(bookingId),
amount: amount,
paymentMethod: "CASH",
paymentStatus: "PAID"

};

console.log("Payment gửi đi:", paymentData);

try{

const response = await fetch("http://localhost:8080/api/payments",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body: JSON.stringify(paymentData)

});

if(!response.ok){
throw new Error("Payment API lỗi");
}

const result = await response.json();

console.log("Payment thành công:", result);

alert("Thanh toán thành công!");

window.location.href = "../pages/home.html";

}
catch(error){

console.error("Lỗi payment:", error);

alert("Thanh toán thất bại");

window.location.href = "payment.html?bookingId=" + bookingId;

}

});