# SecureAuth: JWT + RBAC Security

This project is a Spring Boot application that demonstrates a secure authentication and authorization system using JSON Web Tokens (JWT) and Role-Based Access Control (RBAC).

## Technologies Used

*   **Spring Boot:** Framework for building the application.
*   **Spring Security:** For handling authentication and authorization.
*   **Spring Data JPA:** For data persistence.
*   **JWT (JSON Web Token):** For creating access and refresh tokens.
*   **MySQL:** As the relational database.
*   **Maven:** For project build and dependency management.

## Prerequisites

*   **Java 21**
*   **Maven**
*   **MySQL** database server

## Setup and Configuration

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/Valtor26/secure-auth.git
    ```

2.  **Database Configuration:**
    *   Create a MySQL database named `secureauth_db`.
    *   The application uses `spring.jpa.hibernate.ddl-auto=update`, which will automatically create the necessary tables on startup.

3.  **Environment Variables:**
    This project uses environment variables to handle sensitive information. You need to set the following variables in your operating system or IDE configuration:
    *   `DB_USERNAME`: Your MySQL database username.
    *   `DB_PASSWORD`: Your MySQL database password.
    *   `JWT_SECRET`: A strong secret key for signing the JWTs.

## How to Run

1.  **Build the project:**
    ```sh
    mvn clean install
    ```

2.  **Run the application:**
    ```sh
    mvn spring-boot:run
    ```
    The application will start on `http://localhost:8080`.

## API Endpoints

### Authentication (`/api/auth`)

*   `POST /signup`: Register a new user.
*   `POST /login`: Authenticate a user and receive an access and refresh token.
*   `POST /refresh`: Obtain a new access token using a valid refresh token.
*   `POST /logout`: Log out the user and invalidate the refresh token.

### User (`/api/user`)

*   `GET /profile`: Get the profile of the currently authenticated user. (Requires `USER` or `ADMIN` role)
*   `GET /dashboard`: Access the user dashboard. (Requires `USER` or `ADMIN` role)

### Admin (`/api/admin`)

*   `GET /dashboard`: Access the admin dashboard. (Requires `ADMIN` role)
*   `GET /users`: Get a list of all registered users. (Requires `ADMIN` role)
*   `DELETE /users/{id}`: Delete a user by their ID. (Requires `ADMIN` role)
