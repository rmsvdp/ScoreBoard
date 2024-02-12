import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class ScoreBoard {


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

	 private class comparaPuntos implements Comparator<Marcador>{
	   public int compare(Marcador s1, Marcador s2)
	   {
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


