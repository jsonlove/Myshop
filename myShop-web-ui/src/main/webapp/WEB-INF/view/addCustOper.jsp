<%@ page language="java" pageEncoding="UTF-8"%>
<html>
  <head>
  		<%@ include file="../common/heads.jsp"%>
        <title>添加收银员</title>
        <!--选择网点弹出层样式-->
        <link href="${ctxStatic}css/uxSelect-1.0.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  		<header class="h b-b mb10">
            <a href="javascript:history.back(-1);" class="iconfont icon-fanhui"></a>
            <h1>添加收银员</h1>
        </header>
        <section>
        <div class="casher-fillIn">
        		<input hidden="hidden" value="${custId }" id="custId">
                <ul>
                    <li class="ux-media b-b">
                        <div class="ux-box">
                            <div class="item-left"><h3>姓名</h3></div>
                            <div class="item-body">
                                <input type="text"
                                	onkeyup="value=value.replace(/[^\w\u4E00-\u9FA5]/g,'') "
                                	onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d\u4E00-\u9FA5]/g,''))"
	                                name="custOper.operName" maxlength="8"  id="operName" value="" placeholder="请输入收银员姓名" class="ux-input js_need"/>
	                               <!--  onkeyup="value=value.replace(/[\W]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" -->
                            </div>
                        </div>
                    
                    </li>
                    <li class="ux-media b-b">
                        <div class="ux-box">
                            <div class="item-left"><h3>登录名</h3></div>
                            <div class="item-body">
                            <input type="text" onkeyup="value=value.replace(/[^\w\u4E00-\u9FA5]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d\u4E00-\u9FA5]/g,''))"
                              name="custOper.loginName" maxlength="8" id="loginName" value="" placeholder="请输入收银员登录名" class="ux-input js_need"/>  
                                <!-- <input type="text"onkeypress="return /[\W][\w\u4E00-\u9FA5]/.test(String.fromCharCode(window.event.keyCode))" 
                                    onpaste="return !/[\W][^\w\u4E00-\u9FA5]/g.test(window.clipboardData.getData('Text'))" 
                                    name="custOper.loginName" maxlength="8" id="loginName" value="" placeholder="请输入收银员登录名" class="ux-input js_need"/> -->
                            </div>
                        </div>
                    </li>
                      <li class="ux-media b-b"> 
                        <div class="ux-box"> 
                             <div class="item-left"><h3>初始密码</h3></div> 
                             <div class="item-body"> 
                                 <input type="text" name="custOper.password" maxlength="6" id="password" value="000000" disabled="disabled" class="ux-input js_need"/> 
                             </div> 
                         </div> 
                          </li> 
                    <li class="ux-media b-b">
                        <div class="ux-box">
                            <div class="item-left"><h3>手机号码</h3></div>
                            <div class="item-body">
                                <input type="text" name="custOper.telno" id="telNo" value="" placeholder="请输入收银员手机号码" class="ux-input js_need" maxlength="11"/>
                            </div>
                        </div>
                    </li>
                    <li class="ux-arrow b-b">
                        <div class="ux-box">
                            <div class="item-left">
                                <h3>所属网点</h3>
                            </div>
                            
                            <div class="item-body" id="js_businessType">
                            		<input type="hidden" id="typfFillin" value=""  />
					            	<input type="text" id="js_typfFillin" value=""  placeholder="请选择收银员所属网点"  readonly="readonly" class="ux-input js_net"/>
                            </div>
                        </div>
                    </li>
                    <li class="ux-media">
                        <div class="ux-box">
                            <div class="item-left"><h3>类型</h3></div>
                            <div class="item-body">
                                <p>
                                	 <c:if test="${shopType == '2'}">
                                	 	<input type="hidden" name="custOper.operType" id="opertype" value="1">
                                	 	<span>特惠</span> 
                                	 </c:if>
                                	  <c:if test="${shopType == ''}">
                                	 	<input type="hidden" name="custOper.operType" id="opertype" value="3">
                                	 	<span>网点自提</span> 
                                	 </c:if>
                                	<!-- <span class="u-check m-check">
                                        <input type="checkbox" id="checkbox1" class="checkbox">
                                        <label for="check1" class="">团购</label>
                                    </span> -->
<!--                                 	<span class="u-check m-check"> -->
<!--                                         <input type="checkbox" id="checkbox2" class="checkbox"> -->
<!--                                         <label for="check2" class="">线下</label> -->
<!--                                     </span> -->
                                	<!-- <span class="u-check m-check">
                                        <input type="checkbox" id="checkbox3" class="checkbox">
                                        <label for="check3" class="">网点自提</label>
                                    </span> -->
                                </p>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="casher-fillBtnWrap">
            	 <a id="btn-sub" href="javascript:;" class="btn btn-main btn-disable">确认</a>
            </div>

        </section>        
  </body>
    <!--滑动手机屏幕js-->
    <script src="${ctxStatic}js/touchjs.min.js"></script> 
    <!--弹出层选择网点js样式-->
    <script src="${ctxStatic}js/uxSelect-1.0.js"></script>     
    <script type="text/javascript"> 
    	var storeArray = new Array();
    	var storeId = "";
        $(function(){
        	 $.ajax({
  		        url:"/emcapp/custOper/queryCustOperStore",    //请求的url地址
  		        dataType:"json",   //返回格式为json
  		        async:true,//请求是否异步，默认为异步，这也是ajax重要特性
  		        data:{"custId":$("#custId").val()},    //参数值
  		        type:"post",   //请求方式
  		        success:function(req){
  			       	 if(null != req.stores){
	  			       	$.each(req.stores,function(i,s){
	  			       		storeArray[i] = {"id":s.storeId , "name":s.storeName};
	  					});
	  			        //选择网点
	  			        $("#js_businessType").uxTouchSelect({
	  			        	fillId:"js_typfFillin",
	  				        itemArr:storeArray
	  			        },getVerifyHistoryDate);  
  			     	 }else{
  			     		uxun.tipsBox("你还未有网点,请先添加");
  	  		            setTimeout("window.location.href ='/emcapp/custstore/queryCustStore'; ",1000); 
  			     	 }
  		        },
  		        error:function(){
  		        	uxun.tipsBox("查询失败");
  		        }
  		        
  		    });
        });
      
        function getVerifyHistoryDate(){
        	storeId = $("#js_typfFillin").attr('data-id');
        	$("#typfFillin").val(storeId);
        }
        //激活按钮
        var flag=false;
        var netTimeout=setInterval(function(){
            if($(".js_net").val()){
                flag=true;
                checkInput();
                clearInterval(netTimeout);
            }
        },100); 
        
        function checkInput(){
            $(".js_need").on("input",function(){
                active();
            })
            $(".u-check input").on("change",function(){
                active();
            })
            active();
            function active(){
                var n=$(".js_need").length;
                var flag=true;
                for(var i=0;i<n;i++){
                    if($(".js_need").eq(i).val()==""){
                        flag=false;break;
                    }
                }
                //检查checkbox中是否全部没选
             /*    var check_num=$(".u-check input").length;
                var check_flag=0;
                for(var j=0;j<check_num;j++){
                    if(!$(".u-check input").eq(j).attr("checked")){
                        check_flag++;
                    }                   
                } */
                //如果全部没选中
               /*  if(check_flag==check_num){flag=false;} */
                if(flag){
                	$(".casher-fillBtnWrap .btn").attr("disabled",false);
                    $(".casher-fillBtnWrap .btn").removeClass("btn-disable");
                }else{
                	$(".casher-fillBtnWrap .btn").attr("disabled","disabled");
                    $(".casher-fillBtnWrap .btn").addClass("btn-disable");
                }
            } 
        }    
        
        //点击添加
        $("#btn-sub").click(function(){
        	var result = $(this).attr("disabled");
        	if(result == "disabled"){
        		return false;
        	}
        	/*  var checkbox1 = $("#checkbox1").attr("checked");
        	var checkbox2 = $("#checkbox2").attr("checked");
        	var checkbox3 = $("#checkbox3").attr("checked"); */
        	var reg = new RegExp("[`~!@#$^&*=|{}''\\[\\].<>/?~！@#+%￥……&*;—|{}【】()‘”“'？{0-9}]");
            var value = $("#operName").val();
        	if(reg.test(value)){
        		uxun.tipsBox("不能包含非法字符和数字");
        		$("#operName").val("");
        		return false;
        	}else if (value == "") {
                uxun.tipsBox("收银员名称不能为空");
                return false;
            }
        	if(!(/^1\d{10}$/.test($("#telNo").val()))){
        		uxun.tipsBox("手机号格式错误");
        		$("#telNo").val("");
        		return false;
        	}
        	/*if(checkbox1 == "checked"){
        		$("#opertype").val("1");
        	}
        	if(checkbox2 == "checked"){
        		$("#opertype").val("2");
        	}
        	if(checkbox3 == "checked"){
        		$("#opertype").val("3");
        	}
        	if(checkbox1 == "checked" && checkbox2 == "checked"){
        		$("#opertype").val("1,2");
        	}
        	if(checkbox2 == "checked" && checkbox3 == "checked"){
        		$("#opertype").val("2,3");
        	}
        	if(checkbox1 == "checked" && checkbox3 == "checked"){
        		$("#opertype").val("1,3");
        	}
        	if(checkbox1 == "checked" && checkbox2 == "checked"){
        		$("#opertype").val("1,2");
        	}
        	if(checkbox1 == "checked" && checkbox2 == "checked" && checkbox3 == "checked"){
        		$("#opertype").val("1,2,3");
        	} */
            $.ajax({
                url:"/emcapp/custOper/saveCustOper",    //请求的url地址
                dataType:"json",   //返回格式为json
                async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                data:{
                    "custId":$("#custId").val(),
                    "operName":$("#operName").val(),
                    "loginName":$("#loginName").val(),
                    "telno":$("#telNo").val(),
                    "storeId":$("#typfFillin").val(),
                    "operType":$("#opertype").val(),
                    "password":$("#password").val()
                },    //参数值
                type:"post",   //请求方式
                success:function(req){
                    if(req.message=="0002"){
                        uxun.tipsBox("登录名已存在");
                        setTimeout("",1000);
                    }else if(req.message=="0001"){
                        uxun.tipsBox("添加失败");
                        setTimeout("",1000);
                    }else if(req.message=="0000"){
                        uxun.tipsBox("添加成功");
                        setTimeout("window.location.href ='/emcapp/custOper/custOperIndex'; ",1000);
                    }
                },
                error:function(){
                    uxun.tipsBox("添加失败");
                }
            });
        	//return true;
        });
      
    </script>
 </html>
	

