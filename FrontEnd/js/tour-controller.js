let editId = null;
let toursList = []; // Mảng lưu trữ dữ liệu để lấy lại khi bấm Sửa

// Tự động chạy loadTours() khi mở web
document.addEventListener("DOMContentLoaded", loadTours);

async function loadTours() {
    try {
        toursList = await getTours();
        const tbody = document.getElementById("tourTableBody");
        tbody.innerHTML = "";

        toursList.forEach(t => {
            const tr = document.createElement("tr");
            
            // Format tiền tệ cho đẹp mắt
            const adultP = t.adultPrice ? t.adultPrice.toLocaleString('vi-VN') : 0;
            const childP = t.childPrice ? t.childPrice.toLocaleString('vi-VN') : 0;

            tr.innerHTML = `
                <td>${t.id}</td>
                <td>${t.title}</td>
                <td>${t.duration}</td>
                <td>${t.departure}</td>
                <td>${adultP} đ</td>
                <td>${childP} đ</td>
                <td>
                    <button class="btn-edit" onclick="editTour(${t.id})">Sửa</button>
                    <button class="btn-delete" onclick="removeTour(${t.id})">Xóa</button>
                </td>
            `;
            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error("Lỗi khi tải danh sách:", error);
    }
}

function openModal() {
    editId = null; // Chế độ Thêm mới
    document.getElementById("modalTitle").innerText = "Thêm Tour Mới";
    
    // Xóa trắng form
    document.getElementById("title").value = "";
    document.getElementById("description").value = "";
    document.getElementById("duration").value = "";
    document.getElementById("departure").value = "";
    document.getElementById("adultPrice").value = "";
    document.getElementById("childPrice").value = "";
    document.getElementById("imageUrl").value = "";
    
    document.getElementById("tourModal").style.display = "flex";
}

function closeModal() {
    document.getElementById("tourModal").style.display = "none";
}

function editTour(id) {
    // Tìm tour trong mảng đã lưu
    const tour = toursList.find(t => t.id === id);
    if (!tour) return;

    editId = tour.id; // Chế độ Cập nhật
    document.getElementById("modalTitle").innerText = "Sửa Tour";
    
    // Đổ dữ liệu cũ vào Form
    document.getElementById("title").value = tour.title;
    document.getElementById("description").value = tour.description;
    document.getElementById("duration").value = tour.duration;
    document.getElementById("departure").value = tour.departure;
    document.getElementById("adultPrice").value = tour.adultPrice;
    document.getElementById("childPrice").value = tour.childPrice;
    document.getElementById("imageUrl").value = tour.imageUrl;

    document.getElementById("tourModal").style.display = "flex";
}

async function saveTour() {
    const tourData = {
        title: document.getElementById("title").value,
        description: document.getElementById("description").value,
        duration: document.getElementById("duration").value,
        departure: document.getElementById("departure").value,
        adultPrice: Number(document.getElementById("adultPrice").value),
        childPrice: Number(document.getElementById("childPrice").value),
        imageUrl: document.getElementById("imageUrl").value
    };

    try {
        if (editId) {
            await updateTour(editId, tourData);
        } else {
            await addTour(tourData);
        }
        closeModal();
        loadTours(); // Tải lại bảng ngay lập tức
    } catch (error) {
        console.error("Lỗi khi lưu tour:", error);
        alert("Có lỗi xảy ra, hãy kiểm tra Console.");
    }
}

async function removeTour(id) {
    if (confirm("Bạn có chắc chắn muốn xóa Tour này?")) {
        try {
            await deleteTour(id);
            loadTours();
        } catch (error) {
            console.error("Lỗi khi xóa tour:", error);
        }
    }
}