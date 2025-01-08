import java.util.*;

public class AM{
  public static void main(String args[]){
    AccessModifier am = new AccessModifier();
    am.accessWithClass();
    // am1=new AccessModifier();
    //am1.accessWithClass();
  }

}

class AccessModifier{
  public String publicVar="PublicVariable";
  private String privateVar="Private Variable";
  protected String protectedVar="Protected variable";

  String defaultVar="default variable";

  public void publicMethod(){
    System.out.println(publicVar);
  }

  private void privateMethod(){
    System.out.println(privateVar);
  }
  protected void protectedMethod(){
    System.out.println(protectedVar);
  }

  void accessWithClass(){
    publicMethod();
    privateMethod();
    protectedMethod();
  }
}
