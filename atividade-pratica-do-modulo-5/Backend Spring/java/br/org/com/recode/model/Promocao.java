package br.org.com.recode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "promocao")
public class Promocao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String destino;
	private String data_ida;
	private String horario_ida;
	private String data_volta;
	private String horario_volta;
	private String cia_aerea;
	private String hotel;
	private String observacoes;
	private double valor;
	private double valor_promocional;
	
	public Promocao() {
		
	}
	
	public Promocao(long id, String destino, String data_ida, String horario_ida, String data_volta, String horario_volta, String cia_aerea, String hotel, String observacoes, double valor, double valor_promocional) {
		super();
		this.id = id;
		this.destino = destino;
		this.data_ida = data_ida;
		this.horario_ida = horario_ida;
		this.data_volta = data_volta;
		this.horario_volta = horario_volta;
		this.cia_aerea = cia_aerea;
		this.hotel = hotel;
		this.observacoes = observacoes;
		this.valor = valor;
		this.valor_promocional = valor_promocional;
	}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getData_ida() {
		return data_ida;
	}
	public void setData_ida(String data_ida) {
		this.data_ida = data_ida;
	}
	public String getHorario_ida() {
		return horario_ida;
	}
	public void setHorario_ida(String horario_ida) {
		this.horario_ida = horario_ida;
	}
	public String getData_volta() {
		return data_volta;
	}
	public void setData_volta(String data_volta) {
		this.data_volta = data_volta;
	}
	public String getHorario_volta() {
		return horario_volta;
	}
	public void setHorario_volta(String horario_volta) {
		this.horario_volta = horario_volta;
	}
	public String getCia_aerea() {
		return cia_aerea;
	}
	public void setCia_aerea(String cia_aerea) {
		this.cia_aerea = cia_aerea;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValor_promocional() {
		return valor_promocional;
	}
	public void setValor_promocional(double valor_promocional) {
		this.valor_promocional = valor_promocional;
	}
	
}