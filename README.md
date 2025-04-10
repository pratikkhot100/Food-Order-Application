# Online Food Ordering Application

A full-stack web application built using Java (JSP, Servlets), JDBC, and MySQL. The project allows users to browse and order food, while admins can manage menu items, categories, and orders.

The goal of this project is to develop a user-friendly online food ordering system that streamlines the process of browsing menus, placing orders, and managing food items. It aims to bridge the gap between restaurants and customers through a digital platform, offering convenience, efficiency, and real-time order management for both users and administrators.

---

## 🧰 (images/tech-heading.png)

### Technologies Used

- **Backend**: Java, JSP, Servlets, JDBC, POJO classes  
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
│       │       ├── model/          # POJO classes (Models)
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

### 🏠 Home Page

  ![Screenshot 2025-04-10 195651](https://github.com/user-attachments/assets/1f7773b1-c231-40cc-96d3-c397a943abb9)

  ![Screenshot 2025-04-10 195708](https://github.com/user-attachments/assets/417461f9-dce6-4f46-8dbc-c116fe5d31b0)

  ![Screenshot 2025-04-10 195731](https://github.com/user-attachments/assets/c23a48cf-1479-4cd5-850e-606f870ca034)

  ![Screenshot 2025-04-10 195744](https://github.com/user-attachments/assets/54a744d2-75d0-4568-a3bb-3e43d13d3b86)

  ![Screenshot 2025-04-10 195757](https://github.com/user-attachments/assets/0ecf3c85-1703-4456-8d2d-c2a83312fa43)

  ![Screenshot 2025-04-10 195809](https://github.com/user-attachments/assets/edf240ca-98c1-4698-8508-fbd6bab66995)

  ![Screenshot 2025-04-10 195822](https://github.com/user-attachments/assets/a3f86263-7a20-40c3-8bac-5cea0adbb492)

### 👥 User Dashboard

  ![Screenshot 2025-04-10 195849](https://github.com/user-attachments/assets/050dbcb5-be8d-4c5b-a838-5ea630841f06)

  ![Screenshot 2025-04-10 195919](https://github.com/user-attachments/assets/2130109f-6a70-4a45-ac80-a50e4e972946)

  ![Screenshot 2025-04-10 195954](https://github.com/user-attachments/assets/b7375e2e-3779-419e-92f9-ac6759901dc8)

  ![Screenshot 2025-04-10 200053](https://github.com/user-attachments/assets/76135987-a708-4094-b1ab-089f189f5412)

  ![Screenshot 2025-04-10 200110](https://github.com/user-attachments/assets/2c8714f4-ca70-4fde-9421-1f7ef9aa7df2)


### 🛠️ Admin Dashboard

  ![Screenshot 2025-04-10 200236](https://github.com/user-attachments/assets/368f13e0-ebac-42ea-85b1-ffd921758510)

  ![Screenshot 2025-04-10 200311](https://github.com/user-attachments/assets/9d7d6816-7d82-46fb-b0e9-8adedd6d6602)

  ![Screenshot 2025-04-10 200325](https://github.com/user-attachments/assets/4b162214-e7ca-4c49-a39e-83ed9051fecd)

  ![Screenshot 2025-04-10 200352](https://github.com/user-attachments/assets/6c5bd5af-9d8d-4a6a-a4a2-85ba636f548f)
  
---

## ================= MySQL Database =================

 STEP 1: Open MySQL Command Prompt or MySQL Workbench

 STEP 2: Login to the administrator user of MySql:
	 ```mysql -u <username> -p``` (Enter Password if asked)

 STEP 3: Copy paste and execute the MySQL Query from the following file:-
 - Run the Sql Query From this file: [MySQL Database](https://github.com/pratikkhot100/Online-Food_Application/blob/main/mysql_database.sql) 

---

## "Suggestions and project improvement ideas are welcomed!"

- [Pratik Khot](https://github.com/pratikkhot100) 
