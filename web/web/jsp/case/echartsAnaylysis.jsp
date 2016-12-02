<%@ page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<link type="text/css" href="<%=path%>/css/eChartCss/jquery.fullPage.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/css/eChartCss/jquery.fullPage-arti.css" rel="stylesheet" />
	</head>
	<body style="background: #F2F2F2 none repeat scroll 0% 0%;">
	   <!-- 头部导航开始 -->
    <header class="hd">
        <div class="inner">
            <a class="logo"></a>
            <nav>
                <ul class="menu">
                    <li data-menuanchor="page1" class="active" style ="float:left;"><a href="#page1">总体概览</a></li>
                    <li data-menuanchor="page2"><a href="#page2" style ="float:left;">基层法院概览</a></li>
                    <li data-menuanchor="page3"><a href="#page3" style ="float:left;">审判程序类型</a></li>
                   
                <!--<li data-menuanchor="page3"><a href="#page3" style ="float:left;">瑕疵分布</a></li>
                    <li data-menuanchor="page4"><a href="#page4" style ="float:left;">审判程序类型</a></li>
                    <li data-menuanchor="page5"><a href="#page5" style ="float:left;">程序变更因素</a></li> -->
                </ul>
            </nav>
        </div>
    </header>
    <!-- 头部导航结束 -->

    <!-- 主体开始 -->
    <div class="con">
        <div class="section s1 active">
            <div id="graphA" style="width:95%;height:318px;display:inline;float:left;margin:60px 0px 0px 10px;"></div>
            <div id="graphB" style="width:55%;height:280px;display:inline;float:left;margin:10px 0px 0px 20px;"></div>
           	<div id="graphC" style="width:34%;height:280px;display:inline;float:left;margin:10px 0px 2px 20px;"></div>
        </div>
		<div class="section s2">
           	  <div id="errorContent" style="width:55%;height:320px;display:inline;float:left;margin:60px 0px 0px 20px;">
	         	<select id="court" name="court" style = "margin-left:2%"> 
	               <option value="上海市高级人民法院">上海市高级人民法院</option>
	               <option value="上海海事法院">上海海事法院</option> 
	               <option value="上海知识产权法院">上海知识产权法院</option> 
	               <option value="上海市徐汇区人民法院" selected = "selected">上海市徐汇区人民法院</option>
	               <option value="上海市长宁区人民法院">上海市长宁区人民法院</option> 
	               <option value="上海市闵行区人民法院">上海市闵行区人民法院</option> 
	               <option value="上海市浦东新区人民法院">上海市浦东新区人民法院</option> 
	               <option value="上海市奉贤区人民法院">上海市奉贤区人民法院</option> 
	               <option value="上海市松江区人民法院">上海市松江区人民法院</option> 
	               <option value="上海市金山区人民法院">上海市金山区人民法院</option> 
	               <option value="上海市黄浦区人民法院">上海市黄浦区人民法院</option> 
	               <option value="上海市静安区人民法院">上海市静安区人民法院</option> 
	               <option value="上海市普陀区人民法院">上海市普陀区人民法院</option> 
	               <option value="上海市闸北区人民法院">上海市闸北区人民法院</option> 
	               <option value="上海市虹口区人民法院">上海市虹口区人民法院</option>
	               <option value="上海市杨浦区人民法院">上海市杨浦区人民法院</option>
	               <option value="上海市宝山区人民法院">上海市宝山区人民法院</option>
	               <option value="上海市嘉定区人民法院">上海市嘉定区人民法院</option>
	               <option value="上海市青浦区人民法院">上海市青浦区人民法院</option>
	               <option value="上海市崇明县人民法院">上海市崇明县人民法院</option>
	               <option value="上海铁路运输法院">上海铁路运输法院</option>  
	            </select>
           		<button id="courtButton" type="button" class='rb1'>查询</button>
           		<div id="graphD" style="width:99%;height:320px;display:inline;float:left;margin:0px 0px 0px 20px;"></div>
         	</div>
           	<div id="graphF" style="width:34%;height:270px;display:inline;float:left;margin:90px 0px 0px 20px;"></div>
           	<div id="graphE" style="width:55%;height:320px;display:inline;float:left;margin:10px 0px 0px 20px;"></div>
           	<div id="graphG" style="width:34%;height:270px;display:inline;float:left;margin:10px 0px 0px 20px;"></div>
             <!-- <div id="graphC" style="width:34%;height:32px;display:inline;float:left;margin:10px 20px 2px 10px;"></div>
              <div id="graphD" style="width:34%;height:320px;display:inline;float:left;margin:10px 0px 0px 20px;"></div>
            <div id="graphE" style="width:34%;height:320px;display:inline;float:left;margin:10px 0px 0px 20px;"></div>-->
        </div>


        <!-- 第二页 -->
        <!--<div class="section s2">
            <div id="courtRate" style="width:50%;height:600px;display:inline;float:left;margin:80px 10px 0px 10px;"></div>
            <div id="causeRate" style="width:50%;height:600px;display:inline;float:left;margin:80px 0px 0px -40px;"></div>
        </div>-->

        <!-- 第三页 -->
        <!--<div class="section s3">
            <div id="errorbar" style="width:50%;height:600px;display:inline;float:left;margin:80px 0px 0px 10px;"></div>
            <div id="errorpie" style="width:50%;height:600px;display:inline;float:left;margin:80px 0px 0px -80px;"></div>           
        </div>-->

        <!-- 第二页 -->
        <div class="section s3">
        <!--<div id="judgeall" style="width:50%;height:600px;display:inline;float:left;margin:80px 20px 0px 10px;"></div>
            <div id="judgezoom" style="width:80%;height:600px;margin:80px auto 0px auto;">-->
            <div id="judgeall" style="width:48%;height:600px;display:inline;float:left;margin:80px 10px 0px 10px;"></div>
            <div id="judgezoom" style="width:48%;height:600px;display:inline;float:left;margin:80px 5px 0px 5px;">
           	<select id="courtName" name="courtName"> 
               <option value="上海市高级人民法院">上海市高级人民法院</option>
               <option value="上海海事法院">上海海事法院</option> 
               <option value="上海知识产权法院">上海知识产权法院</option> 
               <option value="上海市徐汇区人民法院" selected = "selected">上海市徐汇区人民法院</option> 
               <option value="上海市长宁区人民法院">上海市长宁区人民法院</option> 
               <option value="上海市闵行区人民法院">上海市闵行区人民法院</option> 
               <option value="上海市浦东新区人民法院">上海市浦东新区人民法院</option> 
               <option value="上海市奉贤区人民法院">上海市奉贤区人民法院</option> 
               <option value="上海市松江区人民法院">上海市松江区人民法院</option> 
               <option value="上海市金山区人民法院">上海市金山区人民法院</option> 
               <option value="上海市黄浦区人民法院">上海市黄浦区人民法院</option> 
               <option value="上海市静安区人民法院">上海市静安区人民法院</option> 
               <option value="上海市普陀区人民法院">上海市普陀区人民法院</option> 
               <option value="上海市闸北区人民法院">上海市闸北区人民法院</option> 
               <option value="上海市虹口区人民法院">上海市虹口区人民法院</option>
               <option value="上海市杨浦区人民法院">上海市杨浦区人民法院</option>
               <option value="上海市宝山区人民法院">上海市宝山区人民法院</option>
               <option value="上海市嘉定区人民法院">上海市嘉定区人民法院</option>
               <option value="上海市青浦区人民法院">上海市青浦区人民法院</option>
               <option value="上海市崇明县人民法院">上海市崇明县人民法院</option>
               <option value="上海铁路运输法院">上海铁路运输法院</option>  
            </select>
            <!--<select id="judge" name="judge"> 
               <option value="G">合议庭</option> 
               <option value="S" selected = "selected">独任审理</option> 
            </select>-->
            <button id="refresh" type="button" class='rb1'>查询</button>
            <div id="judgedetail" style="width:100%;height:92%;margin-top: 20px;"></div>
           </div>
        </div>

 		

        <!-- 第五页 -->
        <!-- <div class="section s5">
            <div id="judgetrans" style="width:80%;height:600px;margin:80px auto 0px auto;"></div>
        </div> -->
    </div>
    
	<script type="text/javascript" src="<%=path%>/js/echartJs/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/echartJs/echarts.js"></script>
  	<script type="text/javascript" src="<%=path%>/js/echartJs/macarons.js"></script>
	<script type="text/javascript" src="<%=path%>/js/echartJs/jquery.fullPage.min.js"></script>
	<script type="text/javascript">
	var path = '<%=path%>';
	$(document).ready(function(){
       //myMap('mapA','mapB',path+'/JSON/shanghai.json',path+'/echartsAnalysis_initEchartDetail.do',path+'/echartsAnalysis_initEchartYearRateDetail.do');
      
       myGraph('graphA','graphB','graphC','graphD','graphE','graphF','graphG',path+'/echartsAnalysis_initEchartRankDetail.do',path+'/echartsAnalysis_initEchartYearRateDetail.do',path+'/echartsAnalysis_initEchartContentAndNumBycourtAndJudgeDetail.do',path+'/echartsAnalysis_initEchartCourtRoomRateBycourt.do',path+'/echartsAnalysis_initEchartJudgeNamRateBycourtAndRoom.do',path+'/echartsAnalysis_initEchartContentAndNumBycourtAndJudgeDetail.do',path+'/echartsAnalysis_initEchartContentAndNumBycourtAndJudgeDetail.do');
       //errorBar('errorbar','errorpie',path+'/echartsAnalysis_initEchartContentAndNumDetail.do');
       judgeAll ('judgeall',path+'/JSON/judgeall.json');
       judgeDetail('judgedetail',path+'/echartsAnalysis_initEchartCourtYearRateBycourtAndTrialProduce.do');
       $('.con').fullpage({
            navigation: true,
            anchors: ['page1', 'page2','page3'],
            menu: '.menu',
            navigationTooltips: ['总体概览','基层法院概览','审判程序类型',],
            verticalCentered:false,
        });
       //judgeTrans('judgetrans');
       /*$('.con').fullpage({
            navigation: true,
            anchors: ['page1', 'page2', 'page3', 'page4', 'page5'],
            menu: '.menu',
            navigationTooltips: ['总体概览','文书分布','瑕疵分布','审判程序类型','程序变更因素',],
            verticalCentered:false,
        });*/
    });

    function myGraph(elementA,elementB,elementC,elementD,elementE,elementF,elementG,elementAPath,elementBPath,elementCPath,elementDPath,elementEPath,elementFPath,elementGPath){
       // 基于准备好的dom，初始化echarts实例
       var myGraphA = echarts.init(document.getElementById(elementA));
       var myGraphB = echarts.init(document.getElementById(elementB),'macarons');
       var myGraphC = echarts.init(document.getElementById(elementC));
       var myGraphD = echarts.init(document.getElementById(elementD),'macarons');
       var myGraphE = echarts.init(document.getElementById(elementE),'macarons');
       var myGraphF = echarts.init(document.getElementById(elementF),'macarons');
        var myGraphG = echarts.init(document.getElementById(elementG),'macarons');
       var initCourtName = '上海市徐汇区人民法院';
       var initRoomName = '民一庭';
       myGraphA.showLoading();
       myGraphB.showLoading();
       myGraphC.showLoading();
       myGraphD.showLoading();
       myGraphE.showLoading();
       myGraphF.showLoading();
       myGraphG.showLoading();

       // 异步加载数据
       $.getJSON(elementAPath).done(function (data) {
           myGraphA.hideLoading();

           var categoryData = [];
           var barData = [];
           $.each(data.d.errorRankRateDetailDtoList,function(key,value){
                 categoryData=value.courtArray;
                 barData=value.errorRateArray;
           })
           
          myGraphA.setOption({
              title:{
                  text:'上海市法院文书瑕疵率(%)',
                  textStyle: {
                       color: '#777',
                       fontSize: 16,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   x: 'center'
              },
              tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>瑕疵率：{c}%'
              },
              grid: {
                  left: '3%',
                  right:'5%',
                  bottom:'22%'
              },
              /*dataZoom : {
                  show : true,
                  realtime : true,
                  start : 0,
                  end : 100
              },*/
              yAxis: {
                  type: 'value',
                  name:'(%)',
                  nameGap: 10,
                  scale: true,
                  position: 'top',
                  boundaryGap: false,
                  splitLine: {show: true},
                  axisLine: {show: false},
                  axisTick: {show: false},
                  nameTextStyle: {
                    color: '#777	',
                    fontSize: 12
                  },
                  axisLine: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  axisTick: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  axisLabel: {
                      textStyle: {
                          color: '#777',
                          fontStyle: 'normal',
                          fontWeight:  'bold'
                      }
                  },
              },
              xAxis: {
                  type: 'category',
                  name: '名称',
                  nameLocation: 'end',
                  nameTextStyle: {
                      color: '#777',
                      fontSize: 12,
                      fontStyle: 'normal'
                  },
                  axisLine: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  splitLine: {show: false},
                  axisTick: {show: false},
                  axisLabel: {
                      interval:0,
                      formatter: function(val){return val.replace(/[\r\n]/g,"").replace(/(上海)|(市)|(人民)|(法院)/g,"")},
                      textStyle: {
                          color: '#777',
                          fontSize: 12,
                          fontStyle: 'normal',
                          /*fontWeight:  'bold'*/
                      },
                      /*rotate:45*/
                  },
                  data: categoryData
              },
              series: [
                  {
                      name: 'courts',
                      type: 'bar',
                      symbol: 'none',
                      itemStyle: {
                          normal: {
                              color: '#ddb926'
                          }
                      },
                      data: barData
                  }
              ]
           });

       });

       $.getJSON(elementBPath).done(function (data) {
           myGraphB.hideLoading();

           var categoryData = [];
           var barData = [];
           $.each(data.d.errorYearRateList,function(key,value){
              if(value.courtName = initCourtName){
                 categoryData=value.yearArray;
                 barData=value.errorRateArray;
              }
           })
           
           myGraphB.setOption({
              title:{
                  text:'徐汇法院瑕疵率分布(%)',
                  textStyle: {
                       color: '#777',
                       fontSize: 16,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   x: 'center'
              },
              tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>瑕疵率：{c}%'
              },
              grid: {
                  left: '4%'
              },
              dataZoom : {
                  show : true,
                  realtime : true,
                  start : 0,
                  end : 100
              },
              yAxis: {
                  type: 'value',
                  name:'(%)',
                  nameGap: 10,
                  scale: true,
                  position: 'top',
                  boundaryGap: false,
                  splitLine: {show: true},
                  axisLine: {show: false},
                  axisTick: {show: false},
                  nameTextStyle: {
                    color: '#777',
                    fontSize: 12
                  },
                  axisLine: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  axisTick: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  axisLabel: {
                      textStyle: {
                          color: '#777',
                          fontStyle: 'normal',
                          fontWeight:  'bold'
                      }
                  },
              },
              xAxis: {
                  type: 'category',
                  name: '时间',
                  nameLocation: 'end',
                  nameTextStyle: {
                      color: '#777',
                      fontSize: 12,
                      fontStyle: 'normal'
                  },
                  axisLine: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  splitLine: {show: true},
                  axisTick: {show: false},
                  axisLabel: {
                      interval:0,
                      formatter: '{value}',
                      textStyle: {
                          color: '#777',
                          fontStyle: 'normal',
                          fontSize: 8,
                          fontWeight:  'bold'
                      }
                  },
                  data: categoryData
              },
              series: [
                  {
                      name: 'courts',
                      type: 'bar',
                      symbol: 'none',
                      itemStyle: {
                          normal: {
                              color: '#ddb926'
                          }
                      },
                      data: barData
                  }
              ]
           });
       }); 

		// 异步加载数据
       $.getJSON(elementCPath).done(function (data) {
           myGraphC.hideLoading();

           var info = [];
           /*var errorliblist = [
                               {value:0,name:'形式瑕疵'},
                               {value:0,name:'实质瑕疵'}
                              ];*/  
             for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
              var value = data.d.errorContentAndNumBycjList[i];
              var errorlibnum = value.num;
              info.push({"name":value.errorContent,"value":value.num});
              /*if(value.errorContent == '无判诉求瑕疵'||value.errorContent == '法条适用瑕疵'||value.errorContent == '无诉判决瑕疵'){
                $.each(errorliblist,function(key,value){
                  if(value.name == '实质瑕疵'){
                    value.value += errorlibnum;
                  }
                })
              }else{
                $.each(errorliblist,function(key,value){
                  if(value.name == '形式瑕疵'){
                    value.value += errorlibnum;
                  }
                })
              }*/
           }
           
            /*$.each(errorliblist,function(key,value){
                if(value.value == 0){
                   errorliblist.splace(key,1);
                }
            })*/
           

            myGraphC.setOption({
                title : {
                    text: '上海法院文书瑕疵位置分布',
                    textStyle: {
                       color: '#777',
                       fontSize: 16,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   x: 'center'
                },
                /*grid: {
                  left: '2%',
                  right:'8%'
                },*/
                tooltip : {
                    trigger: 'item',
                    formatter: "{a}<br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: []
                },
                series : [
                    {
                        name: '瑕疵分布',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data: info,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
                /*series : [
                    {
                        name: '瑕疵分布',
                        type: 'pie',
                        selectedMode: 'single',
                        radius : [0, '30%'],
                        data: errorliblist 
                    },
                    {
                        name: '瑕疵分布',
                        type: 'pie',
                        radius : ['40%', '55%'],
                        data: info 
                    }
                ]*/

            });
        });
		


        // 异步加载数据
       $.getJSON(elementFPath+'?d.court='+encodeURI(encodeURI(initCourtName))+'&d.courtRoom='+encodeURI(encodeURI(initRoomName))).done(function (data) {
           myGraphF.hideLoading();
           var info = [];
             for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
              var value = data.d.errorContentAndNumBycjList[i];
              info.push({"name":value.errorContent,"value":value.num});
           }

            myGraphF.setOption({
                title : {
                    text: initRoomName+'文书瑕疵位置分布',
                    textStyle: {
                       color: '#777',
                       fontSize: 16,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   x: 'center'
                },
                grid: {
                  bottom:'42%'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a}<br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: []
                },
                series : [
                    {
                        name: '瑕疵分布',
                        type: 'pie',
                        radius : '55%',
                        center: ['46%', '60%'],
                        data: info,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]

            });
        });


		
		        // 异步加载数据
       $.getJSON(elementGPath+'?d.court='+encodeURI(encodeURI(initCourtName))+'&d.courtRoom='+encodeURI(encodeURI(initRoomName))+'&d.showFlag=1').done(function (data) {
           myGraphG.hideLoading();

           var info = [];
             for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
              var value = data.d.errorContentAndNumBycjList[i];
              info.push({"name":value.errorContent,"value":value.num});
           }

            myGraphG.setOption({
                title : {
                    text: data.d.judge+"文书瑕疵位置分布",
                    textStyle: {
                       color: '#777',
                       fontSize: 16,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   x: 'center'
                },
                grid: {
                  bottom:'42%'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a}<br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: []
                },
                series : [
                    {
                        name: '瑕疵分布',
                        type: 'pie',
                        radius : '55%',
                        center: ['41%', '60%'],
                        data: info,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]

            });
		 });




       $.getJSON(elementDPath+'?d.court='+encodeURI(encodeURI(initCourtName))).done(function (data) {
           myGraphD.hideLoading();

           var categoryData = [];
           var barData = [];
           $.each(data.d.errorCourtRoomRateDetailDtoList,function(key,value){
                 categoryData=value.courtRoomArray;
                 barData=value.errorRateArray;
           })
           
           myGraphD.setOption({
              title:{
                  text:'徐汇法院各法庭瑕疵率(%)',
                  textStyle: {
                       color: '#777',
                       fontSize: 16,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   x: 'center'
              },
              tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>瑕疵率：{c}%'
              },
              grid: {
                  left: '6%',
                  bottom:'20%'
              },
              /*dataZoom : {
                  show : true,
                  realtime : true,
                  start : 0,
                  end : 100
              },*/
              yAxis: {
                  type: 'value',
                  name:'(%)',
                  nameGap: 10,
                  scale: true,
                  position: 'top',
                  boundaryGap: false,
                  splitLine: {show: true},
                  axisLine: {show: false},
                  axisTick: {show: false},
                  nameTextStyle: {
                    color: '#777',
                    fontSize: 12
                  },
                  axisLine: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  axisTick: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  axisLabel: {
                      textStyle: {
                          color: '#777',
                          fontStyle: 'normal',
                          fontWeight:  'bold'
                      }
                  },
              },
              xAxis: {
                  type: 'category',
                  name: '法庭',
                  nameLocation: 'end',
                  nameTextStyle: {
                      color: '#777',
                      fontSize: 12,
                      fontStyle: 'normal'
                  },
                  axisLine: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  splitLine: {show: true},
                  axisTick: {show: false},
                  axisLabel: {
                      interval:0,
                      formatter:function(val) {
                           return val.split("/")[1].replace(/(法庭)/g,"")
                      },
                      textStyle: {
                          color: '#777',
                          fontStyle: 'normal',
                          fontSize: 10,
                          /*fontWeight:  'bold'*/
                      },
                      rotate:45
                  },
                  data: categoryData
              },
              series: [
                  {
                      name: 'courts',
                      type: 'bar',
                      symbol: 'none',
                      itemStyle: {
                          normal: {
                              color: '#ddb926'
                          }
                      },
                      data: barData
                  }
              ]
           });
       });

       $.getJSON(elementEPath+'?d.court='+encodeURI(encodeURI(initCourtName))+'&d.courtRoom='+encodeURI(encodeURI(initRoomName))).done(function (data) {
           myGraphE.hideLoading();

           var categoryData = [];
           var barData = [];
           $.each(data.d.errorJudgeNameRateDetailDtoList,function(key,value){
                 categoryData=value.judgeNameArray;
                 barData=value.errorRateArray;
           })
           
           myGraphE.setOption({
              title:{
                  text:initRoomName+'各法官瑕疵率(%)',
                  textStyle: {
                       color: '#777',
                       fontSize: 16,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   x: 'center'
              },
              tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>瑕疵率：{c}%'
              },
              grid: {
                  left: '6%',
                  bottom:'23%'
              },
              /*dataZoom : {
                  show : true,
                  realtime : true,
                  start : 0,
                  end : 100
              },*/
              yAxis: {
                  type: 'value',
                  name:'(%)',
                  nameGap: 10,
                  scale: true,
                  position: 'top',
                  boundaryGap: false,
                  splitLine: {show: true},
                  axisLine: {show: false},
                  axisTick: {show: false},
                  nameTextStyle: {
                    color: '#777',
                    fontSize: 12
                  },
                  axisLine: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  axisTick: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  axisLabel: {
                      textStyle: {
                          color: '#777',
                          fontStyle: 'normal',
                          fontWeight:  'bold'
                      }
                  },
              },
              xAxis: {
                  type: 'category',
                  name: '法官',
                  nameLocation: 'end',
                  nameTextStyle: {
                      color: '#777',
                      fontSize: 12,
                      fontStyle: 'normal'
                  },
                  axisLine: {
                      lineStyle: {
                          color: '#777'
                      }
                  },
                  splitLine: {show: true},
                  axisTick: {show: false},
                  axisLabel: {
                      interval:0,
                      formatter:function(val) {
                           return val.split("/")[2]
                      },
                      textStyle: {
                          color: '#777',
                          fontSize: 10,
                          fontStyle: 'normal',
                          /*fontWeight:  'bold'*/
                      },
                      rotate:45
                  },
                  data: categoryData
              },
              series: [
                  {
                      name: 'courts',
                      type: 'bar',
                      symbol: 'none',
                      itemStyle: {
                          normal: {
                              color: '#ddb926'
                          }
                      },
                      data: barData
                  }
              ]
           });
       });

       myGraphA.on('click', function (params) {
          var court = params.name.replace(/[\r\n]/g,"");
          var courtLabel = court.replace(/(上海)|(市)|(县)|(人民)/g,"");
          var categoryData = [];
          var barData = [];
          $.getJSON(elementBPath).done(function (data) {
               $.each(data.d.errorYearRateList,function(key,value){
                  if(value.courtName == court){
                     categoryData=value.yearArray;
                     barData=value.errorRateArray;
                   }
               });

             myGraphB.setOption({
               title:{
                   text: courtLabel+'瑕疵率分布(%)',
               },
               xAxis: {
                   data: categoryData
               },
               series: [
                   {
                       data: barData
                   }
               ]
              });
          });

          $.getJSON(elementCPath+'?d.court='+encodeURI(encodeURI(court))).done(function (data) {
                var info = [];
                for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
                   var value = data.d.errorContentAndNumBycjList[i];
                   info.push({"name":value.errorContent,"value":value.num});
                }

               myGraphC.setOption({
               title:{
                   text: courtLabel+'文书瑕疵位置分布',
               },
               series: [
                   {
                       data: info
                   }
               ]
              });
          });

          $.getJSON(elementFPath+'?d.court='+encodeURI(encodeURI(court))+'&d.showFlag=0').done(function (data) {
                var info = [];
                for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
                   var value = data.d.errorContentAndNumBycjList[i];
                   info.push({"name":value.errorContent,"value":value.num});
                }

               myGraphF.setOption({
               title:{
                   text: data.d.courtRoom+'文书瑕疵位置分布',
               },
               series: [
                   {
                       data: info
                   }
               ]
              });
          });
          
          $.getJSON(elementGPath+'?d.court='+encodeURI(encodeURI(court))+'&d.showFlag=2').done(function (data) {
                var info = [];
                for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
                   var value = data.d.errorContentAndNumBycjList[i];
                   info.push({"name":value.errorContent,"value":value.num});
                }

               myGraphG.setOption({
               title:{
                   text: data.d.judge+'文书瑕疵位置分布',
               },
               series: [
                   {
                       data: info
                   }
               ]
              });
          });

          $.getJSON(elementDPath+'?d.court='+encodeURI(encodeURI(court))).done(function (data) {
                 $.each(data.d.errorCourtRoomRateDetailDtoList,function(key,value){
                	 categoryData=value.courtRoomArray;
                	 barData=value.errorRateArray;
          		 })

             myGraphD.setOption({
               title:{
                   text: courtLabel+'各法庭瑕疵率(%)',
               },
               xAxis: {
                   data: categoryData
               },
               series: [
                   {
                       data: barData
                   }
               ]
              });
          });
          
         $.getJSON(elementEPath+'?d.court='+encodeURI(encodeURI(court))+'&d.showFlag=3').done(function (data) {
              $.each(data.d.errorJudgeNameRateDetailDtoList,function(key,value){
                 categoryData=value.judgeNameArray;
                 barData=value.errorRateArray;
           		})
             myGraphE.setOption({
               title:{
                   text: data.d.courtRoom+'各法官瑕疵率(%)',
               },
               xAxis: {
                   data: categoryData
               },
               series: [
                   {
                       data: barData
                   }
               ]
              });
          });
          
          
          
       });


       myGraphD.on('click', function (params) {
          var court = params.name.replace(/[\r\n]/g,"").split("/")[0];
          var room = params.name.replace(/[\r\n]/g,"").split("/")[1];
          //var courtLabel = court.replace(/(上海)|(市)|(县)|(人民)/g,"");
          var categoryData = [];
          var barData = [];

          $.getJSON(elementFPath+'?d.court='+encodeURI(encodeURI(court))+'&d.courtRoom='+encodeURI(encodeURI(room))).done(function (data) {
                var info = [];
                for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
                   var value = data.d.errorContentAndNumBycjList[i];
                   info.push({"name":value.errorContent,"value":value.num});
                }

             myGraphF.setOption({
               title:{
                   text: room+'文书瑕疵位置分布',
               },
               series: [
                   {
                       data: info
                   }
               ]
              });
          });
          
         $.getJSON(elementGPath+'?d.court='+encodeURI(encodeURI(court))+'&d.courtRoom='+encodeURI(encodeURI(room))+'&d.showFlag=1').done(function (data) {
                var info = [];
                for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
                   var value = data.d.errorContentAndNumBycjList[i];
                   info.push({"name":value.errorContent,"value":value.num});
                }

             myGraphG.setOption({
               title:{
                   text: data.d.judge+'文书瑕疵位置分布',
               },
               series: [
                   {
                       data: info
                   }
               ]
              });
          });

          $.getJSON(elementEPath+'?d.court='+encodeURI(encodeURI(court))+'&d.courtRoom='+encodeURI(encodeURI(room))).done(function (data) {
              $.each(data.d.errorJudgeNameRateDetailDtoList,function(key,value){
                 categoryData=value.judgeNameArray;
                 barData=value.errorRateArray;
           		})
             myGraphE.setOption({
               title:{
                   text: room+'各法官瑕疵率(%)',
               },
               xAxis: {
                   data: categoryData
               },
               series: [
                   {
                       data: barData
                   }
               ]
              });
          });
       });

       myGraphE.on('click', function (params) {
          var court = params.name.replace(/[\r\n]/g,"").split("/")[0];
          var room = params.name.replace(/[\r\n]/g,"").split("/")[1];
          var judge = params.name.replace(/[\r\n]/g,"").split("/")[2];
          var info = [];

          $.getJSON(elementGPath+'?d.court='+encodeURI(encodeURI(court))+'&d.courtRoom='+encodeURI(encodeURI(room))+'&d.judge='+encodeURI(encodeURI(judge))).done(function (data) {
               for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
                   var value = data.d.errorContentAndNumBycjList[i];
                   info.push({"name":value.errorContent,"value":value.num});
                }

             myGraphG.setOption({
               title:{
                   text: judge+'文书瑕疵位置分布',
               },
               series: [
                   {
                       data: info
                   }
               ]
              });
          });
       });
       
       $('#courtButton').click(function(){
	  	var court = $("#court option:selected").val();
	    var courtLabel = court.replace(/(上海)|(市)|(县)|(人民)/g,"");
	    var courtRoom ='';
        var categoryData = [];
        var barData = [];
        $.getJSON(elementBPath).done(function (data) {
               $.each(data.d.errorYearRateList,function(key,value){
                  if(value.courtName == court){
                     categoryData=value.yearArray;
                     barData=value.errorRateArray;
                   }
               });

             myGraphB.setOption({
               title:{
                   text: courtLabel+'瑕疵率分布(%)',
               },
               xAxis: {
                   data: categoryData
               },
               series: [
                   {
                       data: barData
                   }
               ]
              });
          });
        $.getJSON(elementDPath+'?d.court='+encodeURI(encodeURI(court))).done(function (data) {
                 $.each(data.d.errorCourtRoomRateDetailDtoList,function(key,value){
                	 categoryData=value.courtRoomArray;
                	 barData=value.errorRateArray;
          		 })

             myGraphD.setOption({
               title:{
                   text: courtLabel+'各法庭瑕疵率(%)',
               },
               xAxis: {
                   data: categoryData
               },
               series: [
                   {
                       data: barData
                   }
               ]
              });
          });
          
       	$.getJSON(elementCPath+'?d.court='+encodeURI(encodeURI(court))).done(function (data) {
               var info = [];
               for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
                  var value = data.d.errorContentAndNumBycjList[i];
                  info.push({"name":value.errorContent,"value":value.num});
               }

              myGraphC.setOption({
              title:{
                  text: courtLabel+'文书瑕疵位置分布',
              },
              series: [
                  {
                      data: info
                  }
              ]
             });
          });
          
         $.getJSON(elementFPath+'?d.court='+encodeURI(encodeURI(court))+'&d.showFlag=0').done(function (data) {
               var info = [];
               for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
                  var value = data.d.errorContentAndNumBycjList[i];
                  info.push({"name":value.errorContent,"value":value.num});
               }

              myGraphF.setOption({
              title:{
                  text: data.d.courtRoom+'文书瑕疵位置分布',
              },
              series: [
                  {
                      data: info
                  }
              ]
             });
          });
          
       $.getJSON(elementGPath+'?d.court='+encodeURI(encodeURI(court))+'&d.showFlag=2').done(function (data) {
               var info = [];
               for(var i = 0; i<data.d.errorContentAndNumBycjList.length;i++){
                  var value = data.d.errorContentAndNumBycjList[i];
                  info.push({"name":value.errorContent,"value":value.num});
               }

              myGraphG.setOption({
              title:{
                  text: data.d.judge+'文书瑕疵位置分布',
              },
              series: [
                  {
                      data: info
                  }
              ]
             });
          });
          
        $.getJSON(elementEPath+'?d.court='+encodeURI(encodeURI(court))+'&d.showFlag=3').done(function (data) {
              $.each(data.d.errorJudgeNameRateDetailDtoList,function(key,value){
                 categoryData=value.judgeNameArray;
                 barData=value.errorRateArray;
           		})
             myGraphE.setOption({
               title:{
                   text: data.d.courtRoom+'各法官瑕疵率(%)',
               },
               xAxis: {
                   data: categoryData
               },
               series: [
                   {
                       data: barData
                   }
               ]
              });
          });
          
          
          
	  	});
    }
    
    function judgeAll(element,jsonpath){
       // 基于准备好的dom，初始化echarts实例
       var myChartline = echarts.init(document.getElementById(element),'macarons');
       myChartline.showLoading();

        // 异步加载数据
       $.getJSON(jsonpath).done(function (data) {
           myChartline.hideLoading();

           // 显示标题，图例和空的坐标轴
           var sdataZ = [];
           var gdataZ = [];
           var yearsZ = []; 
           $.each(data,function(key,value){
                   yearsZ=value.courtYear;
                   sdataZ=value.sData;
                   gdataZ=value.gData;
           });
           myChartline.setOption({
               title: {
                   text: '审判程序瑕疵分布',
                    textStyle: {
                        color: '#777',
                    },
                    left: 'left'
               },
               tooltip : {
                   trigger: 'axis'
               },
               legend: {
                   data:['独任审理','合议庭']
               },
               grid: {
                   left: '3%',
                   right: '4%',
                   bottom: '3%',
                   top:'12%',
                   containLabel: true
               },
               xAxis : [
                   {
                       type : 'category',
                       axisLabel: {
                        textStyle: {
                          color: '#777',
                          fontStyle: 'normal'
                         }
                       },
                       boundaryGap : false,
                       data : yearsZ
                   }
               ],
               yAxis: [
                   
                   {
                       type: 'value',
                       name: '瑕疵比（%）',
                       nameTextStyle: {
                         color: '#777',
                         fontSize: 12,
                         fontStyle: 'normal'
                       },
                       min: 0,
                       max: 100,
                       interval: 20,
                       axisLabel: {
                          formatter: '{value}',
                          textStyle: {
                            color: '#777',
                            fontStyle: 'normal'
                          }  
                       },
                   }
               ],
               series : [
                   {
                       name:'独任审理',
                       type:'line',
                       stack: '总量',
                       areaStyle: {normal: {}},
                       data:sdataZ
                   },
                   {
                       name:'合议庭',
                       type:'line',
                       areaStyle: {normal: {}},
                       data:gdataZ
                   }
               ]
            });
       });    
    }     

    function judgeDetail(element,jsonpath){
       // 基于准备好的dom，初始化echarts实例
       var myChartline = echarts.init(document.getElementById(element),'macarons');
       myChartline.showLoading();
       var courtName = $("#courtName option:selected").val();
       //var judge = $("#judge option:selected").val(); 

        // 异步加载数据
       $.getJSON(jsonpath+'?d.court='+encodeURI(encodeURI(courtName))).done(function (data) {
           myChartline.hideLoading();

           // 显示标题，图例和空的坐标轴
           var sdataZ = [];
           var gdataZ = [];
           var yearsZ = []; 
           $.each(data.d.errorCourtYearRateList,function(key,value){
                   yearsZ=value.courtYearArray;
                   sdataZ=value.scourtErrorRateArray;
                   gdataZ=value.gcourtErrorRateArray;
           });

           myChartline.setOption({
                title: {
                    text: courtName,
                    textStyle: {
                        color: '#777',
                    },
                    left: 'left'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['独任审理','合议庭']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        axisLabel: {
                          textStyle: {
                           color: '#777',
                           fontStyle: 'normal'
                          }
                        },
                        boundaryGap : false,
                        data : yearsZ
                    }
                ],
                yAxis: [
                    
                    {
                        type: 'value',
                        name: '瑕疵率（%）',
                        nameTextStyle: {
                         color: '#777',
                         fontSize: 12,
                         fontStyle: 'normal'
                        },
                        min: 0,
                        max: 100,
                        interval: 20,
                        axisLabel: {
                            formatter: '{value}',
                            textStyle: {
                              color: '#777',
                              fontStyle: 'normal'
                            }
                        }
                    }
                ],
                series : [
                    {
                       name:'独任审理',
                       type:'line',
                       stack: '总量',
                       areaStyle: {normal: {}},
                       data:sdataZ
                   },
                   {
                       name:'合议庭',
                       type:'line',
                       areaStyle: {normal: {}},
                       data:gdataZ
                   }
                ]
            });
        });

        $('#refresh').click(function(){
        	var courtName = $("#courtName option:selected").val();
        	//var judge = $("#judge option:selected").val();
        	myChartline.showLoading();

        	// 异步加载数据
           $.getJSON(jsonpath+'?d.court='+encodeURI(encodeURI(courtName))).done(function (data) {
           myChartline.hideLoading();

            // 显示标题，图例和空的坐标轴
           var sdataZ = [];
           var gdataZ = [];
           var yearsZ = []; 
            $.each(data.d.errorCourtYearRateList,function(key,value){
                   yearsZ=value.courtYearArray;
                   sdataZ=value.scourtErrorRateArray;
                   gdataZ=value.gcourtErrorRateArray;
           });

           myChartline.setOption({
           	    title: {
                    text: courtName,
                    left: 'left'
                },
                xAxis : [
                    {
                        data : yearsZ
                    }
                ],
                series : [
                    {
                       name:'独任审理',
                       data:sdataZ
                   },
                   {
                       name:'合议庭',
                       data:gdataZ
                   }
                ]
            });
          });
        });
    } 
</script>
</body>
</html>
