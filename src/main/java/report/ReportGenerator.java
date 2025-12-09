/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Tweet;

/**
 *
 * @author hrlm2
 */
public class ReportGenerator {
    
    
    public void guardarTweetsLimpios(List<Tweet> tweets, String rutaSalida){
        List<String> lista = new ArrayList<>();
        
        lista = tweets.stream()
                .map(tweet ->
                        "ID: "+tweet.getId()
                       +", Entidad: "+tweet.getEntidad()
                       +", Sentimiento: "+tweet.getSentimiento()
                       +", Texto: "+tweet.getTexto()
                )
                .toList();

        try{
            Files.write(Path.of(rutaSalida),lista);
            System.out.println("Archivo generado.");
        }catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
    
    public void guardarEstadisticas(Map<String,Long> conteo,Map<String,Double> promedios,String rutaSalida){
        List<String> lista = new ArrayList<>();
        lista.add("Conteo de Sentimientos");
        lista.addAll(conteo.entrySet().stream()
                .map(t -> "Sentimiento: "+t.getKey()+"| Conteo: "+t.getValue())
                .toList());
        lista.add("Promedio de Tweets de cada Sentimiento");
        lista.addAll(promedios.entrySet().stream()
                .map(t-> "Sentimiento: "+t.getKey()+"| Promedio: "+t.getValue())
                .toList());
        try{
            Files.write(Path.of(rutaSalida),lista);
            System.out.println("Archivo generado.");
        }catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
