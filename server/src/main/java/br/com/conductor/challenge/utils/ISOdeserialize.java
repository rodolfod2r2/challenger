package br.com.conductor.challenge.utils;

import java.util.TreeMap;

public class ISOdeserialize {

    public static TreeMap<String, String> deserialize(String message) {

        TreeMap<String, String> stringTreeMap = new TreeMap<>();

        String withoutPipes = message.substring(1, message.length() - 1);

        String[] fields = withoutPipes.split("[|]");

        for (int i = 0; i < fields.length; i=i+2) {
            stringTreeMap.put(fields[i], fields[i+1]);
        }

        return stringTreeMap;
    }

}
