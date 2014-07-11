	var map;
	var shape = new google.maps.Polygon({strokeOpacity: 0.8,strokeWeight: 2,fillOpacity: 0.35,clickable: false, editable: false});
	var paths = new google.maps.MVCArray();
	var nVert = 1;
	
	
  function initialize() {
		var mapDiv = document.getElementById('map-canvas');
		map = new google.maps.Map(mapDiv, {
		center: new google.maps.LatLng(-23.62239, -46.69915),
		zoom: 16,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	
	google.maps.event.addListener(map,'click',function(event){
		var lat = event.latLng.lat();
		var lon = event.latLng.lng();
		drawPolygon(lat,lon)
	});
	
	document.getElementById('vlFillColor').value= '000000';
	document.getElementById('vlStrokeColor').value= 'FF0000';
	}
		
	function drawPolygon(lat,lon){
		paths.push(new google.maps.LatLng(lat,lon));
		shape.setPath(paths);
		shape.setMap(map);
		
		changeColor();
		document.getElementById('vertX').value = document.getElementById('vertX').value + lat +",\n";
		document.getElementById('vertY').value = document.getElementById('vertY').value + lon +",\n";
		document.getElementById('nVert').value = nVert++;
	}
	 
	 function changeColor(){
		shape.strokeColor = "#"+document.getElementById('vlStrokeColor').value;
		shape.fillColor =  "#"+document.getElementById('vlFillColor').value;
	 }
	 
	 function clearPage(){
		initialize();
		 nVert = 1;
		 document.getElementById('vertX').value = "";
		 document.getElementById('vertY').value = "";
		 document.getElementById('nVert').value = "";
		 document.getElementById('dsDescr').value = "";
		 shape = new google.maps.Polygon({strokeOpacity: 0.8,strokeWeight: 2,fillOpacity: 0.35,clickable: false});
		 paths = new google.maps.MVCArray();	
	 }
	
	google.maps.event.addDomListener(window, 'load', initialize);