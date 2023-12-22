# nopCommerce Demo Store Automated Testing

Automated tests for nopCommerce demo store using JAVA and SELENIUM. 

## Test Scenarios

1. **Combined Signup, Login, and Checkout**
   - See `BrowserTest.java` in the root directory.
   - Combines user signup, login, and checkout scenarios.
   - Utilizes data from `Book1.xlsx` for Data-Driven Testing.

2. **Invalid Signup Attempt**
   - Navigate to [nopCommerce demo store](#)
   - Attempt to register with invalid information.

3. **Existing User Login and Checkout**
   - Navigate to [nopCommerce demo store](#)
   - Log in with existing user credentials and complete a purchase.

4. **Verify Cart Functionality**
   - Navigate to [nopCommerce demo store](#)
   - Add, modify, and remove products from the shopping cart.

## Continuous Integration
Integrated with GitHub Action for automated testing on each push or pull request.

## Test Reports
Test reports generated after each run can be found in the `/reports` directory.

## Test Automation Approach
The automation tests follow the Page Object Model (POM) and Data-Driven Testing (DDT) for better maintainability and readability.

## Project Structure
- `BrowserTest.java`: Combines user signup, login, and checkout scenarios. Uses data from `Book1.xlsx` for DDT.
- `pages/`: Directory containing pages as per the Page Object Model.
- `Book1.xlsx`: Data file used for Data-Driven Testing.

## Getting Started

1. Clone the repository: `git clone https://github.com/RahulKumar208/Web_UI_Test_Automation`
2. Install dependencies: `Java & Selenium Dependencies`
3. Run tests: `Ready to Run`

## Contributing
1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make changes, commit, and push.
4. Open a pull request.

Feel free to report issues or suggest improvements!
