package Day1;
import Helpers.UtilityHelpers;
import Inputs.Inputs;

import java.util.*;

public class Part1 {

    public static void main(String[] args){
        UtilityHelpers helpers = new UtilityHelpers();
        Part1 part1 = new Part1();

        System.out.println(part1.solution(helpers.inputGeneratorAsInt(part1.inputs)));
    }

    public Integer solution(ArrayList<Integer> inputs){
        boolean isItFirst = true;
        Integer increased = 0;
        Integer decreased = 0;

        int previous = 0;
        int current = 0;

        for (Integer input:
             inputs) {
            if (isItFirst) {
                previous = input;
                isItFirst=false;
                continue;
            }
            current = input;

            if (current>previous) {
                increased++;
            } else decreased++;

            previous=current;
        }
        return increased;
    }

    String[] inputs = Inputs.day1.split("\n");
}
