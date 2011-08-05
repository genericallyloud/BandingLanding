_.templateSettings = {
  interpolate : /\{\{(.+?)\}\}/g
};
// Load the application once the DOM is ready, using `jQuery.ready`:
$(function(){
  // DeckCard Model
  // ----------

  // Our basic **Todo** model has `content`, `order`, and `done` attributes.
  window.DeckCard = Backbone.Model.extend({

    // Remove this Card from the deck and delete its view.
    clear: function() {
      this.destroy();
      this.view.remove();
    }

  });

  // DeckCard Collection
  // ---------------
  window.DeckListing = Backbone.Collection.extend({

    // Reference to this collection's model.
    model: DeckCard,
    url:"/rest/deckcards",

    // cards are sorted by their name
    comparator: function(deckCard) {
      return deckCard.get('cardName');
    }

  });

  // Create our global collection of **Todos**.
  window.deckListing = new DeckListing();

  // DeckCard View
  // --------------

  // The DOM element for a todo item...
  window.CardView = Backbone.View.extend({

    //... is a list tag.
    tagName:  "tr",

    // Cache the template function for a single item.
    template: _.template($('#card-template').html()),

    // The DOM events specific to a card.
    events: {
      "change .card-count"   : "updateCount",
      "click .remove-card"   : "clear"
    },

    // The TodoView listens for changes to its model, re-rendering. Since there's
    // a one-to-one correspondence between a **Todo** and a **TodoView** in this
    // app, we set a direct reference on the model for convenience.
    initialize: function() {
      this.model.bind('change', this.render, this);
      this.model.view = this;
    },

    // Re-render the contents of the todo item.
    render: function() {
      $(this.el).html(this.template(this.model.toJSON()));
      return this;
    },

    // Remove this view from the DOM.
    remove: function() {
      $(this.el).remove();
    },

    // Remove the item, destroy the model.
    clear: function() {
      this.model.clear();
    },
    
    updateCount:function(){
    	var count = $(this.el).find(".card-count").val();
    	this.model.set({count:count});
    	this.model.save();
    }

  });

  // Add a single todo item to the list by creating a view for it, and
  // appending its element to the `<ul>`.
  function addOne(card) {
    var view = new CardView({model: card});
    this.$("#card-list").append(view.render().el);
  }

  // Add all items in the **Todos** collection at once.
  function addAll() {
    deckListing.each(addOne);
  }
  
  deckListing.bind('add',   addOne);
  deckListing.bind('reset', addAll);
  deckListing.reset(initialCardList);
});