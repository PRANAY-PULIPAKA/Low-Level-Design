# Liskov Substitution Principle (LSP) - Complete SDE interview guide

## What is the Liskov Substitution Principle?

**In simple terms:** Objects of a superclass should be replaceable with objects of its subclasses without breaking the application.

If you have a method that expects a Parent class object, you should be able to pass a Child class object to it, and the method should still behave correctly without knowing the difference.

    The Golden Rule: A subclass should extend the behavior of a parent class, not completely change it or strip it away.

### ❌ The Bad Way: Violating LSP

### The Classic Violation: The Rectangle-Square Problem

>The most common trap occurs when trying to model mathematical relationships directly into mutable object hierarchies. Mathematically, a square *is* a rectangle, but in mutable code, this abstraction completely breaks down.

### The Violating Code

```java
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public int getArea() { return this.width * this.height; }
}

class Square extends Rectangle {
    // To preserve square properties, we force both dimensions to change together
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}
```

### Why does this break LSP?

Imagine a client method that tests or uses the Rectangle class:

````java
public void verifyArea(Rectangle rect) {
    rect.setWidth(5);
    rect.setHeight(10);
    
    // If rect is a Rectangle: 5 * 10 = 50. Correct!
    // If rect is a Square: The height setter changed the width to 10 too! 10 * 10 = 100.
    assert rect.getArea() == 50 : "LSP Violation: Area is not 50!";
}
````
## How to Fix It (The LSP Compliant Way)

The problem above happened because a Square isn't truly substitutable for a Rectangle when mutating width and height independently. We need to abstract the common behavior or separate them.

>A great approach is to introduce a common interface or abstract class (Polygon or Shape) that only guarantees what both can actually do: calculate area.

````java
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() { return width * height; }
}

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getArea() { return side * side; }
}
````

## 🎯 Top Interview Follow-Up Questions (and How to Answer)

### Q1: What is the Liskov Substitution Principle in your own words, and why is it important?

> **Answer**: LSP states that a subclass should be perfectly substitutable for its parent class without breaking client code execution or altering application correctness. It is vital because it preserves polymorphism. When a subclass violates LSP, it strips away client trust in the base interface. This forces developers to introduce conditional checks (instanceof), which degrades maintainability.

### Q2: Give me an example of an LSP violation other than the Rectangle/Square problem.

> **Answer**: Consider a banking system with a base class Account providing a withdraw(double amount) method. A developer introduces a FixedDepositAccount subclass. Because fixed deposits lock funds until maturity, the developer overrides withdraw to throw an UnsupportedOperationException.

**The Fix:** Separate the capabilities. Extract a WithdrawalAccount hierarchy or introduce a capability interface like Withdrawable.

### Q3: How does violating LSP directly lead to breaking the Open-Closed Principle (OCP)?

> **Answer:** When a subclass violates LSP, client components cannot blindly rely on the abstraction contract. They must explicitly verify the concrete class types using runtime evaluation blocks (if/else checks combined with instanceof).
> 
>Whenever a new violating subclass is integrated, you must manually open and update those client checking-blocks. This directly violates OCP, which dictates that modules must be open for extension but closed for modification.

### Q4: If a Java class implements an Interface but overrides a method with an empty body, is that an LSP violation?

> **Answer**: It depends on the interface's design contract. If the interface specifies that the method must execute an action or alter a component's state, leaving it blank weakens the postconditions and violates LSP. However, if the interface method is explicitly documented as an optional lifecycle callback or hook (such as event listeners where doing nothing is a valid alternative), it complies with LSP.