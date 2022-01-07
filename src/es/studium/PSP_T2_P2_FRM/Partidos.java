package es.studium.PSP_T2_P2_FRM;

public class Partidos extends Thread
{
	public int id;
	public Equipos local;
	public Equipos visitante;
	public String resultado;    
	public Partidos(String nombre) 
	{
		super(nombre);
	}
	public void run()
	{
		int golesLocal =(int) (Math.random() * (6)) + (10/getLocal().getId());
		int golesVisitante =(int) (Math.random() * (6) + (10/getVisitante().getId()));
		
		getLocal().setJugados(getLocal().getJugados()+ 1);
		getVisitante().setJugados(getVisitante().getJugados()+ 1);
		
		getLocal().setFavor(getLocal().getFavor() + golesLocal);
		getVisitante().setFavor(getVisitante().getFavor() + golesVisitante);
		
		
		getLocal().setContra(getLocal().getContra() + golesVisitante);
		getVisitante().setContra(getVisitante().getContra() + golesLocal);
		
		if(golesLocal==golesVisitante) 
		{
			getLocal().setEmpatados(getLocal().getEmpatados()+ 1);
			getVisitante().setEmpatados(getVisitante().getEmpatados()+ 1);
			
			getLocal().setPuntos(getLocal().getPuntos()+1);
			getVisitante().setPuntos(getVisitante().getPuntos()+1);
		}
		else if(golesLocal>golesVisitante) 
		{
			getLocal().setGanados(getLocal().getGanados()+ 1);
			getVisitante().setPerdidos(getVisitante().getPerdidos()+ 1);
			getLocal().setPuntos(getLocal().getPuntos()+3);
		}
		else if(golesLocal<golesVisitante) 
		{
			getLocal().setPerdidos(getLocal().getPerdidos()+ 1);
			getVisitante().setGanados(getVisitante().getGanados()+ 1);
			getVisitante().setPuntos(getVisitante().getPuntos()+3);
		}
		System.out.println("Finaliza "+getLocal().getNombre()+ ": " + golesLocal+ "-"+getVisitante().getNombre()+ ": " + golesVisitante);
	
	}
	public Partidos(int id, Equipos l, Equipos v, String r) 
	{
		this.id = id;
		this.local = l;
		this.visitante = v;
		this.resultado = r;
	}  
	public Partidos(int id, Equipos l, Equipos v) 
	{
		this.id = id;
		this.local = l;
		this.visitante = v;
	}
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipos getLocal() {
		return local;
	}

	public void setLocal(Equipos local) {
		this.local = local;
	}

	public Equipos getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipos visitante) {
		this.visitante = visitante;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
