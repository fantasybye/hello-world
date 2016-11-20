<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
<title>Risk Chart</title>
</head>
<body>
	<form class="chart">
	<div id="mostpro" style="width: 50%;height:400px;float:left"></div>
	<div id="mostide" style="width: 50%;height:400px;float:left"></div>
	<s:iterator id="recdata" value="recognized" >
   		 <td id="rrname"><s:property value="#recdata.riskName"/></td>
   		 <td id="rrnum"><s:property value="#recdata.num" /></td>
	</s:iterator>
	
	<s:iterator id="topdata" value="toProblem" >
   		 <td id="prname"><s:property value="#topdata.riskName"/></td>
   		 <td id="prnum"><s:property  value="#topdata.num" /></td>
	</s:iterator>
	<script type="text/javascript" src="echarts.common.min.js"></script>
	<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
    <script type="text/javascript">  
    	var recnamelist = new Array();
    	var recnumlist = new Array();
    	var topnamelist = new Array();
    	var topnumlist = new Array();
	    $(function() {	    	
	        $.each($('#recdata #rrname'), function(i, o) {
	        	recnamelist[i]=($(o).attr('value'));
	        });
	        $.each($('#recdata #rrnum'), function(i, o) {
	        	recnumlist[i]=($(o).attr('value'));
	        });
	        $.each($('#topdata #prname'), function(i, o) {
	        	topnamelist[i]=($(o).attr('value'));
	        });
	        $.each($('#topdata #prnum'), function(i, o) {
	        	topnumlist[i]=($(o).attr('value'));
	        });
	    });
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
                data:['数量'],
                show:false
            },
            xAxis: {
                data: topnamelist,
            	name: '风险名称'
            },
            yAxis: {
            	name: '数量'
            },
            series: [{
                name: '数量',
                type: 'bar',
                data: topnumlist               
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
                data:['数量'],	
            	show:false
            },
            xAxis: {
                data: recnamelist,
            	name: '风险名称'
            },
            yAxis: {
            	name: '数量'
            },
            series: [{
                name: '数量',
                type: 'bar',
                data: recnumlist
            }],
        };

        // 使用刚指定的配置项和数据显示图表。
        mostideChart.setOption(mostideOption);
        
     
    </script>
    </form>
</body>
</html>