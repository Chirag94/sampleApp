package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import models.AdModel;

public class AdBookService {

	private static List<AdModel> ads;
	
	public static List<AdModel> showBids() {
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

	public static void initialise() {
		generateDataSet();
	}

	private static void generateDataSet() {
		ads = new ArrayList<>();
		AdModel adBid1 = new AdModel("amazonIN", 100, "https://www.amazon.in", "https://lh3.googleusercontent.com/proxy/a1X50NMN05e32XJKFxhrf01Jc0mbe0R90ylUVSyTSh-bWvHmVt-inMnK7-YqUm4VPy1FNaRRYQEujLiwHtvB83VHEJXX6zBDYx08KJtI3ZRn-iXD8JvNaHPo1fiprkxnKG_aVPy7YYZs4eWce3fMYSKIUwfs");
		AdModel adBid2 = new AdModel("amazonUK", 110, "https://www.amazon.uk", "https://cdn.vox-cdn.com/thumbor/bF11WEG9EMdS7FQcAgCgm6rjrck=/0x26:640x453/1400x1050/filters:focal(0x26:640x453):format(jpeg)/cdn.vox-cdn.com/assets/1043499/amazon_co_uk_logo_640.jpg");
		AdModel adBid3 = new AdModel("flipkart", 120, "https://www.flipkart.com", "https://storiesflistgv2.azureedge.net/stories/2019/03/article_banner_press_release_26_03_19_v1-01.jpg");
		AdModel adBid4 = new AdModel("whatsapp", 105, "https://www.whatsapp.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/WhatsApp_logo-color-vertical.svg/1200px-WhatsApp_logo-color-vertical.svg.png");
		AdModel adBid5 = new AdModel("twitter", 115, "https://www.twitter.com", "https://static01.nyt.com/images/2014/08/10/magazine/10wmt/10wmt-superJumbo-v4.jpg");
		AdModel adBid6 = new AdModel("google", 110, "https://www.google.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/1200px-Google_2015_logo.svg.png");
		AdModel adBid7 = new AdModel("apple", 175, "https://www.apple.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1200px-Apple_logo_black.svg.png");
		AdModel adBid8 = new AdModel("microsoft", 130, "https://www.microsoft.com", "https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE2mBE8?ver=aa97");
		
		
		ads.add(adBid1);
		ads.add(adBid2);
		ads.add(adBid3);
		ads.add(adBid4);
		ads.add(adBid5);
		ads.add(adBid6);
		ads.add(adBid7);
		ads.add(adBid8);
		
		
	}

}
