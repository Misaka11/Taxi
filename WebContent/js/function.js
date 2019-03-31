    function searchPath(str)//输入车牌和当前日期，显示路径
    {
        //根据车牌号str从后端传入经纬度
        console.log("车牌号："+str);
        var data=new Object();
        data.sj=NowTime;
        data.car=str;
        postAjax("GetPathServlet",data,searchPathFeedback);
    }
    
    function searchPathFeedback(result)
    {
        cars = eval("("+result+")");//把响应内容转成javascript对象
        console.log(cars);
    }
    
    function searchCars(str)//根据时间，显示车辆分布
    {
        console.log("查询时间："+str);
        var data=new Object();
        data.sj=str;
        postAjax("GetSjServlet",data,searchCarsFeedback);
    }
    
    
    function searchCarsFeedback(result)
    {
        carsPos = eval("("+result+")");//把响应内容转成javascript对象
        console.log(carsPos.length);
    }

    function searchNowCars(str)//实时显示车辆位置+热点区域中心点
    {
    	console.log("当前时间："+str);
    	var data=new Object();
    	data.sj=str;
    	console.log(data);
    	postAjax("CarsSjNowServlet",data,searchCarsFeedback);
    }
    
    function searchDeal()//查询十分钟内完成的交易记录
    {
    	var data=getTimeDuring(10);
    	console.log(data);
    	postAjax("DealServlet",data,searchDealFeedback);
    }
    
    function searchDealFeedback(result)
    {
    	deals=eval("("+result+")");
    	console.log(deals);
    }
    
    function searchSCPos()
    {
    	var data=getTimeDuring(30);
    	console.log(data);
    	postAjax("SCPosServlet",data,searchSCPosFeedback);
    }
    
    function searchSCPosFeedback(result)
    {
    	SCPos=eval("("+result+")");
 //   	console.log(SCPos.length);
    }
    
    function searchProduction()
    {
    	console.log("into pro");
    	postAjax("ProductionServlet",{},searchProductionFeedback);
    }
    
    function searchProductionFeedback(result)
    {
    	console.log(result);
    	production=eval("("+result+")");
    	console.log(production);
        var data = {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                series: [{
                    name: 'series-real',
                    data: production.carsNum,
                }, {
                    name: 'series-projection',
                    data: production.driversNum,
                }]
            };

            options = {
                fullWidth: true,
                lineSmooth: false,
                height: "270px",
                low: 0,
                high: 'auto',
                series: {
                    'series-projection': {
                        showArea: true,
                        showPoint: true,
                        showLine: true
                    },
                },
                axisX: {
                    showGrid: false,

                },
                axisY: {
                    showGrid: true,
                    onlyInteger: true,
                    offset: 0,
                },
                chartPadding: {
                    left: 20,
                    right: 20
                }
            };
            new Chartist.Line('#visits-trends-chart', data, options);
    }
    
    function searchRevenue(month)
    {
        var month = document.getElementById("display_time").value;
        console.log(month);
    	var date=new Object();
    	date.month=month[5]+month[6];
        console.log(date);
    	postAjax("RevenueServlet",date,searchRevenueFeedback);
    }
    
    function searchRevenueFeedback(result)
    {
        console.log(revenue);
    	revenue=eval("("+result+")");
    	console.log(revenue);
        document.getElementById("tb").innerHTML = "";
        for (var i = 0; i <10; i++) {
            add(i+1,revenue.cph[i],revenue.money[i]);
        }
        document.getElementById("zonge").innerHTML = "营业总额："+revenue.sum;
    }
    function add(pm,cph,yye){
        //获取table
        var tab = document.getElementById("tb");
        //创建元素
        var tr = document.createElement("tr");
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        var td3 = document.createElement("td");
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tab.appendChild(tr);
        td1.innerHTML = pm;
        td2.innerHTML = cph;
        td3.innerHTML = yye;

    }
    function showRl(data)
    {
        document.getElementById("rl").innerHTML = "";
        for (var i = 0; i <data.length; i++) {
            addrl(i+1,data[i]);
        }
    }
    function addrl(pm,cph){
        //获取table
        var tab = document.getElementById("rl");
        //创建元素
        var tr = document.createElement("tr");
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        tr.appendChild(td1);
        tr.appendChild(td2);
        tab.appendChild(tr);
        td1.innerHTML = pm;
        td2.innerHTML = cph;

    }
    function postAjax(url,param,callback){
        $.ajax({
            url : url,
            type : 'GET',
            data : param,
            dataType : 'text',
            success : function(data) {
//            	    console.log(data);
                    callback(data);
            },
            error : function(data, status, e) {
                alert(e);
            },
            complete : function() {
            }
        });
    }
    
    function getAjax(url,param){
        var info;
        $.ajax({
            url : url,
            type : 'GET',
            data : param,
            async: false,
            dataType : 'json',
            success : function(data, status) {
                if (status == "success") {
                    info= data;
                }
            },
            error : function(data, status, e) {
                alert(e);
            },
            complete : function() {
            }
        });
        return info;
    }

    function feedback(result)
    {
    	console.log("feedback");
    	if(result=="success") alert("操作成功！");
    	else alert("操作失败！");
    }


