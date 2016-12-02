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
                    <li data-menuanchor="page2"><a href="#page2" style ="float:left;">文书分布</a></li>
                    <li data-menuanchor="page3"><a href="#page3" style ="float:left;">瑕疵分布</a></li>
                    <li data-menuanchor="page4"><a href="#page4" style ="float:left;">审判程序类型</a></li>
                   <!--  <li data-menuanchor="page5"><a href="#page5" style ="float:left;">程序变更因素</a></li> -->
                </ul>
            </nav>
        </div>
    </header>
    <!-- 头部导航结束 -->

    <!-- 主体开始 -->
    <div class="con">
         <div class="section s1 active">
            <div id="mapA" style="width:65%;height:600px;display:inline;float:left;margin:100px 0px 0px 80px;"></div>
            <div id="mapB" style="width:30%;height:420px;display:inline;float:left;margin:260px 20px 0px -160px;"></div>
        </div>

        <!-- 第二页 -->
        <div class="section s2">
            <div id="courtRate" style="width:50%;height:600px;display:inline;float:left;margin:80px 10px 0px 10px;"></div>
            <div id="causeRate" style="width:50%;height:600px;display:inline;float:left;margin:80px 0px 0px -40px;"></div>
        </div>

        <!-- 第三页 -->
        <div class="section s3">
            <div id="errorbar" style="width:50%;height:600px;display:inline;float:left;margin:80px 0px 0px 10px;"></div>
            <div id="errorpie" style="width:50%;height:600px;display:inline;float:left;margin:80px 0px 0px -80px;"></div>           
        </div>

        <!-- 第四页 -->
        <div class="section s4">
            <!-- <div id="judgeall" style="width:50%;height:600px;display:inline;float:left;margin:80px 20px 0px 10px;"></div> -->
            <div id="judgezoom" style="width:80%;height:600px;margin:80px auto 0px auto;">
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
            <select id="judge" name="judge"> 
               <option value="G">合议庭</option> 
               <option value="S" selected = "selected">独任审理</option> 
            </select>
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
	<script type="text/javascript" src="<%=path%>/js/echartJs/jquery.fullPage.min.js"></script>
	<script type="text/javascript">
	var path = '<%=path%>';
	$(document).ready(function(){
       myMap('mapA','mapB',path+'/JSON/shanghai.json',path+'/echartsAnalysis_initEchartDetail.do',path+'/echartsAnalysis_initEchartYearRateDetail.do');
       courtRate('courtRate',path+'/echartsAnalysis_initEchartNumAndRateDetail.do');
       causeRate('causeRate',path+'/echartsAnalysis_initEchartCauseAndRateDetail.do');
       errorBar('errorbar','errorpie',path+'/echartsAnalysis_initEchartContentAndNumDetail.do');
       //judgeAll ('judgeall',path+'/JSON/judgeall.json');
       judgeDetail('judgedetail',path+'/echartsAnalysis_initEchartCourtYearRateBycourtAndTrialProduce.do');
       //judgeTrans('judgetrans');
       $('.con').fullpage({
            navigation: true,
            anchors: ['page1', 'page2', 'page3', 'page4', 'page5'],
            menu: '.menu',
            navigationTooltips: ['总体概览','文书分布','瑕疵分布','审判程序类型','程序变更因素',],
            verticalCentered:false,
        });
    });
	
	
		
	function myMap(elementA,elementB,mapJsonPath,mapJsonData,mapClickData){
       // 基于准备好的dom，初始化echarts实例
       var myChart = echarts.init(document.getElementById(elementA));
       var detailChart = echarts.init(document.getElementById(elementB));
       myChart.showLoading();

       // 异步加载数据
       $.getJSON(mapJsonPath).done(function (data) {
           myChart.hideLoading();
           echarts.registerMap('shanghai', data);
           // 显示标题，图例和空的坐标轴
           myChart.setOption({
                title:{
                   text: '上海市法院文书瑕疵地图',
                   textStyle: {
                       color: '#777',
                       fontSize: 20,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{b}<br/>{c}%'
                },
                visualMap: {
                    left: '80',
                    bottom:'40',
                    min: 0,
                    max: 100,
                    text:['','瑕疵比(%)'],
                    realtime: false,
                    calculable: true,
                    inRange: {
                        color: ['lightskyblue','yellow', 'orangered']
                    }
                },
                series: [{
                        type: 'map',
                        mapType:'shanghai',
                        itemStyle:{
                           normal:{label:{show:false}},
                           emphasis:{label:{show:true}}
                        },
                        roam:false,
                        data:[],
                        nameMap: {
                          '徐汇区': '上海市徐汇区人民法院',
                          '长宁区': '上海市长宁区人民法院',
                          '闵行区': '上海市闵行区人民法院',
                          '浦东新区': '上海市浦东新区人民法院',
                          '奉贤区': '上海市奉贤区人民法院',
                          '松江区': '上海市松江区人民法院',
                          '金山区': '上海市金山区人民法院',
                          '黄浦区': '上海市黄浦区人民法院',
                          '静安区': '上海市静安区人民法院',
                          '普陀区': '上海市普陀区人民法院',
                          '闸北区': '上海市闸北区人民法院',
                          '虹口区': '上海市虹口区人民法院',
                          '杨浦区': '上海市杨浦区人民法院',
                          '宝山区': '上海市宝山区人民法院',
                          '嘉定区': '上海市嘉定区人民法院',
                          '青浦区': '上海市青浦区人民法院',
                          '崇明县': '上海市崇明县人民法院'
                        }
                }]
           });
       });

        // 异步加载数据
       $.getJSON(mapJsonData).done(function (data) {
            var info = [];
           	 for(var i = 0; i<data.d.errorRateList.length;i++){
            	var value = data.d.errorRateList[i];
            	info.push({"name":value.courtName,"value":value.errorRate});
           }
            
            myChart.setOption({
               series: [
                   {
                       data: info
                   }
               ]
            });


       }); 

       $.getJSON(mapClickData).done(function (data) {
       	   var courtname = "";
       	   var categoryData = [];
           var barData = [];
           $.each(data.d.errorYearRateList,function(key,value){
              if(key == 0){
              	 courtname = value.courtName;
                 categoryData=value.yearArray;
                 barData=value.errorRateArray;
               }
           })
           
           detailChart.setOption({
              title:{
                  text:courtname+'历年瑕疵率(%)',
                  textStyle: {
                      fontSize: 16,
                      fontStyle: 'normal',
                      fontWeight:  'bold'
                  },
              },
              tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>{c}%'
              },
              grid: {
                  left: '20%',
              },
              xAxis: {
                  type: 'value',
                  nameGap: 20,
                  scale: true,
                  position: 'top',
                  boundaryGap: false,
                  splitLine: {show: false},
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
              yAxis: {
                  type: 'category',
                  name: '月份',
                  nameLocation: 'start',
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
                      formatter: '{value}',
                      textStyle: {
                          color: '#777',
                          fontStyle: 'normal'
                      }
                  },
                  data: categoryData
              },
              series: [
                  {
                      name: 'years',
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

       myChart.on('click', function (params) {
	          var court = params.name.replace(/[\r\n]/g,"");
	          var categoryData = [];
	          var barData = [];
	          $.getJSON(mapClickData).done(function (data) {
	               $.each(data.d.errorYearRateList,function(key,value){
	                if(value.courtName == court){
	                   categoryData=value.yearArray;
	                   barData=value.errorRateArray;
	                 }
	               });
	
	             detailChart.setOption({
	               title:{
	                   text: court+'历年瑕疵比(%)',
	               },
	               yAxis: {
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
   
   function courtRate(element,jsonpath){
       // 基于准备好的dom，初始化echarts实例
       var myChart = echarts.init(document.getElementById(element));
       myChart.showLoading();

        // 异步加载数据
       $.getJSON(jsonpath).done(function (data) {
           myChart.hideLoading();
           // 显示标题，图例和空的坐标轴
           var dataGZ = [];
           var courts = [1,];  
           var schema = [
               {name: 'rate', index: 0, text: '瑕疵率'},
               {name: 'num', index: 1, text: '处理文书数'}
           ];
           
           
           var itemStyle = {
               normal: {
                   opacity: 0.8,
                   shadowBlur: 10,
                   shadowOffsetX: 0,
                   shadowOffsetY: 0,
                   shadowColor: 'rgba(0, 0, 0, 0.5)'
               }
           };

           $.each(data.d.errorNumAndRateList,function(key,value){
                   courts.push(value.courtName);
                   dataGZ.push(value.numAndRateArray);
           });

           myChart.setOption({
               title:{
                   text: '文书瑕疵率',
                   textStyle: {
                       color: '#777',
                       fontSize: 20,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   left: 'center'
               },
               legend: {
                   y: 'top',
                   data: [],
                   textStyle: {
                       color: '#777',
                       fontSize: 16
                   }
               },
               grid: {
                   x: '15%',
                   x2: 80,
                   y: '11%',
                   y2: '25%'
               },
               /*toolbox: {
                   show: true,
                   feature: {
                       dataView: {show: true, readOnly: false},
                       magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                       restore: {show: true},
                       saveAsImage: {show: true}
                   }
               },*/
               tooltip: {
                   padding: 10,
                   backgroundColor: '#222',
                   borderColor: '#777',
                   borderWidth: 1,
                   precision:0.1,
                   formatter: function (obj) {
                       var value = obj.value;
                       return '<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-           bottom: 7px">'
                           + obj.name + '：'
                           + '</div>'
                           + schema[0].text + '：' + value[1].toFixed(2) + '%<br>'
                           + schema[1].text + '：' + value[2] + '件<br>';
                   }
               },
               xAxis: {
                   type: 'category',
                   name: '法院名称',
                   nameGap: 16,
                   nameTextStyle: {
                       color: '#777',
                       fontSize: 14
                   },
                   splitLine: {
                       show: false
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
                   data:courts,
                   axisLabel: {
                       rotate:45,
                       interval:0,
                       textStyle: {
                           color: '#777',
                           fontStyle: 'normal',
                       }
                   }
               },
               yAxis: {
                   type: 'value',
                   name: '瑕疵率（％）',
                   nameLocation: 'end',
                   nameGap: 20,
                   precision:2,
                   nameTextStyle: {
                       color: '#777',
                       fontSize: 16,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
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
                   splitLine: {
                       show: false
                   },
                   axisLabel: {
                       formatter: '{value}',
                       textStyle: {
                           color: '#777',
                           fontStyle: 'normal',
                       }
                   }
               },
               visualMap: [
                   {
                       left: 'right',
                       top: '3%',
                       dimension: 2,
                       min: 300,
                       max: 6000,
                       itemWidth: 30,
                       itemHeight: 120,
                       calculable: true,
                       precision: 0.1,
                       text: ['气泡大小：处理文书数'],
                       textGap: 30,
                       textStyle: {
                           color: '#777',
                           fontStyle: 'normal',
                           fontWeight:  'bold'
                       },
                       inRange: {
                           symbolSize: [20, 60],
                           color: ['#dd4444', '#fec42c', '#80F1BE','#323c48']
                       },
                       outOfRange: {
                           symbolSize: [10, 70],
                           color: ['rgba(255,255,255,.2)']
                       },
                       controller: {
                           inRange: {
                               color: ['#c23531']
                           },
                           outOfRange: {
                               color: ['#444']
                           }
                       }
                   }
               ],
               series: [
                   {
                       name: '遵义法院',
                       type: 'scatter',
                       itemStyle: itemStyle,
                       data: dataGZ,
                       markPoint : {
                           data : [
                               {type : 'max', name: '最大值'},
                               {type : 'min', name: '最小值'}
                           ]
                       },
                       markLine : {
                           data : [
                               {type : 'average', name: '平均值'}
                           ]
                       }
                   }
               ]
            });
        });
    }   


    function causeRate(element,jsonpath){
       // 基于准备好的dom，初始化echarts实例
       var myChart = echarts.init(document.getElementById(element));
       myChart.showLoading();

        // 异步加载数据
       $.getJSON(jsonpath).done(function (data) {
           myChart.hideLoading();
           // 显示标题，图例和空的坐标轴
           var dataGZ = [];
           var cause = [1,];  
           var schema = [
               {name: 'rate', index: 0, text: '瑕疵率'},
               {name: 'num', index: 1, text: '处理文书数'}
           ];
           
           
           var itemStyle = {
               normal: {
                   opacity: 0.8,
                   shadowBlur: 10,
                   shadowOffsetX: 0,
                   shadowOffsetY: 0,
                   shadowColor: 'rgba(0, 0, 0, 0.5)'
               }
           };

           $.each(data.d.errorCauseAndRateList,function(key,value){
                   cause.push(value.causeName);
                   dataGZ.push(value.causeAndRateArray);
           });

           myChart.setOption({
               title:{
                   text: '案由瑕疵率',
                   textStyle: {
                       color: '#777',
                       fontSize: 20,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
                   },
                   left: 'center'
               },
               legend: {
                   y: 'top',
                   data: [],
                   textStyle: {
                       color: '#777',
                       fontSize: 16
                   }
               },
               grid: {
                   x: '15%',
                   x2: 80,
                   y: '11%',
                   y2: '25%'
               },
               /*toolbox: {
                   show: true,
                   feature: {
                       dataView: {show: true, readOnly: false},
                       magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                       restore: {show: true},
                       saveAsImage: {show: true}
                   }
               },*/
               tooltip: {
                   padding: 10,
                   backgroundColor: '#222',
                   borderColor: '#777',
                   borderWidth: 1,
                   precision:0.1,
                   formatter: function (obj) {
                       var value = obj.value;
                       return '<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-           bottom: 7px">'
                           + obj.name + '：'
                           + '</div>'
                           + schema[0].text + '：' + value[1].toFixed(2) + '%<br>'
                           + schema[1].text + '：' + value[2] + '件<br>';
                   }
               },
               xAxis: {
                   type: 'category',
                   name: '案由名称',
                   nameGap: 16,
                   nameTextStyle: {
                       color: '#777',
                       fontSize: 14
                   },
                   splitLine: {
                       show: false
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
                   data:cause,
                   axisLabel: {
                       rotate:45,
                       interval:0,
                       textStyle: {
                           color: '#777',
                           fontStyle: 'normal',
                       }
                   }
               },
               yAxis: {
                   type: 'value',
                   name: '瑕疵率（％）',
                   nameLocation: 'end',
                   nameGap: 20,
                   precision:2,
                   nameTextStyle: {
                       color: '#777',
                       fontSize: 16,
                       fontStyle: 'normal',
                       fontWeight:  'bold'
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
                   splitLine: {
                       show: false
                   },
                   axisLabel: {
                       formatter: '{value}',
                       textStyle: {
                           color: '#777',
                           fontStyle: 'normal',
                       }
                   }
               },
               visualMap: [
                   {
                       left: 'right',
                       top: '3%',
                       dimension: 2,
                       min: 200,
                       max: 6000,
                       itemWidth: 30,
                       itemHeight: 120,
                       calculable: true,
                       precision: 0.1,
                       text: ['气泡大小：处理文书数'],
                       textGap: 30,
                       textStyle: {
                           color: '#777',
                           fontStyle: 'normal',
                           fontWeight:  'bold'
                       },
                       inRange: {
                           symbolSize: [20, 60],
                           color: ['#dd4444', '#fec42c', '#80F1BE','#323c48']
                       },
                       outOfRange: {
                           symbolSize: [10, 70],
                           color: ['rgba(255,255,255,.2)']
                       },
                       controller: {
                           inRange: {
                               color: ['#c23531']
                           },
                           outOfRange: {
                               color: ['#444']
                           }
                       }
                   }
               ],
               series: [
                   {
                       name: '遵义法院',
                       type: 'scatter',
                       itemStyle: itemStyle,
                       data: dataGZ,
                       markPoint : {
                           data : [
                               {type : 'max', name: '最大值'},
                               {type : 'min', name: '最小值'}
                           ]
                       },
                       markLine : {
                           data : [
                               {type : 'average', name: '平均值'}
                           ]
                       }
                   }
               ]
            });
        });
    }

    function errorBar(elementA,elementB,jsonpath){
       // 基于准备好的dom，初始化echarts实例
       var myChartbar = echarts.init(document.getElementById(elementA));
       var myChartpie = echarts.init(document.getElementById(elementB));
       myChartbar.showLoading();
       myChartpie.showLoading();
        // 异步加载数据
       $.getJSON(jsonpath).done(function (data) {
           myChartbar.hideLoading();
           myChartpie.hideLoading();
           // 显示标题，图例和空的坐标轴
           var dataZ = [];
           var errorZ = [];  
           $.each(data.d.errorContentAndNumList,function(key,value){
                   errorZ=value.errorContentArray;
                   dataZ=value.numberArray;
           });
           myChartbar.setOption({
                title:{
                    text:'',
                    textStyle: {
                        fontSize: 16,
                        fontStyle: 'normal',
                        fontWeight:  'bold'
                    },
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{b}<br/>{c}'
                },
                grid: {
                    left: '20%',
                    right: '20%'
                },
                xAxis: {
                    type: 'value',
                    name: '瑕疵数量',
                    nameLocation: 'end',
                    scale: true,
                    position: 'top',
                    boundaryGap: false,
                    splitLine: {show: false},
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
                yAxis: {
                    type: 'category',
                    name: '文书位置',
                    nameLocation: 'start',
                    nameGap: 20,
                    min:0,
                    max:100,
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
                        formatter: '{value}',
                        textStyle: {
                            color: '#777',
                            fontStyle: 'normal'
                        }
                    },
                    data: errorZ
                },
                series: [
                    {
                        name: 'years',
                        type: 'bar',
                        symbol: 'none',
                        itemStyle: {
                            normal: {
                                color: '#ddb926'
                            }
                        },
                        data: dataZ
                    }
                ]
            });

            myChartpie.setOption({
                title : {
                    text: '',
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
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
                        data:[
                            {value:61,name:'法院名称'},
                            {value:112,name:'诉请'},
                            {value:113,name:'审判组织和落款日期'},
                            {value:158,name:'原告陈述'},
                            {value:173,name:'文书论理'},
                            {value:180,name:'案由和审理经过'},
                            {value:250,name:'诉讼权利义务告知'},
                            {value:271,name:'第三人'},
                            {value:309,name:'原告举证'},
                            {value:1167,name:'法律条文'},
                            {value:1285,name:'被告答辩和事实查明'},
                            {value:2744,name:'原告'},
                            {value:4478,name:'判决'},
                            {value:4826,name:'法条适用'},
                            {value:7450,name:'被告'}
                        ],
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
    }
    
    function judgeAll(element,jsonpath){
       // 基于准备好的dom，初始化echarts实例
       var myChartline = echarts.init(document.getElementById(element));
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
                   text: ''
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
                       boundaryGap : false,
                       data : yearsZ
                   }
               ],
               yAxis: [
                   
                   {
                       type: 'value',
                       name: '瑕疵比（%）',
                       min: 0,
                       max: 100,
                       interval: 20,
                       axisLabel: {
                           formatter: '{value}'
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
    }     

    function judgeDetail(element,jsonpath){
       // 基于准备好的dom，初始化echarts实例
       var myChartline = echarts.init(document.getElementById(element));
       myChartline.showLoading();
       var courtName = $("#courtName option:selected").val();
       var judge = $("#judge option:selected").val(); 

        // 异步加载数据
       $.getJSON(jsonpath+'?d.court='+encodeURI(encodeURI(courtName))+'&d.trial_procedure='+judge).done(function (data) {
           myChartline.hideLoading();

           // 显示标题，图例和空的坐标轴
           var dataZ = [];
           var yearsZ = []; 
           $.each(data.d.errorCourtYearRateList,function(key,value){
                   yearsZ=value.courtYearArray;
                   dataZ=value.courtErrorRateArray;
           });

           myChartline.setOption({
                title: {
                    text: courtName,
                    textStyle: {
                        color: '#777',
                    },
                    left: 'center'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:[]
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
                        boundaryGap : false,
                        data : yearsZ
                    }
                ],
                yAxis: [
                    
                    {
                        type: 'value',
                        name: '瑕疵率（%）',
                        min: 0,
                        max: 100,
                        interval: 20,
                        axisLabel: {
                            formatter: '{value}'
                        }
                    }
                ],
                series : [
                    {
                        name:judge,
                        type:'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data:dataZ
                    }
                ]
            });
        });

        $('#refresh').click(function(){
        	var courtName = $("#courtName option:selected").val();
        	var judge = $("#judge option:selected").val();
        	myChartline.showLoading();

        	// 异步加载数据
           $.getJSON(jsonpath+'?d.court='+encodeURI(encodeURI(courtName))+'&d.trial_procedure='+judge).done(function (data) {
           myChartline.hideLoading();

           // 显示标题，图例和空的坐标轴
           var dataZ = [];
           var yearsZ = []; 
           $.each(data.d.errorCourtYearRateList,function(key,value){
                   yearsZ=value.courtYearArray;
                   dataZ=value.courtErrorRateArray;
           });

           myChartline.setOption({
           	    title: {
                    text: courtName,
                    left: 'center'
                },
                xAxis : [
                    {
                        data : yearsZ
                    }
                ],
                series : [
                    {
                        name:judge,
                        data:dataZ
                    }
                ]
            });
          });
        });
    } 

    function judgeTrans(element){
       // 基于准备好的dom，初始化echarts实例
       var myCharttree = echarts.init(document.getElementById(element));

           myCharttree.setOption({
             title : {
                 text: '审判程序变更影响因素分布图',
                 textStyle: {
                     color: '#777',
                     fontSize: 20
                 },
                 left: 'center'
             },
             tooltip : {
                 trigger: 'item',
                 formatter: "{b}:{c}"
             },
          /* toolbox: {
                 show: true,
                 feature: {
                     dataView: {show: true, readOnly: false},
                     magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                     restore: {show: true},
                     saveAsImage: {show: true}
                 }
             },*/
             hoverable : true,
             series : [
                 {
                     name:'影响因素分布图',
                     type:'treemap',
                     itemStyle: {
                         normal: {
                             label: {
                                 show: true,
                                 formatter: "{b}:{c}",
                                 textStyle: {
                                     color: '#777',
                                     fontSize: 10,
                                     fontStyle: 'normal',
                                     fontWeight:  'bold'
                                 },
                                 left: 'center'
                             },
                             borderWidth: 1,
                             borderColor: '#222'
                         },
                         emphasis: {
                             label: {
                                 show: true,
                                 textStyle: {
                                     color: '#777',
                                     fontFamily: 'Times New Roman",Georgia,Serif',
                                     fontSize: 18,
                                     fontStyle: 'normal',
                                     fontWeight:  'bold'
                                 }
                             },
                             color: '#cc99cc',
                             borderWidth: 3,
                             borderColor: '#996699'
                         }
                     },
                     data:[
                         {
                             name: '案件事实部分',
                             value: 42,
                             itemStyle: {
                                 normal: {
                                     label: {
                                         show: true,
                                         formatter : "{b}",
                                         x: 60,
                                         y: 65
                                     },
                                     color: '#ccff99',
                                     borderWidth: 1,
                                     borderColor: '#777'
                                 },
                                 emphasis: {
                                     label: {
                                         show: true,
                                         formatter : "{b}-{c}",
                                         x: 80,
                                         y: 85
                                     },
                                     color: '#cc9999',
                                     borderWidth: 3,
                                     borderColor: '#999999'
                                 }
                             },
                             children: [
                                 {
                                     name: '案情复杂（34.7%）',
                                     value: 38
                                 },
                                 {
                                     name: '法律\n关系\n复杂\n（0.8%）',
                                     value: 1
                                 },
                                 {
                                     name: '案情\n需要\n（0.8%）',
                                     value: 1
                                 },
                                 {
                                     name: '不宜\n适用\n简易\n程序\n（1.6%）',
                                     value: 2
                                 }
                             ]
                         },
                         {
                             name: '下落不明或无法送达',
                             value: 51,
                             itemStyle: {
                                 normal: {
                                     color: '#99ccff',
                                     borderColor: '#777'
                                 },
                                 emphasis: {
                                     label: {
                                         show: false
                                     }
                                 }
                             },
                             children: [
                                 {
                                     name: '当事人下落不明（35.5%）',
                                     value: 43
                                 },
                                 {
                                     name: '材料\n无法\n直接\n送达\n（6.6%）',
                                     value: 8
                                 }
                             ]
                         },
                         {
                             name: '直接转为\n普通程序\n（9.9%）',
                             value: 12,
                             itemStyle: {
                                 normal: {
                                     color: '#9999cc',
                                 }
                             }
                         },
                         {
                             name: '当事人提出',
                             value: 4,
                             itemStyle: {
                                 normal: {
                                     color: '#99cccc',
                                     borderColor: '#777'
                                 }
                             },
                             children: [
                                 {
                                     name: '当事人\n申请\n（1.6%）',
                                     value: 2
                                 },
                                 {
                                     name: '审计\n鉴定\n评估\n（0.8%）',
                                     value: 1
                                 },
                                 {
                                     name: '依法\n裁定\n中止\n诉讼\n（0.8%）',
                                     value: 1
                                 }
                             ]
                         },
                         {
                             name: '当事人提起反诉（2.47%）',
                             value: 3,
                             itemStyle: {
                                 normal: {
                                     color: '#ccffcc',
                                     borderColor: '#777',
                                     label: {
                                         show: true,
                                         left: 'center'
                                     }
                                 }
                             }
                         },
                         {
                             name: '程序\n提出\n异议\n（0.8%）',
                             value: 1,
                             itemStyle: {
                                 normal: {
                                     color: '#ccccff',
                                     borderColor: '#777'
                                 }
                             }
                         },
                         {
                             name: '追加当事人\n（6.6%）',
                             value: 8,
                             itemStyle: {
                                 normal: {
                                     color: '#cc9999',
                                     borderColor: '#777'
                                 }
                             }
                         }
                     ]
                 }
               ]
            });    
       }
</script>
</body>
</html>
