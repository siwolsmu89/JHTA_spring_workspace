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
			<form method="post" action="step2.do">
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
							<tr>
								<th>구매수량</th>
								<td>
									<fmt:formatNumber value="${orderForm.amount }" />
								</td>
							</tr>
							<tr>
								<th>구매자 이름</th>
								<td>${orderForm.username }</td>
							</tr>
							<tr>
								<th>구매자 연락처</th>
								<td>${orderForm.usertel }</td>
							</tr>
							<tr>
								<th>결제방식</th>
								<td>${orderForm.payType }</td>
							</tr>
							<tr>
								<th>결제 카드</th>
								<td>${orderForm.payAccount }</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="card-body">
					<div class="form-group">
						<label>수령자 이름</label>
						<input class="form-control" type="text" name="receiverUsername" />
					</div>
					<div class="form-group">
						<label>수령자 전화번호</label>
						<input class="form-control" type="text" name="receiverTel" />
					</div>
					<div class="form-group">
						<label>수령자 주소</label>
						<input class="form-control" type="text" name="receiverAddress" />
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