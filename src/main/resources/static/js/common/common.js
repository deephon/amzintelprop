var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;
var webPath = localObj.protocol + "//" + localObj.host;
var common = {
    cancel:0,
    showAddOrEdit: function (title, url) {
        layer.open({
            type: 2,
            title: title,
            closeBtn:2,
            maxmin: false,
            shadeClose: false, //点击遮罩关闭层
            area: ['780px', '480px'],
            content: webPath+url,
            cancel:function(i,j){
                common.cancel = 2;
            },
            end: function () {
                if(common.cancel === 0){
                    location.reload();
                }
            }
        });
    },
	showAddOrEdit2: function (title, url,len,wei) {
		layer.open({
			type: 2,
			title: title,
			maxmin: false,
			shadeClose: false, //点击遮罩关闭层
			area: [len, wei],
			content: webPath + url,
			cancel:function(i,j){
				common.cancel = 2;
			},
			end: function () {
				if(common.cancel === 0){
					location.reload();
				}
			}
		});
    },
    close:function(status){
        if(status == 200){//请求成功时
            common.cancel = 0;
            layer.closeAll();
        }
        if(status == 201){//点击取消按钮时
            common.cancel = 1;
            layer.closeAll();
        }
    },
    sleep:function(time){
        var start = new Date().getTime();
        while (new Date().getTime() < start + time);
    },
    showMessage:function(status,message){
        var icon = 6;
        common.cancel = 0;
        if(status != 200){
            icon = 5;
            common.cancel = 1;
        }
        var messageId = layer.alert(message, {icon: icon,closeBtn: 0}, function(){
            if(status == 200){
                layer.closeAll();
            }else{
                layer.close(messageId);
            }
        });
    },
    reload:function(href){
        if(href){
            location.href = href;
        }else{
            location.reload();
        }
    },
    toAction:function (action) {
        form1.action = action;
        form1.submit();
    },
    delete:function (url,product_id) {
        var result = "";
        if (confirm('确定删除吗？')) {
            $.ajax({
                url:webPath + url,
                data:{
                    id:product_id
                },
                type:'get',
                async: false,
                success:function (data) {
                    if(data.success ===200) {
                        result = data.url;
                    }
                }
            });
            if (result.length > 0) {
                window.open(result,"_self");
            }
        }
    }
};