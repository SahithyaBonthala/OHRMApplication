Feature: OrangeHRM Application Functionalities Testing

Scenario: Validating OrangeHRM Application LogIn Page

Given User should open Browser in the System 
When User enters OrangeHRM Application URL Address 
Then User Should be Navigated to OrangeHRM Application LogIn WebPage
Then User Should Close the OrangeHRM Application along with the browser 

Scenario: Validating OrangeHRM Application LogIn Functionality

Given User should open Browser in the System 
When User enters OrangeHRM Application URL Address
Then User Should be Navigated to OrangeHRM Application LogIn WebPage
Then User should enter Username and password and click on logIn button
Then User should be navigated to OrangeHRM Application Homepage
Then User should click on Welcome Admin and click on logOut button
Then User Should be Navigated to OrangeHRM Application LogIn WebPage
Then User Should Close the OrangeHRM Application along with the browser 