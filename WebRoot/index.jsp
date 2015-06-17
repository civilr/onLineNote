<%@page language="java" pageEncoding="UTF-8"%>
<!-- 导入Struts 2的标签库 -->
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>登陆界面</title>
</head>
<script type="text/javascript">
function Login()
{
     document.forms[0].action = "Login.action";
     document.forms[0].submit();
}
</script>
  <body>
    <s:form action="Login">
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <table align="center">
        <tr>
           <td>用户:</td>
           <td><input type="text" name="userid"></td>
        </tr>
        <tr>
           <td>密码:</td>
           <td><input type="password" name="password"></td>
        </tr>
        <tr>
        <td>
            <input type="submit" value="登录"/>
        </td>
        </tr>
        <tr>
            <td colspan="2" >
               <font color="red">
                <s:property value="errormsg"/>
                </font>
            </td>
        </tr>
    </table>
    </s:form>
  </body>
</html>
