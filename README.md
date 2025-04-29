# Nike Website Testing Project

### Course: Software Testing – CEN 4072  
**Team Members:** Gabriel Correa, Lazaro Loureiro, Catalina Perez, Christopher Smith  

---

## 📝 Project Overview

This project focuses on automated testing of the [Nike website](https://www.nike.com) using **Selenium**, **TestNG**, and **Maven**. The goal was to simulate real-world user interactions and verify the functionality of key areas of the site to ensure a seamless and bug-free user experience.

---

## 🎯 Objectives

- Validate navigation and link accuracy across the site.
- Test key features like:
  - Product search and filtering
  - Customizing products (e.g., shoes)
  - Gift card flow
  - Find-a-store functionality
  - Language and region settings
  - Home and membership pages

---

## 🧰 Tools & Technologies

| Tool         | Purpose                                         |
|--------------|--------------------------------------------------|
| Selenium     | Simulate user interactions on the web           |
| TestNG       | Design, organize, and prioritize test execution |
| Maven        | Project management and dependency handling      |
| IntelliJ     | Integrated development environment              |
| Google Chrome| Browser used for execution                      |

---

## 🧪 Test Strategy

### Types of Testing Performed:
- **Unit Testing:** Validated individual components, such as footer links or search buttons.
- **Integration Testing:** Verified workflows like customizing a gift card or searching for stores.
- **System Testing:** Full end-to-end user journeys, simulating real browser usage.

### Execution:
- Tests were grouped into 8 main classes (e.g., `NikeShoe`, `NikeSearch`, `FooterLinks`, etc.).
- TestNG was used to prioritize and organize test cases using `testng.xml`.
- Screenshots and console output captured test results.
- Failures were usually caused by website updates (e.g., changed XPaths), and were corrected accordingly.

---


## 📈 Value & Impact

Testing high-traffic features of nike.com ensures:

- Higher uptime and usability
- Faster feedback and bug detection
- Reliable user experience after website changes
- Reduced manual testing time

Common issues identified/prevented:
- Broken or misdirected links
- Malfunctioning product customization tools
- Non-functioning location searches or region settings

---

## 📸 Sample Results

- All test executions produced detailed console output and screenshots.
- A final `emailable-report.html` from TestNG summarizes all test results.

---

## 📎 Repository & Code Access

**GitHub Repository:**  
[https://github.com/Gabs0403/software-testing-project](https://github.com/Gabs0403/software-testing-project)

You can also find:
- Source/test code (`.java` files)
- `pom.xml` and `testng.xml`
- Screenshots and generated reports

