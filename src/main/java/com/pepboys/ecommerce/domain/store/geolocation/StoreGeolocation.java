package com.pepboys.ecommerce.domain.store.geolocation;

public class StoreGeolocation {
	private String KEY;
	private String ADDR;
	private String CITY;
	private String STATE;
	private String ZIP;
	
	@Override
	public String toString() {
		return "KnowwhereStoreLocation [KEY=" + KEY + ", ADDR=" + ADDR
				+ ", CITY=" + CITY + ", STATE=" + STATE + ", ZIP=" + ZIP + "]";
	}

	public String getKEY() {
		return KEY;
	}
	
	public String getADDR() {
		return ADDR;
	}
	
	public String getCITY() {
		return CITY;
	}
	
	public String getSTATE() {
		return STATE;
	}
	
	public String getZIP() {
		return ZIP;
	}
	
}
