<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div class="jumbotron">
    <h1>로그인</h1>
</div>
<div class="container">
    <c:url var="loginPath" value="/user/loginPost" />
    <c:url var="signUpPath" value="/signup" />
    <form action="${ loginPath }" method="post">
        <div class="form-group form-group-lg">
            <div class="form-group">
                <label>사용자명</label> <input type="text" name="id" class="form-control" placeholder="ID">
            </div>
            <div class="form-group">
                <label>비밀번호</label> <input type="password" name="pwd" class="form-control" placeholder="비밀번호">
            </div>
            <div class="form-group">
                <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
            </div>
            <div class="form-action">
                <input type="submit" class="btn btn-primary btn-lg" value="로그인">
                <a href="${ signUpPath }" class="btn btn-success btn-lg">회원 가입</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>