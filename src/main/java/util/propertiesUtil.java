package util;/*
 *
 * 功能描述: <br>
 * 〈properties文件解析$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/28$ 16:13$
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class propertiesUtil {
    public static Properties properties = new Properties();
    static {
        try {
            InputStream inputStream = new FileInputStream(new File("src/main/resources/config.properties"));
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPath(String key){
        return properties.getProperty(key);
    }

}
