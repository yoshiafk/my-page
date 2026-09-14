$(document).ready(function(){
	document.location.hash = '';
	
    const menuClick  = document.querySelector("#toggle-menu");
	const menuContent = document.querySelector("#mobile-menu");
	const hamburger = document.querySelector("#hamburger");
	const body = document.querySelector("body");

	if(menuClick) {
			menuClick.addEventListener("click", function() {
			hamburger.classList.toggle("is-anime");
			menuContent.classList.toggle("is-show");
			body.classList.toggle("is-overflow");
		});	
	}

	$('.tab-link-pane, .aside-link-pane').on('click',function() {
		$('.tab-link-pane.is-active, .aside-link-pane.is-active').removeClass('is-active');
		$(this).addClass('is-active');
	});

	$('#select-anchor').change( function () {
		var target = $(this).val();
		setTimeout(function() {
			$('html, body').stop().animate({
				scrollTop: $(target).offset().top - 2
			}, 0, function () {
				window.location.hash = target;
			});
		}, 400);
    });

	const sections = document.querySelectorAll("section");
	const navLi = document.querySelectorAll(".sticky-tab-pane ul li, .sticky-aside ul li");
	window.onscroll = () => {
		var current = "";

		sections.forEach((section) => {
			const sectionTop = section.offsetTop;
			if (pageYOffset >= sectionTop - 60) {
			current = section.getAttribute("id"); }
		});

		navLi.forEach((li) => {
			li.classList.remove("is-active");
			if (li.classList.contains(current)) {
			li.classList.add("is-active");
			}
		});
	};
	$(".insurance-solutions").hover(function () {
		var data_id = $(this).data('id');
		
		$('.insurance-solutions-details').each(function() {
			var el = $(this);
			
			if(el.attr('id') == data_id)
				el.show();
			else
				el.hide();
		});
	});

	$('.topbar').mouseenter(function(e) {
		$('.nav-axa__mega-menu').removeClass('is-active');
		$('.nav-axa__mega-menu--hover').removeClass("is-open-mega-menu");
	});
	$('.cloak').mouseenter(function(e) {
		$('.nav-axa__mega-menu').removeClass('is-active');
		$('.nav-axa__mega-menu--hover').removeClass("is-open-mega-menu");
	});
	$('.nav-link-axa').mouseenter(function(e) {
		$('.nav-axa__mega-menu').removeClass('is-active');
		$('.nav-axa__mega-menu--hover').removeClass("is-open-mega-menu");
	});
	$(".nav-axa__mega-menu").mouseenter(function(){
		$(this).addClass('is-active');
		$('.nav-axa__mega-menu--hover').addClass("is-open-mega-menu");
	});
	$(".nav-axa__mega-menu--hover").mouseleave(function(){
		$(this).removeClass("is-open-mega-menu");
	});
	$(".nav-axa-wrapper").mouseenter(function(){
		$('.nav-axa__mega-menu').addClass('is-active');
	});
	$(".hero").mouseenter(function(){
		$('.nav-axa__mega-menu').removeClass('is-active');
	});

	// function setSlideHeight(that){
	// 	$('.swiper-slide').css({height:'auto'});
	// 	var currentSlide = that.activeIndex;
	// 	var newHeight = $(that.slides[currentSlide]).height();

	// 	$('.swiper-wrapper,.swiper-slide').css({ height : newHeight })
	// 	that.update();
	// }

	// $(window).resize(function(){
	// 	resizeSwiper()
	// });

	

	// let text = document.querySelector(".card-plan");

	// let animation = gsap.to(".card-plan", {
	// 	paused: true,
	// 	opacity: 0
	// });

	// text.addEventListener("mouseenter", () => animation.play());
	// text.addEventListener("mouseleave", () => animation.reverse());
	// const cards = document.querySelectorAll(".card-plan__inner");

	// cards.forEach((link) => {
	//   const arrow = link.children[0];
	//   gsap.set(arrow, { height: "280px", yPercent: 0, xPercent: 0 });
	//   const t = gsap.to(arrow, { height: "428px", xPercent: 0, opacity: 1, duration: 0.3, paused: true , ease: Power2.easeOut });
	//   link.addEventListener("mouseenter", () => {
	// 	t.play();
	//   });
	//   link.addEventListener("mouseleave", () => {
	// 	t.reverse();
	//   });
	// });

	// // $(".card-plan-wrapper").flickity({
	// // 	wrapAround: false,
	// // 	contain: true,
	// //   	pageDots: false,
	// // 	prevNextButtons: false
	// });

});