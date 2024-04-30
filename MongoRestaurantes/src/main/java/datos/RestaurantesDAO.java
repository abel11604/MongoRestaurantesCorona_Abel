/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import objetos.Restaurante;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author abelc
 */
public class RestaurantesDAO {

    private MongoCollection getCollection() {
        ConexionBD conexionBD = new ConexionBD();
        MongoDatabase database = conexionBD.crearConexion();
        MongoCollection collection = database.getCollection("restaurantes", Restaurante.class);
        return collection;
    }

    public boolean agregar(Restaurante r) {
        try {
            this.getCollection().insertOne(r);
            return true;
        } catch (MongoException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Restaurante> consultarRestauranteRatingMayorQue(float rating) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        MongoCursor<Restaurante> cursor = this.getCollection()
                .find(Filters.gt("rating", rating))
                .iterator();
        try {
            while (cursor.hasNext()) {
                Restaurante restaurante = cursor.next();
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }
        return restaurantes;

    }

    public ArrayList<Restaurante> consultarRestaurantesPorCategoria(String categoria) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        List<String> categoriasList = List.of(categoria);
        Bson filtro = Filters.in("categorias", categoriasList);
        MongoCursor<Restaurante> cursor = this.getCollection()
                .find(filtro)
                .iterator();

        try {
            while (cursor.hasNext()) {
                Restaurante restaurante = cursor.next();
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }

        return restaurantes;
    }

    public ArrayList<Restaurante> consultarRestaurantesPorNombre(String nombre) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Pattern pattern = Pattern.compile(nombre, Pattern.CASE_INSENSITIVE);
        Bson filter = Filters.regex("nombre", pattern);
        MongoCursor<Restaurante> cursor = this.getCollection().find(filter).iterator();
        try {
            while (cursor.hasNext()) {
                Restaurante restaurante = cursor.next();
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
            return restaurantes;
        }

    }

    public void agregarCategoriaARestaurante(String restauranteId, String nuevaCategoria) {
        Bson filtroId = Filters.eq("_id", new ObjectId(restauranteId));
        Bson update = Updates.addToSet("categorias", nuevaCategoria);
        UpdateResult result = this.getCollection().updateOne(filtroId, update);
        if (result.getModifiedCount() == 1) {
            System.out.println("Se agregó la categoría al restaurante con ID: " + restauranteId);
        } else {
            System.out.println("No se pudo agregar la categoría al restaurante con ID: " + restauranteId);
        }
    }

    public boolean eliminarRestaurantePorId(String id) {
        try {
            Bson filter = Filters.eq("_id", new ObjectId(id));
            DeleteResult result = this.getCollection().deleteOne(filter);
            if (result.getDeletedCount() > 0) {
                System.out.println("Restaurante eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ningún restaurante con el ID proporcionado.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarRestaurantesPorRatingMenorIgualA(float rating) {
        try {
            DeleteResult result = this.getCollection()
                    .deleteMany(Filters.lte("rating", rating));
            return result.wasAcknowledged();
        } catch (MongoException e) {
            e.printStackTrace();
            return false;
        }
    }
}
