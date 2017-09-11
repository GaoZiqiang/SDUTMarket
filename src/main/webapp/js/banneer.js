
$(function(){
	var nowing=0;
	var timer = '';
	var branch_len = $('.banner-content li').length;
	var branch_img_len = $('.banner-content img').width();
	var branch_img_count_len = parseInt(branch_len * branch_img_len);

	$(".next").click(function(){
		if(!$(".banner-content li:first").is(":animated")) {
			if (!$(".banner-content li:first").is(":animated")) {
				if (nowing < 5) {
					nowing++
				} else {
					nowing = 0;
				}
				$('.banner-dots li').eq(nowing).addClass('cur').siblings().removeClass('cur');
				$(".banner-content li:first").animate({'marginLeft': '-=branch_img_len'}, 500, function () {
					$(".banner-content li:first").css('marginLeft', 0);
					$('.banner-content').append($(".banner-content li:first"));
				});
			}
		}
		});

	$(".prev").click(function(){
		if(!$(".banner-content li:first").is(":animated")){
			if(nowing>0){
				nowing--
			}else{
				nowing=5;
			}
			$('.banner-dots li').eq(nowing).addClass('cur').siblings().removeClass('cur')
			$('.banner-content').prepend($(".banner-content li:last"));
			$('.banner-content li:first').css({'marginLeft':'-branch_img_len'});
			$(".banner-content li:first").animate({'marginLeft':'+=branch_img_len'},500,function(){
				$(".banner-content li:first").css('marginLeft','0px');
			});
		}
	});

	timer = setInterval(function(){
		$(".next").click();
	},4000);

	$(".banner-content").mouseenter(function(){
		clearInterval(timer);
	});

	$(".banner-content").mouseleave(function(){
		timer = setInterval(function(){
			$(".next").click();
		},4000)
	});
});