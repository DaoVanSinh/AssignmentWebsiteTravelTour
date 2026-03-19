const API_URL = "http://localhost:8080/api/admin/tours";

const params = new URLSearchParams(window.location.search);
const payment = params.get("payment");

if (payment === "success") {
    alert("Thanh toán thành công!");
}
document.addEventListener("DOMContentLoaded", loadTours);

async function loadTours() {
    try {
        const response = await fetch(API_URL);
        const tours = await response.json();

        renderTours(tours);

    } catch (error) {
        console.error("Lỗi khi load tour:", error);
    }
}
function renderTours(tours) {
    const grid = document.querySelector(".tour-grid");
    grid.innerHTML = "";

    tours.forEach((tour) => {

        const price = formatPrice(tour.adultPrice);
        const date = formatDate(tour.startDate);

        const card = document.createElement("div");
        card.className = "tour-card";

        card.innerHTML = `
        <div class="tour-banner">
            <img src="${tour.imageUrl}" alt="${tour.title}" />
        </div>

        <div class="tour-info">
            <h3 class="tour-name">${tour.title}</h3>

            <p class="tour-departure">Nơi khởi hành: ${tour.departure}</p>

            <p class="tour-price">${price}</p>

            <div class="date-chips">
                <span class="chip">${date}</span>
            </div>
        </div>
        `;

        card.addEventListener("click", () => {
            window.location.href = `booking.html?id=${tour.id}`;
        });

        grid.appendChild(card);
    });
}
async function searchTours() {
    const name = document.getElementById("searchName").value.toLowerCase();
    const departure = document.getElementById("searchDeparture").value.toLowerCase();
    const price = document.getElementById("searchPrice").value;

    try {
        const response = await fetch(API_URL);
        const tours = await response.json();

        const filtered = tours.filter(tour => {
            return (
                tour.title.toLowerCase().includes(name) &&
                tour.departure.toLowerCase().includes(departure) &&
                (!price || tour.adultPrice <= price)
            );
        });

        renderTours(filtered);

    } catch (error) {
        console.error("Lỗi khi search:", error);
    }
}
function formatPrice(price) {
    if (!price) return "";

    return price.toLocaleString("vi-VN") + " VNĐ";
}
function formatDate(date) {
    if (!date) return "";

    const d = new Date(date);
    const day = String(d.getDate()).padStart(2, "0");
    const month = String(d.getMonth() + 1).padStart(2, "0");

    return `${day}/${month}`;
}