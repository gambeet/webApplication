<%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 20.06.2017
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Edit Element</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://cdn-na.infragistics.com/igniteui/latest/css/themes/infragistics/infragistics.theme.css" rel="stylesheet" />
<link href="http://cdn-na.infragistics.com/igniteui/latest/css/structure/infragistics.css" rel="stylesheet" />
<script src="http://modernizr.com/downloads/modernizr-latest.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
<script src="http://cdn-na.infragistics.com/igniteui/latest/js/infragistics.core.js"></script>
<script src="http://cdn-na.infragistics.com/igniteui/latest/js/infragistics.lob.js"></script>
<script>
    $( function() {
        $( "#datepicker" ).datepicker();
    } );
</script>
<link rel="stylesheet" href="http://htmlbook.ru/mysite.css">
</head>
<body>
<%
    String currentTable = null;
    if (session.getAttribute("currentTable") != null) {
        currentTable = (String) session.getAttribute("currentTable");
    }
    String includePage = "editPages/edit" + currentTable + ".jsp";
%>
<jsp:include page="<%=includePage%>"></jsp:include>
</body>
</html>