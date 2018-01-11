
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.json.JSONArray"%>
<%@ page import="org.json.JSONObject"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training application</title>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
    $('#dropdownList').on('change', function() {
      if ( this.value != 'All')
      
      {
        $("#business").show();
      }
      else
      {
        $("#business").hide();
      }
    });
});
</script>
<body>
	<form action="proxy" method="POST">
		Filter By <select name="FilterList" id='dropdownList'>
			<option value="destinationName">destination Name</option>
			<option value="minTripStartDate">min Trip Start Date</option>
			<option value="maxTripStartDate">max Trip Start Date</option>
			<option value="lengthOfStay">length Of Stay</option>
			<option value="maxStarRating">max Star Rating</option>
			<option value="minStarRating">min Star Rating</option>
			<option value="maxTotalRate">max Total Rate</option>
			<option value="minTotalRate">min Total Rate</option>
			<option value="maxGuestRating">max Guest Rating</option>
			<option value="minGuestRating">min Guest Rating</option>
			<option value="All" selected="selected">All</option>
		</select>
		<div style='display:none;' id='business'>Filter Value
		<input name="FilterValue" />
</div> 
		<input type="submit" value="Search" />
	</form>

	<%
		StringBuilder json = (StringBuilder)request.getAttribute("json");
	if(json != null){
	out.print(json);
	}
	%>




</body>
</html>