package testCase;/*
 *
 * 功能描述: <br>
 * 〈后台登录测试用例$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/27$ 15:48$
 */

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Assertion;
import util.caseUtil;
import util.uiLibraryUtil;
import util.webDriverBase;

public class loginCase extends webDriverBase {

    @Test(dataProvider = "datas")
    public void login(String Username,String Password,String ErrorMsg) throws InterruptedException {
        driver.get("http://47.56.97.57:8098/#/login");
        uiLibraryUtil.getElementByKeyword("登录页面","用户名").sendKeys(Username);
        uiLibraryUtil.getElementByKeyword("登录页面","密码").sendKeys(Password);
        driver.findElement(By.cssSelector("button[type='button']")).click();
        //String resResult = driver.getCurrentUrl();
        Assertion.assertUrlContains(ErrorMsg);
        // 页面刷新
        driver.navigate().refresh();
    }

    @DataProvider
    public Object[][] datas(){
        String[] cellNames = {"Username","Password","ErrorMsg"};
        Object[][] datas = caseUtil.getCaseData("0",cellNames);
        return datas;
    }

    @Test(dataProvider = "data")
    public void loginTrue(String Username,String Password,String ErrorMsg) {
        driver.get("http://47.56.97.57:8098/#/login");
        uiLibraryUtil.getElementByKeyword("登录页面","用户名").sendKeys(Username);
        uiLibraryUtil.getElementByKeyword("登录页面","密码").sendKeys(Password);
        driver.findElement(By.cssSelector("button[type='button']")).click();
        Assertion.assertUrlContains(ErrorMsg);
    }

    @DataProvider
    public Object[][] data(){
        String[] cellNames = {"Username","Password","ErrorMsg"};
        Object[][] datas = caseUtil.getCaseData("1",cellNames);
        return datas;
    }
}
