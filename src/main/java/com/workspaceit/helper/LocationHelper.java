package com.workspaceit.helper;

import com.workspaceit.pojo.location.GeoLocation;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class LocationHelper {

    private static Float METERS_IN_DEGREES = 111300f;

    public static GeoLocation getNearbyLocation(GeoLocation location, Integer radius){
        if(location==null || radius==null){
            return null;
        }
        Random random = new Random();
        // Convert radius from meters to degrees
        double radiusInDegrees = radius / METERS_IN_DEGREES;

        double x0 = location.getLongitude() ; //* 1E6;
        double y0 = location.getLatitude() ; //* 1E6;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(Math.toRadians(y0));

        double foundLongitude = new_x + x0;
        double foundLatitude = y + y0;
        System.out.println("{Latitude: " + foundLongitude + ",  Longitude: " + foundLatitude+"}" );
        System.out.println(foundLatitude + "," + foundLongitude);
        return new GeoLocation(foundLatitude,foundLongitude);
    }

}
