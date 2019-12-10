package Shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.Statement;

public class Agentdata {
	connectionmanager2 con=new connectionmanager2();

	public void agentdetails() throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			Scanner s=new Scanner(System.in);
			int flag=0,flag1=0;
			String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
			Pattern pswNamePtrn = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
			Pattern pattern = Pattern.compile(regex);
			System.out.println("Enter the username");
			String user=s.next();
			Matcher m=pattern.matcher(user);
			System.out.println("Enter the password");
			String pass=s.next();
			Matcher o=pswNamePtrn.matcher(pass);
			if(m.matches())
			{
				System.out.println("Valid Adminname");
				flag=1;
			}
			else
			{
				System.out.println("Invalid Adminname");
			}
			if(o.matches())
			{
				System.out.println("Valid password");
				flag1=1;
			}
			else
			{
				System.out.println("Invalid password");
			}
			if(flag==1 && flag1==1)
			{
				//for store data in database we use preparedstatement
				PreparedStatement st=(PreparedStatement) con.getConnection().prepareStatement("insert into" +" agentlogin(Username,Password) values(?,?);");
				st.setString(1,user);//1 means index value
				st.setString(2,pass);
				
				st.executeUpdate();//value will be updated to database
				//con.getConnection().close();
				System.out.println("Successfully verified");
				}
				else
				{
					System.out.println("Agent data insertion failed");
				}
		
		Agentdata ag=new Agentdata();
		ag.choice1();
	}
	public void choice1() throws ClassNotFoundException,SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("1) Buysell");
		System.out.println("2) View Product");
		System.out.println("3) Home page");
		
        System.out.println("Enter the choice");
		int d=sc.nextInt();
		
		
		switch(d)
		{
		case 1:
			System.out.println("Enter the id");
            int id1=sc.nextInt();
            System.out.println("Enter the quantity");
            int quant=sc.nextInt();
            Statement sp=(Statement)con.getConnection().createStatement();
            ResultSet r3=sp.executeQuery("Select * from addproduct");
            int price=0,tot=0;
            while(r3.next())
            {
            	if(r3.getInt(1)==id1)
            	{
            		if(quant<=r3.getInt(3))
            		{
            			price=r3.getInt(4);
            			tot=price*quant;
            			System.out.println("Cost is "+tot);
            			int newqunty=r3.getInt(3)-quant;
            			System.out.println("Thanks for your purchase");
            			PreparedStatement st1=(PreparedStatement) con.getConnection().prepareStatement("update addpproduct set agentlogin(Username,Password) values(?,?);");
            			st1.setInt(1, newqunty);
            			st1.setInt(2, id1);
            		}
            		else
            		{
            			System.out.println("Out of stock");
            		}
            	}
            
            }
            break;
		case 2:
			System.out.println("~~~~~List Of Product~~~~~");
			System.out.println("########**********########");
			Statement s1=(Statement)con.getConnection().createStatement();
			ResultSet r=s1.executeQuery("select * from addproduct");
			while(r.next())//for get values one by one
			{
				System.out.println("######################");
				
				System.out.println("Product ID:  "+r.getInt(1)+"\n"+"Product name:       "+r.getString(2)+"\n"+"Quantity:        "+r.getInt(3)+"\n"+"Price:      "+r.getInt(4));
				System.out.println("######################");
			}
			break;
		case 3:
			System.out.println("Agent Account Logout");
			
		case 4:
			
		shoppingapp sh=new shoppingapp();
		sh.choice();
		break;
		default:
			break;
		
		}

	}
	}

