

var map;
var URL = 'device/live';

function initialize() {
    
    var myLatLng = new google.maps.LatLng( 0, 0 ),
        myOptions = {
    	zoom : 10,
		center : myLatLng,
		mapTypeControl : true,
		mapTypeControlOptions : {
			style : google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
			position : google.maps.ControlPosition.BOTTOM_CENTER
		},
		panControl : true,
		panControlOptions : {
			position : google.maps.ControlPosition.TOP_RIGHT
		},
		zoomControl : true,
		zoomControlOptions : {
			style : google.maps.ZoomControlStyle.LARGE,
			position : google.maps.ControlPosition.LEFT_CENTER
		},
		scaleControl : true,
		scaleControlOptions : {
			position : google.maps.ControlPosition.TOP_LEFT
		},
		streetViewControl : true,
		streetViewControlOptions : {
			position : google.maps.ControlPosition.LEFT_TOP
		}
            },
    map = new google.maps.Map( document.getElementById( 'map-canvas' ), myOptions );
    
    google.maps.event.addListener(map, 'drag', function(event) {       
        console.log("Map drag!");
        $("#deviceOptions").find('option').removeAttr("selected");
    });
    
    var markers = {};
    $.getJSON(URL, function (json) {
		 	$.each(json, function (i, fb) {
		 		//if(fb.sim == '1642756747'){
		 		console.log("Initialized here| lat >> " + fb.latitude + "|long >>> " + fb.longitude);
		 		var image = 'resources/img/arrow/arrow_'+ fb.direction +'.png';
		        lineCoordinates = new google.maps.LatLng(fb.latitude, fb.longitude);
		        //Info
		        marker = new google.maps.Marker( {position: lineCoordinates, map: map, icon:image} );
		        marker.setMap( map );
		        map.panTo(lineCoordinates);
		        markers[i] = marker;
		 		//}
		    });
	});
    
    moveMarker( map, markers);
    
    return map;
}


//Move marker 
function moveMarker( map, markers) {
    //delayed so you can see it move
	setInterval( function(){
		//setAllMap(null, markers);
    	$.getJSON(URL, function (json) {
   		 	$.each(json, function (i, fb) {
   		 		//if(fb.sim == '1642756747'){

   		 		var infoWindow = new google.maps.InfoWindow();
   		 		
   		        lineCoordinates = new google.maps.LatLng(fb.latitude, fb.longitude);
   		        //Info
   		        markers[i].setPosition(lineCoordinates);
   		        markers[i].setMap( map );
   		        var marker = markers[i]; 
   		        google.maps.event.addListener(marker, 'click', (function(marker,i) {
   		        return function(){
   		        	infoWindow.setContent(createInfoWindowContent(fb));
   		        	
   		        	infoWindow.open(map,marker);
   		        };
 	      	  })(marker,i));
   		    });
   		 	
    	});
        
        
    }, 5000 );

};

// get the info of the marker.
function createInfoWindowContent(obj) {
	  return [
	    '<font style=\"font-weight: bold;\">Mã Thiết Bị:</font> ' + obj.plateNumber,
	    '<font style=\"font-weight: bold;\">Vĩ độ:</font> ' + obj.latitude + ' , <font style=\"font-weight: bold;\">Kinh độ:</font> ' + obj.longitude,
	    '<font style=\"font-weight: bold;\">Tín hiệu:</font> Tốt ', 
	    '<font style=\"font-weight: bold;\">Tốc độ:</font> ' + obj.speed,
	    '<font style=\"font-weight: bold;\">Trạng thái:</font> ' + obj.status + ' , ' +
	      '<font style=\"font-weight: bold;\"> Ghi chú:</font> Người thuê ở Hà Nội'
	  ].join('<br>');
}

//Initial the map.
map = initialize();

//tracking by car.
function trackingByCar(plateNumber){
	console.log('tracking by car >>> ' + plateNumber); 
	$.getJSON(URL, function (json) {
		 $.each(json, function (i, fb) {
		 		if(plateNumber == fb.plateNumber){

		 			var latLgn = new google.maps.LatLng(fb.latitude, fb.longitude);
	   		 		map.panTo(latLgn);
	   		 		
	   		 		console.log('LatLong of this car >>> ' + fb.latitude); 
		 		};
		 });
	});
}