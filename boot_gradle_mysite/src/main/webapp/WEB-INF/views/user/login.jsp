<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
   <!-- %@ include file ="../include/head.jsp" %> -->
<head>
<meta charset="EUC-KR">
<title>Login Page</title>
</head>
<body class ="hold-transaction login-page"">

    <div class="login-logo">
    	<a herf="${path}"/> <b> DoubleS</b> &nbsp MVC-BOARD
    </div>
    
    <div class ="login-box-bode">
    	<p class="login-box-msg">로그인 페이지</p>
    	
    	<form action="${path}/user/loginPost" method="post">
    		<div class="form-group has-feedback">
    		     <input type="text" name ="id" class ="form-control" palceholder="아이디">
    		     <span class ="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>    		
    		</div>
    		<div class="form-group has-feedback">
    		     <input type="password" name ="pwd" class ="form-control" palceholder="비밀번호">
    		     <span class ="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>    		
    		</div>
    		
    		<div class="row">
    		  <div class="col-xs-8">
    		    <div class="checkbox icheck">
    		    	<label> <input type ="checkbox" name ="useCookie"> 로그인유지 </label>    		    
    		    </div>
    		  </div>
    		  <div class="col-xs-4">
    		     <button type ="submit" class="btn btn-primary btn-block btn-flat" > 
    		       <i class="fa fa-sign-in"></i>로그인
    		      </button>     		     
    		  </div>    		
    		</div>    	
    	</form>
         
        <div class ="social-auth-link text-center">
            <p>- 또는 -</p>
            <a herf="#" class ="btn btn-block btn-social btn-facebook btn-flat">
               <i class="fa fa-facebook"></i>페이스북 로그인 
            </a>
             <a herf="#" class ="btn btn-block btn-social btn-google btn-flat">
               <i class="fa fa-google-plus"></i>구글 계정으로 로그인
            </a>
        </div> 
        
        <a herf="#"> 비밀번호 찾기</a>
        <a herf="${path}/user/register" class="text-center"> 회원가입</a>    	
    	</div>
    </div>
    
    <script>
     var msg ="${msg}";
     if(msg=="REGISTERED"){
    	 
    	 alert("회원가입이 완료되었습니다. 로그인해주세요");
    	 
     }else if(msg=="FAILURE"){
    	 
    	 alert("아이디와 비밀번호를 확인해 주세요");
     }
    
    </script>
    
</body>
</html>