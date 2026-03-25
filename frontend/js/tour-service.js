
const API_URL = "http://localhost:8080/api/admin/tours";

// 1. Lấy danh sách Tour
async function getTours() {
    const response = await fetch(API_URL);
    return await response.json();
}

// 2. Thêm Tour mới
async function addTour(tourData) {
    const response = await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(tourData)
    });

    if (!response.ok) {
        const errorText = await response.text();
        console.error("Backend lỗi:", errorText);
        throw new Error("Thêm tour thất bại");
    }

    return await response.json();
}

// 3. Cập nhật Tour (Sửa)
async function updateTour(id, tourData) {
    const response = await fetch(`${API_URL}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(tourData)
    });

    if (!response.ok) {
        const errorText = await response.text();
        console.error("Backend lỗi:", errorText);
        throw new Error("Cập nhật thất bại");
    }

    return await response.json();
}

// 4. Xóa Tour
async function deleteTour(id) {
    await fetch(`${API_URL}/${id}`, { 
        method: 'DELETE' 
    });
}