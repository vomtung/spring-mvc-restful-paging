<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/simplePagination.css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.simplePagination.js"></script>
<script type="text/javascript">

	function onLoad(){
	$.ajax({
		  url: "${pageContext.servletContext.contextPath}/"+"index/getproduct",
		  dataType:"json", 
		  type :'GET'
		}).done(function(data) {
			for(var i=0;i <data.products.length;i++){
				$('#productList').append("<tr><td>"+data.products[i].name+"</td><td>"+data.products[i].description+"</td><td>"+data.products[i].manufacture+"</td></tr>");
			}
			
			//paging
			$(function() {
			    $("#paging").pagination({
			        items: data.totalProduct,
			        itemsOnPage: 3,
			        onPageClick:function(pageNumber, event){
			        	pageClick(pageNumber,event);
			        },
			        cssStyle: 'light-theme'
			    });
			});
		});
	};
	
	function pageClick(pageNumber,event){
		$.ajax({
			  url: "${pageContext.servletContext.contextPath}/"+"index/getproduct?page="+pageNumber,
			  dataType:"json", 
			  type :'GET'
			}).done(function(data) {
				$('#productList').html('');
				for(var i=0;i <data.products.length;i++){
					$('#productList').append("<tr><td>"+data.products[i].name+"</td><td>"+data.products[i].description+"</td><td>"+data.products[i].manufacture+"</td></tr>");
				}
			});
	}
</script>
</head>
<body onload="onLoad()">
<h2>Product List</h2>
	
	<table id=productList style="width:100%">
  		<tr>
	    	<td>name</td>
	    	<td>description</td>
	    	<td>manufacture</td>
  		</tr>
	</table>
	<div id="paging"></div>
</body>
</html>
