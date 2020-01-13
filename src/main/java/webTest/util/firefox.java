package webTest.util;/*
 *
 * 功能描述: <br>
 * 〈火狐浏览器驱动$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/19$ 18:28$
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firefox {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        //启动火狐浏览器
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("6666");
    }
}
