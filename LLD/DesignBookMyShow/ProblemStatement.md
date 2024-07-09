## Problem Definition

The movie ticket booking system enables customers to book tickets for their favorite movies. This system maintains information about all cinemas located in various cities, along with details of the halls within each cinema. The system's database stores a wide array of movies, each of which can have multiple shows scheduled in a specific cinema. Customers can search for and select a movie they wish to watch. The system then presents a seating layout that clearly indicates both booked and available seats, allowing customers to reserve the available ones.

### Actors:
1. **Primary:**
    - Customer
2. **Secondary:**
    - Admin
    - Ticket Agent

### Use Cases:

#### Customer:
1. **Search for movie** (can filter by `movie title`, `genre`, `sort by release date`, `language`)
2. **Create, view, cancel booking**
3. **Book a seat**
4. **Pay for booking**

#### Ticket Agent:
1. **Search for movie** (can filter by `movie title`, `genre`, `sort by release date`, `language`)
2. **Create, view, cancel booking on behalf of customer**
3. **Book a seat**

#### Admin:
1. **Add show**
2. **Modify show**
3. **Remove show**
4. **Add movie**
5. **Search movie**
6. **Delete movie**

### Relationships in Use Case Diagrams:

1. **Association:**
    - **Denoted by:** solid line
    - **Definition:** Relationship between and among actor(s) and use case(s)

2. **Generalization:**
    - **Denoted by:** solid line with arrow on only one side (toward the parent use case)
    - **Definition:** Parent and child use cases, where child inherits parent's use case

3. **Include:**
    - **Denoted by:** dotted line with arrow on one side towards main use case, write `<<include>>` on arrow
    - **Definition:** Must be included with main use case

4. **Exclude:**
    - **Denoted by:** dotted line with arrow on one side towards main use case, write `<<exclude>>` on arrow
    - **Definition:** May be included with main use case


### Design Patterns Used

1. **Singleton Pattern:**
   - Ensures only one instance of important classes like `BookingManager`, `PaymentProcessor`, and `NotificationService`.

2. **Strategy Pattern:**
   - Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Used for different payment methods and notification methods.

3. **Observer Pattern:**
   - Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. Used for notifications.


### Folder structure
```
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── moviebooking
│   │               ├── controller
│   │               │   ├── AdminController.java
│   │               │   ├── BookingController.java
│   │               │   └── UserController.java
│   │               ├── model
│   │               │   ├── Booking.java
│   │               │   ├── Cinema.java
│   │               │   ├── Hall.java
│   │               │   ├── Movie.java
│   │               │   ├── Seat.java
│   │               │   ├── Show.java
│   │               │   └── User.java
│   │               ├── repository
│   │               │   ├── BookingRepository.java
│   │               │   ├── CinemaRepository.java
│   │               │   ├── MovieRepository.java
│   │               │   └── UserRepository.java
│   │               ├── service
│   │               │   ├── BookingService.java
│   │               │   ├── NotificationService.java
│   │               │   ├── PaymentService.java
│   │               │   └── UserService.java
│   │               ├── strategy
│   │               │   └── payment
│   │               │       ├── CreditCardPayment.java
│   │               │       ├── PaymentStrategy.java
│   │               │       └── PayPalPayment.java
│   │               ├── observer
│   │                   └── notification
│   │                       ├── EmailNotification.java
│   │                       ├── NotificationObserver.java
│   │                       └── SMSNotification.java
```