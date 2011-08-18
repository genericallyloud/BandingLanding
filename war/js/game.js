var App = SC.Application.create();

App.MyView = SC.View.extend({
  mouseDown: function() {
    window.alert("hello world!");
  }
});

//(function($){
//	$(document).ready(function(){
//		//get the game id - not provided so game can be completely static
//		var path = window.location.pathname; //should look like /game/{id}
//		var id = path.substring(6);
//		
//		$.ajax({
//			url:"http://bandinglanding.appspot.com/rest/game/" + id,
//		    contentType: "application/json",
//			type:"GET",
//			xhrFields: {
//				withCredentials: true
//			},
//			success:function(data){
//				alert(data.playerDto.player.user.email + " is the player!");
//				console.log(data);
//			}
//		});
//	});
//})(jQuery);