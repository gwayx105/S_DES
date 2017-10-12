import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 
 * 
 * */
public class S_DES {
	// S-Boxes
    final static int[][] S0 = { {1,0,3,2} , {3,2,1,0} , {0,2,1,3} , {3,1,3,2} } ;
    final static int[][] S1 = { {0,1,2,3},  {2,0,1,3}, {3,0,1,0}, {2,1,0,3}} ;
	public byte key_1 [] = new byte[10];
	public byte key_2 [] = new byte[10];
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		S_DES S_DES = new S_DES();
		//System.out.println("Key : "+Arrays.toString(key));
		//genKeys();
		int response = 0;
		byte[] user_key = new byte[10];
		byte[] user_text= new byte[8]; 
		do {
			response = S_DES.mainMenu();
			switch(response){
				case 1:
					//Encryption Starts
					//get user key input
					System.out.print("Enter KEY : ");
					String u_1 = input.next();
					user_key = u_1.getBytes();
					//generate round keys
					S_DES.genKeys(user_key);
					//get plaintext from user
					System.out.print("Enter Plaintext : ");
					u_1 = input.next();
					user_text=u_1.getBytes();
					//Encrypt plaintext
					byte[] cipherText = S_DES.Encrypt(user_key, user_text);
					System.out.println("RawKey\t\tPlaintext\tCiphertext");
					//Display output of  rawkey plaintext and ciphertext
					System.out.println(new String(user_key, StandardCharsets.US_ASCII)+" \t"+new String(user_text, StandardCharsets.US_ASCII)+"  \t" + new String(cipherText, StandardCharsets.US_ASCII));
					break;
				case 2:
					//Decryption begins
					//get user's key
					System.out.print("Enter KEY : ");
					String u_2 = input.next();
					user_key = u_2.getBytes();
					//get ciphertext from user
					System.out.print("Enter Ciphertext : ");
					
					break;
				case 3:
					System.out.println("Exiting Program...!");
					break;
				default:
					System.out.println("Invalid Entry...Please check and try again!!!");
					break;
			}
		}while(response!=3);
		//System.out.print(Arrays.toString(S0));
	}
	public byte[] Encrypt(byte[] rawkey, byte[] plaintext) {
		//test ciphertext
		byte[] temp = IP(plaintext);
		
				
		return temp;
	}
	public byte[] Decrypt(byte[] rawkey, byte[] ciphertext) {
		byte[] temp = new byte[8];
		return temp;
	}
	public void genKeys(byte[] k) {
		//create sub keys
		//Sub key one generated
		key_1 = P8(LS1(P10(k)));
		//Sub key two generated
		key_2 = P8(LS2(LS1(P10(k))));
		System.out.print("Key 1: "+new String(key_1, StandardCharsets.US_ASCII)+" Key 2:"+new String(key_2, StandardCharsets.US_ASCII)+"\n");
	}
	public byte [] P10(byte k1[]) {
		/** Perform permutation P10 on 10-bit key 
		  Perm10(k1, k2, k3, k4, k5, k6, k7, k8, k9, k10) =  (k3, k5, k2, k7, k4, k10, k1, k9, k8, k6)
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
	
	public byte [] P8(byte k1[]) {
		/** Perform permutation P8 on 10-bit key by discarding the k1 and k2 bits
		  Perm8(k1, k2, k3, k4, k5, k6, k7, k8, k9, k10) =  (k6, k3, k7, k4, k8, k5, k10, k9)
		  **/
		byte[] temp = new byte[8];
		temp[0] = k1[5];
		temp[1] = k1[2];
		temp[2] = k1[6];
		temp[3] = k1[3];
		temp[4] = k1[7];
		temp[5] = k1[4];
		temp[6] = k1[9];
		temp[7] = k1[8];
		return temp;
	}
	public byte [] P4(byte k[]) {
		byte [] temp = new byte [4];
		
		return temp;
	}
	public byte[] LS1(byte k[]) {
		//shifting bits to the left once
		byte [] temp = new byte[10];
		temp[0] = k[1];
	    temp[1] = k[2];
	    temp[2] = k[3];
	    temp[3] = k[4];
	    temp[4] = k[0];
	    
	    temp[5] = k[6];
	    temp[6] = k[7];
	    temp[7] = k[8];
	    temp[8] = k[9];
	    temp[9] = k[5];
		return temp;
	}
	public byte[] LS2(byte k[]) {
		//shifting bits to the left twice
		byte [] temp = new byte[10];
		temp[0] = k[2];
	    temp[1] = k[3];
	    temp[2] = k[4];
	    temp[3] = k[0];
	    temp[4] = k[1];
	    
	    temp[5] = k[7];
	    temp[6] = k[8];
	    temp[7] = k[9];
	    temp[8] = k[5];
	    temp[9] = k[6];
		return temp;
	}
	public byte[] IP(byte k[]) {
		//initial permutation function
		byte [] temp =new byte[8];
		temp[0] = k[1];
	    temp[1] = k[5];
	    temp[2] = k[2];
	    temp[3] = k[0];
	    temp[4] = k[3];
	    temp[5] = k[7];
	    temp[6] = k[4];
	    temp[7] = k[6];
	    return temp;
	}
	public byte[] IP_INV(byte k[]) {
		//initial permutation inverse function
		byte[] temp = new byte[8];
		temp[0] = k[1];
	    temp[1] = k[5];
	    temp[2] = k[2];
	    temp[3] = k[0];
	    temp[4] = k[3];
	    temp[5] = k[7];
	    temp[6] = k[4];
	    temp[7] = k[6];
	    return temp;
	}
	public byte[] EXP_PERM(byte p[]) {
		byte[] temp = new byte [8];
		temp[0]  = p[3];
	    temp[1]  = p[0];
	    temp[2]  = p[1];
	    temp[3]  = p[2];
	    temp[4]  = p[1];
	    temp[5]  = p[2];
	    temp[6]  = p[3];
	    temp[7]  = p[0];
		return temp;
	}
	public int mainMenu() {
		int s = 0;
		System.out.println("\n-------------------------------------");
		System.out.println("Please follow instructions below!\nEnter the corresponding number");
		System.out.println("1.\tEncrypt Text");
		System.out.println("2.\tDecrypt Text");
		System.out.println("3.\tExit S-DES");
		System.out.print("Response : ");
		s = input.nextInt();
		
		return s;
	}
}
