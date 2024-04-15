package com.targetindia.programs;
import com.targetindia.util.KeyboardUtil;
public class Assn2 {

    public static String clubbing(int a,int b){
        String s="";
        if(a==0 && b==0){
            return s;
        }
        String[] single = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen",
                "fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] doubles = {"zero","one","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        if(a==0 || a == 1){
            int club = a*10 + b;
            s += single[club]+" ";
        }
        else{
            s += doubles[a]+" " + single[b]+" ";
        }
        return s;
    }

    public static void inWords(int number){
        if(number<1 || number>999999999){
            System.out.println("Please enter a valid input");
        }
        int units = number%10;
        int tens = (number%100 - number%10)/10;
        int hundreds = (number%1000 -number%100)/100;
        int thousands = (number%10000 -number%1000)/1000;
        int tenThousands = (number%100000 -number%10000)/10000;
        int lakhs = (number%1000000 -number%100000)/100000;
        int tenlakhs = (number%10000000 -number%1000000)/1000000;
        int crores = (number%100000000 -number%10000000)/10000000;
        int tenCrores = (number%1000000000 -number%100000000)/100000000;
        String ans = "";

        //for crores part
        ans += clubbing(tenCrores,crores);
        if(tenCrores!=0 || crores!=0){
            ans+="crores ";
        }

        //for lakhs part
        ans+=clubbing(tenlakhs,lakhs);
        if(tenlakhs!=0 || lakhs!=0){
            ans+="lakhs ";
        }

        //for thousands part
        ans+= clubbing(tenThousands,thousands);
        if(tenThousands!=0 || thousands!=0){
            ans+="thousand ";
        }

        //for hundred part
        ans+=clubbing(0,hundreds);
        if(hundreds!=0){
            ans+="hundred and ";
        }

        //for tens part
        ans += clubbing(tens,units);
        System.out.print(ans);
        return;
    }
    public static void main(String[] args) {
        int number = KeyboardUtil.getInt("Enter number to be converted into words: ");
        inWords(number);
    }
}