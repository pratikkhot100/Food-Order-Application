# 🍔 Food Ordering Application

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

- **Model**: Java classes representing data entities like `User`, `FoodItem`, `Order`, etc.  
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

## 🖼️ Screenshots

 ### 🏠 Home Page
   
 ![Screenshot 2025-04-14 184419](https://github.com/user-attachments/assets/2e3faab6-4a1f-40f0-b295-665f523d166a)

 ![Screenshot 2025-04-14 184436](https://github.com/user-attachments/assets/a0fe2305-4358-44f9-a472-e6e4207e0128)

 ![Screenshot 2025-04-14 184445](https://github.com/user-attachments/assets/9389c4d7-87d4-45f5-a6f1-c9edb027a367)

 - Company
   
 ![Screenshot 2025-04-14 184459](https://github.com/user-attachments/assets/a709bbe9-9ca7-46c9-9802-feff2fa00d25)

 - Contact
   
 ![Screenshot 2025-04-14 184510](https://github.com/user-attachments/assets/f85c1916-e127-475f-bb34-d16de67bd359)

 - Login
   
 ![Screenshot 2025-04-14 184526](https://github.com/user-attachments/assets/5340475c-84ac-46ca-850b-f6b75ba6e469)
 
 - Registration
   
 ![Screenshot 2025-04-14 184546](https://github.com/user-attachments/assets/9ad60134-55f6-468c-8617-c44383e2cf76)

 ---
 
 ### 👤 User Role
 
 ![Screenshot 2025-04-14 185035](https://github.com/user-attachments/assets/9a93f232-f733-401d-be02-c2aca06bda4c)

 - Menus
   
 ![Screenshot 2025-04-14 185043](https://github.com/user-attachments/assets/3a1f2859-fb23-41a5-bb7b-90d0a0be9942)

 - Profile
   
 ![Screenshot 2025-04-14 185052](https://github.com/user-attachments/assets/aff9ef54-23d1-44d4-98a1-071c98f15bc2)

 - Order History
   
 ![Screenshot 2025-04-14 185104](https://github.com/user-attachments/assets/1fa07e6e-f5eb-4c16-b972-5ca7ea36d11c)

  ---
 
 ### 🛠️ Admin Role

 ![Screenshot 2025-04-14 184642](https://github.com/user-attachments/assets/6c86aa7b-b21f-42cc-ac06-c3db201e95c7)

 - Add Food
   
 ![Screenshot 2025-04-14 184659](https://github.com/user-attachments/assets/116d837e-b4e1-476c-af62-1f66d70dde56)

 - All Order
   
 ![Screenshot 2025-04-14 184710](https://github.com/user-attachments/assets/1fde895c-c8db-4e1f-9f87-feee354ac0f0)

 - Menus
   
 ![Screenshot 2025-04-14 184722](https://github.com/user-attachments/assets/79ae853d-815f-464a-b9f6-cba57d057d9b)

 ![Screenshot 2025-04-14 184742](https://github.com/user-attachments/assets/3a430e7d-dc7d-498d-8b40-0f92fac391a1)
 
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

## 🍚 ================= MySQL Database =================

 STEP 1: Open MySQL Command Prompt or MySQL Workbench

 STEP 2: Login to the administrator user of MySql:
	 ```mysql -u <username> -p``` (Enter Password if asked)

 STEP 3: Copy paste and execute the MySQL Query from the following file:-
 - Run the Sql Query From this file: [MySQL Database](https://github.com/pratikkhot100/Online-Food_Application/blob/main/mysql_database.sql) 

---

 ## 📞 Contact Information

  🐙 GitHub: https://github.com/pratikkhot100

  💼 LinkedIn: https://www.linkedin.com/in/pratikkhot01

  📧 Email: pratikkhot1207@gmail.com
