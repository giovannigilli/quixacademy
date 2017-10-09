<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="qs2" uri="/quix-strut2-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<form name="forms.prestitiEditForm" novalidate>
	<div class="box box-framework" >
		<div class="box-header with-border">
			<h3 class="qh3 box-title"><s:text name="prestiti.edit.title"/></h3>
		</div>
		<div class="box-body">
			<div class="qrow">		
				<div class="qcol-md-6 qcol-sm-6 qcol-xs-12" ng-class="{'qhas-error': forms.prestitiEditForm.beneficiario.$invalid}">
					<label for="beneficiario"><s:text name="prestiti.edit.beneficiario"/></label>
					<input type="text" 
						ng-model="scopeController.selectedRow.beneficiario" 
						id="beneficiario" 
						name="beneficiario"
						class="qform-control" />
					<div ng-messages="forms.prestitiEditForm.beneficiario.$error" role="alert">
					  	<div ng-message="notNull"><s:text name="error.notNull"/></div>
					  	<div ng-message="invalidAK"><s:text name="error.invalidAK"/></div>
					  	<div ng-message="notValid"><s:text name="error.notValid"/></div>
					  	<div ng-message="lenght"><s:text name="error.lenght"/></div>
					  	<div ng-message="dateToBeforeDateFrom"><s:text name="error.dateToBeforeDateFrom"/></div>
					  	<div ng-message="fieldToBeforeFieldFrom"><s:text name="error.fieldToBeforeFieldFrom"/></div>
					  	<div ng-message="notUnique"><s:text name="error.notUnique"/></div>
					  	<div ng-message="min"><s:text name="error.min"/></div>
					  	<div ng-message="max"><s:text name="error.max"/></div>
					  	<div ng-message="ognl"><s:text name="error.ognl"/></div>
					  	<div ng-message="pattern"><s:text name="error.pattern"/></div>
					  	<div ng-message="notBlank"><s:text name="error.notBlank"/></div>
					  	<div ng-message="qvpattern.message"><s:text name="error.qvpattern.message"/></div>
					  	<div ng-message="string.length"><s:text name="error.string.length"/></div>
					</div>
				</div>		
				<div class="qcol-md-6 qcol-sm-6 qcol-xs-12" ng-class="{'qhas-error': forms.prestitiEditForm.oggettoPrestato.$invalid}">
					<label for="oggettoPrestato"><s:text name="prestiti.edit.oggettoPrestato"/></label>
					<input type="text" 
						ng-model="scopeController.selectedRow.oggettoPrestato" 
						id="oggettoPrestato" 
						name="oggettoPrestato"
						class="qform-control" />
					<div ng-messages="forms.prestitiEditForm.oggettoPrestato.$error" role="alert">
					  	<div ng-message="notNull"><s:text name="error.notNull"/></div>
					  	<div ng-message="invalidAK"><s:text name="error.invalidAK"/></div>
					  	<div ng-message="notValid"><s:text name="error.notValid"/></div>
					  	<div ng-message="lenght"><s:text name="error.lenght"/></div>
					  	<div ng-message="dateToBeforeDateFrom"><s:text name="error.dateToBeforeDateFrom"/></div>
					  	<div ng-message="fieldToBeforeFieldFrom"><s:text name="error.fieldToBeforeFieldFrom"/></div>
					  	<div ng-message="notUnique"><s:text name="error.notUnique"/></div>
					  	<div ng-message="min"><s:text name="error.min"/></div>
					  	<div ng-message="max"><s:text name="error.max"/></div>
					  	<div ng-message="ognl"><s:text name="error.ognl"/></div>
					  	<div ng-message="pattern"><s:text name="error.pattern"/></div>
					  	<div ng-message="notBlank"><s:text name="error.notBlank"/></div>
					  	<div ng-message="qvpattern.message"><s:text name="error.qvpattern.message"/></div>
					  	<div ng-message="string.length"><s:text name="error.string.length"/></div>
					</div>
				</div>
			</div>
			<div class="qrow">		
				<div class="qcol-md-6 qcol-sm-6 qcol-xs-12" ng-class="{'qhas-error': forms.prestitiEditForm.dataPrestito.$invalid}">
					<label for="dataPrestito"><s:text name="prestiti.edit.dataPrestito"/>*</label>
						<div class="qdropdown">
							<a class="qdropdown-toggle" id="dropdown2" role="qbutton" data-toggle="qdropdown" data-target="#" href="#">
								<div class="qinput-group">
						    		<input type="text" name="dataPrestito" id="dataPrestito" class="qform-control box-input-calendar" data-ng-model="scopeController.selectedRow.dataPrestito" presetDate="true" dateformat="DD/MM/YYYY">
						    		<span class="qinput-group-addon"><i class="fa fa-calendar"></i></span>
						    	</div>
						  	</a>
						  	<ul class="qdropdown-menu" role="qmenu" aria-labelledby="dLabel">
						    	<datetimepicker data-ng-model="scopeController.selectedRow.dataPrestito" data-datetimepicker-config="{ minView:'day', modelType: 'Date' }"/>
						  	</ul>
						</div>
					
					<div ng-messages="forms.prestitiEditForm.dataPrestito.$error" role="alert">
					  	<div ng-message="notNull"><s:text name="error.notNull"/></div>
					  	<div ng-message="invalidAK"><s:text name="error.invalidAK"/></div>
					  	<div ng-message="notValid"><s:text name="error.notValid"/></div>
					  	<div ng-message="lenght"><s:text name="error.lenght"/></div>
					  	<div ng-message="dateToBeforeDateFrom"><s:text name="error.dateToBeforeDateFrom"/></div>
					  	<div ng-message="fieldToBeforeFieldFrom"><s:text name="error.fieldToBeforeFieldFrom"/></div>
					  	<div ng-message="notUnique"><s:text name="error.notUnique"/></div>
					  	<div ng-message="min"><s:text name="error.min"/></div>
					  	<div ng-message="max"><s:text name="error.max"/></div>
					  	<div ng-message="ognl"><s:text name="error.ognl"/></div>
					  	<div ng-message="pattern"><s:text name="error.pattern"/></div>
					  	<div ng-message="notBlank"><s:text name="error.notBlank"/></div>
					  	<div ng-message="qvpattern.message"><s:text name="error.qvpattern.message"/></div>
					  	<div ng-message="string.length"><s:text name="error.string.length"/></div>
					</div>
				</div>		
				<div class="qcol-md-6 qcol-sm-6 qcol-xs-12" ng-class="{'qhas-error': forms.prestitiEditForm.scadenzaPrestito.$invalid}">
					<label for="scadenzaPrestito"><s:text name="prestiti.edit.scadenzaPrestito"/></label>
						<div class="qdropdown">
							<a class="qdropdown-toggle" id="dropdown2" role="qbutton" data-toggle="qdropdown" data-target="#" href="#">
								<div class="qinput-group">
						    		<input type="text" name="scadenzaPrestito" id="scadenzaPrestito" class="qform-control box-input-calendar" data-ng-model="scopeController.selectedRow.scadenzaPrestito" presetDate="true" dateformat="DD/MM/YYYY">
						    		<span class="qinput-group-addon"><i class="fa fa-calendar"></i></span>
						    	</div>
						  	</a>
						  	<ul class="qdropdown-menu" role="qmenu" aria-labelledby="dLabel">
						    	<datetimepicker data-ng-model="scopeController.selectedRow.scadenzaPrestito" data-datetimepicker-config="{ minView:'day', modelType: 'Date' }"/>
						  	</ul>
						</div>
					
					<div ng-messages="forms.prestitiEditForm.scadenzaPrestito.$error" role="alert">
					  	<div ng-message="notNull"><s:text name="error.notNull"/></div>
					  	<div ng-message="invalidAK"><s:text name="error.invalidAK"/></div>
					  	<div ng-message="notValid"><s:text name="error.notValid"/></div>
					  	<div ng-message="lenght"><s:text name="error.lenght"/></div>
					  	<div ng-message="dateToBeforeDateFrom"><s:text name="error.dateToBeforeDateFrom"/></div>
					  	<div ng-message="fieldToBeforeFieldFrom"><s:text name="error.fieldToBeforeFieldFrom"/></div>
					  	<div ng-message="notUnique"><s:text name="error.notUnique"/></div>
					  	<div ng-message="min"><s:text name="error.min"/></div>
					  	<div ng-message="max"><s:text name="error.max"/></div>
					  	<div ng-message="ognl"><s:text name="error.ognl"/></div>
					  	<div ng-message="pattern"><s:text name="error.pattern"/></div>
					  	<div ng-message="notBlank"><s:text name="error.notBlank"/></div>
					  	<div ng-message="qvpattern.message"><s:text name="error.qvpattern.message"/></div>
					  	<div ng-message="string.length"><s:text name="error.string.length"/></div>
					</div>
				</div>
			</div>
		</div>
		<div class="box-footer qtext-center">
			<button ng-click="save()" class="qbtn btn-framework-color"><i class="fa fa-floppy-o"></i>&nbsp;<s:text name="button.save"/></button>
			<button ng-click="back()" class="qbtn btn-framework-color"><i class="fa fa-arrow-circle-left"></i>&nbsp;<s:text name="button.back"/></button>
		</div>
	</div>
</form>