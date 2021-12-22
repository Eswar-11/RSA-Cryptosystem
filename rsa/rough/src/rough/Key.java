package rough;

import java.math.BigInteger;


 //Key class used to store the key's Component and Modulus

public class Key {

  private BigInteger component; //Component
	private BigInteger modulus; //Modulus

	Key(BigInteger component, BigInteger modulus){
		this.component = component;
		this.modulus = modulus;
	}
	

	public BigInteger getComponent(){
		return component;
	}
	

	public BigInteger getModulus(){
		return modulus;
	}
	

	@Override
	public String toString(){
		return "Component: "+component+" / Modulus: "+modulus;
	}
}