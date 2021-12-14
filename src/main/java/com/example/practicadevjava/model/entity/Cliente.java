package com.example.practicadevjava.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="apellido", length=50)
    private String apellido;

    @Column(name="nombre", length=50)
    private String nombre;

    @Column(name="email", length=50)
    private String email;

    @Column(name="telefono", length=50)
    private String  telefono;


    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Pedido> pedidos;

    public Cliente() {
        pedidos = new ArrayList<Pedido>();
    }

    public Cliente(String apellidos, String nombres, String email, String telefono,String foto) {

        this.apellido = apellidos;
        this.nombre = nombres;
        this.email = email;
        this.telefono = telefono;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  //  public String getFoto() {
    //    return foto;
    //}

    //public void setFoto(String foto) {
      //  this.foto = foto;
   // }



    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
               // ", foto='" + foto + '\'' +
                '}';
    }
}
