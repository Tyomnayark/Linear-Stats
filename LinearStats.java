import mathfunc.*;

import java.io.*;
import java.util.ArrayList;


public class LinearStats {
    public static void main(String[] args) {
        String fileName = args[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            if (!fileName.endsWith(".txt")) {
                throw new FileNotFoundException();
            }

            ArrayList<Double> doubleArrayListY = new ArrayList<>();
            ArrayList<Double> doubleArrayListX = new ArrayList<>();
            String buffer = null;
            int counter = 0;

            while (bufferedReader.ready()) {
                buffer = bufferedReader.readLine();
                if (buffer.length() != 0) {
                    doubleArrayListX.add(Double.valueOf(counter));
                    doubleArrayListY.add(Double.parseDouble(buffer));
                    counter++;
                }
            }
            if (doubleArrayListY.size() == 0) {
                System.out.println("FILE IS EMPTY\nPLEASE FILL THE FILE");
                throw new IOException();
            }

            LinearRegressionLine.getValue(doubleArrayListX, doubleArrayListY);
            PearsonCorrelationCoefficient.getValue(doubleArrayListX, doubleArrayListY);

        } catch (NumberFormatException exc) {
            System.out.println("THE FILE CONTAINS ILLEGAL SYMBOLS");
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("PLEASE ENTER THE FILE NAME LIKE \"data.txt\"");
        } catch (FileNotFoundException e) {
            if (!args[0].endsWith(".txt")) {
                System.out.println("WRONG FORMAT - " + fileName.substring(fileName.indexOf("."), fileName.length()));
            }
            System.out.println("FILE \"" + args[0] + "\" NOT FOUND");

        } catch (IOException e) {
            System.out.println();
        }
    }
}
