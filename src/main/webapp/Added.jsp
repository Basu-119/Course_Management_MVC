<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="button.css">
    <title>Successfully Added</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <style>

        body {

            display: flex;

            justify-content: center;

            align-items: center;

            height: 80vh;

            margin: 0;

            background-color: #f7f7f7;

        }

 

        .success-message {

            display: none;

            text-align: center;

            padding: 20px;

            background-color: #34a853;

            color: #fff;

            border-radius: 5px;

            animation: fadeIn 1s ease-in-out;

        }

 

        @keyframes fadeIn {

            0% {

                opacity: 0;

            }

 

            100% {

                opacity: 1;

            }

        }

        .but{

            color: royalblue;

            text-decoration-color: rgb(0, 0, 0);

            background-color: rgb(0, 255, 128);

        }

    </style>

</head>

 

<body>

    <div class="container">

        <div class="row justify-content-center">

            <div class="col-md-6">

                <div class="success-message" id="successMsg">

                    <h2>Added Successfully</h2><br><br>

                   <a href="Welcome.html"><button class="button-59" role="button">GO BACK</button>
				</a>


                </div>

            </div>

        </div>

    </div>

  

    <script>

        // Show the success message with a delay of 2 seconds

        window.onload = function() {

            setTimeout(function() {

                document.getElementById('successMsg').style.display = 'block';

            }, 1000);

        };

    </script>

</body>

 

</html>