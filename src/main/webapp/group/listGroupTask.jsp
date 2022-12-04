<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>


	<%@ include file="../layout/header.jsp"%>
	<%@ include file="../layout/sidebar.jsp"%>

	<div class="content">
		<div class="animated fadeIn">
			<div class="row">

				<div class="col-md-12">
					<div class="card">
						<div class="card-header" style="height: 80px;">
                                <strong class="card-title add-title">Danh sách nhóm việc</strong>
                                <button type="button" class="btn btn-secondary mb-1 btn-add-group" id="btn-add-group" data-toggle="modal" data-target="#mediumModal">
                                    Thêm mới nhóm việc
                                </button>
                            </div>
						<div class="card-body">
							<table id="bootstrap-data-table"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>Mã nhóm việc</th>
										<th>Tên nhóm việc</th>
										<th>Mô tả</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${listGroupTask}" var="group">
										<tr>
											<td>${group.getGroupId()}</td>
											<td>${group.getGroupName()}</td>
											<td>${group.getDescription()}</td>
											<td><a href="<%= request.getContextPath() %>/taskList?groupId=${group.getGroupId()}&groupName=${group.getGroupName()}" class="btn btn-success " data-id="${group.getGroupId()}"><i class="fa fa-check"></i></a>
                                                <button type="button" class="btn btn-primary btn-update-group" data-id="${group.getGroupId()}"><i class="fa fa-edit"></i></button>
                                                <button type="button" class="btn btn-danger btn-delete-group" data-id="${group.getGroupId()}"><i class="fa fa-trash-o"></i></button></td>
                                                
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>


			</div>
			    <!-- MODAL -->
                <div class="modal fade" id="mediumModal" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="mediumModalLabel">Thêm mới nhóm việc</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="<%= request.getContextPath() %>/groupTask" method="post" class="" id="formGroup">
                                <input type="text" id="groupId" name="groupId" placeholder="groupId" class="form-control hidden" style="display: none;">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                            <input type="text" id="groupName" name="groupName" placeholder="Tên nhóm việc" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group password-control">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                                            <textarea id="description" name="description" rows="5" cols="50" placeholder="Mô tả" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                            <button type="submit" class="btn btn-success btn-sm " id="btn-modal">Thêm mới</button>
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
	<script type="text/javascript" src="./assets/js/group.js"></script>
</body>
</html>