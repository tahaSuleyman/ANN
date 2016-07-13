/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ann;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author tahasuleymankahraman
 */
public class MLP {
    static HashMap<Integer,Double[]> Map;
    static Double[] X = new Double [15];
    static Double[] W1 = new Double[8];
    static Double[] W2 = new Double[8];
    static Double[] W3 = new Double[8];
    static Double[] W4 = new Double[8];
    static Double[] W5 = new Double[8];
    static Double[] W6 = new Double[8];
    static Double[] W7 = new Double[8];
    static Double[] W8 = new Double[8];
    static Double[] W9 = new Double[8];
    static Double[] W10 = new Double[8];
    static Double[] W11= new Double[8];
    static Double[] W12= new Double[8];
    static Double[] W13= new Double[8];
    static Double[] W14= new Double[8];
    static Double[] W15= new Double[8];
    static Double[] Ij= new Double[9];
    static Double[] Oj=new Double[9];
    static Double[] Er= new Double[440];
    static Double[][] Herr = new Double[440][8];
    static Double[][] Houtput = new Double[440][8];
    static Double[] Wout=new Double[8]; 
    static Double[] RMSE = new Double[5];
                 static Double[] Day1 = new Double [440];
                 static Double[] Day2 = new Double [440];
                 static Double[] Day3 = new Double [440];
                 static Double[] Day4 = new Double [440];
                 static Double[] Day5 = new Double [440];
                 static Double[] Day6 = new Double [440];
                 static Double[] Day7 = new Double [440];
                 static Double[] FFMC = new Double [440];
                 static Double[] DNC= new Double [440];
                 static Double[] DC= new Double [440];
                 static Double[] ISI= new Double [440];
                 static Double[] TEMP= new Double [440];
                 static Double[] RH= new Double [440];
                 static Double[] Wind= new Double [440];
                 static Double[] Rain= new Double [440];
                 static Double[] Area= new Double [440];
                 static int count=0;
                 static Double res=0.0;
    /**
     *
     * @param args
     */
    public static void main(String[] args){
    
        MLP(1000,15.5);
    
    
    }
    public static void WRandomizer(){
        Map=DataProvider.FF();
        for(int i =0;i<8;i++){
            W1[i]=Math.random()-0.5;
            W2[i]=Math.random()-0.5;
            W3[i]=Math.random()-0.5;
            W4[i]=Math.random()-0.5;
            W5[i]=Math.random()-0.5;
            W6[i]=Math.random()-0.5;
            W7[i]=Math.random()-0.5;
            W8[i]=Math.random()-0.5;
            W9[i]=Math.random()-0.5;
            W10[i]=Math.random()-0.5;
            W11[i]=Math.random()-0.5;
            W12[i]=Math.random()-0.5;
            W13[i]=Math.random()-0.5;
            W14[i]=Math.random()-0.5;
            W15[i]=Math.random()-0.5;
            Wout[i]=Math.random()-0.5;
        }
        
        Day1=Map.get(0);
        Day2=Map.get(1);
        Day3=Map.get(2);
        Day4=Map.get(3);
        Day5=Map.get(4);
        Day6=Map.get(5);
        Day7=Map.get(6);
        FFMC=Map.get(7);
        DNC =Map.get(8);
        DC  =Map.get(9);
        ISI =Map.get(10);
        TEMP=Map.get(11);
        RH  =Map.get(12);
        Wind=Map.get(13);
        Rain=Map.get(14);
        Area=Map.get(15);
    }
    
    public static void MLP(int epoch,Double Lr){
        WRandomizer();
        int K=0,k=0;
        for(int i=0;i<5;i++){
            for(int e=0; e<epoch;e++){
            train(k,K);
            Wupdate(k,Lr);
            
        }
            
            test(k);
            K+=88;
            k+=1;
            
            Ij= new Double[9];
            Oj=new Double[9];
            Er= new Double[440];
            Herr = new Double[440][8];
            Houtput = new Double[440][8];
        }
        
    for(int i=0;i<5;i++){
    res+=RMSE[i];
    System.out.println(RMSE[i]);
    }
    System.out.println((res/5));
    
    
    }
    
    public static void test(int k){
        
        Double mse=0.0;
        for(int i =k*88;i<k*88+88;i++){
            
            X[0]=Day1[i];X[1]=Day2[i];
            X[2]=Day3[i];X[3]=Day4[i];
            X[4]=Day5[i];X[5]=Day6[i];
            X[6]=Day7[i];X[7]=FFMC[i];
            X[8]=DNC[i];X[9]=DC[i];
            X[10]=ISI[i];X[11]=TEMP[i];
            X[12]=RH[i];X[13]=Wind[i];
            X[14]=Rain[i];
            for(int j = 0;j<8;j++){
            in(j);
            out(j);
            }
            Ij[8]=(Oj[0]*Wout[0])+(Oj[1]*Wout[1])+(Oj[2]*Wout[2])+(Oj[3]*Wout[3])+(Oj[4]*Wout[4])+(Oj[5]*Wout[5])+(Oj[6]*Wout[6])+(Oj[7]*Wout[7]);
            out(8);
            
            mse+=(Area[i]-Oj[8])*(Area[i]-Oj[8]);
            
        }
        RMSE[count]=Math.sqrt((mse/88));
        count++;
    }
    public static void train(int k,int K){
        
        for(int i = 0;i<440;i++){
            if(i==k*88 &&k!=4){
                i+=88;
            }
            if(i==k*88 && k==4){
                break;
            }
            X[0]=Day1[i];X[1]=Day2[i];
            X[2]=Day3[i];X[3]=Day4[i];
            X[4]=Day5[i];X[5]=Day6[i];
            X[6]=Day7[i];X[7]=FFMC[i];
            X[8]=DNC[i];X[9]=DC[i];
            X[10]=ISI[i];X[11]=TEMP[i];
            X[12]=RH[i];X[13]=Wind[i];
            X[14]=Rain[i];
            for(int j=0;j<8;j++){
                in(j);
                out(j);
              Houtput[i][j]=Oj[j];
            }
            Ij[8]=(Oj[0]*Wout[0])+(Oj[1]*Wout[1])+(Oj[2]*Wout[2])+(Oj[3]*Wout[3])+(Oj[4]*Wout[4])+(Oj[5]*Wout[5])+(Oj[6]*Wout[6])+(Oj[7]*Wout[7]);
            out(8);
            Err(i);
            Herr(i,k);
        }
            

    }
    public static void in(int j){
        
        Ij[j]=(W1[j]*X[0])+(W2[j]*X[1])+(W3[j]*X[2])+(W4[j]*X[3])+(W5[j]*X[4])+(W6[j]*X[5])+(W7[j]*X[6])+(W8[j]*X[7])+(W9[j]*X[8])+(W10[j]*X[9])+(W11[j]*X[10])+(W12[j]*X[11])+(W13[j]*X[12])+(W14[j]*X[13])+(W15[j]*X[14]);
    
    
    }
    
    public static void out(int j){
    
        Double ex=Ij[j]*(-1);
        Oj[j]=1/(1+(Math.pow(2.718, ex)));
        
    
    
    
    }
    public static void Err(int j){
    
    Er[j]=Oj[8]*(1-Oj[8])*(Area[j]-Oj[8]);
    
    
    
    }
    public static void Herr(int k,int a){
        
        for(int i =0;i<8;i++){
        Herr[k][i]=Oj[i]*(1-Oj[i]*Er[k]*Wout[i]);
        //TODO: CHECK DEĞERLER
        }
        
        
    
    
    }
    
    public static void Wupdate(int e,Double Lr){
        int r=0;
        Random rnd= new Random();
        
        if(e==0){
        r=rnd.nextInt(352);
        r+=88;
        }
        
        if(e==1){
        r=rnd.nextInt(2);
            if(r==1){
            r=rnd.nextInt(88);
            }
            if(r==0){
            r=rnd.nextInt(264);
            r+=176;
            }
        }
        if(e==2){
        r=rnd.nextInt(2);
            if(r==1){
            r=rnd.nextInt(176);
            }
            if(r==0){
            r=rnd.nextInt(176);
            r+=264;
            }
        //0-175 / 264-440
        }
        if(e==3){
            r=rnd.nextInt(2);
            if(r==1){
                r=rnd.nextInt(264);
        }
            if(r==0){
                r=rnd.nextInt(88);
                r+=352;
            }
        //0-263 / 352-440
        }
        if(e==4){
            r=rnd.nextInt(352);
        //0-351
        }
        for(int i=0;i<8;i++){
        Wout[i]=Wout[i]+((Lr)*(Er[r])*(Houtput[r][i]));
                
                }
        for(int i=0;i<8;i++){
        W1[i]=W1[i]+((Lr)*(Herr[r][i])*(X[0]));
        }
        for(int i=0;i<8;i++){
        W2[i]=W2[i]+((Lr)*(Herr[r][i])*(X[1]));
        }
        for(int i=0;i<8;i++){
        W3[i]=W3[i]+((Lr)*(Herr[r][i])*(X[2]));
        }
        for(int i=0;i<8;i++){
        W4[i]=W4[i]+((Lr)*(Herr[r][i])*(X[3]));
        }
        for(int i=0;i<8;i++){
        W5[i]=W5[i]+((Lr)*(Herr[r][i])*(X[4]));
        }
        for(int i=0;i<8;i++){
        W6[i]=W6[i]+((Lr)*(Herr[r][i])*(X[5]));
        }
        for(int i=0;i<8;i++){
        W7[i]=W7[i]+((Lr)*(Herr[r][i])*(X[6]));
        }
        for(int i=0;i<8;i++){
        W8[i]=W8[i]+((Lr)*(Herr[r][i])*(X[7]));
        }
        for(int i=0;i<8;i++){
        W9[i]=W9[i]+((Lr)*(Herr[r][i])*(X[8]));
        }
        for(int i=0;i<8;i++){
        W10[i]=W10[i]+((Lr)*(Herr[r][i])*(X[9]));
        }
        for(int i=0;i<8;i++){
        W11[i]=W11[i]+((Lr)*(Herr[r][i])*(X[10]));
        }
        for(int i=0;i<8;i++){
        W12[i]=W12[i]+((Lr)*(Herr[r][i])*(X[11]));
        }
        for(int i=0;i<8;i++){
        W13[i]=W13[i]+((Lr)*(Herr[r][i])*(X[12]));
        }
        for(int i=0;i<8;i++){
        W14[i]=W14[i]+((Lr)*(Herr[r][i])*(X[13]));
        }
        for(int i=0;i<8;i++){
        W15[i]=W15[i]+((Lr)*(Herr[r][i])*(X[14]));
        }
    
    }
    
    
    public static void Pweight(){
    for(int i =0;i<8;i++){
             System.out.println("W1"+i+" "+W1[i]);
            System.out.println("W2"+i+" "+W2[i]);
            System.out.println("W3"+i+" "+W3[i]);
            System.out.println("W4"+i+" "+W4[i]);
            System.out.println("W5"+i+" "+W5[i]);
            System.out.println("W6"+i+" "+W6[i]);
            System.out.println("W7"+i+" "+W7[i]);
            System.out.println("W8"+i+" "+W8[i]);
            System.out.println("W9"+i+" "+W9[i]);
            System.out.println("W10"+i+" "+W10[i]);
            System.out.println("W11"+i+" "+W11[i]);
            System.out.println("W12"+i+" "+W12[i]);
            System.out.println("W13"+i+" "+W13[i]);
            System.out.println("W14"+i+" "+W14[i]);
            System.out.println("W15"+i+" "+W15[i]);
            System.out.println("W"+24+" "+Wout[i]);
        }
        
    }
}  