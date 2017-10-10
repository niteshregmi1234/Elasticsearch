package es;



import es.impl.UserInformation;
import util.AddToEs;

import java.io.IOException;



public class App {
//   private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        UserInformation userInformation =new UserInformation();
        userInformation.getUserFieldMap();
        userInformation.getUserValueMap();
        new AddToEs().addToElasticSearch(userInformation.mapFieldAndValue());


    }
}
