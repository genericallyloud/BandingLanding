
<!DOCTYPE html> 
<html> 
 
  <head> 
    <title>Backbone Demo: Todos</title> 
    <link href="/css/deckbuilder.css" media="all" rel="stylesheet" type="text/css"/>
  </head> 
 
  <body> 
 
    <h1>Your deck, sir:</h1> 
	<div id="deck"> 
		<ul id="card-list"></ul> 
    </div>
    
    <!-- Templates --> 
 
    <script type="text/template" id="card-template">
		<div class="card">
			<span class="remove-card">x</span>
			<span class="card-title">{{cardName}}</span>
			<input class="card-count" type="number" min="0" max="100" value="{{count}}"/>
		</div>
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