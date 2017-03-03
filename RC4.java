import java.util.Scanner;

public class RC4 {
    byte[] key = new byte[] { 0x1A, 0x2B, 0x3C, 0x4D, 0x5E, 0x6F, 0x77 }; // Given key
    int[][] s = new int[arraySize][arraySize]; // initialize Store values from 0 - 255
    int[][] k = new int[arraySize][arraySize]; // initialize key is stored in a 16 by 16
    int value; // for the specific value till 255
    public static final int arraySize = 16;
    
    public RC4() {
        
    }
    
    public void initialize() {
        value = 0;
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                s[i][j] = value; // fill array with values till 255
                k[i][j] = key[value % key.length]; // fill array with key
                value++;
            }
        }
        //System.out.println("before the initialization: ");
        //print();
        //	System.out.println();
        
        int change = 0; // value to swap in s array
        for ( int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                change = (change + s[i][j] + k[i][j]) % 256; // byte value
                int temp = s[i][j];
                s[i][j] = s[change / arraySize][change % arraySize]; // Swap
                s[change / arraySize][change % arraySize] = temp;
            }
        }
        System.out.println("Permutation after the initialization: ");
        print();
        System.out.println();
        System.out.println("indices for i: " + (value - 1));
        System.out.println("indices for j: " + change);
    }
    
    public void generateByteSteam(int number)
    {
        int i = 0;
        int j = 0;
        for(int l = 0; l < number; l++)
        {
            i = (i + 1) % 256;
            j = (j + s[i/arraySize][i % arraySize]) % 256;
            int temp = s[i/arraySize][i % arraySize]; // swap
            s[i/arraySize][i % arraySize] = s[j/arraySize][j % arraySize];
            s[j/arraySize][j % arraySize] = temp;
        }
        System.out.println("first " + number + " bytes of keystream: ");
        print();
        System.out.println("indices for i: " + i);
        System.out.println("indices for j: " +j);
        
    }
    
    public void print()
    {
        int l =0;
        int t = 0;
        for ( l = 0; l < arraySize; l++) {
            for ( t = 0; t < arraySize; t++) {
                String hex = Integer.toHexString(s[l][t]); // convert to hex
                System.out.print(hex + " ");
            }
            System.out.println();
        }
    }
    
    public void encrypt(String plainText) {
        byte[] plaintTextByte = plainText.getBytes();
        // int[][]
        //for (byte c : plaintTextByte) {
        //System.out.println(c);
        //}
    }
    
    public static void main(String[] args) {
        RC4 start = new RC4();
        start.initialize();
        Scanner in = new Scanner(System.in);
        System.out.println("Input Plaintext: ");
        String input = in.nextLine();
        start.encrypt(input);
        System.out.println("Enter byte Stream int: ");
        int byteNumber = in.nextInt();
        start.generateByteSteam(byteNumber);
    }
    
}
