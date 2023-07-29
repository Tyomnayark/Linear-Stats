package mathfunc;

import java.util.ArrayList;
import java.util.Locale;

public class PearsonCorrelationCoefficient {
    public static void getValue(ArrayList<Double> listX, ArrayList<Double> listY) {
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumXSquare = 0;
        double sumYSquare = 0;

        int n = listX.size();

        for (int i = 0; i < n; i++) {
            double x = listX.get(i);
            double y = listY.get(i);

            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumXSquare += x * x;
            sumYSquare += y * y;
        }

        double numerator = n * sumXY - sumX * sumY;
        double denominator = Math.sqrt((n * sumXSquare - sumX * sumX) * (n * sumYSquare - sumY * sumY));

        if (denominator == 0) {
            throw new ArithmeticException("Denominator is zero. Pearson correlation coefficient is undefined.");
        }

        double correlationCoefficient = numerator / denominator;
        System.out.printf(Locale.ENGLISH, "Pearson Correlation Coefficient: %.10f\n", correlationCoefficient);
    }
}
