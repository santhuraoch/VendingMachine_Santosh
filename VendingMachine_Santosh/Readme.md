
# VENDING MACHINE

Development Environment
-------------------------------------------
IntelliJ IDEA 2020.2 (Ultimate Edition)
Build #IU-202.6397.94, built on July 27, 2020
Version : JavaSE-1.8

-------------------------------------------

Covered Functionalities
-------------------------------------------
* User is able to Order the Items listed on the Vending machine (As per the Given Statement)
* User is able to purchase the item in denomations if 1,5,10,25 Cents.
* User is able to get the refund by cancelling the request
* Vendor is able to reset the Vending machine upon Successful authentication(Passcode: 9999) and reset the Available quantity

Assumptions
-------------------------------------------
* Covered Scenarios based upon the assumption that any type of tests can be developed hence Junit.
* Code is written to run in Console as there is no information to run on UI.
* Tasks that vendor can perform are not clear, so developed the tests that the Vendor will be able to login and reset the Item Quantity
* Maven is used to import the libraries and build the application as there is no mention of any other tools to be used.

How to run the application
-------------------------------------------
1) Open IDE and navigate to the below path:
 Path: /VendingMachine/src/main/VendingMachine.java
2) Run application [Eg: Run 'VendingMachine.main()']
3) Program will be compiled and executed in the console, enter the inputs as per the Commands on the console.

Application Flow
-------------------------------------------
* When User executes the Program (VendingMachine.java), the User will have to choose to Enter the vending Machine Application or Exit
* When user continues with Option 'Y', then List of available Items is displayed with Price
* User will have to select the Item and Enter the denomation required for purchasing the Item
* User will be prompted to Confirm to purchase the product, if User confirms, he/she should be able to collect the item 
* User will be able to cancel the Purchase and get a refund
* Vendor will be able to reset Vending machine and reset Available Item Quantity  
  
Run the JUnit test

-------------------------------------------

Open IDE and navigate to the below path:
Path : /VendingMachine/src/test/ 
Below are the tests available <br />
            ItemCostTest.java <br />
 			ItemDetailsTest.java <br />
 			VendorTest.java <br />
 			ValidationsTest.java <br />

 * Right Click on each of Test Files to run the JUnit Tests

