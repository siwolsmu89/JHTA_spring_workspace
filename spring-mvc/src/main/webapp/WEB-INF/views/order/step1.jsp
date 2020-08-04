<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-3 mb-5">
	<div class="row">
		<div class="col-12">
			<div class="card">
			<form method="post" action="step1.do">
				<div class="card-header">구매상품</div>
				<div class="card-body">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>상품이름</th>
								<td>${orderForm.productName }</td>
							</tr>
							<tr>
								<th>상품가격</th>
								<td>
									<fmt:formatNumber value="${orderForm.productPrice }" /> 원
								</td>
							</tr>
							<tr>
								<th>상품 할인가격</th>
								<td>
									<fmt:formatNumber value="${orderForm.productDiscountPrice }" /> 원
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="card-body">
					<div class="form-group">
						<label>구매수량</label>
						<input class="form-control" type="number" name="amount" value="1" />
					</div>
					<div class="form-group">
						<label>구매가격</label>
						<input class="form-control" type="number" name="price" value="${orderForm.productDiscountPrice }" />
					</div>
					<div class="form-group">
						<label>구매자 이름</label>
						<input class="form-control" type="text" name="username" />
					</div>
					<div class="form-group">
						<label>구매자 연락처</label>
						<input class="form-control" type="text" name="usertel" />
					</div>
				</div>
				<div class="card-footer text-right">
					<button type="submit" class="btn btn-primary">다음</button>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>