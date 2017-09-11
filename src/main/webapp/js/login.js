$(window).load(function () {
	var screenWidth=$(window.document).innerWidth()
	var screenHeight=$(window.document).innerHeight()
	//刷新页面让其停留在顶部
	$(function(){
		// setTimeout(function(){window.scrollTo(0,0);}, 50);
	});
	var centerTop=($(window).innerHeight()-$(".login-container,.registration-container").height())/2;
	var centerLeft=($(window).innerWidth()-$(".login-container,.registration-container").width())/2;
	$(".login-container,.registration-container").css('top',centerTop+"px");
	$(window).resize(function () {
		var centerTop=($(window).height()-$(".login-container,.registration-container").height())/2;
		var centerLeft=($(window).width()-$(".login-container,.registration-container").width())/2;
		$(".login-container,.registration-container").css('top',centerTop+"px").css('left',centerLeft+'px').css('margin-left','0');
	});
	$(".login").click(function () {
		$(".login-container").css('display','block');
		$(".registration-container").css('display','none');
		$('#screen').css({'display': 'block','width':screenWidth ,'height':screenHeight })
	});
	$(".login-close").click(function () {
		$(".login-container").css('display','none');
		$('#screen').css('display','none')
	});
	$(".registration").click(function () {
		$(".registration-container").css('display','block');
		$(".login-container").css('display','none');
		$('#screen').css({'display': 'block','width':screenWidth ,'height':screenHeight })
	});
	$(".registration-close").click(function () {
		$(".registration-container").css('display','none');
		$('#screen').css('display','none')
	});
});