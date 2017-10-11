import java.util.Arrays;
import java.util.Scanner;

public class S_DES {
	// S-Boxes
    final static int[][] S0 = { {1,0,3,2} , {3,2,1,0} , {0,2,1,3} , {3,1,3,2} } ;
    final static int[][] S1 = { {0,1,2,3},  {2,0,1,3}, {3,0,1,0}, {2,1,0,3}} ;
	public static byte key [] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 0};
	Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		S_DES S_DES = new S_DES();
		System.out.println("Key : "+Arrays.toString(key));
		//genKeys();
		int response = 0;
		do {
			response = S_DES.mainMenu();
			switch(response){
				case 0:
					System.out.print("Enter KEY : ");
					
					System.out.print("Enter Plaintext : ");
										
					break;
				case 1:
					System.out.print("Enter KEY : ");
					
					System.out.print("Enter Ciphertext : ");
					
					break;
				case 2:
					System.out.println("Exiting Program...!");
					break;
				default:
					System.out.println("Invalid Entry...Please check and try again!!!");
					break;
			}
		}while(response!=0);
		System.out.print(Arrays.toString(S0));
	}
	public byte[] Encrypt(byte[] rawkey, byte[] plaintext) {
		return null;
	}
	public byte[] Decrypt(byte[] rawkey, byte[] ciphertext) {
		return null;
	}
	public void genKeys() {
		
	}
	public byte [] P10(byte k1[]) {
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
	
	public byte [] P8(byte k1[]) {
		
		return null;
	}
	public int mainMenu() {
		int s = 0;
		System.out.println("-------------------------------------");
		System.out.println("Please follow instructions below!\nEnter the corresponding number");
		System.out.println("1.\tEncrypt Text");
		System.out.println("2.\tDecrypt Text");
		System.out.println("3.\tExit S-DES");
		s = input.nextInt();
		return s;
	}
}
