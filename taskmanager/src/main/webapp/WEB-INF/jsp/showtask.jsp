<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html lang="en">
  <head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Creating Dynamic Tabs in Bootstrap via jQuery</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
  <script>
  $(document).ready(function(){
      $("#myTab a").click(function(e){
          e.preventDefault();
          $(this).tab("show");
      });
  });
  </script>
  <style>
    .container {
  padding: 2rem 0rem;
}

h4 {
  margin: 2rem 0rem 1rem;
}

  </style>
  </head>
  <body>
    <c:set var="user" scope="session" value="${sessionScope.currentUser}" />
    <!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!-- Container wrapper -->
  <div class="container">
   
    <!-- Toggle button -->
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarButtonsExample"
      aria-controls="navbarButtonsExample"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarButtonsExample">
      <!-- Left links -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <span class="navbar-brand mb-0 h1">Task Manager</span>
        </li>
      </ul>
      <!-- Left links -->

      <div class="d-flex align-items-center">
        <a type="button" class="btn px-3 me-2" href="/taskmanager/task" >
          Create Tasks
        </a>
        <button type="button" class="btn  btn-primary me-3" href="/taskmanager/logout" >
          View Tasks
        </button>
        <a type="button" class="btn  px-3 me-2" href="/taskmanager/logout" >
          View Users
        </a>
        <a type="button" class="btn  px-3 me-2" href="/taskmanager/logout" >
          Logout
        </a>
        
      </div>
    </div>
    <!-- Collapsible wrapper -->
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->
  
     <form> 
          <div  id="tasks">
              <h4 class="mt-2 text-center">All Tasks under you</h4>
              <div class="container">
                <div class="row">
                  <div class="col-12">
                    <table id="table1" class="table table-striped table-bordered" style="width:90%">
                      <thead>
                        <tr>
                        
                          <th scope="col">Task Description</th>
                          <th scope="col">Created By</th>
                          <th scope="col">Deadline</th>
                          <th scope="col">Assigned To</th>
                          <th scope="col">Status</th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="task" items="${requestScope.tasks}">
                        <tr>                        
                          <td><c:out value="${task.getDescription()}"/></td>
                          <td><c:out value="${task.getCreatedBy()}"/></td>
                          <td><c:out value="${task.getTargetDate()}"/></td>
                          <td><c:out value="${task.getAssignedTo()}"/></td>
                          <td><c:out value="${task.getStatus()}"/></td>
                          <td>
                            <a type="button" class="btn btn-success"><i class="far fa-eye"></i>View Tsk</a>
                            <a type="button" class="btn btn-warning" href="/taskmanager/editTask/${task.getId()}"><i class="fas fa-edit"></i>Edit</a>
                            <a type="button" class="btn btn-danger" href="/taskmanager/deleteTask/${task.getId()}"><i class="far fa-trash-alt"></i>Delete</a>
                          </td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
        </div>
        
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap4.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#table1').DataTable();
            $('#table2').DataTable();
        });
      </script>
  </body>
  </html>