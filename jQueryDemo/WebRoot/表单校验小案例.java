<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>我的jquery表单校验页面</title>
    
	<style type="text/css">
		p{
			text-align: center;font-size:24px;
		}
		table{
			margin: 0 auto;border: 0;
		}
		table tr{
			height:40px;border:0;
		}
		table tr td{
			padding:0 14px;border:1px solid #999
		}
		.error{
			color:red
		}
	</style>
	<script type="text/javascript" src="../js/jquery-3.2.0.js"></script>
	<script type="text/javascript" src="./js/jquery.validate.js"></script>
	<script type="text/javascript">
		$(function(){
			/*  ************自定义身份证的校验规则IDCardValidate************ */
			$.validator.addMethod("IDCardValidate",function(value,element,params){
				//value:也就是value的值
				//element:被校验的元素对象
				//params：校验规则的参数
				if(value.length!=params[0]&&value.length!=params[1]){
					return false;
				}
				return true;
			});
			$.validator.addMethod("IDCardNumValidate",function(value,element,params){
				if(params && value.trim().length == 15){
					var reg = /^[0-9]{15}$/;
					var val = reg.test(value);
					return val;
				}
				return true;
			});
			
			$.validator.addMethod("IDCardNumAndCharValidate",function(value,element,params){
				if(params && value.trim().length == 18){
					var reg = /^[0-9]{18}|[0-9]{17}X$/;
					var val = reg.test(value);
					return val;
				}
				return true;
			});
			
			/*  ************自定义身份证的校验规则IDCardValidate************ */
			
			$("#empForm").validate({
				rules:{
					realname:"required",
					username:{
						required:true,
						minlength:5,
						maxlength:8
					},
					psw:{
						required:true,
						/*方法一
						minlength:6,
						maxlength:12 
						*/
						/* 方法二 */
						rangelength:[6,12],
					},
					psw2:{
						required:true,
						minlength:6,
						maxlength:12,
						equalTo:"#psw",
					},
					gender:"required",
					age:{
						required:true,
						range:[18,80],
					},
					edu:{
						required:true,
					},
					birthday:{
						required:true,
						dateISO:true
					},
					checkbox1:{
						required:true,
					},
					email:{
						email:true
					},
					cart:{
						required:true,
						IDCardValidate:[15,18],
						IDCardNumValidate:true,
						IDCardNumAndCharValidate:true
					}
				},
				messages:{
					realname:"姓名不能为空",
					username:{
						required:"用户名不能为空",
						minlength:"用户名长度最少5位",
						maxlength:"用户名长度最多8位"
					},
					psw:{
						required:"密码不能为空",
						/*方法一 
						minlength:"密码长度最少6位",
						maxlength:"密码长度最多12位" 
						*/
						/* 方法二 */
						rangelength:"密码长度6~12位之间",
					},
					psw2:{
						required:"请输入密码",
						minlength:"密码长度最少6位",
						maxlength:"密码长度最多12位" ,
						equalTo:"两次密码不一致",
					},
					age:{
						required:"必须输入年龄",
						range:"年龄在18~80之间",
					},
					edu:{
						required:"学历不能为空",
					},
					birthday:{
						required:"请输入出生日期",
						dateISO:"格式不正确"
					},
					email:{
						email:"格式不正确"
					},
					cart:{
						required:"请输入身份证信息",
						IDCardValidate:"身份证必须是15位或18位",
						IDCardNumValidate:"15位必须都是数字",
						IDCardNumAndCharValidate:"18位都是数字或者末尾是X"
					}
				}
			});
		});
	</script>
</head>
<body>
	<p>员工信息录入</p>
	<form name="empForm" id="empForm" method="post" action="test.html">
		<table border=1>
			<tr>
				<td>真实姓名(不能为空 ,没有其他要求)</td>
				<td><input type="text" id="realname" name="realname" />
				</td>
			</tr>
			<tr>
				<td>登录名(登录名不能为空,长度应该在5-8之间,可以包含中文字符(一个汉字算一个字符)):</td>
				<td><input type="text" id="username" name="username" /></td>
			</tr>
			<tr> 
		      <td>密码(不能为空,长度6-12字符或数字,不能包含中文字符):</td>
		      <td><input type="password" id="psw"  name="psw" /></td>
		    </tr>
		    <tr> 
		      <td>重复密码密码(不能为空,长度6-12字符或数字,不能包含中文字符):</td>
		      <td><input type="password" id="psw2" name="psw2" /></td>
		    </tr>
		    <tr>
				<td>性别(必选其一)</td>
				<td>
				    <input  type="radio" id="gender_male" value="m" name="gender"/>&nbsp;男&nbsp;&nbsp;
				    <input  type="radio" id="gender_female" value="f" name="gender"/>&nbsp;女
				    <label class="error" for="gender" style="display:none">请选择性别</label>
				</td>
			</tr>
			<tr>
				<td>年龄(必填26-50):</td>
				<td><input type="text" id="age" name="age" /></td>
			</tr>
		    <tr> 
		      <td>你的学历:</td>
		      <td> <select name="edu" id="edu">
			          <option value="">－请选择你的学历－</option>
			          <option value="a">专科</option>
			          <option value="b">本科</option>
			          <option value="c">研究生</option>
			          <option value="e">硕士</option>
			          <option value="d">博士</option>
		          </select>
			  </td>
		    </tr>
			<tr> 
              <td>出生日期(1982/09/21):</td>
               <td><input type="text" id="birthday"  name="birthday" value="" /></td>
            </tr>
		    <tr> 
		      <td>兴趣爱好:</td>
		      <td colspan="2"> 
			      <input type="checkbox" name="checkbox1" id="qq1"/>&nbsp;乒乓球 &nbsp;
		          <input type="checkbox" name="checkbox1" id="qq2" value="1" />&nbsp;羽毛球 &nbsp;
		          <input type="checkbox" name="checkbox1" id="qq3" value="2" />&nbsp;上网 &nbsp;
		          <input type="checkbox" name="checkbox1" id="qq4" value="3" />&nbsp;旅游 &nbsp;
		          <input type="checkbox" name="checkbox1" id="qq5" value="4" />&nbsp;购物 &nbsp;
			  	  <label class="error" for="checkbox1" style="display: none">必须选一个</label>
			  </td>
		    </tr>
			<tr> 
			      <td align="left">电子邮箱:</td>
			      <td><input type="text" id="email" name="email" /></td>
			  </tr>
			<tr> 
				<td align="left">身份证(15-18):</td>
				<td><input type="text" id="cart" name="cart" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"  name="firstname"  id="firstname" value="保存"></td>
			</tr>
		</table>
	</form>
</body>