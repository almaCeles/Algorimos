
package regresionLineal;

import java.util.Scanner;



public class NewClass {
    static int n;
    static double B0, B1, xyy, y , x, x22, yy,r;
    static double a [][];
    static  double xy [],x2[];
    
    public static void main(String[] args) {
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
                    xy=new double[n];
                    x2=new double[n];
                    for(int d=0; n>d ;d++ ){
                        System.out.println("ingresa los valores: (y) (x)"+ d);
                        a[d][0]=sc.nextDouble();
                        a[d][1]=sc.nextDouble();
                       System.out.println("--");
                    }
                    clas.calcularVariables();
                break;
            case 2:
                clas.calcularB();
                break;
                
            case 3:
                System.out.println("---predecir---");
                System.out.println("inrgesa el dato");
                r=sc.nextDouble();
                clas.predecir();
               break;
        }
        }while(op<4 );
    }
    
   
    public void calcularVariables(){
         for(int d=0; n>d ;d++ ){
            y+=a[d][0];
            x+=a[d][1];
            xy[d]=a[d][1]*a[d][0];
            x2[d]=a[d][1]*a[d][1];
         }
     /*     System.out.println("--------------------------");
         System.out.println(""
                 + "y="+y+"\n"+
                 "x="+x+"\n");*/
         
         for(int d=0; n>d ;d++ ){
            xyy+=xy[d];
            x22+=x2[d];           
         }
         /*    System.out.println(""
                 + "xy="+xyy+"\n"+
                 "x2="+x22+"\n");
               System.out.println("--------------------------");*/
    }
    public void calcularB(){
        B0= ((x22*y)-(x*xyy))/((n*x22)-(Math.pow(x,2)));
        B1= ((n*xyy)-(x*y))/((n*x22)-(Math.pow(x,2)));
        System.out.println("--------------------------");
        System.out.println("b0= "+B0+ " b1="+ B1);
        System.out.println("--------------------------");
            
    }
    public void predecir(){
        System.out.println("--------------------------");
        yy=B0+(B1*r);
        System.out.println("el valor predecido es: "+yy);
        System.out.println("--------------------------");
        
    }
}
