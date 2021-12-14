package com.example.practicadevjava.services;

import com.example.practicadevjava.model.entity.Cliente;
import com.example.practicadevjava.model.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {
    Producto registrar(Producto producto);

    Producto actualizar(Producto producto);

    Producto obtener(Long id);

    int eliminar(Long id);
    public Page<Producto> findAll(Pageable pageable);
    public List<Producto> listar();
}
