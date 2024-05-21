Feature: OrangeHRM Application Functionalities Testing

Background:
Given User Should Open Browser in the System 

@Smoke
Scenario: Validating OrangeHRM Application LogIn Page

When User enters OrangeHRM Application URL Address 
Then User should Be navigated to OrangeHRM Application LogIn WebPage
Then User should close the orangeHRM Application along with the browser

@ReTesting
Scenario: Validating OrangeHRM Application LogIn Functionality

Given User Should Open Browser in the System
When User enters OrangeHRM Application URL Address
Then User should Be navigated to OrangeHRM Application LogIn WebPage
Then User Should enter userName and password and then click on login button
Then User Should be navigated to OrangeHRM Application Home Page
Then User Should click on WelCome Admin and click on Logout
Then User should Be navigated to OrangeHRM Application LogIn WebPage
Then User should close the orangeHRM Application along with the browser

@Smoke @RegressionTesting
Scenario Outline: Validating OrangHRM Application LogIn Functioanlity with TestData

#Given User should open Browser in the System
When User enters OrangeHRM Application URL Address
Then User should Be navigated to OrangeHRM Application LogIn WebPage
Then User should enter "<userName>" and "<password>" and click on login button
Then User Should be navigated to OrangeHRM Application Home Page
Then User Should click on WelCome Admin and click on Logout
Then User should Be navigated to OrangeHRM Application LogIn WebPage
#Then User should close the OrangeHRM Application along with the browser
Examples:
|  userName     |  password    |
|  Sahithya     |  Sahithy@24  |
|  Sahithya     |  WebDriver   |
|  Cucumber     |  Sahithy@24  |
|  srini        |  Q@Trainer7  |
