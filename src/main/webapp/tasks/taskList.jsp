<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>


<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/sidebar.jsp"%>

<div class="content">
	<div class="animated fadeIn">
		<div class="row">

			<div class="col-lg-12">
				<div class="card">
					<div class="card-header card-header-custom">
						<h4><%= request.getParameter("groupName") %></h4>
						<button type="button" class="btn btn-secondary mb-1 btn-add-task"
							id="add-task" data-toggle="modal" data-target="#mediumModal">
							Thêm mới công việc</button>
					</div>
					<div class="card-body">
						<div class="default-tab">
							<nav>
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
									<a class="nav-item nav-link active" id="nav-home-tab"
										data-toggle="tab" href="#nav-task-data" role="tab"
										aria-controls="nav-home" aria-selected="true">Home</a> <a
										class="nav-item nav-link" id="nav-profile-tab"
										data-toggle="tab" href="#nav-list-task" role="tab"
										aria-controls="nav-profile" aria-selected="false">Profile</a>
								</div>
							</nav>
							<div class="tab-content pl-3 pt-2" id="nav-tabContent">
								<div class="tab-pane fade show active" id="nav-task-data"
									role="tabpanel" aria-labelledby="nav-task-data-tab">
									<div class="row">
										<div class="col-lg-6">
											<div class="card">
												<div class="card-body">
													<h4 class="mb-3">Pie Chart</h4>
													<div class="flot-container">
														<div id="flot-pie" class="flot-pie-container"></div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6">
											<div class="card">
												<div class="card-body">
													<h4 class="mb-3">Line Chart</h4>
													<div class="flot-container">
														<div id="chart1" style="width: 100%; height: 275px;"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="nav-list-task" role="tabpanel"
									aria-labelledby="nav-list-task-tab">
									<div class="row">
										<h3 style="padding: 16px;">Phạm Thành Công</h3>
									</div>
									<div class="row">
										<div class="col-md-4">
											<div class="card">
												<div class="card-header card-unprocess">
													<i class="fa  fa-gavel"></i> <strong
														class="card-title mb-3">Chưa thực hiện</strong>
												</div>
												<div class="card-body">
													<div class="container-custom">
														<p class="taskId">Task 001</p>
														<div class="row-custom">
															<div class="col-custom col-half-custom">
																<i class="fa fa-calendar">16/11/2022</i>
															</div>
															<div class="col-custom col-half-custom">
																<i class="fa fa-user"></i> Phạm Thành Công
															</div>
															<div class="clear"></div>
														</div>
													</div>

													<div class="container-custom">
														<p class="taskId">Task 001</p>
														<div class="row-custom">
															<div class="col-custom col-half-custom">
																<i class="fa fa-calendar">16/11/2022</i>
															</div>
															<div class="col-custom col-half-custom">
																<i class="fa fa-user"></i> Phạm Thành Công
															</div>
															<div class="clear"></div>
														</div>
													</div>
												</div>
											</div>
										</div>


										<div class="col-md-4">
											<div class="card">
												<div class="card-header card-processing">
													<i class="ti ti-reload"></i> <strong
														class="card-title mb-3">Đang thực hiện</strong>
												</div>
												<div class="card-body">
													<div class="container-custom">
														<p class="taskId">Task 001</p>
														<div class="row-custom">
															<div class="col-custom col-half-custom">
																<i class="fa fa-calendar">16/11/2022</i>
															</div>
															<div class="col-custom col-half-custom">
																<i class="fa fa-user"></i> Phạm Thành Công
															</div>
															<div class="clear"></div>
														</div>
													</div>

													<div class="container-custom">
														<p class="taskId">Task 001</p>
														<div class="row-custom">
															<div class="col-custom col-half-custom">
																<i class="fa fa-calendar">16/11/2022</i>
															</div>
															<div class="col-custom col-half-custom">
																<i class="fa fa-user"></i> Phạm Thành Công
															</div>
															<div class="clear"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="card">
												<div class="card-header card-complete">
													<i class="fa fa-check-square"></i> <strong
														class="card-title mb-3">Hoàn thành</strong>
												</div>
												<div class="card-body">
													<div class="container-custom">
														<p class="taskId">Task 001</p>
														<div class="row-custom">
															<div class="col-custom col-half-custom">
																<i class="fa fa-calendar">16/11/2022</i>
															</div>
															<div class="col-custom col-half-custom">
																<i class="fa fa-user"></i> Phạm Thành Công
															</div>
															<div class="clear"></div>
														</div>
													</div>

													<div class="container-custom">
														<p class="taskId">Task 001</p>
														<div class="row-custom">
															<div class="col-custom col-half-custom">
																<i class="fa fa-calendar">16/11/2022</i>
															</div>
															<div class="col-custom col-half-custom">
																<i class="fa fa-user"></i> Phạm Thành Công
															</div>
															<div class="clear"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- .row -->


								</div>
							</div>

						</div>
					</div>
				</div>
			</div>


		</div>
		<!-- MODAL -->
		<div class="modal fade" id="mediumModal" tabindex="-1" role="dialog"
			aria-labelledby="mediumModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="mediumModalLabel">Thêm mới công
							việc</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="<%= request.getContextPath() %>/taskList"
							method="post" class="" id="formGroup">
							<div class="form-group">
								<input type="hidden" id="taskId" name="taskId"
									class="form-control" value=""> <input type="hidden"
									id="groupId" name="groupId"
									value="<%= request.getParameter("groupId") %>"
									class="form-control"> <input type="hidden"
									id="groupName" name="groupName"
									value="<%= request.getParameter("groupName") %>"
									class="form-control">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<input type="text" id="taskName" name="taskName"
										placeholder="Tên công việc" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-lock"></i>
									</div>
									<input type="date" id="endDate" name="endDate"
										placeholder="Ngày kết thúc" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-lock"></i>
									</div>

									<select name="accountId" id="accountId"
										class="form-control-sm form-control">
										<option value="" disabled selected>Người thực hiện</option>
										<c:forEach items="${listAccount }" var="element">
											<option value="${element.getAccountId() }">${element.getFullname() }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-male"></i>
									</div>
									<select name="statusId" id="statusId"
										class="form-control-sm form-control">
										<option value="" disabled selected>Trạng thái</option>
										<c:forEach items="${listStatus }" var="element">
											<option value="${element.getStatusId() }">${element.getStatusName() }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">

									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Cancel</button>
									<button type="submit" class="btn btn-success btn-sm "
										id="btn-modal">Thêm mới</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- .animated -->
</div>
<!-- .content -->
<%@ include file="../layout/footer.jsp"%>
<script type="text/javascript" src="./assets/js/task.js"></script>
</body>
</html>