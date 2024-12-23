<%@ include file="views/header.jsp" %>
<div class="container mt-5">
    <h1 class="text-center mb-4">Welcome to the Event Management System</h1>
    <p class="lead text-center">
        Manage your events with ease. Create, view, update, and delete events seamlessly.
    </p>
    <div class="text-center mt-4">
        <a href="${pageContext.request.contextPath}/events" class="btn btn-primary btn-lg">Go to Events</a>
    </div>
</div>
<%@ include file="views/footer.jsp" %>
