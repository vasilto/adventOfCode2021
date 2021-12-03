package Day1;

import Helpers.UtilityHelpers;
import Inputs.Inputs;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Part2 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        Part2 part2 = new Part2();
        UtilityHelpers utilityHelpers = new UtilityHelpers();


        int result = part1.solution(part2.createNewComparingGroups(utilityHelpers.inputGeneratorAsInt(inputs)));
        System.out.println(result);

        System.out.println(part2.sendGetRequestAndReturnInputsAsString("1/input"));
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
    
    ArrayList<Integer> createNewComparingGroups(ArrayList<Integer> inputs) {
        int startingIndex = 0;

        Iterator<Integer> iterator = inputs.iterator();
        ArrayList<Integer> newComparingGroups = new ArrayList<>();
        Integer sum = 0;
        while (startingIndex + 2 != inputs.size()) {
            for (int i = startingIndex; i < startingIndex+3; i++) {
                sum = sum + inputs.get(i);
            }
            newComparingGroups.add(sum);
            startingIndex++;
            sum = 0;
        }

        return newComparingGroups;
    }

    static String[] inputs = Inputs.day1.split("\n");

}
