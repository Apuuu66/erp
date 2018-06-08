var method = "";

// 数据表格

$(function () {
    $('#myGird').datagrid({
        title: pageName + "管理",
        url: urlPrefix + "/page",
        columns: columns,
        loadMsg: '嗖 ----正在火速加载中 -------------', //加载提示
        pagination: true, //显示分页工具栏
        rownumbers: true, //显示行号列
        singleSelect: false,//是允许选择一行

        toolbar: "#toolbar",//工具栏
    });


    //点击查询按钮
    $('#btnSearch').bind('click', function () {
        $.ajax({
            type: "post",
            url: urlPrefix + "/tt",
            data: $("#searchForm").serialize(),
            success: function (rtn) {//返回json结果
                $("#myGird").datagrid('loadData', rtn);
            }
        });
    });

    //输入框的enter事件
    $('#name').bind('keydown', function (event) {
        if (event.keyCode == "13") {
            Submit();
        }
    });

});


//添加
function Insert() {
    method = "add";
    $("#myDlg").dialog({
        title: "添加" + pageName,
        width: 240,
        height: 126,
    });
    // $("#uuid").attr("readonly", false);
    $("#trh").attr("hidden", true);
    $("#editForm").form('clear');
    $('#myDlg').dialog('open');
}

//编辑
function Edit() {
    method = 'update';
    // var row = $("#myGird").datagrid('getSelected');
    var row = $("#myGird").datagrid('getSelections');
    if (row == 0) {
        $.messager.alert("提示", "请先选中要编辑的行!");
        return false;
    } else if (row.length > 1) {
        $.messager.alert("提示", "不能同时编辑多行!");
        return false;
    }
    $("#trh").attr("hidden", false);
    $('#editForm').form('clear');
    // 设置添加dialog 并打开
    $("#myDlg").dialog({
        title: "编辑" + pageName,
        width: w,
        height: h,
        closed: false,
    });
    // 数据回显
    $('#editForm').form('load', row[0]);
}

//删除
function Delete() {
    var row = $("#myGird").datagrid('getSelected');
    if (row == null) {
        $.messager.alert("提示", "请先选中要删除的行!");
        return false;
    }
    $.messager.confirm("提示", "确定要删除么?", function (r) {
        if (r) {
            $.ajax({
                type: "POST",
                url: urlPrefix + '/delete',
                data: {uuid: row.uuid},
                // contentType: "application/json;charset=utf-8",
                success: function (rtn) {
                    $.messager.alert("提示", rtn.message, "info", function () {
                        $("#myGird").datagrid("reload");
                    })
                },
            });
        }
    });
}

function Submit() {
    $.ajax({
        type: "post",
        url: urlPrefix + "/" + method,
        data: $('#editForm').serialize(),
        success: function (rtn) {
            $.messager.alert("提示", rtn.message, "info", function () {
                // 关闭窗口 刷新表单
                $("#myDlg").dialog("close");
                $("#myGird").datagrid("reload");
            });
        }
    });
}

function getSelectionIds() {
    var myGird = $("#myGird");
    var sels = myGird.datagrid("getSelections");
    var ids = [];
    for (var i in sels) {
        ids.push(sels[i].uuid);
    }
    ids = ids.join(",");
    return ids;
}

