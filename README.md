# Metodos_Numericos
Realizado por:
  <li>Diego Alonso Fernández Delagadillo</li>
 
<h2 align = "center"> <font color = "darkorange" size = "+6"  font face = "bauhaus 93">  Indice </font> </h2>
<header> <font color = "red" size="+1" font face = "aharoni">
                <nav class="navegacion">                   
     <li> <a href="#Descripcion"> Descripción </a> <br> </li>
                            <ul class="subindice"> 
                                <li> <a href="#Lineal"> Euler (4 ejemplos). </a> </li>
                                <li> <a href="#Cuadratica"> Runge-Kutta (4 ejemplos). </a> </li>
                                <li> <a href="#Langrage"> Taylor (4 ejemplos). </a> </li> 
                            </ul>
                    </ul>
                </nav>
            </font> </header>

<h2 align = "center"> <font font face = "forte">  <a name="Descricpcion"> Descripción </a></h2>
Los métodos de Euler, Taylor y Runge-Kutta son herramientas numéricas para resolver ecuaciones diferenciales. El método de Euler es simple pero puede ser inestable, el método de Taylor es preciso pero no se utiliza comúnmente, y el método de Runge-Kutta es preciso y estable, siendo especialmente popular el método de Runge-Kutta de orden 4.
  
Existen varios métodos para resolver ecuaciones diferenciales, cada uno con sus propias características y aplicaciones. Algunos de los más comunes son:
  <li>1.-Euler</li>
  <li>2.- Runge-Kutta</li>
  <li>3.-Taylor</li>

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<h2 align = "center"> <font font face = "forte">  <a name="Lineal"> 1. Euler </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Euler es un método iterativo simple y rápido para resolver EDOs. Se basa en la aproximación de la pendiente en un punto y se utiliza para calcular el valor de la variable en el siguiente paso. El método de Euler es de orden 1, lo que significa que el error por paso es del orden de ℎ, donde ℎ es el tamaño del paso. Aunque es rápido, el método de Euler puede ser inestable y no es adecuado para problemas que requieren una alta precisión.   
<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

    public class Ejercicio4 {
    public static double interpolate(double[] x, double[] y, double xTarget) {
        int n = x.length;
        double yTarget = 0;

        int i = 0;
        while (i < n - 1 && x[i] < xTarget) {
            i++;
        }

        if (i == 0) {
            yTarget = y[0];
        } else if (i == n - 1) {
            yTarget = y[n - 1];
        } else {
            double x0 = x[i - 1];
            double x1 = x[i];
            double y0 = y[i - 1];
            double y1 = y[i];

            double m = (y1 - y0) / (x1 - x0);
            double b = y0 - m * x0;
            yTarget = m * xTarget + b;
        }

        return yTarget;
    }

    public static void main(String[] args) {
    double[] x = {0.8, 1.6, 2.8, 3.2, 4.6};
    double[] y = {1.2, 3.2, 5.2, 7.2, 9.2};
    double xTarget = 2.0;
    double yTarget = interpolate(x, y, xTarget);
    System.out.println("El valor de y para x = " + xTarget + " es " + yTarget);
     }
    }

  ![Lineal](https://github.com/Hante990/Interpolaci-n2/assets/107586879/0037a026-e06c-45ce-8827-166931a2d22e)

<h2 align = "center"> <font font face = "forte">  <a name="Cuadratica"> 2.- Interpolación cuadratica </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

La interpolación cuadrática es una herramienta útil en la aproximación de funciones suaves y en la predicción de valores intermedios entre puntos conocidos. Sin embargo, es importante tener en cuenta que su uso debe ser cuidadoso para evitar problemas de sobreajuste y garantizar la validez de los resultados obtenidos.
   
<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

    public class Interpolacion_Cuadratica {

    public static void main(String[] args) {
        System.out.println("Solucion de ecuaciones cuadráticas");
        double a, b, c, x1, x2, producto, cuadrado, diferencia, raiz;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el coeficiente a");
        a = scanner.nextDouble();
        System.out.println("Ingresa el coeficiente b");
        b = scanner.nextDouble();
        System.out.println("Ingresa el coeficiente c");
        c = scanner.nextDouble();

        cuadrado = Math.pow(b, 2);
        producto = 4 * a * c;
        diferencia = cuadrado - producto;
        raiz = Math.sqrt(diferencia);

        x1 = (-b + raiz) / (2 * a);
        x2 = (-b - raiz) / (2 * a);

        System.out.println("La ecuacion es: " + a + "x^2 + " + b + "x + " + c + " = 0");
        System.out.println("Las raices son:");
        System.out.println("El valor de x1 es: " + x1);
        System.out.println("El valor de x2 es: " + x2);
      }
    } 
    
  ![Cua](https://github.com/Hante990/Interpolaci-n2/assets/107586879/88a62d83-01c4-421a-a441-54eec1a2f964)

<h2 align = "center"> <font font face = "forte"> <a name="Langrage">  3.- Interpolación langrage </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

La interpolación de Lagrange es una técnica fundamental en el campo de los métodos numéricos y es ampliamente utilizada en diversas áreas, como la aproximación de funciones, la predicción de valores intermedios y la resolución de problemas matemáticos y computacionales que requieren el ajuste preciso de curvas a datos conocidos.
   
<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

      public class Ejercicio5 {
        public static double interpolate(double[] x, double[] y, double xTarget) {
        double result = 0;

        for (int i = 0; i < x.length; i++) {
            double term = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    term = term * (xTarget - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        double[] x = {1.1, 2.2, 3.3, 4.4, 5.5};
    double[] y = {1.1, 3.1, 5.1, 7.1, 9.1};
    double xTarget = 4.5;

        double yTarget = interpolate(x, y, xTarget);

        System.out.println("El valor interpolado de y para x = " + xTarget + " es " + yTarget);
     }
    }

![langrage](https://github.com/Hante990/Interpolaci-n2/assets/107586879/dd6934bc-7890-444a-b38d-b6dcecd0ac99)
