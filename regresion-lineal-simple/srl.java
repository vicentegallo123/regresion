
import java.lang.Math;

public class srl {
//variables a utilizar siendo que j PARA EL FOR
    private double beta0;
    private double beta1;
    private int j = 9;


    srl() {
        beta0 = 0;
        beta1 = 0;
    }


    // calcular B0,  parámetro del modelo SLR
    public double calculateB0(double[] vectorSales, double[] vectorAdvertising, double beta1) {

        beta0 = 0;// aquí se codifica el modelo matemático 

        double sumvX2 = 0;float sumvY2 = 0;double sumvXY = 0;double sumvX = 0;double sumvY = 0;


        for (int i = 0; i < j; i ++){

            beta0 =  sumvY * sumvX2 - sumvX * sumvXY/ j * sumvX2 - Math.pow(sumvX,2);

            sumvX = sumvX + vectorAdvertising[i];
            sumvY = sumvY + vectorSales[i];
            sumvXY = sumvXY + (vectorAdvertising[i] * vectorSales[i]);
            sumvX2 = sumvX2 + Math.pow(vectorAdvertising[i],2);
            sumvY2 = (float) (sumvY2 + Math.pow(vectorSales[i],2));
        }

        System.out.println( "sumatoria de X "+sumvX);
        System.out.println( "sumatoria de Y "+sumvY);
        System.out.println( "sumatoria de XY "+sumvXY);
        System.out.println( "sumatoria de X2 "+sumvX2);
        System.out.println( "sumatoria de Y2 "+sumvY2);




        beta0 =  (((sumvY*sumvX2)-(sumvX*sumvXY)))/((j*sumvX2)-(Math.pow(sumvX,2)));


        return beta0;
    }

    // calcular B1
    public double calculateB1(double[] vectorSales, double[] vectorAdvertising) {

        beta1 = 0;// aquí se codifica el modelo matemático construido en clase para B1



        double sumX2 = 0;
        float sumY2 = 0;
        double sumXY = 0;
        double sumX = 0;
        double sumY = 0;

        for (int i = 0; i < j; i++){



            sumX = sumX + vectorAdvertising[i];
            sumY = sumY + vectorSales[i];
            sumXY = sumXY + (vectorAdvertising[i] * vectorSales[i]);
            sumX2 = sumX2 + Math.pow(vectorAdvertising[i],2);
            sumY2 = (float) (sumY2 + Math.pow(vectorSales[i],2));

        }

        System.out.println( "sumatoria de X "+sumX);
        System.out.println( "sumatoria de Y "+sumY);
        System.out.println( "sumatoria de XY "+sumXY);
        System.out.println( "sumatoria de X2 "+sumX2);
        System.out.println( "sumatoria de Y2 "+sumY2);



        beta1 =  (((j*sumXY) -(sumY*sumX)))/(((j*sumX2)-(Math.pow(sumX,2))));



        return beta1;
    }

    // imprimir ecuación de regresión
    public void regresion() {

        System.out.println("\nSales =  " + beta0 + " + " + "\n Advertising= "+beta1);
    }

    // predicir ventas en función a un valor dado de advertising
    public void predecir(double advertising) {

        double sales = 0;

        sales = beta0 + (beta1 * advertising);

        System.out.println("\nDado el valor de advertsing: " + advertising + "\n las ventas predicidas son = " + sales);
    }
}
