package es.studium.PSP_T2_P2_FRM;

public class Equipos 
{
	public int id;
	public String nombre;
	public int puntos, jugados, ganados, perdidos,empatados, favor, contra;

	public Equipos(int id, String nombre,  int puntos, int jugados, int ganados, int perdidos,  int empatados, int favor,  int contra) 
	{
		this.id = id;
		this.nombre = nombre;
		this.puntos = puntos;
		this.jugados = jugados;
		this.ganados = ganados;
		this.perdidos = perdidos;
		this.empatados = empatados;
		this.favor = favor;
		this.contra = contra;
	} 
	public Equipos(int id, String nombre)
	{
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() 
	{
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getJugados() {
		return jugados;
	}

	public void setJugados(int jugados) {
		this.jugados = jugados;
	}

	public int getGanados() {
		return ganados;
	}

	public void setGanados(int ganados) {
		this.ganados = ganados;
	}

	public int getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(int perdidos) {
		this.perdidos = perdidos;
	}

	public int getEmpatados() {
		return empatados;
	}

	public void setEmpatados(int empatados) {
		this.empatados = empatados;
	}

	public int getFavor() {
		return favor;
	}

	public void setFavor(int favor) {
		this.favor = favor;
	}

	public int getContra() {
		return contra;
	}

	public void setContra(int contra) {
		this.contra = contra;
	}

}
