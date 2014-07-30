/**
 * Unicorn Admin Template
 * Version 2.2.0
 * Diablo9983 -> diablo9983@gmail.com
 **/

$(document).ready(function(){

	var msg_template = '<p><span class="msg-block"><strong></strong><span class="time"></span><span class="msg"></span></span></p>';
	var widget_chat = $('.widget-chat');
	var messages = $('#chat-messages');
	var message_box = $('.chat-message');
	var message_box_input = $('.chat-message input');
	var messages_inner = $('#chat-messages-inner');

	$(function(){
		messages_inner.html("");
		$.ajax({
			url:"/chat/list",
			type:"POST",
			dataType:"json",
			success: function(data){
				var i = 0;
				var portrait = "/static/img/demo/av2.jpg";
				for(index in data){
					i = i + 1;
					var content = data[index].content;
					var time = data[index].time;
					var sender = data[index].sender;
					var receiver = data[index].receiver;
					var id = 'msg-'+i;
					messages_inner.append('<p id="'+id+'" class="user-'+sender+'"><img src="' + portrait +'" alt="" />'
							+'<span class="msg-block"><strong>'+sender+'</strong> <span class="time">- '+time+'</span>'
							+'<span class="msg">'+content+'</span></span></p>');
					$('#'+id).fadeOut(0).addClass('show');
				}
				messages.animate({ scrollBottom: messages_inner.height() },1000);
				messages.getNiceScroll().resize();
			},
			error: function(data){
				
			}
		});
	});
	
	$('.chat-message button').click(function(){
		var input = $(this).parent().siblings('input[type=text]');	
		if(input.val() != ''){
			messages_inner.html("");
			add_message('/static/img/demo/av1.jpg',input.val(),true);
		} else {
			$('.input-box').addClass('has-error');
		}
	});

	messages.niceScroll({
		zindex: 1060
	});

	message_box_input.keypress(function(e){
		if($(this).val() != '') $('.input-box').removeClass('has-error');
		if(e.which == 13) {	
			if($(this).val() != ''){
				messages_inner.html("");
				add_message('/static/img/demo/av1.jpg',$(this).val(),true);
			} else {
				$('.input-box').addClass('has-error');
			}		
		}
	});

//	setTimeout(function(){
//		add_message('Neytiri','/static/img/demo/av2.jpg','I have a problem. My computer not work!')
//	},'1000');
//		setTimeout(function(){
//		add_message('Cartoon Man','/static/img/demo/av3.jpg','Turn off and turn on your computer then see result.')
//	},'5000');
//	setTimeout(function(){
//		remove_user('neytiri','Neytiri')
//	},'8000');
	
	function add_message(img,msg,clear) {

		var time = new Date();
		var hours = time.getHours();
		var minutes = time.getMinutes();
		if(hours < 10) hours = '0' + hours;
		if(minutes < 10) minutes = '0' + minutes;
		var time = hours + ':' + minutes;
		send_data(img, msg, time);
		if(clear) {
			$('.input-box').removeClass('has-error');
			message_box_input.val('').focus();

		}
	
	}

	function send_data(img, msg, time){
		$.ajax({
			url:"/chat/add",
			type:"POST",
			dataType:"json",
			data:{
				content:msg,
				time:time
			},
			success: function(data){
				var i = 0;
				var portrait = "/static/img/demo/av2.jpg";
				for(index in data){
					i = i + 1;
					var content = data[index].content;
					var time = data[index].time;
					var sender = data[index].sender;
					var receiver = data[index].receiver;
					var id = 'msg-'+i;
					messages_inner.append('<p id="'+id+'" class="user-'+sender+'"><img src="' + portrait + '" alt="" />'
							+'<span class="msg-block"><strong>'+sender+'</strong> <span class="time">- '+time+'</span>'
							+'<span class="msg">'+content+'</span></span></p>');
					$('#'+id).fadeOut(0).addClass('show');
				}
				messages.animate({ scrollBottom: messages_inner.height() },1000);
				messages.getNiceScroll().resize();
			},
			error: function(data){
				
			}
		});
	}

	function remove_user(userid,name) {
		i = i + 1;
		$('.contact-list li#user-'+userid).addClass('offline').delay(1000).slideUp(800,function(){
			$(this).remove();
		});
		var id = 'msg-'+i;
		messages_inner.append('<p class="offline al" id="'+id+'"><span>User <a href="#">@'+name+'</a> left the chat</span></p>');
		$('#'+id).fadeOut(0).addClass('show');
	}
});
