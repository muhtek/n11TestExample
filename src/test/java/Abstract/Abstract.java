package Abstract;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.junit.Before;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;



import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Abstract {

    public Logger log = LogManager.getLogger(getClass().getName());
    public static WebDriver driver;
    public String browserName = System.getProperty("browserName");
    public String deviceName = System.getProperty("deviceName");
    public final Properties configProp = new Properties();
    public InputStream inputStream;
    public String baseUrl ="https://www.n11.com/";
    public static int waitDuration = 20;
    private int count = 0;
    private static int maxTry = 3;
    public static String failedMessage;


    @Before
    public void setUp()throws Exception {
        if (browserName == "chrome") {
            driver.manage().window().maximize();
            driver.get(baseUrl);
            MDC.put("BrowserName", "Chrome");
        } else if (browserName == "responsive") {
            try {
                Map<String, String> mobileEmulation = new HashMap<String, String>();
                mobileEmulation.put("deviceName", deviceName);
                Map<String, Object> chromeOptions = new HashMap<String, Object>();
                chromeOptions.put("mobileEmulation", mobileEmulation);
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                driver.manage().window().maximize();
                driver.get(baseUrl);
                MDC.put("BrowserName", "Responsive");
                MDC.put("DeviceName", deviceName);
                // inputStream = getClass().getClassLoader().getResourceAsStream("responsiveElement.properties");
                //configProp.load(inputStream)
                //new InputStreamReader(inputStream, "UTF-8");
            } catch (NoClassDefFoundError e) {
                System.out.println(e.getMessage());
            }
        } else {
            driver = new ChromeDriver();
            // driver = new RemoteWebDriver(new URL("http://10.10.0.56:4444/wd/hub"), DesiredCapabilities.firefox());
            driver.manage().window().maximize();
            driver.get(baseUrl);
            MDC.put("BrowserName", "Chrome");
        }

    }


    @AfterClass
    public static void cleanUp() {
        if (driver != null) {
            //driver.close();
           // driver.quit();
        }
    }



}

