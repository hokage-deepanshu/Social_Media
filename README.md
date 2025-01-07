# Social_Media

# Mini Social Media Platform

## Overview
The **Mini Social Media Platform** is a web-based application designed to facilitate social interactions among users. The platform includes features such as user registration, post creation, and interactions through likes and comments. It demonstrates the use of modern web development technologies with a focus on scalability and maintainability.

---

## Features

### User Features
- **Registration and Login**: Secure user authentication.
- **Profile Management**: Update user details and profile picture.

### Post Features
- **Create Posts**: Add text or media content.
- **Edit/Delete Posts**: Modify or remove existing posts.
- **Like and Comment**: Interact with other users' posts.

### Admin Features
- **User Management**: View and manage user accounts.
- **Content Moderation**: Monitor and manage posts and comments.

---

## Technologies Used

### Frontend
- HTML
- CSS
- JavaScript

### Backend
- Java (Core & Advanced)
- Maven
- (Optional: Spring Boot for REST APIs)

### Database
- MySQL

### Tools
- IntelliJ IDEA
- MySQL Workbench

---

## System Architecture
- **Frontend**: Handles user interactions and sends requests to the backend.
- **Backend**: Processes requests, handles business logic, and communicates with the database.
- **Database**: Stores user, post, like, and comment data.

---

## Entity-Relationship Diagram

### Entities and Attributes

#### 1. Users
- **UserID** (Primary Key)
- Username
- Password
- Email
- ProfilePicture

#### 2. Posts
- **PostID** (Primary Key)
- UserID (Foreign Key)
- Content
- CreatedAt

#### 3. Likes
- **LikeID** (Primary Key)
- UserID (Foreign Key)
- PostID (Foreign Key)

#### 4. Comments
- **CommentID** (Primary Key)
- UserID (Foreign Key)
- PostID (Foreign Key)
- CommentText

### Relationships
- **Users and Posts**: One-to-Many
- **Users and Likes**: One-to-Many
- **Users and Comments**: One-to-Many
- **Posts and Likes**: One-to-Many
- **Posts and Comments**: One-to-Many

---

## Installation and Setup

### Prerequisites
- Java installed on the system.
- MySQL Server running.
- IntelliJ IDEA or any preferred IDE.

### Steps
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Open the project in IntelliJ IDEA.
3. Configure the database connection in the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/social_media
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
4. Build and run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
5. Access the application:
   - **Frontend**: Open `index.html` in your browser.
   

---

## Testing

### Unit Testing
- Test service and DAO layers using JUnit and Mockito.

### Integration Testing
- Use Postman or similar tools to test REST endpoints.

---

## Future Enhancements
- Add messaging functionality.
- Implement real-time notifications.
- Develop a recommendation system for suggested posts or friends.

---
