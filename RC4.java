import java.util.Scanner;


public class RC4 {
    byte[] key = new byte[]{0x1A, 0x2B, 0x3C, 0x4D, 0x5E, 0x6F};
    int[][] s;
    int[][] k;
    public static final int arraySize = 16;
    
    public RC4()
    {
        s = new int[arraySize][arraySize];
        k = new int[arraySize][arraySize];
        int value = 0;
        for(int i = 0; i < arraySize; i++)
        {
            for(int j = 0; j < arraySize; j++)
            {
                s[i][j] = value;
                value++;
                k[i][j] = key[value % key.length];
                System.out.println( value+ " " + k[i][j]);
            }
        }
    }
    
    public void encrypt(String plainText)
    {
        byte[] plaintTextByte = plainText.getBytes();
        //int[][]
        for(byte c : plaintTextByte)
        {
            //	System.out.println(c);
        }
        
    }
    
    public static void main(String[] args)
    {
        RC4 start = new RC4();
        Scanner in = new Scanner(System.in);
        System.out.println("Input Plaintext: ");
        String input = in.nextLine();
        start.encrypt(input);
    }
    
}
