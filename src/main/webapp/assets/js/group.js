
jQuery.noConflict();
jQuery(document).ready(function($) {
	console.log("abs")
    $('.btn-update-group').on('click', function(e) {
		console.log("asv");
		var url = $("#formGroup").attr('action');
		var groupId = $(this).attr('data-id');
		$.ajax({
			url: url,
			type: 'get',
			data: {
				groupId: groupId,
				action: "update"
			}
		})
		.done(function(result){
			console.log(result);
			$('#mediumModal').modal('show');
			$('#mediumModalLabel').text("Cập nhật thông tin");
			$('#btn-modal').text("Cập nhật");
			$("#groupId").val(result.groupId);
			$("#groupName").val(result.groupName);
			$("#description").val(result.description);
			})		
			.fail(function(error){
				alert("ERROR");
			})
	})

	$('.btn-delete-group').on('click', function(e) {
		var url = $('#formGroup').attr('action');
		var groupId = $(this).attr('data-id');
		$.ajax({
			url: url,
			type: 'get',
			data: {
				groupId: groupId,
				action: 'delete'
			}
		}).done(function(result) {
			alert("Xóa thành công");
			location.reload();
		}).fail(function(error) {
				alert("Xóa thất bại");
		}) 
	})
	
	$("#btn-add-group").on('click', function(e) {
		
		//$('#formGroup').trigger("reset");
		$("#groupId").val("");
			$("#groupName").val("");
			$("#description").val("");
			$('#mediumModalLabel').text("Thêm mới nhóm việc");
			$('#btn-modal').text("Thêm mới");
	})
});