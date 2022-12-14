<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Creating Dynamic Tabs in Bootstrap via jQuery</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css" rel="stylesheet">  
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>   
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>   
    <link
      href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
      rel="stylesheet"
    />

  </head>
  <body>
    <section class="vh-100" style="background-color: #eee">
      <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-lg-12 col-xl-11">
            <div class="card text-black" style="border-radius: 25px">
              <div class="card-body p-md-5">
                <div class="row justify-content-center">
                  <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                      Task
                    </p>

                    <form class="mx-1 mx-md-4">
                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <input
                            type="text"
                            id="description"
                            class="form-control"
                            name="description"
                          />
                          <label class="form-label" for="form3Example1c"
                           ><strong>Task Description</label>
                          
                        </div>
                      </div>
                      <form class="mx-1 mx-md-4">
                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                        <c:set var="user" scope="session" value="${sessionScope.currentUser}" />
                        <div class="form-outline flex-fill mb-0">
                          <input
                            type="text"
                            id="createdBy"
                            class="form-control"
                            name="createdBy"
                            value="${sessionScope.currentUser.getEmail()}"
                          />
                          <label class="form-label" for="form3Example1c"
                           >Created By</label>
                          
                        </div>
                      </div>

                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <div class="form-outline mb-4">

                            <div class="form-group">
                                <select class="loginlb1 form-control term overflow-scroll" name="assignedTo" id="assignedTo" required>
                                     <c:forEach var="userEmails" items="${requestScope.allUsersEmails}">
                                <option class="overflow-scroll"><c:out value="${userEmails}"/></option>
                                </c:forEach>
                                </select>
                            </div>
                            </div>
                          <label class="form-label" for="form3Example3c" >Assigned To</label>
                        </div>
                      </div>

                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <input
                            type="text"
                            id="targetDate"
                            class="date form-control"
                            name="targetDate"
                          />
                          <label class="form-label" for="form3Example4c"
                            >Deadline</label
                          >
                        </div>
                      </div>

                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                         
                                <select class="loginlb1 form-control term overflow-scroll" name="role" id="role" required>
                                     
                                <option class="overflow-scroll">New Task</option>
                                <option class="overflow-scroll">Working</option>
                                <option class="overflow-scroll">Completed</option>
                                </c:forEach>
                                </select>
    
                          <label class="form-label" for="form3Example4cd"
                            >Task Status</label
                          >
                        </div>
                      </div>
                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <textarea class="form-control" rows="5" id="comment"></textarea>
                          <label class="form-label" for="form3Example4cd"id="comment"
                            >Comments</label
                          >
                        </div>
                      </div>

                      <div
                        class="d-flex justify-content-center mx-4 mb-3 mb-lg-4"
                      >
                        <button type="button" class="btn btn-primary btn-lg">
                          Ok
                        </button>
                      </div>
                    </form>
                  </div>
                  <div
                    class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2"
                  >
                   
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>   
<script type="text/javascript">  
    $('.date').datepicker({  
       format: 'mm-dd-yyyy'  
     });  
</script>  
  </body>
</html>
