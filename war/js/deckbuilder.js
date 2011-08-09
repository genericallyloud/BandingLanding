(function($){
	$(document).ready(function(){
		/*
		 * Set up the data table, defining columns, and using the rest api
		 */
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
	           {sTitle:"P/T", mDataProp:"card.powerToughness", sWidth:"40px"},
	           {sTitle:"Cost", mDataProp:"card.cost", sWidth:"50px"},
	           {sTitle:"Color", mDataProp:"card.color", sWidth:"80px"},
	           {sTitle:"Count", mDataProp:"deckCard.count", sWidth:"50px", bUseRendered:false, fnRender:function(row){
	        	   var deckCard = row.aData.deckCard;
				   return '<input class="card-count" type="number" min="0" max="100" value="' + deckCard.count + '"/>';
			   }}
	        ]
		});
		//template for the card popup
		var viewerTemplate = $("#card-template").template();
		//set up the dialog and attach open even to name
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
		
		//handler for deleting the row
		$("#example .remove-card").live("click",function(){
			var rowElem = this.parentNode.parentNode;
			var data = table.fnGetData(rowElem);//tr parent of delete div
			//now that I have the data, lets kill the row, more responsive that way
			table.fnDeleteRow(rowElem);
			//now delete on server
			$.ajax({
				url:"/rest/deckcards/" + data.deckCard.id,
				type:"DELETE"
			});
			//alert("Deleting " + data.card.name);
			return false;
		});
		
		//handler for updating count
		$("#example .card-count").live("change",function(){
			var updated = $(this).val();
			var data = table.fnGetData(this.parentNode.parentNode);//tr parent of delete div
			var deckCard = data.deckCard;
			deckCard.count = updated;
			//now delete on server
			$.ajax({
				url:"/rest/deckcards/" + deckCard.id,
			    contentType: "application/json",
				type:"PUT",
				data:JSON.stringify(deckCard)
			});
			//alert("Deleting " + data.card.name);
			return false;
		});
	});
})(jQuery);