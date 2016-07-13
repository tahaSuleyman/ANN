/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ann;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author tahasuleymankahraman
 */
public class DataProvider {
    public static void main(String[] args){
    
    }
    public static HashMap<Integer,Double[]>FF(){
    BufferedReader br = null;
    ArrayList<String> FF= new ArrayList<>();
    HashMap<Integer,Double[]> hm = new HashMap<>();
                    String[] part;
                    Double[] Day1 = new Double [440];
                    Double[] Day2 = new Double [440];
                    Double[] Day3 = new Double [440];
                    Double[] Day4 = new Double [440];
                    Double[] Day5 = new Double [440];
                    Double[] Day6 = new Double [440];
                    Double[] Day7 = new Double [440];
                    Double[] FFMC = new Double [440];
                    Double[] DNC= new Double [440];
                    Double[] DC= new Double [440];
                    Double[] ISI= new Double [440];
                    Double[] TEMP= new Double [440];
                    Double[] RH= new Double [440];
                    Double[] Wind= new Double [440];
                    Double[] Rain= new Double [440];
                    Double[] Area= new Double [440];
                Double min1,max1,min2,max2,min3,max3,min4,max4,min5,max5,min6,max6,min7,max7,min8,max8,min9,max9;
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("src/ann/FF.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
                            FF.add(sCurrentLine);}
                        
                       for(int i =0 ; i<440;i++){
                       part = FF.get(i).split(",");
                            if(null != part[0])switch (part[0]) {
                                case "mon":
                                    Day1[i]=1.0;
                                    Day2[i]=0.0;
                                    Day3[i]=0.0;
                                    Day4[i]=0.0;
                                    Day5[i]=0.0;
                                    Day6[i]=0.0;
                                    Day7[i]=0.0;
                                    break;
                                case "tue":
                                    Day1[i]=0.0;
                                    Day2[i]=1.0;
                                    Day3[i]=0.0;
                                    Day4[i]=0.0;
                                    Day5[i]=0.0;
                                    Day6[i]=0.0;
                                    Day7[i]=0.0;
                                    break;
                                case "wed":
                                    Day1[i]=0.0;
                                    Day2[i]=0.0;
                                    Day3[i]=1.0;
                                    Day4[i]=0.0;
                                    Day5[i]=0.0;
                                    Day6[i]=0.0;
                                    Day7[i]=0.0;
                                    break;
                                case "thu":
                                    Day1[i]=0.0;
                                    Day2[i]=0.0;
                                    Day3[i]=0.0;
                                    Day4[i]=1.0;
                                    Day5[i]=0.0;
                                    Day6[i]=0.0;
                                    Day7[i]=0.0;
                                    break;
                                case "fri":
                                    Day1[i]=0.0;
                                    Day2[i]=0.0;
                                    Day3[i]=0.0;
                                    Day4[i]=0.0;
                                    Day5[i]=1.0;
                                    Day6[i]=0.0;
                                    Day7[i]=0.0;
                                    break;
                                case "sat":
                                    Day1[i]=0.0;
                                    Day2[i]=0.0;
                                    Day3[i]=0.0;
                                    Day4[i]=0.0;
                                    Day5[i]=0.0;
                                    Day6[i]=1.0;
                                    Day7[i]=0.0;
                                    break;
                                case "sun":
                                    Day1[i]=0.0;
                                    Day2[i]=0.0;
                                    Day3[i]=0.0;
                                    Day4[i]=0.0;
                                    Day5[i]=0.0;
                                    Day6[i]=0.0;
                                    Day7[i]=1.0;
                                    break;
                                default:
                                    break;
                            }
                            FFMC[i]=Double.parseDouble(part[1]);
                            DNC[i] =Double.parseDouble(part[2]);
                            DC[i] =Double.parseDouble(part[3]);
                            ISI[i] =Double.parseDouble(part[4]);
                            TEMP[i]=Double.parseDouble(part[5]);
                            RH[i]=Double.parseDouble(part[6]);
                            Wind[i]=Double.parseDouble(part[7]);
                            Rain[i]=Double.parseDouble(part[8]);
                            Area[i]=Double.parseDouble(part[9]);
                       }
                       
                       max1=max(FFMC);
                       min1=min(FFMC);
                       max2=max(DNC);
                       min2=min(DNC);
                       max3=max(DC);
                       min3=min(DC);
                       max4=max(ISI);
                       min4=min(ISI);
                       max5=max(TEMP);
                       min5=min(TEMP);
                       max6=max(RH);
                       min6=min(RH);
                       max7=max(Wind);
                       min7=min(Wind);
                       max8=max(Rain);
                       min8=min(Rain);
                       max9=max(Area);
                       min9=min(Area);
                       
                       for(int i =0;i<440;i++){
                       FFMC[i]=norm(FFMC[i],min1,max1);
                       DNC[i]= norm(DNC[i],min2,max2);
                       DC[i]= norm(DC[i],min3,max3);
                       ISI[i]= norm(ISI[i],min4,max4);
                       TEMP[i]= norm(TEMP[i],min5,max5);
                       RH[i]= norm(RH[i],min6,max6);
                       Wind[i]= norm(Wind[i],min7,max7);
                       Rain[i]= norm(Rain[i],min8,max8);
                       Area[i]= norm(Area[i],min9,max9);
                       
                       }
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       hm.put(0,Day1);
                       hm.put(1,Day2);
                       hm.put(2,Day3);
                       hm.put(3,Day4);
                       hm.put(4,Day5);
                       hm.put(5,Day6);
                       hm.put(6,Day7);
                       
                       hm.put(7,FFMC);
                       hm.put(8,DNC);
                       hm.put(9,DC);
                       hm.put(10,ISI);
                       hm.put(11,TEMP);
                       hm.put(12,RH);
                       hm.put(13,Wind);
                       hm.put(14,Rain);
                       hm.put(15,Area);
                        
                        
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
                return hm;
    
    }
    
    /*public static HashMap<Integer,Double[]>CR(){
    HashMap<Integer,Double[]> hm = new HashMap<>();
    ArrayList<String> CR= new ArrayList<>();
    BufferedReader br = null;
    
                    String[] part;
                    int j =0;
                    Double[] Ch= new Double[1000];
                    Double[] Amo= new Double[1000];
                    Double[] Ag=new Double[1000];
                    Double[] Cl= new Double[1000];
                    Double max1,min1,max2,min2;
    try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("src/ann/CR.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
                            CR.add(sCurrentLine);}
                        for(int i=0;i<1000;i++){
                        part = CR.get(i).split(",");
                        if(null != part[0])
                            switch (part[0]){
                            case "'critical/other existing credit'":{
                                Ch[i]=0.0;
                                break;
                            }
                            case "'existing paid'":{
                                Ch[i]=1.0;
                            break;
                            }
                            case "'delayed previously'":{
                                Ch[i]=2.0;
                            break;
                            
                            }
                            case "'no credits/all paid'":{
                                Ch[i]=3.0;
                            break;
                            
                            }
                            case "'all paid'":{
                                Ch[i]=4.0;
                            break;
                            
                            }
                            default:{
                                break;}
                        }
                        
                        
                        Amo[i]=Double.parseDouble(part[1]);
                        
                        if(null!=part[2])switch(part[2]){
                            case">=7":{
                                Amo[i]=0.0;
                            break;
                            }
                            case"1<=X<4":{
                                Amo[i]=1.0;
                            break;
                            }
                            case"4<=X<7":{
                                Amo[i]=2.0;
                            break;
                            }
                            case"unemployed":{
                                Amo[i]=3.0;
                            break;
                            }
                            case"<1":{
                                Amo[i]=4.0;
                            break;
                            }
                            
                            default:{
                                j++;
                                break;
                            }
                        }
                        if(null!=part[3])switch(part[3]){
                            case"'real estate'":{
                                Cl[i]=0.0;
                            break;
                            }
                            case"'life insurance'":{
                                Cl[i]=1.0;
                            break;
                            }
                            case"'no known property'":{
                                Cl[i]=2.0;
                                
                            break;
                            }
                            case"car":{
                                Cl[i]=3.0;
                            break;
                            }
                            
                            default:{
                                break;
                            }
                        }
                        
                        Ag[i]=Double.parseDouble(part[4]);
                        
                        if("good".equals(part[5])){
                        Cl[i]=1.0;
                        }
                        if("bad".equals(part[5])){
                        Cl[i]=0.0;
                        }
                        }
                        
                        max1=max(Amo);
                        min1=min(Amo);
                        max2=max(Ag);
                        min2=min(Ag);
                        
                        for(int i =0;i<1000;i++){
                        norm(Amo[i],min1,max1);
                        norm(Ag[i],min2,max2);
                        
                        
                        }
                        //TODO: FIX ARRAYS
                       
                        
                        
                        
    }
    catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    return hm;
    }
    */
    public static Double max(Double[] a){
    Double max=0.0;
    for(int i =0;i<a.length;i++){
        
        if(a[i]>max){
        max = a[i];
        }
    }
    
    
    return max;
    }
    public static Double min(Double[] a){
        Double min = 1000000.0;
        
        for(int i=0;i<a.length;i++){
            if(a[i]<min)
                min=a[i];
        
        
        }
    
        return min;
    }
    public static double norm(Double a,Double min,Double max){
    
        a = (a-min)/(max-min);
        
        
    return a;
    }
    
}