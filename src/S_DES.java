import java.util.Arrays;

public class S_DES {
	// S-Boxes
    final static int[][] S0 = { {1,0,3,2} , {3,2,1,0} , {0,2,1,3} , {3,1,3,2} } ;
    final static int[][] S1 = { {0,1,2,3},  {2,0,1,3}, {3,0,1,0}, {2,1,0,3}} ;
	public static byte key1 [] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Key : "+Arrays.toString(key1));
		System.out.print(Arrays.toString(S0));
	}
	public static byte[] Encrypt(byte[] rawkey, byte[] plaintext) {
		return null;
	}
	public static byte[] Decrypt(byte[] rawkey, byte[] ciphertext) {
		return null;
	}
	public byte [] Perm10(byte k1[]) {
		/** Perform permutation P10 on 10-bit key 
		  Perm10(k1, k2, k3, k4, k5, k6, k7, k8, k9, k10)  
		        (k3, k5, k2, k7, k4, k10, k1, k9, k8, k6)
		  **/
		byte[] temp =new byte[10];
		temp[0] = k1[2];
		temp[1] = k1[4];
		temp[2] = k1[1];
		temp[3] = k1[6];
		temp[4] = k1[3];
		temp[5] = k1[9];
		temp[6] = k1[0];
		temp[7] = k1[8];
		temp[8] = k1[7];
		temp[9] = k1[5];
		return temp;
	}
	
	public byte [] Perm8(byte k1[]) {
		return null;
	}
}
