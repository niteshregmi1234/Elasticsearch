package es.api;

import java.util.List;
import java.util.Map;

public interface Elastic {
    public void addToElasticSearch(List<Map<String, String>> jsonMaps);


}
