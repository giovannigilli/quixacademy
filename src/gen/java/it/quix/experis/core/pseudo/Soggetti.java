package it.quix.experis.core.pseudo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.quix.framework.core.codegen.annotation.QgListColumnField;
import it.quix.framework.core.codegen.annotation.QgSearchField;
import it.quix.framework.core.converter.annotation.QcDateTimeType;

@Table(name = "soggetti")
public class Soggetti {

	@Id
	@Column(length = 50, nullable = false)
	@QgSearchField
	@QgListColumnField
	public String username;
	
	@Column(length = 50, nullable = false)
	@QgSearchField
	@QgListColumnField
	public String email;
	
	@Column(name="ragione_sociale", length = 255)
	@QgSearchField
	@QgListColumnField
	public String ragioneSociale;
	
	@Column(length = 50)
	@QgSearchField
	@QgListColumnField
	public String nome;
	
	@Column(length = 50)
	@QgSearchField
	@QgListColumnField
	public String cognome;
	
	@Column(length = 255)
	@QgSearchField
	@QgListColumnField
	public String immagine;
	
	@QcDateTimeType
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ultima_modifica", nullable = false)
	@QgSearchField
	@QgListColumnField
	public Date dataUltimaModifica;
	
	@OneToMany(mappedBy = "proprietario")
	public Set<Oggetti> oggetti;
	
	@OneToMany(mappedBy = "beneficiario")
	public Set<Prestiti> prestiti;
	
}
