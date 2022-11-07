
jQuery.noConflict();
jQuery(document).ready(function($) {
	console.log("abs")
    $('.btn-update-account').on('click', function(e) {
		console.log("asv");
		var url = $("#formAccount").attr('action');
		var accountId = $(this).attr('data-id');
		$.ajax({
			url: url,
			type: 'get',
			data: {
				accountId: accountId,
				action: "update"
			}
		})
		.done(function(result){
			console.log(result);
			$('#mediumModal').modal('show');
			$('#mediumModalLabel').text("Cập nhật thông tin");
			$('#btn-modal').text("Cập nhật");
			$("#accountId").val(result.accountId);
			$("#email").val(result.email);
			$(".password-control").hide();
			$("#fullname").val(result.fullname);
			$("#address").val(result.address);
			$("#phone").val(result.phone);
			})		
			.fail(function(error){
			})
	})

	$('.btn-delete-account').on('click', function(e) {
		var url = $('#formAccount').attr('action');
		var accountId = $(this).attr('data-id');
		$.ajax({
			url: url,
			type: 'get',
			data: {
				accountId: accountId,
				action: 'delete'
			}
		}).done(function(result) {
			alert("Xóa thành công");
			location.reload();
		}).fail(function(error) {
				alert("Xóa thất bại");
		}) 
	})
	
	$("#btn-add-account").on('click', function(e) {
		
			$(".password-control").show();
		$('#formAccount').trigger("reset");
			$('#mediumModalLabel').text("Thêm mới thành viên");
			$('#btn-modal').text("Thêm mới");
	})
});