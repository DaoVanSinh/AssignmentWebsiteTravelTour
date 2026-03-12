const urlParams = new URLSearchParams(window.location.search);
const bookingId = urlParams.get("bookingId");

let amount = 0;

fetch(`http://localhost:8080/api/bookings/${bookingId}`)
.then(res => res.json())
.then(data => {

    document.getElementById("customerName").innerText = data.customerName;
    document.getElementById("phone").innerText = data.phone;
    document.getElementById("email").innerText = data.email;
    document.getElementById("quantity").innerText = data.numberOfPeople;
    document.getElementById("specialRequest").innerText = data.specialRequest;

    amount = data.numberOfPeople * 1000000;

    document.getElementById("totalPrice").innerText = amount + " VND";

});

document.getElementById("buy").addEventListener("click", function(){

    fetch(`http://localhost:8080/api/payments/vnpay?bookingId=${bookingId}&amount=${amount}`)
    .then(res => res.json())
    .then(data => {

        window.location.href = data.paymentUrl;

    });

});