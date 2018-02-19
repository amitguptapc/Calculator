import java.io.*;
import java.util.*;

class answer
{
    answer()throws Exception
    {
        FileWriter fw=new FileWriter("ans.txt",true);//to make in the file
        BufferedWriter bw = new BufferedWriter(fw);//to write in the file
        PrintWriter pw = new PrintWriter(bw);//to print in the file
        pw.close();
        bw.close();
        fw.close();
    }

    void ansmgr(String str)throws Exception
    {
        FileWriter fw=new FileWriter("ans.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);//to write the answer in the file 
        PrintWriter pw = new PrintWriter(bw);
        pw.println(str);
        pw.close();
        bw.close();
        fw.close();
    }

    String ansread()throws Exception
    {
        FileReader fw=new FileReader("ans.txt");
        BufferedReader bw = new BufferedReader(fw);

        String s="";
        String line="";
        int i=1;//to print the answerno
        while((line=bw.readLine())!=null)
        {  
            s=s+"\n"+"ANS.  "+i+"  ";
            s=s+line;
            i++;//to increment the ith vaue

        }
        return s;

    }

    void clear()throws Exception
    {
        FileWriter fw=new FileWriter("ans.txt");//to clear the answer and make a new file
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.close();
        bw.close();
        fw.close();
    }
}