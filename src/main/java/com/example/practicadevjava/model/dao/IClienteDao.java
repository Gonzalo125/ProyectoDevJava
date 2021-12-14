package com.example.practicadevjava.model.dao;

import com.example.practicadevjava.model.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {


}
