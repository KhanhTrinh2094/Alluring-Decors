/* jQuery Form Styler v1.5.2 | (c) Dimox | https://github.com/Dimox/jQueryFormStyler */
(function(c){c.fn.styler=function(d){d=c.extend({wrapper:"form",idSuffix:"-styler",filePlaceholder:"\u0424\u0430\u0439\u043b \u043d\u0435 \u0432\u044b\u0431\u0440\u0430\u043d",fileBrowse:"\u041e\u0431\u0437\u043e\u0440...",selectSearch:!0,selectSearchLimit:10,selectSearchNotFound:"\u0421\u043e\u0432\u043f\u0430\u0434\u0435\u043d\u0438\u0439 \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u043e",selectSearchPlaceholder:"\u041f\u043e\u0438\u0441\u043a...",selectVisibleOptions:0,singleSelectzIndex:"100",
selectSmartPositioning:!0,onSelectOpened:function(){},onSelectClosed:function(){},onFormStyled:function(){}},d);return this.each(function(){function w(){var c="",m="",b="",u="";void 0!==a.attr("id")&&""!=a.attr("id")&&(c=' id="'+a.attr("id")+d.idSuffix+'"');void 0!==a.attr("title")&&""!=a.attr("title")&&(m=' title="'+a.attr("title")+'"');void 0!==a.attr("class")&&""!=a.attr("class")&&(b=" "+a.attr("class"));var t=a.data(),h;for(h in t)""!=t[h]&&(u+=" data-"+h+'="'+t[h]+'"');this.id=c+u;this.title=
m;this.classes=b}var a=c(this);a.is(":checkbox")?a.each(function(){if(1>a.parent("div.jq-checkbox").length){var d=function(){var d=new w,b=c("<div"+d.id+' class="jq-checkbox'+d.classes+'"'+d.title+'><div class="jq-checkbox__div"></div></div>');a.css({position:"absolute",zIndex:"-1",opacity:0,margin:0,padding:0}).after(b).prependTo(b);b.attr("unselectable","on").css({"-webkit-user-select":"none","-moz-user-select":"none","-ms-user-select":"none","-o-user-select":"none","user-select":"none",display:"inline-block",
position:"relative",overflow:"hidden"});a.is(":checked")&&b.addClass("checked");a.is(":disabled")&&b.addClass("disabled");b.click(function(){b.is(".disabled")||(a.is(":checked")?(a.prop("checked",!1),b.removeClass("checked")):(a.prop("checked",!0),b.addClass("checked")),a.change());return!1});a.closest("label").add('label[for="'+a.attr("id")+'"]').click(function(a){b.click();a.preventDefault()});a.change(function(){a.is(":checked")?b.addClass("checked"):b.removeClass("checked")}).keydown(function(a){32==
a.which&&b.click()}).focus(function(){b.is(".disabled")||b.addClass("focused")}).blur(function(){b.removeClass("focused")})};d();a.on("refresh",function(){a.off().parent().before(a).remove();d()})}}):a.is(":radio")?a.each(function(){if(1>a.parent("div.jq-radio").length){var g=function(){var m=new w,b=c("<div"+m.id+' class="jq-radio'+m.classes+'"'+m.title+'><div class="jq-radio__div"></div></div>');a.css({position:"absolute",zIndex:"-1",opacity:0,margin:0,padding:0}).after(b).prependTo(b);b.attr("unselectable",
"on").css({"-webkit-user-select":"none","-moz-user-select":"none","-ms-user-select":"none","-o-user-select":"none","user-select":"none",display:"inline-block",position:"relative"});a.is(":checked")&&b.addClass("checked");a.is(":disabled")&&b.addClass("disabled");b.click(function(){b.is(".disabled")||(b.closest(d.wrapper).find('input[name="'+a.attr("name")+'"]').prop("checked",!1).parent().removeClass("checked"),a.prop("checked",!0).parent().addClass("checked"),a.change());return!1});a.closest("label").add('label[for="'+
a.attr("id")+'"]').click(function(a){b.click();a.preventDefault()});a.change(function(){a.parent().addClass("checked")}).focus(function(){b.is(".disabled")||b.addClass("focused")}).blur(function(){b.removeClass("focused")})};g();a.on("refresh",function(){a.off().parent().before(a).remove();g()})}}):a.is(":file")?a.css({position:"absolute",top:0,right:0,width:"100%",height:"100%",opacity:0,margin:0,padding:0}).each(function(){if(1>a.parent("div.jq-file").length){var g=function(){var m=new w,b=c("<div"+
m.id+' class="jq-file'+m.classes+'"'+m.title+' style="display: inline-block; position: relative; overflow: hidden"></div>'),g=c('<div class="jq-file__name">'+d.filePlaceholder+"</div>").appendTo(b);c('<div class="jq-file__browse">'+d.fileBrowse+"</div>").appendTo(b);a.after(b);b.append(a);a.is(":disabled")&&b.addClass("disabled");a.change(function(){var c=a.val();if(a.is("[multiple]"))for(var c="",h=a[0].files,m=0;m<h.length;m++)c+=(0<m?", ":"")+h[m].name;g.text(c.replace(/.+[\\\/]/,""));""==c?(g.text(d.filePlaceholder),
b.removeClass("changed")):b.addClass("changed")}).focus(function(){b.addClass("focused")}).blur(function(){b.removeClass("focused")}).click(function(){b.removeClass("focused")})};g();a.on("refresh",function(){a.off().parent().before(a).remove();g()})}}):a.is("select")?a.each(function(){if(1>a.parent("div.jqselect").length){var g=function(){function m(a){a.off("mousewheel DOMMouseScroll").on("mousewheel DOMMouseScroll",function(a){var b=null;"mousewheel"==a.type?b=-1*a.originalEvent.wheelDelta:"DOMMouseScroll"==
a.type&&(b=40*a.originalEvent.detail);b&&(a.stopPropagation(),a.preventDefault(),c(this).scrollTop(b+c(this).scrollTop()))})}function b(){i=0;for(len=h.length;i<len;i++){var a="",c="",b=a="",d="",m="";h.eq(i).prop("selected")&&(c="selected sel");h.eq(i).is(":disabled")&&(c="disabled");h.eq(i).is(":selected:disabled")&&(c="selected sel disabled");void 0!==h.eq(i).attr("class")&&(b=" "+h.eq(i).attr("class"),m=' data-jqfs-class="'+h.eq(i).attr("class")+'"');var f=h.eq(i).data(),n;for(n in f)""!=f[n]&&
(a+=" data-"+n+'="'+f[n]+'"');a="<li"+m+a+' class="'+c+b+'">'+h.eq(i).text()+"</li>";h.eq(i).parent().is("optgroup")&&(void 0!==h.eq(i).parent().attr("class")&&(d=" "+h.eq(i).parent().attr("class")),a="<li"+m+' class="'+c+b+" option"+d+'">'+h.eq(i).text()+"</li>",h.eq(i).is(":first-child")&&(a='<li class="optgroup'+d+'">'+h.eq(i).parent().attr("label")+"</li>"+a));x+=a}}function g(){var s=new w,e=c("<div"+s.id+' class="jq-selectbox jqselect'+s.classes+'" style="display: inline-block; position: relative; z-index:'+
d.singleSelectzIndex+'"><div class="jq-selectbox__select"'+s.title+' style="position: relative"><div class="jq-selectbox__select-text"></div><div class="jq-selectbox__trigger"><div class="jq-selectbox__trigger-arrow"></div></div></div></div>');a.css({margin:0,padding:0}).after(e).prependTo(e);var s=c("div.jq-selectbox__select",e),q=c("div.jq-selectbox__select-text",e),k=h.filter(":selected");k.length?q.html(k.text()):q.html(h.first().text());b();var p="";/*d.selectSearch&&(p='<div class="jq-selectbox__search"><input type="search" autocomplete="off" placeholder="'+d.selectSearchPlaceholder+'"></div><div class="jq-selectbox__not-found">'+d.selectSearchNotFound+"</div>");*/var f=c('<div class="jq-selectbox__dropdown" style="position: absolute">'+p+'<ul style="position: relative; list-style: none; overflow: auto; overflow-x: hidden">'+x+"</ul></div>");e.append(f);var n=c("ul",f),l=c("li",f),r=c("input",f),y=c("div.jq-selectbox__not-found",f).hide();l.length<d.selectSearchLimit&&r.parent().hide();var v=0,B=0;l.each(function(){var a=c(this);a.css({display:"inline-block",
"white-space":"nowrap"});a.innerWidth()>v&&(v=a.innerWidth(),B=a.width());a.css({display:"block"})});var p=e.clone().appendTo("body").width("auto"),t=p.width();p.remove();t==e.width()&&(q.width(B),v+=e.find("div.jq-selectbox__trigger").width());v>e.width()&&f.width(v);a.css({position:"absolute",left:0,top:0,width:"100%",height:"100%",opacity:0});var u=e.outerHeight(),A=r.outerHeight(),z=n.css("max-height"),p=l.filter(".selected");1>p.length&&l.first().addClass("selected sel");void 0===l.data("li-height")&&
l.data("li-height",l.outerHeight());var C=f.css("top");"auto"==f.css("left")&&f.css({left:0});"auto"==f.css("top")&&f.css({top:u});f.hide();p.length&&(h.first().text()!=k.text()&&e.addClass("changed"),e.data("jqfs-class",p.data("jqfs-class")),e.addClass(p.data("jqfs-class")));if(a.is(":disabled"))return e.addClass("disabled"),!1;s.click(function(){a.focus();c("div.jq-selectbox").filter(".opened").length&&d.onSelectClosed.call(c("div.jq-selectbox").filter(".opened"));if(!navigator.userAgent.match(/(iPad|iPhone|iPod)/g)){if(d.selectSmartPositioning){var b=
c(window),h=e.offset().top,q=b.height()-u-(h-b.scrollTop()),k=d.selectVisibleOptions,g=l.data("li-height"),s=5*g,p=g*k;0<k&&6>k&&(s=p);0==k&&(p="auto");q>s+A+20?(f.height("auto").css({bottom:"auto",top:C}),k=function(){n.css("max-height",Math.floor((q-20-A)/g)*g)},k(),n.css("max-height",p),"none"!=z&&n.css("max-height",z),q<f.outerHeight()+20&&k()):(f.height("auto").css({top:"auto",bottom:C}),k=function(){n.css("max-height",Math.floor((h-b.scrollTop()-20-A)/g)*g)},k(),n.css("max-height",p),"none"!=
z&&n.css("max-height",z),h-b.scrollTop()-20<f.outerHeight()+20&&k())}c("div.jqselect").css({zIndex:d.singleSelectzIndex-1}).removeClass("opened");e.css({zIndex:d.singleSelectzIndex});f.is(":hidden")?(c("div.jq-selectbox__dropdown:visible").hide(),f.show(),e.addClass("opened focused"),d.onSelectOpened.call(e)):(f.hide(),e.removeClass("opened"),c("div.jq-selectbox").filter(".opened").length&&d.onSelectClosed.call(e));l.filter(".selected").length&&(0!=n.innerHeight()/g%2&&(g/=2),n.scrollTop(n.scrollTop()+
l.filter(".selected").position().top-n.innerHeight()/2+g));r.length&&(r.val("").keyup(),y.hide(),r.focus().keyup(function(){var a=c(this).val();l.each(function(){c(this).html().match(RegExp(".*?"+a+".*?","i"))?c(this).show():c(this).hide()});1>l.filter(":visible").length?y.show():y.hide()}));m(n);return!1}});l.hover(function(){c(this).siblings().removeClass("selected")});var D=l.filter(".selected").text();l.filter(".selected").text();l.filter(":not(.disabled):not(.optgroup)").click(function(){var b=
c(this),n=b.text();if(D!=n){var l=b.index(),l=l-b.prevAll(".optgroup").length;b.addClass("selected sel").siblings().removeClass("selected sel");h.prop("selected",!1).eq(l).prop("selected",!0);D=n;q.html(n);e.data("jqfs-class")&&e.removeClass(e.data("jqfs-class"));e.data("jqfs-class",b.data("jqfs-class"));e.addClass(b.data("jqfs-class"));a.change()}r.length&&(r.val("").keyup(),y.hide());f.hide();e.removeClass("opened");d.onSelectClosed.call(e)});f.mouseout(function(){c("li.sel",f).addClass("selected")});
a.change(function(){q.html(h.filter(":selected").text());l.removeClass("selected sel").not(".optgroup").eq(a[0].selectedIndex).addClass("selected sel");h.first().text()!=l.filter(".selected").text()?e.addClass("changed"):e.removeClass("changed")}).focus(function(){e.addClass("focused");c("div.jqselect").removeClass("opened")}).blur(function(){e.removeClass("focused")}).on("keydown keyup",function(c){q.html(h.filter(":selected").text());l.removeClass("selected sel").not(".optgroup").eq(a[0].selectedIndex).addClass("selected sel");
38!=c.which&&37!=c.which&&33!=c.which||f.scrollTop(f.scrollTop()+l.filter(".selected").position().top);40!=c.which&&39!=c.which&&34!=c.which||f.scrollTop(f.scrollTop()+l.filter(".selected").position().top-f.innerHeight()+liHeight);32==c.which&&c.preventDefault();13==c.which&&(c.preventDefault(),f.hide())});c(document).on("click",function(a){c(a.target).parents().hasClass("jq-selectbox")||"OPTION"==a.target.nodeName||(c("div.jq-selectbox").filter(".opened").length&&d.onSelectClosed.call(c("div.jq-selectbox").filter(".opened")),
r.length&&r.val("").keyup(),f.hide().find("li.sel").addClass("selected"),e.removeClass("focused opened"))})}function t(){var d=new w,e=c("<div"+d.id+' class="jq-select-multiple jqselect'+d.classes+'"'+d.title+' style="display: inline-block; position: relative"></div>');a.css({margin:0,padding:0}).after(e);b();e.append("<ul>"+x+"</ul>");var g=c("ul",e).css({position:"relative","overflow-x":"hidden","-webkit-overflow-scrolling":"touch"}),k=c("li",e).attr("unselectable","on").css({"-webkit-user-select":"none",
"-moz-user-select":"none","-ms-user-select":"none","-o-user-select":"none","user-select":"none","white-space":"nowrap"}),d=a.attr("size"),p=g.outerHeight(),f=k.outerHeight();void 0!==d&&0<d?g.css({height:f*d}):g.css({height:4*f});p>e.height()&&(g.css("overflowY","scroll"),m(g),k.filter(".selected").length&&g.scrollTop(g.scrollTop()+k.filter(".selected").position().top));a.prependTo(e).css({position:"absolute",left:0,top:0,width:"100%",height:"100%",opacity:0});a.is(":disabled")?(e.addClass("disabled"),
h.each(function(){c(this).is(":selected")&&k.eq(c(this).index()).addClass("selected")})):(k.filter(":not(.disabled):not(.optgroup)").click(function(b){a.focus();e.removeClass("focused");var d=c(this);b.ctrlKey||b.metaKey||d.addClass("selected");b.shiftKey||d.addClass("first");b.ctrlKey||(b.metaKey||b.shiftKey)||d.siblings().removeClass("selected first");if(b.ctrlKey||b.metaKey)d.is(".selected")?d.removeClass("selected first"):d.addClass("selected first"),d.siblings().removeClass("first");if(b.shiftKey){var f=
!1,g=!1;d.siblings().removeClass("selected").siblings(".first").addClass("selected");d.prevAll().each(function(){c(this).is(".first")&&(f=!0)});d.nextAll().each(function(){c(this).is(".first")&&(g=!0)});f&&d.prevAll().each(function(){if(c(this).is(".selected"))return!1;c(this).not(".disabled, .optgroup").addClass("selected")});g&&d.nextAll().each(function(){if(c(this).is(".selected"))return!1;c(this).not(".disabled, .optgroup").addClass("selected")});1==k.filter(".selected").length&&d.addClass("first")}h.prop("selected",
!1);k.filter(".selected").each(function(){var a=c(this),b=a.index();a.is(".option")&&(b-=a.prevAll(".optgroup").length);h.eq(b).prop("selected",!0)});a.change()}),h.each(function(a){c(this).data("optionIndex",a)}),a.change(function(){k.removeClass("selected");var a=[];h.filter(":selected").each(function(){a.push(c(this).data("optionIndex"))});k.not(".optgroup").filter(function(b){return-1<c.inArray(b,a)}).addClass("selected")}).focus(function(){e.addClass("focused")}).blur(function(){e.removeClass("focused")}),
p>e.height()&&a.keydown(function(a){38!=a.which&&37!=a.which&&33!=a.which||g.scrollTop(g.scrollTop()+k.filter(".selected").position().top-f);40!=a.which&&39!=a.which&&34!=a.which||g.scrollTop(g.scrollTop()+k.filter(".selected:last").position().top-g.innerHeight()+2*f)}))}var h=c("option",a),x="";a.is("[multiple]")?t():g()};g();a.on("refresh",function(){a.off().parent().before(a).remove();g()})}}):a.is(":reset")&&a.click(function(){setTimeout(function(){a.closest(d.wrapper).find("input, select").trigger("refresh")},
1)})}).promise().done(function(){d.onFormStyled.call()})}})(jQuery);