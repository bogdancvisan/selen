package steps;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.TestPage;



public class TestSteps
{

    WebDriver fox = new FirefoxDriver();
    WebElement element;
    WebDriverWait wait = new WebDriverWait(fox, 10);
    Actions act = new Actions(fox);

    public void openPage()
    {
        fox.get(TestPage.sportPage);
        fox.manage().window().maximize();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(TestSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TestPage.sportAdvertId)));
        waitAndClickCSS(TestPage.sportCloseCss);
        waitAndClickId(TestPage.sportAcceptCookiesId);

        fox.navigate().to("/mens/mens-boots");
    }

    public void selectProduct()
    {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(TestSteps.class.getName()).log(Level.SEVERE, null, ex);
        }

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TestPage.sportAdvertId)));
        waitAndClickCSS(TestPage.sportCloseCss);

        waitAndClickXPath(TestPage.sportFirstBootXp);

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TestPage.sportAdvertId)));
        waitAndClickCSS(TestPage.sportCloseCss);

        selectElementInList(TestPage.sportColorList, TestPage.sportColorListA, "aria-checked", "true");

        selectElementInList(TestPage.sportSizeList, "class", "");
        waitAndClickId(TestPage.sportAddToBagId);

        fox.navigate().back();

        waitAndClickXPath(TestPage.sportSecondBootXp);

        selectElementInList(TestPage.sportColorList, TestPage.sportColorListA, "aria-checked", "true");

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(TestSteps.class.getName()).log(Level.SEVERE, null, ex);
        }

        selectElementInList(TestPage.sportSizeList, "class", "");
        waitAndClickId(TestPage.sportAddToBagId);

        waitAndClickId(TestPage.sportViewBagId);
        waitAndClickXPath(TestPage.sportAddButtonXpath);
        waitAndClickId(TestPage.sportUpdateBagId);

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(TestSteps.class.getName()).log(Level.SEVERE, null, ex);
        }

        String getTextFirst, getTextSecond, getTotal;
        getTextFirst = fox.findElement(By.cssSelector(TestPage.sportTotalMoneyFirstCSS)).getText();
        getTextSecond = fox.findElement(By.cssSelector(TestPage.sportTotalMoneySecondCSS)).getText();
        getTotal = fox.findElement(By.id(TestPage.sportTotalProductsId)).getText();
        System.out.println(getTextFirst + " " + getTextSecond + " " + getTotal);

        String getFirstValue, getSecondValue, getTotalValue;
        getFirstValue = getTextFirst.replaceAll("\\W", "");
        getSecondValue = getTextSecond.replaceAll("\\W", "");
        getTotalValue = getTotal.replaceAll("\\W", "");

        int priceA = Integer.parseInt(getFirstValue);
        int priceB = Integer.parseInt(getSecondValue);
        int priceTotal = Integer.parseInt(getTotalValue);

        if (priceA + priceB == priceTotal) {
            System.out.println(priceTotal + " The SUM is correct!");
        }

    }

    public void closeTest()
    {
        fox.quit();
    }

    public void selectElementInList(String locator, String attribute, String value)
    {
        List<WebElement> list = fox.findElements(By.xpath(locator));
        int count = list.size();

        for (int i = 0; i < count; i++) {
            WebElement getList = list.get(i);
            String color = getList.getAttribute(attribute);
            if (color.equalsIgnoreCase(value)) {
                getList.click();
                break;
            }
        }
    }

    public void selectElementInList(String locator, String locator2, String attribute, String value)
    {
        List<WebElement> list = fox.findElements(By.xpath(locator));
        List<WebElement> list2 = fox.findElements(By.xpath(locator2));
        int count = list.size();

        for (int i = 0; i < count; i++) {
            WebElement getList = list.get(i);
            WebElement getUList = list2.get(i);
            String color = getList.getAttribute(attribute);
            if (color.equalsIgnoreCase(value)) {
                getUList.click();
                break;
            }
        }
    }

    private void waitAndClickId(String locator)
    {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        fox.findElement(By.id(locator)).click();
    }

    private void waitAndClickCSS(String locator)
    {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        fox.findElement(By.cssSelector(locator)).click();
    }

    private void waitAndClickXPath(String locator)
    {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        fox.findElement(By.xpath(locator)).click();
    }
}
