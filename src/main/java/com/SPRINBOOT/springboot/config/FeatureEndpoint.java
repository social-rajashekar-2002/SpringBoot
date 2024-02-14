package com.SPRINBOOT.springboot.config;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id="features")
public class FeatureEndpoint {

    private final Map<String,Feature>featureMap=new ConcurrentHashMap<>();


    public FeatureEndpoint(){
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Auth", new Feature(false));
    }

    @ReadOperation
    public Map<String,Feature>fetaures(){
        return featureMap;
    }

    @ReadOperation
    public Feature feat(@Selector String FeatureName){
        return featureMap.get(FeatureName);
    }


    

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Feature{
        private boolean isEnabled;
    }
}
