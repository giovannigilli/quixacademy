<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="qs2" uri="/quix-strut2-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<form name="forms.soggettiListForm" novalidate>
	<div class="box box-framework">
		<div class="box-header with-border">
			<div class="qrow" style="margin: 1px 10px 10px 6px;display: inline-block;" ng-cloak>
				<label for="qt"  class="control-label text-yellow cursor" ng-click="filtriEspansi = !filtriEspansi">
					<span  class="fa fa-filter fa-lg collapse-plus text-framework">
						<i style="font-size: 12px;" ng-show="filtriEspansi != true" class="fa fa-lg fa-plus"></i>
						<i style="font-size: 12px;" ng-show="filtriEspansi == true" class="fa fa-lg fa-minus"></i>
					</span>
				</label>
			</div>
  			<h3 class="qh3 box-title">&nbsp;&nbsp;<s:text name="soggetti.search.title"/></h3>
		</div>
		<div class="box-body" ng-show="!filtriEspansi" ng-cloak>
			<span class="filterDiv" ng-if="scopeController.search.username != null && scopeController.search.username != ''">
				<s:text name="soggetti.search.username"/>: 
				<b>
					{{scopeController.search.username}}
				</b>
				&nbsp;&nbsp;<i class="fa fa-times-circle" style="cursor: pointer;" ng-click="removeFilter('username')"></i>
			</span>
			<span class="filterDiv" ng-if="scopeController.search.email != null && scopeController.search.email != ''">
				<s:text name="soggetti.search.email"/>: 
				<b>
					{{scopeController.search.email}}
				</b>
				&nbsp;&nbsp;<i class="fa fa-times-circle" style="cursor: pointer;" ng-click="removeFilter('email')"></i>
			</span>
			<span class="filterDiv" ng-if="scopeController.search.ragioneSociale != null && scopeController.search.ragioneSociale != ''">
				<s:text name="soggetti.search.ragioneSociale"/>: 
				<b>
					{{scopeController.search.ragioneSociale}}
				</b>
				&nbsp;&nbsp;<i class="fa fa-times-circle" style="cursor: pointer;" ng-click="removeFilter('ragioneSociale')"></i>
			</span>
			<span class="filterDiv" ng-if="scopeController.search.nome != null && scopeController.search.nome != ''">
				<s:text name="soggetti.search.nome"/>: 
				<b>
					{{scopeController.search.nome}}
				</b>
				&nbsp;&nbsp;<i class="fa fa-times-circle" style="cursor: pointer;" ng-click="removeFilter('nome')"></i>
			</span>
			<span class="filterDiv" ng-if="scopeController.search.cognome != null && scopeController.search.cognome != ''">
				<s:text name="soggetti.search.cognome"/>: 
				<b>
					{{scopeController.search.cognome}}
				</b>
				&nbsp;&nbsp;<i class="fa fa-times-circle" style="cursor: pointer;" ng-click="removeFilter('cognome')"></i>
			</span>
			<span class="filterDiv" ng-if="scopeController.search.immagine != null && scopeController.search.immagine != ''">
				<s:text name="soggetti.search.immagine"/>: 
				<b>
					{{scopeController.search.immagine}}
				</b>
				&nbsp;&nbsp;<i class="fa fa-times-circle" style="cursor: pointer;" ng-click="removeFilter('immagine')"></i>
			</span>
			<span class="filterDiv" ng-if="scopeController.search.dataUltimaModificaFrom != null && scopeController.search.dataUltimaModificaFrom != ''">
				<s:text name="soggetti.search.dataUltimaModificaFrom"/>: 
				<b>
					{{scopeController.search.dataUltimaModificaFrom | date:"<s:text name="format.date5" />"}}
				</b>
				&nbsp;&nbsp;<i class="fa fa-times-circle" style="cursor: pointer;" ng-click="removeFilter('dataUltimaModificaFrom')"></i>
			</span>
			<span class="filterDiv" ng-if="scopeController.search.dataUltimaModificaTo != null && scopeController.search.dataUltimaModificaTo != ''">
				<s:text name="soggetti.search.dataUltimaModificaTo"/>: 
				<b>
					{{scopeController.search.dataUltimaModificaTo | date:"<s:text name="format.date5" />"}}
				</b>
				&nbsp;&nbsp;<i class="fa fa-times-circle" style="cursor: pointer;" ng-click="removeFilter('dataUltimaModificaTo')"></i>
			</span>
		</div>
		<div class="box-body qfade " ng-show="filtriEspansi" ng-cloak>
			<div class="qrow">
				<div class="qcol-xs-12 qcol-sm-12 qcol-md-6" ng-class="{'qhas-error': forms.soggettiListForm.username.$invalid}">
					<label for="username"><s:text name="soggetti.search.username"/>:</label>
					<div>
						<input type="text" ng-model="scopeController.search.username" id="username" class="qform-control" />
						<div ng-messages="forms.soggettiListForm.username.$error" role="alert">
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
				<div class="qcol-xs-12 qcol-sm-12 qcol-md-6" ng-class="{'qhas-error': forms.soggettiListForm.email.$invalid}">
					<label for="email"><s:text name="soggetti.search.email"/>:</label>
					<div>
						<input type="text" ng-model="scopeController.search.email" id="email" class="qform-control" />
						<div ng-messages="forms.soggettiListForm.email.$error" role="alert">
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
			<div class="qrow">
				<div class="qcol-xs-12 qcol-sm-12 qcol-md-6" ng-class="{'qhas-error': forms.soggettiListForm.ragioneSociale.$invalid}">
					<label for="ragioneSociale"><s:text name="soggetti.search.ragioneSociale"/>:</label>
					<div>
						<input type="text" ng-model="scopeController.search.ragioneSociale" id="ragioneSociale" class="qform-control" />
						<div ng-messages="forms.soggettiListForm.ragioneSociale.$error" role="alert">
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
				<div class="qcol-xs-12 qcol-sm-12 qcol-md-6" ng-class="{'qhas-error': forms.soggettiListForm.nome.$invalid}">
					<label for="nome"><s:text name="soggetti.search.nome"/>:</label>
					<div>
						<input type="text" ng-model="scopeController.search.nome" id="nome" class="qform-control" />
						<div ng-messages="forms.soggettiListForm.nome.$error" role="alert">
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
			<div class="qrow">
				<div class="qcol-xs-12 qcol-sm-12 qcol-md-6" ng-class="{'qhas-error': forms.soggettiListForm.cognome.$invalid}">
					<label for="cognome"><s:text name="soggetti.search.cognome"/>:</label>
					<div>
						<input type="text" ng-model="scopeController.search.cognome" id="cognome" class="qform-control" />
						<div ng-messages="forms.soggettiListForm.cognome.$error" role="alert">
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
				<div class="qcol-xs-12 qcol-sm-12 qcol-md-6" ng-class="{'qhas-error': forms.soggettiListForm.immagine.$invalid}">
					<label for="immagine"><s:text name="soggetti.search.immagine"/>:</label>
					<div>
						<input type="text" ng-model="scopeController.search.immagine" id="immagine" class="qform-control" />
						<div ng-messages="forms.soggettiListForm.immagine.$error" role="alert">
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
			<div class="qrow">
				<div class="qcol-xs-6 qcol-sm-6 qcol-md-3" ng-class="{'qhas-error': forms.soggettiListForm.dataUltimaModificaFrom.$invalid}">
					<label for="dataUltimaModificaFrom"><s:text name="soggetti.search.dataUltimaModificaFrom"/>:</label>
					<div>

		              		<div class="qdropdown">
								<a class="qdropdown-toggle" id="dropdown2" role="qbutton" data-toggle="qdropdown" data-target="#" href="#">
									<div class="qinput-group">
							    		<input type="text" name="dataUltimaModificaFrom" id="dataUltimaModificaFrom" class="qform-control box-input-calendar" data-ng-model="scopeController.search.dataUltimaModificaFrom" presetDate="true" dateformat="DD/MM/YYYY">
							    		<span class="qinput-group-addon"><i class="fa fa-calendar"></i></span>
							    	</div>
							  	</a>
							  	<ul class="qdropdown-menu" role="qmenu" aria-labelledby="dLabel">
							    	<datetimepicker data-ng-model="scopeController.search.dataUltimaModificaFrom" data-datetimepicker-config="{ minView:'day', modelType: 'Date' }"/>
							  	</ul>
							</div>
						
		              	
						<div ng-messages="forms.soggettiListForm.dataUltimaModificaFrom.$error" role="alert">
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
				<div class="qcol-xs-6 qcol-sm-6 qcol-md-3" ng-class="{'qhas-error': forms.soggettiListForm.dataUltimaModificaTo.$invalid}">
					<label for="dataUltimaModificaTo"><s:text name="soggetti.search.dataUltimaModificaTo"/>:</label>
					<div>

		              		<div class="qdropdown">
								<a class="qdropdown-toggle" id="dropdown2" role="qbutton" data-toggle="qdropdown" data-target="#" href="#">
									<div class="qinput-group">
							    		<input type="text" name="dataUltimaModificaTo" id="dataUltimaModificaTo" class="qform-control box-input-calendar" data-ng-model="scopeController.search.dataUltimaModificaTo" presetDate="true" dateformat="DD/MM/YYYY">
							    		<span class="qinput-group-addon"><i class="fa fa-calendar"></i></span>
							    	</div>
							  	</a>
							  	<ul class="qdropdown-menu" role="qmenu" aria-labelledby="dLabel">
							    	<datetimepicker data-ng-model="scopeController.search.dataUltimaModificaTo" data-datetimepicker-config="{ minView:'day', modelType: 'Date' }"/>
							  	</ul>
							</div>
						
		              	
						<div ng-messages="forms.soggettiListForm.dataUltimaModificaTo.$error" role="alert">
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
		<div class="box-footer qtext-center" ng-show="filtriEspansi">
			<button ng-click="filtriEspansi = false;search();" class="qbtn btn-framework-color"><i class="fa fa-search"></i>&nbsp;<s:text name="button.search"/></button>
			<button ng-click="resetSearch()" class="qbtn btn-framework-color"><i class="fa fa-undo"></i>&nbsp;<s:text name="button.reset"/></button>
		</div>
	</div>
</form>

<div class="box box-framework" >
	<div class="box-body qtext-center" ng-if="!(scopeController.result.list!= null && scopeController.result.list.length>0)" >
		<div class="qpull-right" style="padding: 10px;" ng-hide="popup">
        	<button class="qbtn btn-framework-color" ng-click="create()" type="button"><i class="fa fa-plus-circle"></i>&nbsp;<s:text name="button.new" /></button>
		</div>
    	<s:text name="soggetti.list.noResults"></s:text>
   	</div>
	<div class="box-header" ng-if="scopeController.result.list!= null && scopeController.result.list.length>0" ng-cloak>
	  	<span><span class="qbadge bg-framework">{{ scopeController.result.count }}</span>&nbsp;<s:text name="soggetti.list.numRecord"/></span>
		<div class="qpull-right">
			<div class="qbtn-group" ng-hide="popup" ng-hide="popup">
                 <button class="qbtn btn-framework-color" ng-click="create()" type="button"><i class="fa fa-plus-circle"></i>&nbsp;<s:text name="button.new" /></button>
                 <button data-toggle="qdropdown" class="qbtn btn-framework-color qdropdown-toggle" type="button" aria-expanded="false">
                   <span class="qcaret"></span>
                   <span class="qsr-only"></span>
                 </button>
                 <ul role="qmenu" class="qdropdown-menu qdropdown-menu-right">
                   	<li ng-click="exportXLS()"><a><i class="fa fa-file-excel-o"></i>&nbsp;<s:text name="button.excel" /></a></li>
                 </ul>
          	</div>		
		</div>
	</div>
  	<div class="box-body" ng-if="scopeController.result.list!= null && scopeController.result.list.length>0" ng-cloak>
    	<table class="qtable qtable-hover">
			<thead>
				<tr>
					<th class="qtext-left"><s:text name="soggetti.list.username"/></th>
					<th class="qtext-left"><s:text name="soggetti.list.email"/></th>
					<th class="qtext-left"><s:text name="soggetti.list.ragioneSociale"/></th>
					<th class="qtext-left"><s:text name="soggetti.list.nome"/></th>
					<th class="qtext-left"><s:text name="soggetti.list.cognome"/></th>
					<th class="qtext-left"><s:text name="soggetti.list.immagine"/></th>
					<th class="qtext-center"><s:text name="soggetti.list.dataUltimaModifica"/></th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="row in scopeController.result.list">
					<td>{{ row.username }}</td>
					<td>{{ row.email }}</td>
					<td>{{ row.ragioneSociale }}</td>
					<td>{{ row.nome }}</td>
					<td>{{ row.cognome }}</td>
					<td>{{ row.immagine }}</td>
					<td class="qtext-center" nowrap="nowrap">{{ row.dataUltimaModifica  | date:"<s:text name="format.date3" />" }}</td>
					<td class="qtext-right">
						<div class="qbtn-group" ng-hide="popup">
		                  	<button class="qbtn btn-framework-color" ng-click="edit(row)" type="button"><i class="fa fa-pencil"></i>&nbsp;<s:text name="button.edit" /></button>
		                   	<button data-toggle="qdropdown" class="qbtn btn-framework-color qdropdown-toggle" type="button" aria-expanded="false">
		                       	<span class="qcaret"></span>
		                       	<span class="qsr-only"></span>
		                    </button>
		                    <ul role="qmenu" class="qdropdown-menu qdropdown-menu-right">
		                       	<li ng-click="delete(row)"><a><i class="fa fa-trash-o"></i>&nbsp;<s:text name="button.delete" /></a></li>
		                    </ul>
		              	</div>
		              	<div ng-show="popup">		 	
							<button class="qbtn btn-framework-color" ng-click="select(row)" type="button"><i class="fa fa-check-circle"></i>&nbsp;<s:text name="button.select" /></button>		 	
						</div>		
					</td>
				</tr>
			</tbody>
		</table>
		<div class="qtext-center">
			<pagination 
				ng-model="scopeController.search.page" 
				total-items="scopeController.result.count" 
				max-size="5" 
				direction-links="false" 
				boundary-links="true" 
				first-text="&lt;" 
				last-text="&gt;" 
				rotate="false" 
				ng-change="list()"
				style="margin: 0px;"
			/>
		</div>
		<div class="qtext-center" ng-show="popup">
			<button class="qbtn btn-framework-color" ng-click="close()" type="button"><i class="fa fa-undo"></i>&nbsp;<s:text name="button.close" /></button>		 	
		</div>	
	</div>
</div>					
				
