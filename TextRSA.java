package RSA;

import java.math.BigInteger;

public class TextRSA extends IntRSA {
    BigInteger[] encryptedText;
    String decryptedText;
    String textMessage;
    public TextRSA(BigInteger p, BigInteger q){
        super(p, q);
    }

    protected BigInteger[] stringToBigIntArray(String textMessage){
        BigInteger[] result = new BigInteger[textMessage.length()];
        for(int count = 0; count < textMessage.length(); count++){
            result[count] = BigInteger.valueOf((int) textMessage.charAt(count)); // result[count] = textMessage.charAt(count)
        }
        return result;
    }

    protected String arrayToString(BigInteger[] array){
        String[] stringArray = new String[array.length];
        for (int count = 0; count < array.length; count++){
            stringArray[count] = Character.toString( (char) array[count].intValue());
        }
        return String.join("", stringArray);
    }

    public BigInteger[] textEncrypt(String textMessage){
        encryptedText = stringToBigIntArray(textMessage);
        for (int count = 0; count < encryptedText.length; count++){
            encryptedText[count] = encryptNumber(encryptedText[count]);
        }
        return encryptedText;
    }

    public String textDecrypt(){
         //BigInteger[] temp = stringToBigIntArray(encryptedText)
        for (int count = 0; count < encryptedText.length; count++){
            encryptedText[count] = decryptNumber(encryptedText[count]);
        }
        decryptedText = arrayToString(encryptedText);
        return decryptedText;
    }
}


