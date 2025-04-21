# Demo Webshop Test Automation Framework

A structured UI test automation framework using Java, Selenium, Cucumber, and Allure Reporting.

## ✅ Project Structure

```
├── src
│   └── test
│       ├── java
│       │   └── com.demowebshop
│       │       ├── api
│       │       └── ui
│       │           ├── actions            # Logic classes with annotated @Step methods
│       │           ├── pages              # Page Objects
│       │           ├── runners            # Test runners
│       │           ├── stepdefinitions    # Cucumber Step Definitions
│       │           │   └── authSteps      # Grouped BDD steps for Auth scenarios
│       │           └── utils              # Utility classes
│       └── resources
│           ├── features
│           │   ├── api                   # .feature files for API
│           │   └── ui                    # .feature files for UI
│           ├── allure.properties
│           ├── cucumber.properties
│           ├── junit-platform.properties
│           └── logback.xml
└── pom.xml
```

## 🧠 Naming Pattern for Steps and Logs

- Method: `@Step("<action or assertion in present continuous>")`
- Log message: Concise, but expressive

Example:
```java
@Step("Entering email {0} and password {1}")
public void enterCredentials(String email, String password) {
    logger.info("Entering email: {} and password: {}", email, password);
    AllureLogger.attachLog("Credentials entered: " + email + "/" + password);
    loginPage.enterLoginCredentials(email, password, true);
}
```

**Common @Step patterns:**
- Navigating to...
- Clicking [element] button
- Entering [field]...
- Validating [error/success/message]...
- Selecting [dropdown/item]...
- Submitting form
- Uploading file

## 🛠️ Logging Rules

- Use `logger.info()` for console logs (logback)
- Use `AllureLogger.attachLog()` for Allure report steps
- Logs must be added **only inside logic/action classes**, not step defs or pages
- Avoid duplicate logs unless important for both console and report

## 📦 Dependencies

        <!-- Cucumber -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.11.1</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.11.1</version>
            <scope>test</scope>
        </dependency>

        <!-- JUnit 4 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
            <scope>test</scope>
        </dependency>

        <!-- WebDriverManager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.9.2</version>
        </dependency>

        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.31.0</version>
        </dependency>
        
        <!-- Rest-Assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.5.0</version>
            <scope>test</scope>
        </dependency>

        <!-- Allure -->
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-cucumber7-jvm</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-junit4</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Logback -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.5.16</version>
        </dependency>

## 🚀 How to Run

**To execute tests and generate Allure results:**
```bash
mvn clean test
```

**To serve Allure report locally:**
```bash
mvn allure:serve
```

**To generate static report:**
```bash
mvn allure:report
```

## ⏭️ To Do Next

- [ ] Move UI hooks to `@Before`/`@After` with screenshot logic and driver closure
- [ ] Add a logger for errors and steps to the common utility
- [ ] Create a template for feature files and test cases
- [ ] Add parameterization for tests via `examples`
- [ ] Write the first batch of UI tests: login, login with error, empty fields, incorrect email
- [ ] Separate positive/negative scenarios in tests
- [ ] Connect CI (GitHub Actions, Jenkins)

---

