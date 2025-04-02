<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/style.css">
</head>
<body>
	<%
	
	%>
	<div class="container">
    <h2 class="text-center" style="text-align: center; font-weight: bold;">Registration Form</h2>
    <form action="../../RegistrationController" method="post">
    <div class="sub-container">
        <div class="mb-3">
            <label class="form-label">First Name:</label>
            <input type="text" name="firstName" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Username:</label>
            <input type="text" name="username" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Gender:</label>
            <select name="gender" class="form-control">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Phone Number:</label>
            <input type="text" name="phone" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Password:</label>
            <input type="password" name="password" class="form-control" required>
        </div>
      </div>
      
      <div class="sub-container">
        <div class="mb-3">
            <label class="form-label">Last Name:</label>
            <input type="text" name="lastName" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Birthday:</label>
            <input type="date" name="dob" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Email:</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Subject:</label>
            <input type="text" name="subject" class="form-control" value="Computing" readonly>
        </div>
        <div class="mb-3">
            <label class="form-label">Retype Password:</label>
            <input type="password" name="confirmPassword" class="form-control" required>
        </div>
        </div>
        <button type="submit" class="btn btn-success w-100" >Submit</button>
    </form>
	</div>
</body>
</html>