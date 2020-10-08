jQuery(function($) {

	$('#form').submit(
			function(e) {

				e.preventDefault();

				var $form = $('#form');
				var query = $form.serialize();
				var param = $form.serializeArray();

				dt = new Date($('#date').val());
				let y = dt.getFullYear();
				let m = dt.getMonth()
				let d = dt.getDate();
				dt.setMonth(dt.getMonth() - 1);
				if (dt.getFullYear() == y && dt.getMonth() == m - 1
						&& dt.getDate() == d) {
					$("#message").text("正常です");
					let message = "正常です"
					$.ajax({
						type : "PUT",
						url : '/skillsheet_information_update',
						data : {
							'message' : message,
							'Skillsheet' : query
						}
					});
				} else {
					// $("#message").text("生年月日を確認してください。");
					let message = "生年月日を確認してください。"
					$.ajax({
						type : "PUT",
						url : '/skillsheet_information_update',
						data : {
							'message' : message,
							'Skillsheet' : query
						}
					});
				}
			});
});

function validateDate(date) {
	dt = new Date(date);
	let y = dt.getFullYear();
	let m = dt.getMonth()
	let d = dt.getDate();
	dt.setMonth(dt.getMonth() - 1);
	return (dt.getFullYear() == y && dt.getMonth() == m - 1 && dt.getDate() == d);
}

onclick = "if(validateDate($('#date').val())){alert('valid date')}else{alert('invalid date')}"
