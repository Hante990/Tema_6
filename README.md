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
  <li>2.-Runge-Kutta</li>
  <li>3.-Taylor</li>

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<h2 align = "center"> <font font face = "forte">  <a name="Lineal"> 1. Euler </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Euler es un método iterativo simple y rápido para resolver EDOs. Se basa en la aproximación de la pendiente en un punto y se utiliza para calcular el valor de la variable en el siguiente paso. El método de Euler es de orden 1, lo que significa que el error por paso es del orden de ℎ, donde ℎ es el tamaño del paso. Aunque es rápido, el método de Euler puede ser inestable y no es adecuado para problemas que requieren una alta precisión.   
<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

    /*
      * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
      * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
    */
    package Euler;

     /**
     *
     * @author alons
    */
      public class E1 {

     public static void main(String[] args) {
        // Ecuación diferencial: dy/dx = (x + y + xy)
        // Condiciones iniciales: y(0) = 1
        double x0 = 0, y0 = 1, x, y, h = 0.025, xEnd = 0.1;
        int n = (int)((xEnd - x0) / h);
        
        x = x0;
        y = y0;
        
        System.out.println("x\ty");
        System.out.println(x + "\t" + y);
        
        for (int i = 0; i < n; i++) {
            y = y + h * dydx(x, y);
            x = x + h;
            System.out.println(x + "\t" + y);
         }
       }
    
        public static double dydx(double x, double y) {
        return x + y + x * y;
          }
       }
![Screenshot 2024-05-28 232923](https://github.com/Hante990/Tema_6/assets/107586879/d2b28a67-3dcc-45b8-8880-0f6e404a1b89)

<h2 align = "center"> <font font face = "forte">  <a name="Cuadratica"> 2.- Runge-Kutta </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Runge-Kutta es un conjunto de métodos numéricos iterativos que se utilizan para resolver EDOs. Estos métodos se basan en la expansión de la función en serie de Taylor y se utilizan para calcular la pendiente en varios puntos dentro del intervalo de integración. El método de Runge-Kutta es de orden 𝑛, donde 𝑛 es el orden del método. Los métodos de Runge-Kutta son más precisos que el método de Euler y se utilizan ampliamente en problemas que requieren una alta precisión. El método de Runge-Kutta de orden 4 es especialmente popular debido a su buena precisión y estabilidad.
   
<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

    /*
      * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
      * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
    */
     package Rugen_Kutta;

    /**
    *
    * @author alons
    */
    public class E1 {
    public static void main(String[] args) {
        // Ecuación diferencial: dy/dx = x^2 - y
        // Condiciones iniciales: y(0) = 1
        double x0 = 0, y0 = 1, x, y, h = 0.025, xEnd = 0.1;
        int n = (int)((xEnd - x0) / h);
        
        x = x0;
        y = y0;
        
        System.out.println("x\ty");
        System.out.println(x + "\t" + y);
        
        for (int i = 0; i < n; i++) {
            double k1 = h * dydx(x, y);
            double k2 = h * dydx(x + 0.5 * h, y + 0.5 * k1);
            double k3 = h * dydx(x + 0.5 * h, y + 0.5 * k2);
            double k4 = h * dydx(x + h, y + k3);
            
            y = y + (k1 + 2*k2 + 2*k3 + k4) / 6;
            x = x + h;
            System.out.println(x + "\t" + y);
         }
       }
    
        public static double dydx(double x, double y) {
        return x * x - y;
          }
       }
 
![Screenshot 2024-05-28 233417](https://github.com/Hante990/Tema_6/assets/107586879/c9594910-de12-47a5-8109-85a09064a8d7)

<h2 align = "center"> <font font face = "forte"> <a name="Langrage">  3.- Taylor </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Taylor es una técnica para expandir una función en serie de Taylor, lo que permite aproximar la solución de una EDO. El método de Taylor se basa en la expansión de la función en serie de Taylor en torno a un punto y se utiliza para calcular la pendiente en ese punto. El método de Taylor es de orden 𝑛, donde 𝑛 es el orden de la expansión. Sin embargo, el método de Taylor no se utiliza comúnmente debido a que los métodos de Runge-Kutta de orden 𝑛 tienen la misma precisión que el método de Taylor de orden 𝑛, pero requieren menos evaluaciones de la función.
   
<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

     /*
       * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
       * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
     */
        package Taylor;

      /**
      *
      * @author alons
      */
         public class E1 {
         public static void main(String[] args) {
        // Ecuación diferencial: dy/dx = x^2 - y
        // Condiciones iniciales: y(0) = 1
        double x0 = 0, y0 = 1, x, y, h = 0.025, xEnd = 0.1;
        int n = (int)((xEnd - x0) / h);
        
        x = x0;
        y = y0;
        
        System.out.println("x\ty");
        System.out.println(x + "\t" + y);
        
        for (int i = 0; i < n; i++) {
            double k1 = h * dydx(x, y);
            double k2 = h * (dydx(x + h, y + k1));
            
            y = y + (k1 + k2) / 2;
            x = x + h;
            System.out.println(x + "\t" + y);
        }
    }
    
    public static double dydx(double x, double y) {
        return x * x - y;
     }
    }

![Screenshot 2024-05-28 233815](https://github.com/Hante990/Tema_6/assets/107586879/49668357-7db1-4707-a52e-1c704bc75cc7)
