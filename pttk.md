# Xác định yêu cầu hệ thống
 1. Mục đích xác định yêu cầu

Việc xác định yêu cầu hệ thống nhằm làm rõ các chức năng mà hệ thống Website Tour Du lịch Việt Nam cần đáp ứng, cũng như các yêu cầu về chất lượng và phạm vi hoạt động. Đây là cơ sở quan trọng để tiến hành thiết kế, xây dựng và triển khai hệ thống một cách hiệu quả, tránh thiếu sót hoặc phát sinh ngoài phạm vi đề tài.

2. Đối tượng sử dụng hệ thống

Hệ thống Website Travel Tour có các đối tượng sử dụng chính như sau:

* Người dùng (User) :

  Là khách hàng có nhu cầu tìm hiểu thông tin tour du lịch và thực hiện đặt tour trực tuyến.
* Quản trị viên (Admin):

  Là người quản lý hệ thống, chịu trách nhiệm quản lý tour, người dùng và các đơn đặt tour.

 3. Yêu cầu chức năng
  Yêu cầu chức năng đối với người dùng:

Hệ thống cần đáp ứng các chức năng sau cho người dùng:

* Đăng ký tài khoản mới
* Đăng nhập hệ thống
* Xem danh sách các tour du lịch
* Xem chi tiết thông tin tour
* Thực hiện đặt tour
* Nhận thông báo kết quả đặt tour (thành công hoặc thất bại)

Yêu cầu chức năng đối với quản trị viên:

Hệ thống cần đáp ứng các chức năng sau cho quản trị viên:

* Quản lý thông tin tour (thêm, sửa, xoá)
* Quản lý thông tin người dùng
* Quản lý các đơn đặt tour
* Kiểm tra và cập nhật trạng thái đơn đặt tour

 4. Yêu cầu phi chức năng
Ngoài các chức năng chính, hệ thống cần đảm bảo các yêu cầu phi chức năng sau:

* Giao diện thân thiện, dễ sử dụng
* Thời gian phản hồi nhanh
* Dữ liệu nhập vào được kiểm tra hợp lệ
* Đảm bảo bảo mật thông tin người dùng
* Hệ thống dễ bảo trì và mở rộng

 5. Phạm vi và giới hạn hệ thống
Trong phạm vi đề tài, hệ thống có các giới hạn sau:

* Không hỗ trợ thanh toán trực tuyến
* Không phát triển ứng dụng trên nền tảng di động
* Hệ thống chỉ mang tính chất học tập và minh hoạ

6. Kết luận

# Phần xác định yêu cầu hệ thống đã làm rõ các chức năng, đối tượng sử dụng và phạm vi hoạt động của Website Tour Du lịch Việt Nam. Đây là cơ sở quan trọng để nhóm tiến hành các bước tiếp theo trong quá trình thiết kế và xây dựng hệ thống.

* Hệ thống website tour
du lịch được xây dựng nhằm hỗ trợ người dùng trong việc tìm kiếm, xem thông tin
và đặt tour du lịch một cách thuận tiện. Dựa trên yêu cầu của hệ thống, các chức
năng chính được xác định như sau:

**1. Chức năng xem
danh sách tour**

* Hiển thị danh sách các tour du lịch hiện
  có trong hệ thống
* Hiển thị các thông tin cơ bản của tour:
  * Tên tour
  * Hình ảnh minh họa
  * Giá tour
  * Thời gian tour
* Cho phép người dùng duyệt và lựa chọn tour
  mong muốn

**2. Chức năng xem chi tiết tour**

* Hiển thị đầy đủ thông tin chi tiết của một
  tour du lịch
* Bao gồm các thông tin:
  * Mô tả chi tiết tour
  * Lịch trình tour
  * Giá tour
  * Hình ảnh chi tiết
* Cho phép người dùng chuyển sang chức năng
  đặt tour

**3. Chức năng đăng ký tài khoản**

* Cho phép người dùng tạo tài khoản mới trên
  hệ thống
* Người dùng nhập các thông tin cần thiết:
  * Tên đăng nhập
  * Mật khẩu
  * Thông tin cá nhân
* Kiểm tra tính hợp lệ của dữ liệu trước khi
  lưu vào hệ thống

**4. Chức năng đăng nhập hệ thống**

* Cho phép người dùng đăng nhập bằng tài khoản
  đã đăng ký
* Xác thực thông tin đăng nhập với hệ thống
  backend
* Quản lý trạng thái đăng nhập của người
  dùng

**5. Chức năng đặt tour**

* Cho phép người dùng đã đăng nhập thực hiện
  đặt tour
* Người dùng nhập các thông tin đặt tour:
  * Tour cần đặt
  * Số lượng người
  * Ngày khởi hành
* Gửi thông tin booking lên hệ thống backend
  để xử lý
* Lưu thông tin đặt tour vào cơ sở dữ liệu

**6. Chức năng thông báo kết quả**

* Thông báo cho người dùng khi đặt tour
  thành công
* Thông báo lỗi khi dữ liệu không hợp lệ hoặc
  đặt tour thất bại
* Hướng dẫn người dùng thực hiện lại khi có
  lỗi xảy ra

**7. Chức năng quản lý dữ liệu hệ thống (mở rộng)**

* Quản lý danh sách tour
* Quản lý thông tin người dùng
* Quản lý thông tin booking
* Phục vụ cho việc mở rộng hệ thống trong
  tương lai

**8. Chức năng giao tiếp Frontend – Backend**

* Frontend gửi yêu cầu (request) đến backend
  thông qua REST API
* Backend xử lý yêu cầu và trả về dữ liệu
  (response)
* Đảm bảo dữ liệu được truyền tải chính xác
  và an toàn

