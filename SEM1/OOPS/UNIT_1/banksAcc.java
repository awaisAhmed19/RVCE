import java.util.*;
class BankAcc{
    static int Accounts=0;
    String Cname, Acc_type,T_type ;
    int deposit;
    int Bal;
    int amt;
    BankAcc(){
      this.Cname=null;
      this.Acc_type=null;
      this.Bal=0;
    }

    BankAcc(String Cname,String Acc_type){
      this.Cname=Cname;
      this.Acc_type=Acc_type;
      this.Bal=0;
    }
    
    static boolean is_valid_amount(int amt){
      return (amt>50&&amt<100000); 
    }
    
    static boolean is_valid_Account(String Acc_type){
      return Acc_type.equalsIgnoreCase("saving")||Acc_type.equalsIgnoreCase("current");
    }

    static boolean is_valid_T_type(String T_type){
      return T_type.equalsIgnoreCase("cash")||T_type.equalsIgnoreCase("cheque");
    }
    void Deposit(int amt, String T_type ){
      if(!(is_valid_T_type(T_type))){ 
        System.out.println("Invalid Transaction type please check the spelling");
        return;
      }
      if (!(is_valid_amount(amt))){
        if(amt<50){
          System.out.println("the amount must be more than 50 RS");
        }
        else{System.out.println("the amount must be less than 100000 RS");
        }
        return;
      }
      else{
        this.Bal+=amt;
        this.T_type=T_type;
      }
    }
    
    void Deposit(int amt){
      
      if (!(is_valid_amount(amt))){
        if(amt<50){
          System.out.println("the amount must be more than 50 RS");
        }
        else{System.out.println("the amount must be less than 100000 RS");
        }
        return;
      }
      else{
        this.Bal+=amt;
      }
    }

    void Display(){
      System.out.println("The Name of the customer "+this.Cname);
      System.out.println("The Balance of the customer "+this.Bal);
      System.out.println("The Account Type of the customer "+this.Acc_type);
    }
  static void choice(){
    System.out.println("Enter a Choice between 0 to 5");
    System.out.println("1 --to add an account");
    System.out.println("2 --to to remove the account");
    System.out.println("3 --to to make a deposit");
    System.out.println("4 --to display all the accounts ");
    System.out.println("5 --to quit"); 
  }
  public static void main(String[] args){
    Scanner in =new Scanner(System.in);
    ArrayList<BankAcc> b=new ArrayList<>();
    choice();
    int choice=in.nextInt();
    while(choice>0 && choice!=5){
      switch(choice){
        case 1: System.out.println("enter the name and account type");
                System.out.println("Enter the customer name:");
                in.nextLine();
                String name=in.nextLine();
                System.out.println("Press 1 for Savings account");
                System.out.println("Press 2 for current account");
                int Ac_ch=in.nextInt();
                if (Ac_ch==1){
                    System.out.println("you have choosen savings account");
                    b.add(new BankAcc(name,"Savings"));
                }else{
                    System.out.println("you have choosen current account"); 
                    b.add(new BankAcc(name,"Current"));
                }
        break;
        case 2: System.out.println("enter the Name of the Account holder that needs to be deleted");
                in.nextLine();
                String Rname=in.nextLine();
                int flag=0;
                for(int i=0;i<b.size();i++){
                  if(b.get(i).Cname.equalsIgnoreCase(Rname)){
                     System.out.println("Are you sure you want to delete the account? y or n");
                     in.next();
                     String ch=in.next();
                     if(ch.equalsIgnoreCase("y")){
                        b.remove(i);
                        flag=1;
                     }
                     else if(ch.equalsIgnoreCase("n")){
                        break;
                     }
                  }
                }
                if(flag==0){
                  System.out.println("ACCOUNT HOLDER NAME NOT FOUND");
                }
        break;
        case 3:System.out.println("Enter the account holder name you would like to deposit to");
               in.nextLine();
               String Dname=in.nextLine();
               int dflag=0,index=-1;
               
               for (int i=0;i<b.size();i++){
                  if(b.get(i).Cname.equalsIgnoreCase(Dname)){
                      dflag=1;
                      index=i;
                      break;
                  }
               }
               if(dflag==1){
                  System.out.println("Enter the amount you would like to deposit");
                  int amount=in.nextInt();
                  int T_type=0;
                  System.out.println("Enter the choice of Transcation you are using default[0]");
                  System.out.println("1 --for Cash");
                  System.out.println("2 --for Cheque");
                  T_type=in.nextInt();
                  if(T_type!=0&&index!=-1){
                    if (T_type==1){
                      b.get(index).Deposit(amount,"Cash");
                    }else{
                      b.get(index).Deposit(amount,"Cheque");
                    }
                  }
                  else if(T_type>2 || T_type<0 ||index==-1){
                    System.out.println("INVALID INPUT");
                  }
                  else{
                    if (index!=-1){
                      b.get(index).Deposit(amount);
                    }
                    else{
                      System.out.println("Index not found");
                    }
                  }
               }else{
                 System.out.println("ACCOUNT NOT FOUND");
               }
        break;
         case 4: for(BankAcc acc:b){
                   acc.Display();
         }
         break;
         case 5: System.exit(0);
          break;
      }
      choice();
      choice=in.nextInt();
    }

  }
}
