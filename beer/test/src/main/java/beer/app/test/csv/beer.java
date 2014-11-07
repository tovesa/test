package beer.app.test.csv;

import java.util.Date;

public class beer {
	
	private Date ratingDate;
	private String ratingPlace;
	private Date purchasingPlace;
	private String purchasingDate;
	private String name;
	private String brewery;
	private String country;
	private Date bbe;
	private Date bottled;
	private String pack;
	private int aroma;
	private int appearance;
	private int taste;
	private int palate;
	private int overall;
	private String notes;
	private String batch;
	
	
	
	public beer(Date rated, String ratingPlace, String name, String brewery,
			String pack, int aroma, int appearance, int taste, int palate,
			int overall, String notes) {
		super();
		this.ratingDate = rated;
		this.ratingPlace = ratingPlace;
		this.name = name;
		this.brewery = brewery;
		this.pack = pack;
		this.aroma = aroma;
		this.appearance = appearance;
		this.taste = taste;
		this.palate = palate;
		this.overall = overall;
		this.notes = notes;
	}


	public beer(Date rated, String ratingPlace, Date purchased,
			String purchasingDate, String name, String brewery, String country,
			Date bbe, Date bottled, String pack, int aroma, int appearance,
			int taste, int palate, int overall, String notes, String batch) {
		super();
		this.ratingDate = rated;
		this.ratingPlace = ratingPlace;
		this.purchasingPlace = purchased;
		this.purchasingDate = purchasingDate;
		this.name = name;
		this.brewery = brewery;
		this.country = country;
		this.bbe = bbe;
		this.bottled = bottled;
		this.pack = pack;
		this.aroma = aroma;
		this.appearance = appearance;
		this.taste = taste;
		this.palate = palate;
		this.overall = overall;
		this.notes = notes;
		this.batch = batch;
	}

	
	public Date getRated() {
		return ratingDate;
	}
	public void setRated(Date rated) {
		this.ratingDate = rated;
	}
	public String getRatingPlace() {
		return ratingPlace;
	}
	public void setRatingPlace(String ratingPlace) {
		this.ratingPlace = ratingPlace;
	}
	public Date getPurchased() {
		return purchasingPlace;
	}
	public void setPurchased(Date purchased) {
		this.purchasingPlace = purchased;
	}
	public String getPurchasingDate() {
		return purchasingDate;
	}
	public void setPurchasingDate(String purchasingDate) {
		this.purchasingDate = purchasingDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrewery() {
		return brewery;
	}
	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getBbe() {
		return bbe;
	}
	public void setBbe(Date bbe) {
		this.bbe = bbe;
	}
	public Date getBottled() {
		return bottled;
	}
	public void setBottled(Date bottled) {
		this.bottled = bottled;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public int getAroma() {
		return aroma;
	}
	public void setAroma(int aroma) {
		this.aroma = aroma;
	}
	public int getAppearance() {
		return appearance;
	}
	public void setAppearance(int appearance) {
		this.appearance = appearance;
	}
	public int getTaste() {
		return taste;
	}
	public void setTaste(int taste) {
		this.taste = taste;
	}
	public int getPalate() {
		return palate;
	}
	public void setPalate(int palate) {
		this.palate = palate;
	}
	public int getOverall() {
		return overall;
	}
	public void setOverall(int overall) {
		this.overall = overall;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}

}
