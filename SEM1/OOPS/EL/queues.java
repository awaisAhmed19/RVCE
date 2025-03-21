
import java.util.*;

public class queues<T> implements Iterable<T>{
  private static int DEFAULT_SIZE=8;
  private int index,size;
  public T[] arr;
  
  public queues(){
    this.size=DEFAULT_SIZE;
    this.index=0;
    arr= (T[])new Object[size];
  }

  private void DynamicSize(){
    if(this.index>=this.size){
      this.size=this.size*2;
      T[] newarr=(T[])new Object[this.size];
      System.arraycopy(arr,0,newarr,0,arr.length);
      arr=newarr;
    }
  } 
  
  public boolean isEmpty(){
    return this.index==0;
  }

  public void add(T ele){
    DynamicSize();
    arr[this.index]=ele;
    this.index++;
  }

  public T poll(){
    if(isEmpty()){
      System.out.println("The queue is now empty");
      return null;
    }
    T ret= arr[0];
    T[] newarr=Arrays.copyOfRange(arr,1,arr.length); 
    arr=newarr;
    this.index--;
    return ret;
  }

  public void remove(){
    if(isEmpty()){
      System.out.println("The queue is now empty");
      return;
    }
    T[] newarr=Arrays.copyOfRange(arr,1,arr.length); 
    arr=newarr;
    this.index--;
  }

  public T element(){
    if(isEmpty()){
      System.out.println("The queue is now empty");
      return null;
    }
    return arr[0];
  }

  public T peek(){
    if(isEmpty()){
      return null;
    }
    return arr[0];
  }

  public int size(){
    return this.index+1;
  }
    public Iterator<T> iterator(){
      return new Iterator<T>(){
        private int currentIndex=0;

        @Override
        public boolean hasNext(){
          return currentIndex<index;
        }

        @Override
        public T next(){
          return arr[currentIndex++];
        }
      };
    }

  public static void main(String args[]){
    queues<Integer> intq=new queues();
    queues<Character> charq=new queues();
    queues<String> strq=new queues();
    for(int i=1;i<100;i++){
      intq.add(i);
    }
    for(Integer i : intq){
      System.out.print(i+" ");
    }
    System.out.println();
    for(int i=60;i<100;i++){
      charq.add((char)i);
    }
    for(Character i : charq){
      System.out.print(i+" ");
    }
    System.out.println();
    strq.add("Hello");
    strq.add("My");
    strq.add("Name");
    strq.add("Awais");
    strq.remove();
    for(String i : strq){
      System.out.print(i+" ");
    }

    System.out.println();
    System.out.println("the peek() of intq "+ intq.peek());
    System.out.println("the peek() of charq "+ charq.peek());
    System.out.println("the peek() of strq "+ strq.peek());
    System.out.println("the element() of intq "+ intq.element());
    System.out.println("the element() of charq "+ charq.element());
    System.out.println("the element() of strq "+ strq.element());

    System.out.println("the poll() of intq "+ intq.poll());
    System.out.println("the poll() of charq "+ charq.poll());
    System.out.println("the poll() of strq "+ strq.poll());
    System.out.println("the size() of intq "+ intq.size());
    System.out.println("the size() of charq "+ charq.size());
    System.out.println("the size() of strq "+ strq.size());
  }
}
