<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="echarts.common.min.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
<title>Risk Chart</title>
</head>
<body>
	<form class="chart">
	<div id="mostpro" style="width: 50%;height:400px;float:left"></div>
	<div id="mostide" style="width: 50%;height:400px;float:left"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var mostproChart = echarts.init(document.getElementById('mostpro'));

        // 指定图表的配置项和数据
        var mostproOption = {
            title: {
                text: 'Risks With The Most Promblems',
                left: 'center'
            },
            tooltip: {},
            legend: {
                data:['销量'],
                show:false
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"],
            	name: '风险名称'
            },
            yAxis: {
            	name: '数量'
            },
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]               
            }],
            color: ['#b0e0e6']
        };

        // 使用刚指定的配置项和数据显示图表。
        mostproChart.setOption(mostproOption);
        
   
        // 基于准备好的dom，初始化echarts实例
        var mostideChart = echarts.init(document.getElementById('mostide'));

        // 指定图表的配置项和数据
        var mostideOption = {
            title: {
                text: 'Risk With The Most Idenfications',
                left: 'center'
            },
            tooltip: {},
            legend: {
                data:['销量'],	
            	show:false
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"],
            	name: '风险名称'
            },
            yAxis: {
            	name: '数量'
            },
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }],
        };

        // 使用刚指定的配置项和数据显示图表。
        mostideChart.setOption(mostideOption);
        
     
    </script>
    </form>
</body>
</html>