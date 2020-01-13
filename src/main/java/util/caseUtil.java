package util;/*
 *
 * 功能描述: <br>
 * 〈测试用例数据处理$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/27$ 14:17$
 */

import pojo.loginElement;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class caseUtil {
    public static List<loginElement> loginElements = new ArrayList<loginElement>();
    static {
        List list = excelUtil.laod("src/main/resources/logincase.xls","登录", loginElement.class);
        loginElements.addAll(list);
    }

    public static Object[][] getCaseData(String isNegative,String[] cellNames){
        //创建 clazz 对象
        Class clazz = loginElement.class;
        // 创建loginElement集合
        List<Object> loginElementList = new ArrayList<Object>();
        //遍历loginElements集合，取出测试用例
        for (loginElement element:loginElements) {
            //判断用例类型
            if (isNegative.equals(element.getIsNegative())){
                //把符合需求的用例重新添加到集合
                loginElementList.add(element);
            }
        }
        return BaseUtil.assembleDatas(loginElementList,cellNames,clazz);
    }


    public static void main(String[] args) {
        String[] cellNames = {"IsNegative","Des","Username","Password","ErrorMsg"};
        Object[][] datas = getCaseData("0",cellNames);
        for (Object[] objects:datas) {
            for (Object object:objects) {
                System.out.print("["+object+"]");
            }
            System.out.println("");
        }
    }
}
