package adserver;

import static spark.Spark.*;

import com.google.gson.Gson;

import service.AdBookService;

public class App {

	public static void main(String[] args) {
		StartSparkServer();
	}

	public static void StartSparkServer() {
		ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);
		staticFiles.location("/public");
		AdBookService.initialise();
		Gson gson = new Gson();
		get("/showbids",(req,res)->{
			return AdBookService.showBids();
		},gson::toJson);
	}
}
