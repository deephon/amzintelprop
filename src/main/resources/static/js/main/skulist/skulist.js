/**
 * Created by pzt on 2017/8/27.
 */
$(function(){
    var commonJs = {
        chosen : function(){
            var chosenItmes = $('select.chosen-select');
            chosenItmes.chosen({
                no_results_text: '没有找到',    // 当检索时没有找到匹配项时显示的提示文本
                disable_search_threshold: 2,    // 10 个以下的选择项则不显示检索框
                search_contains: true           // 从任意位置开始检索
            });
        },
         wdatePicker: function(){
            function wdate(id, setTime){
                window.L.open('wDate', {
                    'obj' : document.getElementById(id),    //需绑定的对象
                    'eventType' : 'focus',    //绑定的触发事件,默认click
                    'params' : {'readOnly' : true, 'dateFmt':'yyyy-MM-dd HH:mm:ss', startDate:'%y-%M-%d '+ setTime +'',}    //传递WdatePicker的参数

                });
            }
            wdate('startTime', '00:00:00');
            wdate('endTime', '23:59:59');
            wdate('cStartTime', '00:00:00');
            wdate('cEndTime', '23:59:59');
        },
        cancelBub: function(){
            var labelItems = $('#leadingOut');
            labelItems.on('click', '.dropdown-menu', function(e){
               commonJs.stopMp(e);
            });
        },
        stopMp: function(e){  // 阻止事件冒泡
         var e = e || window.event;
            if(e.stopPropagation){
                e.stopPropagation();
            }else{
                e.cancelBubble=true;
            }
        },
        toggleTr: function(){
            var trItems = $('.toggle-tr').find("td:eq(0)"),
                input = trItems.find('input'),
                dropdown = trItems.find('.dropdown'),
                lastTd = trItems.find('td:eq(9)'),
                operableLi = $(".dropdown-menu"),
                table = $("#appendSuit");
            table.on('click', '.slideToggle',function(){
                // debugger;
                var iconObj = $(this).find("i");
                if(iconObj.hasClass("glyphicon-chevron-left")){
                    iconObj.removeClass('glyphicon-chevron-left').addClass("glyphicon-chevron-down");
                    $(this).parent().next('tr').fadeIn();
                }else{
                    iconObj.removeClass('glyphicon-chevron-down').addClass("glyphicon-chevron-left");
                    $(this).parent().next('tr').hide();
                }
            });

            table.on("click", ".li-btn",function(){
                var $this = $(this),
                    oVal = $.trim($this.text()),
                    parentTr = $this.parents(".toggle-tr");
                    trEditableVal = parentTr.find(".editable"),
                    editObj = parentTr.next().find(".editable"),
                    arr = [];
                    trEditableVal.each(function(){
                        arr.push($(this));
                    });
                    editObj.each(function(){
                        arr.push($(this));
                    });
                if(oVal == "修改"){
                    if($(this).find("a").data('name')=='category'){
                        if($(this).find("a").data('status')==4 || $(this).find("a").data('status')==3){
                            layer.alert('已送审/已通过的品类不能进行修改', {icon: 5});
                            return false;
                        }
                    }
                    
                    for(var i= 0; i < arr.length; i++){
                        var thisVal = arr[i].text();
                        arr[i].html("<input type='text' style='width: 100%;' value="+ thisVal +">" );
                        if(arr[i].hasClass("declared_tax_code")){ // 申报税则号输入框数字与长度限定
                            arr[i].find("input").attr("maxlength", 10);
                            var noReg = /^[0-9]*$/;
                            arr[i].on("keyup", "input", function(){
                                var val = $(this).val();
                                if(!noReg.test(val)){
                                    $(this).val('');
                                }else if(val.length >= 10){
                                    var newVal = val.substr(0, 10);
                                    $(this).val(newVal);                                    
                                }
                            })
                        }
                        if(arr[i].prev().hasClass("export_rate")){ // 
                            arr[i].find("input").attr("placeholder", "限制2位小数(1.11%)");
                        }
                    }
                    $(this).find("a").text("保存");
                }else if(oVal == "保存"){
                    var $save = $(this);
                    for(var i = 0; i < arr.length; i++){
                        var newVal = arr[i].find("input").val();
                        if(newVal == "" && arr[i].hasClass("require")){
                            alert("必填项内容不能为空！");
                            arr[i].find("input").css("border", "1px solid red");
                            return;
                        }
                        arr[i].html(newVal);
                    }
                    $(this).find("a").text("修改");
                    if($(this).find("a").data('name')=='sku'){
                        var transportAttrArray = [];
                        var sku_tax_id=$(this).parents('.toggle-tr').data('id');
                        var declared_value= $(this).parents('.toggle-tr').find(".declared_value").text();
                        var declared_tax_code= $(this).parents('.toggle-tr').find(".declared_tax_code").text();
                        var pack_cn_name= $(this).parents('.toggle-tr').find(".pack_cn_name").text();
                        var pack_en_name= $(this).parents('.toggle-tr').find(".pack_en_name").text();
                        var fba_cn_name= $(this).parents('.toggle-tr').find(".fba_cn_name").text();
                        var fba_en_name= $(this).parents('.toggle-tr').find(".fba_en_name").text();
                        var fieldVal = new Object();;
                        var keys = parentTr.next("tr").find(".edit-key");
                        keys.each(function(){
                            if($(this).text()=="是否退税" || $(this).text()=="带符合目的国标准插头"){
                                fieldVal[$(this).text()] = $(this).next("td").find("input:radio:checked").val();
                            }else{
                                fieldVal[$(this).text()] = $(this).next("td").text();
                            }
                        });
                        var transportAttr = $save.parents(".toggle-tr").next("tr").find(".transportAttr");
                        transportAttr.each(function () {
                            if($(this).is(":checked")){
                                transportAttrArray.push($(this).val());
                            }
                        });
                        var datas = new Object();
                        datas['id']=sku_tax_id;
                        datas['declared_value']=declared_value;
                        datas['declared_tax_code']=declared_tax_code;
                        datas['pack_cn_name']=pack_cn_name;
                        datas['pack_en_name']=pack_en_name;
                        datas['fba_cn_name']=fba_cn_name;
                        datas['fba_en_name']=fba_en_name;
                        datas['tax_field']=fieldVal;
                        datas['transport_mode']=transportAttrArray;
                        var url = ROOT_URL + "/?c=skuInfo_skuTaxCtrl&a=taxSkuSave";
                        $.post(url,datas,function (data){
                            if (data.code == 200) {
                                layer.alert(data.msg, {icon: 1}, function() {
                                    window.location.reload();
                                });
                            } else {
                                layer.alert(data.msg, {icon: 5});
                                return false;
                            }
                        }, 'json');
                    }else{
                        if($(this).find("a").data('status')==4 || $(this).find("a").data('status')==3){
                            layer.alert('已送审/已通过的品类不能进行添加税则', {icon: 5});
                            return false;
                        }
                        var transportAttrArray = [];
                        var category_id=$('#category_id').data('id');
                        var taxid=$(this).parents('.toggle-tr').data('id');
                        var id=$(this).parents('.toggle-tr').data('itemid');
                        var declared_value= $(this).parents('.toggle-tr').find(".declared_value").text();
                        var declared_tax_code= $(this).parents('.toggle-tr').find(".declared_tax_code").text();
                        var pack_cn_name= $(this).parents('.toggle-tr').find(".pack_cn_name").text();
                        var pack_en_name= $(this).parents('.toggle-tr').find(".pack_en_name").text();
                        var fba_cn_name= $(this).parents('.toggle-tr').find(".fba_cn_name").text();
                        var fba_en_name= $(this).parents('.toggle-tr').find(".fba_en_name").text();
                        var vat_rate= $(this).parents('.toggle-tr').find(".vat_rate").text();
                        var nation_rate= $(this).parents('.toggle-tr').find(".nation_rate").text();
                        var lacal_rate= $(this).parents('.toggle-tr').find(".lacal_rate").text();
                        var fieldVal = new Object();
                        var keys = parentTr.next("tr").find(".edit-key");
                        keys.each(function(){
                            if($(this).text()=="是否退税" || $(this).text()=="带符合目的国标准插头"){
                                fieldVal[$(this).text()] = $(this).next("td").find("input:radio:checked").val();
                            }else{
                                fieldVal[$(this).text()] = $(this).next("td").text();
                            }
                        });
                        var transportAttr = $save.parents(".toggle-tr").next("tr").find(".transportAttr");
                        transportAttr.each(function () {
                            if($(this).is(":checked")){
                                transportAttrArray.push($(this).val());
                            }
                        });
                        var datas = new Object();
                        datas['category_id']=category_id;
                        datas['taxid']=taxid;
                        datas['id']=id;
                        datas['declared_value']=declared_value;
                        datas['declared_tax_code']=declared_tax_code;
                        datas['pack_cn_name']=pack_cn_name;
                        datas['pack_en_name']=pack_en_name;
                        datas['fba_cn_name']=fba_cn_name;
                        datas['fba_en_name']=fba_en_name;
                        datas['vat_rate']=vat_rate;
                        datas['nation_rate']=nation_rate;
                        datas['lacal_rate']=lacal_rate;
                        datas['tax_field']=fieldVal;
                        datas['transport_mode']=transportAttrArray;
//                        console.log(datas);
                        var url = ROOT_URL + "/?c=tax_taxCtrl&a=taxSave";
                        $.post(url,datas,function (data){
                            if (data.code == 200) {
                                layer.alert(data.msg, {icon: 1}, function() {
                                    window.location.reload();
                                });
                            } else {
                                layer.alert(data.msg, {icon: 5});
                                return false;
                            }
                        }, 'json');
                    }
                    

                }else if(oVal == "移除"){
                    if($(this).find("a").data('name')=='sku'){
                        parentTr.next().remove();
                        parentTr.remove();
                        var sku_tax_id=$(this).parents('.toggle-tr').data('id');
                        var datas = new Object();
                        datas['id']=sku_tax_id;
                        var url = ROOT_URL + "/?c=skuInfo_skuTaxCtrl&a=skuTaxDel";
                        $.post(url,datas,function (data){
                            if (data.code == 200) {
                                var obj = $("#selectCategory");
                                skuInfo.keep(obj, 1);
                                layer.alert(data.msg, {icon: 1});
                                   // window.location.reload();
                            } else {
                                layer.alert(data.msg, {icon: 5});
                                return false;
                            }
                        }, 'json');
                    }else{
                        if($(this).find("a").data('status')==4 || $(this).find("a").data('status')==3){
                            layer.alert('已审核/已通过的品类不能进行添加税则', {icon: 5});
                            return false;
                        }
                        parentTr.next().remove();
                        parentTr.remove();
                        var category_id=$('#category_id').data('id');
                        var taxid=$(this).parents('.toggle-tr').data('id');
                        var id=$(this).parents('.toggle-tr').data('itemid');
                        var datas = new Object();
                        datas['category_id']=category_id;
                        datas['taxid']=taxid;
                        datas['id']=id;
                        var url = ROOT_URL + "/?c=tax_taxCtrl&a=taxDel";
                        $.post(url,datas,function (data){
                            if (data.code == 200) {
                                layer.alert(data.msg, {icon: 1}, function() {
                                    window.location.reload();
                                });
                            } else {
                                layer.alert(data.msg, {icon: 5});
                                return false;
                            }
                        }, 'json');
                    }
                    
                    
                }
            });
            // input.click(function(e){
            //     commonJs.stopMp(e);
            // });
            // lastTd.click(function(e){
            //     $(this).find('.dropdown-menu').dropdown('toggle');
            //     commonJs.stopMp(e);
            // });
        },
        newField: function(){  // 字段配置页面新增字段功能
            var addField = $('.btn-addField'),
                cancelBtn = $('.btn-cancel'),
                editField = $('#editField'),
                delField = $('#delField');
            addField.on('click', function(){
                if(editField.length > 0 && editField.text() == "保存") {
                    alert("请先保存修改中的字段!");
                    cancelBtn.click();
                    return
                };
                if(delField.length > 0 && delField.text() == "保存") {
                    alert("请先保存删除后的字段!");
                    cancelBtn.click();
                    return
                };
                var fieldName = $('#fieldName'),
                    val = $.trim(fieldName.val()),
                    container = $('#sortable1'),
                    tag = $('#selectType .chosen-single').find("span").text();
                if(val){
                    var html = "<li class='ui-state-default yks-pr' data-tag='"+ tag +"'>" + val + "<i class='delLi glyphicon glyphicon-remove'></i></li>";
                    container.append(html);
                    fieldName.val('');
                    cancelBtn.click();
                }else{
                    alert('字段名不能为空！');
                    return;
                }
            })
        },
        editField: function(){  // 字段配置页面修改字段功能
            if($("#sortable1").length > 0) $("#sortable1").sortable(); // 初始化拖拽功能
            var editField = $('#editField'),
                delField = $('#delField');
            editField.on('click', function(){
                if(delField.length > 0 && delField.text() == "保存") {
                    alert("请先完成字段删除操作!");
                    return
                }; 
                var sortable = $('#sortable1'),
                    items = $('#sortable1').find('li'),
                    val = $.trim($(this).text()),
                    $this = $(this);
                   if(val == '修改'){
                       $(this).text('保存');
                       items.css('border', '1px solid red');
                       (function(){
                            sortable.on('click', 'li', function(){
                                if(items.find('input').length > 0) {
                                    if($.trim(items.find('input').val()) == ""){
                                        return
                                    }
                                };
                                var oldVal = $(this).html();
                                $(this).html('<input text="text" style="height: 20px">');
                                var editState = $(this).find('input');
                                editState.focus();
                                editState.on(
                                    {
                                        'click': function(e){commonJs.stopMp(e)},
                                        'blur' : function(){
                                            var value = $.trim($(this).val()),
                                                $thisParent = $(this).parent('li');
                                            if(value == ''){
                                                $thisParent.html(oldVal);
                                            }else{
                                                $thisParent.html(value + "<i class='delLi glyphicon glyphicon-remove'></i>");
                                            }
                                        }   
                                    }
                                )
                            });
                       })();
                   }else{
                        var inputItems = $('#sortable1 li').find('input');
                        if(inputItems.length > 0){
                            inputItems.each(function(){
                                var value = $.trim($(this).val());
                                if(value == ''){
                                    alert("字段内容不能为空！");
                                    $(this).focus();
                                    return false;
                                }else{
                                    $this.text('修改');
                                    items.css('border', '1px solid #c5c5c5');
                                }
                            })
                        }else{
                            $this.text('修改');
                            items.css('border', '1px solid #c5c5c5');
                            sortable.off('click'); // 卸载所有事件，一旦保存则禁止修改
                        }
                   }
            });
        },
        delField: function(){ // 字段配置页面删除字段功能
            var delBtn = $("#delField"),
                editField = $('#editField');
            delBtn.on("click", function(){
                if(editField.length>0 && editField.text() == "保存") {
                    alert("请先完成字段修改操作!");
                    return
                };
                var sortable = $('#sortable1'),
                    items = $('#sortable1 li').find('i');
                if($.trim($(this).text()) == '删除'){
                    $(this).text("保存");
                    items.show();
                    sortable.on('click', 'i', function(){
                        $(this).parent("li").remove();
                    })
                }else{
                    $(this).text("删除");
                    items.hide();
                }
            });
        },
        selectType: function(){
            var selectOpts = $("#selectType"),
            sortable = $("#sortable1"),    
            items = sortable.find("li"),
            loadVal = selectOpts.find(".chosen-single span").text();
            items.each(function(){
                if($(this).data("tag") == loadVal){
                    $(this).removeClass("yks-dn");
                }
            });
            selectOpts.on("click", ".active-result", function(){
                var currentVal = $(this).text(),
                    liItems = $("#sortable1").find('li');
                console.log(currentVal);
                liItems.addClass("yks-dn");
                liItems.each(function(){
                    if($(this).data("tag") == currentVal){
                        $(this).removeClass("yks-dn");
                    }
                })
            });
        },
        addTr: function(){
            var addBtn = $('#addTr'),
                addTbody = $('#addTbody');
                addBtn.on('click', function(){
                var html =  '<tr class="">\
                                <td>1%</td>\
                                <td>1%</td>\
                                <td>1%</td>\
                                <td>\
                                    <select class="chosen-select form-control" name="status">\
                                        <option value="" class="empty-opt">请先择</option>\
                                        <option value="1">中国</option>\
                                        <option value="2">美国</option>\
                                        <option value="0">欧盟</option>\
                                    </select>\
                                </td>\
                                <td>\
                                    <div class="dropdown">\
                                        <button class="btn btn-info btn-sm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">操作\
                                        <span class="caret"></span>\
                                        </button>\
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">\
                                            <li><a onclick="" class="del">删除</a></li>\
                                        </ul>\
                                    </div>\
                                </td>\
                            </tr>';
                    addTbody.append(html);
                    commonJs.chosen();
                });
        },
        delTr: function(){
            delTbody = $('#addTbody');
            delTbody.on("click", ".del", function(){
                $(this).parents('tr').remove();
            });
        },
        init : function(){
            commonJs.chosen();      // 初始化带搜索框的select列表
            commonJs.wdatePicker(); // 日期控件调用
            commonJs.cancelBub();   // 阻止事件冒泡
            commonJs.toggleTr();    // 品类详情页 动态显示隐藏tr
            commonJs.newField();    // 字段配置页面增加字段
            commonJs.editField();   // 字段配置页面修改字段
            commonJs.delField();    // 字段配置页面删除字段
            commonJs.selectType();  // 字段配置页面选择类型
            commonJs.addTr();       // 新增税则页面动态增加表格内容
            commonJs.delTr();       // 新增税则页面动态删除表格内容
        }
    }
    commonJs.init();
});
