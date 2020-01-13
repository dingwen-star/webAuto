package webTest.util;/*
 *
 * 功能描述: <br>
 * 〈谷歌浏览器驱动$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/19$ 18:27$
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chrome {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("66666");
    }
}
