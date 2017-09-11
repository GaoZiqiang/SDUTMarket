
$('.page_first').hover(
        function () {
            $('.page_border').css({'width': '85px', 'left': '480px'})
        },
        function () {
            $('.page_border').css({'width': '0px', 'left': '0px'})
        }
);
$('.page_type').hover(
        function () {
            $('.page_border').css({'width': '105px', 'left': '595px'})
        },
        function () {
            $('.page_border').css({'width': '0px', 'left': '0px'})
        }
);
$('.page_typewrap').mouseenter(
        function () {
            $('.type_menu').show()
        }

);
$('.type_menu').mouseleave(
        function () {
            $('.type_menu').hide()
        }

);
//登陆