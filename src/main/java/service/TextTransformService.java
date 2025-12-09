/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import model.Tweet;

/**
 *
 * @author hrlm2
 */
public class TextTransformService {
    
    public Function<Tweet,Tweet> transformar(){
        Function<Tweet,Tweet> transformarMayuscula = t ->{
            return new Tweet(t.getId(),t.getEntidad(),t.getSentimiento(),t.getTexto().toUpperCase().trim());
        };
        Function<Tweet,Tweet> eliminarUsuario = t ->{
            return new Tweet(t.getId(),t.getEntidad(),t.getSentimiento(),t.getTexto().replaceAll("@\\w+", "").trim());
        };
        Function<Tweet,Tweet> eliminarTema = t ->{
            return new Tweet(t.getId(),t.getEntidad(),t.getSentimiento(),t.getTexto().replaceAll("#\\w+", "").trim());
        };
        Function<Tweet,Tweet> transformarTodo = t -> {
            
            return eliminarTema.apply( 
                    eliminarUsuario.apply(
                            transformarMayuscula.apply(t)));
        };
        return transformarTodo;
    }
    
    public Consumer<Tweet> consumerImprimirTweet(){
        Consumer<Tweet> imprimirTweet = (tweet)->{
            System.out.println("Tweet ID: "+tweet.getId());
            System.out.println("Entidad: "+tweet.getEntidad()+"   |  Sentimiento: "+tweet.getSentimiento());
            System.out.println(tweet.getTexto());
        };
        return imprimirTweet;
    }

    
    public List<Tweet> transformarTweets (List<Tweet> tweets, Function<Tweet,Tweet> transformacion){
        
        return tweets.stream().map(transformacion).toList();
    }
    
    public void procesarTweets(List<Tweet> tweets,Function<Tweet,Tweet> transformacion,Consumer<Tweet> accionFinal){
        tweets.stream()
                .map(transformacion)
                .forEach(accionFinal);
    }
}
