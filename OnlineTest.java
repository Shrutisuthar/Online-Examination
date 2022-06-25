
package quiz;

/**
 *
 * @author Shruti
 */

import java.util.Calendar;

import java.awt.*;  
import java.awt.event.*;  
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;  
import java.util.TimeZone;
import javax.swing.Timer;
  
class OnlineTest extends JFrame implements ActionListener  
{  
    long sTime=System.currentTimeMillis();
    JLabel l,to,d;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];  
          Calendar c = Calendar.getInstance();        
        String timStr = String.format("%d:%02d:%02d", c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
   
    OnlineTest(String s)  
    {  
        super(s);  
      
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        to = new JLabel();
       
        //t.setText("Your Current time is this"+ timStr+ "submit it in 5 minutes");
        to.setBounds(50, 300, 450, 30);
        to.setForeground(Color.red);
        add(to);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(500,200);  
        setVisible(true);  
        setSize(1000,500); 
    }  

   
    public void actionPerformed(ActionEvent e)  
    {  
           javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//                    sdf.format(new java.util.Date());
                    to.setText("Current Time :"+sdf.format(new java.util.Date()));
                }
                
            }
            );
           t.start();
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  

            long totalTime = System.currentTimeMillis()-sTime;
            System.out.println(totalTime);
            if(totalTime<1000000)
            {
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
            }
            else
            {
            JOptionPane.showMessageDialog(this,"you taken more time next time submit it on time");  
            System.exit(0); 
            }
            //System.out.println("correct ans="+count);  
             
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Which component is used to debug and execute the java programs?");  
            jb[0].setText("JRE");jb[1].setText("JDK");jb[2].setText("JIT");jb[3].setText("JVM");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Which one of the following is not a Java feature?");  
            jb[0].setText("Object-oriented");jb[1].setText("Use of pointers");jb[2].setText("Portable");jb[3].setText("Dynamic");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which of these cannot be used for a variable name in Java?");  
            jb[0].setText("keyword");jb[1].setText("identifier");jb[2].setText("both");jb[3].setText("none of above");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: String class is defined in which package?");  
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: What is the extension of java code files?");  
            jb[0].setText(".js");jb[1].setText(".txt");jb[2].setText(".class");jb[3].setText(".java");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which one among these is not a keyword?");  
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which one among these is not a class? ");  
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");  
                        jb[3].setText("Button");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Which of the following is not an OOPS concept in Java?");  
            jb[0].setText("Polymorphism");jb[1].setText("Inheritance");jb[2].setText("Compilation");  
                        jb[3].setText("Encapsulation");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: which function is not present in Applet class?");  
            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which of the below is not a Java Profiler?");  
            jb[0].setText("JProfiler");jb[1].setText("Eclipse Profiler");jb[2].setText("JConsole");  
                        jb[3].setText("JVM");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[0].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[3].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[2].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[3].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {   
        new OnlineTest("Online Test Of Java");  
    }  
}  
