# API Reference

Base URL: `/api`

## Auth
`POST /auth/register`
```json
{"name":"John Doe","email":"john@example.com","password":"secret123","phone":"9999999999","address":"Bengaluru"}
```

`POST /auth/login`
```json
{"email":"customer@insurance.local","password":"Customer@123"}
```

## Policies
- `GET /policies` — public catalogue
- `GET /policies/mine` — authenticated user's policies
- `POST /policies` — ADMIN
- `POST /policies/{id}/purchase` — authenticated user

## Claims
- `GET /claims` — customers see their claims; agents/admin see all
- `POST /claims` — CUSTOMER
- `PATCH /claims/{id}/status` — AGENT/ADMIN

## Payments
- `GET /payments` — customers see their payments; agents/admin see all

## Administration
- `GET /users` — ADMIN
- `GET /dashboard/summary` — authenticated dashboard metrics
