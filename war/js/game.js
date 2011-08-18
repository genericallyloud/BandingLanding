var App = SC.Application.create();

App.MyView = SC.View.extend({
  mouseDown: function() {
    window.alert("hello world!");
  }
});

//(function($){
//	$(document).ready(function(){
//		$.ajax({
//			url:"http://bandinglanding.appspot.com/rest/game/16003",
//		    contentType: "application/json",
//			type:"GET",
//			xhrFields: {
//				withCredentials: true
//			},
//			success:function(data){
//				console.log(data);
//			}
//		});
//	});
//})(jQuery);