var page = {
    curPage : $("#curPage").val(),
    pageCount : $("#pageCount").val(),
    pageSize : $("#pageSize2").val(),


    firstPage: function () {
        $("#curPage").val(1);
        $("#form1").submit();
    },

    lastPage: function () {
        $("#curPage").val(page.pageCount);
        $("#form1").submit();
    },

    previousPage: function () {
        if ($("#curPage").val() > 1) {
            $("#curPage").val(parseInt(page.curPage) - 1);
        }
        $("#form1").submit();
    },

    nextPage: function () {
        if (parseInt(page.curPage) < parseInt(page.pageCount)) {
            $("#curPage").val(parseInt(page.curPage) + 1);
        }
        $("#form1").submit();
    },

    goto_Page: function () {
        var p = parseInt(page.curPage);
        if (isNaN(p) || p < 1 || p > page.pageCount) {
            $("#curPage").val(1);
        } else {
            $("#curPage").val(p);
        }
        $("#form1").submit();
    }
};
$(document).ready(function () {
    $(function () {
        $("#curPage").bind('keypress', function (event) {
            if (event.keyCode == "13") {
                page.goto_Page();
            }
        });
    });
    for (var i = 10; i < 41; i = i + 5) {
        $("#pageSize").append($("<option/>").text(i).val(i));
    }
    $("#pageSize").val(page.pageSize);
});
