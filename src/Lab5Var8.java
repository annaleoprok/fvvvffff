import java.io.*;
import java.util.Scanner;

public class Lab5Var8{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Count");
        int count = sc.nextInt();
        sc.nextLine();
        DataOutputStream dout = null;
        DataInputStream din = null;
        DataOutputStream dout2 = null;
        DataInputStream din2 = null;
        try {
            File f1 = new File("Lab5Src.txt");
            if(f1.exists())f1.delete();
            f1.createNewFile();
            dout = new DataOutputStream(new FileOutputStream(f1));
            for (int i = 0; i < count; i++) {
                String word = sc.nextLine();
                dout.writeUTF(word);
            }
            din = new DataInputStream(new FileInputStream(f1));

            File f2 = new File("Lab5Res.txt");
            if(f2.exists())f2.delete();
            dout2 = new DataOutputStream(new FileOutputStream(f2));
            int countA = 0;
            for (int i = 0; i < count; i++) {
                String wordW = din.readUTF();
                //String
                if (wordW.indexOf('a') == 0);{
                    dout2.writeUTF(wordW);
                    countA++;
                }
            }
            din2 = new DataInputStream(new FileInputStream(f2));
            for (int i = 0; i < count; i++){
                System.out.println(din2.readUTF());
            }

        }
            catch(IOException io){
            io.printStackTrace();
            }
        finally {
            dout.flush();
            dout.close();
            din.close();
            dout2.flush();
            dout2.close();
            din2.close();
            sc.close();
        }
    }
}