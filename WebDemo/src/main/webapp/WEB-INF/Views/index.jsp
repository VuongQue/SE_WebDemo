<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhập thông tin người dùng</title>
   	<style type="text/css">
  		<%@include file="css/style.css" %>
	</style>
</head>
<body>
    <h2>Nhập thông tin người dùng</h2>
    
    <form action="UserServlet" method="post">
        <label for="name">Họ và tên:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="birthdate">Ngày sinh:</label>
        <input type="date" id="birthdate" name="birthdate" required><br><br>

        <label for="gender">Giới tính:</label>
        <select id="gender" name="gender" required>
            <option value="Nam">Nam</option>
            <option value="Nữ">Nữ</option>
            <option value="Khác">Khác</option>
        </select><br><br>

        <label for="address">Địa chỉ:</label>
        <input type="text" id="address" name="address" required><br><br>

        <label for="identity_card">Căn cước:</label>
        <input type="text" id="identity_card" name="identity_card" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="phone">Số điện thoại:</label>
        <input type="text" id="phone" name="phone" required><br><br>

        <button type="submit">Lưu</button>
        <button type="button" onclick="window.location.href='ShowDataServlet';">Xem danh sách người dùng</button>
    </form>

    
</body>
</html>
