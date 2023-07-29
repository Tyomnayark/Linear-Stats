package mathfunc;

import java.util.ArrayList;

public class Average {
    public static double getValue(ArrayList<Double> integerArrayList) {
        double average = integerArrayList.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
        return average;
    }
}
