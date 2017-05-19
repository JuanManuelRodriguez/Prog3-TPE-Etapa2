public class ArrayLista implements Lista{
	private Usuario[] users;
	private int size;
	private boolean ordenado;
	
	public ArrayLista(int nro) {
		this.users = new Usuario[nro];
		this.size=0;
		this.ordenado = false;
	}
	public ArrayLista(){
		this(10000);
	}
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void delete(int dni) {
		int pos = -1;
		for (int i = 0; i < users.length; i++) {
			if(users[i].getDni() == dni) {
				pos = i;
				break;
			}
		}
		if(pos != -1) {
			for (int i = pos+1; i < this.size(); i++) {
				users[i-1] = users[i]; 
			}
			users[this.size()-1] = null;
			this.size--;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	public void duplicarCapacidad() {
		Usuario[] nuevoArreglo = new Usuario[this.users.length*2];
		for (int i = 0; i < users.length; i++) {
			nuevoArreglo[i] = users[i];
		}
		this.users = nuevoArreglo;
	}
	
	@Override
	public void add(int dni, String[] gustos) {
		if(this.size() == this.users.length) this.duplicarCapacidad();
		Usuario nuevoUsuario = new Usuario(dni, gustos);
		this.users[this.size()] = nuevoUsuario;
		this.size++;
		ordenado = false;
	}
	
	public boolean existeDNI(int dni){
		if(!this.isEmpty()) {
			for (int i=0;i<size;i++) {
				if(users[i].getDni() == dni) {
					return true;
				}
			}
		}
		return false;
	}
	
//	public void insertarConMuchaBusqueda(int dni, String[] gustos){
//		this.add(dni, gustos);
//		this.quicksort(0, this.size-1);
//	}
//	
//	public boolean existeDNIOrdenadoMuchaInsercion(int dni){
//		if(!this.isEmpty()) {
//			if(!ordenado){
//				this.quicksort(0, this.size()-1);
//			}
//			return this.busquedaBinaria(dni);
//		}
//		return false;
//	}
	
	public void quicksort(int izq, int der) {
		Usuario pivote = users[izq]; // toma primer elemento como pivote
		int i = izq; // i realiza la b�squeda de izquierda a derecha
		int j = der; // j realiza la b�squeda de derecha a izquierda
		Usuario aux;

		while (i < j) { // mientras no se crucen las b�squedas
			while (users[i].getDni() <= pivote.getDni() && i < j)
				i++; // busca elemento mayor que pivote
			while (users[j].getDni() > pivote.getDni())
				j--; // busca elemento menor que pivote
			if (i < j) { // si no se han cruzado
				aux = users[i]; // los intercambia
				users[i] = users[j];
				users[j] = aux;
			}
		}
		users[izq] = users[j]; // se coloca el pivote en su lugar de forma que tendremos
		users[j] = pivote; // los menores a su izquierda y los mayores a su derecha
		if (izq < j - 1)
			quicksort( izq, j - 1); // ordenamos subarray izquierdo
		if (j + 1 < der)
			quicksort(j + 1, der); // ordenamos subarray derecho
		
		ordenado = true;
	}
	
	public boolean busquedaBinaria(int dni){
		  int centro,inf=0,sup=this.size-1;
		   while(inf<=sup){
		     centro=(sup+inf)/2;
		     if(users[centro].getDni()==dni) return true;
		     else if(dni < users[centro].getDni() ){
		        sup=centro-1;
		     }
		     else {
		       inf=centro+1;
		     }
		   }
		   return false;
		 }
}