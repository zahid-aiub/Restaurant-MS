package com.workspaceit.utils;

import com.workspaceit.pojo.location.GeoLocation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dipanjal on 11/2/18
 **/
public class ApiUtils {

    public static final String GOOGLE_API_HASH_MAP_KEY = "google_api_url";
    public static final String NEARBY_API_HASH_MAP_KEY = "nearby_api_url";

//    private static final String GOOGLE_MAP_URL = "https://maps.google.com/maps?q=loc:<lat>,<lon>&z=<zoom>";
    private static final String GOOGLE_MAP_URL = "https://maps.google.com/maps?q=loc:<lat>,<lon>";
    private static final String NEARBY_LOCATION_API_URL = "/api/location/near/<radious>?latitude=<lat>&longitude=<lon>";

    public static Map getUrls(GeoLocation newLocation,Integer radious){
        Map urlmap = new HashMap();
        urlmap.put(GOOGLE_API_HASH_MAP_KEY,getGoogleMapApiUrl(newLocation));
        urlmap.put(NEARBY_API_HASH_MAP_KEY,getNearbyLocationApiUrl(newLocation, radious));
        return urlmap;
    }
    public static String getGoogleMapApiUrl(GeoLocation geoLocation){
        String googleMapUrl = GOOGLE_MAP_URL.replaceAll("<lat>",String.valueOf(geoLocation.getLatitude()))
                .replaceAll("<lon>",String.valueOf(geoLocation.getLongitude()));
        return googleMapUrl;
    }
    public static String getNearbyLocationApiUrl(GeoLocation geoLocation,Integer radious){
        String apiUrl = NEARBY_LOCATION_API_URL.replaceAll("<radious>",String.valueOf(radious))
                .replaceAll("<lat>",String.valueOf(geoLocation.getLatitude()))
                .replaceAll("<lon>",String.valueOf(geoLocation.getLongitude()));
        return apiUrl;
    }

}
