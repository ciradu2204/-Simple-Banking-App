/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.system;

/**
 *
 * @author Pc
 */
    
public class PremiumClients extends Client{
    
private boolean borrowCredit;

public PremiumClients(String name, int age, double initialDeposit){
 
    super(name, age, initialDeposit);
    
    this.borrowCredit = true; 
    
      
}  

public boolean getborrowCredit(){
return borrowCredit;
}

public void setborrowCredit(boolean borrowCredit){

this.borrowCredit = borrowCredit;
}

    @Override
    public String toString(){
        return String.format("\t%s \n \t%d \n \t%1.2f \n \t%b", getName(), getAge(), getInitialDeposit(), getborrowCredit());
    }

}
   

