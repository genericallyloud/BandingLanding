<%@ page isELIgnored="true" %>
<!DOCTYPE html> 
<html> 
 
  <head> 
    <title>The Banding Landing</title>
    <meta name = "viewport" content = "initial-scale = 1.0,width = device-width, user-scalable = no">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <link href="/css/game.css" media="all" rel="stylesheet" type="text/css"/>
  </head> 
 
 <body>
	<div id="game-board">
		<div class="player-area">
			<div class="card-sidebar">
				<div class="sidebar-block avatar">
					<img class="sidebar-img" src="/img/default-avatar.jpg"/>
					<div class="sidebar-info">20</div>
				</div>
				<div class="sidebar-block library">
					<img class="sidebar-img" src="/img/mtg-card-back-small.jpg"/>
				</div>
				<div class="sidebar-block graveyard">
					<div class="sidebar-img empty-card"></div>
					<div class="sidebar-info">0</div>
				</div>
				<div class="sidebar-block exile">
					<div class="sidebar-img empty-card"></div>
					<div class="sidebar-info">0</div>
				</div>
				<div class="sidebar-block hand">
					<div class="sidebar-img empty-card"></div>
					<div class="sidebar-info">0</div>
				</div>
			</div>
			<div class="play-zone"></div>
			<div class="area-controls"></div>
		</div>
		<div id="dividing-line"></div>
		<div class="player-area">
			<div class="card-sidebar">
				<div class="sidebar-block avatar">
					<img class="sidebar-img" src="/img/default-avatar.jpg"/>
					<div class="sidebar-info">20</div>
				</div>
				<div class="sidebar-block library">
					<img class="sidebar-img" src="/img/mtg-card-back-small.jpg"/>
				</div>
				<div class="sidebar-block graveyard">
					<div class="sidebar-img empty-card"></div>
					<div class="sidebar-info">0</div>
				</div>
				<div class="sidebar-block exile">
					<div class="sidebar-img empty-card"></div>
					<div class="sidebar-info">0</div>
				</div>
				<div class="sidebar-block hand">
					<div class="sidebar-img empty-card"></div>
					<div class="sidebar-info">0</div>
				</div>
			</div>
			<div class="play-zone"></div>
			<div class="area-controls"></div>
		</div>
	</div>
	
	<script type="text/x-handlebars">
    	{{#view App.MyView}}
      		<h1>Hello world!</h1>
    	{{/view}}
  	</script>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
	<script>!window.jQuery && document.write(unescape('%3Cscript src="js/libs/jquery-1.6.2.min.js"%3E%3C/script%3E'))</script>
	<script src="/js/libs/sproutcore-2.0.beta.3.min.js"></script>
    <script src="/js/game.js"></script>
  </body> 
 
</html> 