# ParaBank UI Automation Framework

A robust, maintainable, and scalable test automation framework built for **ParaBank** using **Java 17**, **Selenium WebDriver 4.28.1**, and **TestNG**. Designed following the **Page Object Model (POM)** design pattern with explicit wait strategies for dynamic AngularJS components.

---

## 🛠️ Tech Stack & Dependencies

* **Language:** Java 17
* **Automation Library:** Selenium WebDriver `4.28.1`
* **Test Framework:** TestNG `7.10.2`
* **Build Tool:** Apache Maven
* **Driver Management:** Selenium Manager / WebDriverManager
* **Design Pattern:** Page Object Model (POM)

---

## 📁 Project Structure

```text
Parabank-automation
 ├── src
 │    └── test
 │         ├── java
 │         │    └── com
 │         │         └── parabank
 │         │              ├── base
 │         │              │    └── DriverFactory.java       # WebDriver initialization & management
 │         │              ├── listeners
 │         │              │    └── TestListener.java        # Execution logs & failure handling
 │         │              ├── pages
 │         │              │    ├── BasePage.java            # Wrapper methods for waits & JS execution
 │         │              │    ├── DashboardPage.java       # User overview & session verification
 │         │              │    ├── LoginPage.java           # Authentication flows
 │         │              │    ├── OpenAccountPage.java     # New account creation
 │         │              │    ├── TransferFundsPage.java   # Internal account fund transfers
 │         │              │    ├── BillPayPage.java         # Bill payment form submissions
 │         │              │    ├── FindTransactionsPage.java# Transaction search & dynamic data lookup
 │         │              │    └── UpdateProfilePage.java   # Profile management & Angular state syncing
 │         │              └── tests
 │         │                   ├── AccountActivityTest.java
 │         │                   ├── AccountsOverviewTest.java
 │         │                   ├── BillPayTest.java
 │         │                   ├── DashboardTest.java
 │         │                   ├── DepositTest.java
 │         │                   ├── OpenAccountTest.java
 │         │                   ├── TransferFundsTest.java
 │         │                   └── UpdateProfileTest.java
 │         └── resources
 │              └── config.properties                       # Test environment configuration
 ├── pom.xml                                                # Maven build & plugin setup
 └── README.md
