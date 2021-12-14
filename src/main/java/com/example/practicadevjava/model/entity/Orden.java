package com.example.practicadevjava.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden")
public class Orden implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<Pedido> pedidos;


    private Double totalOrden;

    public Orden() {
        this.pedidos = new ArrayList<Pedido>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return fecha;
    }

    public void setCreateAt(Date createAt) {
        this.fecha = createAt;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Double getTotalOrden() {
        return totalOrden;
    }

    public void setTotalOrden(Double totalOrden) {
        this.totalOrden = getTotal();
    }

    public Double getTotal() {
        Double total = 0.0;

        int size = pedidos.size();

        for (int i = 0; i < size; i++) {
            total += pedidos.get(i).getTotal();
        }
        return total;
    }

    private static final long serialVersionUID = 1L;
}
