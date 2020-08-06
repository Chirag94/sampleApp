package models;

public class AdModel {

	String bidder;
	Integer cpi;
	String target;
	String img;
	public AdModel(String bidder,Integer cpi, String target, String image) {
		this.bidder = bidder;
		this.cpi = cpi;
		this.target = target;
		this.img = image;
	}
	public String getBidder() {
		return bidder;
	}
	public void setBidder(String bidder) {
		this.bidder = bidder;
	}
	public Integer getCpi() {
		return cpi;
	}
	public void setCpi(Integer cpi) {
		this.cpi = cpi;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
