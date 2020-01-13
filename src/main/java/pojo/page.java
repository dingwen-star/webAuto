package pojo;/*
 *
 * 功能描述: <br>
 * 〈page 页面元素$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/28$ 14:12$
 */

import java.util.List;

public class page {
    public page() {
    }

    public page(String keywrod, List<pageElement> elements) {
        this.keywrod = keywrod;
        this.elements = elements;
    }

    public String getKeywrod() {
        return keywrod;
    }

    public void setKeywrod(String keywrod) {
        this.keywrod = keywrod;
    }

    public List<pageElement> getElements() {
        return elements;
    }

    public void setElements(List<pageElement> elements) {
        this.elements = elements;
    }

    private String keywrod;
    private List<pageElement> elements;

}
