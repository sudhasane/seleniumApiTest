package com.poc.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

import static com.poc.steps.CucumberHooks.driver;

public class DriverUtils {

    @BeforeClass
    public static void chromeSetup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
    }

    public static int WAIT_FOR_10_SECS = 10;
    public static int WAIT_FOR_20_SECS = 20;
    public static int WAIT_FOR_30_SECS = 30;

    Actions action = new Actions(driver);

    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public static String getElementText(By locator) {
        return findElement(locator).getText();
    }

    public static boolean isElementDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    public static boolean isElementEnabled(By locator) {
        return findElement(locator).isEnabled();
    }

    public static void clearText(By locator) {
        findElement(locator).clear();
    }

    public static void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public static void clickOnElement(By locator) {
        findElement(locator).click();
    }

    public static void clickOnElementByIndex(By locator, int index) {
        findElements(locator).get(index).click();
    }


    public static void clickWithJavaScript(By locator) {
        WebElement element = findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void refreshPage(By locator) {
        driver.navigate().refresh();
        pageWait();
        waitForelementVisible(locator, 30);
    }
    public static void refresh(){
        driver.navigate().refresh();
        pageWait();
    }

    public static String getElementAttribute(By locator, String atrName) {
        return findElement(locator).getAttribute(atrName);
    }

    public static String getCSSValue(By locator, String atrName) {
        return findElement(locator).getCssValue(atrName);
    }

    public WebDriverWait waitForElement() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_10_SECS);
        return wait;
    }

    public static <T> ExpectedCondition<T> refreshed(final ExpectedCondition<T> condition) {
        return new ExpectedCondition<T>() {
            @Override
            public T apply(WebDriver driver) {
                try {
                    return condition.apply(driver);
                } catch (StaleElementReferenceException | UnhandledAlertException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return String.format("%s", condition);
            }
        };
    }

    private static void wait(ExpectedCondition<?> expCondition, long waitTime) {
        for (int i = 1; i < 4; i++) {
            try {
                new WebDriverWait(driver, waitTime).until(refreshed(expCondition));
                return;
            } catch (TimeoutException | UnreachableBrowserException te) {
                throw te;
            } catch (WebDriverException wde) {
                //                logWarning("Caught WebDriverException " + i + " times");
                waitForMilliSeconds(5000);
            }
        }
        throw new RuntimeException("Webdriver exception failed more than 3 times");
    }

    public static void waitForMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static ExpectedCondition<WebElement> elementVisible(final By locator) {
        return ExpectedConditions.visibilityOfElementLocated(locator);
    }

    public static void waitForelementVisible(By locator, int waitTime) {
        wait(elementVisible(locator), waitTime);
    }

    public static void waitForelementClickable(By locator, int waitTime) {
        wait(elementClickable(locator), waitTime);
    }

    public static ExpectedCondition<WebElement> elementClickable(final By locator) {
        return ExpectedConditions.elementToBeClickable(locator);
    }

    public void doKeyBoardClick(String locator) {
        action.keyDown(Keys.LEFT_CONTROL).click((driver.findElement(By.xpath(locator)))).keyUp(Keys.LEFT_CONTROL).build().perform();
    }

    public void getWindowHandle(String windowName) {
        driver.switchTo().defaultContent();
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> iterator = tabs.iterator();
        driver.switchTo().window(iterator.next());
        driver.get(windowName);
    }

    public void actionMoveToElement(By locator) {
        action.moveToElement(findElement(locator)).click();
    }

    public void actionMoveToElementHover(By locator) {
        action.moveToElement(findElement(locator)).perform();
    }

    public boolean jsExecute(By locator) {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth >0", findElement(locator));
    }

    public String getPageTitle() throws InterruptedException {
        Thread.sleep(500);
        return driver.getTitle();
    }

    public static boolean isElementPresent(By locator) {
        if (findElements(locator).size() >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void waitForTitleIsVisible(String title, int waitTime) {
        title(title);
    }

    public static void scrollElementToView(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findElement(locator));
    }

    public static ExpectedCondition<Boolean> title(String title) {
        return ExpectedConditions.titleIs(title);
    }

    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public static void declineAlert() {
        driver.switchTo().alert().dismiss();
    }

    public static String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public static Boolean isClickable(By locator) {
        String str = findElement(locator).getAttribute("class");
        if (str.equals("disabled")) {
            return true;
        } else {
            return false;
        }

    }

    public static Boolean isButtonEnabled(By locator) {
        return findElement(locator).isEnabled();
    }

    public static void scrollDownThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public static Boolean isColumnNameDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    public static void pageWait() {
        new WebDriverWait(driver, WAIT_FOR_30_SECS).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getSessionTokenFromCookie() {
        Set<Cookie> cookies = driver.manage().getCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String cookiesString = (String) js.executeScript("return document.cookie");
        cookies = parseBrowserCookies(cookiesString);
        for (Cookie st : cookies) {
            if (st.getName().equals("sessionToken")) {
                return st.getValue();
            }

        }
        return null;
    }

    public int getNumberOfelements(By locator) {
        return findElements(locator).size();
    }

    private static Set<Cookie> parseBrowserCookies(String cookiesString) {
        Set<Cookie> cookies = new HashSet<>();

        if (StringUtils.isBlank(cookiesString)) {
            return cookies;
        }
        Arrays.asList(cookiesString.split("; ")).forEach(cookie -> {
            String[] splitCookie = cookie.split("=", 2);
            cookies.add(new Cookie(splitCookie[0], splitCookie[1], "/"));
        });

        return cookies;
    }

    public void selectDropDownElement(By locator, String visibleText) {
        select(locator).selectByVisibleText(visibleText);
    }

    Select select(By locator) {
        return new Select(findElement(locator));
    }

    public static void waitForelementNotVisible(By locator, int waitTime) {
        wait(ExpectedConditions.invisibilityOfElementLocated(locator), waitTime);
    }
}
