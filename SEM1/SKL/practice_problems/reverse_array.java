import java.util.*;

public class reverse_array{
  public static void main(String args[]){
    int temp=0;
    int []array={1,2,3,4,5,6,7,8,9};
    int []output=new int[array.length];
    //System.out.println(array.length);
    for (int i=array.length;i>0;i--){
      output[array.length-i]=array[i-1];
    }

    for(int j=0;j<array.length;j++){
      System.out.print(output[j]);
    }
  }
}

