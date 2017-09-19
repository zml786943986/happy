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
    $(document).ready(function() {
		$("#menuTree").tree({
			url : '../user/showMenus.do?menuId=0',
			onClick : function(node) {
				$("#menuId").val(node.id);
				$("#menuName").val(node.text);
				$("#menuSort").val(node.menuSort);
				$("#iconsName").val(node.iconCls);
				if (isLeaf(node)) {
					$("#menuPath").val(node._url);
					$("#pathP").attr("style", "display:block;");
				} else {
					$("#pathP").attr("style", "display:none;");
				}
			}
		});
	});
    </script>
</head>
<body>
	<ul id="menuTree"></ul>
</body>
</html>