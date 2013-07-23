package com.pepboys.ecommerce.domain.store.geolocation;

import java.util.List;

public class StoreGeolocationList {
	public StoreGeolocationList() {
		super();
	}
	public StoreGeolocationList(String statusCode, String statusString,
			String count, List<StoreGeolocation> locations) {
		super();
		this.statusCode = statusCode;
		this.statusString = statusString;
		this.count = count;
		this.locations = locations;
	}
	private String statusCode;
	private String statusString;
	private String count;
	private List<StoreGeolocation> locations;
	@Override
	public String toString() {
		return "KnowwhereStoreLocationList [statusCode=" + statusCode
				+ ", statusString=" + statusString + ", count=" + count
				+ ", locations=" + locations + "]";
	}
	public String getStatusCode() {
		return statusCode;
	}
//	public void setStatusCode(String statusCode) {
//		this.statusCode = statusCode;
//	}
	public String getStatusString() {
		return statusString;
	}
//	public void setStatusString(String statusString) {
//		this.statusString = statusString;
//	}
	public String getCount() {
		return count;
	}
//	public void setCount(String count) {
//		this.count = count;
//	}
	public List<StoreGeolocation> getLocations() {
		return locations;
	}
//	public void setLocations(List<StoreGeolocation> locations) {
//		this.locations = locations;
//	}
}
