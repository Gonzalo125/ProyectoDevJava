package com.example.practicadevjava.model.dao;

import com.example.practicadevjava.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);

}
