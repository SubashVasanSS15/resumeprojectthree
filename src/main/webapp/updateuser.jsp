<%@include file="includes/header.jsp" %>
<div class="container mtb">
    <div class="row">
      <div class="col-lg-6">
      <form action="${pageContext.request.contextPath}/operation" method="post">
      Username:<input type="text" name="username" value="${param.username}" required><br>
      Email:<input type="email" name="email" value="${param.email }" required><br>
      <input type="hidden" name="usersId" value="${param.usersID}">
      <input type="hidden" name="form" value="updateuseroperation">
      
      <input type="submit" value="update User"><br>
      </form>
      
      
      </div>
      </div>
      </div>
      
      <%@include file="includes/footer.jsp" %>