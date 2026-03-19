# Xác định yêu cầu & phân tích hệ thống cho chức năng đăng nhập đăng kí

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

# Phân tích hệ thống chức năng booking

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

# Phân tích hệ thống chức năng hiển thị tìm kiếm lọc tour

1. Yêu cầu chức năng

Xem và tìm kiếm tour du lịch

Đặt tour trực tuyến

Quản lý khách hàng

Quản lý tour và đơn đặt tour

2. Yêu cầu phi chức năng

Giao diện thân thiện, dễ sử dụng

Bảo mật thông tin người dùng

Hoạt động ổn định, tốc độ truy cập tốt

**Thiết kế hệ thống**

1.Thiết kế tổng thể

Mô hình website Client – Server

2.Thiết kế chức năng

Sơ đồ phân rã chức năng

Sơ đồ Use Case tổng quát

3.Thiết kế dữ liệu

Mô hình cơ sở dữ liệu

Các bảng chính: Tour, Khách hàng, Đơn đặt tour, Thanh toán

4.Thiết kế giao diện

Giao diện người dùng

Giao diện quản trị

# Phân tích hệ thống cho chức năng CRUD tour

1. Tác nhân ngoài (Người dùng)

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

2. Tác nhân nội bộ (Quản trị)

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

3. Tác nhân hệ thống (System Actors)

Nếu hệ thống có kết nối với bên thứ ba:

* **Cổng thanh toán (Payment Gateway):** (Ví dụ: VNPay, Momo, PayPal) Xử lý giao dịch và trả kết quả thanh toán về cho website.
* **Hệ thống gửi Email/SMS:** Tự động gửi xác nhận đặt tour hoặc mã OTP.

# Tìm hiểu xây dựng hệ thống cho chức năng payment & review

Hệ thống quản lý tour du lịch được xây dựng nhằm phục vụ hai nhóm đối tượng chính là User và Admin/Service. Đối với phía User, hệ thống cho phép người dùng thực hiện đăng ký tài khoản mới và đăng nhập để sử dụng các chức năng của hệ thống. Sau khi đăng nhập, người dùng có thể xem danh sách các tour du lịch hiện có cùng với các thông tin chi tiết như điểm đến, thời gian khởi hành, giá tour và lịch trình. Hệ thống hỗ trợ chức năng tìm kiếm tour theo từ khóa và lọc tour dựa trên khu vực du lịch, ngày khởi hành hoặc mức giá, giúp người dùng dễ dàng lựa chọn tour phù hợp với nhu cầu cá nhân.

Khi đã chọn được tour mong muốn, người dùng có thể tiến hành đặt tour trực tiếp trên hệ thống và thực hiện thanh toán theo các phương thức được hỗ trợ. Sau khi đặt tour thành công, người dùng có thể xem lại lịch sử đặt tour của mình để theo dõi các tour đã tham gia hoặc đã đăng ký. Ngoài ra, hệ thống còn cho phép người dùng thực hiện đánh giá tour sau khi hoàn thành chuyến đi, góp phần nâng cao chất lượng dịch vụ và cung cấp thông tin tham khảo cho những người dùng khác.

Về Admin hoặc Service, hệ thống cung cấp chức năng đăng nhập dành riêng cho quản trị viên nhằm đảm bảo tính bảo mật và phân quyền sử dụng. Sau khi đăng nhập, Admin có quyền quản lý các sản phẩm tour du lịch thông qua các chức năng CRUD, bao gồm tạo mới tour, chỉnh sửa thông tin tour, xóa tour không còn phù hợp và xem danh sách các tour hiện có trong hệ thống. Những chức năng này giúp Admin dễ dàng cập nhật thông tin tour, đảm bảo dữ liệu luôn chính xác và phục vụ tốt cho hoạt động kinh doanh du lịch.
