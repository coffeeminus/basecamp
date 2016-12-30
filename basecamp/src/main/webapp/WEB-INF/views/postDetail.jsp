<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String postId = (String)request.getParameter("postId");
	System.out.println(postId);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
function checkPW(){
	//비밀번호를 확인하는 메소드
	var postId = <%= postId %>;
	var pw = $("#pw").val();

	//ajax 로 비밀번호 확인후 수정 submit 
	$.ajax({
		url: "checkPw.do",
		type: 'POST',
		data: 'postId=' +postId + "&pw=" + pw,
		success: function(ret){
			//비밀번호가 일치하지 않을때 - 0
			if(ret == 0){
				alert("비밀번호가 일치하지않습니다");
				return false;
			}
		},
		error: function (request, status, error) {
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});	
}

</script>
</head>
<body>
<div class="container">
    <h2 align="center">:D</h2>
    <div class="center">
      <form method="post" action="modPost.do" class="form-horizontal" role="form" align="center" onsubmit="return checkPW()">
      	<input type="hidden" name="postId" value='<%= postId %>'/>
        <div class="form-group" align="center">
          <label class="control-label col-sm-2" for="username">이메일<em>*</em></label>
          <div class="col-sm-6">
            <input type="text" name="email" id="email" class="form-control" value="${post.email}"readonly/>
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
        		<textarea class="form-control" rows="3" name="text">${post.text}</textarea>
        	</div>        	
        </div> 
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-8">
            <input type="submit" name="post" id="modifyPost" value="수정하기!" class="btn btn-default" />
           <a class="btn btn-default" href="boardList.do" role="button">목록으로</a>          
          </div>
        </div>
      </form>
    </div>
  </div>
</body>
</html>