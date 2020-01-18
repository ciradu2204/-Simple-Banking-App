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
public class Client {
    private String name;
    private int age; 
    private double initialDeposit;
    
    public Client(){
    }
    public Client(String name, int age, double initialDeposit){
     
     this.name = name;
     setInitialDeposit(initialDeposit);
     setAge(age);
    }
    
    public String getName(){
    
      return this.name;
    }
    
    public int getAge(){
    return this.age;
    
    }
    
    public double getInitialDeposit(){
    return this.initialDeposit;
      
    
    }
    
    public void setName(String name){
    this.name = name;
    }
    
    //The age of the client should be greater than zero and less than 1001
    public void setAge(int age){
     if( age>0 && age<100){
       this.age = age;
     }else{
         System.err.println("The age doesn't exist");
     }
    }
    
    public void setInitialDeposit(double initialDeposit){
     
        if(initialDeposit>0){
       this.initialDeposit = initialDeposit;
       }else{
       System.err.println("The initial amount doesn't exist"); 
           
       }
        
    }
    
    
    
    @Override
    public String toString(){
        System.out.printf("");
        return String.format("\t%s \n \t%d \n \t%1.2f", getName(), getAge(), getInitialDeposit());
        
        
    }
    
     
}
