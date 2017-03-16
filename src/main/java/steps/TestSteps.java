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

    public void firstPage() {
        fox.manage().deleteAllCookies();
        fox.get(TestPage.sportPage);
        fox.manage().window().maximize();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestSteps.class.getName()).log(Level.SEVERE, null, ex);
        }
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TestPage.sportAdvertId)));
        waitAndClickXPath(TestPage.sportCloseAdvertXp);
        waitAndClickId(TestPage.sportAcceptCookiesId);

    }

    public void secondPage() {
        waitAndClickXPath(TestPage.sportMensPageXp);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TestPage.sportAdvertId)));
        waitAndClickXPath(TestPage.sportCloseAdvertXp);
        waitAndClickXPath(TestPage.sportBootsPageXp);

        selectElementInList(TestPage.sportFirstBootXp, TestPage.sportSecondBootXp, "innerHTML", "Karrimor");
        selectElementInList(TestPage.sportColorList, TestPage.sportColorListA, "aria-checked", "true");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TestPage.sportSizeOne)));

        selectElementInList(TestPage.sportSizeList, "class", "");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TestPage.sportAddToBagXp)));
        waitAndClickXPath(TestPage.sportAddToBagXp);

        fox.navigate().back();

        selectElementInList(TestPage.sportFirstBootXp, TestPage.sportSecondBootXp, "innerHTML", "Firetrap");
        selectElementInList(TestPage.sportColorList, TestPage.sportColorListA, "aria-checked", "true");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TestPage.sportSizeOne)));

        selectElementInList(TestPage.sportSizeList, "class", "");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TestPage.sportAddToBagXp)));
        waitAndClickXPath(TestPage.sportAddToBagXp);

    }

    public void thirdPage() {

        waitAndClickId(TestPage.sportViewBagId);
        waitAndClickXPath(TestPage.sportAddButtonXpath);
        waitAndClickXPath(TestPage.sportUpdateBagXp);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
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

        fox.quit();
    }

    private void selectElementInList(String locator, String attribute, String value) {
        List<WebElement> list = fox.findElements(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
        int count = list.size();

        for (int i = 0; i < count; i++) {
            WebElement getList = list.get(i);
            String attribValue = getList.getAttribute(attribute);
            if (attribValue.equalsIgnoreCase(value)) {
                wait.until(ExpectedConditions.visibilityOf(getList));
                getList.click();
                break;
            }
        }
    }

    private void selectElementInList(String locator, String locator2, String attribute, String value) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
        List<WebElement> list = fox.findElements(By.xpath(locator));
        List<WebElement> list2 = fox.findElements(By.xpath(locator2));
        int count = list.size();

        for (int i = 0; i < count; i++) {
            WebElement getList = list.get(i);
            WebElement getUList = list2.get(i);
            String attribValue = getList.getAttribute(attribute);
            if (attribValue.equalsIgnoreCase(value)) {
                wait.until(ExpectedConditions.visibilityOf(getList));
                getUList.click();
                break;
            }
        }
    }

    private void waitAndClickId(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
        fox.findElement(By.id(locator)).click();
    }

    private void waitAndClickXPath(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        fox.findElement(By.xpath(locator)).click();
    }
}
