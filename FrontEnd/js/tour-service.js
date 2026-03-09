// tour-service.js
const API_URL = "http://localhost:8080/api/tours";
const ADMIN_API = "http://localhost:8080/api/tours/manage";

const TourService = {
    // Lấy tất cả tour
    async fetchAll() {
        const res = await fetch(API_URL);
        return await res.json();
    },

    // Lưu tour mới (POST)
    async create(tourData) {
        return await fetch(ADMIN_API, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(tourData)
        });
    },

    // Xóa tour (DELETE)
    async remove(id) {
        return await fetch(`${ADMIN_API}/${id}`, { method: 'DELETE' });
    }
}