package com.workspaceit.controller.api;

import com.workspaceit.contents.URLPrefix;
import com.workspaceit.helper.LocationHelper;
import com.workspaceit.pojo.location.GeoLocation;
import com.workspaceit.pojo.wraper.ApiStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = URLPrefix.API+"/location")
public class GeoLocationController {

    @CrossOrigin
    @RequestMapping(value = "/near/{radious}")
    public ApiStatus findNearbyLocation(@PathVariable("radious") Integer radious,
                                        @RequestParam( value = "latitude") double latitude,
                                        @RequestParam(value = "longitude") double longditude){
        GeoLocation nearbyLocation = LocationHelper.getNearbyLocation(new GeoLocation(latitude,longditude),radious);
        Map map = new HashMap();
        map.put("nearbyLocation",nearbyLocation);
        map.put("URLS","http://test.com");
        return new ApiStatus(200,"OK",map);
    }
}
