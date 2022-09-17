package RSA;

import java.math.BigInteger;

public class IntRSA {
    protected int intMessage, encryptedNumber, decryptedNumber;
    protected BigInteger[] ferma = {BigInteger.valueOf(3), BigInteger.valueOf(5), BigInteger.valueOf(17), BigInteger.valueOf(257), BigInteger.valueOf(65537)};
    private BigInteger d, p, q, n, fi, e;

    public IntRSA(BigInteger p, BigInteger q){
        this.p = p;
        this.q = q;
        BigInteger temp1 = this.p.subtract(BigInteger.valueOf(1));
        BigInteger temp2 = this.q.subtract(BigInteger.valueOf(1));
        n = this.p.multiply(this.q);
        fi = temp1.multiply(temp2);
        e = setE(ferma);
        d = e.modInverse(fi);
    }

    protected BigInteger gcd(BigInteger first, BigInteger second){


        if (second.compareTo(first) == 1) return gcd(second, first); //second > first
        if (second.compareTo(BigInteger.valueOf(0)) == 0) return first; //second == BigInteger.valueOf(0)
        return gcd(second, first.mod(second)); //first % second
    }
    protected BigInteger setE(BigInteger[] ferma){
        for (BigInteger x: ferma){
            if (gcd(x, fi).compareTo(BigInteger.valueOf(1)) == 0) return x; //gcd(x, fi) == BigInteger.valueOf(1)
        }
        return BigInteger.valueOf(-1);
    }

    public int encryptNumber(int intMessage){
        encryptedNumber = myPow(BigInteger.valueOf(intMessage), e, n).intValue(); // BigInteger.valueOf(intMessage).pow(e.intValue()).mod(n).intValue()
        return encryptedNumber;
    }

    public BigInteger myPow(BigInteger a, BigInteger b, BigInteger c){
        BigInteger number = BigInteger.valueOf(1);
        while (b.compareTo(BigInteger.valueOf(0)) == 1){
            BigInteger temp = b.and(BigInteger.valueOf(1));
            if (temp.compareTo(BigInteger.valueOf(0)) == 1){
                number = number.multiply(a).mod(c);
            }
            b = b.shiftRight(1);
            a = a.multiply(a).mod(c);
        }
        return number;
    }

    public int decryptNumber(){
        decryptedNumber = myPow(BigInteger.valueOf(encryptedNumber), d, n).intValue(); // BigInteger.valueOf(encryptedNumber).pow(d.intValue()).mod(n).intValue()
        return decryptedNumber;
    }
    public int decryptNumber(int encryptedNumber){
        decryptedNumber = myPow(BigInteger.valueOf(encryptedNumber), d, n).intValue(); // BigInteger.valueOf(encryptedNumber).pow(d.intValue()).mod(n).intValue()
        return decryptedNumber;
    }

}





