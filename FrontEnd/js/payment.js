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

document.getElementById("date").innerText = data.departureDate;
document.getElementById("specialRequest").innerText = data.specialRequest;

const tourRes = await fetch(`http://localhost:8080/api/admin/tours/${data.tourId}`);
const tour = await tourRes.json();

document.getElementById("tourCode").innerText = tour.id;
document.getElementById("duration").innerText = tour.duration;
document.getElementById("location").innerText = tour.departure;

document.getElementById("price").innerText =
new Intl.NumberFormat('vi-VN').format(tour.adultPrice) + " VND";

amount =
(data.adultQuantity * tour.adultPrice) +
(data.childQuantity * tour.childPrice);

document.getElementById("totalPrice").innerText =
new Intl.NumberFormat('vi-VN').format(amount) + " VND";

});

document.getElementById("buy").addEventListener("click", async function () {

try {

const response = await fetch(
`http://localhost:8080/api/payments/vnpay?bookingId=${bookingId}&amount=${amount}`
);

if (!response.ok) {
throw new Error("VNPay API lỗi");
}

const data = await response.json();

console.log("VNPay URL:", data.paymentUrl);

window.location.href = data.paymentUrl;

}
catch(error){

console.error("Lỗi VNPay:", error);
alert("Không thể kết nối VNPay");

}

});
