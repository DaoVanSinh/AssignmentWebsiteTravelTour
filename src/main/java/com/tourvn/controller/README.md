# Controller

- Chứa các class Controller (REST API)
- Mỗi chức năng tạo controller RIÊNG
- Không sửa controller của người khác

Ví dụ:
- BookingController.java (chức năng booking)
- TourController.java (chức năng tour)
- AuthController.java (đăng nhập / đăng ký)
- PaymentController.java (thanh toán)
- ReviewController.java (đánh giá)

Controller:
- Nhận request từ frontend
- Gọi service xử lý
- Trả response về frontend
