# Selenium Automation Framework

## 1. Project Overview

This project is a Selenium WebDriver automation framework developed using Java, TestNG and Maven.

The framework automates functional scenarios for the SauceDemo application and follows the Page Object Model (POM) design pattern.

The framework is designed with reusable components, configuration management, test-data management, logging, screenshot capture and CI/CD integration using GitHub Actions.

---

## 2. Technology Stack

- Java 17
- Selenium WebDriver 4.35.0
- TestNG 7.11.0
- Maven
- Apache POI
- Log4j2
- Extent Reports
- Git & GitHub
- GitHub Actions

---

## 3. Framework Structure

```text
saucedemo-automation
│
├── .github
│   └── workflows
│       └── maven-test.yml
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── Baseclass.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │   ├── Login.java
│   │   │   │   └── Products.java
│   │   │   │
│   │   │   └── utils
│   │   │       ├── Configreader.java
│   │   │       ├── Excelreader.java
│   │   │       ├── Testlistener.java
│   │   │       └── Waitutils.java
│   │   │
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       ├── java
│       │   └── test
│       │       ├── Logintest.java
│       │       └── productstest.java
│       │
│       └── resources
│           ├── log4j2.xml
│           └── test data.xlsx
│
├── pom.xml
├── testng.xml
└── testing regression.xml