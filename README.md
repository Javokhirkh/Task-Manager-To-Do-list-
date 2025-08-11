# Task Management API

A simple Spring Boot REST API for managing tasks, built with:
- **Spring Boot**
- **Spring Data JPA**
- **MapStruct**
- **Hibernate Validation**

This project allows you to **create, update, delete, and retrieve tasks**, as well as change their status or priority.

---

## Features
- Create a new task with validation
- Update existing tasks (partial or full update)
- Delete a task by ID
- Get all tasks or a task by ID
- Change task **priority** or **status**
- Enum-based `TaskPriority` and `TaskStatus`
- DTO mapping using **MapStruct**
- Automatic timestamps for creation & updates

---

## Requirements
- **Java 17+**
- **Maven 3+**
- **Spring Boot 3+**
- **H2 Database** (in-memory for development)

---

## Installation & Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/task-api.git
   cd task-api