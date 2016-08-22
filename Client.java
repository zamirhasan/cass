
package Client;

import java.io.*;
import java.net.*;
import java.security.*;
import javax.crypto.*;

public class Client {

    public static void main(String[] args) throws IOException , SocketException, InvalidKeyException,IllegalBlockSizeException, NoSuchAlgorithmException, Exception{
   			int port=2000;
        File f1=new File("C:\\Users\\fy-comp33.FY\\Desktop\\project\\Client\\input.txt");
        FileReader fr=new FileReader(f1);
        BufferedReader br=new BufferedReader(fr);
        Socket s2=new Socket("127.0.0.1",port);
        DataInputStream di;
        di = new DataInputStream(s2.getInputStream());
        String no=br.readLine();
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        DesEncrypter  encrypter = new DesEncrypter (key);
        String encrypted = encrypter.encrypt(no);


        PrintStream p=new PrintStream(s2.getOutputStream());
        p.println(encrypted);
        String temp;
        temp = di.readLine();
        String s3=encrypter.decrypt(temp);

        File file2=new File("C:\\Users\\fy-comp33.FY\\Desktop\\project\\Client\\output.txt");
        FileWriter fw=new FileWriter(file2);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(s3);
        bw.close();


    }

}

class DesEncrypter {
  Cipher ecipher;

  Cipher dcipher;

  DesEncrypter(SecretKey key) throws Exception {
    ecipher = Cipher.getInstance("DES");
    dcipher = Cipher.getInstance("DES");
    ecipher.init(Cipher.ENCRYPT_MODE, key);
    dcipher.init(Cipher.DECRYPT_MODE, key);
  }

  public String encrypt(String str) throws Exception {
    // Encode the string into bytes using utf-8
    byte[] utf8 = str.getBytes("UTF8");

    // Encrypt
    byte[] enc = ecipher.doFinal(utf8);

    // Encode bytes to base64 to get a string
    return new sun.misc.BASE64Encoder().encode(enc);
  }

  public String decrypt(String str) throws Exception {
    // Decode base64 to get bytes
    byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

    byte[] utf8 = dcipher.doFinal(dec);

    // Decode using utf-8
    return new String(utf8, "UTF8");
  }
}
