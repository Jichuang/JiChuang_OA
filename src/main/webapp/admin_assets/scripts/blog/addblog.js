var addBlog = function() {

	var handleAdd = function() {
		$("#addBlogForm").validate({
			errorElement : 'span', // default input error message container
			errorClass : 'help-block', // default input error message class
			focusInvalid : false, // do not focus the last invalid input
			rules : {
				blogtitle : {
					required : true
				},
				blogcont : {
					required : true
				},
				blogtags : {
					required : true
				}
			},

			messages : {
				blogtitle : {
					required : "博客的标题不能为空"
				},
				blogcont : {
					required : "博客的内容不能为空"
				},
				blogtags : {
					required : "博客的标签不能为空"
				}
			},

			invalidHandler : function(event, validator) { // display error
				// alert on form
				// submit
				$('.alert-error', $('.login-form')).show();
			},

			highlight : function(element) { // hightlight error inputs
				$(element).closest('.form-group').addClass('has-error'); // set
				// error
				// class
				// to
				// the
				// control
				// group
			},

			success : function(label) {
				label.closest('.form-group').removeClass('has-error');
				label.remove();
			},

			errorPlacement : function(error, element) {
                var unique_id = $.gritter.add({
                    // (string | mandatory) the heading of the notification
                    title: '您的博客还没有编辑完!',
                    // (string | mandatory) the text inside the notification
                    text: '请确认您的博客的标题、内容、标签已经填写完毕',
                    // (string | optional) the image to display on the left
                    image: './admin_assets/img/avatar1.jpg',
                    // (bool | optional) if you want it to fade out on its own or just sit there
                    sticky: true,
                    // (int | optional) the time you want it to be alive for before fading out
                    time: '',
                    // (string | optional) the class name you want to apply to that specific message
                    class_name: 'my-sticky-class'
                });

                // You can have it return a unique id, this can be used to manually remove it later using
                setTimeout(function () {
                    $.gritter.remove(unique_id, {
                        fade: true,
                        speed: 'slow'
                    });
                }, 12000);
            },

			
			submitHandler : function(form) {
				form.submit();
			}
		});

		$("#addBlogForm input").keypress(function(e) {
			if (e.which == 13) {
				if ($("#addBlogForm").validate().form()) {
					$("#addBlogForm").submit();
				}
				return false;
			}
		});
	}

	return {
		// main function to initiate the module
		init : function() {

			handleAdd();

		}

	};

}();