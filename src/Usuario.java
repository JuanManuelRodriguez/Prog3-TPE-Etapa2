public class Usuario {
	private int dni;
	private String[] gustos;
	
	public Usuario(int dni, String[] gustos) {
		this.setDni(dni);
		this.setGustos(gustos);
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String[] getGustos() {
		return gustos;
	}
	public void setGustos(String[] gustos) {
		this.gustos = gustos;
	}
}