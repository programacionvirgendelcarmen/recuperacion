package RA6;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static boolean validarCodigo(String codigo) {
        return codigo.matches("E\\-[0-9]{2}[ABC]{2}");
    }
    public static boolean validarMarca(String marca) {
        return marca.toLowerCase().matches("(honda|ford|seat|suzuki)");
    }
    public static List<Coche<String, String>> devolverCochesPorMarca(
            List<Coche<String, String>> lista, String marca) {
        List<Coche<String, String>> listaFiltrada = new ArrayList<>();
        for (Coche<String, String> coche : lista)
            if (coche.getMarca().equalsIgnoreCase(marca))
                listaFiltrada.add(coche);
        return listaFiltrada;

    }
    public static List<Coche<String,String>> leerCochesJSON (String ruta) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(ruta));
        List<Coche<String,String>> coches = gson.fromJson(
                reader, new TypeToken<List<Coche<String,String>>>() {}.getType());
        return coches;
    }

    public static void main(String[] args) {
        //System.out.println(validarCodigo("e-10AB"));
        //System.out.println(validarMarca("Suzuki"));
       /* List<Generica<String, String>> lista = List.of(
                new Generica<String , String>("E-86BC", "honda"),
                new Generica<String , String>("E-82AB", "ford"),
                new Generica<String , String>("E-93BC", "suzuki")
        );
        System.out.println(devolverCochesPorMarca(lista, "mercedes"));*/
        try {
            for (Coche<String, String> coche : leerCochesJSON("FILES/coches.json"))
                System.out.println(coche);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
