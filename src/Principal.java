import java.time.LocalDateTime;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Principal App = new Principal();
		App.run();
	
	}
	 public void run() {
		 

			ScoreBoard  TopTen = new ScoreBoard("Lights Out");
			
	
			
			TopTen.insertScore(100, "AFX", "1WET", LocalDateTime.now());
			TopTen.insertScore(600, "AFX", "1WET", LocalDateTime.now());
			TopTen.insertScore(950, "UVI", "1WET", LocalDateTime.now());
			TopTen.insertScore(800, "JFC", "1WET", LocalDateTime.now());
			TopTen.insertScore(999, "RMS", "1WET", LocalDateTime.now());
			TopTen.insertScore(601, "AFX", "1WET",LocalDateTime.now());
			TopTen.insertScore(400, "MIA", "1WET",LocalDateTime.now());
			TopTen.insertScore(823, "VDP", "1WET",LocalDateTime.now());
			TopTen.insertScore(998, "R02", "1WET",LocalDateTime.now());
			TopTen.insertScore(997, "R03", "1WET",LocalDateTime.now());
			TopTen.insertScore(996, "HAL", "1WET",LocalDateTime.now());
			
			lista(TopTen);
			
		} // run()

	 public void lista(ScoreBoard _TopTen) {
		 
		 String[] TablaPuntuaciones = new String[10];
			
			TablaPuntuaciones = _TopTen.getScoreBoard();
			
			System.out.println("        "+ _TopTen.getJuego());
			System.out.println("-----------------------------------");
			System.out.println("        ALL OF FAME");
			System.out.println("-----------------------------------");
			for (int i=0;i<10;i++) {
				
				System.out.println(TablaPuntuaciones[i]);
				
			}
	 }

}  // Class
