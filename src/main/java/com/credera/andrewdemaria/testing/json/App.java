package com.credera.andrewdemaria.testing.json;

import com.pepboys.ecommerce.domain.store.geolocation.StoreGeolocationList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 *
 * A simple app to test json parsing
 */
public class App {
	
    public static String GEOLOCATION_STORE_LIST_CLASS = "com.pepboys.ecommerce.domain.store.geolocation.StoreGeolocationList";

	
    public StoreGeolocationList retrieveStoreListByCustomerIp() {
    	
    	String data = surroundWithObjectDeclaration(requestKnowwhereDataFromGeoService());
    	System.out.println(data);
    	return parseKnowwhereStoreLocationResponse(data);
    }
    
	private String surroundWithObjectDeclaration(String data) {
		return "{ \"" + GEOLOCATION_STORE_LIST_CLASS + "\": " + data + " }";
	}
	
    private StoreGeolocationList parseKnowwhereStoreLocationResponse(String data) {
    	XStream xstream = new XStream(new JettisonMappedXmlDriver());
    	StoreGeolocationList list = (StoreGeolocationList) xstream.fromXML(data);
    	return list;
    }
    
    private String requestKnowwhereDataFromGeoService() {
    		return "{\"statusCode\": \"0\", \"statusString\": \"Success\", \"count\": 2, \"locations\": [{\"KEY\":\"07980\", \"ADDR\":\"8000 Stream Walk Ln\", \"CITY\": \"Manassas\", \"STATE\":\"VA\", \"ZIP\": \"20109\"}, {\"KEY\":\"07922\", \"ADDR\":\"10275 North Fwy\", \"CITY\":\"Houston\", \"STATE\":\"TX\", \"ZIP\":\"77037\"} ]}";
    }
    
    public static void main( String[] args )
    {
    }
}
