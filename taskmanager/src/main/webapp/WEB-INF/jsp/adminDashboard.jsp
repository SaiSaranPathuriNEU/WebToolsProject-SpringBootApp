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
  </head>
  <body>
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
              <a href="#profile" class="nav-link">Tasks</a>
          </li>
          <li class="nav-item">
              <a href="#messages" class="nav-link">Create Tasks</a>
          </li>
          <li class="nav-item">
            <a href="#messages" class="nav-link">View Users</a>
         </li>
         <li class="nav-item">
          <a href="#messages" class="nav-link">Logout</a>
       </li>
        
            
        </li>
      </ul>
      <div class="tab-content">
          <div class="tab-pane fade show active" id="home">
              <h4 class="mt-2">Home tab content</h4>
              <p>Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui. Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
          </div>
          <div class="tab-pane fade" id="profile">
              <h4 class="mt-2">Profile tab content</h4>
              <p>Vestibulum nec erat eu nulla rhoncus fringilla ut non neque. Vivamus nibh urna, ornare id gravida ut, mollis a magna. Aliquam porttitor condimentum nisi, eu viverra ipsum porta ut. Nam hendrerit bibendum turpis, sed molestie mi fermentum id. Aenean volutpat velit sem. Sed consequat ante in rutrum convallis. Nunc facilisis leo at faucibus adipiscing.</p>
          </div>
          <div class="tab-pane fade" id="messages">
              <h4 class="mt-2">Messages tab content</h4>
              <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis.</p>
          </div>
      </div>
  </div>
  </body>
  </html>