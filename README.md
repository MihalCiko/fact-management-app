# Fact Management App
The Fact App is a simple application that allows you to manage facts. 
It provides functionality to Search, Edit and Delete facts.

## Prerequisites
To get started with the Facts App:

* Java Development Kit (JDK) 11 or higher installed
* Gradle build tool installed
* MySQL database installed

## Setup
1. Clone the repository:
`git clone https://github.com/MihalCiko/fact-management-app.git`

2. Open the project in your favorite IDE.

3. Configure the database connection by updating the `application.properties` file located 
 in `src/main/resources` with your local database credentials.
4. Build the project using Gradle: `./gradlew build`
5. Run the application: `./gradlew bootRun`


The application will start running on http://localhost:8080/home.
