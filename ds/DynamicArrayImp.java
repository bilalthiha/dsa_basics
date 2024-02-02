class DynamicArray{
    private int size;
    private int capacity;
    Object[] array;

    public DynamicArray(){
        capacity = 10;
        array = new Object[capacity];
        size = 0;
    }

    public DynamicArray(int capacity){
        this.capacity = capacity;
        array = new Object[capacity];
        size = 0;        
    }

    public Object get(int index){
        return array[index];
    }

    public void add (Object data){
        if(size >= capacity){
            grow();
        }
        array[size] = data;
        size++;
    }

    private void grow(){
        int newCapacity = (int)(capacity * 2);
        Object[] newArray = new Object[newCapacity];

        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }

        capacity = newCapacity;
        array = newArray;
    }

    public void insert(int index, Object data){
        if(size >= capacity){
            grow();
        }

        for(int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}

        array[index] = data;
        size++;        
    }

    public void delete(Object data){
        for(int i=0; i < array.length; i++){
            if(array[i] == data){
                for(int j = i; j < size -1; j++){
                    array[j] = array[j+1];
                }
                array[size-1] = null;
                size--;

                if(size <= (int) capacity/3){
                    shrink();
                }
                break;
            }
        }
    }

    private void shrink(){
        int newCapacity = (int)(capacity / 2);
        Object[] newArray = new Object[newCapacity];

        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }

        capacity = newCapacity;
        array = newArray;
    }

    public int search(Object data){
        for(int i = 0; i < size; i++){
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < size; i++){
            s += array[i] + " ";
        }

        if(s == ""){
            s = "[]";
        }

        return s;
    }


}
public class DynamicArrayImp {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(5);
		
		dynamicArray.add("A");
		dynamicArray.add("B");
		dynamicArray.add("E");

        dynamicArray.insert(0, "X");
        dynamicArray.delete("A");
        System.out.println("Index of B: "+ dynamicArray.search("B"));

        System.out.println(dynamicArray);        
		System.out.println("empty: " + dynamicArray.isEmpty());        
    }   
    
}
