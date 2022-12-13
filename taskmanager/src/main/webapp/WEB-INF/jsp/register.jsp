<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@taglib
uri="http://www.springframework.org/tags/form" prefix="form"%> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registration</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
      /* Custom style to set icon size */
      .alert i[class^="bi-"] {
        font-size: 1.5em;
        line-height: 1;
      }
    </style>
  </head>
  <body>
    <form:form
      class="form-signin"
      action="register"
      method="post"
      modelAttribute="user"
    >
      <section class="vh-100" style="background-color: #eee">
        <div class="container h-100">
          <div
            class="row d-flex justify-content-center align-items-center h-100"
          >
            <div class="col-lg-12 col-xl-11">
              <div class="card text-black" style="border-radius: 25px">
                <div class="card-body p-md-5">
                  <div class="row justify-content-center">
                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                      <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                        Register Here
                      </p>

                      <form class="mx-1 mx-md-4">
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="firstName"
                              class="form-control"
                              name="firstName"
                              required="required"
                            />
                            <label class="form-label" for="form3Example1c"
                              ><strong>Name</strong>
                            </label>
                          </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="lastName"
                              class="form-control"
                              name="lastName"
                              required
                            />
                            <label class="form-label" for="form3Example1c"
                              ><strong>Last Name</strong></label
                            >
                          </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <input
                              type="email"
                              id="email"
                              class="form-control"
                              name="email"
                              required
                            />
                            <label class="form-label" for="form3Example3c"
                              ><strong>Email</strong>
                            </label>
                          </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <input
                              type="password"
                              id="password"
                              class="form-control"
                              name="password"
                              required
                            />
                            <label class="form-label" for="form3Example4c"
                              ><strong>Password</strong></label
                            >
                          </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0 form-group">
                            <select
                              class="loginlb1 form-control term"
                              name="role"
                              id="role"
                            >
                              <option>User</option>
                              <option>Admin</option>
                            </select>
                          </div>
                        </div>

                        <div
                          class="form-check d-flex justify-content-center mb-5"
                        >
                          <input
                            class="form-check-input me-2"
                            type="checkbox"
                            value=""
                            id="form2Example3c"
                            required
                          />
                          <label class="form-check-label" for="form2Example3">
                            I agree all statements in
                            <a href="#!">Terms of service</a>
                          </label>
                        </div>

                        <div
                          class="d-flex justify-content-center mx-4 mb-3 mb-lg-4"
                        >
                          <button type="submit" class="btn btn-primary btn-lg">
                            Register
                          </button>
                        </div>
                      </form>
                      <c:if test="${requestScope.getAlert == 'yes'}">
                        <!-- Error Alert -->
                        <div
                          class="alert alert-danger alert-dismissible d-flex align-items-center fade show"
                        >
                          <i class="bi-exclamation-octagon-fill"></i>
                          <strong class="mx-2">Error!</strong> A problem has
                          been occurred while submitting your data.
                          <button
                            type="button"
                            class="btn-close"
                            data-bs-dismiss="alert"
                          ></button>
                        </div>
                      </c:if>
                    </div>
                    <div
                      class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2"
                    >
                      <img
                        src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                        class="img-fluid"
                        alt="Sample image"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </form:form>
  </body>
</html>
