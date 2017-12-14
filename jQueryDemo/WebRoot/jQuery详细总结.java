
一、jQuery的简介
	1、jquery概述
		jquery是一个优秀的javascript的轻量级框架，
		
		兼容css3和各大浏览器，提供了dom、events、animate、ajax等简易的操作。
		
		jquery的插件非常丰富，大多数功能都有相应的插件解决方案。
		
		jquery的宗旨是write less do more(写的少做到多)
		
	2、jquery的下载与配置
		下载：
			www.jquery.com
				
		配置： 
			(1) 将下载的jquery放到工程中，一般放到webRoot下
			(2) 在html页面中将jquery进行引入
			
			<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
		
		测试是否引入成功
			<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
			
			<script type="text/javascript">
				$(document).ready(function(){
					alert("引入成功");
				});
			</script>

	3、快速入门
		3.1、js版的二级城市联动
			<script type="text/javascript">
				window.onload = function(){
					var city = document.getElementById("city");
					/* 添加change事件 */
					city.onchange = function(){
					
						/* 获取选中的标签 */
						var option = document.getElementsByTagName("option");
						/* 遍历循环 */
						for(var i=0;i<option.length;i++){
							/* 判断哪一个被选中(结果是true) */
							if(option[i].selected){
								var val = option[i].value;
								
								/* 根据选中的城市改变城市中的区 */
								switch(val){
									case "bj":
										/* 获取对应区域的id值 */
										var area = document.getElementById("area");
										area.innerHTML = "<option>昌平区</option>"
														+"<option>朝阳区</option>"
														+"<option>海淀区</option>";
										break;
									case "tj":
										/* 获取对应区域的id值 */
										var area = document.getElementById("area");
										area.innerHTML = "<option>南开区</option>"
														+"<option>和平区</option>"
														+"<option>河西区</option>";
										break;
									case "sh":
										/* 获取对应区域的id值 */
										var area = document.getElementById("area");
										area.innerHTML = "<option>闵行区</option>"
														+"<option>浦东区</option>"
														+"<option>虹桥区</option>";
										break;
								}
							}
						}
					};
				};
			</script>
			</head>
			<body>
				<select id="city">
					<option value="bj">北京</option>
					<option value="tj">天津</option>
					<option value="sh">上海</option>
				</select>
				<select id="area">
					<option>昌平区</option>
					<option>朝阳区</option>
					<option>海淀去</option>
				</select>
			</body>
		
		3.2、jQuery版的二级城市联动
			<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
				<script type="text/javascript">
					$(document).ready(function(){
						/* 获取id=city的城市标签 */
						var $city = $("#city");
						/* 绑定时间 */
						$city.change(function(){
							var $val = $("#city option:selected").val();
							/* 给对应的城市赋值相关的区域 */
							switch($val){
								case 'bj':
									$("#area").html("<option>昌平区</option>"
													+"<option>朝阳区</option>"
													+"<option>海淀区</option>");
									break;
								case 'tj':
									$("#area").html("<option>南开区</option>"
													+"<option>和平区</option>"
													+"<option>河西区</option>");
									break;
								case 'sh':
									$("#area").html("<option>闵行区</option>"
													+"<option>浦东区</option>"
													+"<option>虹桥区</option>");
									break;
							}
						});
					});
				</script>
			</head>
			<body>
				<select id="city">
					<option value="bj">北京</option>
					<option value="tj">天津</option>
					<option value="sh">上海</option>
				</select>
				<select id="area">
					<option>昌平区</option>
					<option>朝阳区</option>
					<option>海淀去</option>
				</select>
			</body>
		
		3.3、js和jQuery的混合版本
			<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
				<script type="text/javascript">
					window.onload = function(){
						var city = document.getElementById("city");
						/* 将city转成jQuery对象 */
						$(city).change(function(){
							var $val = $("#city option:selected").val();
							/* 给对应的城市赋值相关的区域 */
							switch($val){
								case 'bj':
									/* 使用$("#area")[0].innerHTML或者$("#area").get()0.innerHTML */
									$("#area")[0].innerHTML="<option>昌平区</option>"
													+"<option>朝阳区</option>"
													+"<option>海淀区</option>";
									break;
								case 'tj':
									$("#area")[0].innerHTML="<option>南开区</option>"
													+"<option>和平区</option>"
													+"<option>河西区</option>";
									break;
								case 'sh':
									$("#area")[0].innerHTML="<option>闵行区</option>"
													+"<option>浦东区</option>"
													+"<option>虹桥区</option>";
									break;
							}				
						});
					};
				</script>
			</head>
			<body>
				<select id="city">
					<option value="bj">北京</option>
					<option value="tj">天津</option>
					<option value="sh">上海</option>
				</select>
				<select id="area">
					<option>昌平区</option>
					<option>朝阳区</option>
					<option>海淀去</option>
				</select>
			</body>
		
		
		3.4、js与jQuery的关系和区别
			(1) js对象与jquery对象之间的转换
				约定jquery对象变量的形式：$变量名(可以不写$)
				
				js对象转成jquery对象：$(js对象)
				
				jquery对象转成js对象：jquery对象[0] 或者 jquery对象.get(0);
		
			(2) 页面加载完毕事件window.onload 和 $(document).ready() 的区别??
				A、window.onload方法会等页面全部元素（包括图片等）加载完毕再加载js，
					$(document).ready()只是页面元素加载完毕即可---dom加载完毕就执行
				
				B、window.onload方法只能写一个，写多个也是只运行一个；
					而$(document).ready方法可以书写多个，且都执行
				
				C、window.onload没有简写形式，
					而$(document).ready(fiunction(){})有简写形式是$(function(){});
						
			(3) 事件的写法
				js事件的写法：js对象.事件 = 函数;
				
				jsNode.onclick = function(){}
				
				jquery的写法：jquery对象.事件(function(){});
				
				jqueryObj.click(function(){});

二、jQuery的选择器
	1、基本选择器
		注意：
			基本选择器是 jQuery中最常用的选择器, 也是最简单的选择器, 
			它通过元素的id, class 和标签名来查找DOM 元素(在网页中 id 只能使用一次, class 允许重复使用).
			
		1.1、元素选择器*
			定义：
				元素选择器就是html已经定义的标签元素,例如 div, input, a等等
			语法：
				$("html标签名")     ------ html标签名称{css}

		1.2、id选择器*
			定义：
				通过html中标签的id属性的值来定位元素对象的
			语法：
				$("#id的属性值")
			
		1.3、类选择器*
			定义
				这个标签是直接选择html代码中class=""myClass""的元素或元素组
				因为在同一html页面中class是可以存在多个同样值的 
				
			语法：
				$(".class的属性值")

		1.4、通配符选择器(不常用)
			定义：
				匹配所有的页面元素
			
			语法：
				$("*")
			
		1.5、并列选择器
			定义：
				将每一个选择器匹配到的元素合并后一起返回，你可以指定任意多个选择器
				
			语法：
				$("selector1, selector2... ... selectorN")
		
		例如：
			<head>
				<title>基本选择器</title>
			    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
				<script language="JavaScript" src="js/jquery-3.2.0.js"></script>
				<style type="text/css">
				 	div,span{
					    width: 180px;
					    height: 180px;
					    margin: 20px;
					    background: #9999CC;
					    border: #000 1px solid;
						float:left;
					    font-size: 17px;
					    font-family:Roman;
					}
					div .mini{
					    width: 50px;
					    height: 50px;
					    background: #CC66FF;
					    border: #000 1px solid;
					    font-size: 12px;
					    font-family:Roman;
					}
					div .mini01{
					    width: 50px;
					    height: 50px;
					    background: #CC66FF;
					    border: #000 1px solid;
					    font-size: 12px;
					    font-family:Roman;
					}
				 </style>
			</head>
			<body>
				 <input type="button" value="改变 id 为 one 的元素的背景色为 红色"  id="b1"/><br/><hr>
				 <input type="button" value=" 改变元素名为 <div> 的所有元素的背景色为 红色"  id="b2"/><br/><hr>
				 <input type="button" value=" 改变 class 为 mini 的所有元素的背景色为 红色"  id="b3"/><br/><hr>
				 <input type="button" value=" 改变所有元素的背景色为 红色"  id="b4"/><br/><hr>
				 <input type="button" value=" 改变所有的<span>元素和 id 为 two 的元素的背景色为红色"  id="b5"/><br/><hr>
				
				 <div id="one">id为one</div>
				
				 <div id="two" class="mini" >
				   	   id为two  class是 mini 
				       <div class="mini">class是 mini</div>
				 </div>
				
				 <div class="one">
				 	   class是 one 
				       <div class="mini">class是 mini</div>
					   <div class="mini">class是 mini</div>
				 </div>
				 <div class="one">
				 	  class是 one 
				      <div class="mini01" >class是 mini01</div>
					  <div class="mini" >class是 mini</div>
				</div>
				
				<div id="mover">div  动画</div>
				
				<span class="spanone">class为spanone的span元素</span>
				
				<span class="mini">class为mini的span元素</span>
				
			</body>
			<script type="text/javascript">
				 //<input type="button" value="改变 id 为 one 的元素的背景色为 红色"  id="b1"/>
				 $("#b1").click(function(){
				 	$("#one").css("background","red");
				 });
				 
				 //<input type="button" value=" 改变元素名为 <div> 的所有元素的背景色为 红色"  id="b2"/>
				 $("#b2").click(function(){
				 	$("div").css("background","red");
				 });
				 
				 //<input type="button" value=" 改变 class 为 mini 的所有元素的背景色为 红色"  id="b3"/>
				 $("#b3").click(function(){
				 	$(".mini").css("background","red");
				 });
				 
				 //<input type="button" value=" 改变所有元素的背景色为 红色"  id="b4"/>
				 $("#b4").click(function(){
				 	$("*").css("background","red");
				 });
				 
				 //<input type="button" value=" 改变所有的<span>元素和 id 为 two 的元素的背景色为红色"  id="b5"/>
				 $("#b5").click(function(){
				 	$("span,#two").css("background","red");
				 });
			</script>
	
	2、属性选择器
		2.1、包含某属性*
			定义：
				html元素中包含有这个属性即可，无论此属性值是什么
			
			语法：
				$("基本选择器[attribute]")
		
		2.2、某属性等于某属性值*
			定义：
				html元素中包含有这个属性并且属性等于属性值
				
			语法：
				$("基本选择器[attribute=value]")

		2.3、某属性不等于某属性值
			定义：
				html元素中包含有这个属性并且属性不等于属性值
				
			语法：
				$("基本选择器[attribute!=value]")
		
		2.4、某属性值以某属性值开头
			定义：
				html元素中包含有这个属性并且属性是以某个字符开头的
				
			语法：
				$("基本选择器[attribute^=value]")
				
		2.5、 某属性以某属性值结尾
			定义：
				html元素中包含有这个属性并且属性是以某个字符结尾的
				
			语法：
				$("基本选择器[attribute$=value]")
		
		2.6、某属性的属性值包含某些字符
			定义：
				html元素中包含有这个属性并且属性的属性值含有指定的某些字符
				
			语法：
				$("基本选择器[attribute*=value]")
			
			注意：
				如需有多个属性条件可以一次排列使用，如：$("div[id][name='gender'][class='myclass']...")
			
		例如：
			<head>
			    <title>属性过滤选择器</title>
			    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
				<script language="JavaScript" src="js/jquery-3.2.0.js"></script>
				<style type="text/css">
				 	div,span{
					    width: 180px;
					    height: 180px;
					    margin: 20px;
					    background: #9999CC;
					    border: #000 1px solid;
						float:left;
					    font-size: 17px;
					    font-family:Roman;
					}
					div .mini{
					    width: 50px;
					    height: 50px;
					    background: #CC66FF;
					    border: #000 1px solid;
					    font-size: 12px;
					    font-family:Roman;
					}
					div .mini01{
					    width: 50px;
					    height: 50px;
					    background: #CC66FF;
					    border: #000 1px solid;
					    font-size: 12px;
					    font-family:Roman;
					}
					div.visible{
						display:none;
					}
				 </style>
			</head>
			<body>
				 <input type="button" value=" 含有属性title 的div元素背景色为红色"  id="b1"/><br/><hr>
				 <input type="button" value=" 属性title值等于test的div元素背景色为红色"  id="b2"/><br/><hr>
				 <input type="button" value=" 属性title值不等于test的div元素(没有属性title的也将被选中)背景色为红色"  id="b3"/><br/><hr>
				 <input type="button" value=" 属性title值 以te开始 的div元素背景色为红色"  id="b4"/><br/><hr>
				 <input type="button" value=" 属性title值 以est结束 的div元素背景色为红色"  id="b5"/><br/><hr>
				 <input type="button" value="属性title值 含有es的div元素背景色为红色"  id="b6"/><br/><hr>
				 <input type="button" value="选取有属性id的div元素，然后在结果中选取属性title值含有“es”的 div 元素背景色为红色"  id="b7"/><br/><hr>
				 
			     <div id="one">id为one   div</div>
				
				 <div id="two" class="mini" title="test">
			    	   id为two class是 mini div title="test"
				       <div  class="mini">class是 mini</div>
				 </div>
				
				 <div class="visible" >
				 	   class是 one 
				       <div  class="mini" >class是 mini</div>
					   <div  class="mini" >class是 mini</div>
				 </div>
				 <div class="one" title="test02">
				 	  class是 one    title="test02"
				      <div class="mini01">class是 mini01</div>
					  <div class="mini" style="margin-top:0px;">class是 mini</div>
				</div>
				
				<div class="visible">这是隐藏的</div>
				
				<div class="one"></div>
				
				<div id="mover" >动画</div>
			</body>
			<script type="text/javascript">
				 //<input type="button" value=" 含有属性title 的div元素背景色为红色"  id="b1"/>
				 $("#b1").click(function(){
				 	$("div[title]").css("background","red");
				 });
				 
				 //<input type="button" value=" 属性title值等于test的div元素背景色为红色"  id="b2"/>
				 $("#b2").click(function(){
				 	$("div[title='test']").css("background","red");
				 });
				 
				 //<input type="button" value=" 属性title值不等于test的div元素(没有属性title的也将被选中)背景色为红色"  id="b3"/>
				 $("#b3").click(function(){
				 	$("div[title!='test']").css("background","red");
				 });
				 
				 //<input type="button" value=" 属性title值 以te开始 的div元素背景色为红色"  id="b4"/>
				 $("#b4").click(function(){
				 	$("div[title^='te']").css("background","red");
				 });
				 
				 //<input type="button" value=" 属性title值 以est结束 的div元素背景色为红色"  id="b5"/>
				 $("#b5").click(function(){
				 	$("div[title$='est']").css("background","red");
				 });
				 
				 //<input type="button" value="属性title值 含有es的div元素背景色为红色"  id="b6"/>
				 $("#b6").click(function(){
				 	$("div[title*='es']").css("background","red");
				 });
				 
				 //<input type="button" value="选取有属性id的div元素，然后在结果中选取属性title值含有“es”的 div 元素背景色为红色"  id="b7"/>
				 $("#b7").click(function(){
				 	$("div[id][title*='es']").css("background","red");
				 });
			</script>
	
	3、层级选择器
		3.1、 祖先选择器*
			定义:
				在给定的祖先元素下匹配所有后代元素.这个要与下面讲的"parent > child"区分开
			
			语法：
				$("ancestor  descendant")
		
		3.2、父子选择器
			定义：
				在给定的父元素下匹配所有子元素，注意：要区分好后代元素与子元素
				
			语法：
				$("parent>child")
		
		3.3、相邻选择器
			定义：
				匹配紧接在指定元素后的元素
				
			语法：
				$("pre+next")
		
		3.4、兄弟选择器(后面)
			定义;
				匹配紧接在指定元素后的元素
				
			语法：
				$("pre~next")

		注意：
			此选择器只能选择指定元素后的兄弟节点，
			如想获得指定元素的所有兄弟节点使用siblings()方法 
				例如：
					$(""#mydiv"").siblings()
					
		例如：
			<head>
			    <title>层次选择器</title>
			    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
				<script language="JavaScript" src="js/jquery-3.2.0.js"></script>
				<style type="text/css">
				 	div,span{
					    width: 180px;
					    height: 180px;
					    margin: 20px;
					    background: #9999CC;
					    border: #000 1px solid;
						float:left;
					    font-size: 17px;
					    font-family:Roman;
					}
					div .mini{
					    width: 50px;
					    height: 50px;
					    background: #CC66FF;
					    border: #000 1px solid;
					    font-size: 12px;
					    font-family:Roman;
					}
					div .mini01{
					    width: 50px;
					    height: 50px;
					    background: #CC66FF;
					    border: #000 1px solid;
					    font-size: 12px;
					    font-family:Roman;
					}
				 </style>
			</head>
			<body>
				 <input type="button" value="改变 <body> 内所有 <div> 的背景色为红色"  id="b1"/><br/><hr>
				 <input type="button" value=" 改变 <body> 内子 <div> 的背景色为 红色"  id="b2"/><br/><hr>
				 <input type="button" value=" 改变 id 为 one 的下一个 <div> 的背景色为 红色"  id="b3"/><br/><hr>
				 <input type="button" value=" 改变 id 为 two 的元素后面的所有兄弟<div>的元素的背景色为 红色"  id="b4"/><br/><hr>
				 <input type="button" value=" 改变 id 为 two 的元素所有 <div> 兄弟元素的背景色为红色"  id="b5"/><br/><hr>
				 
			     <div id="one">id为one</div>
				
				 <div id="two" class="mini">
				   	   id为two class是 mini 
				       <div class="mini">class是 mini</div>
				 </div>
				
				 <div class="one">
				 	    class是 one 
				       <div class="mini">class是 mini</div>
					   <div class="mini">class是 mini</div>
				 </div>
				 
				 <div class="one">
				 	  class是 one 
				      <div class="mini01" >class是 mini01</div>
					  <div class="mini" >class是 mini</div>
				</div>
				
				<div id="mover"> 动画</div>
		
				<span class="spanone">span</span>
			</body>
			<script type="text/javascript">
				 //<input type="button" value="改变 <body> 内所有 <div> 的背景色为红色"  id="b1"/>
				 $("#b1").click(function(){
				 	$("body div").css("background","red");
				 });
				 
				 //<input type="button" value=" 改变 <body> 内子 <div> 的背景色为 红色"  id="b2"/>
				 $("#b2").click(function(){
				 	$("body>div").css("background","red");
				 });
				 
				 //<input type="button" value=" 改变 id 为 one 的下一个 <div> 的背景色为 红色"  id="b3"/>
				 $("#b3").click(function(){
				 	$("#one+div").css("background","red");
				 });
				 
				 //<input type="button" value=" 改变 id 为 two 的元素后面的所有兄弟<div>的元素的背景色为 红色"  id="b4"/>
				 $("#b4").click(function(){
				 	$("#two~div").css("background","red");
				 });
				 
				 //<input type="button" value=" 改变 id 为 two 的元素所有 <div> 兄弟元素的背景色为红色"  id="b5"/>
				 $("#b5").click(function(){
				 	$("#two").siblings("div").css("background","red");
				 });
			</script>
			
	4、过滤选择器
		注意：	
			遍历jquery集合的方法
			方法一：
				jquery集合对象.each(function(index,domElement));
				其中：
					index代表集合中每个对象的脚标，domElement代表集合中的每个js对象
				
				例如：
					$("#b4").click(function(){
					 	var $inputs = $("input:hidden");
					 	$inputs.each(function(index,domEle){
					 		alert(index);
					 		alert(domEle.value);
					 	});
					 });
			
			方法二：
				$.each(jquery集合对象,function(index,domElement){});
				其中：
					index代表集合中每个对象的脚标，domElement代表集合中的每个js对象
				
				例如：
					$("#b5").click(function(){
					 	var $inputs = $("input:hidden");
					 	$.each($inputs,function(index,domEle){
					 		alert($(domEle).val());
					 	});
					 	
					 });

			方法三：(一般不用)
				例如：
					$("#b3").click(function(){
					 	var $inputs = $("input:hidden");
					 	for(var i=0;i<$inputs.length;i++){
					 		var inputX = $inputs[i];
					 		alert($(inputX).val());
					 	}
					 });
				
		4.1、基础过滤选择器
			语法：
				:first                          匹配某集合元素的第一个元素
				:last                           匹配某集合元素的最后一个元素
				:not(selecter)               	匹配某集合元素不包含某个元素

				:even                           匹配某集合元素的偶数元素 索引从0开始 忽视层级层级关系
				:odd                            匹配某集合元素的奇数元素 索引从0开始

				:eq(index)                    	匹配某集合元素的第index个元素
				:gt(index)                     	匹配某集合元素索引大于第index的元素    ------&gt;   &lt;
				:lt(index)                      匹配某集合元素索引小于第index的元素

				:header                        	固定写法 匹配标题元素

				:animated                   	固定写法 匹配正在执行动画的元素

			例如：
				<head>
				    <title>基本过滤选择器</title>
				    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
					<script language="JavaScript" src="js/jquery-3.2.0.js"></script>
					<style type="text/css">
					 	div,span{
						    width: 180px;
						    height: 180px;
						    margin: 20px;
						    background: #9999CC;
						    border: #000 1px solid;
							float:left;
						    font-size: 17px;
						    font-family:Roman;
						}
						div .mini{
						    width: 50px;
						    height: 45px;
						    background: #CC66FF;
						    border: #000 1px solid;
						    font-size: 12px;
						    font-family:Roman;
						}
						div .mini01{
						    width: 50px;
						    height: 45px;
						    background: #CC66FF;
						    border: #000 1px solid;
						    font-size: 12px;
						    font-family:Roman;
						}
					</style>
				</head>
				<body>
					 <input type="button" value=" 改变第一个 div 元素的背景色为 红色"  id="b1"/><br/><hr>
					 <input type="button" value=" 改变最后一个 div 元素的背景色为 红色"  id="b2"/><br/><hr>
					 <input type="button" value=" 改变class不为 one 的所有 div 元素的背景色为 红色"  id="b3"/><br/><hr>
					 <input type="button" value=" 改变索引值为偶数的 div 元素的背景色为 红色"  id="b4"/><br/><hr>
					 <input type="button" value=" 改变索引值为奇数的 div 元素的背景色为 红色"  id="b5"/><br/><hr>
					 <input type="button" value=" 改变索引值为大于 3 的 div 元素的背景色为 红色"  id="b6"/><br/><hr>
					 <input type="button" value=" 改变索引值为等于 3 的 div 元素的背景色为 红色"  id="b7"/><br/><hr>
					 <input type="button" value=" 改变索引值为小于 3 的 div 元素的背景色为 红色"  id="b8"/><br/><hr>
					 <input type="button" value=" 改变所有的标题元素的背景色为 红色"  id="b9"/><br/><hr>
					 <input type="button" value=" 改变当前正在执行动画的所有元素的背景色为 红色"  id="b10"/><br/><hr>
					
					 <h1>有一种奇迹叫坚持</h1>
					 
				     <div id="one">id为one</div>
					
					 <div id="two" class="mini" >
						id为two  class是 mini 
						<div class="mini">class是 mini</div>
					 </div>
					
					 <div class="one" >
						class是 one 
						<div class="mini">class是 mini</div>
						<div class="mini">class是 mini</div>
					 </div>
					 
					 <div class="one" >
						class是 one 
						<div class="mini01">class是 mini01</div>
						<div class="mini">class是 mini</div>
					</div>
					
					<div id="mover"> 动画</div>
				</body>
				<script type="text/javascript">
					 //<input type="button" value=" 改变第一个 div 元素的背景色为 红色"  id="b1"/>
					 $("#b1").click(function(){
					 	$("div:first").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变最后一个 div 元素的背景色为 红色"  id="b2"/>
					 $("#b2").click(function(){
					 	$("div:last").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变class不为 one 的所有 div 元素的背景色为 红色"  id="b3"/>
					 $("#b3").click(function(){
					 	$("div:not(.one)").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变索引值为偶数的 div 元素的背景色为 红色"  id="b4"/>
					 $("#b4").click(function(){
					 	$("div:even").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变索引值为奇数的 div 元素的背景色为 红色"  id="b5"/>
					 $("#b5").click(function(){
					 	$("div:odd").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变索引值为大于 3 的 div 元素的背景色为 红色"  id="b6"/>
					 $("#b6").click(function(){
					 	$("div:gt(3)").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变索引值为等于 3 的 div 元素的背景色为 红色"  id="b7"/>
					 $("#b7").click(function(){
					 	$("div:eq(3)").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变索引值为小于 3 的 div 元素的背景色为 红色"  id="b8"/>
					 $("#b8").click(function(){
					 	$("div:lt(3)").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变所有的标题元素的背景色为 红色"  id="b9"/>
					 $("#b9").click(function(){
					 	$(":header").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变当前正在执行动画的所有元素的背景色为 红色"  id="b10"/>
					 $("#b10").click(function(){
					 	$(":animated").css("background","red");
					 });
					 
					 //***********执行动画效果***********
					 function mover(){
					 	$("#mover").slideToggle("slow",mover);
					 }
					 mover();
					 //***********执行动画效果***********
				</script>
		
		4.2、内容过滤选择器
			语法：
				:contains(text)            		匹配某包含text(文本)内容的元素
				:empty                      	匹配所有不包含子元素或者文本的空元素
				:parent                        	匹配含有子元素或者文本的元素
				
				:has(selecter)              	匹配含有某选择器的元素
				
			例如：
				<head>
				    <title>内容过滤选择器</title>
				    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
					<script language="JavaScript" src="js/jquery-3.2.0.js"></script>
					<style type="text/css">
					 	div,span{
						    width: 180px;
						    height: 180px;
						    margin: 20px;
						    background: #9999CC;
						    border: #000 1px solid;
							float:left;
						    font-size: 17px;
						    font-family:Roman;
						}
						div .mini{
						    width: 50px;
						    height: 50px;
						    background: #CC66FF;
						    border: #000 1px solid;
						    font-size: 12px;
						    font-family:Roman;
						}
						div .mini01{
						    width: 50px;
						    height: 50px;
						    background: #CC66FF;
						    border: #000 1px solid;
						    font-size: 12px;
						    font-family:Roman;
						}
					</style>
				</head>
				<body>
					 <input type="button" value=" 改变含有文本 ‘di’ 的 div 元素的背景色为 红色"  id="b1"/><br/><hr>
					 <input type="button" value=" 改变不包含子元素(或者文本元素) 的 div 空元素的背景色为"  id="b2"/><br/><hr>
					 <input type="button" value=" 改变含有 class 为 mini 元素的 div 元素的背景色为 红色"  id="b3"/><br/><hr>
					 <input type="button" value=" 改变含有子元素(或者文本元素)的div元素的背景色为 红色"  id="b4"/><br/><hr>
					 <input type="button" value=" 改变不含有文本 di的 div 元素的背景色"  id="b5"/><br/><hr>
		
				     <div id="one"> id为one  div</div>
					
					 <div id="two" class="mini" >
						id为two  class是 mini  div
						<div class="mini">class是 mini</div>
					 </div>
					
					 <div class="one">
					 	    class是 one 
					       <div  class="mini" >class是 mini</div>
						   <div  class="mini" >class是 mini</div>
					 </div>
					 <div class="one">
						class是 one 
						<div class="mini01">class是 mini01</div>
						<div class="mini">class是 mini</div>
					</div>
					
					<div class="one"></div>
					
					<div id="mover"> 动画</div>
					
				</body>
				<script type="text/javascript">
					 //<input type="button" value=" 改变含有文本 ‘di’ 的 div 元素的背景色为 红色"  id="b1"/>
					 $("#b1").click(function(){
					 	$("div:contains('di')").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变不包含子元素(或者文本元素) 的 div 空元素的背景色为"  id="b2"/>
					 $("#b2").click(function(){
					 	$("div:empty").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变含有 class 为 mini 元素的 div 元素的背景色为 红色"  id="b3"/>
					 $("#b3").click(function(){
					 	$("div:has(.mini)").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变含有子元素(或者文本元素)的div元素的背景色为 红色"  id="b4"/>
					 $("#b4").click(function(){
					 	$("div:parent").css("background","red");
					 });
					 
					 //<input type="button" value=" 改变不含有文本 di的 div 元素的背景色"  id="b5"/>
					 $("#b5").click(function(){
					 	$("div:not(:contains('di'))").css("background","red");
					 });
				</script>
			
		4.3、可见度过滤选择器
			语法：
				:hidden                       	匹配所有的不可见元素  ---input type="hidden"    ---- div: display:none
				:visible                        匹配所有的可见元素

			例如：
				<head>
				    <title>可见度过滤选择器</title>
				    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
					<script language="JavaScript" src="js/jquery-3.2.0.js"></script>
					<style type="text/css">
						 	div,span{
							    width: 180px;
							    height: 180px;
							    margin: 20px;
							    background: #9999CC;
							    border: #000 1px solid;
								float:left;
							    font-size: 17px;
							    font-family:Roman;
							}
							div .mini{
							    width: 50px;
							    height: 50px;
							    background: #CC66FF;
							    border: #000 1px solid;
							    font-size: 12px;
							    font-family:Roman;
							}
							div .mini01{
							    width: 50px;
							    height: 50px;
							    background: #CC66FF;
							    border: #000 1px solid;
							    font-size: 12px;
							    font-family:Roman;
							}
							div.visible{
								display:none;
							}
					 </style>
				</head>
				<body>
					 <input type="button" value=" 改变所有可见的div元素的背景色为 红色"  id="b1"/><br/><hr>
					 <input type="button" value=" 选取所有不可见的div元素, 利用 jQuery 中的 show() 方法将它们显示出来, 并设置其背景色为 红色"  id="b2"/><br/><hr>
					 <input type="button" value=" 选取所有的文本隐藏域, 并打印它们的值"  id="b3"/><br/><hr>
					 <input type="button" value=" 选取所有的文本隐藏域, 并打印它们的值"  id="b4"/><br/><hr>
					 <input type="button" value=" 选取所有的文本隐藏域, 并打印它们的值"  id="b5"/><br/><hr>
					 
					 <!--文本隐藏域-->
				     <input type="hidden" value="hidden_1">
					 <input type="hidden" value="hidden_2">
					 <input type="hidden" value="hidden_3">
					 
				     <div id="one">id为one  div</div>
					
					 <div id="two" class="mini">
						id为two   class是 mini  div
						<div  class="mini">class是 mini</div>
					</div>
					
					 <div class="visible">
						class是 one 隐藏的
						<div class="mini">class是 mini</div>
						<div class="mini">class是 mini</div>
					 </div>
					 
					 <div class="one" >
						class是 one 
						<div class="mini01">class是 mini01</div>
						<div class="mini">class是 mini</div>
					 </div>
					 
					<div class="visible">这是隐藏的</div>
					
					<div class="one"></div>
		
					<div id="mover" >动画</div>
				</body>
				<script type="text/javascript">
					 //<input type="button" value=" 改变所有可见的div元素的背景色为 红色"  id="b1"/>
					 $("#b1").click(function(){
					 	$("div:visible").css("background","red");
					 });
					 
					 //<input type="button" value=" 选取所有不可见的div元素, 利用 jQuery 中的 show()/hide() 方法将它们显示出来, 并设置其背景色为 红色"  id="b2"/>
					 $("#b2").click(function(){
					 	$("div:hidden").show().css("background","red");
					 });
					 
					 //<input type="button" value=" 选取所有的文本隐藏域, 并打印它们的值"  id="b3"/>
					 $("#b3").click(function(){
					 	var $inputs = $("input:hidden");
					 	for(var i=0;i<$inputs.length;i++){
					 		var inputX = $inputs[i];
					 		alert($(inputX).val());
					 	}
					 });
					 
					 //<input type="button" value=" 选取所有的文本隐藏域, 并打印它们的值"  id="b4"/>
					 $("#b4").click(function(){
					 	var $inputs = $("input:hidden");
					 	$inputs.each(function(index,domEle){
					 		alert(index);
					 		alert(domEle.value);
					 	});
					 });
					 
					 //<input type="button" value=" 选取所有的文本隐藏域, 并打印它们的值"  id="b5"/>
					 $("#b5").click(function(){
					 	var $inputs = $("input:hidden");
					 	$.each($inputs,function(index,domEle){
					 		alert($(domEle).val());
					 	});
					 	
					 });
				</script>
		
		4.4、子元素过滤选择器（选儿子）
			注意父子关系(之间要加空格)
			
			语法：
				:nth-child(index/even/odd)      匹配其父元素下的第N个(索引从1开始)子或奇偶元素
				:first-child                   	匹配第一个子元素
				:last-child                    	匹配最后一个子元素
				:only-child                  	匹配只有一个子元素

			例如：
				<head>
				    <title>子元素过滤选择器</title>
				    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
					<script language="JavaScript" src="js/jquery-3.2.0.js"></script>
					<style type="text/css">
					 	div,span{
						    width: 180px;
						    height: 180px;
						    margin: 20px;
						    background: #9999CC;
						    border: #000 1px solid;
							float:left;
						    font-size: 17px;
						    font-family:Roman;
						}
						div .mini{
						    width: 50px;
						    height: 50px;
						    background: #CC66FF;
						    border: #000 1px solid;
						    font-size: 12px;
						    font-family:Roman;
						}
						div .mini01{
						    width: 50px;
						    height: 50px;
						    background: #CC66FF;
						    border: #000 1px solid;
						    font-size: 12px;
						    font-family:Roman;
						}
						div.visible{
							display:none;
						}
					</style>
				</head>
				<body>
					 <input type="button" value=" 每个class为one的div父元素下的第2个子元素"  id="b1"/><br/><hr>
					 <input type="button" value=" 每个class为one的div父元素下的第一个子元素"  id="b2"/><br/><hr>
					 <input type="button" value=" 每个class为one的div父元素下的最后一个子元素"  id="b3"/><br/><hr>
					 <input type="button" value=" 如果class为one的div父元素下的仅仅只有一个子元素，那么选中这个子元素"  id="b4"/><br/><hr>
					 
					 <div id="one" class="mini"  title="test">
						id为two   class是 mini  div  title="test"
						<div class="mini">class是 mini</div>
					 </div>
					 
					 <div class="one" title="test">
						class是 one 
						<div class="mini">class是 mini</div>
					 </div>
					
					 <div class="visible" >
						class是 one 
						<div class="mini">class是 mini</div>
						<div class="mini">class是 mini</div>
					 </div>
					 
					 <div class="one" title="test02">
						class是 one  title="test02"   
						<div class="mini01">class是 mini01</div>
						<div class="mini" style="margin-top: 0px;">class是 mini</div>
					</div>
					
					<div class="one"></div>
		
					<div id="mover">动画</div>
				</body>
				<script type="text/javascript">
					 
					 //<input type="button" value=" 每个class为one的div父元素下的第2个子元素"  id="b1"/>
					 $("#b1").click(function(){
					 	$(".one>:nth-child(2)").css("background","red");
					 });
					 //<input type="button" value=" 每个class为one的div父元素下的第一个子元素"  id="b2"/>
					 $("#b2").click(function(){
					 	$(".one :first-child").css("background","red");
					 });
					 //<input type="button" value=" 每个class为one的div父元素下的最后一个子元素"  id="b3"/>
					 $("#b3").click(function(){
					 	$(".one :last-child").css("background","red");
					 });
					 
					 //<input type="button" value=" 如果class为one的div父元素下的仅仅只有一个子元素，那么选中这个子元素"  id="b4"/>
					 $("#b4").click(function(){
					 	$(".one :only-child").css("background","red");
					 });
					 
				</script>
		
		4.5、表单属性过滤选择器*
			语法：
				:enabled                     	 匹配所有可用元素
				:disabled                    	 匹配所有不可用元素
				
				:checked                     	匹配所有选中的被选中元素(复选框、单选框等，不包括option)*
				:selected                     	匹配所有选中的option元素*

			例如：
				<head>
					<script language="JavaScript" src="js/jquery-3.2.0.js"></script>
				</head>
				<body>
					<input type="button" value="保存"  class="mini" name="ok"  class="mini" /><br/><hr>
					<input type="button" value=" 利用 jQuery 对象的 val() 方法改变表单内可用 <input> 元素的值"  id="b1"/><br/><hr>
					<input type="button" value=" 利用 jQuery 对象的 val() 方法改变表单内不可用 <input> 元素的值"  id="b2"/><br/><hr>
					<input type="button" value=" 利用 jQuery 对象的 length 属性获取多选框选中的个数"  id="b3"/><br/><hr>
					<input type="button" value=" 利用 jQuery 对象的 text() 方法获取下拉框选中的内容"  id="b4"/><br/><hr>
					<br><br>
					<input type="text" value="不可用值1" disabled="disabled"> <br/><br/>
					<input type="text" value="可用值1" ><br/><br/>
					<input type="text" value="不可用值2" disabled="disabled"><br/><br/>
					<input type="text" value="可用值2" ><br/><br/>
					<br><br>
					<input type="checkbox" name="items" value="美容" >美容
					<input type="checkbox" name="items" value="IT" >IT
					<input type="checkbox" name="items" value="金融" >金融
					<input type="checkbox" name="items" value="管理" >管理
					<br><br>
					<input type="radio" name="sex" value="男" >男
					<input type="radio" name="sex" value="女" >女
					<br><br>
					<select name="job" id="job" multiple="multiple" size=4>
				        <option>程序员</option>
						<option>中级程序员</option>
						<option>高级程序员</option>
						<option>系统分析师</option>
					</select>
					    
					<select name="edu" id="edu">
				        <option>本科</option>
						<option>博士</option>
						<option>硕士</option>
						<option>大专</option>
					</select>
				</body>
				<script type="text/javascript">
					 //<input type="button" value=" 利用 jQuery 对象的 val() 方法改变表单内可用 <input> 元素的值"  id="b1"/>
					 $("#b1").click(function(){
					 	$("input[type='text']:enabled").val("hello jquery");
					 });
					 
					 //<input type="button" value=" 利用 jQuery 对象的 val() 方法改变表单内不可用 <input> 元素的值"  id="b2"/>
					 $("#b2").click(function(){
					 	$("input[type='text']:disabled").val("hello jquery!!");
					 });
					 //<input type="button" value=" 利用 jQuery 对象的 length 属性获取多选框选中的个数"  id="b3"/>
					 $("#b3").click(function(){
					 	var $items = $("input[name='items']:checked");
					 	alert($items.length);
					 });
					 
					 //<input type="button" value=" 利用 jQuery 对象的 text() 方法获取下拉框选中的内容"  id="b4"/>
					 $("#b4").click(function(){
					 	var $options = $("option:selected");
					 	$options.each(function(index,domEle){
					 		alert($(domEle).text());
					 	});
					 });
				</script>

三、jQuery的dom操作

	1、内部插入节点						
		append(content) :向每个匹配的元素的内部的结尾处追加内容     ：    父元素.append(子元素)							
		
		appendTo(content) :将每个匹配的元素追加到指定的元素中的内部结尾处 ：  子元素.appendTo(父元素)							
		
		prepend(content):向每个匹配的元素的内部的开始处插入内容							
		
		prependTo(content) :将每个匹配的元素插入到指定的元素内部的开始处							
	
		注意：
			只能插入到最前面或最后面(直接剪切走)
		例如：
			<body>
				 <ul id="city">
				 	 <li id="bj" name="beijing">北京</li>
					 <li id="tj" name="tianjin">天津</li>
					 <li id="cq" name="chongqing">重庆</li>
				 </ul>
				  <ul id="love">
				 	 <li id="fk" name="fankong">反恐</li>
					 <li id="xj" name="xingji">星际</li>
				 </ul>
			</body>
			<script type="text/javascript">
				/**将反恐放置到city的后面*/
				//append(content) :向每个匹配的元素的内部的结尾处追加内容
				var $city = $("#city");
				var $fk = $("#fk");
				$city.append($fk);
				
				//appendTo(content) :将每个匹配的元素追加到指定的元素中的内部结尾处
				var $city = $("#city");
				var $fk = $("#fk");
				$fk.appendTo($city);
				
				/**将反恐放置到city的最前面*/
				//prepend(content):向每个匹配的元素的内部的开始处插入内容
				var $city = $("#city");
				var $fk = $("#fk");
				$city.prepend($fk);
				
				//prependTo(content) :将每个匹配的元素插入到指定的元素内部的开始处
				var $city = $("#city");
				var $fk = $("#fk");
				$fk.prependTo($city);
			</script>
		
	2、外部插入节点 							
		after(content) :在每个匹配的元素之后插入内容   ---- 目标元素.after(被插入的元素)							
		
		before(content):在每个匹配的元素之前插入内容 							
		
		insertAfter(content):把所有匹配的元素插入到另一个、指定的元素元素的后面     ----被插入的元素.insertAfter(目标元素)							
		
		insertBefore(content) :把所有匹配的元素插入到另一个、指定的元素元素的前面 	
		
		注意：
			插入到指定位置(直接剪切走)
		
		例如：
			<body>
				 <ul id="city">
				 	 <li id="bj" name="beijing">北京</li>
					 <li id="tj" name="tianjin">天津</li>
					 <li id="cq" name="chongqing">重庆</li>
				 </ul>
				 <p id="p2">I would like to say:p2</p>
			</body>
			<script type="text/javascript">
				/**将p2放置到天津的后面*/
				//after(content) :在每个匹配的元素之后插入内容 
				var $tj = $("#tj");
				var $p2 = $("#p2");
				$tj.after($p2);
				
				//insertAfter(content):把所有匹配的元素插入到另一个、指定的元素元素集合的后面 
				var $tj = $("#tj");
				var $p2 = $("#p2");
				$p2.insertAfter($tj);
				
				/**将p2放置到天津的前面*/
				//before(content):在每个匹配的元素之前插入内容
				var $tj = $("#tj");
				var $p2 = $("#p2");
				$tj.before($p2);
				
				//insertBefore(content) :把所有匹配的元素插入到另一个、指定的元素元素集合的前面 
				var $tj = $("#tj");
				var $p2 = $("#p2");
				$p2.insertBefore($tj);
			</script>
		
	3、属性操作							
		获得属性值：attr("属性名称")							
		
		修改属性值：attr("属性名称"，"属性值")							
		
		增加属性：   attr("属性名称"，"属性值")							
		
		删除属性：   removeAttr("属性名称")							
		
		注意：
			jQuery中有很多方法都是一个函数实现获取和设置.
				如: 
					attr()
					html()
					text()
					val()
					height()
					width()
					css()等				
		
		例如:
			<body>
				 <ul>
				 	 <li id="bj" name="beijing">北京</li>
					 <li id="tj" name="tianjin">天津</li>
				 </ul>
			</body>
			<script type="text/javascript">
				//获取北京节点的name属性值
				var $name = $("#bj").attr("name");
				alert($name);
			    
				//设置北京节点的name属性的值为dabeijing
				$("#bj").attr("name","dabeijing");
				alert($("#bj").attr("name"));
				
				//新增北京节点的discription属性 属性值是didu
				$("#bj").attr("discription","didu");
				alert($("#bj").attr("discription"));
				
				//删除北京节点的name属性并检验name属性是否存在
				$("#bj").removeAttr("name");
				alert($("#bj").attr("name"));
			</script>
			
	4、创建节点							
		创建li节点 ：$("<li/>") == $("<li></li>") 							
		注意：
			html标签的写法 要不写开始关闭<li></li> 要不写自闭标签<li/>
			动态创建的新元素节点不会被自动添加到文档中, 而是需要使用其他方法将其插入到文档中
		
		例如：
			<body>
				 <ul id="city">
				 	 <li id="bj" name="beijing">北京</li>
				 </ul>
			</body>
			<script type="text/javascript">
				//创建<li id="tj" name="tianjin">天津</li>的节点插入到北京的后面
				var $li = $("<li/>");
				$li.attr("id","tj");
				$li.attr("name","tianjin");
				//添加内容方法一
				$li.html("天津");
				//添加内容方法二
				$li.text("天津");
				
				$bj = $("#bj");
				$bj.after($li);
			</script>
		
	5、删除节点							
		remove(): 
			从 DOM 中删除所有匹配的元素, 传入的参数用于根据 jQuery 表达式来筛选元素. 
			当某个节点用 remove() 方法删除后, 该节点所包含的所有后代节点将被同时删除. 
			这个方法的返回值是一个指向已被删除的节点的引用 ----- 自杀
			
		empty(): 
			清空节点 – 清空元素中的所有后代节点(不包含属性节点)  
		
		例如：
			<body>
				 <ul id="city">
				 	 <li id="bj" name="beijing">北京</li>
					 <li id="tj" name="tianjin">天津</li>
					 <li id="cq" name="chongqing">重庆</li>
				 </ul>
			</body>
			<script type="text/javascript">
			   //删除<li id="bj" name="beijing">北京</li>
			   $("#bj").remove();
			   
			   //删除所有的子节点   清空元素中的所有后代节点(不包含属性节点).
			   $("#city").empty();
			   
			   //测试(id='city')并没有被删除
			   alert($("#city").attr("id"));
			</script>
			
	6、复制节点							
		clone(): 
			克隆匹配的 DOM 元素, 返回值为克隆后的副本. 但此时复制的新节点不具有任何行为(事件)
			
		clone(true): 
			复制元素的同时也复制元素中的的事件
			
		例如：
			<body>
				<button>保存</button>	<br>	<br>	<br>	
			    <p>段落</p>
			</body>
		    <script type="text/javascript">
		        //button增加事件
		        $("button").click(function(){
		        	alert("x");
		        });
				
			    //克隆button 追加到p上 ,但事件不克隆
			    var button2 = $("button").clone();
			    $("p").append(button2);
			    
			    //克隆button 追加到p上 ,但事件也克隆
			    var button2 = $("button").clone(true);
			    $("p").append(button2);
		    </script>
		
	7、替换节点							
		replaceWith(): 
			将所有匹配的元素都替换为指定的 HTML 或 DOM 元素
			
		replaceAll(): 
			颠倒了的 replaceWith() 方法
			
		例如：
			<body>
				<button>保存</button>	<br>	<br>	<br>	
			    <p>段落</p>
			</body>
			<script type="text/javascript">
				/**创建一个button，将段落p用创建的button替换*/
				//使用replaceAll(): 
				var $button = $("<button/>");
				$button.text("new button");
				$button.replaceAll($("p"));
		
				//使用replaceWith(): 
				var $button = $("<button/>");
				$button.text("new button");
				$("p").replaceWith($button);
			</script>
		
	8、样式操作							
		追加样式：
			addClass() ------- 使用attr("class","")
			
		移除样式：
			removeClass()：从匹配的元素中删除全部或指定的 class
			
		切换样式：
			toggleClass()：控制样式上的重复切换.如果类名存在则删除它, 如果类名不存在则添加它.
			
		判断是否含有某个样式：
			hasClass()判断元素中是否含有某个 class, 如果有, 则返回 true; 否则返回 false						
		
		例如：
			<head>
			    <title>样式操作</title>
			    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
				<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
				<style type="text/css">
				   .one{
					    width: 200px;
					    height: 140px;
					    margin: 20px;
					    background: red;
					    border: #000 1px solid;
						float:left;
					    font-size: 17px;
					    font-family:Roman;
					}
				 	div,span{
					    width: 140px;
					    height: 140px;
					    margin: 20px;
					    background: #9999CC;
					    border: #000 1px solid;
						float:left;
					    font-size: 17px;
					    font-family:Roman;
					}
					div .mini{
					    width: 40px;
					    height: 40px;
					    background: #CC66FF;
					    border: #000 1px solid;
					    font-size: 12px;
					    font-family:Roman;
					}
					div .mini01{
					    width: 40px;
					    height: 40px;
					    background: #CC66FF;
					    border: #000 1px solid;
					    font-size: 12px;
					    font-family:Roman;
					}
					
					/*待用的样式*/
					.second{
						width: 300px;
					    height: 340px;
					    margin: 20px;
					    background: yellow;
					    border: pink 3px dotted;
						float:left;
					    font-size: 22px;
					    font-family:Roman;
					}
				</style>
			</head>
			<body>
				 <input type="button" value="采用属性增加样式(改变id=one的样式)" id="b1"/><br/><hr>
				 <input type="button" value=" addClass"  id="b2"/><br/><hr>
				 <input type="button" value="removeClass"  id="b3"/><br/><hr>
				 <input type="button" value=" 切换样式"  id="b4"/><br/><hr>
				 <input type="button" value=" hasClass"  id="b5"/><br/><hr>
		 
			     <div id="one">id为one</div>
				
				 <div id="two" class="mini" >
					id为two   class是 mini 
					<div class="mini">class是 mini</div>
				 </div>
				
				 <div class="one" >
					class是 one 
					<div class="mini">class是 mini</div>
					<div class="mini">class是 mini</div>
				 </div>
				 
				 <div class="one" >
					class是 one 
					<div class="mini01">class是 mini01</div>
					<div class="mini">class是 mini</div>
				</div>
				
				<div id="mover">动画</div>
		
				<span class="spanone">span</span>
			</body>
			<script type="text/javascript">
				 //<input type="button" value="采用属性增加样式(改变id=one的样式)"  id="b1"/>
				 $("#b1").click(function(){
				 	$("#one").attr("class","second");
				 });
				 
				 //<input type="button" value=" addClass"  id="b2"/>
				 $("#b2").click(function(){
				 	$("#one").addClass("second");
				 });
				 
				 //<input type="button" value="removeClass"  id="b3"/>
				 $("#b3").click(function(){
				 	$("#one").removeClass("second");
				 });
				 
				 //<input type="button" value=" 切换样式"  id="b4"/>
				 $("#b4").click(function(){
				 	$("#one").toggleClass("second");
				 });
				 
				 //<input type="button" value=" hasClass"  id="b5"/>
				 $("#b5").click(function(){
				 	var $res = $("#one").hasClass("second");
				 	alert($res);
				 });
			</script>
	9、案例
		案例1：
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
				<script type="text/javascript"  src="../js/jquery-3.2.0.js"></script>
				<title>无标题文档</title>
				<style type="text/css">
					BODY{
						font-family:Courier;;
						font-size: 12px;
						margin:0px 0px 0px 0px;
						overflow-x:no;
						overflow-y:no;
						background-color: #B8D3F4;
					}
					td{
						font-size:12px;
					}
					.default_input{
						border:1px solid #666666;
						height:18px;
						font-size:12px;
					}
					.default_input2{
						border:1px solid #666666;
						height:18px;
						font-size:12px;
					}
					.nowrite_input{
						border:1px solid #849EB5;
						height:18px;
						font-size:12px;
						background-color:#EBEAE7;
						color: #9E9A9E;
					}
					.default_list{
						font-size:12px;
					  	border:1px solid #849EB5;
					}
					.default_textarea{
						font-size:12px;
						border:1px solid #849EB5;
					}
					.nowrite_textarea{
						border:1px solid #849EB5;
						font-size:12px;
						background-color:#EBEAE7;
						color: #9E9A9E;
					}
					.wordtd5 {
						font-size: 12px;
						text-align: center;
						vertical-align:top;
						padding-top: 6px;
						padding-right: 5px;
						padding-bottom: 3px;
						padding-left: 5px;
						background-color: #b8c4f4;
					}
					.wordtd {
						font-size: 12px;
						text-align: left;
						vertical-align:top;
						padding-top: 6px;
						padding-right: 5px;
						padding-bottom: 3px;
						padding-left: 5px;
						background-color: #b8c4f4;
					}
					.wordtd_1 {
						font-size: 12px;
						vertical-align:top;
						padding-top: 6px;
						padding-right: 5px;
						padding-bottom: 3px;
						padding-left: 5px;
						background-color: #516CD6;
						color:#fff;
					}
					.wordtd_2{
						font-size: 12px;
						text-align: right;
						vertical-align:top;
						padding-top: 6px;
						padding-right: 5px;
						padding-bottom: 3px;
						padding-left: 5px;
						background-color: #64BDF9;
					}
					.wordtd_3{
						font-size: 12px;
						text-align: right;
						vertical-align:top;
						padding-top: 6px;
						padding-right: 5px;
						padding-bottom: 3px;
						padding-left: 5px;
						background-color: #F1DD34;
					}
					.inputtd
					{
						font-size:12px;
						vertical-align:top;
						padding-top: 3px;
						padding-right: 3px;
						padding-bottom: 3px;
						padding-left: 3px;
					}
					.inputtd2
					{
						text-align: center;
						font-size:12px;
						vertical-align:top;
						padding-top: 3px;
						padding-right: 3px;
						padding-bottom: 3px;
						padding-left: 3px;
					}
					.tablebg
					{
						font-size:12px;
					}
					.tb{
						border-collapse: collapse;
						border: 1px outset #999999;
						background-color: #FFFFFF;
					}
					.td2{
						line-height:22px; 
						text-align:center; 
						background-color:#F6F6F6;
					}
					.td3{
						background-color:#B8D3F4; 
						text-align:center; 
						line-height:20px; 
						width:160px;
					}
					.td4{
						background-color:#F6F6F6;
						line-height:20px;
					}
					.td5{border:#000000 solid;
						border-right-width:0px;
						border-left-width:0px;
						border-top-width:0px;
						border-bottom-width:1px;
					}
					
					.tb td{
						font-size: 12px;
						border: 2px groove #ffffff;
					}
					.noborder {
						border: none;
					}
					.button {
						border: 1px ridge #ffffff;
						line-height:18px;
						height: 20px;
						width: 45px;
						padding-top: 0px;
						background:#CBDAF7;
						color:#000000;
						font-size: 9pt;
					    font-family:Courier;;
					} 
					.textarea {
						font-family: Arial, Helvetica, sans-serif, "??";
						font-size: 9pt;
						color: #000000;
						border-bottom-width: 1px;
						border-top-style: none;
						border-right-style: none;
						border-bottom-style: solid;
						border-left-style: none;
						border-bottom-color: #000000;
						background-color:transparent;
						text-align: left
					}
				</style>
			</head>
			
			<body>
				<div style="border:1px dashed #E6E6E6;margin:150px 0px 0px 450px; width:450px; height:300px; background-color:#E6E6E6;">
					<table width="385" height="169" border="0" align="left" cellpadding="0" cellspacing="0" style="margin:15px 0px 0px 15px;">
					  <tr>
					    <td width="126">
					    	<!--multiple="multiple" 能同时选择多个   size="10"  确定下拉选的长度-->
							<select name="first" size="10" multiple="multiple" class="td3" id="first">
							  <option value="选项1">选项1</option>
							  <option value="选项2">选项2</option>
							  <option value="选项3">选项3</option>
							  <option value="选项4">选项4</option>
							  <option value="选项5">选项5</option>
							  <option value="选项6">选项6</option>
							  <option value="选项7">选项7</option>
							  <option value="选项8">选项8</option>
							</select>    
						</td>
					    <td width="89" valign="middle" align="center">
					       <input name="add"  id="add" type="button" class="button" value="-->" /> 
					       <input name="add_all" id="add_all" type="button" class="button" value="==>" /> 
					       <input name="remove"  id="remove" type="button" class="button" value="&lt;--" />
						   <input name="remove_all" id="remove_all" type="button" class="button" value="&lt;==" />
					    </td>
					    <td width="127" align="left">
						  <select name="second" size="10" multiple="multiple" class="td3" id="second">
					         <option value="选项9">选项9</option>
					      </select>
						</td>
					  </tr>
					</table>
				</div>
			</body>
			
			<script type="text/javascript">
				//left to right
				$("#add").click(function(){
					$("#first option:selected").appendTo($("#second"));
				});
				
				//left to right all
				$("#add_all").click(function(){
					$("#first option").appendTo($("#second"));
				});
				
				//right to left
				$("#remove").click(function(){
					$("#second option:selected").appendTo($("#first"));
				});
				
				//right to left all
				$("#remove_all").click(function(){
					$("#second option").appendTo($("#first"));
				});
			</script>
		案例2：
			<body>
				<center>
					<br><br>
					添加用户:<br><br>
					姓名: <input type="text" name="name" id="name"/>&nbsp;&nbsp;
					email: <input type="text" name="email" id="email" />&nbsp;&nbsp;
					电话: <input type="text" name="tel" id="tel" /><br><br>
					<button id="addUser">提交</button>
					<br><br>
					<hr>
					<br><br>
					<table id="usertable" border="1" cellpadding="5" cellspacing=0>
						<tbody>
							<tr>
								<th>姓名</th>
								<th>email</th>
								<th>电话</th>
								<th>&nbsp;</th>
							</tr>
							<tr>
								<td>Tom</td>
								<td>tom@tom.com</td>
								<td>5000</td>
								<td><a href="javaScript.void(0);">Delete</a></td>
							</tr>
						</tbody>
					</table>
				</center>
			</body>
			
			<script type="text/javascript">
				
				$("#addUser").click(function(){
					var $name = $("#name").val();
					var $email = $("#email").val();
					var $tel = $("#tel").val();
					
					var $tr = $("<tr/>");
					
					var $td1 = $("<td/>");
					$td1.text($name);
					
					var $td2 = $("<td/>");
					$td2.text($email);
					
					var $td3 = $("<td/>");
					$td3.text($tel);
					
					var $td4 = $("<td/>");
					var $a = $("<a/>");
					$a.attr("href","deleteEmp?id="+$name);
					$a.text("Delete");
					
					$a.click(function(){
						var res = confirm("您确定要删除【"+$name+"】吗？");
						if(res){
							$(this).parent().parent().remove();
							return false;
						}
					});
					
					$td4.append($a);
					
					$tr.append($td1).append($td2).append($td3).append($td4);
					
					$("#usertable tbody").append($tr);
				});
			</script>
			
		案例3：
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<title>Untitled Document</title>
				<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
			</head>
			<body>
				<form method="post" action="">
				   	请选择您的爱好!
					<br><input type="checkbox" id="checkedAll_2"/>全选/全不选
				   	<br/>
				    <input type="checkbox" name="items" value="足球"/>足球
					<input type="checkbox" name="items" value="篮球"/>篮球
					<input type="checkbox" name="items" value="游泳"/>游泳
					<input type="checkbox" name="items" value="唱歌"/>唱歌
				   	<br/>
				    <input type="button" id="CheckedAll" value="全　选"/>
				    <input type="button" id="CheckedNo" value="全不选"/>
				    <input type="button" id="CheckedRev" value="反　选"/> 
				
				</form>
			</body>
			
			<script type="text/javascript">
			
				$("#CheckedAll").click(function(){
					$("input[name='items']").attr("checked","checked");
				});
				
				$("#CheckedNo").click(function(){
					$("input[name='items']").attr("checked",null);
				});
				
				$("#CheckedRev").click(function(){
					var items = $("input[name='items']");
					items.each(function(index,domEle){
						$(domEle).attr("checked",!$(domEle).attr("checked"));
					});
				});
				
				$("#checkedAll_2").click(function(){
					var a = $("input[name='items']").attr("checked",$("#checkedAll_2").attr("checked"));
				});
			</script>
		案例4：
			<head>
			    <title>获得焦点和失去焦点</title>
			    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
				<script language="JavaScript" src="../js/jquery-3.2.0.js"></script>
				<style type="text/css">
					 input[type='text'],input[type='password']{
					 	width:200px;
					 	height:30px;
					 }
					 input{
					 	margin:10px;
					 }
				</style>
			</head>
			<body>
				 <input type="text" value="用户邮箱/手机号/用户名"  id="b1"/><br>
			</body>
			
			<script type="text/javascript">
			
				$("#b1").focus(function(){
					$(this).val("");
				});
				
				$("#b1").blur(function(){
					if($(this).val().trim()==""){
						$(this).val(this.defaultValue);
					}
				});
			</script>
四、jQuery的表单校验
	1、简介
		jquery有很多丰富的插件供用户使用，表单验证插件就是其中一款,
		
		使用此插件可以很方便的对表单进行校验并可以自定义提示信息，自定义校验方法等操作
		
	2、导入插件的步骤
		(1) 将jquery的原始文件和插件文件jquery.validate.js导入到工程中
			例如：
				<script src="../js/jquery-3.2.0.js" type="text/javascript"></script>
				<script src="./js/jquery.validate.js" type="text/javascript"></script>
				
		(2) 编写js代码对表单进行验证
	
	3、表单验证的格式
		$("form表单的选择器").validate({json数据格式});//键值对  键：值（{}）
		json数据格式：
			{
				rules:{
				            表单项name值:校验规则，
				            表单项name值:校验规则... ...
				},
				messages:{
				            表单项name值:错误提示信息，
				            表单项name值:错误提示信息... ...
				}
			}
		注意：
			校验规则，可以是一个也可以是多个，如果是多个使用json格式(加{})
			
	4、常用校验规则如下
		见图1
	
	5、注意
		当错误提示信息不按照我们预想的位置显示时，我们可以按照如下方式进行设置
		
		自定义错误显示标签放在我们需要显示的位置，当此表单项验证不通过时会将此信息自动显示出来，
		
		jquery验证插件会自动帮助我们控制它的显示与隐藏
		
		<lable for="html元素name值" class="error" style="display:none">错误信息</lable>
			属性解释：
				class="error"：固定的
				for="gender"：为哪一个标签服务的(写的是html元素name属性值)
						
		如果设置了错误lable标签就不必在messages中设置此表单项错误提示信息了
	
	6、如果预定义的校验规则尚不能满足需求的话可以进行自定义校验规则
		6.1、自定义校验规则步骤如下
			(1) 使用$.validator.addMethod("校验规则名称",function(value,element,params)){}
			
			(2) 在rules中通过校验规则名称使用校验规则
			
			(3) 在messages中定义该规则对应的错误提示信息
			
			其中： 
				value是校验组件的value值
				
				element是校验组件的节点对象
				
				params是校验规则的参数
				
		6.2、例如
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
						cart:{
							required:true,
							IDCardValidate:[15,18],
							IDCardNumValidate:true,
							IDCardNumAndCharValidate:true
						}
					},
					messages:{
						cart:{
							required:"请输入身份证信息",
							IDCardValidate:"身份证必须是15位或18位",
							IDCardNumValidate:"15位必须都是数字",
							IDCardNumAndCharValidate:"18位都是数字或者末尾是X"
						}
					}
				});
			});

	7、案例
		见表单校验小案例

五、jQuery的ajax

































































