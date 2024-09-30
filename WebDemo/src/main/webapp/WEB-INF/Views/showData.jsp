<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Danh sách người dùng</title>
	<style type="text/css">
	  		<%@include file="css/style.css" %>
	</style>
</head>
<body>
	 <h2>Danh sách người dùng</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Họ và Tên</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Địa chỉ</th>
                <th>Căn cước</th>
                <th>Email</th>
                <th>Số điện thoại</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.birthdate}</td>
                    <td>${user.gender}</td>
                    <td>${user.address}</td>
                    <td>${user.identity_card}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <button type="button" onclick="window.location.href='UserServlet';">Quay lại trang nhập thông tin</button>
</body>
</html>