# 🏗️ Low Level Design (LLD) — Java

A comprehensive collection of **Low Level Design** patterns and real-world system design problems implemented in Java. This repository is structured to demonstrate both **bad practices** (anti-patterns) and **good practices** (clean, pattern-driven solutions) side by side.

---

## 📁 Project Structure

```
LowLevelDesign/
├── src/
│   ├── BehavioralDesignPattern/
│   │   ├── ChainOfResponsibilityDesignPattern/
│   │   ├── CommandDesignPattern/
│   │   ├── IteratorDesignPattern/
│   │   ├── MediatorDesignPattern/
│   │   ├── MementoDesignPattern/
│   │   ├── ObserverDesignPattern/
│   │   ├── StateDesignPattern/
│   │   ├── StrategyDesignPattern/
│   │   ├── TemplateDesignPattern/
│   │   └── VisitorDesignPattern/
│   │
│   ├── CreationalDesignPatterns/
│   │   ├── AbstractFactoryDesignPattern/
│   │   ├── BuilderDesignPattern/
│   │   ├── FactoryDesignPattern/
│   │   ├── PrototypeDesignFactory/
│   │   └── SingletonDesignPattern/
│   │
│   ├── StructuralDesignPatterns/
│   │   ├── AdapterDesignPattern/
│   │   ├── BridgeDesignPattern/
│   │   ├── CompositeDesignPattern/
│   │   ├── DecoraterDesignPattern/
│   │   ├── FacadeDesignPattern/
│   │   ├── FlyweightDesignPattern/
│   │   └── ProxyDesignPattern/
│   │
│   └── InterviewProblems/
│       ├── ATMMachine/
│       ├── CarRentalSystem/
│       ├── Chess/
│       ├── DesignCache/
│       ├── DiningPhilosophers/
│       ├── Elevator/
│       ├── FileSystem/
│       ├── InventoryManagementSystem/
│       ├── LoggingSystem/
│       ├── MovieTicketBookingSystem/
│       ├── MultiThreadWebCrawler/
│       ├── ParkingLot/
│       ├── SnakeAndFoodGame/
│       ├── SplitWise/
│       ├── TicTacToe/
│       ├── TicTacToe2/
│       └── VendingMachine/
```

Each design pattern folder contains:
- **`BadPractice/`** — Naive or anti-pattern implementation
- **`GoodPractice/`** — Clean implementation using the design pattern

---

## 🧩 Design Patterns Covered

### 🔵 Behavioral Patterns
These patterns focus on communication and responsibility between objects.

| Pattern | Description |
|---|---|
| Chain of Responsibility | Pass requests along a chain of handlers |
| Command | Encapsulate a request as an object |
| Iterator | Sequentially access elements of a collection |
| Mediator | Define an object that encapsulates how objects interact |
| Memento | Capture and restore an object's state |
| Observer | Notify dependents of state changes (pub/sub) |
| State | Alter an object's behavior when its state changes |
| Strategy | Define a family of interchangeable algorithms |
| Template Method | Define the skeleton of an algorithm |
| Visitor | Separate an algorithm from the objects it operates on |

### 🟢 Creational Patterns
These patterns deal with object creation mechanisms.

| Pattern | Description |
|---|---|
| Abstract Factory | Create families of related objects |
| Builder | Construct complex objects step by step |
| Factory Method | Let subclasses decide which class to instantiate |
| Prototype | Clone objects instead of creating new ones |
| Singleton | Ensure a class has only one instance |

### 🟡 Structural Patterns
These patterns deal with object composition and structure.

| Pattern | Description |
|---|---|
| Adapter | Convert one interface to another |
| Bridge | Separate abstraction from implementation |
| Composite | Treat individual and composite objects uniformly |
| Decorator | Add responsibilities to objects dynamically |
| Facade | Provide a simplified interface to a subsystem |
| Flyweight | Share common state among many fine-grained objects |
| Proxy | Provide a surrogate for another object |

---

## 🎯 Interview Problems / Real-World Systems

Practice-oriented LLD problems commonly asked in system design interviews.

| Problem | Key Concepts |
|---|---|
| ATM Machine | State pattern, Transaction handling |
| Car Rental System | Booking, Availability, Pricing |
| Chess | OOP modeling, Rules engine |
| Design Cache | LRU/LFU eviction, Thread safety |
| Dining Philosophers | Concurrency, Deadlock avoidance |
| Elevator | Scheduling, State machine |
| File System | Composite pattern, Permissions |
| Inventory Management System | CRUD, Order lifecycle |
| Logging System | Singleton, Chain of responsibility |
| Movie Ticket Booking System | Seats, Booking, Payment |
| Multi-Thread Web Crawler | Concurrency, BFS/DFS |
| Parking Lot | Slots, Vehicle types, Ticketing |
| Snake And Food Game | Game loop, OOP |
| SplitWise | Expense splitting, Debt simplification |
| TicTacToe | Board, Players, Win detection |
| Vending Machine | State machine, Inventory |

---

## 🚀 Getting Started

### Prerequisites
- Java 11+
- IntelliJ IDEA (recommended) or any Java IDE

### Clone the Repository
```bash
git clone https://github.com/<your-username>/LowLevelDesign.git
cd LowLevelDesign
```

### Running a Pattern
Navigate to the relevant package and run the `Main.java` (or equivalent entry point) inside either `BadPractice` or `GoodPractice`.

---

## 📚 Learning Approach

Each pattern is structured for comparison learning:

1. **Read the `BadPractice` implementation** — Understand the problem with naive code (tight coupling, no extensibility, code duplication).
2. **Read the `GoodPractice` implementation** — See how applying the design pattern solves the problem cleanly.
3. **Refer to the interview problems** — Apply your knowledge to end-to-end system design scenarios.

---

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Add missing patterns or improve existing implementations
- Add new interview problems
- Fix bugs or improve documentation

Please fork the repository, create a feature branch, and open a pull request.

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

> ⭐ If you find this repository helpful, please consider giving it a star!
