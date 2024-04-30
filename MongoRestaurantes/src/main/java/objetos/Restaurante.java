/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author abelc
 */
public class Restaurante {

    private ObjectId id;
    private String nombre;
    private float rating;
    private Date fecha;
    private List<String> categorias;

    public Restaurante() {
    }

    public Restaurante(ObjectId id, String nombre, float rating, Date fecha, List<String> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.rating = rating;
        this.fecha = fecha;
        this.categorias = categorias;
    }

    public Restaurante(String nombre, float rating, Date fecha, List<String> categorias) {
        this.nombre = nombre;
        this.rating = rating;
        this.fecha = fecha;
        this.categorias = categorias;
    }

    public Restaurante(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "id=" + id + ", nombre=" + nombre + ", rating=" + rating + ", fecha=" + fecha + ", categorias=" + categorias + '}';
    }

  
}
