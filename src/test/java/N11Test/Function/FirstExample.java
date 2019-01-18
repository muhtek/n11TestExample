package N11Test.Function;


import Resources.Resources;
import org.junit.Assert;
import org.junit.Test;
import Abstract.MainFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstExample extends Resources {
    @Test
    public void firstExample() throws InterruptedException {

        Assert.assertEquals("n11.com - Alışverişin Uğurlu Adresi", driver.getTitle());
        System.out.println("Site başlığı kontrol edildi");
        classname(girisYap).click();
        id(username).sendKeys(eposta);
        id(pass).sendKeys(sifre);
        id(login).click();
        String b = xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/a[1]").getText();
        Assert.assertEquals("Hesabım", b);
        System.out.println("Hesabım girişi kontrol edildi");
        id("searchData").sendKeys("Iphone");
        classname("searchBtn").click();
        String b2 = xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/section[2]/div[1]/div[1]/h1[1]").getText();
        Assert.assertEquals("Iphone", b2);
        System.out.println("Aratılan ile sonuç eşdeğer");
        xpath(sayfa2).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.n11.com/arama?q=Iphone&pg=2");
        System.out.println("Açılmak istenen 2. Sayfanın açıldığı teyit edildi.");
        xpath(secim3).click();
        xpath(favoriEkle).click();
        xpath(istekListem).click();
        String URL2 = driver.getCurrentUrl();
        Assert.assertEquals(URL2, "https://www.n11.com/hesabim/istek-listelerim");
        System.out.println("Favorilerim Sayfasının açıldığı teyit edildi.");
        xpath(secimTikla).click();
        xpath(secimSil).click();
        xpath(popUpKapa).click();
        Thread.sleep(2000);
        xpath(istekListem).click();
        String b3 = xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[3]/ul[1]/li[1]/div[1]/a[1]/h4[1]").getText();
        Assert.assertEquals("Favorilerim (0)", b3);
        System.out.println("Favorilerim Sayfasın da ki tek kayıt silindi.");

        Actions action = new Actions(driver);
        WebElement element = xpath(menu);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        xpath(logOut).click();

   /* String baySon1= xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/input[1]").getText();
    String bay1=xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/section[2]/div[1]/div[1]/h1[1]").getAttribute("").toString();
    org.testng.Assert.assertEquals(baySon1,bay1);*/


    }

}
