<%@ page language="java" contentType="text/html; charset=UTF-16" pageEncoding="UTF-16"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Employee login</title>
		<meta charset="UTF-16">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" type="text/css"/>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/additional-methods.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js" ></script>
	  	  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.slim.min.js" ></script>
	</head>
	<body>
		<spring:message code="login.placeholder.username" var="login.placeholder.username" /> 
		<spring:message code="login.placeholder.password" var="login.placeholder.password" />
		<spring:message code="reg.msg.rule.password1" var="reg.msg.rule.password1" />
		<spring:message code="reg.msg.rule.username" var="reg.msg.rule.username" />
		
		
		<spring:message code="login.msg.req.username" var="login.msg.req.username" /> 
		<spring:message code="login.msg.req.password" var="login.msg.req.password" />
		
				
			 <div class="container-fluid">
			 	<div class="row">
			    	<div class="col-md-4 dropdown">
					  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
						  Select Language
					  </button>
					  <div class="dropdown-menu">
					    <a class="dropdown-item" href="?language=en"><spring:message code="link.translate.english" text="English" /></a>
					    <a class="dropdown-item" href="?language=bn"><spring:message code="link.translate.bengali" text="বাংলা" /></a>
					    <a class="dropdown-item" href="?language=hi"><spring:message code="link.translate.hindi" text="हिंदी" /></a>
					  </div>
				    </div>
				    <div class="col-md-offset-4"></div>
				    <div class="dropdown col-md-4">
					  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
						  Select Theme
					  </button>
					  <div class="dropdown-menu">
					    <a  class="dropdown-item" href="?theme=cerulean"><spring:message code="link.theme.cerulean" text="cerulean" /></a>
					    <a  class="dropdown-item" href="?theme=Darkly"><spring:message code="link.theme.Darkly" text="Darkly" /></a>
					    <a  class="dropdown-item" href="Lumen"><spring:message code="link.theme.Lumen" text="Lumen" /></a>
					  </div>
				    </div>
			   	</div>
			  <form role="form" id="myForm" action="#" enctype="application/json">
				<div class="form-group">
				  <label for="#username" class="col-lg-4 d-none d-sm-block"><b><spring:message code="login.label.username" text="username:" /></b></label>
				  <input type="text" id="first" class="form-control col-lg-4 col-sm-12 col-xs-12 has-error" name="username" placeholder="${ login.placeholder.username}" data-msg-required="${login.msg.req.username}" data-rule-required="true"  data-msg-usrnregex="${reg.msg.rule.username}" />
				</div>
				<div class="form-group">
				  <label for="#password" class="col-lg-4 d-none d-sm-block"><b><spring:message code="login.label.password" text="password:" /></b></label>
				  <input type="password" id="password" class="form-control col-lg-4 col-sm-12 col-xs-12 has-error" name="password" data-msg-required="${login.msg.req.password1}"  placeholder="${login.placeholder.password}"  data-rule-required="true" data-msg-pwdregex="${reg.msg.rule.password1}" />
				</div>
				<button id="btn" type="button" class="btn btn-primary" onclick="location.href='Login'"><spring:message code="login.label.button" text="Login" /></button>
				
							<c:if test="${newUser}">
								User name doesn't exist. Want to <a href="location.href='signup'">Sign Up</a>?<br/>
								<b>You have number of try-outs: "${tryouts}"<br>Otherwise your account will be Locked.</b>
								
							</c:if>
			  </form>
				  <hr/>
				  <b>Or signed in with:</b>
			<a href="/login"><button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Facebook</button></a>
			<a href="/login"><button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Google</button></a>
			<a href="/login"><button class="btn btn-lg btn-github btn-block text-uppercase" type="submit"><i class="fab fa-github mr-2"></i> Github</button></a>
				
	</div> 
	</body>
	<style>
		:root {
		  --input-padding-x: 1.5rem;
		  --input-padding-y: .75rem;
		}

		.card-signin {
		  border: 0;
		  border-radius: 1rem;
		  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
		}

		.card-signin .card-title {
		  margin-bottom: 2rem;
		  font-weight: 300;
		  font-size: 1.5rem;
		}

		.card-signin .card-body {
		  padding: 2rem;
		}

		.form-signin {
		  width: 100%;
		}

		.form-signin .btn {
		  font-size: 80%;
		  border-radius: 5rem;
		  letter-spacing: .1rem;
		  font-weight: bold;
		  padding: 1rem;
		  transition: all 0.2s;
		}

		.form-label-group {
		  position: relative;
		  margin-bottom: 1rem;
		}

		.form-label-group input {
		  height: auto;
		  border-radius: 2rem;
		}

		.form-label-group>input,
		.form-label-group>label {
		  padding: var(--input-padding-y) var(--input-padding-x);
		}

		.form-label-group>label {
		  position: absolute;
		  top: 0;
		  left: 0;
		  display: block;
		  width: 100%;
		  margin-bottom: 0;
		  /* Override default `<label>` margin */
		  line-height: 1.5;
		  color: #495057;
		  border: 1px solid transparent;
		  border-radius: .25rem;
		  transition: all .1s ease-in-out;
		}

		.form-label-group input::-webkit-input-placeholder {
		  color: transparent;
		}

		.form-label-group input:-ms-input-placeholder {
		  color: transparent;
		}

		.form-label-group input::-ms-input-placeholder {
		  color: transparent;
		}

		.form-label-group input::-moz-placeholder {
		  color: transparent;
		}

		.form-label-group input::placeholder {
		  color: transparent;
		}

		.form-label-group input:not(:placeholder-shown) {
		  padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
		  padding-bottom: calc(var(--input-padding-y) / 3);
		}

		.form-label-group input:not(:placeholder-shown)~label {
		  padding-top: calc(var(--input-padding-y) / 3);
		  padding-bottom: calc(var(--input-padding-y) / 3);
		  font-size: 12px;
		  color: #777;
		}

		.btn-google {
		  color: white;
		  background-color: #ea4335;
		}

		.btn-facebook {
		  color: white;
		  background-color: #3b5998;
		}
		
		.btn-github {
		  color: white;
		  background-color: #000000;
		}


		@supports (-ms-ime-align: auto) {
		  .form-label-group>label {
			display: none;
		  }
		  .form-label-group input::-ms-input-placeholder {
			color: #777;
		  }
		}

		@media all and (-ms-high-contrast: none),
		(-ms-high-contrast: active) {
		  .form-label-group>label {
			display: none;
		  }
		  .form-label-group input:-ms-input-placeholder {
			color: #777;
		  }
		}
		
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
	<script>
		$(document).ready(function() {

			$('input').on('blur', function() {
			    if ($("#myform").valid()) {
			        $('#submit').prop('disabled', false);  
			    } else {
			        $('#submit').prop('disabled', 'disabled');
			    }
			});
			
		  $("#myForm").validate({});
			
		    var map = {};
		
		    $.validator.setDefaults({
				highlight: function ( element, errorClass, validClass ) {
							$( element ).addClass( "is-invalid" ).removeClass( "is-valid" );
						},
				unhighlight:function ( element, errorClass, validClass ) {
							$( element ).addClass( "is-valid" ).removeClass( "is-invalid" );
						},
				errorElement: 'em',
				errorClass: 'help-block',
				errorPlacement: function(error, element) {
				  error.addClass( "invalid-feedback" );
				}
		
		    });
		    
		    $.validator.addMethod("usrnregex", function(value, element) {
				return this.optional(element) || /^[a-zA-Z0-9_]{5,}[a-zA-Z]+[0-9]*$/i.test(value);
		    }, " at least five alphanumerics,one letter,zero or more digit and the underscore");
		
		    $.validator.addMethod("pwdregex", function(value, element) {
				return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
		    }, "Passwords are 8-16 characters with uppercase letters, lowercase letters and at least one number.");
		  
		    $("#myForm").submit(function(e) {
				e.preventDefault();
				if ($("#myForm").valid()) {
				    $.ajax({
						type: 'post',
						url: "addEmployee",
						data: alert(JSON.stringify(createMap())),
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
					var value = $(this).val();
					map[key] = value;
				  }
				});
				return map;
			}
		
		});
	</script>
</html>