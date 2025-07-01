Currency Converter API 💰↔️💹
A simple REST API for currency conversion with exchange rate caching.
Uses the free Frankfurter API for real-time exchange rates.

Tech Stack

Java 17

Spring Boot 3.2

Spring Cache

Lombok

Swagger (OpenAPI 3)

Maven

Quick Start
1. Build & Run
bash
mvn clean package  
java -jar target/currency-converter-service-1.0-SNAPSHOT.jar  
Or using Docker:

bash
docker build -t currency-converter .  
docker run -p 8080:8080 currency-converter  
2. API Documentation
After starting, open in your browser:
🔗 http://localhost:8080/swagger-ui.html

How to Use
Endpoint:
POST /api/currency/convert
Sample Request:
json
{  
  "from": "USD",  
  "to": "EUR",  
  "amount": 100  
}  
Sample Response:
json
{  
  "from": "USD",  
  "to": "EUR",  
  "rate": 0.93,  
  "result": 93.00  
}  
Key Features
✅ Rate Caching - Exchange rates cached in memory for 10 minutes
✅ Error Handling - Clear error messages when API is unavailable
✅ Swagger Docs - Interactive API documentation
✅ Docker Support - Easy container deployment

