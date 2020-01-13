package webTest.util;/*
 *
 * 功能描述: <br>
 * 〈定位元素是否可见$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/25$ 14:59$
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.webDriverBase;

public class webDriverElement extends webDriverBase {
    public static WebElement getElementWhilePageIsReady(By by){
        //确认页面元素是否完全加载
        WebDriverWait wait = new WebDriverWait(driver,30);
        try {
            String jsToBeExecute = "return document.readyState == 'complete'";
            boolean isReady = (Boolean) wait.until(ExpectedConditions.jsReturnsValue(jsToBeExecute));
            if (isReady){
                return getPresenceElement(by);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static WebElement getPresenceElement(By by){
        //获取页面元素
        WebDriverWait wait = new WebDriverWait(driver,30);
        try {
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return webElement;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
