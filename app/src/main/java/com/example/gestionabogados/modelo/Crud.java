package com.example.gestionabogados.modelo;

public interface Crud {

    public boolean ingresar(Abogado ab);

    public boolean modificar(Abogado ab);

    public boolean eliminar(String id);

    public boolean consultar(String sql);
}
