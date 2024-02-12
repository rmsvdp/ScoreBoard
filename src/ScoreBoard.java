import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class ScoreBoard {

/*
 * Interfaz Comparator
 * Esta interfaz tiene un único método abstracto
 * 
 * int compare(Object ob1, Object ob2)
 * 
 * Cuando necesitamos otros criterios distintos de la ordenación natural (orden alfabético, alguna
 * otra condición), debemos usar mejor este interfaz.
 * 
 * devuelve <0 si ob1 va antes de ob2
 * devuelve >0 si ob1 va después de ob2
 * devuelve 0 si son iguales
 * Podemos disponer de varios criterios de comparación, para ello se debe crear una 
 * clase específica para que implemente el criterio
 * 
 * Disponemos de una variante del método sort que acepta el criterio de comparación
 * 
 */
	private class Marcador {
		
		private long puntos;
		private String nick;
		private String curso;
		private LocalDateTime fecha;
				
		public Marcador() {};
		public Marcador(long i) {
			this.puntos = i;
			this.nick = "---";
			this.curso = "----";
		}
		public Marcador(long puntos, String nick, String curso,LocalDateTime fecha) {
			this.puntos = puntos;this.nick = nick;this.curso = curso;this.fecha = fecha;}
		public long getPuntos() {return puntos;	}
	
	}
	// Clase específica para compararPuntos
	
	 private class comparaPuntos implements Comparator<Marcador>{
		 @Override
		 public int compare(Marcador s1, Marcador s2)
	   {
			 // si s2>s1   será negativo --> s2 va antes !
	      return (int) (s1.getPuntos() - s2.getPuntos()); 
	   }
	 }
	private Marcador[] myScoreBoard=new Marcador[10] ;
	private Marcador lineapunt= new Marcador();
	private String juego;
	
	public String getJuego() {return juego;	}
	public void setJuego(String juego) {this.juego = juego;	}
	
	public ScoreBoard(String _juego) {
		juego = _juego;						// Especifica el juego
		
		for (int i=0; i<10;i++) {
			myScoreBoard[i] = new Marcador(0);
		}
	}
	
	public int insertScore(long puntos, String nick, String curso,   LocalDateTime fecha) {
		int result = -1;
		this.lineapunt = new Marcador(puntos,nick,curso,fecha);
		Marcador[] tempM ;
		tempM = Arrays.copyOf(this.myScoreBoard, 11);
		tempM[10]= this.lineapunt;
		Arrays.sort(tempM,new comparaPuntos());
		this.myScoreBoard = Arrays.copyOf(tempM, 10);
		result = Arrays.binarySearch(this.myScoreBoard,this.lineapunt);
		return result;
	}
	
	public String[] getScoreBoard() {
		String[] s = new String[10];
		String tab = "      ";
		for (int i=0;i<10;i++) {
			s[i] = "   " + String.format("%1$" + 2 + "s", Integer.toString(i+1)).replace(' ', '0')+ tab +
					    String.format("%1$" + 4 + "s", Long.toString(myScoreBoard[i].puntos)).replace(' ', '0') + tab + 
					    myScoreBoard[i].nick + tab + myScoreBoard[i].curso;
 		}
		return s;
	}
	
} // ScoreBoard


