<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd html 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<title>로그인</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<script>
			function login(){
				if(document.frmLogin.id.value == "") {
					alert("ID를 입력하세요")
					document.frmLogin.id.focus();
				}
				else if (document.frmLogin.pw.value == "" ) {
					alert("비밀번호를 입력하세요")
					document.frmLogin.pw.focus();
				}
				else {
					document.frmLogin.submit() ;
				}
			}

</script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth=0 marginheight=80>
	<table border=0 cellpadding=0 cellspacing=0 width=100% height=100%>
		<tr>
		<td align=center>
		<table border=4 cellpadding=0 cellspacing=0 width=434 height=180>
			<tr><td align=center>
			<table border=0 cellpadding=0 cellspacing=0 width=400 height=180>
				<tr>
				<td width=107><img src="images/book.bmp"  border=0></td>
				<td width=281 height=150>
							<!-- 로그인 입력창 시작 -->

				<form method = "post" name = "frmLogin" action="main.do?act=login">
				<center><FONT face="굴림" size=3> 로그인하여 주세요</FONT></center>
				<p><p><p>
				<table border=0 cellpadding=0 cellspacing=2 align=center>
					<tr>
					<td><img src="images/id_id.gif" border=0 alt=""></td>
					<td><input type= "text" name="id"  class="input"  tabindex=1 onkeypress="if (event.keyCode == 13) login();" style='width:120;height:20;' ></td>	</tr>
					<tr>
					<td><img src="images/id_pass.gif" border=0 alt=""></td>
					<td><input type="password" name="pw"  class="input"  tabindex=2 onkeypress="if (event.keyCode == 13) login();" style='width:120;height:20;'></td></tr>
					<tr/><tr>
					<td></td>
					<td height="5" background="images/line.gif"></td>
					</tr><tr/>
					<tr><td></td>
					<td><a href="Javascript:login();"><img src="images/butt_login.gif" border = "0" width=80 height=25></a>
					</td>
					</tr>
				</table>
				</form>
							<!-- 로그인 입력창 끝 -->
				</td></tr></table>
			</td></tr></table>				
		</td></tr></table>
	</body>
</html>