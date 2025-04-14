# 🍔 Online Food Ordering Application

A full-stack web application built using Java (JSP, Servlets), JDBC, and MySQL. The project allows users to browse and order food, while admins can manage menu items, categories, and orders.

The goal of this project is to develop a user-friendly online food ordering system that streamlines the process of browsing menus, placing orders, and managing food items. It aims to bridge the gap between restaurants and customers through a digital platform, offering convenience, efficiency, and real-time order management for both users and administrators.

---

## 🧰 (images/tech-heading.png)

### 💻 Technologies Used

- **Backend**: Java, JSP, Servlets, JDBC  
- **Frontend**: HTML, CSS, JavaScript, Bootstrap  
- **Database**: MySQL  

---

### 🏗️ Architecture - MVC Pattern

This project follows the **MVC (Model-View-Controller)** architecture:

- **Model**: Java POJO classes representing data entities like `User`, `FoodItem`, `Order`, etc.  
- **View**: JSP files used for rendering the frontend interface for users and admins.  
- **Controller**: Servlets handling the business logic and routing requests between the view and model.  

---

### 👤 User

- Register and login  
- Browse food items by category  
- Add items to cart  
- Place orders  
- View order history  

### 🔐 Admin

- Login securely  
- Manage categories and food items (CRUD)  
- View and manage customer orders  

---

### ✨ Features

- Login/Signup with session management  
- Role-based access (admin and user dashboards)  
- Dynamic loading of food items and categories  
- Responsive UI with Bootstrap  
- Secure JDBC with Prepared Statements  
- POJO model for data abstraction  
- MVC pattern for separation of concerns  

---

### 📁 Project Structure

```
OnlineFoodApp/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com.onlinefood/
│       │       ├── controller/     # Servlets (Controllers)
│       │       ├── dao/            # Database logic (Data Access Objects)
│       │       ├── model/          # Models
│       │       └── utils/          # DB connection, helpers
│       └── webapp/
│           ├── css/                # Stylesheets
│           ├── js/                 # JavaScript files
│           ├── admin/              # Admin dashboard views
│           ├── user/               # User dashboard views
│           ├── images/             # Image assets
│           ├── index.jsp           # Homepage
│           └── login.jsp           # Login page
└── README.md
```

---

## 🚀 How to Run

1. *Clone the Repository*
   ```bash
    git clone https://github.com/yourusername/OnlineFoodApp.git
    cd OnlineFoodApp

2. Set up the MySQL Database

     Import the database.sql file into your MySQL server.

     Update your database credentials in DBConnection.java.

3. Deploy on Apache Tomcat

    Build the project in your IDE.

    Deploy the compiled WAR or project directory to the Tomcat webapps folder.

Start Tomcat and go to:
http://localhost:8080/OnlineFoodApp

---

## 🖼️ Screenshots

---

## 🍚 ================= MySQL Database =================

 STEP 1: Open MySQL Command Prompt or MySQL Workbench

 STEP 2: Login to the administrator user of MySql:
	 ```mysql -u <username> -p``` (Enter Password if asked)

 STEP 3: Copy paste and execute the MySQL Query from the following file:-
 - Run the Sql Query From this file: [MySQL Database](https://github.com/pratikkhot100/Online-Food_Application/blob/main/mysql_database.sql) 

---

## 📌 "Suggestions and project improvement ideas are welcomed!"

- [Pratik Khot](https://github.com/pratikkhot100) 
