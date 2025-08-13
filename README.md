# StudentCrudAwsRds

## Overview
**StudentCrudAwsRds** is a Java Spring Boot project that provides CRUD (Create, Read, Update, Delete) operations for managing student records. 

The backend is deployed on **AWS Lambda** using **Spring Cloud Function** and is connected to an **AWS RDS PostgreSQL** database. The API is exposed via **AWS API Gateway**, which resides in a **VPC** with properly configured subnets for secure networking. **IAM roles** are used to control access to AWS resources. The frontend is hosted on **AWS S3** as a static website.

**Working frontend link:**  
[Student CRUD Demo](http://student-crud-demo-frontend.s3-website-ap-southeast-2.amazonaws.com/)

---

## Features
- Create, Read, Update, and Delete student records
- Serverless backend using AWS Lambda
- REST API exposed via API Gateway
- Secure network setup in VPC with private/public subnets
- Persistent data storage in PostgreSQL (RDS)
- IAM roles for controlled AWS access
- Frontend hosted on S3
- Easy CI/CD integration with GitHub

---

## Architecture Overview
![AWS Architecture Diagram](images/architecture.png)



## Prerequisites
- Java JDK 21
- Maven
- Git
- AWS Account with Lambda, RDS, API Gateway, S3 access, and IAM permissions

---

## Setup Instructions

### 1. Clone the repository
//bash
git clone https://github.com/algobrewery/student-aws-rds-demo.git
cd student-aws-rds-demo

2. Configure database
Update your application.properties (or use environment variables) with your RDS PostgreSQL credentials:

3. Build and deploy to AWS Lambda
//bash
mvn clean package
Upload the generated JAR to AWS Lambda, assign the appropriate IAM role, and configure environment variablesand set up rds postgres database. Ensure Lambda is associated with the correct VPC and subnets.

4. Configure API Gateway
Create REST API and integrate with Lambda

Enable CORS if frontend requests are cross-origin

Deploy API to a stage

5. Access the frontend
Open the hosted S3 link:
[Student CRUD Demo](http://student-crud-demo-frontend.s3-website-ap-southeast-2.amazonaws.com/)



Add caching layer for frequent database queries

