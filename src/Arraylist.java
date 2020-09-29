
public class Arraylist <E> implements ArrayListInterface<E>{

	private E[] array; // Reference to the actual array
	private int size; //How many elements?
	private int capacity; // How big is the array?
	
	private static final int INITIAL_CAPACITY = 10;
	
	public Arraylist()
	{
		this.capacity = this.INITIAL_CAPACITY;
		this.size = 0;
		array = (E[]) new Object[this.capacity];
	}
	
	public Arraylist(int capacity)
	{
		this.capacity = capacity;
		this.size = 0;
		array = (E[]) new Object[this.capacity];
	}
	
	@Override
	public void add(E element) {
		// This method adds elements to the end of the list
		// Fist we need to check if there is space to add
		if(this.size < this.capacity)
		{
			// This means there is some space
			// The last index is given by size
			array[size]= element; // Insert without issues
			size++;				  // Update how many elements 
		}
		else
		{
			//No space in array...We need to reallocate()
//			System.out.println("There isn't enough space, calling reallocate");
			this.reallocate();
			this.add(element); //Once reallocate provides the space
							   // Call this method again
		}
		
		
	}
	private void reallocate() 
	{
		// This will double the size of the array
		this.capacity *= 2; // Make it double
		E[] temp = (E[])new Object[this.capacity]; // Create array
		// Copy over the elements from the old on to the new
		for(int i = 0; i < array.length; i++)
		{
			//Iterate over the array
			temp[i] = array[i];
		}
		//Once the copying is done, update the reference
		this.array = temp; // Pointing to the new array
	}

	@Override
	public void add(int index, E element)
	{
			// This method add at a given index
			// First this we need to do is check validity of the index
		if(index < 0 || index > size){
			System.out.println("Invalid index!");
			return;
		}else if(index == size){
			this.add(element); // We already have a method for this
		}
		else{
			// we have a valid index, and need to shift elements over
			// Check if there is space to shift
			if(this.size == this.capacity){
				// The array is full
				this.reallocate();	
			}
			// Once reallocated, we have the space to shift over
			//We need to shift all the elements from the index to the end
			// on position to the right
			// Copy over elements one place to the right
			for(int i = size; i > index; i--)
			{
				this.array[i] = this.array[i-1];
			}
			
			this.array[index]=element;
			this.size++;
		}
		
	}
	@Override
	
	public E remove(int index) 
	{
		// this will delete the element at index
		// First check validity of the index
		if(index < 0 || index >= size){
			System.out.println("Invalid Index!");
			return null;
		}
		//Now shift might be required
		//Save the element deleted to be returned
		E temp = array[index];
		//Sift over
		for(int i = 0; i < size -1;i++){
			this.array[i]=this.array[i+1];
		}
		size--;
		return null;
	}
	@Override
	public E get(int index) 
	{
		return this.array[index];
	}
	@Override
	public void set(E element, int index) 
	{
		this.array[index] = element;
		
	}
	@Override
	public int getSize() 
	{
		return size;
	}
	@Override
	public int indexof(E element)
	{
		for (int i = 0 ; i < array.length ; i++)
		{
			if (element.equals(array[i])){
				return i;
			}
		}
		return -1;
	}
	

	public String toString()
	{
		//this method returns the contents of the array in a String
		String s = "";
		// We will iterate over the elements and add to the string 
		for(int i = 0; i < size; i++){
			s = s + array[i] + ", "; // " , " for formatting
		}
		return s;
		
	}

}
