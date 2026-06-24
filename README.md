# Blood Donor Management System (BDMS)

A backend application for managing blood donors, recipients, blood requests, and blood bank inventory.

## Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Flyway
- Maven

## Project Status

### Sprint 1 - Foundation

- [x] Spring Boot Setup
- [x] MySQL Integration
- [x] Flyway Migration
- [x] Security Configuration
- [x] Health Check API
- [x] Standard API Response

## API Endpoints

### Health Check

```http
GET /api/v1/health
```

Response:

```json
{
  "success": true,
  "message": "Application is running",
  "data": "UP"
}
```