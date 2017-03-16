package mainPack;

import java.io.File;
import steps.TestSteps;

public class MainTest
{

    public static void main(String[] args) throws Throwable {
        File fileW = new File("src/main/resources/gecko/geckodriver.exe");
        File fileU = new File("src/main/resources/gecko/geckodriver");
        if (fileW.canExecute()) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/gecko/geckodriver.exe");
        }
        else {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/gecko/geckodriver");
        }
        TestSteps test = new TestSteps();
        test.firstPage();
        test.secondPage();
        test.thirdPage();
    }
}
