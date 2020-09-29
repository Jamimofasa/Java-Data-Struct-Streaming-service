
public interface ArrayListInterface<E> {

	public void add(E element); //This method adds to the end of the list
	public void add(int index, E element); // Adds at specific index
	public E remove(int index); // this removes the element at index
	public E get(int index);
	public void set(E element, int index);
	public int getSize();
	public int indexof(E element);
	
}
