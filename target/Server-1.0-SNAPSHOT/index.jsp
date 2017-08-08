<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<html>
<head><title>Parsing xml</title></head>
<body>
<h1 style="text-shadow: 2px 2px 5px grey;">Flowers</h1>
    <table style="border: 3px grey dashed; box-shadow: 5px 5px 5px grey; color: white">
    <caption style="font-size: 1.5em; color: brown; text-shadow: 2px 2px 5px grey;">DOM parser result</caption>
      <tr style="background-color:#610B21; text-shadow: 1px 1px 1px white;">
	<th>Name</th>
	<th>Note</th>
	<th>Soil</th>
	<th>ColorOfStem</th>
	<th>ColorOfLeaf</th>
	<th>AverageSize</th>
	<th>Type</th>
	<th>TemperatureValue</th>
	<th>Type &#xB0;</th>
	<th>Lighting</th>
	<th>Watering</th>
	<th>Multiplying</th>
     </tr>
<jsp:useBean id="ob" scope="page" class="servlet.view.View" />
<c:set var="flowers" value="${getFlowers}"/>
     <c:forEach var="flower" items="${flowers}" >
        <tr style="color:black; background-color:#D8F781;">
	<c:set var="values" value="${ob.getAll(flower)}"/>
	<c:forEach var="item" items="${values}" >
	<td><c:out value="${item}"/></td>
	</c:forEach>
        </tr>
    </c:forEach>
</table>
<br><br>
<table style="border: 3px grey dashed; box-shadow: 5px 5px 5px grey; color: white">
    <caption style="font-size: 1.5em; color: brown; text-shadow: 2px 2px 5px grey;">SAX parser result</caption>
      <tr style="background-color:#610B21; text-shadow: 1px 1px 1px white;">
	<th>Name</th>
	<th>Note</th>
	<th>Soil</th>
	<th>ColorOfStem</th>
	<th>ColorOfLeaf</th>
	<th>AverageSize</th>
	<th>Type</th>
	<th>TemperatureValue</th>
	<th>Type &#xB0;</th>
	<th>Lighting</th>
	<th>Watering</th>
	<th>Multiplying</th>
<c:set var="values" value="${ob.getAllElems()}"/>
<c:forEach var="value" items="${values}" varStatus="count" >
<c:if test="${(count.count - 1) % 12 == 0}" >
    </tr><tr style="color:black; background-color:#D8F781;">
</c:if>
<td><c:out value="${value}"/></td>
</c:forEach>
</table>
<br><br>
<table style="border: 3px grey dashed; box-shadow: 5px 5px 5px grey; color: white">
    <caption style="font-size: 1.5em; color: brown; text-shadow: 2px 2px 5px grey;">Stax parser result</caption>
      <tr style="background-color:#610B21; text-shadow: 1px 1px 1px white;">
	<th>Name</th>
	<th>Note</th>
	<th>Soil</th>
	<th>ColorOfStem</th>
	<th>ColorOfLeaf</th>
	<th>AverageSize</th>
	<th>Type</th>
	<th>TemperatureValue</th>
	<th>Type &#xB0;</th>
	<th>Lighting</th>
	<th>Watering</th>
	<th>Multiplying</th>
<c:set var="data" value="${ob.getAllData()}"/>
<c:forEach var="item" items="${data}" varStatus="count1" >
<c:if test="${(count1.count - 1) % 12 == 0}" >
    </tr><tr style="color:black; background-color:#D8F781;">
</c:if>
<td><c:out value="${item}"/></td>
</c:forEach>
</table>
<span>Your host name: <%= request.getRemoteHost() %>
<br><%! private int accessCount = 0; %>
      Numbers of request to server: <%= ++accessCount %>
</span>
</body>
</html>
