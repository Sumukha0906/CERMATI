Framework: TestNG
Programming language: Java


Framework Structure:

Under src/test/java:
		- BaseClass: This package has the classes The driver setup based on the browser we need.
			 : BaseBrowser.java: This class is the first that will be run as it has @BeforeMethod and @AfterMethod used 
				which will initiate the browser and Then terminate the browser at end, this class will be extended 
				to all the other classes as Parent class. 
		- PageObject: This package contains all the page class [using Page Object Model]
		- TestCase: This contains the test case classs.

Under src/test/resource : 
		- ConfigFiles: Contains the base properties file 
			: Base.properties: This is where we pase the browser we want to run and URL details and all.
		- Locators: Contains the locators for respective page classes.
		



Approach:
	* Used Mavin dependencies for the Project setup [pom.xml] file, have added all the dependencies required.
	* The Baseclass will be the parent class to all the class.
	* In the TestCase we have created the first case Access a Product via category after applying multiple filters. 
	* And the Report will be generated at the end .
	* As per Requirement the values are Hard coded.
	* The test case are Executed using the XML file.
	* Same approach is followed for the second testCase.
	
	
	
	
To Run the Project: 
	* As I have used mavin dependencies, head to pom.xml and built the project by Saving the pom.xml file [Should be connected to internet] with all the
	dependencies added, [Make sure JDK is installed on the computer].While importing any classes import from TestNG package.
	* Head the XML file
		Run the XML file "TestCase.xml"
	* Report is generated at test-output/index.html for HTML Report
	
	
	
	

	