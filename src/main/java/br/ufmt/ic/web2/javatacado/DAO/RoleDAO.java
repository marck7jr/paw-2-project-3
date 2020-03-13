package br.ufmt.ic.web2.javatacado.DAO;

import org.springframework.data.repository.CrudRepository;

import br.ufmt.ic.web2.javatacado.Models.Role;

public interface RoleDAO extends CrudRepository<Role, Long> {
    
}