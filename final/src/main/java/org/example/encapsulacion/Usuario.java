package org.example.encapsulacion;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private String idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "is_admin")
    private boolean isAdmin;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    private List<URL> urls;



    public Usuario(String nombre, String usuario, String contrasena, Boolean isAdmin) {
        this.idUsuario = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.isAdmin = isAdmin;
    }

    public Usuario() {

    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
    public List<URL> getUrls() {
        return urls;
    }

    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(usuario, usuario.usuario);
    }
    public String getRol() {
        return isAdmin ? "ADMIN" : "USER";
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario);
    }
}

