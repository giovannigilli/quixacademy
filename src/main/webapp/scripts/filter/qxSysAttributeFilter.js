var quixacademyApp = angular.module('quixacademy');

quixacademyApp.filter('sysattribute', function() {
	return function(input, type) {
	    input = input || '';
	    var out = input;
	    var list = eval(type);
	    for (var i = 0; i < list.length; i++) {
	      if(list[i].code == input) {
	    	  out = list[i].description;
	    	  break;
	      }
	    }
	    return out;
	};
});