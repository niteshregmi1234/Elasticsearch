package util;




import org.elasticsearch.client.Client;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;


import java.net.InetAddress;
import java.util.Optional;


public class EsManager {
    public Optional<Client> getClient(String host, int port){
        try {

            Settings setting=Settings.builder().put("cluster.name","elasticsearch").build();

               Client  client = TransportClient.builder().settings(setting).build()
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));

                    System.out.println(new java.util.Date()+":Elastic search connected ");
                    return Optional.of(client);




        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }


    }
}
