package com.demo.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.project.model.Employee;

@Controller
public class mainController {
	
	@RequestMapping(value="/check", method=RequestMethod.GET)
    public String index()
    {
        // The html file name is index.jsp
        return "index";
    }
	
	@RequestMapping(value="/helloWorld", method= {RequestMethod.GET,RequestMethod.POST})
    public String helloWorld()
    {
        return "helloWorld";
    }
	
	@RequestMapping("/empform")  
    public ModelAndView showform(){  
         //command is a reserved request attribute name, now use <form> tag to show object data  
        return new ModelAndView("empform","command",new Employee());  
    }  
	
	@RequestMapping("/parentsDetails")  
    public ModelAndView showParentForm(){  
        return new ModelAndView("parentsDetails","command",new Employee());		//empty form  
    }  
	
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("emp") Employee emp){  
        System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());  
          
        //return new ModelAndView("empform","command",emp);//will display object data  
        return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping  
    }  
      
    @RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
		/*
		 * List<Employee> list=new ArrayList<Employee>(); list.add(new
		 * Employee(1,"rahul",35000f,"S.Engineer")); list.add(new
		 * Employee(2,"aditya",25000f,"IT Manager")); list.add(new
		 * Employee(3,"sachin",55000f,"Care Taker"));
		           
        return new ModelAndView("viewemp","list",list); */ 
        return new ModelAndView();
    }  

    /*
	 * @RequestMapping(value="/login", method = RequestMethod.GET) public String
	 * showLoginPage(ModelMap model){ return "login"; }
	 */
}
