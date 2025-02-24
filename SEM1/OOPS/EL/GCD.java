import java.util.*;
class GCD{
  public static int gcd(int a,int b){
    int temp=0;
    if(a<b){
      temp=a;
      a=b;
      b=temp;
    }else{
      while(b!=0){
        temp=b;
        b=a%b;
        a=temp;
      }
    }
      return a;
  }

  public static void main(String args[]){
    Scanner in=new Scanner(System.in);
    int a,b;
    a=in.nextInt();
    b=in.nextInt();
    System.out.println("gcd for "+a+" and "+b+ "is "+gcd(a,b));
  }
}
