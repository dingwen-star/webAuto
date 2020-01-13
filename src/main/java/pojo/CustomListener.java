package pojo;/*
 *
 * 功能描述: <br>
 * 〈$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/31$ 18:09$
 */

import javafx.scene.input.DataFormat;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CustomListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
        String baseDir = "target"+File.separator+"surefire-reports";
        String screenshotDir = "screenshot";
        //获取测试上下文--》获取当前正在执行的test测试集--》获取测试集name值
        String testNameDir = tr.getTestContext().getCurrentXmlTest().getName();
        //获取当前时间
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateDir = sdf.format(now);
        String fileName = now.getTime() + ".jpg";
        //文件路径
        String filePath = baseDir+ File.separator+screenshotDir+File.separator+testNameDir +File.separator
                +dateDir+File.separator+fileName;
        ScreenshotUtil.saveScreenshot(filePath);
        File file = ScreenshotUtil.saveScreenshot(filePath);
        String toBeReplaced = tr.getTestContext().getCurrentXmlTest().getParameter("HTMLReporterFile");
        String replacement = tr.getTestContext().getCurrentXmlTest().getParameter("host");
        String imgString = getImgString(toBeReplaced,replacement,file);
        //写到reporter日志空
        Reporter.log(imgString);
    }

    private String getImgString(String toBeReplaced,String replacement,File file) {
        //绝对路径
        String absolutPath = file.getAbsolutePath();
        //替换访问路径
        String accessPath = absolutPath.replace(toBeReplaced,replacement);
        String img = "<img src='"+accessPath+"'height='100' width='100'><a href='"+accessPath+"' target='_blank'>点击查看大图</a></img>";
        return  img;
    }

    public static void main(String[] args) {

    }
}
