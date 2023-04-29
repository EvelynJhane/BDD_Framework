package Pages;

import Web.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import Helpers.Misc;
import Web.Driver;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.logging.Handler;

public class WebCommands {

    public WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    public WebElement getElementWithScroll(By locator) {
        WebElement element = null;
        for (int i=1 ; i <= 20 ; i++) {
            try {
                element = Driver.getDriver().findElement(locator);
                break;
            } catch (NoSuchElementException e) {
                scrollDown(100);
            }
        }
        return element;
    }

    public WebElement getElementWithWait(By locator) {
        Wait fWait = new FluentWait(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element is not found within 30 seconds");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }

    public List<WebElement> getElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    public void type(By locator, String data) {
        getElementWithWait(locator).sendKeys(data);
        Misc.sleep(2);
    }

    public void type(WebElement element, String data) {
        element.sendKeys(data);
        Misc.sleep(2);
    }

    public void clickThis(By locator) {
        getElementWithWait(locator).click();
        Misc.sleep(2);
    }

    public void clickThis(WebElement element) {
        element.click();
        Misc.sleep(2);
    }

    public void selectFromDropdown(By locator, String dataToSelect) {
        WebElement dropdownElement = getElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(dataToSelect);
        Misc.sleep(2);
    }

    public String getHandle() {
        return Driver.getDriver().getWindowHandle();
    }

    public Set<String> getAllHandles() {
        return Driver.getDriver().getWindowHandles();
    }

    public void switchToHandle(String handle) {
        Driver.getDriver().switchTo().window(handle);
    }

    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();     // Casting
        js.executeScript("scrollBy(0,"+pixels+");");
        Misc.sleep(2);
    }

    public void scrollUp(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();     // Casting
        js.executeScript("scrollBy(0,-"+pixels+");");
        Misc.sleep(2);
    }

    public void moveMouseToElement(By locator) {
        WebElement element = getElement(locator);
        Actions act = new Actions(Driver.getDriver());
        act.moveToElement(element);
    }

    public void moveMouseToElement(WebElement element) {
        Actions act = new Actions(Driver.getDriver());
        act.moveToElement(element);
    }

    public void clickOneOfElementsUsingText(By locator, String text) {
        List<WebElement> allElements = getElements(locator);
        for (WebElement element : allElements) {
            String elementText = element.getText();
            if (elementText.equalsIgnoreCase(text)) {
                clickThis(element);
                Misc.sleep(2);
                break;
            }
        }
    }

    public void clickOneOfElementsUsingAttributeValue(By locator, String attributeName, String attributeValue) {
        List<WebElement> allElements = getElements(locator);
        for (WebElement element : allElements) {
            String attributeValueFromWeb = element.getAttribute(attributeName);
            if (attributeValueFromWeb.equalsIgnoreCase(attributeValue)) {
                clickThis(element);
                Misc.sleep(2);
                break;
            }
        }
    }

}


