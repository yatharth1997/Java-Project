import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
class myframe
{
	JFrame f;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3,b4,b5,b6,b7;
	myframe()
	{	
		f=new JFrame("Student Information");
		f.getContentPane().setLayout(null);
		l1=new JLabel("Name");
		t1=new JTextField(15);
		l2=new JLabel("Roll No");
		t2=new JTextField(15);
		l3=new JLabel("CGPA");
		t3=new JTextField(25);
		l4=new JLabel("College");
		t4=new JTextField(15);
		b1=new JButton("|<");
		b2=new JButton("<");
		b3=new JButton(">");
		b4=new JButton(">|");
		b5=new JButton("Add");
		b6=new JButton("Delete");
		b7=new JButton("Search");
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				fileread a=new fileread();
				try
				{
					a.read();
				}
				catch(Exception e){}
				t1.setText(a.name.substring(0,8));
				t2.setText(a.roll_no.substring(0,12));
				t3.setText(a.cgpa.substring(0,12));
				t4.setText(a.college.substring(0,13));
			}
        	
        });
		b7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				search a=new search();
				try
				{
					a.read(t1.getText(),t2.getText(),t3.getText(),t4.getText());
				}
				catch(Exception e){}
				String t11=t1.getText();
				String t22=t2.getText();
				String t33=t3.getText();
				String t44=t4.getText();
				String p=" ";
				for(int i=t11.length();i<8;i++)
				{
					t11=t11+p;
				}
				for(int j=t22.length();j<12;j++)
				{
					t22=t22+p;
				}
				for(int k=t33.length();k<12;k++)
				{
					t33=t33+p;
				}
				for(int l=t44.length();l<13;l++)
				{
					t44=t44+p;
				}
				if(t11.equals(a.name)||t22.equals(a.roll_no)||t33.equals(a.cgpa)||t44.equals(a.college))
				 {
				 t1.setText(a.name.substring(0,7));
				 t2.setText(a.roll_no.substring(0,11));
				 t3.setText(a.cgpa.substring(0,11));
				 t4.setText(a.college.substring(0,12));
				 }
				 else
				 {
					JOptionPane.showMessageDialog(f, "No Match Found");
				}
			}
        	
        });
		
		b5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String name,roll_no,cgpa,college;
				String name1=" ";
				String roll_no1=" ";
				String cgpa1=" ";
				String college1=" ";
				name=t1.getText().toString();
				for(int i=name.length();i<7;i++)
				{
					name1=name1+" ";
				}
				roll_no=t2.getText().toString();
				for(int j=roll_no.length();j<11;j++)
				{
					roll_no1=roll_no1+" ";
				}
				cgpa=t3.getText().toString();
				for(int k=cgpa.length();k<11;k++)
				{
					cgpa1=cgpa1+" ";
				}
				college=t4.getText().toString();
				for(int l=college.length();l<12;l++)
				{
					college1=college1+" ";
				}
				try
				{
					FileWriter w1=new FileWriter("info.txt",true);
					w1.write(System.getProperty("line.separator"));
					w1.write(name+name1+"| ");
					w1.write(roll_no+roll_no1+"| ");
					w1.write(cgpa+cgpa1+"| ");
					w1.write(college+college1+"| ");
					JOptionPane.showMessageDialog(f, "Data Added");
					w1.close();
				}
					catch(Exception e){
					JOptionPane.showMessageDialog(f, "Error");
					}		
			}
		});
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				data d=new data();
				try
				{
					d.read(1);
				}
				catch(Exception e){}
				t1.setText(d.name);
				t2.setText(d.roll_no);
				t3.setText(d.cgpa);
				t4.setText(d.college);

			}
        	
        });
				b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				rownum r=new rownum();
				data d=new data();
				try
				{
					int i=r.read(t1.getText());
					d.read(i-1);
				}
				catch(Exception e){}
				t1.setText(d.name);
				t2.setText(d.roll_no);
				t3.setText(d.cgpa);
				t4.setText(d.college);

			}
        	
        	});
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				rownum r=new rownum();
				data d=new data();
				try
				{
					int i=r.read(t1.getText());
					d.read(i+1);
				}
				catch(Exception e){}
				t1.setText(d.name);
				t2.setText(d.roll_no);
				t3.setText(d.cgpa);
				t4.setText(d.college);

			}
        	
        	});
		b6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
		});
		l1.setBounds(50,20,120,27);
		l2.setBounds(50,90,120,27);
		l3.setBounds(50,160,120,27);
		l4.setBounds(50,230,120,27);
		t1.setBounds(220,20,180,27);
		t2.setBounds(220,90,180,27);
		t3.setBounds(220,160,180,27);
		t4.setBounds(220,230,180,27);
		b1.setBounds(50,300,80,27);
		b2.setBounds(140,300,80,27);
		b3.setBounds(230,300,80,27);
		b4.setBounds(320,300,80,27);
		b5.setBounds(50,370,80,27);
		b6.setBounds(185,370,80,27);
		b7.setBounds(320,370,80,27);
		l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		l4.setForeground(Color.blue);
		f.getContentPane().add(l1);
		f.getContentPane().add(l2);
		f.getContentPane().add(l3);
		f.getContentPane().add(l4);
		f.getContentPane().add(t1);
		f.getContentPane().add(t2);
		f.getContentPane().add(t3);
		f.getContentPane().add(t4);
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.getContentPane().add(b3);
		f.getContentPane().add(b4);
		f.getContentPane().add(b5);
		f.getContentPane().add(b6);
		f.getContentPane().add(b7);
		f.setSize(500,500);
		
		f.setVisible(true);
	}
}
class rownum
{
	String line,name,roll_no,cgpa,college;
	int i=0;
	int read(String t1)throws IOException{
	FileReader fr=new FileReader("info.txt");
	BufferedReader br=new BufferedReader(fr);
		while((line=br.readLine())!=null)
		{
		i++;
		name=line.substring(0,8);
		roll_no=line.substring(10,22);
		cgpa=line.substring(24,36);
		college=line.substring(38,line.length()-2);
		if(t1.equals(name))
		{
			break;
		}
		}
	br.close();
	return i;
}
}
class data
{
	String line,name,roll_no,cgpa,college;
	void read(int n)throws IOException{
	
	FileReader fr=new FileReader("info.txt");
	BufferedReader br=new BufferedReader(fr);
		while(((line=br.readLine())!=null)&&(n>0))
		{
		name=line.substring(0,8);
		roll_no=line.substring(10,22);
		cgpa=line.substring(24,36);
		college=line.substring(38,line.length()-2);
		n--;
		}
	br.close();
}
}
class search
{
	String line,name,roll_no,cgpa,college;
	void read(String t1,String t2,String t3,String t4)throws IOException{
	
	FileReader fr=new FileReader("info.txt");
	BufferedReader br=new BufferedReader(fr);
	String p=" ";
	while((line=br.readLine())!=null)
	{
		 name=line.substring(0,8);
		 roll_no=line.substring(10,22);
		 cgpa=line.substring(24,36);
		 college=line.substring(38,line.length()-2);
		 for(int i=t1.length();i<8;i++)
		 {
			t1=t1+p;
		 }
		 for(int j=t2.length();j<12;j++)
		 {
			t2=t2+p;
		 }
		 for(int k=t3.length();k<12;k++)
		 {
			t3=t3+p;
		 }
		 for(int l=t4.length();l<13;l++)
		 {
			t4=t4+p;
		 }
		 if(t1.equals(name)||t2.equals(roll_no)||t3.equals(cgpa)||t4.equals(college))
		 {
			break;
		 }
	}
	br.close();
}
}
class fileread
{
	String line,name,roll_no,cgpa,college;
	void read()throws IOException{
	
	FileReader fr=new FileReader("info.txt");
	BufferedReader br=new BufferedReader(fr);
	while((line=br.readLine())!=null)
	{
		name=line.substring(0,9);
		roll_no=line.substring(10,23);
		cgpa=line.substring(24,37);
		college=line.substring(38,line.length()-1);
		System.out.print(name);
		System.out.print(roll_no);
		System.out.print(cgpa);
		System.out.println(college);
	}
	br.close();
}
}
class student_info{
	public static void main(String [] args) throws IOException
	{
		fileread f=new fileread();
		f.read();
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new myframe();
			}
		});
	}
}