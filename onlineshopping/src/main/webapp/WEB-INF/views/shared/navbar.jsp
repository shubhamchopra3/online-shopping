 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="${UserClickHome?'active':''}"><a href="${contextRoot}/home">Home</a></li>
      <li class="${UserClickAbout?'active':''}"><a href="${contextRoot}/about">About</a></li>
      <li ><a href="${contextRoot}/listProducts">View Products</a></li>
      <li class="${UserClickContact?'active':''}"><a href="${contextRoot}/contact">Contact</a></li>
    </ul>
  </div>
</nav>