/**
 * Created by ycfeng on 2016/9/18.
 */
// 基于准备好的dom，初始化echarts实例

// 指定图表的配置项和数据

var MyCharts = {
    getChart:function(){
        var myChart = echarts.init(document.getElementById("main"));
        var option = {
            title: {
                text: '呵呵哒示例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };
        myChart.setOption(option);
    }
}
/**
     1.解析HTML结构
     2.加载外部的脚本和样式文件
     3.解析并执行脚本代码
     4.执行$(function(){})内对应代码
     5.加载图片等二进制资源
     6.页面加载完毕，执行window.onload
 */
// 使用刚指定的配置项和数据显示图表。
$(function(){
    MyCharts.getChart();
})