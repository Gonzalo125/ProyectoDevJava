package com.example.practicadevjava.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="estado", length=50)
    private String estado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "impuesto_id")
    private List<Impuesto> impuestos;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "itemlist_id")
    private List<itemListArt> items;


    private Double subtotal;


    private Double totalSol;



    public Long getId() {
        return id;
    }
    public Double getTotalSol() {
        return totalSol;
    }

    public void setTotalSol(Double totalSol) {
        this.totalSol = getTotal();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }




    public List<itemListArt> getItems() {
        return items;
    }

    public void setItems(List<itemListArt> items) {
        this.items = items;
    }


    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = getsubTotal();
    }

    public Double getsubTotal() {
        Double subtotal = 0.0;

        int size = items.size();

        for (int i = 0; i < size; i++) {
           subtotal += items.get(i).calcularImporte();
        }
        return subtotal;
    }

    public double getTotal(){
        Double total = 0.0;
        List<Double>listImpuestos= null;
        int size = impuestos.size();

        for (int i = 0; i < size; i++) {
            listImpuestos.add(subtotal*impuestos.get(i).getValor());
        }
        for (int i = 0; i < size; i++) {

           total+= listImpuestos.get(i);
        }
        return total;

    }
    private static final long serialVersionUID = 1L;
}
