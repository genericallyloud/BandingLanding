
<!DOCTYPE html> 
<html> 
 
  <head> 
    <title>The Banding Landing - Deck Builder</title> 
    <link href="/css/deckbuilder.css" media="all" rel="stylesheet" type="text/css"/>
  </head> 
 
  <body>
  	<div class="header">
	  	<div class="content-container">
		 	<div class="nav-container">
			 	<a href="/AddToDeck.crx">Download Extension</a> |
			 	<a href="<%= request.getAttribute("signoutUrl") %>">Sign Out</a>
			</div>
	  	</div>
  	</div>
    <h1>Your deck, sir:</h1> 
	<div id="deck"> 
		<table id="card-list">
		</table> 
    </div>
    
    <!-- Templates --> 
 
    <script type="text/template" id="card-template">
		<td>
			<span class="remove-card"></span>
			<span class="card-title">{{cardName}}</span>
		</td>
		<td>
			<input class="card-count" type="number" min="0" max="100" value="{{count}}"/>
		</td>
	</script>
    <script src="/js/jquery-1.6.2.min.js"></script> 
    <script src="/js/underscore.js"></script> 
    <script src="/js/backbone.js"></script>
    <script>
    	var initialCardList = <%= request.getAttribute("deckListJson") %>;
    </script>
    <script src="/js/deckbuilder.js"></script>
    
  </body> 
 
</html> 