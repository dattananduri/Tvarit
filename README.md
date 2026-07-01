# Tvarit - Hyperlocal Commerce Platform

## Overview

Tvarit is a Spring Boot backend application for a hyperlocal commerce platform that connects customers, delivery partners, and local stores. The platform enables customers to place orders while allowing delivery partners to manage and fulfill those orders efficiently.

**Project Status:** 🚧 Ongoing Development

---

## Features

### Customer Module
- Customer Registration
- Customer Login
- View Customer Profile
- Update Customer Profile
- View Order History

### Partner Module
- Partner Registration
- Partner Login
- View Partner Profile
- Update Partner Profile

### Order Module
- Create Order
- View Order Details
- Update Order Status
- Partner Order Acceptance
- Partner Assignment


## Technology Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs

---

## Architecture

The project follows a layered architecture.

```
Controller
     ↓
Service
     ↓
Repository
     ↓
MySQL Database
```

---

## Database Relationships

- Customer → Customer Orders (One-to-Many)
- Customer Order → Items (One-to-Many)
- Customer Order → Partner (Many-to-One)

---

## Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── dto
└── resources
```

---

## REST API Endpoints

### Customer

| Method | Endpoint |
|--------|----------|
| POST | `/customer/register` |
| POST | `/customer/login` |
| GET | `/customer/profile/{id}` |
| PUT | `/customer/profile/{id}` |
| GET | `/customer/{id}/orders` |

### Partner

| Method | Endpoint |
|--------|----------|
| POST | `/partner/register` |
| POST | `/partner/login` |
| GET | `/partner/profile/{id}` |
| PUT | `/partner/profile/{id}` |

### Orders

| Method | Endpoint |
|--------|----------|
| POST | `/orders` |
| GET | `/orders/{id}` |
| PUT | `/orders/{id}/{status}` |
| PUT | `/orders/{orderId}/accept/{partnerId}` |

---

## Future Enhancements

- JWT Authentication
- Spring Security
- AI-powered Shopping Assistant
- Live Order Tracking
- Google Maps Integration
- Payment Gateway
- Push Notifications

---

## Author

**Sri Datta Nanduri**

- GitHub: https://github.com/dattananduri
- LinkedIn: https://www.linkedin.com/in/datta-nanduri

---

## License

This project is developed for learning and portfolio purposes.
