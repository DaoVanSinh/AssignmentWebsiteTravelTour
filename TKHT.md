# PHÂN TÍCH & THIẾT KẾ – CHỨC NĂNG Hiển thị-Tìm Kiếm-Lọc

## **Use Case**

**Tác nhân chính** **:** Khách hàng (Người dùng hệ thống)

**Use case:**

Xem danh sách tour (HIển thị danh sách tour có sẵn)

Tìm kiếm:Nhập từ khóa theo tên , điểm đến

Lọc Tour: lọc theo giá tiền , số ngày , phương tiện

Xem chi tiết Tour: hiển thị đầy đủ thông tin của Tour được chọn

![USECASE DIAGRAM](images/usecase.png)

## Sequence Diagram

**Khách hàng** nhập từ khóa tìm kiếm hoặc tiêu chí lọc (giá tiền, điểm đến, số ngày, phương tiện).

**TourController** nhận request.

Gọi Service để xử lý.

**TourService** tiếp nhận yêu cầu.

Xây dựng bộ lọc (Specification/QueryDSL).

Xác định tiêu chí sắp xếp (giá, ngày khởi hành, số ngày).

Gọi Repository để truy vấn dữ liệu.

**TourRepository** thực hiện truy vấn.

Gửi truy vấn xuống Database.

**Database** xử lý truy vấn.

Lọc dữ liệu theo điều kiện.

Trả về danh sách tour phù hợp.

**TourRepository** nhận kết quả từ Database

Trả danh sách tour về cho Service.

**TourService** xử lý kết quả.

Áp dụng thêm logic nghiệp vụ nếu cần (lọc bổ sung, sắp xếp).

Chuẩn bị dữ liệu trả về.

**TourController** nhận dữ liệu từ Service và hiển thị danh sách

![Sequence Diagram](images/Sequecn.png)

## Activity Diagram

**Người dùng truy cập trang danh sách tour**

→ Hệ thống hiển thị toàn bộ tour mặc định, sắp xếp theo ngày khởi hành gần nhất.

**Người dùng nhập từ khóa tìm kiếm hoặc chọn tiêu chí lọc**Từ khóa: tên tour, điểm đến

Lọc: giá tiền (min–max), số ngày, phương tiện di chuyển

**Hệ thống kiểm tra dữ liệu đầu vào**

Nếu có kết quả → hiển thị danh sách

Nếu không có kết quả → hiển thị thông báo “Không tìm thấy tour phù hợp”

**Người dùng chọn tiêu chí sắp xếp**

Theo giá tăng/giảm

**Hệ thống thực hiện truy vấn dữ liệu theo filter & sort**

→ Gọi Service → Repository → Database

**Hệ thống hiển thị kết quả**

**Người dùng chọn tour để xem chi tiết**

→ Gọi API `/api/tours/{id}` để lấy thông tin đầy đủ

**Người dùng quay lại danh sách hoặc thay đổi tiêu chí lọc**

![Activity Diagram](images/Active.png)

## Class Diagram-thể hiện các lớp trong chức năng

![Class Diagram](images/Class.png)
