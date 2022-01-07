package es.studium.PSP_T2_P2_FRM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Test
{
	static String [] jornada1 = {"20-1", "2-19", "3-18", "4-17", "5-16", "6-15", "7-14", "8-13", "9-12", "10-11"};
	static	String [] jornada2 = {"11-20", "12-10", "13-9", "14-8", "15-7", "16-6", "17-5", "18-4", "19-3", "1-2"};
	static	String [] jornada3 = {"20-2", "3-1", "4-19", "5-18", "6-17", "7-16", "8-15", "9-14", "10-13", "11-12"};
	static	String [] jornada4 = {"12-20", "13-11", "14-10", "15-9", "16-8", "17-7", "18-6", "19-5", "1-4", "2-3"};
	static	String [] jornada5 = {"20-3", "4-2", "5-1", "6-19", "7-18", "8-17", "9-16", "10-15", "11-14", "12-13"};
	static	String [] jornada6 = {"13-20", "14-12", "15-11", "16-10", "17-9", "18-8", "19-7", "1-6", "2-5", "3-4"};
	static	String [] jornada7 = {"20-4", "5-3", "6-2", "7-1", "8-19", "9-18", "10-17", "11-16", "12-15", "13-14"}; 
	static	String [] jornada8 = {"14-20", "15-13", "16-12", "17-11", "18-10", "19-9", "1-8", "2-7", "3-6", "4-5"};
	static	String [] jornada9 = {"20-5", "6-4", "7-3", "8-2", "9-1", "10-19", "11-18", "12-17","13-16", "14-15"};
	static	String [] jornada10 = {"15-20" , "16-14" , "17-13" , "18-12",  "19-11" ,"1-10" ,"2-9", "3-8", "4-7" , "5-6"};
	static String [] jornada11 = {"20-6" , "7-5", "8-4",  "9-3" , "10-2" , "11-1" , "12-19",  "13-18" , "14-17", "15-16"};
	static	String [] jornada12 = {"16-20" , "17-15",  "18-14",  "19-13",  "1-12" , "2-11",  "3-10" , "4-9",  "5-8",  "6-7"};
	static	String [] jornada13 = {"20-7" , "8-6" , "9-5", "10-4",  "11-3",  "12-2", "13-1", "14-19",  "15-18" , "16-17"};
	static	String [] jornada14 = {"17-20" , "18-16", "19-15" , "1-14",  "2-13",  "3-12",  "4-11" , "5-10", "6-9" , "7-8"};
	static	String [] jornada15 = {"20-8" , "9-7","10-6" , "11-5" , "12-4" , "13-3",  "14-2" , "15-1" , "16-19" , "17-18"};
	static	String [] jornada16 = {"18-20" , "19-17" , "1-16" , "2-15" , "3-14",  "4-13" , "5-12",  "6-11",  "7-10" ,"8-9"};
	static	String [] jornada17 = {"20-9" , "10-8" , "11-7" , "12-6" , "13-5" , "14-4",  "15-3" , "16-2",  "17-1" , "18-19"};
	static	String [] jornada18= {"19-20" , "1-18",  "2-17" , "3-16" , "4-15" , "5-14" , "6-13" , "7-12" , "8-11" , "9-10"};
	static String [] jornada19 = {"20-10" , "11-9" , "12-8" , "13-7" , "14-6" , "15-5" , "16-4",  "17-3" ,"18-2" , "19-1"};
	static String[] equipos ;

	static ArrayList<Equipos> equiposs = new ArrayList();


	static int[] jornadas= new int[19];
	static Partidos [] pJugados = new Partidos[10];



	public static void main(String[] args) 
	{
		leerEquipos();
		imprimir(generarAleatoriosNoRepetidos(19));
		jugarPartidos();
		try 
		{
			obtenerEquipos();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static void leerEquipos() 
	{
		String texto = "";
		try 
		{
			File archivo = new File("clasificacion.txt");
			FileReader entrada = new FileReader(archivo);
			BufferedReader br = new BufferedReader(entrada);
			while((texto=br.readLine())!=null)
			{
				for(int i=0;i<20;i++) 
				{
					equipos = texto.split(",");	

					equiposs.add(new Equipos(i+1, equipos[i]));
					System.out.println(equiposs.get(i).getNombre()); 
				}
				System.out.println();
			}
			entrada.close();

		} 
		catch (IOException e) 
		{

			System.out.println("No se ha encontrado el archivo:" + e.getMessage());
		}
	}

	public static ArrayList<Integer> generarAleatoriosNoRepetidos (int cantidad) {
		ArrayList<Integer> respuesta = new ArrayList<>();
		for (int i = 0; i < cantidad; i++) {
			respuesta.add(gen(respuesta));
		}			
		return respuesta;
	}


	public static int gen(ArrayList<Integer>a) {
		int numero =(int) (Math.random() * (20 - 1)) + 1;
		if (!a.contains(numero)) {
			return numero;
		}else {
			return gen(a);
		}
	}

	public static void imprimir (ArrayList<Integer>num) 
	{
		for (int i = 0; i < num.size(); i++) 
		{
			if(num.get(i)==1) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada1[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

					jornadas[i] = 1;
				}

			}
			else if(num.get(i)==2) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{

					String[] partidos = jornada2[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());


					jornadas[i] = 2;
				}
			}
			else if(num.get(i)==3) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{

					String[] partidos = jornada3[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());


					jornadas[i] = 3;
				}
			}
			else if(num.get(i)==4) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{

					String[] partidos = jornada4[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());


					jornadas[i] = 4;
				}
			}
			else if(num.get(i)==5) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{

					String[] partidos = jornada5[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

					jornadas[i] = 5;
				}
			}
			else if(num.get(i)==6)
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada6[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());


					jornadas[i] = 6;
				}
			}
			else if(num.get(i)==7) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{

					String[] partidos = jornada7[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());


					jornadas[i] = 7;
				}
			}
			else if(num.get(i)==8) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada8[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 8;
				}
			}
			else if(num.get(i)==9) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada9[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 9;
				}
			}
			else if(num.get(i)==10) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada10[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 10;

				}
			}
			else if(num.get(i)==11) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada11[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 11;
				}
			}
			else if(num.get(i)==12) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada12[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 12;
				}

			}
			else if(num.get(i)==13) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada13[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 13;
				}

			}
			else if(num.get(i)==14) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada14[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 14;
				}
			}
			else if(num.get(i)==15) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada15[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 15;
				}
			}
			else if(num.get(i)==16) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada16[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 16;
				}

			}
			else if(num.get(i)==17) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada17[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 17;
				}
			}
			else if(num.get(i)==18) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada18[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 18;
				}
			}
			else if(num.get(i)==19) 
			{
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada19[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
					jornadas[i] = 19;
				}
			}
			System.out.println();
		}
		for (int i = 0; i < num.size(); i++) 
		{
			if(num.get(i)==1) {}
			else if(num.get(i)==1) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada1[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}

			}
			else if(num.get(i)==2) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada2[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==3) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada3[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==4) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada4[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==5) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada5[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==6)
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada6[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==7) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada7[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==8) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada8[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==9) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada9[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==10) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada10[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==11) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada11[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==12) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada12[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}

			}
			else if(num.get(i)==13) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada13[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}

			}
			else if(num.get(i)==14) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada14[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]);  
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==15) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada15[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==16) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada16[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}

			}
			else if(num.get(i)==17) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada17[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==18) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada18[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			else if(num.get(i)==19) 
			{
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for(int j = 0; j<10;j++)
				{
					String[] partidos = jornada19[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					System.out.println(equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
			}
			System.out.println();
		}
	}
	public static void jugarPartidos() 
	{
		obtenerClasificacion();
		for(int i=0;i<19;i++) 
		{
			if(jornadas[i]==1) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada1[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();
			}
			else if(jornadas[i]==2) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada2[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==3) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada3[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==4) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada4[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==5) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada5[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==6)
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada6[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==7)
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada7[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==8) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada8[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==9) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada9[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==10) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada10[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==11) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada11[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==12) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada12[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==13) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada13[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==14) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{

					String[] partidos = jornada14[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==15) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada15[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==16) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada16[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==17) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada17[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==18) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada18[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==19) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+1));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada19[j].split("-");
					int local = Integer.parseInt(partidos[0]); 
					int visitante = Integer.parseInt(partidos[1]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
		}

		for(int i=0;i<19;i++) 
		{
			if(jornadas[i]==1) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada1[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();
			}
			else if(jornadas[i]==2) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada2[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==3) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada3[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==4) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada4[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==5) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada5[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==6)
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada6[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==7)
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada7[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==8) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada8[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==9) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada9[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==10) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada10[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==11) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada11[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==12) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada12[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==13) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada13[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==14) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{

					String[] partidos = jornada14[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==15) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada15[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==16) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada16[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==17) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada17[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]);  
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==18) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada18[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());

				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();

			}
			else if(jornadas[i]==19) 
			{
				System.out.println();
				System.out.println("Jornada " + (i+20));
				System.out.println();
				for (int j = 0;j<10;j++) 
				{
					String[] partidos = jornada19[j].split("-");
					int local = Integer.parseInt(partidos[1]); 
					int visitante = Integer.parseInt(partidos[0]); 
					pJugados[j] = new Partidos(j,equiposs.get(local-1),equiposs.get(visitante-1));
					System.out.println("Arranca: "+ equiposs.get(local-1).getNombre()  +" Vs " +equiposs.get(visitante-1).getNombre());
				}
				System.out.println();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = 0;j<10;j++) 
				{
					pJugados[j].start();
					try {
						pJugados[j].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				obtenerClasificacion();
			}
		}
	}

	public static void obtenerClasificacion() 
	{
		System.out.println();
		System.out.println("Pos --------- Equipo --------- PT --- PJ --- PG --- PP --- PE --- GF --- GC");
		equiposs.sort(Comparator.comparing(Equipos :: getPuntos).reversed());
		for (int i = 0; i<20; i++) 
		{
			equiposs.get(i).setId(i+1);
		}
		for (int i = 0; i<20; i++) 
		{
			System.out.println("--"+(i+ 1) + "---"+ equiposs.get(i).getNombre() + "--------"+  equiposs.get(i).getPuntos()+ "----"+  equiposs.get(i).getJugados() + "----"+  equiposs.get(i).getGanados()+ "----"+  equiposs.get(i).getPerdidos()+ "----"+  equiposs.get(i).getEmpatados()+ "----"+  equiposs.get(i).getFavor()+ "------------"+  equiposs.get(i).getContra());
		}
	}
	public static void obtenerEquipos() throws IOException 
	{
	
		FileWriter flwriter = null;
		try 
		{
			flwriter = new FileWriter("clasificacion.txt");
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for(int i = 0;i<20;i++) 
			{
				bfwriter.write(equiposs.get(i).getNombre()+ ", ");
			}
			bfwriter.close();

		} 
		catch (IOException e) 
		{
			e.printStackTrace();

		}
	}
}





