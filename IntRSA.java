package RSA;

import java.math.BigInteger;

public class IntRSA {
    protected BigInteger encryptedNumber, decryptedNumber, intMessage;
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


        if (second.compareTo(first) == 1) return gcd(second, first);
        if (second.compareTo(BigInteger.valueOf(0)) == 0) return first;
        return gcd(second, first.mod(second));
    }
    protected BigInteger setE(BigInteger[] ferma){
        for (BigInteger x: ferma){
            if (gcd(x, fi).compareTo(BigInteger.valueOf(1)) == 0) return x;
        }
        return BigInteger.valueOf(-1);
    }

    public BigInteger encryptNumber(BigInteger intMessage){
        encryptedNumber = myPow(intMessage, e, n);
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

    public BigInteger decryptNumber(){
        decryptedNumber = myPow(encryptedNumber, d, n);
        return decryptedNumber;
    }
    public BigInteger decryptNumber(BigInteger encryptedNumber){
        decryptedNumber = myPow(encryptedNumber, d, n);
        return decryptedNumber;
    }

}





