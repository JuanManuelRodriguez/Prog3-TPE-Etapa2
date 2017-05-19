public interface Lista {
	public boolean isEmpty();
	public void delete(int dni);
	public int size();
	void add(int dni, String[] gustos);
	boolean existeDNI(int dni);
}