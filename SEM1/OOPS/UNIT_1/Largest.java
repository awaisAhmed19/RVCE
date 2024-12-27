import java.util.*;
class Largest{
  public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    int largest=0;
    int sLargest=largest;
    int[] arr = {1,4,6,8,9,10,88,2,3,4};
    for (int i=0;i<arr.length;i++){
      if(arr[i]>largest){
        sLargest=largest;
        largest=arr[i];
      }
    }

    System.out.println("the largest number: "+largest+" the second largest element: "+sLargest);

  }
}
