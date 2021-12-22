// RSA 128 bits Program //

package rough;
import java.math.*;
import java.security.SecureRandom;
public class RSAGenerator {
	RSAGenerator()
	{
		super();
	}

  private  Key publickey; //Public Key
  private Key privatekey; //Private key
	private static final BigInteger ONE = BigInteger.ONE; 
	public RSAGenerator(int numbits){
		//Generating p and q
		BigInteger p = BigInteger.probablePrime(numbits, new SecureRandom());
		BigInteger q = BigInteger.probablePrime(numbits, new SecureRandom());
		//Computing modulus(n=p*q)
		BigInteger n = p.multiply(q);
		//Compute Euler's totient function, phiN
		BigInteger p_minus_one = p.subtract(ONE);
		BigInteger q_minus_one = q.subtract(ONE);
		BigInteger phiN = p_minus_one.multiply(q_minus_one);
		//Calculate public exponent
		BigInteger e, d;
		do {
			e = BigInteger.probablePrime(numbits, new SecureRandom());
		} while ((e.compareTo(ONE) == 1) && (e.compareTo(phiN) == -1) && (e.gcd(phiN).compareTo(ONE) != 0));
		//Calculate private exponent
		d = e.modInverse(phiN);
		//Set Keys
		publickey = new Key(e,n);privatekey = new Key(d,n);
		System.out.println("Public key is: "+publickey);
	}
	
    //Encryption method
	public BigInteger encrypt(String msg){
		return (new BigInteger(msg.getBytes())).modPow(publickey.getComponent(), publickey.getModulus());
	}
	
    //Decryption method
	public  BigInteger decrypt(BigInteger encrypt_msg,BigInteger d,BigInteger xn){
		if(d==privatekey.getComponent()&&xn==privatekey.getModulus())
		return encrypt_msg.modPow(privatekey.getComponent(), privatekey.getModulus());
		return encrypt_msg.modPow(d,xn);
	}
    
	//returns private key component
    public String toString1(){
		return (privatekey.getComponent()).toString();			
	}
    
    //returns private key modulus
    public String toString2(){
		return (privatekey.getModulus()).toString();	
    }
}