import java.io.*;
import java.util.*;
class file
{
    file()throws Exception
    {
        FileWriter fw=new FileWriter("regdat.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.close();
        bw.close();
        fw.close();
    }

    void filemgr(String str)throws Exception
    {
        FileWriter fw=new FileWriter("regdat.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println(str);
        pw.close();
        bw.close();
        fw.close();
    }

    boolean securitycheck(String ch)throws Exception
    {
        FileReader fw=new FileReader("regdat.txt");
        BufferedReader bw = new BufferedReader(fw);
        String line="";
        while((line=bw.readLine())!=null)
        {
            if(line.equals(ch))
                return true;
        }
        return false;
    }
    
    boolean available(String ch)throws Exception
    {
    	FileReader fw=new FileReader("regdat.txt");
        BufferedReader bw = new BufferedReader(fw);
        String line="";
        while((line=bw.readLine())!=null)
        {
            if(line.contains(ch+","))
                return true;
        }
        return false;
    }
}