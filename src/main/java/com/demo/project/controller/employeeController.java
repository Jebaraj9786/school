package com.demo.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.project.model.Employee;
import com.demo.project.repository.EmployeeRepository;
import com.demo.project.service.employeeService;

@Controller
public class employeeController {

	@Autowired
	employeeService empservice;

	@Autowired 
	private EmployeeRepository employeeRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
	 , @RequestParam int salary, @RequestParam String designation) {
	
	Employee n = new Employee();
	n.setName(name);
	n.setSalary(salary);
	n.setDesignation(designation);
	employeeRepository.save(n);
	return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Employee> getAllUsers() {
	// This returns a JSON or XML with the users
	return employeeRepository.findAll();
	}


	@GetMapping(value = "/getAllEmployee")
	public Iterable<Employee> getEmployees() {
		return empservice.listAll();
	}

	@PostMapping(value = "/addNewParent")
	public void postEmployees(Employee dto) {
		empservice.add(dto);
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable(required = true) Integer id) {
		return empservice.getEmployeeById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) int id) {
		empservice.delete(id);
	}
	
	@RequestMapping(value = "/savee", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("empForm") Employee emp) {
	    empservice.save(emp);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	   // ModelAndView mav = new ModelAndView("empeditform");
	    Employee emp = empservice.get(id);
	   // mav.addObject("empForm", emp);
	     
	   // return mav;
	    return new ModelAndView("empeditform","empForm",emp);
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    empservice.delete(id);
	    return "redirect:/";       
	}

	/*
	 * @PostMapping(path="/add") // Map ONLY POST Requests public @ResponseBody
	 * String addNewUser (@RequestParam String name , @RequestParam String
	 * designation, @RequestParam Float salary) { // @ResponseBody means the
	 * returned String is the response, not a view name // @RequestParam means it is
	 * a parameter from the GET or POST request
	 * 
	 * Employee n = new Employee(); n.setName(name); n.setSalary(salary);
	 * n.setDesignation(designation); empservice.save(n); return "Saved"; }
	 * 
	 * @GetMapping(path="/all") public @ResponseBody Iterable<Employee>
	 * getAllEmployee() { // This returns a JSON or XML with the users return
	 * empservice.findAll(); }
	 * 
	 * @RequestMapping(value="/save",method = RequestMethod.POST) public String
	 * save(@ModelAttribute("emp") Employee emp){ empservice.saveee(emp); return
	 * "redirect:/viewemp";//will redirect to viewemp request mapping } It provides
	 * list of employees in model object
	 * 
	 * @RequestMapping("/viewemp") public String viewemp(Model m){ List<Employee>
	 * list=empservice.getEmployees(); m.addAttribute("list",list); return
	 * "viewemp"; } It displays object data into form for the given id.
	 * The @PathVariable puts URL data into variable.
	 * 
	 * @RequestMapping(value="/editemp/{id}") public String edit(@PathVariable Long
	 * id, Model m){ Employee emp=empservice.getEmpById(id);
	 * m.addAttribute("command",emp); return "empeditform"; } It updates model
	 * object.
	 * 
	 * @RequestMapping(value="/editsave",method = RequestMethod.POST) public String
	 * editsave(@ModelAttribute("emp") Employee emp){ empservice.update(emp); return
	 * "redirect:/viewemp"; } It deletes record for the given id in URL and
	 * redirects to /viewemp
	 * 
	 * @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET) public
	 * String deletee(@PathVariable Long id){ empservice.delete(id); return
	 * "redirect:/viewemp"; }
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHomePage(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		List<Employee> listEmploeeDetails = empservice.listAll();
		//request.setAttribute("listEmpDetails", listEmploeeDetails);
		model.addAttribute("listEmpDetails", listEmploeeDetails);

		return "viewemp";
	}
	
	/*
	 * @GetMapping(value = "/saveeee") public ModelAndView
	 * viewHomePage(@ModelAttribute("empForm") Employee form, HttpServletRequest
	 * request, BindingResult result) throws Exception { List<Employee> empSave =
	 * empservice.listAllemp(form, request,result); return new ModelAndView(); }
	 */
	 
}
