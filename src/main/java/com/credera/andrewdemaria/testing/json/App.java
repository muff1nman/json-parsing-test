package com.credera.andrewdemaria.testing.json;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIBuilder;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.pepboys.ecommerce.domain.store.geolocation.StoreGeolocation;
import com.pepboys.ecommerce.domain.store.geolocation.StoreGeolocationList;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 * 
 * A simple app to test json parsing
 */
public class App {

	public static String KNOWWHERE_LOCATION_API_HOST = "184.106.198.34";

	public static int KNOWWHERE_LOCATION_API_PORT = 8080;

	public static String KNOWWHERE_LOCATION_API_PATH = "/kzbp/pepboys_qa/cgi/csg";

	public static String KNOWWHERE_LOCATION_API_QUERY_NAME = "USER_REMOTE_ADDR";

	public static String GEOLOCATION_STORE_LIST_CLASS = "com.pepboys.ecommerce.domain.store.geolocation.StoreGeolocationList";

	public StoreGeolocationList retrieveStoreListByCustomerIp() throws Exception {

		String data;
		
			data = requestKnowwhereDataFromGeoService();
			System.out.println(data);
			return parseKnowwhereStoreLocationResponse(data);

	}

	private String surroundWithObjectDeclaration(String data) {
		return "{ \"" + GEOLOCATION_STORE_LIST_CLASS + "\": " + data + " }";
	}

	private StoreGeolocationList parseKnowwhereStoreLocationResponse(String data)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		StoreGeolocationList list = mapper.readValue(data,
				StoreGeolocationList.class);
		return list;
	}

	private String requestKnowwhereDataFromGeoService() throws Exception {
		try {
			Client client = Client.create();

			URIBuilder builder = new URIBuilder();
			builder.setScheme("http").setHost(KNOWWHERE_LOCATION_API_HOST)
					.setPort(KNOWWHERE_LOCATION_API_PORT)
					.setPath(KNOWWHERE_LOCATION_API_PATH)
					.setParameter(KNOWWHERE_LOCATION_API_QUERY_NAME, "1.1.1.1");
			URI url = builder.build();
			System.out.println("Accessing resource at " + url.toString());

			WebResource webResource = client.resource(url.toString());
			ClientResponse response = webResource.get(ClientResponse.class);
			if(response.getStatus() != HttpStatus.SC_OK) {
				throw new Exception("Geolocation Resource not found");
			}
			return response.getEntity(String.class);
		} catch (URISyntaxException e) {
			throw new Exception("Geolocation Resource not found");
		}
		//return "{\"statusCode\": \"0\", \"statusString\": \"Success\", \"count\": 2, \"locations\": [{\"KEY\":\"07980\", \"ADDR\":\"8000 Stream Walk Ln\", \"CITY\": \"Manassas\", \"STATE\":\"VA\", \"ZIP\": \"20109\"}, {\"KEY\":\"07922\", \"ADDR\":\"10275 North Fwy\", \"CITY\":\"Houston\", \"STATE\":\"TX\", \"ZIP\":\"77037\"} ]}";
	}

	public StoreGeolocationList createList() {
		// StoreGeolocation storeLoc1 = new StoreGeolocation("1234",
		// "123 Nowhere", "Parker", "CO", "80138");
		// StoreGeolocation storeLoc2 = new StoreGeolocation("12345",
		// "123 Right Here", "Pasdarker", "O", "12345");
		StoreGeolocation storeLoc1 = null;
		StoreGeolocation storeLoc2 = null;
		List<StoreGeolocation> storeList = new ArrayList<StoreGeolocation>();
		storeList.add(storeLoc1);
		storeList.add(storeLoc2);

		return new StoreGeolocationList("statuscode", "statusstring", "count",
				storeList);
	}

	public static void useXstream() {
		App a = new App();

		StoreGeolocationList listOut = a.createList();
		// XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		// XStream xstream = new XStream(new StaxDriver());

		// xstream.setMode(XStream.NO_REFERENCES);
		// xstream.alias("locations", List.class);
		// xstream.addImplicitCollection(StoreGeolocationList.class,
		// "locations");
		// xstream.alias("locations", StoreGeolocation.class);

		// xstream.addImplicitCollection(StoreGeolocationList.class,
		// "locations");
		// xstream.alias("locations", StoreGeolocation.class);
		// xstream.aliasField("KEY", StoreGeolocation.class, "KEY");
		xstream.alias("locationList", StoreGeolocationList.class);
		String data = (xstream.toXML(listOut));
		System.out.println(data);

		// String data =
		// a.surroundWithObjectDeclaration(a.requestKnowwhereDataFromGeoService());
		StoreGeolocationList list;
		XStream xstreamIn = new XStream(new JettisonMappedXmlDriver());
		// XStream xstreamIn = new XStream(new StaxDriver());
		// xstreamIn.addImplicitCollection(StoreGeolocationList.class,
		// "locations");
		// xstreamIn.alias("locations", StoreGeolocation.class);

		// xstreamIn.setMode(XStream.NO_REFERENCES);
		// xstreamIn.alias("locations", List.class);
		// xstreamIn.addImplicitCollection(StoreGeolocationList.class,
		// "locations");
		// xstreamIn.alias("locations", StoreGeolocation.class);
		xstreamIn.alias("locationList", StoreGeolocationList.class);

		StoreGeolocationList list2 = (StoreGeolocationList) xstreamIn
				.fromXML(data);
		System.out.println(list2);

		// StoreGeolocationList list;
		// HierarchicalStreamDriver driver = new JettisonMappedXmlDriver();
		// StringReader reader = new StringReader(data);
		// HierarchicalStreamReader hsr = driver.createReader(reader);
		// StringWriter writer = new StringWriter();
		// new HierarchicalStreamCopier().copy(hsr, new
		// PrettyPrintWriter(writer));
		// writer.close();
		// System.out.println(writer.toString());

	}

	public static void useJackson() throws JsonGenerationException,
			JsonMappingException, IOException {
		App a = new App();
		StoreGeolocationList listOut = a.createList();

		// output of Store object to json string
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(listOut);
		System.out.println(json);

		// input of Store object from json string
		StoreGeolocationList listIn = mapper.readValue(json,
				StoreGeolocationList.class);
		System.out.println(listIn);
	}

	public static void main(String[] args) throws Exception {
		// useJackson();
		// useXstream();
		App a = new App();
		StoreGeolocationList list = a.retrieveStoreListByCustomerIp();
		System.out.println(list);
	}
}
