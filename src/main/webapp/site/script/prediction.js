var prediction=[
['I wish you luck!'],
['Have a good rest!'],
['Behave yourself .be good!'],
['Success to you in defending your thesis!'],
['May your dreams come true!'],
['Good luck on your business!'],
['Enjoy!!'],
['Lets hope the weather keeps!'],
['Good luck with your exam!'],
['Please, accept my best most heartfelt sincerest wishes!']
];

$(document).ready(function () {
	$('.cookie').click(function () {


		$.getJSON('ControllerCookie',  function (data) {
			$.each(data, function (index, element) {

				if (index === 'cookie') {
					$('.massage').text(element);
					console.log(element);
					console.log(index);
				}
			})
		})
	})
});

/*$(document).ready(function () {
	$(".cookie").click(function(){

 $('.massage').text("ffk");
 $.getJSON('ControllerCookie',  function (data) {

 $.each(data, function (index, element) {

 if (index === 'cookie') {
 $('.massage').text(element);
 console.log(element);
 console.log(index);
 }

 });
 });


});
});*/


/*	$.getJSON('ControllerCookie',  function (data) {

		$.each(data, function (index, element) {

			if (index === 'cookie') {
				$('.massage').text(element);
				console.log(element);
			}

		});
	});*/

/*$.ajax({
	url: 'getPrediction',
	method: 'get',
	success:  $(document).ready(function () {
		$('.cookie').click (function (data) {

		$.each(data, function(key, val){
			if(key==="cookie"){

			$('.message' ).text(val);
			}

		});
		
	})
})
});*/
/*$(document).ready(function () {
$(".cookie").click(function(){
	$.ajax({
		url: 'getPrediction',
		method: 'get',
		success:  (function (data) {


				$.each(data, function(key, val){
					if(key==="cookie") {
						$('.message').text(val);
					}
					else{
						$('.message').text("fkfkfk");
					}
				})
})
})
});
});*/


/*$(document).ready(function () {
	$('.cookie').click(function () {
		var index = Math.floor(Math.random()*prediction.length);
		$('.message' ).text(prediction[index]);
	});
});
*/

$(document).ready(function() {

    for(i=0;i < prediction.length;i++)
        $('#myTable1').append('<tr><td class="editor">' + prediction[i] + '</td></tr>');

	});


