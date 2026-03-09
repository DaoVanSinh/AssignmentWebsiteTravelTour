// tour-controller.js

// Hàm hiển thị dữ liệu lên bảng
async function renderTours() {
    const tours = await TourService.fetchAll();
    const tbody = document.getElementById('tour-data');
    tbody.innerHTML = tours.map(t => `
        <tr>
            <td>${t.id}</td>
            <td>${t.name}</td>
            <td>${t.price.toLocaleString()}đ</td>
            <td>${t.startDate}</td>
            <td>
                <button onclick="handleDelete(${t.id})">Xóa</button>
            </td>
        </tr>
    `).join('');
}

// Hàm xử lý khi nhấn nút Xóa
async function handleDelete(id) {
    if(confirm("Bạn có chắc chắn muốn xóa tour này?")) {
        await TourService.remove(id);
        renderTours(); // Tải lại bảng ngay lập tức
    }
}

// Tự động chạy khi mở trang
window.onload = renderTours;