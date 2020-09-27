import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

public class KeyChartGameFrame extends JFrame{
    Random random=new Random();
    String []b= {"Siam","Syeed","Suma","Ema","I Love Java","Maisha","Hridi","AIUB","MMA","Apple"};
   //String []a=new String[5];
   //String x;
   //a[0]= "Java" ; a[1]= "Suma" ; a[2]= "Ema" ; a[3]= "Siam" ;a[4]= "Syeed" ;
    int x,y,with,height,count=0; 
	private JPanel pnlupper,pnldown;
	private JTextField txtwrite,txtlife1,txtlife2,txtlife3,txtscore;
	private JLabel lblname,lblcount,lblscore;
	Timer timer;
	
	public KeyChartGameFrame() { 
		this.setTitle("Typing Master Game");
		this.setSize(700, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addComponent();   
	}
	
	public void addComponent()  
	{	
		pnldown= new JPanel();
		pnldown.setBorder(new TitledBorder(new LineBorder(Color.BLACK,2),"Text Box"));
		pnldown.setBounds(5, 310, 670, 138);
		pnldown.setLayout(null); 
		add(pnldown);
		this.DComponent(); 
		
		pnlupper= new JPanel();
		pnlupper.setBorder(new LineBorder(Color.RED,2));
		pnlupper.setBounds(5, 5, 675, 300);
		pnlupper.setLayout(null);
		add(pnlupper);
		this.UComponent(); 
	}
	 
	private void UComponent()
	{
		int z=random.nextInt(b.length); 
		lblname=new JLabel(b[z]); 
		//lblname=new JLabel("I Love Java");
		lblname.setFont(new Font("serif",Font.BOLD,15));
		pnlupper.setBackground(Color.WHITE); 
		lblname.setBackground(Color.lightGray);  
		
		lblcount=new JLabel("Score :");
		lblcount.setBounds(500, 5, 50, 50); 
		lblcount.setFont(new Font("serif",Font.BOLD,15));
		lblcount.setBackground(Color.WHITE); 
		lblcount.setBackground(Color.lightGray);  
		
		lblscore=new JLabel(); 
		//lblscore.setEditable(false);
		lblscore.setBounds(580, 5, 80, 50);
		lblscore.setFont(new Font("serif",Font.BOLD,15));
		lblscore.setBackground(Color.WHITE); 
		
		x=150;
		y=270; 
		with=100;
		height=30;
		lblname.setBounds(x, y, with, height); 
		timer=new Timer(300, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//lblname=new JLabel(b[z]); 
				y-=15;
				lblname.setBounds(x, y, with, height); 
				if((y>0)&&(txtwrite.getText().equals(lblname.getText())))
				{
					//pnlupper.setBackground(Color.GREEN); 
					count++;
					lblscore.setText(""+count); 
					
					int r=random.nextInt(b.length);
					lblname.setText(b[r]);
					
					if(x==150)
						x=450;
					else
						x=150;
					y=270; 
					with=100;
					height=30;

					lblname.setBounds(x, y, with, height); 
					txtwrite.setText(null);
					//timer.stop();  
					//JOptionPane.showMessageDialog(null, "Congratulations"); 
				}
				else if(y<=0)
				{
					pnlupper.setBackground(Color.RED); 
					timer.stop();  
					JOptionPane.showMessageDialog(null, "Game Over !!  Your Score Is : "+lblscore.getText()); 
				}
			}
		});
		timer.start(); 
		this.pnlupper.add(lblname);  
		this.pnlupper.add(lblcount);
		this.pnlupper.add(lblscore);
	} 
	
	private void DComponent()
	{
		txtwrite= new JTextField();
		txtwrite.setFont(new Font("serif",Font.BOLD,15));
		txtwrite.setBackground(Color.WHITE);
		txtwrite.setBounds(35, 55, 250, 50);
		this.pnldown.add(txtwrite);
		
		txtlife1= new JTextField();
		txtlife1.setEditable(false);
		txtlife1.setBackground(Color.WHITE);
		txtlife1.setBounds(395, 55, 20, 50);
		this.pnldown.add(txtlife1);
		
		txtlife2= new JTextField();
		txtlife2.setEditable(false);
		txtlife2.setBackground(Color.WHITE);
		txtlife2.setBounds(415, 55, 20, 50);
		this.pnldown.add(txtlife2);
		
		txtlife3= new JTextField();
		txtlife3.setEditable(false);
		txtlife3.setBackground(Color.WHITE);
		txtlife3.setBounds(435, 55, 20, 50);
		this.pnldown.add(txtlife3);
	}

} 
