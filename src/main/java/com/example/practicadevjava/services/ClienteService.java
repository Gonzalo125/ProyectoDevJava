package com.example.practicadevjava.services;

import com.example.practicadevjava.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {
    Cliente registrar(Cliente cliente);

    Cliente actualizar(Cliente cliente);

    Cliente obtener(Long id);

    int eliminar(Long id);
    public Page<Cliente> findAll(Pageable pageable);
    public List<Cliente> listar();
}
