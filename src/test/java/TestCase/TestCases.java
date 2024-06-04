package TestCase;


import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseBrowser;
import PageObject.FilterPage;
import PageObject.HomePage;

public class TestCases extends BaseBrowser{

	@Test
	public static void scenario1() throws IOException, InterruptedException {
		
		
			HomePage.homePageSenero1();
			FilterPage.filter();
		
	}
	@Test
	public static void scenario2() throws IOException {
		
		
		HomePage.homePageSenerio2();
			
		
	}
	

}


