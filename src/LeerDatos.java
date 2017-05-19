

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class LeerDatos {
	private ArrayLista lista;
	
	public LeerDatos(ArrayLista list){
		this.lista=list;
	}
	
	public void CSVInsert(String path, String separador, GuardarDatos datos) {
		String csvFile = path;
		String line = "";
		long start_time, end_time;
		double dif;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] items = line.split(separador);
				String[] gustos = new String[5];
				for(int i=1;i<items.length;i++){
					gustos[i-1] = items[i];
				}
				start_time = System.nanoTime();
				this.lista.add(Integer.parseInt(items[0]), gustos);
				end_time = System.nanoTime();
				dif = (end_time - start_time);
				datos.add(items[0] + separador + dif);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void CSVSearch(String path, String separador, GuardarDatos datos) {
		String csvFile = path;
		String line = "";
		long start_time, end_time;
		double dif;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] items = line.split(separador);
				boolean encontre=false;
				start_time = System.nanoTime();
				encontre=this.lista.busquedaBinaria(Integer.parseInt(items[0]));
				end_time = System.nanoTime();
				dif = (end_time - start_time);
				datos.add(items[0] + separador + dif + separador + encontre);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void CSVPreCharge(String path, String separador) {
		String csvFile = path;
		String line = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] items = line.split(separador);
				String[] gustos = new String[5];
				for(int i=1;i<items.length;i++){
					gustos[i-1] = items[i];
				}
				this.lista.add(Integer.parseInt(items[0]), gustos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
