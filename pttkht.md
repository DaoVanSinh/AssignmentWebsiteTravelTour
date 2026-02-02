# TÀI LIỆU PHÂN TÍCH VÀ THIẾT KẾ HỆ THỐNG

## HỆ THỐNG QUẢN LÝ TOUR DU LỊCH (CHỨC NĂNG CRUD)

---

## 1. Giới thiệu

### 1.1. Mục tiêu

Xây dựng tài liệu phân tích và thiết kế hệ thống cho** ****chức năng CRUD Tour** (Create – Read – Update – Delete) trong hệ thống quản lý tour du lịch, phục vụ cho việc học tập và phát triển phần mềm.

### 1.2. Phạm vi

* Quản lý thông tin tour du lịch
* Áp dụng cho hệ thống web/app quản lý du lịch
* Không bao gồm thanh toán trực tuyến

---

## 2. Mô tả tổng quan hệ thống

### 2.1. Các tác nhân (Actors)

* **Quản trị viên (Admin)** : quản lý tour (thêm, sửa, xóa)
* **Nhân viên** : xem, cập nhật thông tin tour
* **Khách hàng** : xem danh sách tour

### 2.2. Chức năng chính

* Thêm mới tour
* Xem danh sách và chi tiết tour
* Cập nhật thông tin tour
* Xóa tour
* Tìm kiếm, lọc tour

---

## 3. Phân tích yêu cầu

### 3.1. Yêu cầu chức năng (Functional Requirements)

| Mã | Tên yêu cầu  | Mô tả                            |
| --- | --------------- | ---------------------------------- |
| FR1 | Thêm tour      | Thêm mới một tour du lịch      |
| FR2 | Xem tour        | Xem danh sách & chi tiết tour    |
| FR3 | Cập nhật tour | Sửa thông tin tour               |
| FR4 | Xóa tour       | Xóa tour khỏi hệ thống         |
| FR5 | Tìm kiếm tour | Tìm theo tên, giá, địa điểm |

### 3.2. Yêu cầu phi chức năng (Non-functional Requirements)

* Giao diện dễ sử dụng
* Phản hồi nhanh
* Bảo mật phân quyền người dùng
* Dữ liệu chính xác, toàn vẹn

---

## 4. Mô hình nghiệp vụ

### 4.1. Mô tả nghiệp vụ CRUD Tour

1. Admin đăng nhập hệ thống
2. Chọn chức năng quản lý tour
3. Thực hiện thêm / sửa / xóa / xem tour
4. Hệ thống kiểm tra dữ liệu
5. Lưu dữ liệu vào CSDL

---

## 5. Thiết kế hệ thống bằng UML

### 5.1. Use Case Diagram (mô tả)

* Actor: Admin, Nhân viên, Khách hàng
* Use Case:
  * Quản lý tour (CRUD)
  * Xem tour
  * Tìm kiếm tour

### 5.2. Use Case: Thêm Tour

* **Actor** : Admin
* **Mô tả** : Thêm mới tour du lịch
* **Luồng chính** :

1. Admin chọn "Thêm tour"
2. Nhập thông tin tour
3. Nhấn Lưu
4. Hệ thống lưu dữ liệu

* **Luồng phụ** : Dữ liệu không hợp lệ → thông báo lỗi

### 5.3. Sequence Diagram (CRUD Tour – mô tả)

* Admin → Controller → Service → Repository → Database

### 5.4. Class Diagram (mô tả)

**Tour**

* tourId
* tenTour
* diemDen
* gia
* thoiGian
* moTa
* trangThai

Phương thức:

* addTour()
* updateTour()
* deleteTour()
* login()
* logout()
* calculateDiscount()

---

## 6. Thiết kế cơ sở dữ liệu

### 6.1. Bảng TOUR

| Tên cột  | Kiểu dữ liệu | Mô tả      |
| ---------- | --------------- | ------------ |
| tour_id    | INT (PK)        | Mã tour     |
| ten_tour   | VARCHAR         | Tên tour    |
| diem_den   | VARCHAR         | Điểm đến |
| gia        | DECIMAL         | Giá tour    |
| thoi_gian  | VARCHAR         | Thời gian   |
| mo_ta      | TEXT            | Mô tả      |
| trang_thai | BOOLEAN         | Trạng thái |

---

## 7. Giao diện (mô tả)

### 7.1. Màn hình danh sách tour

* Hiển thị bảng danh sách tour
* Nút: Thêm – Sửa – Xóa – Xem

### 7.2. Màn hình thêm/sửa tour

* Form nhập thông tin
* Nút Lưu / Hủy

---

## 8. Kết luận

Tài liệu đã trình bày đầy đủ quá trình** ****phân tích và thiết kế hệ thống chức năng CRUD Tour** bao gồm yêu cầu, UML, CSDL và mô tả giao diện. Có thể dùng cho bài tập môn** ***Phân tích & Thiết kế Hệ thống* hoặc làm nền tảng phát triển phần mềm.

---

*Hết*
