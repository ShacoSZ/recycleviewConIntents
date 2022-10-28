package com.example.californication.modelos;

import android.content.Intent;

public class persona {
    private String Nombre;
    private String Telefono;
    private Intent action;

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    public Intent getAction() {return action;}
    public void setAction(Intent action) {this.action=action;}

    public persona(String nombre, String telefono, Intent action) {
        this.Nombre = nombre;
        this.Telefono = telefono;
        this.action= action;
    }


}
