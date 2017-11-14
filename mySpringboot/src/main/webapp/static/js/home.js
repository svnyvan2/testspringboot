
var _home = {
		init:function(){
//			this.initLayout() ;
			this.bingEvent();
			
		},
		initLayout:function(){
			$('body').layout({
				applyDefaultStyles: false,
				sliderCursor:"default", //禁用边缘游标指示
				slideTrigger_open:"dblclick1", //填入无效参数，禁用效果("click", "dblclick", "mouseover") 
				sliderTip:"",//去除边缘提示语
				north__closable: false,//可以被关闭 
				north__size:150,
				spacing_open:0
			});
			$('body>.ui-layout-center').layout({
				applyDefaultStyles: false,
				togglerContent_closed: "<img src='/tt/static/images/left-close-bar.png' style='width:8px;height:48px;'/>",
				togglerContent_open: "<img src='/tt/static/images/right-open-bar.png' style='width:8px;height:48px;'/>",
				west__size:200,
				west__closable: true,//可以被关闭 
				sliderCursor:"default", //禁用边缘游标指示
				slideTrigger_open:"dblclick1", //填入无效参数，禁用效果("click", "dblclick", "mouseover") 
				sliderTip:"",//去除边缘提示语
				spacing_open:8
			});
		},
		bingEvent:function(){
              $(".span-door").click(function(){
            	  if($(this).hasClass("open")){
            		  $(this).removeClass("open").addClass("close");
            		  $(".div-class-south-west").css("left","-200px");
            		  $(".custom-btn").css("left","0px");
            		  $(".div-class-south-east").css("margin-left","0px");
                  }else{
                	  $(this).removeClass("close").addClass("open");
                	  $(".custom-btn").css("left","200px");
                	  $(".div-class-south-west").css("left","0px");
                	  $(".div-class-south-east").css("margin-left","200px");
                  }
              }) ;
              $("#btn").click(function(){
            	  $("#mainFrame").load("test/test2");
              });
		}
}



$(function(){
	_home.init() ;
});