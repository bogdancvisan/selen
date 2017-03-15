package mainPack;

import steps.TestSteps;

public class MainTest {
        
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/gecko/geckodriver.exe");
        TestSteps test = new TestSteps();
        test.user_Navigate_to_LogIn_Page();
        test.selectProduct();
        test.closeTest();        
    }
}