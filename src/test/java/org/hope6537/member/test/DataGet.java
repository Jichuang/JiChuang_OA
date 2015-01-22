package org.hope6537.member.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hope6537 on 2015/1/22.
 */
public class DataGet {

    private List<Integer> inputs;
    private List<Integer> outputs;

    public void getInput(Scanner scanner) {
        inputs = new ArrayList<>();
        int index = 0;
        while (scanner.hasNext()) {
            int res = scanner.nextInt();
            System.out.println(res);
            inputs.add(res);
        }
    }

    public boolean validateOutput(String outputRes) {
        outputs = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i = i + 2) {
            outputs.add(inputs.get(i) + inputs.get(i + 1));
        }
        String res = outputs.toString();
        if (res.equals(outputRes)) {
            return true;
        } else {
            return false;
        }
    }


}
