<%@page language="java" pageEncoding="UTF-8"%>
<!-- 导入Struts 2的标签库 -->
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>注册界面</title>
</head>
<script type="text/javascript">
//注册提交
function regist()
{
     document.forms[0].action = "RegistSubmit.action";
     document.forms[0].submit();
}
</script>
  <body>
    <s:form action="RegistSubmit">
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
           <td>用户ID:</td>
           <td><input type="text" name="user_id" maxlength="20"></td>
        </tr>
         <tr>
           <td>用户名称:</td>
           <td><input type="text" name="user_name" maxlength="20"></td>
        </tr>
        <tr>
           <td>邮箱:</td>
           <td><input type="text" name="email" maxlength="200"></td>
        </tr>
        <tr>
           <td>密码:</td>
           <td><input type="password" name="user_pwd"></td>
        </tr>
        <tr>
           <td>确认密码:</td>
           <td><input type="password" name="user_confirm_pwd"></td>
        </tr>
        <tr>
        <td>
            <input type="submit" value="注册"/>
        </td>
         <td>
            <input type="reset" value="重置"/>
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
