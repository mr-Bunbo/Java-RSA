package RSA;

import java.math.BigInteger;

public class IntRSA {
    protected int intMessage, p, q, n, fi, e, encryptedNumber, decryptedNumber;
    protected int[] ferma = {3, 5, 17, 257, 65537};
    private BigInteger d;

    public IntRSA(int p, int q){
        this.p = p;
        this.q = q;
        n = this.p * this.q;
        fi = (this.p - 1) * (this.q - 1);
        e = setE(ferma);
        d = BigInteger.valueOf(e).modInverse(BigInteger.valueOf(fi));
    }

    protected int gcd(int first, int second){

        if (second > first) return gcd(second, first);
        if (second == 0) return first;
        return gcd(second, first % second);
    }
    protected int setE(int[] ferma){
        for (int x: ferma){
            if (gcd(x, fi) == 1) return x;
        }
        return -1;
    }

    public int encryptNumber(int intMessage){
        encryptedNumber = BigInteger.valueOf(intMessage).pow(e).mod(BigInteger.valueOf(n)).intValue();
        return encryptedNumber;
    }

    public int decryptNumber(){
        decryptedNumber = BigInteger.valueOf(encryptedNumber).pow(d.intValue()).mod(BigInteger.valueOf(n)).intValue();
        return decryptedNumber;
    }
    public int decryptNumber(int encryptedNumber){
        decryptedNumber = BigInteger.valueOf(encryptedNumber).pow(d.intValue()).mod(BigInteger.valueOf(n)).intValue();
        return decryptedNumber;
    }

}




