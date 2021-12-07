package chapter13;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Problem8 {

    List<Integer> getRandomSubset(List<Integer> list) {
        Random rand = new Random();
        return list.stream().filter(item -> rand.nextBoolean()).collect(Collectors.toList());
    }
}
