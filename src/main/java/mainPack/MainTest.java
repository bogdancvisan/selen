package mainPack;

import steps.TestSteps;

public class MainTest {
        
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/gecko/geckodriver.exe");
        TestSteps test = new TestSteps();
        test.openPage();
        test.selectProduct();
        test.closeTest();        
    }

}
