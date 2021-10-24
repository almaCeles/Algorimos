
package regresionLineal;

import java.util.Scanner;



public class NewClass {
   
    
    public static void main(String[] args) {
        
        int n;
        double a [][];
        double b0 = 0, b1 = 0;
        Scanner sc=new Scanner(System.in);     
        NewClass clas=new NewClass ();
        int op;
        do{
        System.out.println(""
                + "1-ingresa valores    \n"
                + "2.-calcular b0, b1   \n"
                + "3.-predecir un valor \n"
        );
        op=sc.nextInt();
        
        switch(op){
            case 1:
                    System.out.println("cuantos pares datos ingresaras");
                    n= sc.nextInt();
                      a= new double[n][2];
                    for(int d=0; n>d ;d++ ){
                        System.out.println("ingresa los valores: (y) (x)"+ d);
                        a[d][0]=sc.nextDouble();
                        a[d][1]=sc.nextDouble();
                       System.out.println("--");
                    }
                    b0=clas.calcularBs(n, a)[0];
                    b1=clas.calcularBs(n, a)[1];
                break;
            case 2:
                
                 System.out.println("--------------------------");
                     System.out.println("b0= "+b0+ " b1="+ b1);
                  System.out.println("--------------------------");
                break;
                
            case 3:
                System.out.println("---predecir---");
                System.out.println("inrgesa el dato");
                double r=sc.nextDouble();
                
               System.out.println("--------------------------");
         
                  System.out.println("el valor predecido es: "+clas.predecir(b0,b1,r));
               System.out.println("--------------------------");
               break;
        }
        }while(op<4 );
    }
    
   
    public double [] calcularBs(int n, double  a[][]){
        ////
         double  xyy = 0, y = 0, x = 0, x22 = 0;
          double xy [],x2[];
          
          
    
           xy=new double[n];
           x2=new double[n];
           
           
           
         for(int d=0; n>d ;d++ ){
            y+=a[d][0];
            x+=a[d][1];
            xy[d]=a[d][1]*a[d][0];
            x2[d]=a[d][1]*a[d][1];
         }
         
         for(int d=0; n>d ;d++ ){
            xyy+=xy[d];
            x22+=x2[d];           
         } 
     ///////////
        double b []= new double  [2]; 
        
        b[0]=((x22*y)-(x*xyy))/((n*x22)-(Math.pow(x,2)));
        b[1]=((n*xyy)-(x*y))/((n*x22)-(Math.pow(x,2)));
          return b;
    }
    
    public double predecir(double B0, double B1, double r){
         double yy=B0+(B1*r);
        return yy;
    }
}
