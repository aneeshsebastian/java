/** Author - Aneesh Sebastian
 * Dockerised Spark/Embedded Jetty example for HttpService
 */
package com.aneeshsebastian;

import spark.Service;
import spark.Spark;

import static spark.Spark.get;
import static spark.debug.DebugScreen.enableDebugScreen;


public class SparkMain {
	
	public static void main(String[] args) {

		enableDebugScreen(); // Enable debug

		Spark.exception(Exception.class, (exception, request, response) -> {
			exception.printStackTrace();
		});

		//Initialize the http service and configure the Port
		//port(8080);
		Service httpService = Service.ignite().ipAddress("0.0.0.0").port(8080);

		httpService.get("/hello", (req, res)->"Hello, world!");
		
		get("/hello/:name", (req,res)->{
            return "Hello, "+ req.params(":name") + "!!";
        });
	}
}
