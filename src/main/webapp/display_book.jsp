<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #2b95a1, #8894bb);
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            animation: fadeInBody 1s ease-in-out;
        }

        .form-container {
            background: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);
            max-width: 900px;
            width: 100%;
            animation: slideInContainer 1s ease-out;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            animation: fadeInHeader 1s ease-out;
        }

        .row {
            display: flex;
            justify-content: space-between;
            gap: 20px;
            flex-wrap: wrap;
            position: relative;
        }

        .column {
            flex: 1;
            min-width: 300px;
            padding: 10px;
            background: rgba(255, 255, 255, 0.2);
            border-radius: 8px;
        }

        .column h3 {
            text-align: center;
            margin-bottom: 10px;
            color: #ffeb3b;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        p, input {
            width: 100%;
            margin: 5px 0;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            box-sizing: border-box;
        }

        input {
            background: #f4f4f4;
            color: #333;
            transition: all 0.3s ease;
        }

        input[readonly] {
            background: #ddd;
        }

        input:focus {
            outline: none;
            border: 2px solid #2b95a1;
            transform: scale(1.02);
        }

        .btn {
            background: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: all 0.3s ease;
            width: 100%;
            margin-top: 10px;
        }

        .btn:hover {
            background: #45a049;
        }

        .back-btn {
            background: #32457a;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: all 0.3s ease;
            width: 100%;
            margin-top: 10px;
        }

        .back-btn:hover {
            background: #3259c1;
        }

        .error, .success {
            font-size: 1.15rem;
            margin: 10px 0;
            font-weight: bold;
        }

        .error {
            color: #f44336;
            text-align: center;
            font-weight: bold;
        }

        .success {
            color: #00ff0a;
            text-align: center;
            font-weight: bold;
        }

        
        @keyframes fadeInBody {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        @keyframes slideInContainer {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes fadeInHeader {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes slideInRight {
            from {
                opacity: 0;
                transform: translateX(100%);
            }
            to {
                opacity: 1;
                transform: translateX(0);
            }
        }

        @keyframes slideInLeft {
            from {
                opacity: 0;
                transform: translateX(-100%);
            }
            to {
                opacity: 1;
                transform: translateX(0);
            }
        }

        @keyframes slideUpButton {
            from {
                bottom: -50px;
                opacity: 0;
            }
            to {
                bottom: 10px;
                opacity: 1;
            }
        }
        
        .myclass
        {
        	 background: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: 2px solid black;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: all 0.3s ease;
            width: 100%;
            margin-bottom: 240px;
            margin-left: 1400%;
        
        }
        
        
        
    </style>
</head>
<body>

 <form action="back2" method="get"  enctype="multipart/form-data">
<button type="submit" class="myclass" name="back" value="back" >Back</button>
</form>

    <div class="form-container">
        <h1>Check Book Details</h1>

       
            
            <form action="check" method="post" enctype="multipart/form-data">
                <label for="studentId">Enter Book Name:</label>
                <input type="text" id="studentId" name="book_name" placeholder="Enter Book Name" required>
                <button type="submit" class="btn" name ="check" value="check">check</button>
            </form>
       
		       
		    	   
             <br>
                <c:if test="${not empty book}">
                <div class="column" style="animation: slideInLeft 1s ease-out;">
                    <h3>Update Details</h3>
                    <form action="update" method="post" enctype="multipart/form-data">
                       

                        <label for="studentName">Book Name:</label>
                        <input type="text"  name="book_name" value="${book.book_name}" required>

                        <label for="studentEmail">Author Name:</label>
                        <input type="text"  name="author_name" value="${book.author_name}" required>

						 <label for="studentEmail">Dept Name:</label>
                        <input type="text"  name=" book_dept" value="${book.book_dept}" required>
                        
                        <button type="submit" class="btn" name ="update" value="update">Update Book</button>
                    </form>
                </div>
            </div>

            </c:if>
      
      		<c:if test="${not empty msg}">
      			<p>${msg}</p>
      		</c:if>
      
    </div>
</body>
</html>
