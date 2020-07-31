<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
	<title>자유 게시판</title>
</head>
<body>
	<div class="container mt-3 mb-5">
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-header">게시글 상세정보</div>
					<div class="card-body">
						<table class="table table-bordered">
							<colgroup>
								<col width="15%">
								<col width="35">
								<col width="15%">
								<col width="35%">
							</colgroup>
							<tr>
								<th>번호</th>
								<td>${board.no }</td>
								<th>등록일</th>
								<td><fmt:formatDate value="${board.createdDate }"/></td>
							</tr>
							<tr>
								<th>제목</th>
								<td><c:out value="${board.title }" /></td>
								<th>작성자</th>
								<td><c:out value="${board.writer }" /></td>
							</tr>
							<tr>
								<th>조회수</th>
								<td>${board.likes }</td>
								<th>최근 수정일</th>
								<td><fmt:formatDate value="${board.updatedDate }"/></td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td colspan="3">
									<c:choose>
										<c:when test="${empty board.filename }">
											첨부 파일이 없습니다.
										</c:when>
										<c:otherwise>
											<strong>${board.filename }</strong>
											<a href="download.do?no=${board.no }" class="btn btn-sm btn-outline-secondary">Download</a>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<th>내용</th>
								<td colspan="3"><c:out value="${board.content }" /></td>
							</tr>
						</table>
					</div>
					<div class="card-footer text-right">
						<div class="d-flex justify-content-between">
							<div>
								<a href="list.do" class="btn btn-primary">목록</a>
							</div>
							<div>
								<a href="modify.do?no=${board.no }" class="btn btn-warning">수정</a>
								<a href="delete.do?no=${board.no }" class="btn btn-danger">삭제</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>