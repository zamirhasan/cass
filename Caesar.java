import java.io.*;
import java.util.*;


public class Caesar
{

	public static void main(String[] args) throws IOException
	{   
	 Scanner sc=new Scanner(System.in);
	 int y=0;
		
		
		int key;
		
		
		System.out.println("input key value");
         key=sc.nextInt();
        
		do
		{
		
		System.out.println("Select an option\n1.Encrypt\n2.Decrypt\n3.Exit");
		y=sc.nextInt();

		switch(y)
		{
			
		case 1:
		File file=new File("D:\\1130308\\input.txt");
	    
	    FileReader ins=new FileReader(file);
		
		BufferedReader br=new BufferedReader(ins);
		
		String str = br.readLine();
		
		
		 String e = "";
		for(int i = 0; i < str.length(); i++)
		{
			int c = str.charAt(i);

			if (Character.isUpperCase(c))
			{
				
				c = c + (key % 26);
				if (c > 'Z')
				c = c - 26;
			}
			else if (Character.isLowerCase(c))
			{
				c = c + (key % 26);
				if (c > 'z')
				c = c - 26;
			}
			e += (char) c;
		}
		System.out.println("Encrypted:" + e);
		
		 
				
				File file1=new File("D:\\1130308\\output.txt");
                FileWriter fw = new FileWriter(file1.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                
                bw.write(e);
                
                bw.close();
                break;

		
		case 2:
			File file3=new File("D:\\1130308\\output.txt");
                FileReader fw3 = new FileReader(file3.getAbsoluteFile());
                BufferedReader bw3 = new BufferedReader(fw3);
                 
                String e1=bw3.readLine();
		String decrypted = "";
		for(int i = 0; i < e1.length(); i++)
		{
			int c = e1.charAt(i);
			if (Character.isUpperCase(c))
			{
				c = c - (key % 26);
				if (c < 'A')
				c = c + 26;
			}
			else if (Character.isLowerCase(c))
			{
				c = c - (key % 26);
				if (c < 'a')
				c = c + 26;
			}
			decrypted += (char) c;
		}
		
		
		System.out.println("Decrypted:" + decrypted);
		File file2=new File("D:\\1130308\\output1.txt");
                FileWriter fw1 = new FileWriter(file2.getAbsoluteFile());
                BufferedWriter bw1 = new BufferedWriter(fw1);
                
                bw1.write(decrypted);
                
                bw1.close();
		break;
		default: break;
	}
	}while(y!=3);
}
	
}
