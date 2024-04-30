/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mongorestaurantes;

import datos.RestaurantesDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import objetos.Restaurante;

/**
 *
 * @author abelc
 */
public class MongoRestaurantes {

    public static void main(String[] args) {
        RestaurantesDAO res = new RestaurantesDAO();
        //agregar restaurantes
        /*
       List<String> categorias1 = Arrays.asList("Italiana", "Pizza");
        List<String> categorias2 = Arrays.asList("Mexicana", "Mariscos");
        List<String> categorias3 = Arrays.asList("Carreta", "Comida rápida");

        Restaurante r1 = new Restaurante("Pizzas don pepe", 4, new Date(), categorias1);
        Restaurante r2 = new Restaurante("Mariscos el wero", 5, new Date(), categorias2);
        Restaurante r3 = new Restaurante("Dogos don tomy", 3, new Date(), categorias3);
        res.agregar(r1);
        res.agregar(r2);
        res.agregar(r3);*/

        // restaurantes mayor que 4 en rating
/*        ArrayList<Restaurante> restaurantes = res.consultarRestauranteRatingMayorQue(4);

    for (Restaurante restaurante : restaurantes) {
        System.out.println("Nombre: " + restaurante.getNombre());
        System.out.println("Rating: " + restaurante.getRating());
        System.out.println("Fecha: " + restaurante.getFecha());
        System.out.println("Categorías: " + restaurante.getCategorias());
        System.out.println("-------------------------");
    }*/
 /*
//Consultar por categoria
 ArrayList<Restaurante> restaurantes = res.consultarRestaurantesPorCategoria("Pizza");

        // Mostrar los restaurantes encontrados
        System.out.println("Restaurantes encontrados:");
        for (Restaurante restaurante : restaurantes) {
            System.out.println(restaurante);
        }
         */
 
 //consultar por nombre
 /*
        ArrayList<Restaurante> restaurantes = res.consultarRestaurantesPorNombre("Sushi");
        System.out.println("Restaurantes encontrados:");
        for (Restaurante restaurante : restaurantes) {
            System.out.println(restaurante);
        }*/
 /*
 //Agregar categoria
 res.agregarCategoriaARestaurante("663132685c64534b12288c2d", "Comida rapida");*/

/* //eliminar
    res.eliminarRestaurantePorId("663132685c64534b12288c2d");
*/
//eliminar rating
  res.eliminarRestaurantesPorRatingMenorIgualA(3);
  
    }
}
