# Insurance Management System

Full-stack Insurance Management System built for the Java Full Stack internship project.

## Stack
- Backend: Java 21, Spring Boot 3.5, Spring Security, JWT, Spring Data JPA, Hibernate, Maven
- Frontend: React 19, Vite, React Router, Axios
- Database: MySQL 8+
- API style: REST / JSON

## Roles
- CUSTOMER: register/login, browse policies, buy/apply for a policy, view own policies, submit claims, view claim status and payments.
- AGENT: login, view customers/policies/claims, update claim status.
- ADMIN: dashboard, manage users/policies/claims/payments.

## Quick start

### 1. Database
Create a MySQL database:
```sql
CREATE DATABASE insurance_db;
```

Update `backend/src/main/resources/application.properties` or environment variables:
```text
DB_URL=jdbc:mysql://localhost:3306/insurance_db
DB_USERNAME=root
DB_PASSWORD=root
JWT_SECRET=change-this-to-a-long-random-secret-key
```

### 2. Backend
```bash
cd backend
mvn spring-boot:run
```
API: `http://localhost:8080/api`

The app uses `spring.jpa.hibernate.ddl-auto=update` and seeds demo data on first startup.

### 3. Frontend
```bash
cd frontend
npm install
npm run dev
```
Open `http://localhost:5173`.

## Demo accounts
- Admin: `admin@insurance.local` / `Admin@123`
- Agent: `agent@insurance.local` / `Agent@123`
- Customer: `customer@insurance.local` / `Customer@123`

## Main API endpoints
- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET /api/policies`
- `POST /api/policies`
- `POST /api/policies/{id}/purchase`
- `GET /api/my/policies`
- `GET /api/claims`
- `POST /api/claims`
- `PATCH /api/claims/{id}/status`
- `GET /api/payments`
- `GET /api/dashboard/summary`
- `GET /api/users`

## Project structure
```text
insurance-management-system/
├── backend/
│   ├── pom.xml
│   └── src/main/java/com/insurance/
│       ├── config/
│       ├── controller/
│       ├── dto/
│       ├── entity/
│       ├── exception/
│       ├── repository/
│       ├── security/
│       └── service/
├── frontend/
│   ├── package.json
│   ├── vite.config.js
│   └── src/
│       ├── api/
│       ├── components/
│       ├── context/
│       ├── pages/
│       └── styles/
└── README.md
```

## Notes
This is an internship-ready MVP. Payment records are simulated; no real payment gateway is connected. File/document upload is represented by a URL field to keep the project self-contained and easy to run.
