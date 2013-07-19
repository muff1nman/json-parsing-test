package com.pepboys.ecommerce.domain.store.geolocation;

import java.util.List;

public class StoreGeolocationList {
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
}
