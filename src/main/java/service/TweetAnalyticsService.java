/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Tweet;

/**
 *
 * @author hrlm2
 */
public class TweetAnalyticsService {
    
    
    
    public double calcularPromedioLongitud(List<Tweet> tweets, String sentimiento){
        double promedio = tweets.stream()
                .filter(l -> l.getSentimiento().contentEquals(sentimiento))
                .mapToInt(l -> l.getTexto().length())
                .average()
                .orElse(0.0);
        return promedio;
    }
    
    public long calcularNumeroSentimiento(List<Tweet> tweets,String sentimiento){
        long conteo = tweets.stream()
                .filter(t -> t.getSentimiento().contentEquals(sentimiento))
                .count();

        return conteo;
    }
    

    
    public Map<String, Long> contarTweetsPorSentimiento(List<Tweet> tweets){ 
    return tweets.stream()
            .collect(Collectors
                    .groupingBy(Tweet::getSentimiento,
                            Collectors.counting()));
}
}
