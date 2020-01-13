package util;/*
 *
 * 功能描述: <br>
 * 〈l浏览器驱动工具类$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/19$ 18:32$
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import javax.rmi.CORBA.Util;
import java.util.concurrent.TimeUnit;

public class webDriverBase {
    public static WebDriver driver;
    @Parameters(value={"driverName"})
    @BeforeSuite
    public static void init(String driverName) {
        if ("firefox".equalsIgnoreCase(driverName)) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            //启动火狐浏览器
            driver = new FirefoxDriver();
        } else if ("chrome".equalsIgnoreCase(driverName)) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.out.println("请检查你所传递的浏览器名称: “" + driverName + "“");
        }
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
