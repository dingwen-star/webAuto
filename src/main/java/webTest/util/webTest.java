package webTest.util;/*
 *
 * 功能描述: <br>
 * 〈测试，元素定位$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/20$ 15:21$
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import util.webDriverBase;

public class webTest extends webDriverBase {

    @Test
    public static void test () throws InterruptedException {
//        driver.get("https://www.baidu.com/");
//        driver.findElement(By.linkText("新闻")).click();
//        Thread.sleep(2000);
//        driver.quit();
        WebDriver.Window window = driver.manage().window();
        window.maximize();
        driver.navigate().to("http://47.56.97.57:8811/#/login");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("18617121598");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Aa123456");
        driver.findElement(By.cssSelector(".el-button[type='button']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
