package com.example.gestionabogados.modelo;

public class Abogado implements Crud{
    private int identificacion;
    private String nombre;
    private String especializacion;
    private String email;
    private int costoh;

    public Abogado(int identificacion, String nombre, String especializacion, String email, int costoh) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.especializacion = especializacion;
        this.email = email;
        this.costoh = costoh;
    }

    public Abogado() {
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCostoh() {
        return costoh;
    }

    public void setCostoh(int costoh) {
        this.costoh = costoh;
    }

    @Override
    public String toString() {
        return "Abogado{" +
                "identificacion=" + identificacion +
                ", nombre='" + nombre + '\'' +
                ", especializacion='" + especializacion + '\'' +
                ", email='" + email + '\'' +
                ", costoh=" + costoh +
                '}';
    }

    @Override
    public boolean ingresar(Abogado ab) {
        return false;
    }

    @Override
    public boolean modificar(Abogado ab) {
        return false;
    }

    @Override
    public boolean eliminar(String id) {
        return false;
    }

    @Override
    public boolean consultar(String sql) {
        return false;
    }
}
