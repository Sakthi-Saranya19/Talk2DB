# Talk2DB
**Chat with your database using the power of Llama.** A Spring Boot application that orchestrates natural language queries between a React frontend, a Llama LLM, and your SQL database.
# 🦙 [Talk2DB]

> **Chat with your database using the power of Llama.** A Spring Boot application that orchestrates natural language queries between a React/Angular/Vue frontend, a Llama LLM, and your SQL database.

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![Llama](https://img.shields.io/badge/Model-Llama-purple)

## 📖 Overview

This project allows users to ask questions in plain English (e.g., *"How many products were sold in May?"*) and receive accurate answers from the database. 

Instead of relying on external cloud APIs, this project utilizes **Llama** (via [Ollama/LocalAI/HuggingFace]) to interpret the user's intent and generate the SQL query. The Spring Boot backend executes the query and returns the results to the frontend.

## 🏗️ Architecture

1.  **Frontend:** User types a prompt.
2.  **Spring Boot Controller:** Receives the prompt.
3.  **System Prompting:** The app augments the user's prompt with the database schema context.
4.  **Llama LLM:** Generates the SQL query based on the schema and prompt.
5.  **Database Execution:** Spring Boot runs the SQL against the database.
6.  **Response:** The data is formatted and sent back to the frontend.

## 🚀 Features

* **Llama-Powered Intelligence:** Utilizes state-of-the-art open-source models for query generation.
* **Privacy-Focused:** Designed to work with local LLM deployments (optional).
* **Schema Aware:** Dynamically injects table structures into the LLM prompt.
* **Sanitization:** Basic SQL validation to prevent destructive queries.

## 🛠️ Tech Stack

* **Backend:** Java 17+, Spring Boot 3
* **AI Engine:** Llama (via [Ollama / Spring AI / Custom REST Client])
* **Database:** [PostgreSQL / MySQL / H2]
* **Frontend:** [React / Angular / Vue / Thymeleaf]

## 📋 Prerequisites

Before running the application, ensure you have the following:

1.  **Java 17** or higher installed.
2.  **Database** running and accessible.
3.  **Llama Model Access:**
    * *If running locally:* Ensure **Ollama** (or your preferred runner) is serving the Llama model on `http://localhost:11434` (or your configured port).
    * *If using an API:* Have your API key and endpoint ready.

## ⚙️ Configuration

1.  **Clone the repo:**
    ```bash
    git clone [https://github.com/your-username/your-repo-name.git](https://github.com/your-username/your-repo-name.git)
    ```

2.  **Configure `application.properties`:**

    ```properties
    # Database Settings
    spring.datasource.url=jdbc:mysql://localhost:3306/mydb
    spring.datasource.username=read_only_user
    spring.datasource.password=secret

    # Llama Configuration (Example using Spring AI or REST)
    # Adjust based on how you connect to Llama
    ai.service.url=http://localhost:11434/api/generate
    ai.model.name=llama3
    ```

## ⚠️ Safety & Security

> **Critical:** This tool gives an AI model access to query your database.
> 1.  **Read-Only Access:** ALWAYS use a database user with `SELECT` privileges only.
> 2.  **Input Validation:** Do not expose this directly to the public internet without proper authentication and rate limiting.

## 🏃‍♂️ Running the App

1.  Start your Llama server (if local).
2.  Run the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
    ```
3.  Open your frontend application to start chatting with your data.

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## 📄 License

[MIT](https://choosealicense.com/licenses/mit/)
