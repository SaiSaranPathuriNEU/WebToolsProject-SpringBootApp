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
        <button type="button" class="btn btn-link px-3 me-2">
          Logout
        </button>
        
      </div>
    </div>
    <!-- Collapsible wrapper -->
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->
  <div class="m-4 justify-content-end">
      <ul class="nav nav-pills justify-content-center" id="myTab">
          <li class="nav-item">
              <a href="#home" class="nav-link active">Home</a>
          </li>
          <li class="nav-item">
              <a href="#tasks" class="nav-link">Tasks</a>
          </li>
          <li class="nav-item">
              <a href="#createTasks" class="nav-link">Create Tasks</a>
          </li>
          <li class="nav-item">
            <a href="#User" class="nav-link">View Users</a>
         </li>
         <li class="nav-item">
          <a href="#logout" class="nav-link">Logout</a>
       </li>
        
            
        </li>
      </ul>
      <form>
      <div class="tab-content">
          <div class="tab-pane fade show active " id="home">
            <c:if test="${user != null}">
              <h4 class="mt-2 align-items-center">Welcome <c:out
                value="${user.getEmail()}" /></h4>
              <p>Welcome to the Admin Page of the Task Manger Application!</p>
            </c:if>
            <h4 class="mt-2 align-items-center">Welcome Admin</h4>
          </div>
          
          <div class="tab-pane fade" id="tasks">
              <h4 class="mt-2">All Tasks:</h4>
              <div class="container">
                <div class="row">
                  <div class="col-12">
                    <table id="table1" class="table table-striped table-bordered" style="width:100%">
                      <thead>
                        <tr>
                          <th scope="col">ID</th>
                          <th scope="col">Task Description</th>
                          <th scope="col">Created By</th>
                          <th scope="col">Deadline</th>
                          <th scope="col">Assigned To</th>
                          <th scope="col">Status</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="task" items="${requestScope.tasks}">
                        <tr>                        
                          <th scope="row"><c:out value="${task.getId()}"/>1</th>
                          <td><c:out value="${task.getDescription()}"/></td>
                          <td><c:out value="${task.getCreatedBy()}"/></td>
                          <td><c:out value="${task.getTargetDate()}"/></td>
                          <td><c:out value="${task.getAssignedTo()}"/></td>
                          <td><c:out value="${task.getStatus()}"/></td>
                          <td>
                            <button type="button" class="btn btn-success"><i class="far fa-eye"></i>View</button>
                            <button type="button" class="btn btn-warning"><i class="fas fa-edit"></i>Update</button>
                            <button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i>Delete</button>
                          </td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
          </div>
          <div class="tab-pane fade show active " id="createTasks">
            <h4 class="mt-2 align-items-center">Create Tasks </h4>
            <p>Create a Task here!</p>
        </div>
        <div class="tab-pane fade" id="User">
          <h4 class="mt-2">All Users:</h4>
          <div class="container">
            <div class="row">
              <div class="col-12">
                <table id="table2" class="table table-striped table-bordered" style="width:100%">
                  <thead>
                    <tr>
                      <th scope="col">First Name</th>
                      <th scope="col">Last Name</th>
                      <th scope="col">Email</th>
                      <th scope="col">Role</th>
                  
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="arguser" items="${requestScope.allUsers}">
                    <tr>
                      
                      <th scope="row"><c:out value="${arguser.getFirstname()}"/></th>
                      <td><c:out value="${arguser.getLastname()}"/></td>
                      <td><c:out value="${arguser.getEmail()}"/></td>
                      <td><c:out value="${arguser.getRole()}"/></td>                  
                      <td>
                        <button type="button" class="btn btn-success"><i class="far fa-eye"></i>View</button>
                        <button type="button" class="btn btn-warning"><i class="fas fa-edit"></i>Update</button>
                      <button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i>Delete</button>
                      </td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
      </div>
          <div class="tab-pane fade" id="logout">
              <h4 class="mt-2">Messages tab content</h4>
              <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis.</p>
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