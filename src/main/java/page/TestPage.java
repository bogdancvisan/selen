package page;

public class TestPage
{
    public static String sportPage = "http://www.sportsdirect.com";
    public static String sportMensPageXp = ".//*[@id='topMenu']/ul/li[1]/a";
    public static String sportBootsPageXp = ".//*[@id[contains(.,'_HtmlModule_lblContent')]]/div/div/div[2]/div[1]/ul[1]/li[8]/a";
    public static String sportAdvertId = "advertPopup";
    public static String sportCloseAdvertXp = ".//*[@id='advertPopup']/div/div/div[1]/button";
    public static String sportFirstBootXp = ".//*[@id='navlist']/li[1]/div/div[2]/div[1]/div[1]/a/span[1]";
    public static String sportSecondBootXp = ".//*[@id='navlist']/li[7]/div/div[2]/div[1]/div[1]/a/span[1]";
    public static String sportAddToBagXp = ".//*[@id[contains(.,'_sAddToBagWrapper')]]";
    public static String sportAcceptCookiesId = "inputAcceptCookies";
    public static String sportViewBagId = "aViewBag";
    public static String sportUpdateBagXp = ".//*[@id[contains(.,'ViewBasket_BasketDetails_lbtnUpdateQtyAndVariants')]]";
    public static String sportTotalMoneyFirstCSS = ".AspNet-GridView-Normal > td:nth-child(6) > span:nth-child(2)";
    public static String sportTotalMoneySecondCSS = ".AspNet-GridView-Alternate > td:nth-child(6) > span:nth-child(2)";    
    public static String sportTotalProductsId = "TotalValue";
    public static String sportAddButtonXpath = ".//*[@id[contains(.,'ViewBasket_BasketDetails_gvBasketDetails')]]/table/tbody/tr/td[4]/div/a[2]";
    public static String sportColorList = ".//*[@id[contains(.,'_ulColourImages')]]/li";//aria-checked="true"
    public static String sportColorListA = ".//*[@id[contains(.,'_ulColourImages')]]/li/a";
    public static String sportSizeList = ".//*[@id[contains(.,'_ulSizes')]]/li/a"; //class="tooltip sizeButtonli"
}