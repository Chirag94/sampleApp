function getBids(){
	Promise.resolve(axios.get('http://localhost:8080/showbids')).then(
	function(res){
		res.data.sort(compare);
		document.getElementById('slot1url').href = res.data[0].target;
		document.getElementById('slot1img').src = res.data[0].img;
		document.getElementById('slot2url').href = res.data[1].target;
		document.getElementById('slot2img').src = res.data[1].img;
	});
}
function compare(ad1,ad2){
	if(ad1.cpi>ad2.cpi)	return -1;
	if(ad1.cpi<ad2.cpi)	return 1;
	return 0;
}
function record(id){
	document.getElementById('recording').innerHTML = document.getElementById(id).href;
}
getBids();