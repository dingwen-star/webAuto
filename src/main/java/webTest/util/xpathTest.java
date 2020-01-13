package webTest.util;/*
 *
 * 功能描述: <br>
 * 〈xpath用法$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/23$ 14:25$
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import util.webDriverBase;

import java.util.List;

public class xpathTest extends webDriverBase {
    @Test
    public void test() throws InterruptedException {
        WebDriver.Window window = driver.manage().window();
        window.maximize();
        driver.get("http://47.56.97.57:8098/#/login");
        driver.findElement(By.xpath("//input[@placeholder='账号']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[contains(@placeholder,'密码')]")).sendKeys("123456");
        //System.out.println(driver.findElement(By.xpath("//*[contains(text(),'邮箱验证')]")).getTagName());;
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'用户管理')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'用户列表')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'用户列表')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'展开')]")).click();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.xpath("//input[@placeholder='请选择']")));
        List<WebElement> options = select.getOptions();
        for (WebElement option:options
             ) {
            System.out.println(option);
        }
    }
}
