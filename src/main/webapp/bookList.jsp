<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
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

    h1 {
        font-size: 3rem;
        margin-bottom: 20px;
        text-align: center;
        animation: fadeIn 1s ease-out;
    }

    .table-container {
        width: 90%;
        max-width: 2000px;
        margin: 20px;
        padding: 20px;
        background: rgba(255, 255, 255, 0.1);
        border-radius: 10px;
        box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
        position: relative;
        animation: tableFadeIn 1.5s ease-in-out;
    }

   
    .search-container {
        position: absolute;
        top: 20px;
        right: 20px;
    }

    .search-container input {
        padding: 8px;
        font-size: 1rem;
        border-radius: 5px;
        border: 1px solid #ddd;
        outline: none;
        width: 200px;
        transition: 0.3s;
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
    
    font
   {
    	width: 700px; 
    
    }
</style>
</head>
<body>

    <h1>Book List</h1>
    
      	  
  <form action="back1" method="get"  enctype="multipart/form-data">
<button type="submit" class="btn" name="back" value="back" >Back</button>
</form>
  

    <div class="table-container">
        <!-- Search Bar -->
        <div class="search-container">
            <input type="text" id="searchInput" onkeyup="searchDepartment()" placeholder="Search by  name...">
        </div>

        <table id="studentTable">
            <tr>
                <th>Department</th>
                <th>Purchase</th>
                
            </tr>


<c:forEach var="b" items="${book}" varStatus="status">
    <tr>
        <td>${b}</td>
        <td>
            <form action="purchase" method="post" enctype="multipart/form-data">
                <input type="hidden" name="book_name" value="${b}">
                <!-- Green button for purchased books -->
                <button type="submit" class="btn" name="b1" value="purchase" 
                        style="background-color: ${b == purchasedBook ? 'green' : 'initial'}">
                    Purchase
                </button>
            </form>
        </td>
        
    </tr>        
</c:forEach>



        </table>
    </div>

       <script>
        function searchDepartment() {
            var input = document.getElementById("searchInput").value.toUpperCase();
            var table = document.getElementById("studentTable");
            var rows = table.getElementsByTagName("tr");

            for (var i = 1; i < rows.length; i++) {  // Skip header row
                var td = rows[i].getElementsByTagName("td")[0];  // First column (Department)
                if (td) {
                    var textValue = td.textContent || td.innerText;
                    if (textValue.toUpperCase().indexOf(input) > -1) {
                        rows[i].style.display = "";  // Show row
                    } else {
                        rows[i].style.display = "none";  // Hide row
                    }	
                }
            }
        }
    </script>
     
 <font color="yellow" >${msg}</font>
		
</body>
</html>
