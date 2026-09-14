/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

//myPage instance for calling script according its page
myPage = {
  action : function(func, args){
	var _parent = $('#myPage-Product') || false;
	if(! _parent) return _parent;
	
    var namespace =  _parent.data('product');
    if (func !== '' && window[namespace] != undefined && window[namespace][func] && typeof window[namespace][func] == 'function'){
      window[namespace][func](args);
    }
  },
  load : function(){
	var _parent = $('#myPage-Product') || false;
	if(! _parent) return _parent;
    // hit up general first.
    myPage.action('general');
    var className = _parent.data('page') || false;
    if(!className) return className;
    // do all the classes too.
    $.each(className.split(/\s+/),function(i,classnm){
      	myPage.action(classnm);
    });
  }
};

/* eslint-disable prefer-arrow-callback */
AUI().ready(
	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
		var _parent = $('#myPage-Product') || false;
		if(! _parent) return _parent;
	    myPage.action('htmlReady');
	    
	    myPage.load();
	    
	    // FOR MEGA MENU
	    $(document).mouseup(function (e) {
	        if ($(e.target).closest(".mega-menu").length === 0) {
	            $(".drop-mega-menu").removeClass('show');
	            $(".mega-menu").removeClass('show');
	        }
	    });
	    $('.new-header li a.drop-mega-menu').on('click', function (event) {
	        if ($(this).hasClass('show')) {
	            $(this).removeClass('show');
	            $(this).siblings('.mega-menu').removeClass('show');
	        } else {
	            $(this).addClass('show');
	            $(this).siblings('.mega-menu').addClass('show');
	        }
	    });
	    
	    $('.collapse.collapse-lv2').on('show.bs.collapse', function () {
	    	$(this).parents('.nav-item').addClass('lv2-show');
	    })
	    $('.collapse.collapse-lv2').on('hide.bs.collapse', function () {
	    	$(this).parents('.nav-item').removeClass('lv2-show');
	    })
	    // FOR MEGA MENU
	}
);

Liferay.Portlet.ready(
	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(_portletId, _node) {
		var _parent = $('#myPage-Product') || false;
		if(! _parent) return _parent;
	    myPage.action('portletReady', _portletId);	 
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
		var _parent = $('#myPage-Product') || false;
		if(! _parent) return _parent;
	    myPage.action('allPortletReady');	
	}
);
