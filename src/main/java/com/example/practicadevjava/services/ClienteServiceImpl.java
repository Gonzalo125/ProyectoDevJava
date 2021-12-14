package com.example.practicadevjava.services;

import com.example.practicadevjava.model.dao.IClienteDao;
import com.example.practicadevjava.model.entity.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

 public final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional
    public Cliente registrar(Cliente cliente) {


        logger.info("registrar");return clienteDao.save(cliente);
    }



    @Override
    @Transactional
    public Cliente actualizar(Cliente cliente) {
        if (obtener(cliente.getId()) != null) {
            logger.info("actualizar");
            return clienteDao.save(cliente);
        }
        return null;
    }

    @Override
    @Transactional
    public Cliente obtener(Long id) {

            logger.info("obtener");
            return clienteDao.findById(id).orElse(null);
        }





    @Override
    @Transactional
    public int eliminar(Long id) {

        if(obtener(id)!=null){
           logger.info("eliminar"); clienteDao.deleteById(id);
           return 1;
         }

       return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listar() {

        logger.info("listar");
        return (List<Cliente>) clienteDao.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {

        logger.info("listar paage");
        return clienteDao.findAll(pageable);
    }

}


