package com.example.practicadevjava.model.dao;

import com.example.practicadevjava.model.entity.Cliente;
import com.example.practicadevjava.model.entity.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductoDao extends PagingAndSortingRepository<Producto, Long> {
}
