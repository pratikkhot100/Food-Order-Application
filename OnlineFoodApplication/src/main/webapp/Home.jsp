<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ROYAL ORCHID</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
     <jsp:include page="Header.jsp"></jsp:include>
     <jsp:include page="Message.jsp"></jsp:include>
     <form action="FoodServlet" method="post">
     <input type="hidden" name="process" value="searchFood">
    <!--  <select>
    
     <option><li><a href="FoodServlet?process=searchbyname">Search by name</a></li></option>
     <option value="Sesrch">Search by Category</option>
     <option>searchFoodById</option>
     <option>Search by Type</option>
     </select> -->
     <br><br>
     <input class="form-control"  type="text" name="userInput" placeholder="Enter type to search"><br>
     <select name="search" class="form-select" style="width: 300px" ><br>
     <option value="byCategory">Search by category</option>
     <option value="byType">Search by type</option>
      <option value="byName">Search by Name</option>
      <option value="byId">Search by Id</option>
     
     </select>
          <input class="btn btn-sm btn-success rounded-pill" style="margin-right: 20px" class="form-control" type="submit" value="Search">
     
     
     </form>
   
          <div id="templatemo_top_dishes">
          
		<h1>Recommended Dishes</h1>
		<div class="top_dishes_box">
			<img src="images/templatemo_image_01.jpg" alt="image" width="205" height="150" />
			<h2>Butter Chicken</h2>
			<p>
				Butter Chicken is a rich and creamy dish made with tender chicken
				cooked in a flavorful tomato-based sauce. It’s a favorite in Indian
				cuisine and pairs perfectly with naan or rice. <a href="#">Read
					more...</a>
			</p>
		</div>

		<div class="top_dishes_box">
			<img src="images/templatemo_image_02.jpg" alt="image" width="205" height="150" />
			<h2>Paneer Tikka</h2>
			<p>
				Paneer Tikka is a popular vegetarian appetizer made from cubes of
				paneer (Indian cottage cheese) marinated in a blend of yogurt and
				spices, then grilled to perfection. It’s served with green chutney.
				<a href="#">Read more...</a>
			</p>
		</div>

		<div class="top_dishes_box">
			<img src="images/templatemo_image_03.jpg" alt="image" width="205" height="150" />
			<h2>Biryani</h2>
			<p>
				Biryani is a fragrant and flavorful rice dish made with basmati
				rice, tender meat (or vegetables), and a blend of aromatic spices.
				It’s often served with raita or a boiled egg on the side. <a
					href="#">Read more...</a>
			</p>
		</div>

		<div class="top_dishes_box">
			<img src="images/templatemo_image_04.jpg" alt="image" width="205" height="150" />
			<h2>Masoor Dal</h2>
			<p>
				Masoor Dal is a comforting dish made from red lentils cooked with
				spices. It's simple, nutritious, and often served with rice or
				flatbread. It’s a staple in many Indian homes. <a href="#">Read
					more...</a>
			</p>
		</div>

		<div class="cleaner">&nbsp;</div>
    
    </div> <!-- end of top dishes -->
    
    <div id="templatemo_content">
    <span class="top"></span>
    <div id="templatemo_innter_content">
        
        <div id="templatemo_content_left">
            <h1>Welcome to our website</h1>
            <img src="images/templatemo_image_05.jpg" alt="image" width="300" height="200" />
            
            <p>Welcome to our website! We are dedicated to providing you with the best culinary experiences. Our website features a variety of delicious dishes, as well as useful information to make your dining experience even better. Whether you're a foodie or simply looking for some meal inspiration, we’ve got something for everyone.</p>
            <p>Our team works hard to bring you the most flavorful and satisfying meals. From appetizers to main courses, you'll find mouthwatering options that cater to all tastes. We hope to inspire you with our special meals and help you discover new flavors.</p>
            <a href="#">Read more...</a>
                
            <div class="cleaner_with_height">&nbsp;</div>
        
        </div> <!-- end of content left -->
        
        <div id="templatemo_content_right">
            <h1>What's new?</h1>
            <div class="right_column_section">
                <h2>Special meal for you</h2>
                <img src="images/templatemo_image_06.jpg" alt="image" />
                <p>We are excited to present a special meal just for you! It’s a delicious blend of fresh ingredients, carefully prepared to offer a unique and satisfying dining experience. Don’t miss out on this special dish, available for a limited time only.</p>
                <a href="#">Read more...</a>
             </div>
        
        </div> <!-- end of content right -->
        <div class="cleaner">&nbsp;</div>
    </div>   
    <div class="cleaner" style="background: #fff;">&nbsp;</div>  
</div>  
    
         <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>