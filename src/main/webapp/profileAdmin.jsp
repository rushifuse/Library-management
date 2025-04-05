<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #2b95a1, #8894bb);
        color: #fff;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
    }
a{
text-decoration: none;
}

    table {
        width: 100%;
        border-collapse: collapse;
        text-align: left;
        margin-top: 40px;
        
    }

    th {
        text-align: center;
        background-color: #2b95a1;
        color: white;
        padding: 12px;
        font-size: 1.1rem;
    }

    td {
        padding: 12px;
        border: 1px solid #ddd;
        color: black;
        text-align: center;
        background-color: rgba(255, 255, 255, 0.8);
        transition: background 0.3s ease-in-out, transform 0.3s ease;
    }

    td:hover {
        background-color: rgba(255, 255, 255, 0.5);
        transform: scale(1.02);
    }

    tr {
        transition: transform 0.3s ease-in-out;
    }

    tr:hover {
        background-color: #ddd;
        transform: scale(1.02);
    }


    h1 {
        font-size: 3rem;
        margin-bottom: 20px;
        text-align: center;
        animation: fadeIn 1s ease-out;
    }

    .table-container {
        width: 100%;
        max-width: 2000px;
        margin: 20px;
        padding: 20px;
      border:2px solid white;
        border-radius: 10px;
        box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
        position: relative;
        animation: tableFadeIn 1.5s ease-in-out;
    }

   
    

    table {
        width: 100%;
       
        text-align: left;
        margin-top: 40px;
        
    }
    
img{

width: 200px;
height: 200px;
border-top-left-radius:40px;
border-bottom-right-radius:40px;
border: 5px groove black;
}

    th {
        text-align: center;
       
        color: white;
        padding: 12px;
        font-size: 1.1rem;
    }

    td {
        padding: 12px;
       background-color: rgba(255, 255, 255, 0.8);
        color: black;
        text-align: center;
        width:200px;
        transition: background 0.3s ease-in-out, transform 0.3s ease;
    }

    td:hover {
    
        transform: scale(1.02);
    }

    tr {
        transition: transform 0.3s ease-in-out;
    }

    tr:hover {
      
        transform: scale(1.02);
    }

    
    .btn {
        display: inline-block;
        margin: 0 10px;
        padding: 10px 20px;
        border: 1px solid black;
        border-radius: 5px;
        font-size: 1rem;
        font-weight: bold;
        color: black;
        text-decoration: none;
        background: #ffffff;
        box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.2);
        cursor: pointer;
        transition: all 0.3s ease;
     	margin-left: 97%;
    }

    .btn:hover {
        background: #f9ff96;
        transform: translateY(-3px);
        box-shadow: 2px 2px 15px rgba(0, 0, 0, 0.3);
    }

    .btn-danger {
        background: linear-gradient(135deg, #f44336, #e53935);
        color: white;
    }

    .btn-danger:hover {
        background: linear-gradient(135deg, #e53935, #f44336);
    }

    
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    @keyframes tableFadeIn {
        from {
            opacity: 0;
            transform: translateY(20px);
        }
        to {
            opacity: 1;
             transform: translateY(0);
        }
    }

    @keyframes slideIn {
        from {
            opacity: 0;
            transform: translateY(-20px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }
    
    #back{
    background-image: url("imgBackground.jpg");
    }
    
    .special
    {
    	text-align: right;
    
    }
    
    .special2
    {
    	text-align: left;
    
    }
    
    
    
</style>
</head>
<body>

<div class="back">
    <h1 style="color: red">Student Profile</h1>
		
		<div align="center">
				<img alt="" src="findImage/${student.name}">	
				
		</div>
  
  <form action="back2" method="get"  enctype="multipart/form-data">
<button type="submit" class="btn" name="back" value="back" >Back</button>
</form>

  
  
   <div class="table-container">
       

        <table id="studentTable">

 	<tr>
 						
    					<td class="special">Lab No :</td>
    					<td class="special2">${student.std_id}</td>
    					</tr>
 	
 	
    					<td class="special">name :</td>
    					<td class="special2">${student.name}</td>
    					</tr>
 			
        	          <tr>
    					<td class="special">Email :</td>
    					<td class="special2">${student.email}</td>
    					</tr>
    					
    						<tr>
    					<td class="special">Password :</td> 
    					<td class="special2">${student.password}</td>
    					</tr>
    					
    						<tr>
    					<td class="special">Department Name :</td> 
    					<td class="special2">${student.dept}</td>
    					</tr>
    </table>
    </div>

    <div class="table-container">
       <table id="studentTable">
            <tr>
                <th>Book Name</th>
                <th>Purchase</th>
                <th>Submit</th>
                <th>Purchase Date</th>
                <th>Submission Date Date</th>
            </tr>

         <c:forEach var="p" items="${purchase}" varStatus="status">
          <tr>
           		<td>${p.book_name}</td>

                <td> ${p.book_purchase}</td>

                <td>${p.submit}</td>
                
                <td>${p.purchase_date}</td>
                
                 <td>${p.submission_date}</td>
          </tr> 
         </c:forEach>



        </table>
    </div>


<br><br><br>
</body>
</html>
