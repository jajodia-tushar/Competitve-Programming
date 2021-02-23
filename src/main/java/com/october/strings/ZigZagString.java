package com.october.strings;

public class ZigZagString {

    public static void main(String[] args) {
        ZigZagString obj = new ZigZagString();
        System.out.println(obj.convert("PAYPALISHIRING",4));
    }

    public String convert(String A, int B) {

        if(B == 1)
            return A;

        StringBuilder[] strArray = new StringBuilder[B];
        int currentRow = 0;
        boolean directionDown = true;

        for(int i = 0; i < A.length(); i++){
            if(strArray[currentRow] == null)
                strArray[currentRow] = new StringBuilder();

            strArray[currentRow].append(A.charAt(i));

            if(directionDown){
                if((1 + currentRow) == B) directionDown = false;
            }
            else{
                if((currentRow - 1)  == -1) directionDown = true;
            }

            if(directionDown) currentRow++;
            else currentRow--;
        }

        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i < B; i++){
            if(strArray[i] != null)
                finalString.append(strArray[i]);
        }
        return finalString.toString();
    }
}
