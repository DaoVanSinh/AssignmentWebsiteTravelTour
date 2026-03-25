document.addEventListener("DOMContentLoaded", function() {
    // Lấy phần tử Canvas từ HTML
    const ctx = document.getElementById('revenueChart').getContext('2d');

    // Dữ liệu giả định (Sau này sẽ gọi API từ Spring Boot để nhét vào đây)
    const tourNames = ['Phú Quốc', 'Hạ Long', 'Nha Trang', 'Đà Nẵng'];
    const revenues = [65000000, 25000000, 15500000, 20000000]; // Đơn vị: VNĐ

    // Vẽ biểu đồ
    new Chart(ctx, {
        type: 'bar', // Biểu đồ dạng cột (bar). Có thể đổi thành 'pie' (tròn) hoặc 'line' (đường)
        data: {
            labels: tourNames,
            datasets: [{
                label: 'Doanh thu (VNĐ)',
                data: revenues,
                backgroundColor: [
                    'rgba(54, 162, 235, 0.6)', // Xanh dương
                    'rgba(255, 99, 132, 0.6)', // Đỏ
                    'rgba(255, 206, 86, 0.6)', // Vàng
                    'rgba(75, 192, 192, 0.6)'  // Xanh lục
                ],
                borderColor: [
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 99, 132, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});