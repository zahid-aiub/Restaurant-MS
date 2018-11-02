package com.workspaceit.controller.api;

import com.workspaceit.contents.URLPrefix;
import com.workspaceit.helper.LocationHelper;
import com.workspaceit.pojo.location.GeoLocation;
import com.workspaceit.pojo.wraper.ApiStatus;
import com.workspaceit.utils.ApiUtils;
import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = URLPrefix.API+"/location")
public class GeoLocationController {

    @CrossOrigin
    @RequestMapping(value = "/near/{radious}")
    public ApiStatus findNearbyLocation(@PathVariable("radious") Integer radious,GeoLocation geoLocation){
        int apiStatus = HttpStatus.SC_OK;
        String message = "OK";

        Map map = new HashMap();
        try{
            if(geoLocation==null || radious==null){
                return new ApiStatus(HttpStatus.SC_BAD_REQUEST,"Bad Request",null);
            }
            GeoLocation nearbyLocation = LocationHelper.getNearbyLocation(geoLocation,radious);
            map.put("nearby_location",nearbyLocation);
            map.put("api_urls",ApiUtils.getUrls(nearbyLocation,radious));
        }catch (Exception e){
            e.printStackTrace();
            apiStatus = HttpStatus.SC_BAD_REQUEST;
            message = e.getMessage();
        }
        return new ApiStatus(apiStatus,message,map);
    }
}
