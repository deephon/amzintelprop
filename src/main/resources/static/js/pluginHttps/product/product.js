var product ={
    updateReference:function (url,id,referenceIndex) {
        var reference = $("#reference" + referenceIndex).val();
        $.ajax({
            url:webPath+url,
            data:{
                id:id,
                reference:reference
            },
            type:'post',
            dataType:'json',
            success:function (data) {
                layer.msg(data.result, {time: 3000});
            }
        })
    },
    updateEmploy:function (url,id,employIndex) {
        var employ = $("#employ" + employIndex).val();
        $.ajax({
            url:webPath + url,
            data:{
                id:id,
                employ:employ
            },
            type:'post',
            dataType:'json',
            success:function (data) {
                layer.msg(data.result, {time: 3000});
            }
        })
    }
};

(function(){
    $("#start_date").jeDate({
        format: "YYYY-MM-DD",
        //isinitVal:true,
        //isTime:true, //isClear:false,
        minDate: "2014-09-19 00:00:00"
    });
    $("#end_date").jeDate({
        format: "YYYY-MM-DD",
        //isinitVal:true,
        //isTime:true, //isClear:false,
        minDate: "2014-09-19 00:00:00"
    });

})();