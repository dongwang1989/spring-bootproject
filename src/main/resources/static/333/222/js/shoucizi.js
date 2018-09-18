function parseUrl(url) {
      var result = [];
      var obj = {};
      var query = url.split("?")[1];
      if (query) {
        if (query.indexOf('&') > -1) {
          var queryArr = query.split("&");
          queryArr.forEach(function (item) {
            var value = item.split("=")[1];
            var key = item.split("=")[0];
            obj[key] = value;
            result.push(obj);
          });
        } else {
          var value = query.split("=")[1];
          var key = query.split("=")[0];
          obj[key] = value;
          result.push(obj);
        }
      }
      return obj;
    }

	$(document).ready(function(){
		
	    var url = location.href;
        var data = parseUrl(url);
        //alert(unescape(data.license));
              //ajax请求后台数据
              getShopCustomerManagePageInfo(unescape(data.license));
              toPage();
              //点击搜索时 搜索数据
              $("#selectButton").click(function(){ 
                getShopCustomerManagePageInfo();
                currentPageAllAppoint = 1; //当点击搜索的时候，应该回到第一页
                toPage();//然后进行分页的初始化

              })
           

		});

        //分页参数设置 这些全局变量关系到分页的功能
        var startAllAppoint = 0;
        var limitAllAppoint = 10;
        var currentPageAllAppoint = 1;
        var totalPageAllAppoint = 0;
        var dataLength = 0;
        var last=0;
        var first=1;
        var pagesize=10;
       
        //ajax请求后台数据
        function getShopCustomerManagePageInfo(license){
        	//alert(license);
            $.ajax({
                type:"get",
                async:false,
                url:"/carfin/getall",               
                data:{"pageindex": currentPageAllAppoint, "pagesize": pagesize},
               
                success:function(data,status){
 
                    startAllAppoint = currentPageAllAppoint;
                    totalPageAllAppoint =data["totalpage"];
                    
                    last=totalPageAllAppoint;
                    getShopCustomesInfo(data);
          

                }
            });

        }



        function getShopCustomesInfo(data){
        	alert(data["list"].length);
        	var values;
        	for (var i = 0; i < data["list"].length; i++) {
        		values+='<tr style="height:40px;width:50px"><td>'+data["list"][i]["license"]+'</td> '+
				'<td>没有找到颜色字段</td>'+
				'<td>'+data["list"][i]["vehicleTypeName"]+'</td>'+
				'<td>'+data["list"][i]["vehicleColorName"]+'</td>'+
				'<td>'+data["list"][i]["platTypeName"]+'</td> '+
				'<td>'+data["list"][i]["platColorName"]+'</td>'+
				'<td>'+data["list"][i]["createTime"]+'</td></tr>';
        		//"caid":256,"pagesize":0,"listdto":null,"pageindex":0,"cagender":"男","cajob":"农民","camode":"密谋策划","caaddr":"繁华地段","caage":"中年","caclusters":3,"caot":"团伙作案","capro":"扰乱社会秩序案","catime":"下午","totpageSize":0
        	}
        	 $("#listvalues").html("");
             $("#listvalues").append(values);
       }


function toPage(){
        	
            layui.use(['form', 'laypage', 'layedit','layer', 'laydate'], function() {
                var form = layui.form(),
                    layer = layui.layer,
                    layedit = layui.layedit,
                    laydate = layui.laydate,
                    laypage = layui.laypage;

                var nums = 10;
               
                //调用分页
                  laypage({
                    cont: 'page'
                    ,pages: totalPageAllAppoint //得到总页数，在layui2.X中使用count替代了，并且不是使用"总页数"，而是"总记录条数"
                    ,curr: currentPageAllAppoint
                    ,first: 1
                    
                    ,last: last
                    ,prev: '<em><</em>'
                    ,next: '<em>></em>'
                    
                    ,skip: true
                    ,jump: function(obj, first){
                    //	alert("obj.curr:"+obj.curr);
                        currentPageAllAppoint = obj.curr;
                        startAllAppoint = (obj.curr-1)*limitAllAppoint;
                      //document.getElementById('biuuu_city_list').innerHTML = render(obj, obj.curr);
                      if(!first){ //一定要加此判断，否则初始时会无限刷新
                    	  
                      getShopCustomerManagePageInfo();
                          
                        }
                    }
                  });
             

            });
}
