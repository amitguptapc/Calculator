import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import sun.audio.*;
class guestcalc extends JFrame implements ActionListener
{
    JFrame W1,fr;
    JLabel background;
    JMenuBar mbar;
    JMenu swt,view;
    JMenuItem sc,sim,savedans;

    JButton[] b = new JButton[19];

    String[] bn = {"7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            ".", "/", "C", "sqrt",
            "+/-", "=", "0"};

    JTextArea d = new JTextArea(1,20);

    boolean[] function = new boolean[4];

    double[] temporary = {0, 0};

    Font font = new Font("Kristen ITC", Font.PLAIN, 24);
    Font font1 = new Font("Kristen ITC", Font.PLAIN, 36);   

    guestcalc()
    {
        W1=new JFrame();
        W1.setTitle(" Simple Calculator ");
        W1.setSize(500,420);
        W1.setLocationRelativeTo(null);
        W1.setResizable(false);
        d.setFont(font1);
        d.setEditable(false);
        d.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mbar=new JMenuBar();
        swt=new JMenu("Switch");
        view =new JMenu("View");
        sc=new JMenuItem("Scientific Calculator");
        sim=new JMenuItem("Simple Calculator");
        savedans=new JMenuItem("Saved Answer");
        mbar.add(swt);

        InputStream in =null;
        AudioStream as=null;

        try
        {
            in=new FileInputStream("guest.wav");
        }catch(Exception e)
        {};
        try
        {
            as=new AudioStream(in);
        }catch(Exception e)
        {};
        AudioPlayer.player.start(as);

        mbar.add(view);
        swt.add(sc);
        swt.add(sim);
        view.add(savedans);
        for(int i = 0; i < 19; i++) {
            b[i] = new JButton();
            b[i].setText(bn[i]);
            b[i].setFont(font);
            b[i].addActionListener(this);
            b[i].setContentAreaFilled(false);
        }
        W1.setLayout(new GridLayout());
        background=new JLabel(new ImageIcon("al.jpg"));
        W1.add(background);
        background.setLayout(new SpringLayout());

        W1.setJMenuBar(mbar);
        background.add((d),new SpringLayout.Constraints(
                Spring.constant(40),
                Spring.constant(30),
                Spring.constant(420),
                Spring.constant(80)));

        mylayout(50,120,60,50,b[0]);
        mylayout(120,120,60,50,b[1]);
        mylayout(190,120,60,50,b[2]);
        mylayout(260,120,60,50,b[3]);
        mylayout(50,180,60,50,b[4]);
        mylayout(120,180,60,50,b[5]);
        mylayout(190,180,60,50,b[6]);
        mylayout(260,180,60,50,b[7]);
        mylayout(50,240,60,50,b[8]);
        mylayout(120,240,60,50,b[9]);
        mylayout(190,240,60,50,b[10]);
        mylayout(260,240,60,50,b[11]);
        mylayout(190,300,60,50,b[12]);
        mylayout(260,300,60,50,b[13]);
        mylayout(330,120,120,50,b[14]);
        mylayout(330,180,120,50,b[15]);
        mylayout(330,240,120,50,b[16]);
        mylayout(330,300,120,50,b[17]);
        mylayout(50,300,130,50,b[18]);
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

    public void clear() {
        try {
            d.setText("");
            for(int i = 0; i < 4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;
        } catch(NullPointerException e) {  
        }
    }

    public void getSqrt() {
        try {
            double value = Math.sqrt(Double.parseDouble(d.getText()));
            d.setText(Double.toString(value));
        } catch(NumberFormatException e) {
        }
    }

    public void getPosNeg() {
        try {
            double value = Double.parseDouble(d.getText());
            if(value != 0) {
                value = value * (-1);
                d.setText(Double.toString(value));
            }
            else {
            }
        } catch(NumberFormatException e) {
        }
    }

    public void getResult() {
        double result = 0;
        temporary[1] = Double.parseDouble(d.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);
        try {
            if(temp0.contains("-")) {
                String[] temp00 = temp0.split("-", 2);
                temporary[0] = (Double.parseDouble(temp00[1]) * -1);
            }
            if(temp1.contains("-")) {
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }
        try {
            if(function[2] == true)
                result = temporary[0] * temporary[1];
            else if(function[3] == true)
                result = temporary[0] / temporary[1];
            else if(function[0] == true)
                result = temporary[0] + temporary[1];
            else if(function[1] == true)
                result = temporary[0] - temporary[1];
            d.setText(Double.toString(result));
            for(int i = 0; i < 4; i++)
                function[i] = false;
        } catch(NumberFormatException e) {
        }
    }

    public void actionPerformed(ActionEvent ae) 
    {
        try
        {
            if(ae.getSource() == b[0])
                d.append("7");
            if(ae.getSource() == b[1])
                d.append("8");
            if(ae.getSource() == b[2])
                d.append("9");
            if(ae.getSource() == b[3]) {

                temporary[0] = Double.parseDouble(d.getText());
                function[0] = true;
                d.setText("");
            }
            if(ae.getSource() == b[4])
                d.append("4");
            if(ae.getSource() == b[5])
                d.append("5");
            if(ae.getSource() == b[6])
                d.append("6");
            if(ae.getSource() == b[7]) {

                temporary[0] = Double.parseDouble(d.getText());
                function[1] = true;
                d.setText("");
            }
            if(ae.getSource() == b[8])
                d.append("1");
            if(ae.getSource() == b[9])
                d.append("2");
            if(ae.getSource() == b[10])
                d.append("3");
            if(ae.getSource() == b[11]) {

                temporary[0] = Double.parseDouble(d.getText());
                function[2] = true;
                d.setText("");
            }
            if(ae.getSource() == b[12])
                d.append(".");
            if(ae.getSource() == b[13]) {

                temporary[0] = Double.parseDouble(d.getText());
                function[3] = true;
                d.setText("");
            }
            if(ae.getSource()==sc)
            {
                JOptionPane.showMessageDialog(fr,"Upgrade Not Possible !","MESSAGE !",JOptionPane.ERROR_MESSAGE);
            }
            if(ae.getSource()==savedans)
            {
                JOptionPane.showMessageDialog(fr,"Not Available In Simple Version !","MESSAGE !",JOptionPane.ERROR_MESSAGE);
            }
            if(ae.getSource() == b[14])
                clear();
            if(ae.getSource() == b[15])
                getSqrt();
            if(ae.getSource() == b[16])
                getPosNeg();
            if(ae.getSource() == b[17])
                getResult();
            if(ae.getSource() == b[18])
                d.append("0");
        }catch(Exception rr)
        {};
    }

    public static void main(String[] arguments)
    {
        guestcalc c = new guestcalc();
    }

    void mylayout(int a, int b, int c, int d,JButton j)
    {
        background.add((j),new SpringLayout.Constraints(
                Spring.constant(a),
                Spring.constant(b),
                Spring.constant(c),
                Spring.constant(d)));
    }
}

class guestcalc1 extends JFrame implements ActionListener
{
    JFrame W1,fr;
    JLabel background;
    JMenuBar mbar;
    JMenu swt,view;
    CALC OB;
    anspane ob45;
    JMenuItem sc,sim,savedans;
    JButton[] b = new JButton[19];
    String[] bn = {"7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            ".", "/", "C", "sqrt",
            "+/-", "=", "0"};
    JTextArea d = new JTextArea(1,20);
    boolean[] function = new boolean[4];
    double[] temporary = {0, 0};
    Font font = new Font("Kristen ITC", Font.PLAIN, 24);
    Font font1 = new Font("Kristen ITC", Font.PLAIN, 36);   
    guestcalc1()
    {
        W1=new JFrame();

        W1.setTitle("Simple Calculator");
        W1.setSize(500,420);
        W1.setLocationRelativeTo( null );
        W1.setResizable(false);
        d.setFont(font1);
        d.setEditable(false);
        d.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        mbar=new JMenuBar();
        swt=new JMenu("Switch");
        view =new JMenu("View");
        sc=new JMenuItem("Scientific Calculator");
        sim=new JMenuItem("Simple Calculator");
        savedans=new JMenuItem("Saved Answer");
        InputStream in =null;
        AudioStream as=null;

        try
        {
            in=new FileInputStream("sm.wav");
        }catch(Exception e)
        {};
        try
        {
            as=new AudioStream(in);
        }catch(Exception e)
        {};
        AudioPlayer.player.start(as);

        mbar.add(swt);
        mbar.add(view);
        swt.add(sc);
        swt.add(sim);
        view.add(savedans);
        for(int i = 0; i < 19; i++) {
            b[i] = new JButton();
            b[i].setText(bn[i]);
            b[i].setFont(font);
            b[i].addActionListener(this);
            b[i].setContentAreaFilled(false);	
        }
        W1.setLayout(new GridLayout());
        background=new JLabel(new ImageIcon("al.jpg"));
        W1.add(background);
        background.setLayout(new SpringLayout());
        W1.setJMenuBar(mbar);
        //d.setOpaque(false);
        background.add((d),new SpringLayout.Constraints(
                Spring.constant(40),
                Spring.constant(30),
                Spring.constant(420),
                Spring.constant(80)));

        mylayout(50,120,60,50,b[0]);
        mylayout(120,120,60,50,b[1]);
        mylayout(190,120,60,50,b[2]);
        mylayout(260,120,60,50,b[3]);
        mylayout(50,180,60,50,b[4]);
        mylayout(120,180,60,50,b[5]);
        mylayout(190,180,60,50,b[6]);
        mylayout(260,180,60,50,b[7]);
        mylayout(50,240,60,50,b[8]);
        mylayout(120,240,60,50,b[9]);
        mylayout(190,240,60,50,b[10]);
        mylayout(260,240,60,50,b[11]);
        mylayout(190,300,60,50,b[12]);
        mylayout(260,300,60,50,b[13]);
        mylayout(330,120,120,50,b[14]);
        mylayout(330,180,120,50,b[15]);
        mylayout(330,240,120,50,b[16]);
        mylayout(330,300,120,50,b[17]);
        mylayout(50,300,130,50,b[18]);
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
        //W1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        W1.setVisible(true);
    }

    static void exit(JFrame j) {
        j.dispose();
    }

    public void clear() {
        try {
            d.setText("");
            for(int i = 0; i < 4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;
        } catch(NullPointerException e) {  
        }
    }

    public void getSqrt() {
        try {
            double value = Math.sqrt(Double.parseDouble(d.getText()));
            d.setText(Double.toString(value));
        } catch(NumberFormatException e) {
        }
    }

    public void getPosNeg() {
        try {
            double value = Double.parseDouble(d.getText());
            if(value != 0) {
                value = value * (-1);
                d.setText(Double.toString(value));
            }
            else {
            }
        } catch(NumberFormatException e) {
        }
    }

    public void getResult() {
        double result = 0;
        temporary[1] = Double.parseDouble(d.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);
        try {
            if(temp0.contains("-")) {
                String[] temp00 = temp0.split("-", 2);
                temporary[0] = (Double.parseDouble(temp00[1]) * -1);
            }
            if(temp1.contains("-")) {
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }
        try {
            if(function[2] == true)
                result = temporary[0] * temporary[1];
            else if(function[3] == true)
                result = temporary[0] / temporary[1];
            else if(function[0] == true)
                result = temporary[0] + temporary[1];
            else if(function[1] == true)
                result = temporary[0] - temporary[1];
            d.setText(Double.toString(result));
            for(int i = 0; i < 4; i++)
                function[i] = false;
        } catch(NumberFormatException e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b[0])
            d.append("7");
        if(ae.getSource() == b[1])
            d.append("8");
        if(ae.getSource() == b[2])
            d.append("9");
        if(ae.getSource() == b[3]) {
            //add function[0]
            temporary[0] = Double.parseDouble(d.getText());
            function[0] = true;
            d.setText("");
        }
        if(ae.getSource() == b[4])
            d.append("4");
        if(ae.getSource() == b[5])
            d.append("5");
        if(ae.getSource() == b[6])
            d.append("6");
        if(ae.getSource() == b[7]) {
            //subtract function[1]
            temporary[0] = Double.parseDouble(d.getText());
            function[1] = true;
            d.setText("");
        }
        if(ae.getSource() == b[8])
            d.append("1");
        if(ae.getSource() == b[9])
            d.append("2");
        if(ae.getSource() == b[10])
            d.append("3");
        if(ae.getSource() == b[11]) {
            //multiply function[2]
            temporary[0] = Double.parseDouble(d.getText());
            function[2] = true;
            d.setText("");
        }
        if(ae.getSource() == b[12])
            d.append(".");
        if(ae.getSource() == b[13]) {
            //divide function[3]
            temporary[0] = Double.parseDouble(d.getText());
            function[3] = true;
            d.setText("");
        }
        if(ae.getSource()==sc)
        {
            W1.setVisible(false);
            OB=new CALC();
            //JOptionPane.showMessageDialog(fr,"Upgrade Not Possible !","MESSAGE !",JOptionPane.ERROR_MESSAGE);
        }
        if(ae.getSource()==savedans)
        {
            ob45 =new anspane();
            //JOptionPane.showMessageDialog(fr,"Not Available In Simple Version !","MESSAGE !",JOptionPane.ERROR_MESSAGE);
        }
        if(ae.getSource() == b[14])
            clear();
        if(ae.getSource() == b[15])
            getSqrt();
        if(ae.getSource() == b[16])
            getPosNeg();
        if(ae.getSource() == b[17])
            getResult();
        if(ae.getSource() == b[18])
            d.append("0");
    }

    public static void main(String[] arguments)
    {
        guestcalc c = new guestcalc();
    }

    void mylayout(int a, int b, int c, int d,JButton j)
    {
        background.add((j),new SpringLayout.Constraints(
                Spring.constant(a),
                Spring.constant(b),
                Spring.constant(c),
                Spring.constant(d)));
    }
}