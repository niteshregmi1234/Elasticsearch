package util;

import es.api.Elastic;
import org.apache.log4j.BasicConfigurator;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import java.util.List;
import java.util.Map;

public class AddToEs implements Elastic {

        public void addToElasticSearch(List<Map<String, String>> jsonMaps) {

            BasicConfigurator.configure();
            EsManager esManager = new EsManager();
            Client client = esManager.getClient("localhost", 9300).get();
            for (Map<String, String> sss : jsonMaps) {
                IndexResponse response = client.prepareIndex("user", "UserMapping", sss.get("uniqueId"))
                        .setSource(sss)
                        .get();

        }
    }
}
