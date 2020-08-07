package adserver;

import static spark.Spark.*;

import com.google.gson.Gson;

import service.AdBookService;

public class App {

	public static void main(String[] args) {
		StartSparkServer();
	}

	public static void StartSparkServer() {
		port(8080);
		staticFiles.location("/public");
		AdBookService.initialise();
		Gson gson = new Gson();
		get("/showbids",(req,res)->{
			return AdBookService.showBids();
		},gson::toJson);
	}
}
