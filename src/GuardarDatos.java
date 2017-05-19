

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class GuardarDatos {
	private Vector<String> tiempos;
	
	public GuardarDatos() {
		tiempos = new Vector<String>();
	}
	
	public void CSVWritter(String salida) {
		BufferedWriter bw = null;
		
		try {
			File file = new File("./src/data/"+salida);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (String tiempo : tiempos) {
				bw.write(tiempo);
				bw.newLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}
	
	public void add(String texto) {
		tiempos.add(texto);
	}
	
	@Override
	public String toString() {
		return tiempos.toString();
	}
}
