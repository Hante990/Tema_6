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