package it.quix.experis.core.pseudo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.quix.framework.core.codegen.annotation.QgListColumnField;
import it.quix.framework.core.codegen.annotation.QgSearchField;
import it.quix.framework.core.converter.annotation.QcDateType;

@Table(name = "prestiti")
public class Prestiti {

	@Id
	@ManyToOne
	@JoinColumn
	@QgSearchField
	@QgListColumnField
	public Soggetti beneficiario;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "oggetto_prestato")
	@QgSearchField
	@QgListColumnField
	public Oggetti oggettoPrestato;
	
	@QcDateType
	@Temporal(TemporalType.DATE)
	@Column(name = "data_prestito", nullable = false)
	@QgSearchField
	@QgListColumnField
	public Date dataPrestito;
	
	@QcDateType
	@Temporal(TemporalType.DATE)
	@Column(name = "scadenza_prestito")
	@QgSearchField
	@QgListColumnField
	public Date scadenzaPrestito;
	
}
