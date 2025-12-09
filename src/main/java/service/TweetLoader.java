/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import model.Tweet;

/**
 *
 * @author hrlm2
 */
public class TweetLoader {
    
    
    public Supplier<List<Tweet>> crearLectorTweet (String ruta){

    Supplier<List<Tweet>> lector =()->{
            try{
               List<String> lineas =  Files.readAllLines(Path.of(ruta));
               List<Tweet> tweets = new ArrayList<>();
               
               /*for(String linea: lineas){
                   String[] campo = linea.split(",",4);
                   Tweet tweet = new Tweet(
                           Integer.parseInt(campo[0]),campo[1],campo[2],campo[3]
                   );
                   tweets.add(tweet);
               }*/
               
               return lineas.stream()
                       .map(linea -> linea.split(",",4))
                       .map(campo -> new Tweet(Integer.parseInt(campo[0]),campo[1],campo[2],campo[3]))
                       .toList();
            }catch(IOException e){
                throw new UncheckedIOException(e);
            }
        };
    return lector;
    }
}
