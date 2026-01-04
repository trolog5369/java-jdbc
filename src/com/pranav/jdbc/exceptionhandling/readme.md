# Java Exception Handling — Day Summary

This module focuses on **understanding and applying Exception Handling in Java** through hands-on examples.
The goal was not just to know keywords, but to clearly see **how program flow changes when exceptions occur** and how Java handles them.

---

## Package Used
`com.pranav.jdbc.exceptionhandling`

This package contains multiple classes, each demonstrating a **specific exception-handling concept**.

---

## Topics Covered Today

### 1. Basic Exception Handling (try–catch)

- Demonstrated how a program crashes when an exception is not handled
- Handled `ArithmeticException` caused by division by zero
- Used `try` and `catch` to prevent abnormal termination
- Displayed exception messages using `e.getMessage()`

**Key Learning**
- Without exception handling, the JVM terminates the program
- With `try–catch`, the program continues gracefully

---

### 2. Multiple Exceptions Handling

- Showed a scenario where **multiple exceptions can occur**
    - `ArithmeticException`
    - `ArrayIndexOutOfBoundsException`
- Used **multi-catch** to handle more than one exception in a single catch block

**Key Learning**
- Java stops execution at the **first exception encountered**
- Multi-catch reduces code duplication

---

### 3. Nested try–catch Blocks

- Demonstrated **try–catch inside another try block**
- Inner exceptions are handled first
- If not handled, control moves to the outer catch block

**Key Learning**
- Nested try–catch provides fine-grained control
- Useful when different parts of code need different handling logic

---

### 4. Order of Exceptions (Important Rule)

- Demonstrated why **subclass exceptions must be caught before superclass exceptions**
- Catching `Exception` before `ArithmeticException` leads to compile-time error
- Correct order:
    - Child exception first
    - Parent exception later

**Key Learning**
- Java follows top-down matching
- Catching the superclass first makes subclass catch unreachable

---

### 5. throw Keyword (Custom Exception)

- Used `throw` to manually raise a `RuntimeException`
- Created a custom error message based on business logic (age validation)

**Key Learning**
- `throw` is used to **explicitly raise an exception**
- Helps enforce business rules
- Custom messages improve clarity

---

### 6. throws Keyword (Exception Declaration)

- Used `throws` to declare an exception in a method signature
- Shifted responsibility of handling exception to the caller

**Key Learning**
- `throws` does NOT handle the exception
- It only informs the caller that an exception may occur
- Common in API and library methods

---

## Concepts Reinforced

- Difference between **runtime crash** and **handled exception**
- Flow of execution during exceptions
- Practical use of:
    - try
    - catch
    - nested try–catch
    - throw
    - throws
- Why exception order matters
- Writing safer and predictable Java code

---

## Outcome

By the end of this session:
- I can confidently handle runtime exceptions
- I understand how Java propagates exceptions
- I can write defensive code that does not crash unexpectedly
- I can read and understand real-world Java error traces better

This forms a strong base for upcoming JDBC and backend error-handling scenarios.
