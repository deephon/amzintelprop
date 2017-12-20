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
    common.grid({
        title:"账号信息"
        ,url:getUrl()
        ,rownumbers: true
        ,colNames:[ '账号', '负责人', '联系方式', '备注说明' ,'操作']
        ,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
            {name : 'account_id',index : 'account_id',width : 80,hidden:true, sortable:false,resizable:false},
            {name : 'account',index : 'account',width : 255},
            {name : 'principal',index : 'principal',width : 255},
            {name : 'contact',index : 'contact',width : 205},
            {name : 'remark',index : 'remark',width : 205},
            {name : 'quantity',index : 'quantity',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
            {name : 'sales',index : 'sales',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}
        ]
        ,sortname:"reportDate"
        ,sortorder:"desc"
    });
    $("#jqGridId").jqGrid('setLabel', 0, '序号', 'labelstyle');
})();