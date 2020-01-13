package util;/*
 *
 * 功能描述: <br>
 * 〈xml文件解析类$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/28$ 16:08$
 */

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.page;
import pojo.pageElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class uiLibraryUtil extends webDriverBase {
    public static List<page> pageList = new ArrayList<page>();
    static {
        loadPages(propertiesUtil.getPath("xmlPath"));
    }

    public static void loadPages(String uiLibraryPath){
        //解析xml,获取解析器
        SAXReader reader = new SAXReader();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(new File(uiLibraryPath));
            //拿到Document对象
            Document document = reader.read(inputStream);
            // 获取根元素
            Element root = document.getRootElement();
            List<Element> pageElements = root.elements("Page");
            for (Element pagesElement:pageElements) {
                //拿到页面关键字keyword
                String pageKeyword = pagesElement.attributeValue("page");
                //获取<page>元素的子元素，保存到uiElement集合
                List<Element> uiElements = pagesElement.elements("UIElement");
                //将每个<pageElement>元素解析封装成pageElement类型对象，在保存到uiElementList中
                List<pageElement> uiElementList = new ArrayList<pageElement>();
                //循环处理每一个Element元素
                for (Element uiElement:uiElements) {
                    String keyword = uiElement.attributeValue("keyword");
                    String by = uiElement.attributeValue("by");
                    String value = uiElement.attributeValue("value");
                    pageElement uiEle = new pageElement(keyword,value,by);
                    uiElementList.add(uiEle);
                }
                page pages = new page(pageKeyword,uiElementList);
                pageList.add(pages);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static WebElement getElementByKeyword(String pageKeyWord,String uiElementKey){
        WebElement element = null;
        for (page pages:pageList){
            //根据页面关键字过滤找到页面对象
            if (pageKeyWord.equals(pages.getKeywrod())){
                List<pageElement> uiElements = pages.getElements();
                for (pageElement uiElement:uiElements){
                    if (uiElementKey.equals(uiElement.getKey())){
                        //获取元素选择器信息
                        String by  = uiElement.getBy();
                        String value = uiElement.getValue();
                        element = getVisibleElement(by,value);
                    }
                }
            }
        }
        return element;
    }

    private static WebElement getVisibleElement(String by, String value) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        By locator = null;
        WebElement element = null;
        if("id".equalsIgnoreCase(by)){
            locator = By.id(value);
        }else if("name".equalsIgnoreCase(by)){
            locator = By.name(value);
        }else if("className".equalsIgnoreCase(by)){
            locator = By.className(value);
        }else if("linkText".equalsIgnoreCase(by)){
            locator = By.linkText(value);
        }else if("partialLinkText".equalsIgnoreCase(by)){
            locator = By.partialLinkText(value);
        }else if("cssSelector".equalsIgnoreCase(by)){
            locator = By.cssSelector(value);
        }else if("xpath".equalsIgnoreCase(by)){
            locator = By.xpath(value);
        }else {
            System.out.println("暂不支持该类型：【"+by+"】");
        }
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e){
            if (e instanceof TimeoutException){
                System.out.println("根据by:【"+by+"】，value：【"+value+"】定位元素超时");
            }else {
                e.printStackTrace();
            }
        }
        return element;
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
