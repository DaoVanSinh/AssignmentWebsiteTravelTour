# DATABASE DESIGN – TOUR BOOKING SYSTEM

## 1. Tổng quan
Database phục vụ hệ thống đặt tour du lịch, bao gồm các chức năng:
- Đăng nhập / đăng ký
- Hiển thị tour
- Đặt tour
- Thanh toán
- Đánh giá tour

Tên database: `tour_booking_db`

---

## 2. Bảng users
Lưu thông tin người dùng.

| Cột | Kiểu dữ liệu | Mô tả |
|---|---|---|
| id | BIGINT | Khóa chính |
| full_name | VARCHAR(100) | Họ tên |
| email | VARCHAR(100) | Email (unique) |
| password | VARCHAR(255) | Mật khẩu |
| phone | VARCHAR(20) | Số điện thoại |
| role | VARCHAR(20) | USER / ADMIN |
| created_at | DATETIME | Ngày tạo |

---

## 3. Bảng tours
Lưu thông tin tour du lịch.

| Cột | Kiểu dữ liệu | Mô tả |
|---|---|---|
| id | BIGINT | Khóa chính |
| name | VARCHAR(150) | Tên tour |
| description | TEXT | Mô tả |
| price | DECIMAL | Giá |
| start_date | DATE | Ngày bắt đầu |
| end_date | DATE | Ngày kết thúc |
| max_people | INT | Số người tối đa |
| created_at | DATETIME | Ngày tạo |

---

## 4. Bảng bookings
Lưu thông tin đặt tour.

| Cột | Kiểu dữ liệu | Mô tả |
|---|---|---|
| id | BIGINT | Khóa chính |
| customer_name | VARCHAR(100) | Tên khách |
| phone | VARCHAR(20) | SĐT |
| email | VARCHAR(100) | Email |
| tour_id | BIGINT | FK → tours |
| number_of_people | INT | Số người |
| booking_date | DATETIME | Ngày đặt |
| status | VARCHAR(20) | CREATED / CANCELED |

---

## 5. Bảng payments
Lưu thông tin thanh toán.

| Cột | Kiểu dữ liệu | Mô tả |
|---|---|---|
| id | BIGINT | Khóa chính |
| booking_id | BIGINT | FK → bookings |
| amount | DECIMAL | Số tiền |
| payment_status | VARCHAR(20) | SUCCESS / FAILED |
| payment_date | DATETIME | Ngày thanh toán |

---

## 6. Bảng reviews
Lưu đánh giá tour.

| Cột | Kiểu dữ liệu | Mô tả |
|---|---|---|
| id | BIGINT | Khóa chính |
| user_id | BIGINT | FK → users |
| tour_id | BIGINT | FK → tours |
| rating | INT | 1–5 |
| comment | TEXT | Nhận xét |
| created_at | DATETIME | Ngày tạo |

