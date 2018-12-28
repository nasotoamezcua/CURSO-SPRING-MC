package com.mitocode.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "libreta")
public class Libreta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLibreta;
	
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="America/Mexico_City")
	private Date fecha;
	
	@OneToMany(mappedBy = "libreta", cascade = {CascadeType.ALL} , fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Nota> notas;

	public int getIdLibreta() {
		return idLibreta;
	}

	public void setIdLibreta(int idLibreta) {
		this.idLibreta = idLibreta;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
	

}
