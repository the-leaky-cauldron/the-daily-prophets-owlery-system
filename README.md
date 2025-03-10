# The Daily Prophet's Owlery System

## Overview

The Daily Prophet's Owlery System is a Spring Boot application that manages message delivery and notifications. Named after the owl postal service in the Harry Potter universe, this system handles message creation, delivery tracking, and notification management for the Daily Prophet publication platform.

## Features

- Message creation and delivery
- Recipient management
- Kafka integration for real-time notifications

## Tech Stack

- Java 17
- Spring Boot 3.4.3
- Spring Security
- Apache Kafka

## Prerequisites

- JDK 17 or higher
- Maven 3.8+
- Kafka 3.0+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Installation

### Environment Setup

1. Install JDK 17

   ```bash
   # For Ubuntu/Debian
   sudo apt install openjdk-17-jdk
   
   # For macOS (using Homebrew)
   brew install openjdk@17
   ```

2. Install Kafka ─ I have followed this [link](https://hub.docker.com/r/bitnami/kafka) to install kafka in docker

    ```sh
    docker run -d --name kafka-server \
        -p 9092:9092 --network app-tier \
        -e KAFKA_CFG_NODE_ID=0 \
        -e KAFKA_CFG_PROCESS_ROLES=controller,broker \
        -e KAFKA_CFG_LISTENERS=PLAINTEXT://:9092,CONTROLLER://:9093 \
        -e KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
        -e KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT \
        -e KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=0@kafka-server:9093 \
        -e KAFKA_CFG_CONTROLLER_LISTENER_NAMES=CONTROLLER \
        bitnami/kafka:latest
    ```

### Environment Variables

The application requires the following environmental variables:

- `APP_MAIL`: Application mail
- `APP_PASS`: Application password

#### Setting Environment Variables

For Linux/macOS:

```bash
export APP_MAIL=your_gmail_address
export APP_PASS=your_app_password
```

For Windows Command Prompt:

```cmd
set APP_MAIL=your_gmail_address
set APP_PASS=your_app_password
```

For Windows PowerShell:

```powershell
$env:APP_MAIL="your_gmail_address"
$env:APP_PASS="your_app_password"
```

### Application Setup

1. Clone the repository

   ```sh
        git clone https://github.com/the-leaky-cauldron/the-daily-prophets-owlery-system
        cd the-daily-prophets-owlery-system
   ```

2. Build the application

    ```sh
        ./mvnw clean package -DskipTests
    ```

3. Run the application

    ```sh
        # If using Maven
        mvn spring-boot:run

        # If using Gradle
        ./gradlew bootRun
    ```

The application will start on port 8081 by default.

## Acknowledgments

- Inspired by J.K. Rowling's Harry Potter series
- Special thanks to all contributors
- Scaler Academy for project guidance
- Spring Boot and related open-source communities

## Contact

- Project Maintainer: [Vijaysurya Mandala](https://github.com/mandalavijaysurya)
- Project Repository: [GitHub](https://github.com/the-leaky-cauldron/the-daily-prophets-owlery-system)
- Issue Tracker: [GitHub Issues](https://github.com/the-leaky-cauldron/the-daily-prophets-owlery-system/issues)
