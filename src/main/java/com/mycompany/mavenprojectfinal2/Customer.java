/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenprojectfinal2;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Roshli
 */

@Entity
public class Customer {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer tpnumber;
        
        private String name;
        
        private Integer age;
        
        private String address;
        
        private String email;

        public Customer( int tpnumber, String name, int age, String address, String email)
        {
            this.tpnumber = tpnumber;
            this.name = name;
            this.age = age;
            this.address = address;
            this.email = email;

        }
 
        
        public Customer()
        {}
        

        public int getTpNumber()
        {
            return tpnumber;
        }
        public String getName()
        {
            return name;
        }
        public int getAge()
        {
            return age;
        }
        public String getAddress()
        {
            return address;
        }
        public String getEmail()
        {
            return email;
        }

        public void setTpNumber(int tpNo)
        {
            tpnumber = tpNo;
        }
        public void setName(String sname)
        {
            name = sname;
        }
        public void setAge(int sage)
        {
            age = sage;
        }
        public void setAddress(String saddress)
        {
            address = saddress;
        }
        public void setEmail(String semail)
        {
            email = semail;
        }
    
}