# Java Role-Based Management System

## Overview

This is a desktop-based Role-Based Management System developed using Java and Swing GUI.  
The project demonstrates Object-Oriented Programming (OOP) principles along with File I/O for data storage.

The system supports multiple user roles with separate dashboards and controlled access to functionalities.

---

## User Roles

The system includes three types of users:

- Admin
- Employee
- Customer

Each user has different permissions and access levels inside the system.

---

## Authentication System

The system includes a complete authentication module:

- User Registration (Sign Up)
- Secure Login System
- Forgot Password / Password Recovery
- Role-Based Access Control
- Separate Dashboard Redirection Based on Role

User data is stored and retrieved using File I/O (text files).

---

## Admin Functionalities

- Manage Employees
- Manage Customers
- View All Users
- Perform Administrative Operations
- Access System Data

All admin core functionalities are implemented.

---

## Employee Functionalities

- Access Employee Dashboard
- View All Packages
- Perform Operational Tasks

Employee package viewing functionality is implemented.

---

## Customer Functionalities

- Register Account
- Login to System
- View Available Packages
- Access Customer Dashboard
- Perform Customer-Level Operations

---

## Project Structure

### Entities Package
- User.java (Base Class)
- Admin.java
- Employee.java
- Customer.java

Inheritance is used to implement role-based behavior.

### Frames Package (Swing GUI)
- LogInFrame
- SignUpFrame
- ForgetPassFrame
- AdminHomeFrame
- AdminOperationFrame
- EmployeeHomeFrame
- EmployeeOperationFrame
- CustomerHomeFrame
- CustomerOperationFrame
- ViewAllAdmin
- ViewAllEmployee
- ViewAllCustomer
- ViewAllPackages

### Data Storage
- Text files are used for storing user information (File I/O).

---

## Technologies Used

- Java
- Java Swing (GUI)
- Object-Oriented Programming (OOP)
- File Handling (File I/O)

---

## Entry Point

The application starts from:

Start.java

---

## Project Objective

This project was developed to practice:

- OOP concepts (Inheritance, Encapsulation)
- GUI development using Swing
- Role-based access control
- File handling in Java

It serves as a foundational project to understand desktop application development.

---

## Future Improvements

- Database Integration (MySQL)
- Password Encryption
- Improved UI Design
- Better Exception Handling
- Enhanced Validation System
