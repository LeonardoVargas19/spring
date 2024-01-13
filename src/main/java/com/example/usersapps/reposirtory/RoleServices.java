package com.example.usersapps.reposirtory;

import com.example.usersapps.entityes.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service//-> Logica de negocio
public class RoleServices {
    @Autowired
    private RowRepository repository;

    public List<Rol> getRole(){
        return (List<Rol>) repository.findAll();
    }
    public Rol createRol(Rol role){
       return repository.save(role);

    }
    public Rol updateRol(Integer rolId , Rol role){
        Optional<Rol> result = repository.findById(rolId);
        if(result.isPresent()){
            return repository.save(role);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Role id %d doesn't exists",rolId));
        }

    }

    public void deleteRole(Integer roleid) {
        Optional<Rol> result = repository.findById(roleid);
        if(result.isPresent()){
            repository.delete(result.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Role id %d doesn't exists",roleid));
        }
    }
}
