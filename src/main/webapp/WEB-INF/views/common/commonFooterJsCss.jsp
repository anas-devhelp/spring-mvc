<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Footer-->
<footer class="page-footer pt-0 mt-5">
    <!--Copyright-->
    <div class="footer-copyright py-3 text-center">
          <div class="container-fluid">
             © 2018 Copyright: <a href="https://jsolutions.com/" target="_blank"> JSolutions </a>
        </div>
    </div>
    <!--/.Copyright-->
</footer>
<!--/.Footer-->
<!-- SCRIPTS -->
<!-- JQuery -->
<script src="https://s3.ap-south-1.amazonaws.com/jsolutions/webapp/assets/js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://s3.ap-south-1.amazonaws.com/jsolutions/webapp/assets/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://s3.ap-south-1.amazonaws.com/jsolutions/webapp/assets/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://s3.ap-south-1.amazonaws.com/jsolutions/webapp/assets/js/mdb.min.js"></script>
<!--Custom scripts-->
<c:if test="${not empty message}">
	<script>
		toastr.success('${message}');
	</script>
</c:if>
<script>
    // SideNav Initialization
    $(".button-collapse").sideNav();

    var container = document.querySelector('.custom-scrollbar');
    Ps.initialize(container, {
        wheelSpeed: 2,
        wheelPropagation: true,
        minScrollbarLength: 20
    });
</script>