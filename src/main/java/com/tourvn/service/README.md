# Service

- Chứa logic nghiệp vụ của hệ thống
- Mỗi chức năng có service riêng
- Không xử lý request trực tiếp

Ví dụ:

- BookingService.java
- TourService.java
- AuthService.java

Service:

- Nhận dữ liệu từ controller
- Xử lý nghiệp vụ
- Gọi repository để làm việc với database
