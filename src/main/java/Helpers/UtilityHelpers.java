package Helpers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UtilityHelpers {

    public ArrayList<String> inputGeneratorAsString(String[] inputs) {
        return new ArrayList<String>(Arrays.asList(inputs));
    }

    public ArrayList<Integer> inputGeneratorAsInt(String[] inputs) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (String input :
                inputs) {
            integers.add(Integer.valueOf(input));
        }
        return integers;
    }

    public String sendGetRequestAndReturnInputsAsString(String endpoint) {
        OkHttpClient httpClient = new OkHttpClient();
        String url = String.format("https://adventofcode.com/2021/day/%s", endpoint);
        Request request = new Request.Builder()
                .url(url)
                .header("cookie", "_ga=GA1.2.156534575.1637310251; " +
                        "_gid=GA1.2.2091502339.1638358186; " +
                        "session=53616c7465645f5f29751ed43d4b79bc80010572435bc9a44ad3f5e57fafc7451849361a09e9f578e5f5f454154be2d5")
                .build();
        String inputsFromRequest = "";
        try {
            Response response = httpClient.newCall(request).execute();
            inputsFromRequest = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputsFromRequest;
    }

    public HashMap<String, String> convertInputsToMap(ArrayList<String> inputGeneratorAsString) {
        HashMap map = new HashMap();

        for (String input :
                inputGeneratorAsString) {
            String[] mapRecord = input.split(" ");
            map.put(mapRecord[0], mapRecord[1]);
        }
        return map;
    }

}
