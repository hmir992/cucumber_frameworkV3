## Getting Started

The Assessment Application is a simple web application with the login page and fuel cost calculator: based on levels of fuel in the tank, it calculates the cost of the fuel that needs to be charged to the customer.

## Prerequisites

Make sure you have the following installed:
- npm(v10.x)
- node(v22.x)
- typescript(v5.x)


## Installation
To install the Assessment Application, follow these steps:

1) Clone the repository
2) Navigate to the project directory: cd qa-assessment-app
3) Install dependencies: `npm clean-install`

## Running the Application
To run the Assessment Application, use the following command: `npm run dev`

The application will be accessible at http://localhost:3000.

To login, use the following credentials:
- username: guest
- password: guestpassword

## Running Tests
To run all tests call `npm test`

## Challenge Tasks
### Feature
As a product owner I would like to have an easy and lightweight app that calculates amount of an additional charge per customers car return.\
Cars should return with the full tank.\
Discrepancy allowed is 5%.  

e.g. Car returns with "4/8" of the tank, telematics report 44% - we need to charge customer X amount.

e.g. Car returns with "8/8" of the tank, telematics report 95% - we will not charge the customer.

### Tasks
### 1.1 Read the app documentation (this readme), and based on "Feature" section check:

Is the story & feature well-defined?\
What questions would you ask to make it clearer, if any?

### 1.2 Use the app in exploratory fashion and check:

Does the app work as designed?\
Are there any bugs?

If so write a bug report on them

### 1.3 Check unit test execution and coverage

Do you find these unit tests done right?\
How would you improve the existing tests?\
Some tests are failing; can you identify why?\
Would you suggest to your team to add more, or write them in a different way?\
What other tools or processes would you suggest?

### Note
Please consider this an open-ended exercise with no right or wrong answer. Reach out if you have any questions or issues. 