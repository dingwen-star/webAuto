package pojo;/*
 *
 * 功能描述: <br>
 * 〈后台登录 对象$〉
 * @Param: $
 * @description: $
 * @Author: DingDing
 * @Date: 2019/12/27$ 10:42$
 */

public class loginElement {
    private String isNegative;
    private String des;
    private String password;
    private String username;
    private String errorMsg;
    private String responseResult;

    public String getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(String isNegative) {
        this.isNegative = isNegative;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(String responseResult) {
        this.responseResult = responseResult;
    }

    @Override
    public String toString() {
        return "isNegative =【"+isNegative+"】"+" des =【"+des+"】username = 【"+username+"】password = 【"+password+"】errorMsg =【"
                +errorMsg+"】responseResult =【"+responseResult+"】";
    }
}
