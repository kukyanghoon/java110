<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
 <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="639731399858-ahjc3pap9isuk2c10qp6h3i3icu37vsc.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
<title>로그인</title>
<link rel='stylesheet' href='/css/common.css'>
<style>
th {
	text-align: right;
}
</style>
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>

	<h1>로그인</h1>

	<form action='login' method='post'>
		<table>
			<tr>
				<th></th>
				<td><input type='radio' name='type' value='student' checked>학생
					<input type='radio' name='type' value='teacher'>강사 <input
					type='radio' name='type' value='manager'>매니저</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type='email' name='email'
					value='${cookie.email.value}'></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<th></th>
				<td><input type='checkbox' name='save'>이메일 저장</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<button>로그인</button> 
					<fb:login-button scope="public_profile, email" onlogin="checkLoginState();"></fb:login-button>

					<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
				</td>
				
			</tr>
		</table>
	</form>

	<jsp:include page="../footer.jsp" />


	<script type="text/javascript">

function autoLogin(accessToken) {
    var type = document.querySelector("input[name='type']:checked").value;
    location.href = "fblogin?type=" + type + 
            "&accessToken=" + accessToken;
}

function checkLoginState() {
    FB.getLoginStatus(function(response) { 
        if (response.status === 'connected') {
            autoLogin(response.authResponse.accessToken);
        
        } else {
            alert("Facebook 로그인 실패!");
        }
    });
}

window.fbAsyncInit = function() {
  console.log("window.fbAsyncInit() 호출됨!");
  FB.init({
    appId      : '1941679139472866', // 개발자가 등록한 앱 ID
    cookie     : true,  
    xfbml      : true,  
    version    : 'v3.2' 
  });
  FB.AppEvents.logPageView();
};

(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "https://connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));




function onSignIn(googleUser) {
  // Useful data for your client-side scripts:
  var profile = googleUser.getBasicProfile();
  console.log("ID: " + profile.getId()); // Don't send this directly to your server!
  console.log('Full Name: ' + profile.getName());
  console.log('Given Name: ' + profile.getGivenName());
  console.log('Family Name: ' + profile.getFamilyName());
  console.log("Image URL: " + profile.getImageUrl());
  console.log("Email: " + profile.getEmail());

  
  // The ID token you need to pass to your backend:
  var id_token = googleUser.getAuthResponse().id_token;
  console.log("ID Token: " + id_token);
};

</script>

</body>
</html>










