package com.pepboys.ecommerce.domain.store.geolocation;

import org.codehaus.jackson.annotate.JsonProperty;

public class StoreGeolocation {
	@JsonProperty(value = "KEY")
	private String KEY;
	@JsonProperty(value = "ADDR")
	private String ADDR;
	@JsonProperty(value = "CITY")
	private String CITY;
	@JsonProperty(value = "STATE")
	private String STATE;
	@JsonProperty(value = "ZIP")
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
//	public StoreGeolocation() {
//		super();
//	}
//	public StoreGeolocation(String kEY, String aDDR, String cITY, String sTATE,
//			String zIP) {
//		super();
//		KEY = kEY;
//		ADDR = aDDR;
//		CITY = cITY;
//		STATE = sTATE;
//		ZIP = zIP;
//	}

	public String getCITY() {
		return CITY;
	}
	
	public String getSTATE() {
		return STATE;
	}
	
	public String getZIP() {
		return ZIP;
	}

//	public void setKEY(String kEY) {
//		KEY = kEY;
//	}
//
//	public void setADDR(String aDDR) {
//		ADDR = aDDR;
//	}
//
//	public void setCITY(String cITY) {
//		CITY = cITY;
//	}
//
//	public void setSTATE(String sTATE) {
//		STATE = sTATE;
//	}
//
//	public void setZIP(String zIP) {
//		ZIP = zIP;
//	}
//	
}
