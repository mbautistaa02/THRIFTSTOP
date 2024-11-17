package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class HelloApplication extends Application {

    public static String path="C:\\Users\\Usuario\\IdeaProjects\\ESTRUCTURAS\\PROYECTO FINAL THRIFTSTOP\\ThriftShop\\src\\main\\resources\\";
    public static PrendaService prendaService = new PrendaService();
    private static List<Prenda> listaDePrendas = prendaService.getPrendas();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
        stage.setTitle("ThriftStop - Login");
        stage.setScene(scene);
        stage.show();
    }

   /* public static List<Prenda> getPrendas(){
        listaDePrendas = prendaService.getPrendas();
        return listaDePrendas;
    }

    public static List<Prenda> getListaDePrendas(){
        listaDePrendas = prendaService.getPrendas();
        return listaDePrendas;
    }*/
   public static List<Prenda> getPrendas(){
       List<Prenda> listaDePrendas = new ArrayList<>();
       try (InputStream inputStream = HelloApplication.class.getClassLoader().getResourceAsStream("prendas.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
           String line;
           while ((line = reader.readLine()) != null) {
               Prenda pr = Prenda.fromString(line);
               listaDePrendas.add(pr);
               //System.out.println(pr.toString());
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return listaDePrendas;
   }

    public static List<Prenda> getListaDePrendas() { // Método para acceder a la lista de prendas
        return listaDePrendas;
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}
