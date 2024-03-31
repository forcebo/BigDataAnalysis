//
$(function () {
    // 左1
    var xdata1=new Array();
    var ydata1=[]
    $.ajax({ //左1
        type : "post", // 请求方式
        url : "/comment/headphonecomment", //请求地址
        data :null, //参数
        success : function(res) {  //成功回调函数
            for(var i=0;i<res.length;i++){
                xdata1.push(res[i].h_title);
                ydata1.push(res[i].h_commentCountStr);
            }
            echart_1();
        }
    });//左1
    // 右1
    var xdata2=new Array();
    var ydata2=[]
    $.ajax({ //右1
        type : "post", // 请求方式
        url : "/comment/headphonegoodcomment", //请求地址
        data :null, //参数
        success : function(res) {  //成功回调函数
            for(var i=0;i<res.length;i++){
                xdata2.push(res[i].h_title);
                ydata2.push(res[i].h_goodcommentCountStr);
            }
            echart_2();
        }
    });//右1

    // 左2
    var xdata3=new Array();
    var ydata3=[]
    $.ajax({ //左2
        type : "post", // 请求方式
        url : "/comment/speakercomment", //请求地址
        data :null, //参数
        success : function(res) {  //成功回调函数
            for(var i=0;i<res.length;i++){
                xdata3.push(res[i].s_title);
                ydata3.push(res[i].s_commentCountStr);
            }
            echart_3();
        }
    });//左2

    // 右2
    var data4;
    $.ajax({ //右2
        type : "post",
        url : "/comment/speakergoodcomment",
        data :null,
        success : function(res) {
            // console.log(res);
            data4=res;
            var num=100;
            for (var i = 0; i < data4.length; i++) {
                data4[i].name=data4[i].s_title
                data4[i].number=data4[i].s_goodcommentCountStr;
                data4[i].value=num;
                num-=10;
            }
            echart_4();
        }
    }); //右2

    function echart_1() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_1'));

        option = {
            //  backgroundColor: '#00265f',
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            grid: {
                left: '0%',
                top:'10px',
                right: '0%',
                bottom: '4%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                data:xdata1,
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "rgba(255,255,255,.1)",
                        width: 1,
                        type: "solid"
                    },
                },

                axisTick: {
                    show: false,
                },
                axisLabel:  {
                    interval: 0,
                    // rotate:50,
                    show: true,
                    splitNumber: 15,
                    textStyle: {
                        color: "rgba(255,255,255,.6)",
                        fontSize: '12',
                    },
                },
            }],
            yAxis: [{
                type: 'value',
                axisLabel: {
                    //formatter: '{value} %'
                    show:true,
                    textStyle: {
                        color: "rgba(255,255,255,.6)",
                        fontSize: '12',
                    },
                },
                axisTick: {
                    show: false,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "rgba(255,255,255,.1	)",
                        width: 1,
                        type: "solid"
                    },
                },
                splitLine: {
                    lineStyle: {
                        color: "rgba(255,255,255,.1)",
                    }
                }
            }],
            series: [
                {
                    name: '总评论数',
                    type: 'bar',
                    // data: [200, 300, 300, 900, 1500, 1200, 600]
                    data: ydata1,
                    barWidth:'35%', //柱子宽度
                    // barGap: 1, //柱子之间间距
                    itemStyle: {
                        normal: {
                            color:'#f6d707',
                            opacity: 1,
                            barBorderRadius: 5,
                        }
                    }
                }
            ]
        }

        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echart_2() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_2'));

        option = {
            //  backgroundColor: '#00265f',
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            grid: {
                left: '0%',
                top:'10px',
                right: '0%',
                bottom: '4%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                // data: ['商超门店', '教育培训', '房地产', '生活服务', '汽车销售', '旅游酒店', '五金建材'],
                data:xdata2,
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "rgba(255,255,255,.1)",
                        width: 1,
                        type: "solid"
                    },
                },

                axisTick: {
                    show: false,
                },
                axisLabel:  {
                    interval: 0,
                    // rotate:50,
                    show: true,
                    splitNumber: 15,
                    textStyle: {
                        color: "rgba(255,255,255,.6)",
                        fontSize: '12',
                    },
                },
            }],
            yAxis: [{
                type: 'value',
                axisLabel: {
                    //formatter: '{value} %'
                    show:true,
                    textStyle: {
                        color: "rgba(255,255,255,.6)",
                        fontSize: '12',
                    },
                },
                axisTick: {
                    show: false,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "rgba(255,255,255,.1	)",
                        width: 1,
                        type: "solid"
                    },
                },
                splitLine: {
                    lineStyle: {
                        color: "rgba(255,255,255,.1)",
                    }
                }
            }],
            series: [
                {
                    name: '好评数',
                    type: 'bar',
                    // data: [200, 300, 300, 900, 1500, 1200, 600]
                    data: ydata2,
                    barWidth:'35%', //柱子宽度
                    // barGap: 1, //柱子之间间距
                    itemStyle: {
                        normal: {
                            color:'#07f1d7',
                            opacity: 1,
                            barBorderRadius: 5,
                        }
                    }
                }
            ]
        }

        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echart_3() {
        var myChart = echarts.init(document.getElementById('chart_3'));
        option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: { type: 'shadow'}
            },
            grid: {
                left: '0%',
                top:'10px',
                right: '0%',
                bottom: '4%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                data:xdata3,
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "rgba(255,255,255,.1)",
                        width: 1,
                        type: "solid"
                    },
                },
                axisTick: {
                    show: false,
                },
                axisLabel:  {
                    interval: 0,
                    // rotate:50,
                    show: true,
                    splitNumber: 15,
                    textStyle: {
                        color: "rgba(255,255,255,.6)",
                        fontSize: '12',
                    },
                },
            }],
            yAxis: [{
                type: 'value',
                axisLabel: {
                    //formatter: '{value} %'
                    show:true,
                    textStyle: {
                        color: "rgba(255,255,255,.6)",
                        fontSize: '12',
                    },
                },
                axisTick: {
                    show: false,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "rgba(255,255,255,.1	)",
                        width: 1,
                        type: "solid"
                    },
                },
                splitLine: {
                    lineStyle: {
                        color: "rgba(255,255,255,.1)",
                    }
                }
            }],
            series: [
                {
                    type: 'bar',
                    data: ydata3,
                    barWidth:'35%', //柱子宽度
                    // barGap: 1, //柱子之间间距
                    itemStyle: {
                        normal: {
                            color:'#27d08a',
                            opacity: 1,
                            barBorderRadius: 5,
                        }
                    }
                }
            ]
        };
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echart_4(){
        var myChart= echarts.init(document.getElementById("chart_4"));
        option = {
            // backgroundColor: "#ffffff",
            color: ['#37a2da','#32c5e9','#9fe6b8','#ffdb5c','#ff9f7f','#fb7293','#e7bcf3','#8378ea'],
            // color: 'rgba(243,246,244,0)',
            tooltip: {
                trigger: 'item',
                // formatter: "{b} : {c}",
                formatter: function(d){
                    var ins = d.name + ' : ' + d.data.number;
                    return ins
                },
            },
            calculable: true,
            series: [
                {
                    name:'好评数',type:'funnel',left: '5%', right:'5%',
                    top: 10,
                    bottom: 60,
                    width: '90%',
                    height:'90%',
                    min: 0,
                    max: 100,
                    minSize: '50%',
                    maxSize: '100%',
                    sort: 'descending',
                    gap: 2,
                    label: {
                        normal: {
                            show: true,
                            position: 'inside',

                        },
                        emphasis: {
                            textStyle: {
                                fontSize: 20,

                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            length: 10,
                            lineStyle: {
                                width: 1,
                                type: 'solid',

                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            borderColor: '#fff',
                            borderWidth: 0.1
                        }
                    },
                    data:data4,
                }
            ]
        };
        myChart.setOption(option);
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }
})