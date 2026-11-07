import java.util.NoSuchElementException;

public class ArrayList <T>{

	public static final int INITIAL_CAPACITY =9;
	private T[] backingArray;
	private int size;
	
	public ArrayList() {
		if (INITIAL_CAPACITY < 0) {
	        throw new IllegalArgumentException("Capacity cannot be negative.");
	    }
		backingArray = (T[]) new Object[INITIAL_CAPACITY];
	}
	public void addToBack(T data) {
		if (data == null) {
			throw new IllegalArgumentException("Cannot insert null data into data structure.");
		}
		//if size equal to backingArray, means that backingArray is full  
		if (size == backingArray.length) {
			this.resize();
		}
		backingArray[size]=data;
		//+ one so next data will be save at next index
		size++;
	}
	
	public void addToFront(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Cannot insert null data into data structure.");
		}
		if (size == backingArray.length) {
			this.resize();
		}
		//Moving data rightward. From last to first 
		for(int i =size -1; i>=0; i--) {
			//Every index +1
			backingArray[i+1]=backingArray[i];
		}
		backingArray[0]=data;
		size++;
	}
	
	public void addAtIndex(int index, T data) {
		if (index>size || index <0) {
			throw new IndexOutOfBoundsException("Index is not within available range.");
		} else if (data == null) {
			throw new IllegalArgumentException("Cannot insert null data into data structure.");
		}
		if (size == backingArray.length) {
			this.resize();
		}
		//
		if(index == size) {
			backingArray[index] = data;
			size++;
			return;
		}
		//Moving data rightward. From last to first , then every index +1
		for (int i =size -1; i>= index; i--) {
			backingArray[i+1]=backingArray[i];
			
		}
		backingArray[index] = data;
		size++;
	}
	//different between void and T. void is implementing a putting action, T is implementing a getting action. 
	public T removeFromBack() {
		if (size == 0) {
			throw new NoSuchElementException("There is no element to be removed.");
		}
		T storage = backingArray[size-1];
		backingArray[size-1]=null;
		size--;
		return storage;
	}
	public T removeFromFront() {
		if(size ==0) {
			throw new NoSuchElementException("There is no element to be removed.");
		}
		T storage = backingArray[0];
		for (int i=0; i<size-1;i++) {
			backingArray[i] = backingArray[i+1];
		}
		backingArray[size-1]=null;
		size--;
		return storage;
	}
	public T removeAtIndex(int index) {
		if (index < 0 || index>=size) {
			throw new IndexOutOfBoundsException("There is no element to be removed.");
		}
		T storage = backingArray[index];
		if (index ==size-1) {
			backingArray[index] = null;
			size--;
			return storage;
		}
		for (int i = index; i<=size-1; i++) {
			backingArray[i]=backingArray[i+1];
		}
		backingArray[size-1]=null;
		size--;
		return storage;
	}
	
	private void resize() {
		//create a tempList with double size of backingArray 
		T[] tempList = (T[]) new Object[backingArray.length * 2];
		int count = 0;
		//Enhanced for-loop: go through backingArray and store each data into i
		for(T i:backingArray) {
			//store every data i store into tempList[count], then count++
			tempList[count] =i;
			count++;
		}backingArray = tempList;
		/** cannot be used in edx test arraycopy
		System.arraycopy(backingArray, 0, tempList, 0, size);
		backingArray = tempList;

		traditional for loop
		for (int count = 0; count < backingArray.length; count++) {
		    tempList[count] = backingArray[count];
		}
		backingArray = tempList;
		**/
	}
	//check if empty
	public boolean isEmpty() {
		return size ==0;
	}
	//clear backingArray
	public void clear() {
		backingArray = (T[])new Object[INITIAL_CAPACITY];
		size=0;
	}
	//get backingArray
	//T[] because return the whole list to other
	public T[] getbackingArray() {
		return backingArray;
	}
	//return size
	public int size() {
		return size;
	}
}
