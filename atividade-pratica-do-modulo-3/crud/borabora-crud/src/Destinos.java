
public class Destinos {
	
	private int id_destino;
	private int id_admin;
	private String destino;
	private String data_ida;
	private String horario_ida;
	private String data_volta;
	private String horario_volta;
	private String cia_aerea;
	private String hotel;
	private String observacoes;
	private double valor;
	
	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
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
}