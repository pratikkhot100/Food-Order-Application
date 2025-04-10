<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style type="text/css">
body {
    margin-top: 20px;
}

h2 {
    text-align: center;
}

.company-info {
    background-color: #f8f9fa; /* Light gray background */
    padding: 20px; /* Padding for better spacing */
    border-radius: 8px; /* Rounded corners for the div */
}

.table-bordered {
    margin-top: 20px;
    border: 2px solid #333; /* Darker border color */
}

.table-bordered th, .table-bordered td {
    color: black; /* Set text color to black */
    font-size: 18px; /* Increase font size */
    border: 1px solid #333; /* Darker border color for table cells */
}
</style>

</head>
<body>
    <jsp:include page="Header.jsp"></jsp:include>
    <jsp:include page="Message.jsp"></jsp:include>

    <!-- Company Information Section with Background Color -->
    <div class="container company-info">
        <h2>Royal Orchid Food Plaza</h2>
        <table class="table table-bordered">
            <tr>
                <th>Company Name:</th>
                <td><strong>Royal Orchid Food Plaza</strong></td>
            </tr>
            <tr>
                <th>About Us:</th>
                <td>
                    Royal Orchid Food Plaza is a renowned food establishment offering a variety of delicious and high-quality meals. 
                    We strive to deliver exceptional dining experiences to our valued customers with excellent service and taste.
                </td>
            </tr>
            <tr>
                <th>Email Contact:</th>
                <td><a href="https://www.linkedin.com/in/pratikkhot01">contact@royalorchidfoodplaza.com</a></td>
            </tr>
            <tr>
                <th>Contact Number:</th>
                <td>+91 9365836479</td>
            </tr>
            <tr>
                <th>Location:</th>
                <td>143 Royal Street, Food City, Mumbai 400060, Maharashtra, India</td>
            </tr>
            <tr>
                <th>Opening Hours:</th>
                <td>Mon-Sun: 10:00 AM - 11:00 PM</td>
            </tr>
        </table>
    </div>

    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
