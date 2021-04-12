package org.litzy.rodriguez.model;

import java.time.LocalDate;

public class Solicitud {
	private Integer id;
	private LocalDate fecha; //fecha en que aplico para la oferta de trabajo
	private String comentarios; //información adicional
	private String archivo; //nombre del archivo(PDF, DOCX del C.V)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", fecha=" + fecha + ", comentarios=" + comentarios + ", archivo=" + archivo
				+ "]";
	}
}
