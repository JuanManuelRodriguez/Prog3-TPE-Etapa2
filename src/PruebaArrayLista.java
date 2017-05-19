public class PruebaArrayLista {

	public static void main(String[] args) {
		ArrayLista arr = new ArrayLista();
		LeerDatos leerDatos = new LeerDatos(arr); // asigna arr a leerdatos, para que puedan ser guardados
		GuardarDatos datos;

		datos = new GuardarDatos();
		arr = new ArrayLista();
		leerDatos.CSVInsert("./src/data/dataset_insert_10000.csv", ";", datos);// inserta los datos en arr
		arr.quicksort(0, arr.size()-1);
		leerDatos.CSVInsert("./src/data/dataset_500000.csv", ";", datos);// inserta los datos en arr
		arr.quicksort(0, arr.size()-1);
		datos.CSVWritter("salidaInsMuchasBusq.csv");
		datos = new GuardarDatos();
		leerDatos.CSVSearch("./src/data/dataset_1000000.csv", ";", datos);
		datos.CSVWritter("salidaBusqMuchasBusq.csv");
		
		leerDatos.CSVPreCharge("./src/data/dataset_1000000.csv", ";");
		datos = new GuardarDatos();
		arr = new ArrayLista();
		leerDatos.CSVInsert("./src/data/dataset_insert_10000.csv", ";", datos);
		datos.CSVWritter("salidaALInsertar1000000.csv");
		datos = new GuardarDatos();
		leerDatos.CSVSearch("./src/data/dataset_busqueda_10000.csv", ";", datos);
		datos.CSVWritter("salidaALBusqueda1000000.csv");
		
		leerDatos.CSVPreCharge("./src/data/dataset_3000000.csv", ";");
		datos = new GuardarDatos();
		arr = new ArrayLista();
		leerDatos.CSVInsert("./src/data/dataset_insert_10000.csv", ";", datos);
		datos.CSVWritter("salidaALInsertar3000000.csv");
		datos = new GuardarDatos();
		leerDatos.CSVSearch("./src/data/dataset_busqueda_10000.csv", ";", datos);
		datos.CSVWritter("salidaALBusqueda3000000.csv");
	}
}
