document.getElementById("bookingForm").addEventListener("submit", async function(e){

e.preventDefault();

const bookingData = {

customerName: document.getElementById("customerName").value,
email: document.getElementById("email").value,
phone: document.getElementById("phone").value,
tourId: parseInt(document.getElementById("tourId").value),
numberOfPeople: parseInt(document.getElementById("quantity").value)

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