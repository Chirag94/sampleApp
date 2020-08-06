package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import models.AdModel;

public class AdBookService {

	public static List<AdModel> showBids() {
		List<AdModel> ads = readCSV();
		Collections.shuffle(ads);
		return ads.subList(0, 4);
	}

	private static List<AdModel> readCSV() {
		Pattern pattern = Pattern.compile(",");
		List<AdModel> ads = null;
		try (BufferedReader in = new BufferedReader(new FileReader("/Users/chiragsharma/Desktop/HeaderBidder/headerbid/src/main/resources/public/AdDataSet.csv"));){
			ads = in.lines().skip(1).map(line ->{
				String []x = pattern.split(line);
				return new AdModel(x[0], Integer.parseInt(x[1]),x[2], x[3]);
			}).collect(Collectors.toList());
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return ads;
	}

}
