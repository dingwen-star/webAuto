package webTest.util;/*
 *
 * 功能描述: <br>
 * 〈浏览器窗口切换$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/24$ 10:52$
 */

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import util.webDriverBase;

import java.util.Set;

public class switchWindow extends webDriverBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Thread.sleep(1000);
        driver.findElement(By.linkText("新闻")).click();
        Thread.sleep(2000);
        //获取该页面handle
        String handleA = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[contains(text(),'年终回眸，中国外交赢得“满堂红”')]")).click();
       // webDriverElement.getElementWhilePageIsReady(By.linkText("十篇讲话，一个声音")).click();
        Thread.sleep(2000);
        String handleB = driver.getWindowHandle();//获取该页面handle
        Set<String> handles = driver.getWindowHandles();
        for (String handle:handles
             ) {
            System.out.println(handle);
            if (handle.equals(handleA)){
                continue;
            }
            //切换窗口
            driver.switchTo().window(handleB);
            //获取网页标题
            System.out.println(driver.getTitle());
        }
    }
}
