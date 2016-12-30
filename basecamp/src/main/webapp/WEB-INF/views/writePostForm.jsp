<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>writePostForm</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style type="text/css">
.center {
  margin-left: auto;
  margin-right: auto;
}
</style>
<script type="text/javascript">
function checkPost(){
	//입력값들 가져오기
	var inputEmail = $("#email");
	
	//이메일 유효성 검사
	var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	
	//글검사
	if(!inputEmail.val()){
		alert("이메일 주소를 입력해 주세요");
		inputEmail.focus();
		return false;
	}
	if(!regEmail.test(inputEmail.val())){
		alert("유효하지 않은 이메일");
		inputEmail.focus();
		return false;
	}
}
</script>
</head>
<body>
<div class="container">
    <h2 align="center">글 작성</h2>
    <div class="center">    
      <form method="post" action="writePost.do" class="form-horizontal" role="form" align="center" onsubmit="return checkPost()">
        <div class="form-group" align="center">
          <label class="control-label col-sm-2" for="username">이메일<em>*</em></label>
          <div class="col-sm-6">
            <input type="text" name="email" id="email" placeholder="이메일@도메인.com" required="true" class="form-control" />
           	
           </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="password">비밀번호<em>*</em></label>
          <div class="col-sm-6">
            <input type="password" name="pw" id="pw" required="true" class="form-control" />
          </div>
        </div>
        <div class="form-group">
        	<label class="control-label col-sm-2" for="text">내용</label>
        	<div class="col-sm-6">
        		<textarea class="form-control" rows="3" name="text"></textarea>
        	</div>        	
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-8">
            <input type="submit" name="post" id="submitPost" value="등록!" class="btn btn-default" />
           <a class="btn btn-default" href="boardList.do" role="button">목록으로</a>          
          </div>
        </div>
      </form>
    </div>
  </div>
</body>
</html>