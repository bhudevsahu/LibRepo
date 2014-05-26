package Connections;

import Model.LibModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Libdao 
{
	public int checkAvail(LibModel lm ,String tit, String an)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			String val = "select distinct ab.book_id, ab.branch_id, ab.no_of_copies, (ab.no_of_copies-ab.num_o) as num_avail from (select bc.branch_id, bc.book_id, bc.title, bc.no_of_copies, coalesce(bl.num_out,0) as num_o from (select branch_id, book.book_id, book.title, no_of_copies from book_copies inner join book on book_copies.book_id=book.book_id where book_copies.book_id like '%"+lm.getBook_id()+"%') as bc left join (select branch_id,  book_id, count(*) as num_out from book_loans where book_id like '%"+lm.getBook_id()+"%' group by branch_id,book_id)as bl on bc.book_id=bl.book_id and bc.branch_id=bl.branch_id) as ab inner join book_authors ba on ba.book_id=ab.book_id where title like '%"+tit+"%' and author_name like '%"+an+"%'";
			rs=st.executeQuery(val);
			if(rs.next())
			{
				int a=0;
				do
				{	
					//System.out.println("hello# "+a);
					lm.book_ids.add(rs.getString(1));
					lm.branch_id.add(rs.getString(2));
					lm.no_copies.add(rs.getInt(3));
					lm.available.add(rs.getInt(4));
				}
				while(rs.next());
				return 1;
			}
				return 2;
		}
			
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
	}
	public int checkOut(LibModel lm)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			//System.out.println("one");
			String val = "select count(*) from book_loans group by card_no having card_no='"+lm.getCard()+"'";
			//System.out.println("two");
			rs=st.executeQuery(val);
			//System.out.println("three");
			if(rs.next())
			{
				int card =rs.getInt(1);
				//System.out.println(card+"#");
				if(card<3)
				{
					//System.out.println("inside true");
					String val2 = "select (no_of_copies-num_out) as num_avail from (select bcb.branch_id, bcb.no_of_copies, coalesce(bl.num_out,0) as num_out from (select bc.branch_id, bc.no_of_copies from book_copies bc inner join book b on bc.book_id=b.book_id where b.book_id='"+lm.getBook_id()+"') as bcb left join (select branch_id, count(book_id) as num_out from book_loans where book_id='"+lm.getBook_id()+"' group by branch_id) as bl on bcb.branch_id=bl.branch_id) as ab where branch_id="+lm.getBrid();
					rs=st.executeQuery(val2);
					while(rs.next())
					{
						int avail=rs.getInt(1);
						//System.out.println(avail+"#");
						if (avail>0)
						{
							//System.out.println("more inside");
							String addCheckOut= "insert into book_loans values ('"+lm.getBook_id()+"', "+lm.getBrid()+", '"+lm.getCard()+"', curdate(), (curdate()+ interval 14 day ))";
							st.executeUpdate(addCheckOut);
							//System.out.println("inserted successfully");
							return 1;
						}
						return 3;
					}
					return i;
				}
				//System.out.println("return 2");
				return 2;
			}
			if(!rs.next())
			{
				//System.out.println("empty set");
				String val1 = "select (no_of_copies-num_out) as num_avail from (select bcb.branch_id, bcb.no_of_copies, coalesce(bl.num_out,0) as num_out from (select bc.branch_id, bc.no_of_copies from book_copies bc inner join book b on bc.book_id=b.book_id where b.book_id='"+lm.getBook_id()+"') as bcb left join (select branch_id, count(book_id) as num_out from book_loans where book_id='"+lm.getBook_id()+"' group by branch_id) as bl on bcb.branch_id=bl.branch_id) as ab where branch_id="+lm.getBrid();
				rs=st.executeQuery(val1);
				while(rs.next())
				{
					int avail=rs.getInt(1);
					//System.out.println(avail+"#");
					if (avail>0)
					{
						String addCheckOut= "insert into book_loans values ('"+lm.getBook_id()+"', "+lm.getBrid()+", '"+lm.getCard()+"', curdate(), (curdate()+ interval 14 day ))";
						st.executeUpdate(addCheckOut);
						//System.out.println("inserted successfully");
						return 1;
					}
					return 3;
				}
			}
			
			//System.out.println("return i");
			return i;
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
		
		
	}
	public void checkoutHistory(LibModel lm)
	{
		Connection con=LibConnection.connectDao();
		try 
		{
			Statement st=con.createStatement();
			String val = "insert into checkouthistory values('"+lm.getBook_id()+"',"+lm.getBrid()+",'"+lm.getCard()+"',curdate())";
			st.executeUpdate(val);
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
		}
	}
	public int checkoutHistory2(LibModel lm)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			String val = "select * from checkouthistory";
			rs=st.executeQuery(val);
			if(rs.next())
			{
				do
				{	
					//System.out.println("hello# "+a);
					lm.book_ids.add(rs.getString(1));
					lm.branch_id.add(rs.getString(2));
					lm.cards.add(rs.getString(3));
					lm.date_out.add(rs.getString(4));
				}
				while(rs.next());
				return 1;
			}
			return 2;
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
	}
	public int checkIn(LibModel lm, String name)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			String val = "select bl.book_id,bl.branch_id, bl.card_no,bl.date_out, bl.due_date  from book_loans bl inner join borrower b on bl.card_no=b.card_no where concat(b.fname,b.lname) like '%"+name+"%' and bl.card_no like '%"+lm.getCard()+"%' and bl.book_id like '%"+lm.getBook_id()+"%'";
			rs=st.executeQuery(val);
			if(rs.next())
			{
				do
				{	
					//System.out.println("hello# "+a);
					lm.book_ids.add(rs.getString(1));
					lm.branch_id.add(rs.getString(2));
					lm.cards.add(rs.getString(3));
					lm.date_out.add(rs.getString(4));
					lm.due_date.add(rs.getString(5));
				}
				while(rs.next());
				return 1;
			}
			return 2;
		}
			
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
		
	}
	public int checkIn2(LibModel lm, int index)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();

		try 
		{
			Statement st=con.createStatement();
			//System.out.println("one");
			//System.out.println(lm.book_ids.get(index-1)+" &"+lm.branch_id.get(index-1)+" &"+lm.cards.get(index-1));
			String val = "delete from book_loans where book_id='"+lm.book_ids.get(index-1)+"' and branch_id ="+lm.branch_id.get(index-1)+" and card_no='"+lm.cards.get(index-1)+"'";
			st.executeUpdate(val);
			return 1;
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("entered exception "+e);
			return 2;
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
		
	}
	public void checkinHistory(LibModel lm, int index)
	{
		Connection con=LibConnection.connectDao();
		try 
		{
			Statement st=con.createStatement();
			String val = "insert into checkinhistory values('"+lm.book_ids.get(index-1)+"',"+lm.branch_id.get(index-1)+",'"+lm.cards.get(index-1)+"',curdate())";
			st.executeUpdate(val);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("entered exception "+e);
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
		}
	}
	public int checkinHistory2(LibModel lm)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			String val = "select * from checkinhistory";
			rs=st.executeQuery(val);
			if(rs.next())
			{
				
				do
				{	
					//System.out.println("hello# "+a);
					lm.book_ids.add(rs.getString(1));
					lm.branch_id.add(rs.getString(2));
					lm.cards.add(rs.getString(3));
					lm.date_out.add(rs.getString(4));
				}
				while(rs.next());
				return 1;
			}
			return 2;
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
	}
	public int bookDetails(LibModel lm, String bid, String tit, String author)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			String val = "select b.book_id,b.title,a.author_name from book b inner join book_authors a on b.book_id=a.book_id where b.book_id like '%"+bid+"%' and b.title like '%"+tit+"%' and a.author_name like '%"+author+"%'";
			rs=st.executeQuery(val);
			if(rs.next())
			{
				do
				{	
					//System.out.println("hello# "+a);
					lm.book_ids.add(rs.getString(1));
					lm.book_titles.add(rs.getString(2));
					lm.names.add(rs.getString(3));
				}
				while(rs.next());
				return 1;
			}
			return 2;
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
	}
	public int borrowerDetails(LibModel lm, String card, String name)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			String val= "select b.card_no, concat(b.fname,' ',b.lname), b.address, b.phone, coalesce(l.book_id,'---') ,coalesce(l.branch_id,'---') from borrower b left join book_loans l on b.card_no=l.card_no where concat(b.fname,b.lname) like '%"+name+"%' and b.card_no like '%"+card+"%'";
			rs=st.executeQuery(val);
			if(rs.next())
			{
				do
				{	
					//System.out.println("hello# ");
					lm.cards.add(rs.getString(1));
					lm.names.add(rs.getString(2));
					lm.addresses.add(rs.getString(3));
					lm.phones.add(rs.getString(4));
					lm.book_ids.add(rs.getString(5));
					lm.branch_id.add(rs.getString(6));
				}
				while(rs.next());
				return 1;
			}
			return 2;
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
	}
	public int addBorrower(LibModel lm)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			//System.out.println("one");
			String val = "select fname, lname, address from borrower";
			rs=st.executeQuery(val);
			while(rs.next())
			{
				if(rs.getString(1).equalsIgnoreCase(lm.getFname()))
						if(rs.getString(2).equalsIgnoreCase(lm.getLname()))
							if(rs.getString(3).equalsIgnoreCase(lm.getAddress()))
									return 2;
						
			}
			String val1 = "insert into borrower values('"+lm.getCard()+"','"+lm.getFname()+"','"+lm.getLname()+"','"+lm.getAddress()+"','"+lm.getPhone()+"')";
			st.executeUpdate(val1);
			return 1;
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
		
	}
	public int checkCard(LibModel lm)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			String val = "select * from borrower where card_no='"+lm.getCard()+"'";
			rs=st.executeQuery(val);
			if(rs.next())
			{
				lm.setFname(rs.getString(2));
				lm.setLname(rs.getString(3));
				lm.setAddress(rs.getString(4));
				lm.setPhone(rs.getString(5));
				
				return 1;
			}
			else	
				return 2;
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
		
	}
	public int updateBorrower(LibModel lm)
	{
		int i=-1;
		Connection con=LibConnection.connectDao();
		ResultSet rs;
		try 
		{
			Statement st=con.createStatement();
			//System.out.println("one");
			String val = "select fname, lname, address from borrower where card_no not in ('"+lm.getCard()+"')";
			rs=st.executeQuery(val);
			while(rs.next())
			{
				if(rs.getString(1).equalsIgnoreCase(lm.getFname()))
					if(rs.getString(2).equalsIgnoreCase(lm.getLname()))
						if(rs.getString(3).equalsIgnoreCase(lm.getAddress()))
							return 2;
			}
			String val1 = "update Borrower set fname='"+lm.getFname()+"',lname='"+lm.getLname()+"', address='"+lm.getAddress()+"', phone='"+lm.getPhone()+"' where card_no='"+lm.getCard()+"'";
			st.executeUpdate(val1);
			return 1;
			
		}
		catch(SQLException e)
		{
			System.out.println("entered exception "+e);
			return i;
		}
		
	}
		
	
}
