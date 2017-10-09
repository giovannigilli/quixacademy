package it.quix.experis.core.pseudo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.quix.framework.core.codegen.annotation.QgListColumnField;
import it.quix.framework.core.codegen.annotation.QgSearchField;
import it.quix.framework.core.converter.annotation.QcDateTimeType;

@Table(name = "oggetti")
public class Oggetti {

	@Id
	@Column(nullable = false)
	public Integer id;
	
	@ManyToOne
	@JoinColumn(name = "proprietario")
	@QgSearchField
	@QgListColumnField
	public Soggetti proprietario;
	
	@Column(length = 255)
	@QgSearchField
	@QgListColumnField
	public String titolo;
	
	@Lob
	@Column
	@QgSearchField
	@QgListColumnField
	public String descrizione;
	
	@Column(length = 255)
	@QgListColumnField
	public String immagine;
	
	@Column(length = 255)
	@QgSearchField
	@QgListColumnField
	public String categoria;
	
	@QcDateTimeType
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ultima_modifica", nullable = false)
	@QgSearchField
	@QgListColumnField
	public Date dataUltimaModifica;
	
	@OneToOne(mappedBy = "oggettoPrestato")
	public Prestiti prestito;
}
