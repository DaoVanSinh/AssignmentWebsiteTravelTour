## PHÂN TÍCH VÀ THIẾT KẾ HỆ THỐNG CHO ĐĂNG NHẬP/ĐĂNG KÝ

## 1. Mục tiêu chức năng

Chức năng Đăng nhập / Đăng ký cho phép người dùng tạo tài khoản mới và truy cập vào hệ thống thông qua thông tin xác thực. Đây là chức năng cơ bản, đảm bảo:

* Xác định danh tính người dùng
* Phân quyền truy cập hệ thống
* Bảo mật dữ liệu người dùng

## 2. Phân tích nghiệp vụ

### 2.1. Đối tượng sử dụng

* Người dùng (User) : cá nhân sử dụng hệ thống

### 2.2. Các chức năng liên quan

* Đăng ký tài khoản
* Đăng nhập hệ thống
* Quên mật khẩu (mở rộng)
* Phân quyền theo vai trò

## 3.Biểu đồ UseCase

![](https://file+.vscode-resource.vscode-cdn.net/c%3A/Users/Admin/AssignmentWebsiteTravelTour/picture/Use_Case.png?version%3D1768199355668)

## 4. Đặc tả Use Case

### 4.1. Use Case : Đăng ký

Tên Use Case: Đăng ký

Actor: Người dùng

Mô tả: Cho phép người dùng tạo tài khoản mới trong hệ thống.

#### Luồng chính

1. Người dùng chọn chức năng Đăng ký
2. Hệ thống hiển thị giao diện đăng ký
3. Người dùng nhập thông tin (họ tên, email, mật khẩu, xác nhận mật khẩu)
4. Người dùng nhấn nút Đăng ký
5. Hệ thống kiểm tra tính hợp lệ của dữ liệu
6. Hệ thống lưu thông tin người dùng vào cơ sở dữ liệu
7. Hệ thống thông báo đăng ký thành công

#### Luồng ngoại lệ

* AF1: Email đã tồn tại

  → Hệ thống thông báo email đã được sử dụng
* AF2: Mật khẩu không khớp

  → Hệ thống yêu cầu nhập lại mật khẩu
* AF3: Dữ liệu không hợp lệ

  → Hệ thống hiển thị thông báo lỗi

#### Điều kiện tiên quyết

* Người dùng chưa có tài khoản trong hệ thống

#### Điều kiện kết thúc

* Tài khoản được tạo thành công

### 4.2. Use Case : Đăng nhập

Tên Use Case: Đăng nhập

Actor: Người dùng

Mô tả: Cho phép người dùng truy cập hệ thống bằng tài khoản đã đăng ký.

#### Luồng chính

1. Người dùng chọn chức năng Đăng nhập
2. Hệ thống hiển thị giao diện đăng nhập
3. Người dùng nhập email và mật khẩu
4. Người dùng nhấn nút Đăng nhập
5. Hệ thống xác thực thông tin
6. Hệ thống cho phép truy cập hệ thống

#### Luồng ngoại lệ

* AF1: Sai email hoặc mật khẩu

  → Hệ thống thông báo đăng nhập thất bại
* AF2: Tài khoản bị khóa

  → Hệ thống thông báo tài khoản không hợp lệ
* AF3: Người dùng chọn Quên mật khẩu

  → Chuyển sang chức năng khôi phục mật khẩu

#### Điều kiện tiên quyết

* Người dùng đã có tài khoản

#### Điều kiện kết thúc

* Người dùng đăng nhập thành công hoặc thất bại

## 5.Sequence Diagram đăng nhập/đăng ký

### 5.1. Sequence Diagram đăng ký

![](https://file+.vscode-resource.vscode-cdn.net/c%3A/Users/Admin/AssignmentWebsiteTravelTour/picture/SD_Register.png?version%3D1768199760448)

### 5.2. Sequence Diagram đăng nhập

![](https://file+.vscode-resource.vscode-cdn.net/c%3A/Users/Admin/AssignmentWebsiteTravelTour/picture/SD_Login.png?version%3D1768199825638)

## 6. Class Diagram

![](https://file+.vscode-resource.vscode-cdn.net/c%3A/Users/Admin/AssignmentWebsiteTravelTour/picture/Class_Diagram.png?version%3D1768199892642)

## 7. Yêu cầu phi chức năng

* Bảo mật mật khẩu (mã hóa)
* Xác thực dữ liệu đầu vào
* Thời gian phản hồi nhanh
* Dễ mở rộng và bảo trì
