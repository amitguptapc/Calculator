import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import sun.audio.*;
import java.io.*;
public class bar extends JFrame {

    CALC ob;
    JLabel l;
    JProgressBar p;
    boolean paint = false;
    public bar()
    {
        super("LOADING CALCULATOR...");
        setResizable(false);
        setSize(400,327);
        UIManager.put("ProgressBar.selectionBackground", Color.black);
        UIManager.put("ProgressBar.selectionForeground", Color.white);
        UIManager.put("ProgressBar.foreground", new Color(8,32,128));
        UIManager.put("ProgressBar.cellLength", new Integer(5));
        UIManager.put("ProgressBar.cellSpacing", new Integer(1));
        p = new JProgressBar();
        this.setLayout(new	SpringLayout());
        l=new JLabel(new ImageIcon("a.gif"));
        this.add(l);

        InputStream in =null;
        AudioStream as=null;

        try
        {
            in=new FileInputStream("load.wav");
        }catch(Exception e)
        {};
        try
        {
            as=new AudioStream(in);
        }catch(Exception e)
        {};
        AudioPlayer.player.start(as);

        this.add((p),new SpringLayout.Constraints(
                Spring.constant(0),
                Spring.constant(250),
                Spring.constant(400),
                Spring.constant(50)));

        p.setMinimum(0);
        p.setMaximum(100);
        p.setStringPainted(paint);
        paint = !paint;
        this.setVisible(true);
        p.setStringPainted(paint);
        Thread runner = new Thread() {
                int m;
                public void run() {
                    p.setIndeterminate(true);
                    try {
                        Thread.sleep(1000);
                    }
                    catch (Exception ex) {}
                    p.setIndeterminate(false);
                    for (m=0; m<=100; m++) 
                    {
                        Runnable runme = new Runnable() {
                                public void run() {
                                    p.setValue(m);
                                }
                            };
                        SwingUtilities.invokeLater(runme);
                        try {
                            Thread.sleep(50);
                        }
                        catch (Exception ex) {}
                    }
                    setVisible(false);

                    ob=new CALC();
                }

            };
        this.setLocationRelativeTo( null );
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        runner.start();

    }
}