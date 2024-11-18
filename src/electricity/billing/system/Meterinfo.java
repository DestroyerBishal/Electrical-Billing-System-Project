package electricity.billing.system;
import javax.swing.*; 
import java.awt.*; 
import java.util.*; 
import java.awt.event.*;

public class Meterinfo extends JFrame implements ActionListener { 
    
    JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfphone; 
    JButton next,cancel; 
    JLabel lblmeter; 
    Choice meterlocation,metertype,Phasecode,billtype;
    Meterinfo(){ 
        setSize(700,500); 
        setLocation(400,200);  
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p); 
        
        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(180,10,200,25);  
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblname=new JLabel("Meter Number");
        lblname.setBounds(100,80,100,20); 
        p.add(lblname); 
        
        JLabel lblmeternumber=new JLabel();
        lblmeternumber.setBounds(240,80,100,20); 
        p.add(lblmeternumber); 
        
        JLabel lblmeterno=new JLabel("Meter Location");
        lblmeterno.setBounds(100,120,100,20); 
        p.add(lblmeterno); 
        
        meterlocation=new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside"); 
        meterlocation.setBounds(240,120,200,20);
        p.add(meterlocation);
        
        
        
        JLabel lbladdress=new JLabel("Meter Type");
        lbladdress.setBounds(100,160,100,20); 
        p.add(lbladdress);
        
        metertype=new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");  
        metertype.add("Smart Meter");  
        metertype.setBounds(240,160,200,20);
        p.add(metertype);
        
        JLabel lblcity=new JLabel("Phase Code");
        lblcity.setBounds(100,200,100,20); 
        p.add(lblcity);
        
        Phasecode = new Choice();
        Phasecode.add("011");
        Phasecode.add("022");  
        Phasecode.add("033");  
        Phasecode.add("044");  
        Phasecode.add("055");  
        Phasecode.add("066");  
        Phasecode.add("077");  
        Phasecode.add("088");  
        Phasecode.add("099"); 
        Phasecode.setBounds(240,200,200,20);
        p.add(Phasecode);
        
        
        JLabel lblstate=new JLabel("Bill Type");
        lblstate.setBounds(100,240,100,20); 
        p.add(lblstate);
        
        billtype=new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");  
        billtype.setBounds(240,240,200,20);
        p.add(billtype); 
        
        JLabel lblemail=new JLabel("Days");
        lblemail.setBounds(100,280,100,20); 
        p.add(lblemail);
        
        JLabel lblphone=new JLabel("30 Days");
        lblphone.setBounds(240,320,100,20); 
        p.add(lblphone); 
        
        JLabel lblnotes=new JLabel("Notes");
        lblnotes.setBounds(100,320,100,20); 
        p.add(lblnotes);
        
        JLabel lblnotes1=new JLabel("By Default Bill is calculated for 30 days only");
        lblnotes1.setBounds(240,320,500,20); 
        p.add(lblnotes1);
        
        
        

        
        next=new JButton("Next"); 
        next.setBounds(120,390,100,25); 
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);  
        
        cancel=new JButton("Cancel"); 
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);  
        
        setLayout(new BorderLayout()); 
        
        add(p,"Center"); 
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2); 
        JLabel image= new JLabel(i3);
        add(image,"West"); 
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setVisible(true); 
    }
        public void actionPerformed(ActionEvent ae){ 
            if(ae.getSource()== next){ 
                String name=tfname.getText(); 
                String meter=lblmeter.getText();
                String address=tfaddress.getText();
                String city=tfcity.getText();
                String state=tfstate.getText(); 
                String email=tfemail.getText();
                String phone=tfphone.getText(); 
                
            String query1="insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
            String query2="insert into login values('"+meter+"','','"+name+"','','')";  
            
            try{
                Conn c=new Conn(); 
                c.s.executeUpdate(query1); 
                c.s.executeUpdate(query2); 
                
                JOptionPane.showMessageDialog(null, "Customer Detail Added Successfully");  
                setVisible(false);
            } catch(Exception e){ 
                e.printStackTrace();
            }
        }else{ 
            setVisible(false);     
        }
    }
     
    public static void main(String[] args){ 
        new Meterinfo();
    
    }
}
