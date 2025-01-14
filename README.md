# AmaysimQA

### *Project Structure*
src/test/java/AmaysimQA: Contains the Java source code for test automation.

### *Execution*
1. Clone Git project
git clone https://github.com/JhoyPadlan/AmaysimQA.git

2. Run the script.
   #### *mvn test -Dtest=AmaysimQA*

##### *Note: You should be at the root directory to run this command. Make sure to replace <TestScript> with the name of the automation script you want to run.*

### *Test Reports*

* Reports: After test execution, Reports are generated and stored in the allure-results directory. To generate this report temporarily, run this code below.

  #### *allure serve ./allure-results*

##### *Note: You should be at the allure-results directory to run this command.*

### *Dependencies*
* Java 22 or latest
* Maven
* NodeJs
* Chrome Web Driver

##### *Note: Update Chrome webdriver path in test script.*

 * Users\\^\\^\\ChromeDriver\\chromedriver-win64\\chromedriver.exe
