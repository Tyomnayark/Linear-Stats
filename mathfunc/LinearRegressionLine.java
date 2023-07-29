package mathfunc;

import java.util.ArrayList;
import java.util.Locale;

public class LinearRegressionLine {
    public static void getValue(ArrayList<Double> listX, ArrayList<Double> listY) {
        double averageX = Average.getValue(listX);
        double averageY = Average.getValue(listY);

        double xy = 0;
        double xSquared = 0;
        for (int i = 0; i < listX.size(); i++) {
            xy += listX.get(i) * listY.get(i);
            xSquared += Math.pow(listX.get(i), 2);
        }

        int n = listX.size();
        double sumX = listX.stream().mapToDouble(Double::doubleValue).sum();
        double sumY = listY.stream().mapToDouble(Double::doubleValue).sum();

        double m = (n * xy - sumX * sumY) / (n * xSquared - Math.pow(sumX, 2));
        double b = (sumY - m * sumX) / n;

        System.out.printf(Locale.ENGLISH, "Linear Regression Line: y = %fx + %f\n", m, b);
    }

}
