package es.impl;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInformation {
    List<List<String>> arrayValueMaps = new ArrayList<List<String>>();
    List<String> arrayFieldMap = new ArrayList<String>();
    List<Map<String, String>> jsonMaps = new ArrayList<Map<String, String>>();

    public void getUserFieldMap() {
        String[] userFieldMap;
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        File fileField = new File(classLoader.getResource("").getFile());

        try {
            BufferedReader rdField = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/csvFieldFilePackage/userInfoFieldFile.csv")));

            String lineField = rdField.readLine();
            userFieldMap = lineField.split(";");
            for (String s : userFieldMap) {
                arrayFieldMap.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void getUserValueMap() {
        String[] userValueMap;
        List<String> arrayValueMap;
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        File ValueField = new File(classLoader.getResource("csvValueFilePackage/userInfoValueFile.csv").getFile());
        try {
            BufferedReader rdValue = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/csvValueFilePackage/userInfoValueFile.csv")));
            String lineValue;
            while ((lineValue = rdValue.readLine()) != null) {
                userValueMap = lineValue.split(";");
                arrayValueMap = new ArrayList<String>();
                for (String s : userValueMap) {
                    arrayValueMap.add(s);
                }
                arrayValueMaps.add(arrayValueMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, String>>  mapFieldAndValue() {
        Map<String, String> jsonMap;

        for (List<String> l : arrayValueMaps) {
            int i = 0;
            jsonMap = new HashMap<String, String>();
            for (String ss : l) {
                jsonMap.put(arrayFieldMap.get(i), ss);
                i++;
            }
            jsonMaps.add(jsonMap);
        }
        return jsonMaps;
    }

}
