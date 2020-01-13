package webTest.util;/*
 *
 * 功能描述: <br>
 * 〈鼠标事件$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/24$ 15:25$
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import util.webDriverBase;

import java.util.concurrent.TimeUnit;

public class actionsDermo extends webDriverBase {
    @Test
    public void test() throws InterruptedException {
        //超时等待:,页面在指定时间内未完成加载,就会抛出异常
        //driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        //隐式等待:首先去找Web元素,如果没有找到,判断时间否超超过设置的时间,如果没有超过,则再次找这个元素,直到找到元素或者时间超过设置时间。
        // 那我们就可以设定一个比较长的超时时间,但同时也不会让程序白白的等待。
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.navigate().to("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
        WebElement source = driver.findElement(By.id("treeDemo_3_span"));
        WebElement target = driver.findElement(By.id("treeDemo_7_span"));
        Actions actions = new Actions(driver);
        //把source 拖拽至target下
        actions.dragAndDrop(source, target).build().perform();
        Thread.sleep(5000);
    }
}
