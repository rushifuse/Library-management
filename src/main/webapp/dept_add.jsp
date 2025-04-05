<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Department</title>
<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #2b95a1, #081e44);
        color: #fff;
        text-align: center;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

    .header {
        position: fixed;
        top: 0;
        width: 100%;
        background: rgba(0, 0, 0, 0.12);
        padding: 10px 20px;
        color: white;
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-size: 1rem;
        z-index: 1000;
    }
    
    .contact{
    	padding-left: 30px;
    }

    .header .contact {
        font-weight: bold;
    }

    .header .social-icons a {
        margin: 0 10px;
        color: white;
        text-decoration: none;
        font-size: 1.2rem;
        transition: transform 0.3s;
    }

    .header .social-icons a:hover {
        transform: scale(1.2);
    }

    h1 {
        font-size: 3rem;
        margin-top: 80px;
        animation: fadeInDown 1s ease-in-out;
    }

    h2 {
        font-size: 1.5rem;
        margin-top: 30px;
    }

   
    @keyframes fadeInDown {
        from {
            opacity: 0;
            transform: translateY(-30px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }

    @keyframes slideInLeft {
        from {
            transform: translateX(-100%);
            opacity: 0;
        }
        to {
            transform: translateX(0);
            opacity: 1;
        }
    }

    @keyframes slideInRight {
        from {
            transform: translateX(100%);
            opacity: 0;
        }
        to {
            transform: translateX(0);
            opacity: 1;
        }
    }

    

     .form-container {
            background: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
            width: 90%;
            max-width: 600px;
            animation: zoomIn 0.8s ease-out;
            text-align: left;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            height: auto;
            background-image: url("/img/book.jpg");
        }

        label {
            font-weight: bold;
            display: block;
            text-align: left;
            margin-bottom: 8px;
            color: black;
        }

        input {
            width: calc(100% - 24px);
            padding: 12px;
            margin-bottom: 15px;
            border: 2px solid black;
            border-radius: 8px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
            font-size: 1rem;
        }


select {
            width: calc(100% - 24px);
            padding: 12px;
            margin-bottom: 15px;
            border: 2px solid black;
            border-radius: 8px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
            font-size: 1rem;
        }
        .button-container {
            text-align: center;
            margin-top: 15px;
        }

        button {
            background: #ffffff;
            color: #2a5298;
            padding: 15px 30px;
        	border: 2px solid red;
        	border-radius: 8px;
        	cursor: pointer;
       	 	font-size: 1rem;
        	font-weight: bold;
        	
        	transition: transform 0.3s, box-shadow 0.3s;
        }

        button:hover {
            transform: scale(1.05);
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
            background: #f9ff96;
        }

       
        .success-message {
            text-align: center;
            color: #00ff00;
            font-weight: bold;
            margin-bottom: 15px;
            font-size: 1.1rem;
        }

        .error-message {
            text-align: center;
            color: red;
            font-weight: bold;
            margin-bottom: 15px;
            font-size: 1.1rem;
        }
        
        .file_border
        {
        border: 2px solid white;
        }
        .myclass
        {
        background: #ffffff;
            color: #2a5298;
            padding: 15px 30px;
        	border: 2px solid red;
        	border-radius: 8px;
        	cursor: pointer;
       	 	font-size: 1rem;
        	font-weight: bold;
        	margin-left:800px;
        	transition: transform 0.3s, box-shadow 0.3s;
        
        }
</style>
</head>
<body>
<h1> Add Books</h1>
   <form action="back2" method="get"  enctype="multipart/form-data">
<button type="submit" class="myclass" name="back" value="back" >Back</button>
</form>
   
    
     <form class="form-container" action="addDept" method="POST" enctype="multipart/form-data">
        
            
            
             <label for="studentEmail">Add Department :</label>
            <input  type="text" placeholder="Enter  Department Name in Short" name="dept_name" required><br>
  			
  			<label for="studentEmail">Quantity :</label>
            <input  type="text" placeholder="Enter quantity " name="book_quantity" required><br>
      
            <div class="button-container">
                <button type="submit" name="deptAdd" value="deptAdd">Add</button>
            </div>
        </form>
    <br><br>
    		<font color="white">
    			${msg}
    		</font>
    
</body>
</html>
