/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenprojectfinal2;


import org.springframework.data.repository.CrudRepository;
import com.mycompany.mavenprojectfinal2.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Roshli
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
