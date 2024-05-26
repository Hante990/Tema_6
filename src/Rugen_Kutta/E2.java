/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Rugen_Kutta;

/**
 *
 * @author alons
 */
public class E2 {
public static void main(String[] args) {
        // Ecuación diferencial: dy/dx = 2x - y
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
        return 2 * x - y;
    }
}