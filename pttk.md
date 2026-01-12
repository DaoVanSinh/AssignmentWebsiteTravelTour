### 1. Tác nhân ngoài (Người dùng)

Đây là những đối tượng tương tác trực tiếp với giao diện website:

* **Khách vãng lai (Ghi chú: Chưa đăng nhập):**
  * Xem danh sách tour, tìm kiếm tour theo điểm đến hoặc giá cả.
  * Xem tin tức du lịch, cẩm nang.
  * Đăng ký tài khoản mới.
* **Khách hàng (Đã có tài khoản):**
  * Quản lý thông tin cá nhân.
  * Đặt tour trực tuyến (Booking).
  * Thực hiện thanh toán (nếu tích hợp cổng thanh toán).
  * Gửi đánh giá/phản hồi (Review) sau khi đi tour.
  * Xem lịch sử đặt tour.

### 2. Tác nhân nội bộ (Quản trị)

Đây là nhân sự của công ty du lịch vận hành hệ thống:

* **Nhân viên quản lý tour (Content/Product Staff):**
  * Thêm, sửa, xóa thông tin tour (mô tả, lịch trình, hình ảnh).
  * Cập nhật giá tour và số chỗ còn nhận.
* **Nhân viên điều hành/Kế toán:**
  * Tiếp nhận và xác nhận đơn đặt tour của khách.
  * Kiểm tra trạng thái thanh toán.
  * Quản lý danh sách khách hàng đi tour.
* **Quản trị viên (Admin):**
  * Quản lý phân quyền tài khoản nhân viên.
  * Cấu hình hệ thống, quản lý danh mục (vùng miền, loại hình du lịch).
  * Xem báo cáo doanh thu và thống kê truy cập.

### 3. Tác nhân hệ thống (System Actors)

Nếu hệ thống có kết nối với bên thứ ba:

* **Cổng thanh toán (Payment Gateway):** (Ví dụ: VNPay, Momo, PayPal) Xử lý giao dịch và trả kết quả thanh toán về cho website.
* **Hệ thống gửi Email/SMS:** Tự động gửi xác nhận đặt tour hoặc mã OTP.
