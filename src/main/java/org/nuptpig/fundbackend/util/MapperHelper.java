package org.nuptpig.fundbackend.util;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperHelper {
    public static <FROM, TO> TO SourceToDestination(FROM source, Class<TO> destinationClass){
        return new ModelMapper().map(source, destinationClass);
    }

    public static <FROM, TO> List<TO> SourcesToDestinations(List<FROM> sources, Class<TO> destinationClass){
        List<TO> destinations = new ArrayList<>();
        for(FROM source: sources){
            destinations.add(SourceToDestination(source, destinationClass));
        }
        return destinations;
    }
}
