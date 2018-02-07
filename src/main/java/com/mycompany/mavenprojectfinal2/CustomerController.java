/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenprojectfinal2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.mycompany.mavenprojectfinal2.Customer;
import com.mycompany.mavenprojectfinal2.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Roshli
 */
@Controller
@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private ManageSaloon customerManage;

    @Autowired
    private CustomerRepository customerRepository;
    
    	@GetMapping(path="/all")
	public Page<Customer> showPage(@RequestParam(defaultValue = "0")int page) {
		// This returns a JSON or XML with the users
		return customerRepository.findAll(new PageRequest(page, 4));
	}
    
    
    
    @RequestMapping(method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer)
    {
        customerManage.updateCustomer(customer);
    }
    

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType. APPLICATION_JSON_VALUE)
    public void insertCustomer(@RequestBody Customer customer)
    {
        
        customerManage.insertCustomer(customer);
    }
}