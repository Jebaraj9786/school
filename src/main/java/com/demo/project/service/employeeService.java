package com.demo.project.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.demo.project.model.Employee;
import com.demo.project.repository.EmployeeRepository;

@Service
@Transactional
public class employeeService {
	
	@Autowired
	EmployeeRepository repo;
	    
	    public List<Employee> listAll() {
	        return (List<Employee>) repo.findAll();
	    }
	     
	    public void save(Employee emp) {
	        repo.save(emp);
	    }
	     
	    public Employee get(Integer id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }
	    public void add(Employee dto) 
	    {
	    	repo.save(dto); 
	    }
	    public Employee getEmployeeById(Integer id) 
	    {
	    	return repo.findById(id).get(); 
	    }

		public List<Employee> listAllemp(Employee form, HttpServletRequest request, BindingResult result) {
			return (List<Employee>) repo.findAll();
		}

	/*
	 * public List<Employee> getEmployee() { return (List<Employee>)
	 * empRepository.findAll(); }
	 * 
	 * public Employee getEmployeeById(Long id) { return
	 * empRepository.findById(id).get(); }
	 * 
	 * public void delete(Long id) { empRepository.deleteById(id);
	 * 
	 * }
	 * 
	 * public void add(Employee dto) { empRepository.save(dto); }
	 * 
	 * 
	 * private Employee toEntity(Employee dto) { Employee entity = new Employee();
	 * entity.setName(dto.getName()); entity.setSalary(dto.getSalary());
	 * entity.setDesignation(dto.getDesignation()); return entity; }
	 * 
	 * 
	 * public void save(Employee n) {
	 * 
	 * System.out.println("jeba"); }
	 * 
	 * public Iterable<Employee> findAll() { return null; }
	 * 
	 * public List<Employee> getEmployees() {
	 * 
	 * return null; }
	 * 
	 * public Employee getEmpById(Long id) {
	 * 
	 * return null; }
	 * 
	 * public void update(Employee emp) {
	 * 
	 * // TODO }
	 * 
	 * public void saveee(Employee emp) {
	 * 
	 * }
	 * 
	 * public List<Employee> listAll() { return (List<Employee>)
	 * empRepository.findAll(); }
	 */

}
