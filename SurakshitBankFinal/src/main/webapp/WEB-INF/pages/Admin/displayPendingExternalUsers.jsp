<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix='tags' tagdir='/WEB-INF/tags' %>
	

        <table >
         <tr>
        		<th style="visibility: false"></th>
        		<th style="visibility: false"></th>
        		<th>Name</th>
        		<th>Address</th>
        		<th>Email</th>
        		<th>Phone number</th>
        		<th>Role</th>
        		<th>Select operation</th>
        	</tr>
        	<c:forEach items="${pendingExtUsersList}" var="pendingExtUser">
        	<form:form action="adminApproveRejectExternalUser" method="POST">
				<tr>			
					<td><input type="hidden" name="emailID" value="${pendingExtUser.emailId}"></td>
					<td><input type="hidden" name="phoneNum" value="${pendingExtUser.phoneNumber}"></td>		
					<td align="center"><c:out value="${pendingExtUser.name}"></c:out> </td>
					<td align="center"><c:out value="${pendingExtUser.address}"></c:out></td>
					<td align="center"><c:out value="${pendingExtUser.emailId}"></c:out></td>
<%-- 					<fmt:formatNumber type="number" groupingUsed="false" value="${EmployeeProfile.phoneNumber}" /> --%>
					<td align="center"><c:out value="${pendingExtUser.phoneNumber}"></c:out></td>
					<td align="center"><c:out value="${pendingExtUser.role}"></c:out></td>
					<td><input type = "radio" name = "approveReject" id = "approveRejectSelection" value = "Approve" >Approve</td>
					<td><input type = "radio" name = "approveReject" id = "approveRejectSelection" value = "Reject" >Reject</td>
					<td><input type = "submit">
				</tr>
			</form:form>
			</c:forEach>
        </table>
      
<tags:commonJs />