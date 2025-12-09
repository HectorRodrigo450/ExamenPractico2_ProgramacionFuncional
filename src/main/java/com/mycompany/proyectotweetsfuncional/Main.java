/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectotweetsfuncional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Tweet;
import report.ReportGenerator;
import service.TextTransformService;
import service.TweetAnalyticsService;
import service.TweetLoader;

/**
 *
 * @author hrlm2
 */
public class Main {

    private static List<Tweet> lista = new ArrayList<>();
    private static Map<String,Double> promedios = new HashMap<>();
    private static Map<String,Long> conteo = new HashMap<>();
    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        
        Runnable analisisTweets = ()->{
          TweetAnalyticsService analytic = new TweetAnalyticsService();
            System.out.println("Calculando Promedios de Tweets por Sentimiento");
            promedios.put("Positive",analytic.calcularPromedioLongitud(lista, "Positive"));
            promedios.put("Negative",analytic.calcularPromedioLongitud(lista, "Negative"));
            promedios.put("Neutral",analytic.calcularPromedioLongitud(lista, "Neutral"));

            promedios.entrySet().stream().forEach(promedio -> System.out.println(promedio.toString()));
            
            System.out.println("Contando tweets por Sentimiento");
            conteo= analytic.contarTweetsPorSentimiento(lista);  
            conteo.entrySet().stream().forEach(c -> System.out.println(c.toString()));
        };
        
        
        Runnable guardarArchivos= ()->{
            System.out.println("--Generando Reportes...");
            ReportGenerator reporte = new ReportGenerator();
            reporte.guardarTweetsLimpios(lista, "output/tweets_limpios.txt");
            reporte.guardarEstadisticas(conteo,promedios, "output/Resumen_Estadisticas.txt");
        };
    
        Runnable pipelinePrincipal = () ->{
            
            
            
            
            TweetLoader loader = new TweetLoader();
            lista = loader.crearLectorTweet("data/twitters.csv").get();

            TextTransformService transform = new TextTransformService();
            lista = transform.transformarTweets(lista, transform.transformar());

            transform.procesarTweets(lista, transform.transformar(), transform.consumerImprimirTweet());
            
            
            
            analisisTweets.run();
            
            guardarArchivos.run();
        };
        
        pipelinePrincipal.run();
    }       
}           
