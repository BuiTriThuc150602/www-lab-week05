# Mô tả sơ lược :
### - Trang web cho phép các công ty đăng bài tuyển nhân viên. Các ứng viên khi đăng nhập vào sẽ được hiển thị các bài viết phù hợp với kỹ năng hiện có của mình.

# Chạy chương trình : 
### - Build dự án với gradle, phiên bản hiện dùng để phát triển là 8.2
### - Spring Boot : Spring Framework 6.x
### - Server Tomcat 10.1.13

# Các màn Hình Và Chức Năng Cơ Bản:
## 1. Login
### Tại địa chỉ mặc định localhost:8080 sẽ là trang đăng nhập :
![login](https://github.com/BuiTriThuc150602/www-lab-week05/assets/125670011/09d9b161-3a98-41e9-b06c-7d109fadb23e)
#### Người dùng đăng nhập bằng tài khoản hiện có, hoặc đăng ký 1 tài khoản mới 
##### (Chức năng chưa cập nhật )
## 2. Home page
### - Khi đăng nhập thành công, nếu tài khoản là candidate, trang chủ sẽ hiển thị những bài đăng của các công ty với các kỹ năng phù hợp với candidate login hiện tại.


![candidateHome](https://github.com/BuiTriThuc150602/www-lab-week05/assets/125670011/438159c9-6c6d-459b-9c32-04106f6cfcdc)

### Nếu tài khoản đăng nhập là 1 công ty ( company login ) thì trang chủ sẽ hiển thị các bài đăng của công ty đó, chủ tài khoản có thể quản lý các bài đăng của công ty mình:

![companyHome](https://github.com/BuiTriThuc150602/www-lab-week05/assets/125670011/909a9031-492f-46f1-a60b-475f9a05adea)

## 3. Company posting
### - Đăng nhập bằng tài khoản công ty, trên thanh điều hướng sẽ hiển thị tab chuyển hướng đến trang để chủ tài khoản dăng bài tuyển nhân sự:

![image](https://github.com/BuiTriThuc150602/www-lab-week05/assets/125670011/1beaadbe-86f0-40c1-a9af-6cf7ddb4fafd)

### - Trang Hiển thị form để chủ tài khoản đăng bài về công việc của công ty mình :


![companyPost](https://github.com/BuiTriThuc150602/www-lab-week05/assets/125670011/fce1bf67-6d82-4ecf-a376-1a7c6a50e77e)

### Các kỹ năng cần thiết sẽ có sẵn, nếu không có kỹ năng cần cho công việc hiện tại, có thể thêm 1 kỹ năng mới cho bài đăng công việc : 

![image](https://github.com/BuiTriThuc150602/www-lab-week05/assets/125670011/1db5b37b-4383-4e2f-85e5-2b082564e2e7)
#### (Chức năng chưa cập nhật )
### - Khi hoàn thành, nhấn vào ##Post để đăng bài viết, sau đó sẽ được chuyển hướng về trang home của công ty.
### - Bài viết và công việc sẽ được lưu vào cơ sở dữ liệu, trang của ứng viên sẽ nhinf thấy bài viết mới nhưng phải reload trang ( Chưa áp dụng websocket ) 

## 4. Candidate List
### - Đăng nhập bằng tài khoản công ty còn được phép xem thông tin các ứng viên, nhằm tìm ra các ứng viên phù hợp


![candidateList](https://github.com/BuiTriThuc150602/www-lab-week05/assets/125670011/5fd5b7df-795e-4ff0-b002-9f814b0dbb5f)

# Các chức năng khác chưa được cập nhật

# Cơ sở dữ liệu :
![image](https://github.com/BuiTriThuc150602/www-lab-week05/assets/125670011/774ed9a9-9abf-426f-adc8-cb9594131f60)

