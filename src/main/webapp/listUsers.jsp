<%@include file="includes/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.user" %>


 <div class="container mtb">
    <div class="row">
      <div class="col-lg-6">
      <h1>List Users</h1>
      <hr>
      <table border="1">
      <thead>
      <th>User ID</th>
       <th>Username</th>
        <th>Email</th>
        <th>Operations</th>
      </thead>
      <%! String deleteURL; %>
      <%
      List<user> listUsers=(List)request.getAttribute("listUsers");
      String updateURL;
      for(int i=0;i<listUsers.size();i++){
    	  out.print("<tr>");
    	  out.print("<td>"+listUsers.get(i).getUsers_id()+"</td>");
    	  out.print("<td>"+listUsers.get(i).getUser_name()+"</td>");
    	  out.print("<td>"+listUsers.get(i).getEmail()+"</td>");
    	  updateURL=request.getContextPath()+"/operation?page=updateuser"+
    			 "&usersID="+listUsers.get(i).getUsers_id()+
    	         "&username="+listUsers.get(i).getUser_name()+
    	         "&email="+listUsers.get(i).getEmail();
    	  deleteURL=request.getContextPath()+"/operation?page=deleteuser"+
    	         "&usersID="+listUsers.get(i).getUsers_id();
    	  out.print("<td><a href="+updateURL+">Update</a> | ");
      %>
      <a href="<%= deleteURL%>"
         onclick="if(!confirm('Are u sure want to delete the user?')) return false">Delete</a>
         </td>
      </tr>
      <%}%>
      </table>
      </div>
      </div>
      </div>
<%@include file="includes/footer.jsp" %>