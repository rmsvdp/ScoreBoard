import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class ScoreBoard {

	
	/* Versi�n con algoritmo de ordenaci�n propio
	 * ------------------------------------------------------------
	 * Esta versi�n utiliza un algoritmo propio de ordenaci�n,
	 * el principio consiste en suponer que se parte siempre
	 * de una lista ordenada.
	 * Se recorre la lista y se para cuando la posici�n sea menor
	 * que la puntuaci�n que estamos intentando registrar.
	 * En ese momento, se desplazan hacia abajo el resto de puntuaciones
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
	/**
	 * Lista con las 10 mejores puntuaciones ordenadas
	 */
	private Marcador[] myScoreBoard=new Marcador[10] ;
	/**
	 * Objeto Marcador auxiliar
	 */
	private Marcador lineapunt= new Marcador();
	/**
	 * Nombre del juego al que hace referencia la lista de puntuaciones
	 */
	private String juego;
	
	
	public String getJuego() {return juego;	}
	public void setJuego(String juego) {this.juego = juego;	}
	
	/**
	 * Constructor por defecto
	 * @param _juego Nombre del juego sobre el que se genera la lista.
	 */
	public ScoreBoard(String _juego) {
		juego = _juego;						// Especifica el juego
		
		for (int i=0; i<10;i++) {
			myScoreBoard[i] = new Marcador(0);
		}
	}

	/**
	 * Gestiona la inserci�n de una puntuaci�n.
	 * @param puntos Puntuaci�n
	 * @param nick   Nick del jugador que registra la puntuaci�n
	 * @param curso  Grupo del jugador
	 * @param fecha  Fecha de creaci�n de la puntaci�n
	 * @return Posci�n en la que se inserta (-1) si no entra
	 * dentro de las 10 primeras.
	 */
	public int insertScore(long puntos, String nick, String curso,   LocalDateTime fecha) {
		int result = -1;
		this.lineapunt = new Marcador(puntos,nick,curso,fecha);
		for (int i=0; i<10;i++) {
			if (myScoreBoard[i].puntos <= lineapunt.puntos) {
				for (int j= 9;j>i;j--) {
					myScoreBoard[j]=myScoreBoard[j-1];
				}
				myScoreBoard[i]=lineapunt;
			result = i;
			break;
			}
		}
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


