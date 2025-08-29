# box-delivery-service

# Box Delivery Service (Spring Boot)

This project implements a REST API for managing **Boxes** that can carry and deliver small items to remote locations.  
It is developed in **Java with Spring Boot** as part of an assessment task.  

---

## 📌 Features

- Create a new box  
- Load items into a box (with validations)  
- View loaded items for a given box  
- Check available boxes for loading  
- Check battery level of a box  

---

## 📐 Business Rules

- A box cannot carry more than **500 grams**.  
- A box cannot be set to **LOADING** state if its battery level is below **25%**.  
- Items must follow naming and code restrictions:  
  - Name: letters, numbers, hyphen (`-`), underscore (`_`)  
  - Code: uppercase letters, numbers, underscore  

---

## ⚙️ Tech Stack

- Java 17+  
- Spring Boot 3.x  
- Spring Web  
- Spring Data JPA  
- MySQL database  
- Lombok 

---

## 🚀 Getting Started

### 1. Clone Repository
```bash
git clone https://github.com/adejumoisris/box-delivery-service.git
cd box-delivery-service
