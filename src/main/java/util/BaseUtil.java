package util;/*
 *
 * 功能描述: <br>
 * 〈测试数据处理类$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/30$ 15:56$
 */

import java.lang.reflect.Method;
import java.util.List;

public class BaseUtil {
    public static Object[][] assembleDatas(List<Object> objects,String[] cellNames,Class clazz){
        //创建二维数组指定数组长度
        Object[][] datas = new Object[objects.size()][cellNames.length];
        for (int i = 0; i < objects.size(); i++) {
            //取出每一数据
            Object element = objects.get(i);
            //取出每一行的每一列数据
            for (int j = 0; j <cellNames.length ; j++) {
                // 获取反射方法
                String callName = cellNames[j];
                String methodName = "get"+callName;
                String value = null;
                try {
                    Method method = clazz.getMethod(methodName);
                    value = (String) method.invoke(element);
                    datas[i][j] = value;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return datas;
    }
}
