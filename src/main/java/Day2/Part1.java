package Day2;

import Helpers.UtilityHelpers;

import java.util.ArrayList;

public class Part1 {

    public static void main(String[] args) throws Exception {
        UtilityHelpers utilityHelpers = new UtilityHelpers();
        Part1 part1 = new Part1();
        String endpoint = "2/input";
        String inputs = utilityHelpers.sendGetRequestAndReturnInputsAsString(endpoint);
        part1.solution(utilityHelpers.inputGeneratorAsString(inputs.split("\n")));
    }

    void solution(ArrayList<String> inputGeneratorAsString) throws Exception {
        int horizontalPosition = 0;
        int depthPosition = 0;
        int aim = 0;

        for (String keyValueInput :
                inputGeneratorAsString) {
            String[] inputs = keyValueInput.split(" ");

            int positionChangerValue = Integer.parseInt(inputs[1]);
            switch (inputs[0]) {
                case "forward":
                    if (aim !=0) {
                        horizontalPosition = horizontalPosition + positionChangerValue;
                        depthPosition = depthPosition + aim*positionChangerValue;
                    } else horizontalPosition = horizontalPosition + positionChangerValue;
                    break;
                case "down":
                    //depthPosition = depthPosition + positionChangerValue;
                    aim = aim + positionChangerValue;
                    break;
                case "up":
                    //depthPosition = depthPosition - positionChangerValue;
                    aim = aim - positionChangerValue;
                    break;
                default:
                    throw new Exception("The value of key is not correct: " + inputs[0]);
            }
        }
        System.out.println("Result is for PART 2 is " + horizontalPosition * depthPosition);
    }

    static String something= "forward 5\n" +
            "down 5\n" +
            "forward 8\n" +
            "up 3\n" +
            "down 8\n" +
            "forward 2";


}
