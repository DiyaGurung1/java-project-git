package com.studentregistration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RegistrationController" })
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		String firstname=request.getParameter("firstName");
		String lastname=request.getParameter("lastName");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String gender=request.getParameter("gender");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String birthday=request.getParameter("dob");
		
		boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();
		
		// 1. Name Format Validation
        if (!firstname.matches("[a-zA-Z]+") || !lastname.matches("[a-zA-Z]+")) {
            isValid = false;
            errorMessage.append("First name and last name should not contain numbers or special characters.\n");
        }

        // 2. Username Length and Format Validation
        if (username.length() <= 6 || !username.matches("[a-zA-Z0-9]+")) {
            isValid = false;
            errorMessage.append("Username must be more than 6 characters and contain no special characters.\n");
        }
        // 3. Birthday Date Restriction
        LocalDate currentDate = LocalDate.now();
        LocalDate userBirthdate = LocalDate.parse(birthday);
        if (userBirthdate.isAfter(currentDate)) {
            isValid = false;
            errorMessage.append("Birthdate cannot be later than the current date.\n");
        }

        // 4. Phone Number Format Validation
        if (!phone.matches("\\+\\d{13}")) {
            isValid = false;
            errorMessage.append("Phone number must start with '+' and be exactly 14 characters long.\n");
        }
        // 5. Password Complexity and Match Validation
        if (!password.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{6,}$")) {
            isValid = false;
            errorMessage.append("Password must contain at least one number, one special character, one capital letter, and be longer than 6 characters.\n");
        }
        
        // If validation fails, print error messages and redirect back to registration page
        out.println("<html><body>");
        out.println("<h2>Registration Failed</h2>");
        out.println("<p>" + errorMessage.toString() + "</p>");
        out.println("<a href='register.html'>Try Again</a>");
        out.println("</body></html>");

		
	}

}
