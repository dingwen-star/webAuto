package util;/*
 *
 * 功能描述: <br>
 * 〈断言工具类$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/30$ 12:21$
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assertion {
    public static WebDriverWait wait = new WebDriverWait(webDriverBase.driver,1);
    // 判断当前页面的Url
    public static void assertUrlContains(String urlcontains){
        boolean isDirectedToLogin = true;
        try {
            // 显示等待
            wait.until(ExpectedConditions.urlContains(urlcontains));
        }catch (Exception e){
            isDirectedToLogin = false;
        }
        Assert.assertTrue(isDirectedToLogin);
    }

    public static void assertTextPresentInElement(WebElement element, String text){
        //断言文本值出现在页面的指定元素
        boolean textToBePresentInElement = true;
        try{
            wait.until(ExpectedConditions.textToBePresentInElement(element,text));
      }catch (Exception e){
            textToBePresentInElement = false;
        }
        Assert.assertTrue(textToBePresentInElement);
    }
}

