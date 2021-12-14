package com.example.practicadevjava.services;

import com.example.practicadevjava.model.dao.IClienteDao;
import com.example.practicadevjava.model.dao.IProductoDao;
import com.example.practicadevjava.model.entity.Cliente;
import com.example.practicadevjava.model.entity.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService{
    public final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private IProductoDao productoDao;

    @Override
    @Transactional
    public Producto registrar(Producto producto) {


        logger.info("registrar");return productoDao.save(producto);
    }



    @Override
    @Transactional
    public Producto actualizar(Producto producto) {
        if (obtener(producto.getId()) != null) {
            logger.info("actualizar");
            return productoDao.save(producto);
        }
        return null;
    }

    @Override
    @Transactional
    public Producto obtener(Long id) {

        logger.info("obtener");
        return productoDao.findById(id).orElse(null);
    }





    @Override
    @Transactional
    public int eliminar(Long id) {

        if(obtener(id)!=null){
            logger.info("eliminar"); productoDao.deleteById(id);
            return 1;
        }

        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listar() {

        logger.info("listar");
        return (List<Producto>) productoDao.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageable) {

        logger.info("listar paage");
        return productoDao.findAll(pageable);
    }

}
