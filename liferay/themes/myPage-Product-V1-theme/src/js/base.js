var SessionStorage={setTwo:function(e,r){sessionStorage.setItem(e,JSON.stringify(r))},set:function(){var e=arguments.length,r=arguments[0],t=arguments[e-1],n=arguments[e-2];if(e<2)return console.log("Argument should be more than 1. Ex: SessionStorage.set(key, val) or SessionStorage.set(parent, .., val)"),null;if(2==e)return this.setTwo(r,t);for(var o=null,s=new Object,l=0;l<e-2;l++)null==o?o=s=null==(s=sessionStorage.getItem(arguments[l]))?new Object:JSON.parse(s):void 0==s[arguments[l]]?(s[arguments[l]]=new Object,s=s[arguments[l]]):s=s[arguments[l]];s[n]=t,sessionStorage.setItem(r,JSON.stringify(o))},get:function(){var e=arguments.length;if(e<1)return console.log("Argument should be more than 0. Ex: SessionStorage.set(key) or SessionStorage.set(key, .., key)"),null;var r=sessionStorage.getItem(arguments[0]);if(null==r)return null;r=JSON.parse(r);for(var t=1;t<e;t++)if(null==(r=r[arguments[t]]))return null;return r},remove:function(){var e=arguments.length;if(e<1)return console.log("Argument should be more than 0. Ex: SessionStorage.remove(key) or SessionStorage.remove(key, .., key)"),null;if(1==e)sessionStorage.removeItem(arguments[0]);else{var r=sessionStorage.getItem(arguments[0]);if(null==r)return null;for(var t=r=JSON.parse(r),n=1;n<e-1;n++)if(null==(t=t[arguments[n]]))return null;delete t[arguments[e-1]],this.set(arguments[0],r)}return!0},clear:function(){sessionStorage.clear()}};
function CustomFormRadio(e){this.$el=e,this.$el.addEventListener("click",this.onSelect.bind(this),!1),this.$el.addEventListener("touchend",this.onSelect.bind(this),!1)}function reloadRadio(){for(var e=document.querySelectorAll(".form-radio"),o=0;o<e.length;o++)new CustomFormRadio(e[o])}CustomFormRadio.prototype={onSelect:function(){this.$el.querySelector('input[type="radio"]').checked=!0}},window.addEventListener("DOMContentLoaded",function(){for(var e=document.querySelectorAll(".form-radio"),o=0;o<e.length;o++)new CustomFormRadio(e[o])});
function getScript(url,success){
	var script=document.createElement('script');
	script.src=url;
	var head=document.getElementsByTagName('head')[0],
	    done=false;
	script.onload=script.onreadystatechange = function(){
	  if ( !done && (!this.readyState || this.readyState == 'loaded' || this.readyState == 'complete') ) {
	    done=true;
	    success();
	    script.onload = script.onreadystatechange = null;
	    head.removeChild(script);
	  }
	};
	head.appendChild(script);
}

function getCookie(cValue) {
    var name = cValue + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}