<%@page import="java.util.ArrayList"%>
<%@page import="DAO.City"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>City List</title>
    <link rel="stylesheet" type="text/css" href="css/style_css.css">
    
        <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f9f9f9;
        }
        .form-container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #45a049;
        }
    </style>
    
</head>
<body>
    <h1>Danh sách sinh viên</h1>
    <%
        ArrayList<City> data = (ArrayList<City>) request.getAttribute("data");
        City editCity = (City) request.getAttribute("editCity");
        if (data != null && !data.isEmpty()) {
    %>
    
    
    <table border="1">
        <tr>
            <th>Mã sinh viên</th>
            <th>Họ và tên</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Điểm Toán</th>
            <th>Điểm Văn</th>
            <th>Điểm Anh</th>
            <th>Sửa</th>
            <th>Xóa</th>
        </tr>
        <% 
            for (City city : data) { 
        %>
        <tr>
            <td><%= city.getID() %></td>
            <td><%= city.getHoten() %></td>
            <td><%= city.getEmail() %></td>
            <td><%= city.getDiachi() %></td>
            <td><%= city.getToan() %></td>
            <td><%= city.getVan() %></td>
            <td><%= city.getAnh() %></td>
            <td>
                <form action="HandleCityController" method="get" style="display:inline;">
                    <input type="hidden" name="editId" value="<%= city.getID() %>">
                    <input type="submit" value="Sửa">
                </form>
            </td>
            <td>
                <form action="HandleDelete" method="post" style="display:inline;">
                    <input type="hidden" name="cityIDDelete" value="<%= city.getID() %>">
                    <input type="submit" value="Xóa" onclick="return confirm('Bạn có chắc chắn muốn xóa sinh viên này?');">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <% } else { %>
    <p>No cities found</p>
    <% } %>
    
    <h1><%= (editCity != null) ? "Edit City" : "Thêm thông tin" %></h1>
    <form action="HandleCityController" method="post">
        <label for="id">Mã sinh viên</label>
        <input type="text" id="id" name="id" value="<%= (editCity != null) ? editCity.getID() : "" %>" required ><br><br>
        
        <label for="namecity">Họ và tên</label>
        <input type="text" id="hoten" name="hoten" value="<%= (editCity != null) ? editCity.getHoten() : "" %>" required><br><br>
        
        <label for="tenkv">Email</label>
        <input type="text" id="email" name="email" value="<%= (editCity != null) ? editCity.getEmail() : "" %>" required><br><br>
        
        <label for="dacsan">Địa chỉ</label>
        <input type="text" id="diachi" name="diachi" value="<%= (editCity != null) ? editCity.getDiachi() : "" %>" required><br><br>
        
        <label for="dacsan">Điểm toán</label>
        <input type="text" id="toan" name="toan" value="<%= (editCity != null) ? editCity.getToan() : "" %>" required><br><br>
        
        <label for="dacsan">Điểm văn</label>
        <input type="text" id="van" name="van" value="<%= (editCity != null) ? editCity.getVan() : "" %>" required><br><br>
        
        <label for="dacsan">Điểm anh</label>
        <input type="text" id="anh" name="anh" value="<%= (editCity != null) ? editCity.getAnh() : "" %>" required><br><br>
        
        <input type="submit" value="<%= (editCity != null) ? "Update sinh viên" : "Insert sinh viên" %>">
        <% if (editCity != null) { %>
        <input type="hidden" name="edit" value="true">
        <% } %>
    </form>
</body>
</html>
