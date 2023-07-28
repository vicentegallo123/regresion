
public class Main {

   
    public static void main(String[] args) {
         // vectores
        double sales[]= {651,762, 856,1063,1190,1298,1421,1440,1518};
        double advertising[]= {23,26,30,34,43,48,52,57,58};

        // crear objeto 
        srl s = new srl();

        double beta0 = 0, beta1 = 0;
        //conjunto de datos


        // calcular parámetros del model b0 y b1
        beta1 = s.calculateB1(sales, advertising);
        beta0 = s.calculateB0(sales, advertising, beta1);

        // desplegar ecuación de regresión
        s.regresion();

        // predicir las ventas en función de 70 millones invertidos en advertising
        s.predecir(70);

    }
    
}
