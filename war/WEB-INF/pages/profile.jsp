<%@ page isELIgnored="true" %>
<!DOCTYPE html> 
<html> 
 
  <head> 
    <title>The Banding Landing - Deck Builder</title>
    <link href="/css/demo_page.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="/css/demo_table_jui.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="/css/ui-lightness/jquery-ui-1.8.15.custom.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="/css/deckbuilder.css" media="all" rel="stylesheet" type="text/css"/>
  </head> 
 
 <body id="dt_example">
 	<div class="header">
	  	<div class="content-container">
		 	<div class="nav-container">
			 	<a href="#" id="start-game">Start a Game</a> |
			 	<a href="/AddToDeck.crx">Download Extension</a> |
			 	<a href="<%= request.getAttribute("signoutUrl") %>">Sign Out</a>
			</div>
	  	</div>
  	</div>
	<div id="container"> 
		<h1>Your deck, sir:</h1>
		<div class="demo_jui"> 
			<table class="display" id="example"></table>
		</div>
	</div>
	<div id="card-viewer"></div>
	<script type="text/x-jquery-tmpl" id="card-template">
        <img src="${card.imageUrl}"/>
    </script>
    <script src="/js/jquery-1.6.2.min.js"></script>
    <script src="/js/jquery-ui-1.8.15.custom.min.js"></script>
    <script src="/js/jquery.tmpl.min.js"></script>
    <script src="/js/jquery.dataTables.min.js"></script>
    <%--  
    <script src="/js/underscore.js"></script>
    <script src="/js/backbone.js"></script>
    <script>
    	var deckDto = <%= request.getAttribute("deckListJson") %>;
    </script>--%>
    <script src="/js/deckbuilder.js"></script>
    
  </body> 
 
</html> 