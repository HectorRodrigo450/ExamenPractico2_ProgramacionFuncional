# ExamenPractico2_ProgramacionFuncional

Este proyecto en Java, lee desde un CSV una lista de Tweets que se procesan para limpiar los tweets de los @usuarios y #temas. Analiza el promedio y la longitud de cada Tweet segun su Sentimiento. Y al final guarda todo lo generado en dos archivos. Todo esto aplicando la programacion funcional que existe en java.
En el proyecto existen las siguientes clases:
-Tweet.java
  Contiene los datos de cada registro del CSV.
-TweetLoader.java
  Crea un Supplier que lee cada registro del archivo de la ruta "data/tweeters.csv", y retorna una Lista de Tweets.
-TextTransformService.java
  Contiene un Function que cambia a Mayusculas todo el texto del tweet, ademas de eliminar los @usuarios y los #temas;
  Contiene un Consumer que imprime en consola toda la lista de Tweets
TweetAnalyticsService.java
  Calcula el promedio de los caracteres del texto de la Lista de Tweets, segun su Sentimiento. Usando Stream, filter, mapToInt, average,orElse.
  Cuenta el numero de Tweets por Sentimiento. Usando stream, collect, Collector.groupingBy (...)
-ReportGenerator.java
  Crea un archivo llamado "tweets_limpios.txt" donde se guardan los tweets despues de haberse transformado.
  Crea un archivo llamado "Resumen_Estadisticas.txt" donde se guardan los promedios y el conteo de la lista de Tweets.
-Main.java
  Contiene un Runnable principal que maneja el flujo principal de todo el programa.

-Declaratoria de uso de IA generativa-
Si se uso Inteligencia Artificial en la creacion de este proyecto.
Sirvio en la generacion de metodos que por desconocimiento se hacia complicada la tarea. Ejemplo:
  t.getTexto().replaceAll("@\\w+", "") <--- El @\\w+ 
Para resolver dudas en ciertas partes del codigo.
En la limpieza de las funciones del programa (ej. Eliminar metodos y atributos sin funcion).
