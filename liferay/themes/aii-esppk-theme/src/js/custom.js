$(function () {
    const menuClick  = document.querySelector("#toggle-menu");
    const menuContent = document.querySelector("#navbar");
    const hamburger = document.querySelector("#hamburger");
    const body = document.querySelector("body");

    menuClick.addEventListener("click", function() {
        hamburger.classList.toggle("is-anime");
        menuContent.classList.toggle("is-show");
        body.classList.toggle("is-overflow");
    });
    
    $('button#alert-close').click(function () {
        $('.alert').removeClass('animate-vertical_slide').addClass('hidden')
    })

	$('.dropdown-menu.dropdown-menu--data-mobile').on({
		"click":function(e){
		  e.stopPropagation();
		}
	});
});