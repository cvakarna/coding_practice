<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration page</title>
<link rel="stylesheet" type="text/css" href="mystyle.css"></link>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script>
</head>
<script type="text/javascript" src="controller.js"></script>

<script type="text/javascript" src="validate.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28//angular-route.min.js"></script>

<body ng-controller="registerController">

	<form method="get">
		<div class="container-fluid row">
			<div id="head" class=" col-lg-12  ">
				<div id="logo" class="col-lg-2 col-sm-4 col-xs-12">
					<img src="logo.png">
				</div>
				<div id="title" class="col-lg-2 col-sm-4 col-xs-12" class="form-group">
					<label>Registration Form</label>
				</div>
			</div>
	<div id="resultMessage">{{resultMessage}}</div>
			<div id="body" class="col-lg-12 well">

				<div class="col-lg-12">
					<fieldset  class="scheduler-border">
	<legend  class="scheduler-border">Personal Details</legend>
	<div class="row">
		<div class="col-sm-12">
			<div class="col-sm-2 form-group">
				<label>Registration Number</label>
			</div>
			<div class="col-sm-2 form-group ">
				<input type="text" class="form-control " value="{{registerID}}"
					disabled="disabled">
			</div>
			<div class="col-sm-4 form-group ">
				<a href="" class="btn btn-info" ng-click="generateID()">Generate</a>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="col-sm-2 form-group">
				<label>First Name</label>
			</div>
			<div class="col-sm-2 form-group">

				<input id="fn" type="text" ng-model="userDetail.firstName"
					class="form-control" onchange="checkfn()" required="required">
			</div>
			<div class="col-sm-2 form-group">
				<span id="fnameError"></span>
			</div>
			<div class="col-sm-2 form-group">
				<label>Last Name</label>
			</div>
			<div class="col-sm-2 form-group">

				<input type="text" ng-model="userDetail.lastName"
					class="form-control">
			</div>
			<div class="col-sm-2 form-group">
				<span></span>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="col-sm-2 form-group">
				<label>Middle Name</label>
			</div>
			<div class="col-sm-2 form-group">

				<input type="text" ng-model="userDetail.middleName"
					class="form-control">
			</div>
			<div class="col-sm-2 form-group">
				<span></span>
			</div>
			<div class="col-sm-2 form-group">
				<label>Date of Birth</label>
			</div>
			<div class="col-sm-2 form-group">

				<input onchange="checkDate()" type="text" placeholder="DD/MM//YYYY"
					class="form-control" id="dob" required="required"
					ng-model="userDetail.dob">
			</div>
			<div class="col-sm-2 form-group">
				<span id="dateError"></span>
			</div>
		</div>

		<div class="col-sm-12">
			<div class="col-sm-2 form-group">
				<label>Unique Id</label>
			</div>
			<div class="col-sm-2 form-group">
				<input type="text" class="form-control"
					ng-model="userDetail.uniqueId" ng-init="generateUUID()"
					required="required">
			</div>
			<div class="col-sm-2 form-group">
				<span id="dateError"></span>
			</div>
			<div class="col-sm-2 form-group">
				<label>PAN Number</label>
			</div>
			<div class="col-sm-2 form-group">
				<input type="text" id="panId" class="form-control"
					ng-model="userDetail.panNumber" onchange="verifyPanId()"
					required="required">
			</div>
			<div class="col-sm-2 form-group">
				<span id="panError"></span>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="col-sm-2 form-group">
				<label>Gender</label>
			</div>
			<div class="col-sm-2 radio form-group">
				<label><input type="radio" name="gender"
					ng-model="userDetail.gender" value="Male">Male</label> <label><input
					type="radio" name="gender" ng-model="userDetail.gender"
					value="Female">Female</label>
			</div>
			<div class="col-sm-2 form-group">
				<span></span>
			</div>
			<div class="col-sm-2 form-group">
				<label>Marital Status</label>
			</div>
			<div class="col-sm-2 form-group">
				<select class="form-control" ng-model="userDetail.maritalStatus">
					<option class="form-control" value="Single">Single</option>
					<option class="form-control" value="Married">Married</option>
					<option class="form-control" value="Divorced">Divorced</option>
					<option class="form-control" value="Separated">Separated</option>
					<option class="form-control" value="Widowed">Widowed</option>
				</select>
			</div>

		</div>
		<div class="col-sm-12">
			<div class="col-sm-2 form-group">
				<label>Communication Address</label>
			</div>
			<div class="col-sm-8 form-group">
				<textarea class="form-control"
					ng-model="userDetail.communicationAddress" required="required"
					rows="3"></textarea>
			</div>
			<div class="col-sm-2 form-group">
				<span id="dateError"></span>
			</div>
		</div>

		<div class="col-sm-12">
			<div class="col-sm-2"></div>
			<div class=" col-sm-9 checkbox checkbox-primary"">
				<input type="checkbox" style="width: 50px"
					ng-model="account.sameAsAbove"> <label>Same as
					Communication Address</label>
			</div>
			<div class="col-sm-2 form-group">
				<span id="dateError"></span>
			</div>
		</div>

		<div class="col-sm-12">
			<div class="col-sm-2 form-group">
				<label>Permanent Address</label>
			</div>

			<div ng-if="account.sameAsAbove" class="col-sm-8 form-group">
				<textarea ng-disabled="account.sameAsAbove"
					ng-model="userDetail.communicationAddress" rows="3"
					class="form-control"></textarea>
			</div>
			<div ng-if="!account.sameAsAbove" class="col-sm-8 form-group">
				<textarea ng-model="permanentAddress" rows="3" class="form-control"></textarea>
			</div>
		</div>



	</div>
</fieldset>
</div>


<div id="bottom" class=" col-lg-12">
	<fieldset class="scheduler-border">
		<legend class="scheduler-border">Educational Details</legend>
		<div class="col-sm-12">
			<div class="col-sm-3 form-group">
				<label>Course</label>
			</div>
			<div class="col-sm-3 form-group">
				<label>University/College</label>
			</div>
			<div class="col-sm-3 form-group">
				<label>Year of pass</label>
			</div>
			<div class="col-sm-2 form-group">
				<label>Percentage</label>
			</div>
			<button type="button" ng-click="add()" class="btn btn-success">
				<span class="glyphicon glyphicon-plus"></span> Add
			</button>
		</div>
		<div class="col-sm-12" ng-repeat="item in items">

			<div class="col-sm-2 form-group">
				<input type="text" class="form-control"
					ng-model=items[$index].course>
			</div>
			<div class="col-sm-4 form-group">
				<input type="text" class="form-control"
					ng-model=items[$index].college>
			</div>
			<div class="col-sm-3 form-group">
				<input type="text" class="form-control"
					ng-model=items[$index].yearOfPass>
			</div>
			<div class="col-sm-1 form-group">
				<input type="text" class="form-control"
					ng-model=items[$index].percentage>
			</div>
			<div class="col-sm-1 form-group"></div>
			<div class="col-sm-1 form-group">
				<button ng-click="remove($index)" class="btn btn-danger">
					<span class="glyphicon glyphicon-trash"></span>
				</button>
			</div>


		</div>
	</fieldset>
					</div>
					<div class="col-sm-2 col-xs-3  col-md-2	 col-lg-1">
						<button ng-disabled="form.$invalid" class="btn btn-primary">
							<span class=" glyphicon " ng-click="collectData()">Submit</span>
						</button>
					</div>

					<div class=" col-sm-2 col-xs-3 col-md-2 col-lg-1">
						<button ng-click="reloadPage()" class="btn btn-primary">
							<span class="glyphicon glyphicon-refresh ">Refresh</span>
						</button>
					</div>

				</div>

			</div>

	</form>
</body>

</html>

