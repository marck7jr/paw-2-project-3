package br.ufmt.ic.web2.javatacado.DAO;

import org.springframework.data.repository.CrudRepository;

import br.ufmt.ic.web2.javatacado.Models.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Long> {
    
}