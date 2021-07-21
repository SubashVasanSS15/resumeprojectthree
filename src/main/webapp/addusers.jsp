<%@include file="includes/header.jsp" %>
<div class="container mtb">
    <div class="row">
      <div class="col-lg-6">
      <form action="${pageContext.request.contextPath}/operation" method="post">
      Username:<input type="text" name="username" required><br>
      Email:<input type="email" name="email" required><br>
      <input type="hidden" name="form" value="adduseroperation">
      
      <input type="submit" value="Add User"><br>
      </form>
      
      
      </div>
      </div>
      </div>
      
      <%@include file="includes/footer.jsp" %>