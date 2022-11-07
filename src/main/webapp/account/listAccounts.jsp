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
                                <strong class="card-title add-title">Danh sách thành viên</strong>
                                <button type="button" class="btn btn-secondary mb-1 add-account" id="btn-add-account" data-toggle="modal" data-target="#mediumModal">
                                    Thêm mới nhân viên
                                </button>
                            </div>
						<div class="card-body">
							<table id="bootstrap-data-table"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>Họ tên</th>
										<th>Email</th>
										<th>Điện thoại</th>
										<th>Địa chỉ</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${listAccounts}" var="account">
										<tr>
											<td>${account.getFullname()}</td>
											<td>${account.getEmail()}</td>
											<td>${account.getPhone()}</td>
											<td>${account.getAddress()}</td>
											<td><button type="button" class="btn btn-success " data-id="${account.getAccountId()}"><i class="fa fa-check"></i></button>
                                                <button type="button" class="btn btn-primary btn-update-account" data-id="${account.getAccountId()}"><i class="fa fa-edit"></i></button>
                                                <button type="button" class="btn btn-danger btn-delete-account" data-id="${account.getAccountId()}"><i class="fa fa-trash-o"></i></button></td>
                                                
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
                                <h5 class="modal-title" id="mediumModalLabel">Thêm mới thành viên</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="<%= request.getContextPath() %>/accounts" method="post" class="" id="formAccount">
                                <input type="text" id="accountId" name="accountId" placeholder="accountId" class="form-control hidden" style="display: none;">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                            <input type="email" id="email" name="email" placeholder="Email" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group password-control">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                                            <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group password-control">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                                            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Nhập lại mật khẩu " class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-male"></i></div>
                                            <input type="text" id="fullname" name="fullname" placeholder="Họ tên" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-home"></i></div>
                                            <input type="text" id="address" name="address" placeholder="Địa chỉ" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon"><i class="fa fa-phone"></i></div>
                                            <input type="text" id="phone" name="phone" placeholder="Số điện thoại" class="form-control">
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
	<script type="text/javascript" src="./assets/js/account.js"></script>
</body>
</html>