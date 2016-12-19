<%@page import="java.io.PrintWriter"%>
<!-- importerar jspl c foreach mm -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- importerar sql -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>

<html>
<head>
<!-- css -->
<link rel="stylesheet" type="text/css" href="main.css">
</head>

<body>
<!-- sql connection -->
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/register" user="root" password="" />


<!-- user input name and password -->
	<div class="user">
		<label for="username">Name:</label> <input type="text" id="username"
			name="" placeholder="Username">
		<!-- an input element is an inline element-->

		<label for="password">password:</label> <input type="text"
			id="password" name="" placeholder="Password">
	</div>

	<div class="headerText">
		<h1>My Shop</h1>
	</div>

<!-- meny navigation -->
	<div id="nav">
		<ul>
			<li><a href="shoes.html">Shoes</a></li>
			<li><a href="#">Jeans</a></li>
			<li><a href="#">Contact</a></li>
			<li><a href="register.html">Register</a></li>
		</ul>
	</div>





	<div class="productadidas">
		<a href=""> <img alt="Whitesuperstar" src="whitesuperstar.jpg">White
			Superstar
		</a>
		
		<!--  det visar shoes som är vita och modelen är som superstar  -->
		
		<sql:query var="shoes">
     SELECT  shoes.size, shoes.quantity from shoes where (color like'%white%'  AND  model like '%superstar%')
     </sql:query>

		<c:forEach items="${shoes.rows}" var="row">
			<!-- here it reads all sizes and all quantity -->
			<select>

				<option value="${row.size}">Size: ${row.size}
					&nbsp;Quantity: ${row.quantity}</option>
			</select>
		</c:forEach>
	</div>


		<!--  det visar shoes som är red och modelen är som superstar  -->

	<div class="productadidas">
		<a href=""> <img alt="RedSuperstar" src="redsuperstar.jpg">Red
			Superstar
		</a><br>
		<sql:query var="shoes">
   SELECT  shoes.size, shoes.quantity from shoes where (color like'%red%'  AND  model like '%superstar%')
       </sql:query>

		<select>
			<c:forEach items="${shoes.rows}" var="row">
				<!-- here it reads all sizes and all quantity -->

				<option value="${row.size}">Size: ${row.size}
					&nbsp;Quantity: ${row.quantity}</option>
			</c:forEach>
		</select>

	</div>



	<!--  koden fungerar inte %100 (update)
	<form method="post" action="Buyer">
	<p>Select a color</p>
    <select name="colors">
       <option value="white">White</option>
       <option value="red">Red</option>
       </select>
    <br>

	<p>Select a size</p>
    <select name="size">
       <option value="38">38</option>
       <option value="39">39</option>
       </select>
    <br>
    
    
    	<p>Select a amount</p>
    <select name="amount">
       <option value="1">1</option>
       <option value="2">2</option>
       </select>
    <br>
    <input type="Submit" value="Submit">
</form>
-->
</body>
</html>

