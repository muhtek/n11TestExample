package Abstract;

import org.apache.log4j.MDC;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Assert.*;

import javax.xml.bind.Element;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainFunctions extends Abstract {

    public String versionInformation = "";

    //Find Element ByLinkText
    public WebElement linktext(String Element) {
        WebDriverWait driverWait = new WebDriverWait(driver, waitDuration);
        WebElement elem = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(Element)));
        return elem;
    }
    //Find Element ByXpath
    public static WebElement xpath(String Element) {
        WebDriverWait driverWait = new WebDriverWait(driver, waitDuration);
        WebElement elem = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Element)));
        return elem;
    }

    //Find Element ById
    public WebElement id(String Element) {
        WebDriverWait driverWait = new WebDriverWait(driver, waitDuration);
        WebElement elem = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(Element)));
        return elem;
    }
    //Find Element ByCss
    public WebElement css(String Element) {
        WebDriverWait driverWait = new WebDriverWait(driver, waitDuration);
        WebElement elem = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Element)));
        return elem;
    }

    //Find Element ByClass
    public WebElement classname(String Element) {
        WebDriverWait driverWait = new WebDriverWait(driver, waitDuration);
        WebElement elem = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className(Element)));
        return elem;
    }
    //Find Element ByName
    public WebElement name(String Element) {
        WebDriverWait driverWait = new WebDriverWait(driver, waitDuration);
        WebElement elem = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(Element)));
        return elem;
    }


    public static void assertText(String value,String text){
      Assert.assertEquals(xpath(value).getText(), text);
    }
    public static void assertCss(String value,String attribute,String text){
      Assert.assertEquals(xpath(value).getCssValue(attribute), text);
    }
    public static void assertAttribute(String value,String attribute,String text){
       Assert.assertEquals(xpath(value).getAttribute(attribute), text);
    }


}
