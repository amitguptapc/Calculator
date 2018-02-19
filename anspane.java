import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class anspane extends JFrame implements ActionListener
{
    JFrame W1;
    JLabel ba;
    answer o;
    JButton b;
    JTextArea ar=new JTextArea(30,20);
    public anspane()
    {
        W1=new JFrame();
        b=new JButton("Clear");
        W1.setTitle("Saved Answer");
        W1.setSize(770,480);
        W1.setLocationRelativeTo( null );
        W1.setResizable(false);
        ar.setEditable(false);
        ar.setOpaque(false);
        W1.setVisible(true);
        ar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        W1.setLayout(new GridLayout());
        ba=new JLabel(new ImageIcon("bor.jpg"));
        W1.add(ba);
        ba.setLayout(new SpringLayout());

        ba.add((ar),new SpringLayout.Constraints(
                Spring.constant(350),
                Spring.constant(110),
                Spring.constant(280),
                Spring.constant(200)));
        b.setContentAreaFilled(false);
        ba.add((b),new SpringLayout.Constraints(
                Spring.constant(400),
                Spring.constant(330),
                Spring.constant(80),
                Spring.constant(30)));
        b.addActionListener(this);
        try{
            o=new answer();
        }
        catch(Exception ec1)
        {};
        try{
            ar.append(o.ansread());
        }
        catch(Exception ec1)
        {};
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            ar.setText("");
            try{
                o.clear();
            }
            catch(Exception e1)
            {};
        }
    }  
}