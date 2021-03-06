<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-16" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-16">
		<title>registration</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/additional-methods.js"></script>
	</head>
	<style>
		.has-error.help-block,
    .has-error.control-label,
    .has-error.radio,
    .has-error.checkbox,
    .has-error.radio-inline,
    .has-error.checkbox-inline,
    .has-error.radio label,
    .has-error.checkbox label,
    .has-error.radio-inline label,
    .has-error.checkbox-inline label {
      color: #cc0000;
    }
    .has-error.form-control {
      border-color: #cc0000;
      -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
      box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    }
    .has-error.form-control:focus {
      border-color: #990000;
      -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #ff3333;
      box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #ff3333;
    }
    .has-error.input-group-addon {
      color: #cc0000;
      border-color: #cc0000;
      background-color: #fff5cc;
    }
    .has-error.form-control-feedback {
      color: #cc0000;
    }
	.valid-feedback.feedback-icon,
	.invalid-feedback.feedback-icon {
		position: absolute;
		width: auto;
		bottom: 10px;
		right: 10px;
		margin-top: 0;
	}
	</style>
	<body>
		<spring:message code="reg.msg.rule.password1" var="reg.msg.rule.password1" />
		<spring:message code="reg.msg.rule.username" var="reg.msg.rule.username" />
		<spring:message code="reg.placeholder.firstname" var="reg.placeholder.firstname" />
		<spring:message code="reg.placeholder.lastname" var="reg.placeholder.lastname" />
		<spring:message code="reg.placeholder.email" var="reg.placeholder.email" />
		<spring:message code="reg.placeholder.password1" var="reg.placeholder.password1" />
		<spring:message code="reg.placeholder.password2" var="reg.placeholder.password2" />
		<spring:message code="reg.placeholder.firstname" var="reg.placeholder.firstname" />
		<spring:message code="reg.placeholder.photo" var="reg.placeholder.photo"/>
		
		<spring:message  code="reg.msg.req.firstname" var="reg.msg.req.firstname"/>
		<spring:message  code="reg.msg.req.lastname" var="reg.msg.req.lastname"/>
		<spring:message  code="reg.msg.req.email" var="reg.msg.req.email"/>
		<spring:message  code="reg.msg.email.email" var="reg.msg.email.email"/>
		<spring:message  code="reg.msg.req.password1" var="reg.msg.req.password1"/>
		<spring:message  code="reg.msg.req.password2" var="reg.msg.req.password2"/>
		<spring:message code="reg.msg.equalTo.password2" var="reg.msg.equalTo.password2"/>
		<spring:message code="reg.placeholder.photo" var="reg.placeholder.photo"/>
		<spring:message code="reg.msg.req.photo" var="reg.msg.req.photo"/>		
		
		
		
		<div class="container-fluid">
		  <form role="form" id="myForm" action="#" enctype="multipart/form-data">
		    <div class="form-group">
		      <label for="#first" class="col-lg-4 d-none d-sm-block"><b><spring:message code="reg.label.firstname" text="Firstname:" /></b></label>
		      <input type="text" id="first" class="form-control col-lg-4 col-sm-12 col-xs-12 has-error" name="firstname" placeholder="${reg.placeholder.firstname}" data-msg-required="${reg.msg.req.firstname}" data-rule-required="true" />
		    </div>
		    <div class="form-group">
		      <label for="#last" class="col-lg-4 d-none d-sm-block"><b><spring:message code="reg.label.lastname" text="Lastname:" /></b></label>
		      <input type="text" id="last" class="form-control col-lg-4 col-sm-12 col-xs-12 has-error" name="lastname" data-msg-required="${reg.msg.req.lastname}" placeholder="${reg.placeholder.lastname}" data-rule-required="true" />
		    </div>
		    <div class="form-group">
		      <label for="#email" class="col-lg-4 d-none d-sm-block"><b><spring:message code="reg.label.email" text="email:" /></b></label>
		      <input type="email" id="email" class="form-control col-lg-4 col-sm-12 col-xs-12 has-error" name="email" data-msg-required="${reg.msg.req.email}" data-msg-email="${reg.msg.email.email}" placeholder="${reg.placeholder.email}" data-rule-required="true" data-rule-email="true" />
		    </div>
		    <div class="form-group">
		      <label for="#password" class="col-lg-4 d-none d-sm-block"><b><spring:message code="reg.label.password1" text="password:" /></b></label>
		      <input type="password" id="password" class="form-control col-lg-4 col-sm-12 col-xs-12 has-error" name="password1" data-msg-required="${reg.msg.req.password1}" placeholder="${reg.placeholder.password1}" data-rule-required="true" data-rule-regex="required password" />
		    </div>
		    <div class="form-group">
		      <label for="#password2" class="col-lg-4 d-none d-sm-block"><b><spring:message code="reg.label.password2" text="Retype password:" /></b></label>
		      <input type="password" id="password2" class="form-control col-lg-4 col-sm-12 col-xs-12 has-error" name="password2" data-msg-required="${reg.msg.req.password2}" data-msg-equalTo="${reg.msg.equalTo.password2}" placeholder="${reg.placeholder.password2}" data-rule-required="true" data-rule-equalTo="#password" />
		    </div>
		    <div class="form-group">
		      <label for="#profilePhoto" class="col-lg-4 d-none d-sm-block"><b><spring:message code="reg.label.photo" text="Profile Photo:"/></b></label>
		      <input type="file" id="profilePhoto" class="form-control col-lg-4 col-sm-12 col-xs-12 has-error" name="photo" data-msg-required="${reg.msg.req.photo}"  placeholder="${reg.placeholder.photo}" data-rule-required="true" />
		    </div>
		    <button id="btn" type="submit" class="btn btn-primary"><spring:message code="reg.label.submit" text="Submit" /></button>
		  </form>
		</div>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		  $("#myForm").validate({});

		  var map = {};

		  $.validator.setDefaults({
		    highlight: function(element, errorClass, validClass) {
		      $(element).addClass("is-invalid").removeClass("is-valid");
		    },
		    unhighlight: function(element, errorClass, validClass) {
		      $(element).addClass("is-valid").removeClass("is-invalid");
		    },
		    errorElement: 'em',
		    errorClass: 'help-block',
		    errorPlacement: function(error, element) {
		      error.addClass("invalid-feedback");
		    }

		  });

		  $.validator.addMethod("regex", function(value, element) {
		    return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
		  }, "Passwords are 8-16 characters with uppercase letters, lowercase letters and at least one number.");

		  $("#myForm").submit(function(e) {
		    e.preventDefault();
		    if ($("#myForm").valid()) {
		    	var formData = new FormData(this);
		    	formData.append("properties", new Blob([JSON.stringify(createMap())], {
	                type: "application/json"
	            }));
		    	$("[type='file']").each(function(){
		    		formData.append($(this).attr("name"),$(this).val());
			    	});
		      $.ajax({
		        type: 'post',
		        url: "addEmployee",
		        data: formData,
		        contentType: 'application/json',
		        dataType: 'json',
		        success: function(xxx) {
		          alert(xxx);
		        },
		        error: function(e) {
		          alert("Request failed: " + JSON.stringify(e));
		        }
		      });
		    }
		  });

		  function createMap() {
		    $("form input").each(function() {
		      if ($(this).val() != null) {
		        var key = $(this).attr("name");
		        if($(this).attr("type") == "file")
			        	continue;
		        var value = $(this).val();
		        map[key] = value;
		      }
		    });
		    return map;
		  }

		});

	</script>
</html>