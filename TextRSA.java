package RSA;

import java.math.BigInteger;

public class TextRSA extends IntRSA {
    String encryptedText;
    String decryptedText;
    String textMessage;
    public TextRSA(BigInteger p, BigInteger q){
        super(p, q);
    }

    protected int[] stringToIntArray(String textMessage){
        int[] result = new int[textMessage.length()];
        for(int count = 0; count < textMessage.length(); count++){
            result[count] = textMessage.charAt(count);
        }
        return result;
    }

    protected String arrayToString(int[] array){
        String[] stringArray = new String[array.length];
        for (int count = 0; count < array.length; count++){
            stringArray[count] = Character.toString( (char) array[count]);
        }
        return String.join("", stringArray);
    }

    public String textEncrypt(String textMessage){
        int[] temp = stringToIntArray(textMessage);
        for (int count = 0; count < temp.length; count++){
            temp[count] = encryptNumber(temp[count]);
        }
        encryptedText = arrayToString(temp);
        return encryptedText;
    }

    public String textDecrypt(){
        int[] temp = stringToIntArray(encryptedText);
        for (int count = 0; count < temp.length; count++){
            temp[count] = decryptNumber(temp[count]);
        }
        decryptedText = arrayToString(temp);
        return decryptedText;
    }
}


