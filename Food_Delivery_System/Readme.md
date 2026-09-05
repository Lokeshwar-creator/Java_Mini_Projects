# 🍔 Food Delivery System

A console-based **Food Delivery System built using Core Java and Object-Oriented Programming (OOP)**.

This project is designed as a Java mini-project to understand and practically apply OOP concepts such as **classes, objects, encapsulation, abstraction, interfaces, polymorphism, composition, association, enums, and exception handling**.

---

## 📌 Project Overview

The Food Delivery System allows a customer to:

* View restaurants
* View restaurant menus
* Add food items to a cart
* Remove items from the cart
* View cart and calculate total
* Place an order
* Make payments
* Select different payment methods
* Assign a delivery partner
* Track delivery
* Update order status
* Cancel orders
* View customer and order details

The application runs completely through the **Java console** and stores data temporarily using `ArrayList`.

---

# 🛠️ Technologies Used

* **Java**
* Core Java
* Object-Oriented Programming
* `ArrayList`
* Interfaces
* Enums
* Exception Handling
* VS Code

No database or external framework is required.

---

# 📁 Project Structure

```text
FoodDeliverySystem/
│
├── FoodItem.java
├── Restaurant.java
├── Customer.java
├── Cart.java
├── OrderStatus.java
├── Order.java
│
├── Payment.java
├── UPIPayment.java
├── CardPayment.java
├── CashPayment.java
│
├── DeliveryStatus.java
├── DeliveryPartner.java
├── Delivery.java
│
├── FoodDeliveryService.java
└── Main.java
```

---

# 🔄 Project Workflow

The complete application workflow is:

```text
                    START
                      │
                      ▼
              Food Delivery System
                      │
                      ▼
              View Restaurants
                      │
                      ▼
                 View Menu
                      │
                      ▼
               Select Food
                      │
                      ▼
                 Add to Cart
                      │
                      ▼
                 View Cart
                      │
                      ▼
                Place Order
                      │
                      ▼
                    ORDER
                      │
                      ▼
                  PAYMENT
                      │
             ┌────────┼────────┐
             ▼        ▼        ▼
            UPI      CARD     CASH
             │        │        │
             └────────┼────────┘
                      ▼
                Order Confirmed
                      │
                      ▼
                  Preparing
                      │
                      ▼
             Assign Delivery Partner
                      │
                      ▼
              Out for Delivery
                      │
                      ▼
                  Delivered
                      │
                      ▼
                     END
```

---

# 🧩 Class Relationships

The main relationships between objects are:

```text
Customer
   │
   └── HAS-A → Cart
                 │
                 └── HAS-A → FoodItem


Restaurant
   │
   └── HAS-A → FoodItem


Order
   ├── HAS-A → Customer
   ├── HAS-A → Restaurant
   ├── HAS-A → FoodItem
   ├── HAS-A → Payment
   └── HAS-A → Delivery


Delivery
   │
   └── HAS-A → DeliveryPartner
```

Payment uses polymorphism:

```text
                  Payment
                     │
          ┌──────────┼──────────┐
          ▼          ▼          ▼
       UPI Payment Card Payment Cash Payment
```

---

# 🧠 OOP Concepts Used

## 1. Class

Each real-world entity is represented using a class.

Examples:

```text
Customer
Restaurant
FoodItem
Cart
Order
Delivery
Payment
```

---

## 2. Object

Objects represent actual entities.

Example:

```java
Customer customer =
    new Customer(1, "Lokesh", "9876543210", "Chennai");
```

Here:

* `Customer` → class
* `customer` → reference
* `new Customer(...)` → object

---

## 3. Encapsulation

Data members are declared `private`.

Example:

```java
private String name;
private double price;
```

They are accessed through methods such as:

```java
getName()
getPrice()
```

This protects the internal data of an object.

---

## 4. Constructor

Constructors initialize objects.

Example:

```java
public FoodItem(
        int itemId,
        String name,
        double price,
        String category) {

    this.itemId = itemId;
    this.name = name;
    this.price = price;
    this.category = category;
}
```

---

## 5. Abstraction

The `Payment` interface defines what every payment method should do.

```java
public interface Payment {

    void pay(double amount);

    void refund(double amount);
}
```

It doesn't specify how each payment method performs the operation.

---

## 6. Polymorphism

Different payment classes implement the same `Payment` interface.

```text
Payment
   │
   ├── UPIPayment
   ├── CardPayment
   └── CashPayment
```

Therefore:

```java
Payment payment;
```

can refer to:

```java
new UPIPayment(...)
```

or:

```java
new CardPayment(...)
```

or:

```java
new CashPayment()
```

And:

```java
payment.pay(amount);
```

automatically executes the appropriate implementation.

---

## 7. Composition / HAS-A Relationship

Objects contain other objects.

For example:

```java
private Cart cart;
```

inside `Customer`.

Therefore:

```text
Customer HAS-A Cart
```

Similarly:

```text
Order HAS-A Delivery
Delivery HAS-A DeliveryPartner
```

---

## 8. Enum

Enums are used for fixed states.

### Order Status

```text
PLACED
CONFIRMED
PREPARING
OUT_FOR_DELIVERY
DELIVERED
CANCELLED
```

### Delivery Status

```text
ASSIGNED
PICKED_UP
ON_THE_WAY
DELIVERED
```

Enums prevent invalid values and make the code easier to understand.

---

## 9. Exception Handling

Input validation is handled using exception handling.

For example:

```java
try {
    return Integer.parseInt(scanner.nextLine());
}
catch (NumberFormatException e) {
    System.out.println("Please enter a valid number.");
}
```

This prevents the application from crashing when the user enters invalid input.

---

# 📦 Main Classes

### `FoodItem`

Represents individual food items.

Stores:

```text
Item ID
Name
Price
Category
```

---

### `Restaurant`

Represents a restaurant and its menu.

Responsibilities:

* Add food
* Display menu
* Display restaurant information

---

### `Customer`

Represents a customer.

Stores:

```text
Customer ID
Name
Phone
Address
Cart
```

---

### `Cart`

Manages selected food items.

Responsibilities:

* Add food
* Remove food
* Calculate total
* Display cart
* Clear cart

---

### `Order`

Represents a placed order.

Stores:

```text
Order ID
Customer
Restaurant
Food Items
Total Amount
Order Status
Payment
Delivery
```

---

### `Payment`

Interface representing the payment contract.

Implementations:

```text
UPIPayment
CardPayment
CashPayment
```

---

### `Delivery`

Represents delivery information.

Stores:

```text
Delivery ID
Delivery Partner
Delivery Address
Delivery Status
```

---

### `DeliveryPartner`

Represents the person delivering the order.

Stores:

```text
Partner ID
Name
Phone
```

---

### `FoodDeliveryService`

Acts as the main service/business layer.

Responsibilities:

* Manage restaurants
* Manage customers
* Place orders
* Find orders
* Assign delivery partners

---

### `Main`

The entry point of the application.

It provides the console menu and interacts with the user.

---

# ▶️ How to Run

### Step 1 — Install Java

Make sure Java is installed.

Check:

```bash
java -version
```

and:

```bash
javac -version
```

---

### Step 2 — Open the Project

Open the `FoodDeliverySystem` folder in VS Code.

---

### Step 3 — Open Terminal

In VS Code:

```text
Terminal → New Terminal
```

---

### Step 4 — Compile

Run:

```bash
javac *.java
```

---

### Step 5 — Run

Run:

```bash
java Main
```

---

# 🎮 Application Menu

```text
========================================
       FOOD DELIVERY SYSTEM
========================================

1. View Restaurants
2. View Restaurant Menu
3. Add Food to Cart
4. View Cart
5. Remove Food from Cart
6. Place Order
7. Make Payment
8. Update Order Status
9. Assign Delivery Partner
10. Track Order
11. Cancel Order
12. View All Orders
13. View Customer Profile
0. Exit

========================================
```

---

# 📝 Example Workflow

A typical order can be processed as:

```text
1. View Restaurants
       ↓
2. View Restaurant Menu
       ↓
3. Add Food to Cart
       ↓
4. View Cart
       ↓
6. Place Order
       ↓
7. Make Payment
       ↓
8. Confirm Order
       ↓
8. Preparing
       ↓
9. Assign Delivery Partner
       ↓
8. Out for Delivery
       ↓
10. Track Order
       ↓
8. Delivered
```

---

# 🎯 Learning Objectives

This project helps understand:

* How to identify classes from a real-world problem
* How objects communicate with each other
* How to use encapsulation
* How interfaces provide abstraction
* How polymorphism reduces `if-else` logic
* How composition and association work
* How enums represent states
* How to separate business logic from the main program
* How to design a small OOP-based application

---

# 🚀 Future Enhancements

This console application can later be upgraded with:

* MySQL database
* JDBC
* Login and registration
* Admin panel
* Restaurant owner login
* Multiple customers
* Order history
* Food quantity
* Discounts and coupons
* GST and delivery charges
* Online payment integration
* GUI using JavaFX
* REST API using Spring Boot
* Web/mobile frontend

---

# 👨‍💻 Project Type

**Java Mini Project — OOP Practice**

The primary goal of this project is to build strong practical understanding of **Java OOP and Low-Level Design concepts** by modeling a real-world food delivery application.
