package edu.eci.escuelaing.Calculadora;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;


/**
 * Hello world!
 *
 */
public class SparkWebCalculator{
    
    public static void main(String... args){
          port(getPort());
          Calculator c = new Calculator();
          get("/acos", (req,res) -> {
        	  res.status(200);
              res.type("application/json");
              Double number = Double.parseDouble(req.queryParamsValues("value")[0]);
        	  return "{"
        	  		+ "\"operation\":\"acos\","
        	  		+ "\"input\":\""+number+"\","
        	  		+ "\"output\":\""+c.getAcos(number)+"\""
        	  		+ "}";
          });
          
          get("/tan", (req,res) -> {
        	  res.status(200);
        	  res.type("application/json");
        	  Double number = Double.parseDouble(req.queryParamsValues("value")[0]);
        	  return "{"
        	  		+ "\"operation\":\"tan\","
        	  		+ "\"input\":\""+number+"\","
        	  		+ "\"output\":\""+c.getTan(number)+"\""
        	  		+ "}";
          });
    }
    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 2000;
    }
    
}
