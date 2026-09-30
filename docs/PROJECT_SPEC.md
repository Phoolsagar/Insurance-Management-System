# Insurance Management System — Implementation Spec

## Core workflow
1. Customer registers and logs in.
2. Customer browses insurance products.
3. Customer purchases a policy.
4. System assigns the policy to the logged-in customer and creates a simulated payment transaction.
5. Customer views active policies.
6. Customer submits a claim against an owned policy.
7. Agent/Admin reviews the claim and changes its status.
8. Customer sees the updated claim status and payment history.
9. Admin can create policies and inspect users and dashboard metrics.

## Roles
| Role | Main capabilities |
|---|---|
| Customer | Registration, login, policy browsing/purchase, own policies, claim submission, own payments |
| Agent | Login, claim review/status updates, operational visibility |
| Admin | Dashboard, user visibility, policy creation, claim review |

## Data model
- `users`: identity, credentials, role, contact data.
- `policies`: policy catalogue plus optional customer ownership.
- `claims`: customer claim tied to a policy.
- `payments`: simulated premium transaction tied to a purchased policy.

## Architecture
React SPA → Axios REST client → Spring Boot controllers → services → Spring Data JPA → MySQL.

JWT is stored by the frontend and sent as `Authorization: Bearer <token>`.

## Security
- BCrypt password hashing.
- JWT authentication.
- Role-based method authorization.
- CORS restricted to local React development origins.
- Password is never serialized in API responses.

## Verification checklist
- [ ] MySQL database available.
- [ ] Backend starts on port 8080.
- [ ] Frontend starts on port 5173.
- [ ] Register/login works.
- [ ] Demo accounts work.
- [ ] Policies load.
- [ ] Customer purchase creates policy ownership and payment.
- [ ] Customer can submit claims.
- [ ] Agent/Admin can update claim status.
- [ ] Admin can create policies.
