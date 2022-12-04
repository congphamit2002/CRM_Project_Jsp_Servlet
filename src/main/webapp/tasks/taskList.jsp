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
						<h4><%=request.getParameter("groupName")%></h4>
						<button type="button" class="btn btn-secondary mb-1 btn-add-task"
							id="btn-add-task" data-toggle="modal" data-target="#mediumModal">
							Thêm mới công việc</button>
					</div>
					<div class="card-body">
						<div class="default-tab">
							<nav>
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
									<a class="nav-item nav-link active" id="nav-home-tab"
										data-toggle="tab" href="#nav-task-data" role="tab"
										aria-controls="nav-home" aria-selected="true">Thống kê công việc</a> <a
										class="nav-item nav-link" id="nav-profile-tab"
										data-toggle="tab" href="#nav-list-task" role="tab"
										aria-controls="nav-profile" aria-selected="false">Danh sách công việc</a>
								</div>
							</nav>
							<div class="tab-content pl-3 pt-2" id="nav-tabContent">
							<c:forEach items="${listChartItem }" var="element">
									<c:if test= "${element.getStatusId() == 1 }">
										<input type="hidden" id="count-unprocess" name="count-unprocess"
									class="form-control" value="${element.getCountItem() }">
									</c:if>
									<c:if test= "${element.getStatusId() == 2 }">
										<input type="hidden" id="count-processing" name="count-processing"
									class="form-control" value="${element.getCountItem() }">
									</c:if>
									<c:if test= "${element.getStatusId() == 3 }">
										<input type="hidden" id="count-complete" name="count-complete"
									class="form-control" value="${element.getCountItem() }">
									</c:if>
								</c:forEach>
								<div class="tab-pane fade show active" id="nav-task-data"
									role="tabpanel" aria-labelledby="nav-task-data-tab">
									<div class="row">
										<div class="col-lg-6">
											<div class="card">
												<div class="card-body">
													<h4 class="mb-3">Biểu đồ tròn</h4>
													<div class="flot-container">
														<div id="flot-pie" class="flot-pie-container"></div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6">
											<div class="card">
												<div class="card-body">
													<h4 class="mb-3">Biểu đồ cột</h4>
													<canvas id="singelBarChart"></canvas>
												</div>
											</div>
										</div>
										<!-- /# column -->
									</div>
								</div>
								<div class="tab-pane fade" id="nav-list-task" role="tabpanel"
									aria-labelledby="nav-list-task-tab">
									<c:forEach items="${listGroupTasks }" var="element">
										<div>
											<div class="row">
												<h3 style="padding: 16px;">${ element.getFullname()}</h3>
											</div>

											<div class="row">
												<div class="col-md-4">
													<div class="card"
														style="border: 1px solid rgb(56, 147, 229);">
														<div class="card-header card-unprocess">
															<i class="fa  fa-gavel"></i> <strong
																class="card-title mb-3">Chưa thực hiện</strong>
														</div>
														<div class="card-body">
															<c:forEach items="${element.getListTasks() }" var="task">
																<c:if test="${task.getStatusId() == 1}">
																	<div class="container-custom"
																		data-id="${task.getTaskId() }">
																		<p class="taskId">${task.getTaskName() }</p>
																		<div class="row-custom">
																			<div class="col-custom col-half-custom">
																				<i class="fa fa-calendar">${task.getEndDate() }</i>
																			</div>
																			<div class="col-custom col-half-custom">
																				<i class="fa fa-user"></i> ${task.getFullname() }
																			</div>
																			<div class="clear"></div>
																		</div>
																	</div>
																</c:if>
															</c:forEach>
														</div>
													</div>
												</div>

												<div class="col-md-4">
													<div class="card" style="border: 1px solid #02c543;">
														<div class="card-header card-processing">
															<i class="ti ti-reload"></i> <strong
																class="card-title mb-3">Đang thực hiện</strong>
														</div>
														<div class="card-body">
															<c:forEach items="${element.getListTasks() }" var="task">
																<c:if test="${task.getStatusId() == 2}">
																	<div class="container-custom"
																		data-id="${task.getTaskId() }">
																		<p class="taskId">${task.getTaskName() }</p>
																		<div class="row-custom">
																			<div class="col-custom col-half-custom">
																				<i class="fa fa-calendar">${task.getEndDate() }</i>
																			</div>
																			<div class="col-custom col-half-custom">
																				<i class="fa fa-user"></i> ${task.getFullname() }
																			</div>
																			<div class="clear"></div>
																		</div>
																	</div>
																</c:if>
															</c:forEach>
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="card" style="border: 1px solid #df941a;">
														<div class="card-header card-complete">
															<i class="fa fa-check-square"></i> <strong
																class="card-title mb-3">Hoàn thành</strong>
														</div>
														<div class="card-body">
															<c:forEach items="${element.getListTasks() }" var="task">
																<c:if test="${task.getStatusId() == 3}">
																	<div class="container-custom"
																		data-id="${task.getTaskId() }">
																		<p class="taskId">${task.getTaskName() }</p>
																		<div class="row-custom">
																			<div class="col-custom col-half-custom">
																				<i class="fa fa-calendar">${task.getEndDate() }</i>
																			</div>
																			<div class="col-custom col-half-custom">
																				<i class="fa fa-user"></i> ${task.getFullname() }
																			</div>
																			<div class="clear"></div>
																		</div>
																	</div>
																</c:if>
															</c:forEach>
														</div>
													</div>
												</div>
											</div>
											<!-- .row -->
										</div>
									</c:forEach>


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
						<form action="<%=request.getContextPath()%>/taskList"
							method="post" class="" id="formTask">
							<div class="form-group">
								<input type="hidden" id="taskId" name="taskId"
									class="form-control" value=""> <input type="hidden"
									id="groupId" name="groupId"
									value="<%=request.getParameter("groupId")%>"
									class="form-control"> <input type="hidden"
									id="groupName" name="groupName"
									value="<%=request.getParameter("groupName")%>"
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


<!--Flot Chart-->
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.7.3/dist/Chart.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery.flot@0.8.3/jquery.flot.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/flot-spline@0.0.1/js/jquery.flot.spline.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/flot.curvedlines@1.1.1/curvedLines.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery.flot@0.8.3/jquery.flot.pie.min.js"></script>

<script type="text/javascript" src="./assets/js/task.js"></script>
<script type="text/javascript" src="./assets/js/custom-chart.js"></script>

</body>
</html>