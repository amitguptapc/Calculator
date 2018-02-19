import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import sun.audio.*;
class CALC extends JFrame implements ActionListener
{
    JFrame W1,fr;
    solver ob2;
    guestcalc ob5;
    String s="";
    anspane o;
    JLabel l2,l3;
    guestcalc1 ob0;
    JMenuBar mbar;
    JMenu swt,view;
    JMenuItem sc,sim,savedans;
    answer object;
    JButton b[]= new JButton[50];
    String exp="";
    JButton save;

    Font font = new Font("Times New Roman", Font.PLAIN, 12);
    Font font2 = new Font("Times New Roman", Font.PLAIN, 18);
    Font font1 = new Font("Kristen ITC", Font.PLAIN, 25);

    JLabel bk;
    JTextArea display = new JTextArea(1,28);

    String bname[]={"7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0", ".",
            "sin"," cos","tan",
            "cot","sec","cosec",
            "sin­¹","cos­¹","tan­¹",
            "cot­¹","sec­¹","cosec­¹",
            "+","-","*","/",
            "%","mod",
            "ln","log","(",")",
            "!","sqrt","sqr","cub", "exp","antilog",
            "Backspace","AC","=",
            "pi","G","C","E","µ°","NA","R","cubrt"
        };
    public CALC()
    {
        W1=new JFrame();
        W1.setTitle("Calculator");
        W1.setSize(1152,720);
        W1.setLocationRelativeTo( null );
        W1.setResizable(false);
        W1.setLayout(new GridLayout());
        mbar=new JMenuBar();
        swt=new JMenu("Switch");
        view =new JMenu("View");
        sc=new JMenuItem("Scientific Calculator");
        sim=new JMenuItem(" Simple Calculator ");
        savedans=new JMenuItem("Saved Answer");
        mbar.add(swt);
        mbar.add(view);
        swt.add(sc);

        InputStream in =null;
        AudioStream as=null;

        try
        {
            in=new FileInputStream("sc.wav");
        }catch(Exception e)
        {};
        try
        {
            as=new AudioStream(in);
        }catch(Exception e)
        {};
        AudioPlayer.player.start(as);

        swt.add(sim);
        view.add(savedans);
        bk=new JLabel(new ImageIcon("cla.jpg"));
        W1.add(bk);
        save =new JButton("Save Answer");
        for(int i = 0; i < 50; i++) 
        {
            b[i] = new JButton();
            b[i].setText(bname[i]);
            b[i].setFont(font);
            b[i].addActionListener(this);
            //b[i].setContentAreaFilled(false);
            if(i==41||i==40||i==39)
            {
                b[i].setFont(font2);
            }
        }
        save.setFont(font);
        save.addActionListener(this);
        bk.setLayout(new SpringLayout());

        W1.setJMenuBar(mbar);
        l2=new JLabel(new ImageIcon("happy.gif"));
        l3=new JLabel(new ImageIcon("sad.gif"));
        mylayout(0,30,100,100,l2);
        display.setFont(font1);
        display.setEditable(true);
        display.setOpaque(false);
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        bk.add((display),new SpringLayout.Constraints(
                Spring.constant(700),
                Spring.constant(95),
                Spring.constant(360),
                Spring.constant(70)));
        mylayout(850,255,40,30,b[0]);
        mylayout(895,255,40,30,b[1]);
        mylayout(940,255,40,30,b[2]);
        mylayout(850,290,40,30,b[3]);
        mylayout(895,290,40,30,b[4]);
        mylayout(940,290,40,30,b[5]);
        mylayout(850,325,40,30,b[6]);
        mylayout(895,325,40,30,b[7]);
        mylayout(940,325,40,30,b[8]);
        mylayout(985,255,40,30,b[9]);
        mylayout(985,290,40,30,b[10]);
        //save.setContentAreaFilled(false);
        mylayout(760,170,100,30,save);

        mylayout(350,440,50,30,b[11]);
        mylayout(200,475,55,30,b[12]);
        mylayout(260,475,55,30,b[13]);
        mylayout(320,475,55,30,b[14]);
        mylayout(380,475,55,30,b[15]);
        mylayout(270,510,65,30,b[16]);

        mylayout(10,190,60,30,b[17]);
        mylayout(75,190,60,30,b[18]);
        mylayout(140,190,60,30,b[19]);
        mylayout(5,230,60,30,b[20]);
        mylayout(70,230,60,30,b[21]);
        mylayout(135,230,70,30,b[22]);

        mylayout(10,370,45,30,b[23]);
        mylayout(60,370,40,30,b[24]);
        mylayout(105,370,40,30,b[25]);
        mylayout(150,370,40,30,b[26]);

        mylayout(195,370,60,30,b[36]);

        mylayout(20,405,50,30,b[29]);
        mylayout(75,405,50,30,b[30]);
        mylayout(130,405,50,30,b[31]);
        mylayout(185,405,50,30,b[32]);
        mylayout(240,405,50,30,b[33]);
        mylayout(295,405,60,30,b[34]);
        mylayout(275,370,60,30,b[49]);

        mylayout(200,440,60,30,b[37]);
        mylayout(270,440,70,30,b[38]);
        mylayout(360,405,60,30,b[35]);

        mylayout(720,610,100,30,b[39]);
        mylayout(825,610,60,30,b[40]);
        mylayout(890,610,60,30,b[41]);
        mylayout(270,220,50,30,b[42]);
        mylayout(330,220,50,30,b[43]);
        mylayout(390,220,50,30,b[44]);
        mylayout(450,220,50,30,b[45]);
        mylayout(270,260,50,30,b[46]);
        mylayout(330,260,70,30,b[47]);
        mylayout(410,260,50,30,b[48]);
        sc.addActionListener(this);
        sim.addActionListener(this);
        savedans.addActionListener(this);
        W1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        W1.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    int confirmed = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to exit?", "User Confirmation",
                            JOptionPane.YES_NO_OPTION);
                    if (confirmed == JOptionPane.YES_OPTION)
                        exit(W1);
                }
            });

        W1.setVisible(true);
    }

    static void exit(JFrame j) {
        j.dispose();
    }

    public void actionPerformed(ActionEvent e)
    {

        try
        {
            ob2=new solver();
            try{
                object=new answer();
            }
            catch(Exception ec)
            {};
            String st="";
            for(int i=0;i<=38;i++)
            {
                if(e.getSource() == b[i])
                {
                    st=bname[i].trim();
                    display.append(st);
                }
            }

            for(int i=42;i<=49;i++)
            {
                if(e.getSource() == b[i])
                {
                    st=bname[i].trim();
                    display.append(st);
                }
            }
            try
            {
                if(e.getSource() == b[39])
                {
                    String s=display.getText();            
                    display.setText("");
                    display.append(s.substring(0,s.length()-1));
                }
            }catch(Exception e4)
            {};
            if(e.getSource() == b[40])
            {
                display.setText("");
                l3.setBounds(0,0,0,0);
                l2.show(true);
            }
            if(e.getSource() == b[41])
            {
                exp=display.getText();
                s =ob2.main(exp);
                display.append("\n");
                display.append(s);
                if(s.equals("NaN"))
                {
                    l2.hide();
                    mylayout(0,30,100,100,l3);
                }
            }
            if(e.getSource()==sim)
            {
                W1.setVisible(false);
                ob0=new guestcalc1();
            }
            if(e.getSource()==savedans)
            {
                o=new anspane();
            }
            if(e.getSource()==save)
            {

                String str[]=display.getText().split("\\n");
                if(str.length==2)
                {
                    try{
                        object.ansmgr(str[1]);
                    }
                    catch(Exception ec)
                    {};

                    JOptionPane.showMessageDialog(fr,"Answer Has Been Saved Successfully !");
                }
                else
                {
                    JOptionPane.showMessageDialog(fr,"Nothing To Save !","MESSAGE !",JOptionPane.ERROR_MESSAGE);
                }
            }

        }catch(Exception e2)
        {display.append("\n");
            display.append("Error");
            l2.hide();
            mylayout(0,30,100,100,l3);
        };
    }

    void mylayout(int a, int b, int c, int d,JButton j)
    {
        bk.add((j),new SpringLayout.Constraints(
                Spring.constant(a),
                Spring.constant(b),
                Spring.constant(c),
                Spring.constant(d)));
    }

    void mylayout(int a, int b, int c, int d,JLabel j)
    {
        bk.add((j),new SpringLayout.Constraints(
                Spring.constant(a),
                Spring.constant(b),
                Spring.constant(c),
                Spring.constant(d)));
    }
}