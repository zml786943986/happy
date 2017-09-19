<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/scripts/easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/scripts/easyUI/themes/icon.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/scripts/easyUI/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/scripts/easyUI/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/scripts/easyUI/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
    $(function(){
        $("#dg").datagrid({
            url:"../user/showUsers.do",
            columns:[[
                {field:'id',title:'id',width:100},
                {field:'userName',title:'用户名',width:100},
                {field:'password',title:'密码',width:100}
            ]],
            toolbar:'#toolbar',  //表格菜单
            loadMsg:'正在火速加载中...', //加载提示
            pagination:true, //显示分页工具栏
            rownumbers:true, //显示行号列
            singleSelect:true//是允许选择一行
        });
    });
    </script>
</head>
<body>
	<table id="dg"></table>
    <div id="toolbar">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" >添加</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" >编辑</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" >删除</a>
    </div>
</body>
</html>