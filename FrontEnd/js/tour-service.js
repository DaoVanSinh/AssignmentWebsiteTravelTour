const API_URL = "http://localhost:8080/api/tours";
const ADMIN_API = "http://localhost:8080/api/tours/manage"; 

// 1. Lấy danh sách Tour
async function getTours() {
    const response = await fetch(API_URL);
    return await response.json();
}

// 2. Thêm Tour mới
async function addTour(tourData) {
    await fetch(ADMIN_API, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(tourData)
    });
}

// 3. Cập nhật Tour (Sửa)
async function updateTour(id, tourData) {
    await fetch(`${ADMIN_API}/${id}`, {
        method: 'PUT', // Dùng PUT để cập nhật dữ liệu
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(tourData)
    });
}

// 4. Xóa Tour
async function deleteTour(id) {
    await fetch(`${ADMIN_API}/${id}`, { 
        method: 'DELETE' 
    });
}