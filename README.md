# Calculator Automation with Selenium

This project demonstrates the automation of a calculator's basic operations (like addition) using **Selenium WebDriver** in **Java**. It simulates a user interaction with the GUI, performing arithmetic operations in two different modes: **Decimal** and **Binary**.

## Project Overview

The project automates the following steps:

1. **Select Decimal Mode:** Performs addition of 1 and 2 in Decimal mode.
2. **Select Binary Mode:** Performs addition of 1 and 1 in Binary mode.
3. **Verification:** Verifies the results after each operation, ensuring the correctness of the calculations.

The program tests both the **Decimal** and **Binary** modes of the calculator, and it uses the **XPath** selectors to interact with the GUI elements (buttons, radio buttons, text field) on the calculator.

## Dependencies

- Java 8 or higher
- Selenium WebDriver
- WebDriver for the specific browser (e.g., ChromeDriver, GeckoDriver for Firefox)

## Setup

1. Clone the repository:
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```

2. Download the appropriate **WebDriver** for your browser:
    - [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)
    - [GeckoDriver](https://github.com/mozilla/geckodriver/releases)

3. Set up the WebDriver executable in your system's path or specify the path directly in the code.

4. Import the required libraries (e.g., Selenium) to your project, either by using a dependency manager like Maven or Gradle, or by adding the JARs manually.

    **Maven example:**
    ```xml
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
    ```

## How to Run the Project

1. Compile and run the `TestGUI` class in your IDE or from the command line:
    ```bash
    javac TestGUI.java
    java TestGUI
    ```

2. The program will:
    - Launch a browser window.
    - Perform the decimal addition operation (1 + 2).
    - Switch to binary mode and perform the binary addition (1 + 1).
    - Verify the results and print whether the test was successful or not in the console.

## Expected Output

- For Decimal Mode:
    ```
    Test successful! Result: 3
    ```
- For Binary Mode:
    ```
    Test successful! Result: 10
    ```

If any discrepancy occurs, the console will print:
    ```
    Test failed! Expected result: [expected], Received result: [received]
    ```

## Closing the Browser

Once the tests are complete, the browser will automatically close with the `driver.quit()` statement in the code.

## Contributing

Feel free to fork the repository, raise issues, or contribute with pull requests. If you have suggestions for improving the automation or additional tests to add, feel free to open an issue.
