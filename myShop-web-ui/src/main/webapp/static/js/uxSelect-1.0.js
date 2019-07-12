/* uxSelect1.0版本，点击时从侧边弹出可滑动选择的选择列表
 * edit by Mr.AndrewBlack 2016.03.02
 * 插件基于jQuery-1.8.3及百度touchjs两个库而开发
 * 最新修改：增加确定和取消按钮的回调函数_2016.11.17
 * 
 * 用法如下
 * $(idSelector).uxTouchSelect({
 *	   fillId:"",
 *     itemArr:[{id:ID,name:NAME},{id:ID,name:NAME},{id:ID,name:NAME},{id:ID,name:NAME}]
 * },func1,func2);

 * func1_确定函数，可选
 * func2_取消函数，可选
 * options_配置项
 * idSelector_触发选择元素的id，只能使用id
 * fillId_可选参数，选择选项后填充的元素的id，若不传入此参数，则所选项直接填入触发选择元素内
 * itemArr_选择项数组，数组长度必须大于1个，即至少有两项内容，否则报错
 */

;(function($){
	$.fn.uxTouchSelect = function(options,func1,func2) { //定义插件的名称
		var dft={
			//clickId:"", //触发弹框的ID
			fillId:"",  //选择后将内容填充到元素的ID
			itemArr:[]  //选择项数组
		};
		var ops=$.extend(dft,options);
		var that=$(this);
		
		if(ops.itemArr.length==0){
			alert("参数有误");
			return;
		}
		//第二次重新填充数据时需要将取消绑定原来的数据才能正确显示第二次绑定的数据
		that.unbind("click");
		that.on("click",init);
		
		//初始化函数，将主体填入页面内
		function init(){
			if($("div.ux-selectWrap").length){
				return;
			}
			//window.stopR.stopResfresh();
			var htmls=[],sId="",obj;
			htmls.push('<div class="ux-selectWrap">');
			htmls.push('	<div class="ux-selectWrapInner">');
			htmls.push('		<div class="ux-selectTitle">');
			htmls.push('			<a href="javascript:;" id="js_cancelSelect">取消</a>');
			htmls.push('			<a href="javascript:;" id="js_sureSelect">确定</a>');
			htmls.push('		</div>');
			htmls.push('		<div class="ux-selectBox" id="js_selectWrap">');
			htmls.push('			<ul id="js_selectItems">');
			if(ops.fillId==""){
				obj=that;
			}
			else{
				obj=$("#"+ops.fillId);
			}
			sId=obj.attr("data-id");
			for(var i=0;i<ops.itemArr.length;i++){
				if(sId==ops.itemArr[i].id){
					obj.attr("data-index",i);
					htmls.push('<li data-index="'+i+'" data-id="'+ops.itemArr[i].id+'">'+ops.itemArr[i].name+'</li>');
				}
				else{
					htmls.push('<li data-id="'+ops.itemArr[i].id+'">'+ops.itemArr[i].name+'</li>');
				}
			}
			htmls.push('</ul></div></div></div>');
			$("body").append(htmls.join(""));
			$("html").css("overflow","hidden");
			moveFunc();
		}
		
		function moveFunc(){
			//时间轴的移动
			var dy,                   //记录已经移动的距离
				moveIndex=0,          //记录当前是哪一个被选中
				thatIndex="",         //原先已选项的Index值
				SINGLEHEIGHT=36,      //常量，每一个项的高度
				itemLength=$("#js_selectItems").find("li").length,    //选择项的长度，至少要有两个选择项
				target = document.getElementById("js_selectItems"); 
			
			if(ops.fillId==""){
				thatIndex=that.attr("data-index");
			}
			else{
				thatIndex=$("#"+ops.fillId).attr("data-index");
			}
			
			//第一次选择的时候
			if(thatIndex==undefined){
				//只有两个选项
				if(itemLength==2){
					target.style.webkitTransform = "translate3d(0,36px,0)";
					dy=36;
					moveIndex=1;
				}
				else if(itemLength==1){
					target.style.webkitTransform = "translate3d(0,72px,0)";
					dy=72;
					moveIndex=0;
				}
				else{
					moveIndex=2;
				}
				$("#js_selectItems").find("li").eq(moveIndex).addClass("js_selectItem");
			}
			else{
				if(thatIndex>itemLength){//至少能够说明数据已经发生变化，moveIndex只需要改变
					moveIndex=0;
				}
				else{
					moveIndex=thatIndex;
				}
				dy=(2-moveIndex)*36;
				target.style.webkitTransform = "translate3d(0,"+dy+"px,0)";
				$("#js_selectItems").find("li").eq(moveIndex).addClass("js_selectItem");
			}
			
			touch.on('#js_selectItems', 'touchstart', function(ev){
				ev.preventDefault();
			});
			touch.on('#js_selectItems', 'drag', function(ev){
				ev.stopPropagation();
				dy = dy || 0;
				var offy = dy + ev.y;
				target.style.webkitTransform = "translate3d(0,"+offy+"px,0)";
			});
			touch.on('#js_selectItems', 'dragend', function(ev){
				moveIndex=0;
				dy += ev.y;
				//往下移动，只有第一个或者第二个会被选中
				if(dy>0){
					if(dy<SINGLEHEIGHT*(1.5)){
						target.style.webkitTransform = "translate3d(0,36px,0)";
						dy=36;
						moveIndex=1;
					}
					else{
						target.style.webkitTransform = "translate3d(0,72px,0)";
						dy=72;
						moveIndex=0;
					}
				}
				//向上移动，根据li的个数计算
				else{
					//最后一个
					if(dy<SINGLEHEIGHT*(itemLength-3.5)*(-1)){
						dy=SINGLEHEIGHT*(itemLength-3)*(-1);
						target.style.webkitTransform = "translate3d(0,"+dy+"px,0)";
						moveIndex=itemLength-1;
					}
					else{
						moveIndex=Math.round(dy/SINGLEHEIGHT)*(-1);
						dy=SINGLEHEIGHT*moveIndex*(-1);
						target.style.webkitTransform = "translate3d(0,"+dy+"px,0)";
						moveIndex+=2;
					}
				}
				
				//如果只有一个
				if(itemLength==1){
					moveIndex=0;
					dy=72;
					target.style.webkitTransform = "translate3d(0,72px,0)";
				}
				
				//给选中的item添加class
				$("#js_selectItems").find("li").eq(moveIndex).addClass("js_selectItem");
				$("#js_selectItems").find("li").eq(moveIndex).siblings().removeClass("js_selectItem");
			});
			
			//点击取消按钮的时候
			$("#js_cancelSelect").on("click",function(){
				$("div.ux-selectWrap").remove();
				$("html").css("overflow","");
				if(func2 && func2 instanceof Function){
					func2();
				}
			});
			//点击确定按钮的时候
			$("#js_sureSelect").on("click",function(){
				var selectItem=$("#js_selectItems").find("li").eq(moveIndex),
					selectName=selectItem.html(),
					selectId=selectItem.attr("data-id"),
					fillEle=$("#"+ops.fillId);
				if(ops.fillId==""){
					that.attr("data-index",moveIndex);
					if(that.get(0).tagName.toLowerCase()=="input"){
						that.val(selectName).attr("data-id",selectId);
					}
					else{
						that.html(selectName).attr("data-id",selectId);
					}
				}
				else{
					fillEle.attr("data-index",moveIndex);
					if(fillEle.get(0).tagName.toLowerCase()=="input"){
						fillEle.val(selectName).attr("data-id",selectId);
					}
					else{
						fillEle.html(selectName).attr("data-id",selectId);
					}
				}
				$("div.ux-selectWrap").remove();
				$("html").css("overflow","");
				if(func1 && func1 instanceof Function){
					func1();
				}
			});
		}
	}
})(jQuery);