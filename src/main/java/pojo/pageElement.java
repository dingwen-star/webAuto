package pojo;/*
 *
 * 功能描述: <br>
 * 〈页面元素类$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/28$ 14:14$
 */

public class pageElement {
    public pageElement() {
    }

    public pageElement(String key, String value, String by) {
        this.key = key;
        this.value = value;
        this.by = by;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    private String key;
    private String value;
    private String by;
}
