package pojo;/*
 *
 * 功能描述: <br>
 * 〈$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/31$ 18:46$
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import webTest.util.webDriverElement;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static File saveScreenshot(String filePath) {
        File screenshot = null;
        if (webDriverElement.driver instanceof FirefoxDriver){
            //向下强制转换，变为子类型
            FirefoxDriver firefoxDriver = (FirefoxDriver) webDriverElement.driver;
            screenshot = firefoxDriver.getScreenshotAs(OutputType.FILE);
        }else if (webDriverElement.driver instanceof ChromeDriver){
            //向下强制转换，变为子类型
            ChromeDriver ChromeDriver = (ChromeDriver) webDriverElement.driver;
            screenshot = ChromeDriver.getScreenshotAs(OutputType.FILE);
        }
        File destFile = new File(filePath);
        try {
            //拷贝文件截图到指定文件
            FileUtils.copyFile(screenshot,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFile;
    }
}
