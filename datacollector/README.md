# 🧩 Data Collector Service

## Service Name
**Data Collector Service**

## Overview
The **Data Collector Service** is a **Spring Boot microservice** responsible for fetching **product** and **promotion** data from various third-party providers and publishing the collected data to designated **Kafka topics** for downstream processing.

## Core Responsibilities
- **Integrate with multiple external systems**  
  Fetch data from providers such as Techopolis, Zora, etc., via provider-specific APIs.

- **Normalize and validate the fetched data**  
  Convert provider-specific data formats into a unified internal model and ensure data quality.

- **Publish processed data to Kafka topics**  
  Send data to appropriate Kafka topics (e.g., `products`, `promotions`) for consumption by downstream services.

- **Support easy addition of new providers**  
  Enable adding new providers with minimal changes to the existing codebase using design patterns like Strategy and Factory.

## Architecture Overview
- **Provider Abstraction (Strategy Pattern)**  
  Each third-party provider implements a common interface for data fetching, allowing the service to switch providers easily.

- **Provider Factory (Factory Pattern)**  
  Handles the creation of provider instances dynamically based on configuration.

- **Kafka Integration**  
  A separate publisher component handles sending data to Kafka topics, keeping messaging concerns decoupled from business logic.

## Configuration
Provider-specific credentials and endpoints are managed through Spring Boot configuration: