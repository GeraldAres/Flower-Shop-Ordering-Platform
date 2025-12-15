# FLOWER BUSINESS ORDER SYSTEM
**Demonstrated via a Flower Shop (Extensible to Other Small Businesses)**
**By: Javawokez (Alcoseba, Aloyon, Ares, Encabo, Quibuyen)**

---

## Table of Contents

1. Overview
2. Description
3. Who Can Benefit?
4. System Architecture & Design Patterns
   * MVC Architecture
   * Abstract Factory Pattern
   * Facade Pattern
5. Object-Oriented Programming Principles
   * Inheritance
   * Encapsulation
   * Polymorphism
   * Abstraction
6. File Handling & Data Persistence
7. Graphical User Interface (GUI)
8. Scalability & Customization
9. Future Enhancements

---

## 1. Overview

The **Lower Business Order System** is a Java-based desktop application designed to help small businesses manage customer orders efficiently. While the system is demonstrated using a **Flower Shop** scenario, its architecture and design allow it to be easily adapted for other small businesses such as bakeries, cafés, retail stores, and service-based shops.

The system focuses on clean software architecture, strong object-oriented principles, and a flexible user interface that supports future customization.

---

## 2. Description

This system provides a complete order lifecycle for small businesses, including:
* User account creation and authentication
* Order placement and cancellation
* Retrieval of previous order records
* Simple and intuitive graphical interface

The project emphasizes **maintainability, scalability, and reusability**, making it suitable both as a learning project and as a foundation for real-world small business applications.

---

## 3. Who Can Benefit?

The Lower Business Order System is ideal for:

* **Small business owners** needing a basic order management solution
* **Developers** looking for a reusable desktop system template
* **Startups** requiring a lightweight, customizable order system

---

## 4. System Architecture & Design Patterns

### MVC (Model-View-Controller) Architecture

The system follows the **MVC design architecture** to ensure separation of concerns:

* **Model** – Handles business logic, order data, user data, and file operations
* **View** – Manages the graphical user interface (Swing-based forms)
* **Controller** – Acts as the bridge between the View and Model, processing user input and updating data accordingly

This structure improves code readability, testability, and long-term maintenance.

---

### Abstract Factory Pattern

The **Abstract Factory Pattern** is used to:

* Create families of related objects (e.g., stems and bouquets)
* Allow easy substitution of business types (Flower Shop → Bakery, Café, etc.)
* Promote loose coupling between object creation and implementation

This ensures that new business domains can be introduced with minimal code changes.

---

### Facade Pattern

The **Facade Pattern** provides a simplified interface for complex subsystems such as:

* Order processing
* User authentication
* File handling

By using a facade, the system reduces dependencies and simplifies interactions between components.

---

## 5. Object-Oriented Programming Principles

### Implementation of Inheritance

Inheritance is used to:

* Share common properties and behaviors among related classes
* Create base classes such as `User`, `Product`, or `Order`
* Extend these base classes for specific implementations (e.g., `User`, `Guest`, `Bouquet`)

This reduces code duplication and improves maintainability.

---

### Implementation of Encapsulation

Encapsulation is enforced by:

* Using private fields for class data
* Providing controlled access through getters and setters
* Protecting sensitive information such as user credentials

This ensures data integrity and controlled interaction with system components.

---

### Implementation of Polymorphism

Polymorphism allows:

* Different product or order types to be treated uniformly
* Method overriding for customized behavior per business type
* Flexible expansion of features without modifying existing code

---

### Implementation of Abstraction

Abstraction is applied using:

* Abstract classes and interfaces
* High-level definitions for business operations

This hides implementation details and allows developers to focus on functionality rather than internal complexity. 
This was displayed through using interfaces and abstract classes all throughout the program.

---

## 6. File Handling & Data Persistence

The system uses **file handling** to store and retrieve data without requiring a database.

Supported features include:

* User sign-up and login persistence
* Order creation and cancellation
* Retrieval of old order details
* Basic record management using text or serialized files

This approach keeps the system lightweight and easy to deploy.

---

## 7. Graphical User Interface (GUI)

The GUI is built using a combination of:

* **Figma-based design concepts**
* **Java Swing forms**
* **Pure Java code for custom layouts and interactions**
* **Hand-drawn visual elements** for a unique and user-friendly appearance

The codebase allows future clients or developers to:
* Replace existing designs
* Integrate their own UI concepts seamlessly
* Customize branding without changing core logic

---

## 8. Scalability & Customization
Although demonstrated as a Flower Shop system, the architecture allows:
* Easy adaptation to other small business models
* Addition of new product categories
* Expansion of order workflows
* Integration with future technologies (e.g., databases, APIs)

---

## 9. Future Enhancements
Potential future improvements include:
* Database integration (MySQL, SQLite, etc.)
* Role-based access control
* Advanced reporting and analytics
* Online ordering support
* Improved UI/UX with modern Java frameworks

---

## Conclusion
The **Flower Business Order System** is a well-structured, object-oriented Java application that demonstrates real-world software engineering principles while remaining flexible enough for practical use and future growth.
