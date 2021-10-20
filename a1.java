package assignment;
import java.sql.*;
import java.util.Scanner;
public class a1 {
	public void get2()throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String url ="jdbc:mysql://localhost:3306/data1";
		String user="root";
		String pass="7776991441";
		System.out.println("hello");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		System.out.println("Enter student id:");
		String tar=sc.next();
		String q = "SELECT * FROM data1.STUDENT WHERE STUDENT_NO="+tar; 
		Statement st = con.createStatement();
		
		ResultSet r =st.executeQuery(q);
		while(r.next())
		{ 
			System.out.println(r.getString(1)+"   "+r.getString(2)+"   "+r.getString(3)+"   "+r.getString(4));
		}
		

	}
	public void delete()throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String url ="jdbc:mysql://localhost:3306/data1";
		String user="root";
		String pass="7776991441";
		System.out.println("hello");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
        System.out.println("Enter Sttudent id");     
		String tar = sc.next();
		//String sql = "DELETE FROM data1.student WHERE STUDENT_NO =11";
		Statement st = con.createStatement();
		String sql = "DELETE FROM data1.student WHERE STUDENT_NO ="+tar;
		PreparedStatement pt= con.prepareStatement(sql);
		pt.execute();
		System.out.println("DATA deleted");
		
		
	}
	public void insert()throws Exception
	{
        Scanner sc = new Scanner(System.in);
		String url ="jdbc:mysql://localhost:3306/data1";
		String user="root";
		String pass="7776991441";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		String no,name,dateB,datej;
		System.out.println("Enter student number");
		
		no=sc.next();
		System.out.println("Enter student name");
		name=sc.next();
		System.out.println("Enter student date of birth");
		dateB=sc.next();;
		System.out.println("Enter student date of joining");
		datej=sc.next();
		String sql = "insert into data1.student values(?,?,?,?)";
		PreparedStatement pt= con.prepareStatement(sql);
		pt.setString(1, no);
		pt.setString(2, name);
		pt.setString(3, dateB);
		pt.setString(4, datej);
		pt.execute();
		System.out.println("data added");
		sc.close();
		
		
	}
	public void getdata()throws Exception
	{
		String url ="jdbc:mysql://localhost:3306/data1";
		String user="root";
		String pass="7776991441";
		System.out.println("hello");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		String filt = "6";
		String q = "SELECT * FROM data1.STUDENT"; 
		Statement st = con.createStatement();
		
		ResultSet r =st.executeQuery(q);
		while(r.next())
		{ 
			System.out.println(r.getString(1)+"   "+r.getString(2)+"   "+r.getString(3)+"   "+r.getString(4));
		}
		
		
	}

	public static void main(String[] args)throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		a1 aa = new a1();
		try {
		int ch=0;
		do
		{
			System.out.println("1:Insert Data\n2:Delete Data\n3:view All\n4:View by student id\n0:quit");
			ch=sc.nextInt();
			if(ch==1)
			{
				aa.insert();
			}
			if(ch==2)
			{
				aa.delete();
			}
			if(ch==3)
			{
				aa.getdata();
			}
			if(ch==4)
			{
				aa.get2();
			}
		}while(ch!=0);
		}
	catch(Exception e)
		{
		System.out.println("Rerun the program to continiue");
		}

	}
}
