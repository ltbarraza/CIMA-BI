var Model = function() {

	var self = this;
	self.displayMessage = ko.observable(false);
	this.firstName = ko.observable('Luis');
    this.lastName = ko.observable('Torres');
	
	self.categories = ko.observableArray([
        { name: 'Fruit', items: [ 'Apple', 'Orange', 'Banana' ] },
        { name: 'Vegetables', items: [ 'Celery', 'Corn', 'Spinach' ] }
    ])
    
    
    this.fullName = ko.pureComputed({
        read: function () {
            return this.firstName() + " " + this.lastName();
        },
        write: function (value) {
            var lastSpacePos = value.lastIndexOf(" ");
            if (lastSpacePos > 0) { // Ignore values with no space character
                this.firstName(value.substring(0, lastSpacePos)); // Update "firstName"
                this.lastName(value.substring(lastSpacePos + 1)); // Update "lastName"
            }
        },
        owner: this
    });
	
    self.planets = [
            { name: 'Mercury', capital: null }, 
            { name: 'Earth', capital: { cityName: 'Barnsley' } }        
        ]
	
	
	self.myItems = ko.observableArray([ 'A', 'B', 'C' ]);
    self.yellowFadeIn = function(element, index, data) {
         $(element).filter("li")
                   .animate({ backgroundColor: 'yellow' }, 200)
                   .animate({ backgroundColor: 'white' }, 800);
     },
     self.addItem = function() { this.myItems.push('New item'); }
     
     
     this.produce = [ 'Apple', 'Banana', 'Celery', 'Corn', 'Orange', 'Spinach' ];
     this.selectedProduce = ko.observableArray([ 'Corn', 'Orange' ]);
     this.selectedAllProduce = ko.pureComputed({
         read: function () {
             // Comparing length is quick and is accurate if only items from the
             // main array are added to the selected array.
             return this.selectedProduce().length === this.produce.length;
         },
         write: function (value) {
             this.selectedProduce(value ? this.produce.slice(0) : []);
         },
         owner: this
     });

};

ko.applyBindings(new Model());
