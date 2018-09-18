$(document).ready(function(){
	
              //ajax请求后台数据
              getShopCustomerManagePageInfo();
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
        function doR()
        {
        	$.ajax({
                type:"GET",
                async:false,
                url:"/police/doRInt",
                data:{},
                //data:{start:startAllAppoint, limit:limitAllAppoint,selectValue:$("#selectValue").val()},
                success:function(data,status){
                //	alert(data);
                  
                	getShopCustomerManagePageInfo();

                }
            });
        }
        //ajax请求后台数据
        function getShopCustomerManagePageInfo(){
        	//alert("asd");
            $.ajax({
                type:"get",
                async:false,
                url:"/policepred/serachBy",
                data:{"pageindex": currentPageAllAppoint, "pagesize": pagesize},
               
                success:function(data,status){
 
                    startAllAppoint = currentPageAllAppoint;
                    totalPageAllAppoint =data["totalpages"];
                    
                    last=totalPageAllAppoint;
                    getShopCustomesInfo(data);
          

                }
            });

        }



        function getShopCustomesInfo(data){
        	//alert("进入解析data展示"+data["list"].length);
        	
        	var values;
        	for (var i = 0; i < data["list"].length; i++) {
        		values+='<tr style="height:40px;width:50px"><td>'+data["list"][i]["fOrgname"]+'</td> '+
				'<td>'+data["list"][i]["fCommunityName"]+'</td>'+
				'<td>'+data["list"][i]["fAlarmType"]+'</td>'+
				'<td>'+data["list"][i]["fAlarmDate"]+'</td>'+
				'<td>'+data["list"][i]["guesvalue"]+'</td> </tr>';
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
        };