package util;/*
 *
 * 功能描述: <br>
 * 〈excel 解析类$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/27$ 10:30$
 */

import org.apache.poi.ss.usermodel.*;
import pojo.loginElement;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class excelUtil {
    public static List<loginElement> loginElements = new ArrayList<loginElement>();
    static {
        List<loginElement> list = laod("src/main/resources/logincase.xls","登录", loginElement.class);
        loginElements.addAll(list);
//        for (loginElement data:loginElements) {
////            System.out.println(data);
//        }
    }
    public static<T> List<T> laod(String excelPath,String sheetName,Class<T> calzz){
        List<T> list = new ArrayList<T>();
        try {
            // 创建workbook对象
            Workbook workbook = WorkbookFactory.create(new File(excelPath));
            // 创建sheet对象
            Sheet sheet = workbook.getSheet(sheetName);
            //  获取第一行信息
            Row titleRow =sheet.getRow(0);
            // 获取表单最后一列列索引
            int lastCellNum = titleRow.getLastCellNum();
            //循环取出每一列的字段名，保存到数组fields,String[lastCellNum]表示数字长度
            String[] fields = new String[lastCellNum];
            for (int i = 0; i < lastCellNum; i++) {
                //根据索引取出对应的列名
                Cell cell = titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                //设置列的类型为字符串
                cell.setCellType(CellType.STRING);
                //获取每列对应的值
                String title = cell.getStringCellValue();
                //截取字符串，获取列名名称
                title = title.substring(0,title.indexOf("("));
                // 数据保存至数组fields
                fields[i] = title;
            }
            // 获取最后一行的索引,注意索引从零开始
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 1; i <= lastRowNum ; i++) {
                // 创建Object对象
                T obj = calzz.newInstance();
                // 拿到每一行数据
                Row data =sheet.getRow(i);
                //判断是否为空行
                if (data == null || isEmptyRow(data)){
                    continue;
                }

                for (int j = 0; j < lastCellNum; j++) {
                    // 获取每一行的所有值
                    Cell cell = data.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    // 获取每一列的值
                    String value = cell.getStringCellValue();
                    // 获取反射方法名称
                    String methodName = "set"+fields[j];
                    // 获取要反射的方法对象
                    Method method = calzz.getMethod(methodName,String.class);
                    // 完成反射调用
                    method.invoke(obj,value);
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
    }

    public static boolean isEmptyRow(Row dataRow){
        // 判断是否为空行
        // 获取最后一列列索引
        int lastCellNum = dataRow.getLastCellNum();
        for (int i = 0; i < lastCellNum; i++) {
            Cell cell =dataRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            String value = cell.getStringCellValue();
            if (value != null&&value.trim().length()>0){
                return false;
            }
        }
        return true;
    }

}
