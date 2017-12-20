/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.entity;

/**
 *
 * @author Student
 */
public class Customer {
       private String custName;
       private String custIC;
       private String custTelNo;
       private String custAddress;
       private String custEmail;

       
    public Customer(){
        
    }
    
    public Customer(String custName, String custIC, String custTelNo, String custAddress, String custEmail) {
        this.custName = custName;
        this.custIC = custIC;
        this.custTelNo = custTelNo;
        this.custAddress = custAddress;
        this.custEmail = custEmail;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustIC() {
        return custIC;
    }

    public void setCustIC(String custIC) {
        this.custIC = custIC;
    }

    public String getCustTelNo() {
        return custTelNo;
    }

    public void setCustTelNo(String custTelNo) {
        this.custTelNo = custTelNo;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    @Override
    public String toString() {
        return "Customer{" + "Name : %15s\n" + custName + "IC number : %20s\n" + custIC + "Telephone Number : %20s\n" + custTelNo + "Address : %50s\n" + custAddress + "Email : %50s" + custEmail + '}';
    }
    
    
       
       
}

