<div align="center">

# 🛡️ Insurance Management System

### React + Vite • Spring Boot • MySQL • Spring Security • JWT

A complete full-stack Insurance Management System developed for a Java Full Stack internship project.

[![React](https://img.shields.io/badge/React-19-61DAFB?style=for-the-badge&logo=react&logoColor=black)](https://react.dev/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)

</div>

---

## 📌 About The Project

The **Insurance Management System** is a full-stack web application developed for a **Java Full Stack internship project**.

The application provides a centralized platform for managing insurance policies, customers, agents, claims, premiums, and payments.

The system supports three role-based users:

- 👤 **Customer** – Register/login, browse policies, purchase policies, track premiums, view payments, and submit claims.
- 🤝 **Agent** – View customers, policies, and claims, and update claim status.
- 👨‍💼 **Admin** – Manage users, agents, customers, policies, claims, payments, and dashboard analytics.

The frontend communicates with the backend using REST APIs, while Spring Boot, Spring Data JPA, Hibernate, and MySQL handle the backend business logic and data persistence.

---

## ✨ Features

### Core Features

- 🔐 User Authentication (Admin, Agent, Customer)
- 📋 Policy Management (Create, Read, Update, Delete)
- 🏷️ Policy Types & Categories
- 📑 Claims Processing & Management
- 💰 Premium Tracking & Payments
- 🤝 Agent Management
- 👥 Customer Management
- 📊 Dashboard & Analytics

### Additional Features

- JWT-based authentication
- Role-based authorization
- Secure password hashing
- Policy purchase workflow
- Customer policy management
- Claim status tracking
- Payment history
- Premium due-date tracking
- Global exception handling
- REST API integration
- Responsive React UI

---

## 🛠️ Tech Stack

| Frontend | Backend | Database | Security | Tools |
|---|---|---|---|---|
| React 19 | Java 21 | MySQL 8+ | Spring Security | Git |
| Vite | Spring Boot 3.5 | Hibernate/JPA | JWT | GitHub |
| React Router | Spring Data JPA | | BCrypt | Maven |
| Axios | Spring REST API | | | Postman |
| CSS | Maven | | | VS Code |

---

## 🏗️ Architecture

React.js + Vite  
↓  
Axios / REST API  
↓  
Spring Boot  
↓  
Spring Security + JWT  
↓  
Controller → Service → Repository  
↓  
Spring Data JPA / Hibernate  
↓  
MySQL

---

## 📂 Project Structure

Insurance-Management-System/  
├── frontend/  
│   ├── src/  
│   │   ├── api/  
│   │   ├── components/  
│   │   ├── context/  
│   │   ├── pages/  
│   │   └── styles/  
│   ├── package.json  
│   └── vite.config.js  
│  
├── backend/  
│   ├── src/  
│   │   └── main/  
│   │       ├── java/com/insurance/  
│   │       │   ├── config/  
│   │       │   ├── controller/  
│   │       │   ├── dto/  
│   │       │   ├── entity/  
│   │       │   ├── exception/  
│   │       │   ├── repository/  
│   │       │   ├── security/  
│   │       │   └── service/  
│   │       └── resources/  
│   │           └── application.properties  
│   ├── pom.xml  
│   └── Dockerfile  
│  
├── .gitignore  
└── README.md

---

## 🔗 REST API

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register customer |
| POST | `/api/auth/login` | User login |
| GET | `/api/policies` | Get all policies |
| GET | `/api/policies/{id}` | Get policy |
| POST | `/api/policies` | Create policy |
| PUT | `/api/policies/{id}` | Update policy |
| DELETE | `/api/policies/{id}` | Delete policy |
| POST | `/api/policies/{id}/purchase` | Purchase policy |
| GET | `/api/my/policies` | Get customer policies |
| GET | `/api/claims` | Get claims |
| POST | `/api/claims` | Submit claim |
| PATCH | `/api/claims/{id}/status` | Update claim status |
| GET | `/api/payments` | Get payments |
| GET | `/api/dashboard/summary` | Dashboard summary |
| GET | `/api/users` | Get users |

---

## 🚀 Run Locally

### Prerequisites

- Java 21+
- Maven 3.9+
- Node.js 20+
- npm
- MySQL 8+
- Git

### 1. Clone Repository

    git clone https://github.com/YOUR_USERNAME/insurance-management-system.git
    cd insurance-management-system

### 2. Create Database

    CREATE DATABASE insurance_db;

### 3. Configure Backend

Update:

    backend/src/main/resources/application.properties

Configure:

    DB_URL=jdbc:mysql://localhost:3306/insurance_db
    DB_USERNAME=root
    DB_PASSWORD=your_mysql_password
    JWT_SECRET=your_long_random_jwt_secret

### 4. Start Backend

    cd backend
    mvn spring-boot:run

Backend:

    http://localhost:8080

### 5. Start Frontend

Create:

    frontend/.env

Add:

    VITE_API_URL=http://localhost:8080/api

Then:

    cd frontend
    npm install
    npm run dev

Frontend:

    http://localhost:5173

> ⚠️ Never commit real `.env` files, database credentials, or JWT secrets.

---

## 🔑 Demo Accounts

| Role | Email | Password |
|---|---|---|
| 👨‍💼 Admin | `admin@insurance.local` | `Admin@123` |
| 🤝 Agent | `agent@insurance.local` | `Agent@123` |
| 👤 Customer | `customer@insurance.local` | `Customer@123` |

---

## 🐳 Docker

The backend includes Docker support.

    docker build -t insurance-backend ./backend
    docker run -p 8080:8080 insurance-backend

---

## 🌐 Deployment

GitHub  
↓  
React/Vite → Netlify  
↓  
Spring Boot → Docker → Backend Hosting  
↓  
MySQL

---

## 📝 Notes

This project is an **internship-ready MVP**.

- Payment processing is simulated.
- No real payment gateway is connected.
- Claim document upload is represented using a URL field.
- MySQL is used for persistent data storage.
- JWT is used for authentication.
- Spring Security provides role-based authorization.
- Demo data is seeded on application startup.

---

## 🔮 Future Enhancements

- 💳 Real payment gateway integration
- 📧 Email notifications
- 📱 SMS notifications
- 📄 PDF policy generation
- 📁 Actual claim document upload
- 🔔 Policy renewal reminders
- 📊 Advanced analytics
- 🐳 Docker Compose deployment
- ☁️ Cloud deployment
- 📚 Swagger/OpenAPI documentation
- 🧪 Automated testing
- 📝 Audit logging

---

## 👨‍💻 Author

**Phoolsagar Singh**  
Java Developer | Java Backend Developer | Full Stack Developer

**GitHub:** https://github.com/Phoolsagar

**LinkedIn:** https://www.linkedin.com/in/phoolsagar/

**Portfolio:** https://phoolsagar.netlify.app/

---

⭐ If you like this project, consider giving it a star!
