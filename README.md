E-Commerce Application - Spring Boot + Thymeleaf + MySQL
A lightweight E-commerce web application built with Spring Boot 3, Thymeleaf, Spring Data JPA (Hibernate), and MySQL.
It demonstrates MVC architecture, session-based cart, order management, email confirmation, and database persistence.
 
Features
User Functionalities
•	Browse available products
•	Add products to cart (session-based)
•	Remove products from cart
•	Checkout with email confirmation
•	View past orders
Admin Functionalities (optional / extendable)
•	Manage products (Add, Edit, Delete)
•	Manage stock levels
 
Tech Stack
•	Backend: Spring Boot 3, Spring Data JPA, Hibernate, Spring Security
•	Frontend: Thymeleaf, HTML5, CSS, Bootstrap
•	Database: MySQL
•	Email Integration: JavaMailSender (SMTP)
•	Build Tool: Maven
•	IDE: IntelliJ IDEA / Eclipse
 
Architecture
Presentation Layer: Thymeleaf Templates (HTML, CSS, Bootstrap, JS)
Controller Layer: Handles user requests
Service Layer: Business logic (cart, orders, stock, email)
Repository Layer: Database access via Spring Data JPA
Database: MySQL (users, products, orders, order_items)
 
Project Workflow Diagram
flowchart TD

A[User Logs In] --> B[Browse Products]
B --> C[Add Product to Cart]
C --> D{Cart Operations?}

D -->|Remove Item| E[Restore Stock in DB]
D -->|Checkout| F[Create Order]

F --> G[Save Order + Items in DB]
G --> H[Deduct Stock]
H --> I[Send Email Confirmation]
I --> J[Clear Session Cart]
J --> K[View Order History]

subgraph Admin Panel (Future)
  L[Add/Edit/Delete Products]
  M[Manage Stock Levels]
end

 
Database ER Diagram
erDiagram
    USERS {
        Long id PK
        String email UNIQUE
        String password
        String role
    }

    PRODUCTS {
        Long id PK
        String name
        String description
        double price
        int stock
    }

    ORDERS {
        Long id PK
        String user_email FK
        LocalDateTime order_date
        double total_amount
    }

    ORDER_ITEMS {
        Long id PK
        Long order_id FK
        Long product_id FK
        double price
        int quantity
    }

    USERS ||--o{ ORDERS : places
    ORDERS ||--o{ ORDER_ITEMS : contains
    PRODUCTS ||--o{ ORDER_ITEMS : included_in

 
Installation & Setup
1. Clone the Repository
git clone https://github.com/your-username/ecommerce-springboot.git
cd ecommerce-springboot

2. Configure Database
•	Create a MySQL database (e.g., ecommerce_db)
•	Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Configure Email SMTP
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

⚠ For Gmail: enable App Passwords or use alternative SMTP credentials.
4. Run the Application
mvn spring-boot:run

Access at:
http://localhost:8080/

 
Example Flow
1.	User logs in with email
2.	Products are displayed from DB
3.	User adds "Laptop" → stock reduces by 1
4.	User adds "Phone" → stock reduces by 1
5.	User removes "Phone" → stock restores
6.	User proceeds to checkout →
o	Order created and stored in DB
o	Email confirmation sent
o	Cart cleared
 
Future Enhancements
•	Payment Gateway Integration (Stripe, PayPal, Razorpay)
•	Order Tracking System
•	Role-based Admin Dashboard
•	Coupons/Discount system
•	Cart persistence in DB (instead of session)
 
Conclusion
This project demonstrates an end-to-end e-commerce system built with Spring Boot and Thymeleaf, featuring:
•	MVC Architecture
•	Entity relationships (OneToMany, ManyToOne)
•	Session-based cart management
•	CRUD operations with Spring Data JPA
•	Email integration for confirmations
•	Stock & Order handling
It’s a great project for Spring Boot beginners and can be extended into a production-ready application.
 
Contributing
1.	Fork the repository
2.	Create a feature branch
3.	Commit changes
4.	Push the branch
5.	Create a Pull Request
 
