(function($){
	$(document).ready(function(){
		var table = $("#example").dataTable({
			bProcessing:true,
			bJQueryUI:true,
			iDisplayLength:50,
			sAjaxSource:"/rest/deck",
			sAjaxDataProp:"cards",
			aaSorting:[[1,"asc"]],
			aoColumns:[
			   {sTitle:"", bSortable:false,sWidth:"20px",fnRender:function(row){
				   return "<div class='remove-card'></div>";
			   }},
	           {sTitle:"Name", mDataProp:"card.name", bUseRendered:false, fnRender:function(row){
	        	   var card = row.aData.card;
				   return "<a class='card-name' title='" + card.text + "' href='#'>" + card.name + "</a>";
			   }},
	           {sTitle:"Type", mDataProp:"card.types"},
	           {sTitle:"Cost", mDataProp:"card.cost", sWidth:"50px"},
	           {sTitle:"Color", mDataProp:"card.color", sWidth:"80px"},
	           {sTitle:"Count", mDataProp:"deckCard.count", sWidth:"50px", bUseRendered:false, fnRender:function(row){
	        	   var deckCard = row.aData.deckCard;
				   return '<input class="card-count" type="number" min="0" max="100" value="' + deckCard.count + '"/>';
			   }}
	        ]
		});
		var viewerTemplate = $("#card-template").template();
		$("#card-viewer").dialog({autoOpen:false});
		$("#example .card-name").live("click",function(){
			//debugger;
			var data = table.fnGetData(this.parentNode.parentNode);
			console.log(data);
			$("#card-viewer")
				.empty()
				.append($.tmpl(viewerTemplate,data));
			$("#card-viewer").dialog("open");
			return false;
		});
		$("#example .remove-card").live("click",function(){
			var data = table.fnGetData(this.parentNode.parentNode);//tr parent of delete div
			alert("Deleting " + data.card.name);
			return false;
		});
	});
})(jQuery);