public class PruebaConMuchaBusqueda3M {
	public static void main(String[] args) {
		ArrayLista arr = new ArrayLista();
		LeerDatos leerDatos = new LeerDatos(arr); // asigna arr a leerdatos, para que puedan ser guardados
		GuardarDatos datos;

		datos = new GuardarDatos();
		leerDatos.CSVInsert("./src/data/dataset_insert_10000.csv", ";", datos);// inserta los datos en arr
		arr.quicksort(0, arr.size()-1);
		leerDatos.CSVInsert("./src/data/dataset_500000.csv", ";", datos);// inserta los datos en arr
		arr.quicksort(0, arr.size()-1); //size-1 obligado, con size se va de rango el quick
		datos.CSVWritter("salidaInsMuchasBusq3M.csv");
		datos = new GuardarDatos();
		leerDatos.CSVSearch("./src/data/dataset_3000000.csv", ";", datos);
		datos.CSVWritter("salidaBusqMuchasBusq3M.csv");
	}
}