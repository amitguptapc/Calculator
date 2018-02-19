import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import sun.audio.*;
public class paswrdpane extends JFrame implements ActionListener
{
    JFrame W1,W2,W3,W4,W5,W6,W7;
    JTextField field, field1;
    JPasswordField fieldPass,fieldPass1,fieldPass2;
    String u,p,s,q;
    JButton b1,b2,b3,b4,b5;
    bar obj;
    Font font = new Font("Kristen ITC", Font.PLAIN, 28);
    Font font1 = new Font("Kristen ITC", Font.PLAIN, 20);
    Font font2 = new Font("Kristen ITC", Font.PLAIN, 16);
    Font font3 = new Font("Viner Hand ITC", Font.BOLD, 48);
    file ob1;
    guestcalc ob3;
    public paswrdpane()
    {
        W1=new JFrame();
        W1.setTitle("Calculator Login");
        W1.setSize(850,350);
        W1.setLocationRelativeTo( null );
        W1.setResizable(false);
        W1.setLayout(new GridLayout());
        JLabel background=new JLabel(new ImageIcon("image.jpg"));
        W1.add(background);

        InputStream in =null;
        AudioStream as=null;

        try
        {
            in=new FileInputStream("log.wav");
        }catch(Exception e)
        {};
        try
        {
            as=new AudioStream(in);
        }catch(Exception e)
        {};
        AudioPlayer.player.start(as);

        background.setLayout(new SpringLayout());
        b1 = new JButton("sign in");
        JLabel label0 = new JLabel("existing user :");
        label0.setForeground(Color.YELLOW);
        label0.setFont(font);
        background.add((label0),new SpringLayout.Constraints(
                Spring.constant(530),
                Spring.constant(20),
                Spring.constant(500),
                Spring.constant(40)));
        JLabel label1 = new JLabel("username :");
        label1.setForeground(Color.RED);
        label1.setFont(font1);
        background.add((label1),new SpringLayout.Constraints(
                Spring.constant(530),
                Spring.constant(20),
                Spring.constant(500),
                Spring.constant(100)));
        field1 = new JTextField(15);
        field1.setForeground(Color.BLUE);
        field1.setFont(font2);
        field1.setBackground(Color.YELLOW);
        background.add((field1),new SpringLayout.Constraints(
                Spring.constant(530),
                Spring.constant(90),
                Spring.constant(200),
                Spring.constant(25)));
        JLabel label2 = new JLabel("password:");
        label2.setForeground(Color.RED);
        label2.setFont(font1);
        background.add((label2),new SpringLayout.Constraints(
                Spring.constant(530),
                Spring.constant(125),
                Spring.constant(200),
                Spring.constant(25)));
        fieldPass1 = new JPasswordField(15);
        fieldPass1.setForeground(Color.BLUE);

        fieldPass1.setBackground(Color.YELLOW);
        background.add((fieldPass1),new SpringLayout.Constraints(
                Spring.constant(530),
                Spring.constant(160),
                Spring.constant(200),
                Spring.constant(25)));
        b1.setFont(font);
        background.add((b1),new SpringLayout.Constraints(
                Spring.constant(560),
                Spring.constant(210),
                Spring.constant(120),
                Spring.constant(40)));

        b2 = new JButton("sign up");
        b2.setFont(font);

        background.add((b2),new SpringLayout.Constraints(
                Spring.constant(300),
                Spring.constant(100),
                Spring.constant(140),
                Spring.constant(40)));

        JLabel label4 = new JLabel("new user :");
        label4.setFont(font);
        label4.setForeground(Color.YELLOW);
        background.add((label4),new SpringLayout.Constraints(
                Spring.constant(300),
                Spring.constant(20),
                Spring.constant(140),
                Spring.constant(100)));

        b5 = new JButton("guest user");
        b5.setFont(font1);
        background.add((b5),new SpringLayout.Constraints(
                Spring.constant(30),
                Spring.constant(250),
                Spring.constant(150),
                Spring.constant(30)));
        b1.addActionListener(this);
        b2.addActionListener(this);
        b5.addActionListener(this);
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

    public void regpane()
    {
        W2=new JFrame();
        W2.setTitle("Registration Dialog");
        W2.setSize(970,470);
        W2.setResizable(false);
        W2.setLocationRelativeTo( null );

        W2.setLayout(new GridLayout());
        JLabel bkg=new JLabel(new ImageIcon("kool.jpg"));
        W2.add(bkg);
        bkg.setLayout(new SpringLayout());
        InputStream in =null;
        AudioStream as=null;
        try
        {
            in=new FileInputStream("reg.wav");
        }catch(Exception e)
        {};
        try
        {
            as=new AudioStream(in);
        }catch(Exception e)
        {};
        AudioPlayer.player.start(as);
        JLabel l=new JLabel("Registration");
        l.setFont(font3);
        l.setForeground(Color.ORANGE);
        bkg.add((l),new SpringLayout.Constraints(
                Spring.constant(10),
                Spring.constant(5),
                Spring.constant(400),
                Spring.constant(100)));
        JLabel label1 = new JLabel("username:");
        label1.setFont(font);
        label1.setForeground(Color.YELLOW);
        bkg.add((label1),new SpringLayout.Constraints(
                Spring.constant(100),
                Spring.constant(30),
                Spring.constant(400),
                Spring.constant(200)));

        b4 = new JButton("check availibility");
        field = new JTextField(15);
        b4.setFont(font2);
        bkg.add((b4),new SpringLayout.Constraints(
                Spring.constant(270),
                Spring.constant(160),
                Spring.constant(150),
                Spring.constant(30)));

        field.setFont(font2);

        bkg.add((field),new SpringLayout.Constraints(
                Spring.constant(100),
                Spring.constant(160),
                Spring.constant(150),
                Spring.constant(30)));
        JLabel label2 = new JLabel("password:");
        label2.setForeground(Color.yellow);
        label2.setFont(font);

        bkg.add((label2),new SpringLayout.Constraints(
                Spring.constant(100),
                Spring.constant(115),
                Spring.constant(200),
                Spring.constant(200)));
        fieldPass = new JPasswordField(20);

        fieldPass.setFont(font2);
        bkg.add((fieldPass),new SpringLayout.Constraints(
                Spring.constant(100),
                Spring.constant(240),
                Spring.constant(200),
                Spring.constant(30)));
        JLabel label3 = new JLabel("confirm password:");
        label3.setForeground(Color.YELLOW);
        label3.setFont(font);
        bkg.add((label3),new SpringLayout.Constraints(
                Spring.constant(100),
                Spring.constant(200),
                Spring.constant(300),
                Spring.constant(200)));
        fieldPass2 = new JPasswordField(15);
        fieldPass2.setFont(font2);
        bkg.add((fieldPass2),new SpringLayout.Constraints(
                Spring.constant(100),
                Spring.constant(330),
                Spring.constant(230),
                Spring.constant(30)));
        b3 = new JButton("register");
        b3.setFont(font);
        bkg.add((b3),new SpringLayout.Constraints(
                Spring.constant(400),
                Spring.constant(320),
                Spring.constant(150),
                Spring.constant(50)));
        b3.addActionListener(this);
        b4.addActionListener(this);
        W2.setLayout(new FlowLayout());
        W2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        W2.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    int confirmed = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to exit?", "User Confirmation",
                            JOptionPane.YES_NO_OPTION);
                    if (confirmed == JOptionPane.YES_OPTION)
                        exit(W2);
                }
            });
        W2.setVisible(true);
    }

    public static void main(String args[])
    {
        new paswrdpane();
    }

    public void actionPerformed(ActionEvent e)
    {
        W6=new JFrame();
        W7=new JFrame();
        try{
            ob1 = new file();
        }
        catch(Exception ec)
        {};
        s =e.getActionCommand();
        boolean r=false;
        boolean r1=false;
        if (s.equals("sign in"))
        {
            String chk=field1.getText()+","+fieldPass1.getText(); 
            if(chk.equals(","))
            {
                JOptionPane.showMessageDialog(W3,"EMPTY FIELD !","WARNING !",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try{
                    r=ob1.securitycheck(chk);
                }
                catch(Exception ec)
                {};
                if(r==true)
                {
                    W1.setVisible(false);
                    obj = new bar();
                }
                else
                {
                    field1.setText("");
                    fieldPass1.setText("");
                    JOptionPane.showMessageDialog(W3,"PASSWORD OR USERNAME IS INCORRECT !","WARNING !",JOptionPane.WARNING_MESSAGE);                      
                }
            }
        }
        if (s.equals("sign up"))
        {
            W1.setVisible(false);
            regpane();
        }
        if(s.equals("guest user"))
        {
            W1.setVisible(false);
            ob3=new guestcalc();
        }
        if (s.equals("register"))
        {
            u=field.getText();
            p=fieldPass.getText();
            q=fieldPass2.getText();
            try{
                r1= ob1.available(u);}
            catch(Exception ec1)
            {};
            if(r1==true)
            {
                JOptionPane.showMessageDialog(W6,"USERNAME NOT AVAILABLE !","MESSAGE !",JOptionPane.ERROR_MESSAGE);
                field.setText("");
                fieldPass.setText("");
                fieldPass2.setText("");
                return;
            }
            if(p.equals(q))
            {
                if(p.equals("")||u.equals(""))
                {
                    JOptionPane.showMessageDialog(W3,"EMPTY FIELD !","Message !",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    String s1=u+","+p;
                    try{
                        ob1.filemgr(s1);}
                    catch(Exception ecc)
                    {};
                    JOptionPane.showMessageDialog(W5,"Registration Successful","Message",JOptionPane.WARNING_MESSAGE);
                    W2.setVisible(false);
                    obj = new bar();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(W4,"Passwords Doesn't Match !","Warning",JOptionPane.WARNING_MESSAGE); 
                fieldPass.setText("");
                fieldPass2.setText("");
            }
        }
        if(s.equals("check availibility"))
        {
            u=field.getText();
            try{
                r1= ob1.available(u);}
            catch(Exception ec1)
            {};
            if(r1==true)
            {
                JOptionPane.showMessageDialog(W6,"USERNAME NOT AVAILABLE !","MESSAGE !",JOptionPane.ERROR_MESSAGE);
                field.setText("");
            }
            if(r1==false)
            {
                JOptionPane.showMessageDialog(W7,"USERNAME AVAILABLE !");
            }
        }
    }

    static void exit(JFrame j) {
        j.dispose();
    }
}