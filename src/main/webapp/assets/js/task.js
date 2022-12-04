
jQuery.noConflict();
jQuery(document).ready(function($) {
	console.log("abs")
    $('.container-custom').on('click', function(e) {
		var taskId = $(this).attr('data-id');
		console.log(taskId)
		$.ajax({
			url: "http://localhost:8080/CRMProject/taskList",
			type: 'get',
			data: {
				taskId: taskId,
				action: "update"
			}
		})
		.done(function(result){
			console.log(result);
			$('#mediumModal').modal('show');
			$('#mediumModalLabel').text("Cập nhật thông tin");
			$('#btn-modal').text("Cập nhật");
			$("#groupId").val(result.groupId);
			$("#taskId").val(result.taskId);
			$('#accountId').val(result.accountId);
			$("#endDate").val(result.endDate);
			$("#taskName").val(result.taskName);
			$("#accountId").val(result.accountId);
			$("#statusId").val(result.statusId);
			
			})		
			.fail(function(error){
				alert("ERROR");
			})
	})
	
	$("#btn-add-task").on('click', function(e) {
		
		$('#formTask').trigger("reset");
		$("#taskId").val("");
			$('#mediumModalLabel').text("Thêm mới nhóm việc");
			$('#btn-modal').text("Thêm mới");
	})
});