public class Ordenamiento {
	public static void quicksort(Usuario arr[], int izq, int der) {
		Usuario pivote = arr[izq]; // toma primer elemento como pivote
		int i = izq; // i realiza la búsqueda de izquierda a derecha
		int j = der; // j realiza la búsqueda de derecha a izquierda
		Usuario aux;

		while (i < j) { // mientras no se crucen las búsquedas
			while (arr[i].getDni() <= pivote.getDni() && i < j)
				i++; // busca elemento mayor que pivote
			while (arr[j].getDni() > pivote.getDni())
				j--; // busca elemento menor que pivote
			if (i < j) { // si no se han cruzado
				aux = arr[i]; // los intercambia
				arr[i] = arr[j];
				arr[j] = aux;
			}
		}
		arr[izq] = arr[j]; // se coloca el pivote en su lugar de forma que tendremos
		arr[j] = pivote; // los menores a su izquierda y los mayores a su derecha
		if (izq < j - 1)
			quicksort(arr, izq, j - 1); // ordenamos subarray izquierdo
		if (j + 1 < der)
			quicksort(arr, j + 1, der); // ordenamos subarray derecho
	}
}