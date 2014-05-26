package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.LibModel;
import Connections.Libdao;

public class LibServlet extends HttpServlet
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	LibModel lm1= new LibModel();
	public LibServlet() 
	 {
	        super();
	        //System.out.println("hello constructor");
	  }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		 
			String str=request.getParameter("form");
			if(str.equals("form1"))
			{
				String bid= request.getParameter("book_id");
				String tit= request.getParameter("title");
				String an= request.getParameter("author_name");
				response.setContentType("text/html");
				LibModel lm= new LibModel();
				lm.setBook_id(bid);
				Libdao ld= new Libdao();
				int i=ld.checkAvail(lm,tit,an);
				String str1;
				if(i==1)
				{
					request.setAttribute("data", lm);
					request.getRequestDispatcher("./JSP/showAvail.jsp").forward(request,response);
				}
				else
				{
					if(i==2)
						str1="No record found for given value(s)";
					else
						str1="Some error occured.";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
			}
			
			else if(str.equals("form2"))
			{
				String bid= request.getParameter("book_id");
				int brid= Integer.parseInt(request.getParameter("branch_id"));
				String card= request.getParameter("card_no");
				response.setContentType("text/html");
				LibModel lm= new LibModel();
				lm.setBook_id(bid);
				lm.setBrid(brid);
				lm.setCard(card);
				Libdao ld= new Libdao();
				int i=ld.checkOut(lm);
				String str1;
				if(i==1)
				{
					ld.checkoutHistory(lm);
					request.setAttribute("st","Checkout Successful");
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
					
				else
				{
					if(i==2)
						str1="Member is already having 3 books issued";
					else if(i==3)
						str1="Book not available at this branch";
					else
						str1="Wrong or Duplicate values may be entered";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
			else if(str.equals("form3"))
			{
				//System.out.println("hello123");
				String bid= request.getParameter("book_id");
				String card= request.getParameter("card_no");
				String name=request.getParameter("borrower_name");
				response.setContentType("text/html");
				 lm1 = new LibModel();
				lm1.setBook_id(bid);
				lm1.setCard(card);
				Libdao ld= new Libdao();
				int i=ld.checkIn(lm1, name);
				String str1;
				if(i==1)
				{
					request.setAttribute("data", lm1);
					request.getRequestDispatcher("./JSP/checkInSuccess.jsp").forward(request,response);
				}
					
				else
				{
					if(i==2)
						str1="No record found for given value(s)";
					else
						str1="Some error occured.";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
			else if(str.equals("form4"))
			{
				//System.out.println("hello321");
				int index = Integer.parseInt(request.getParameter("index"));
				response.setContentType("text/html");
				//System.out.println(lm1.book_ids.get(index-1)+" &"+lm1.branch_id.get(index-1)+" &"+lm1.cards.get(index-1));
				Libdao ld= new Libdao();
				int i=ld.checkIn2(lm1, index);
				String str1;
				if(i==1)
				{
					ld.checkinHistory(lm1,index);
					str1="Check In Successful.";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
					
				else
				{
					if(i==2)
						str1="Wrong index value entered";
					else
						str1="Some error occured.";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
			else if(str.equals("form5"))
			{
				//System.out.println("hello321");
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				String card = request.getParameter("card");
				response.setContentType("text/html");
				LibModel lm= new LibModel();
				lm.setCard(card);
				lm.setFname(fname);
				lm.setLname(lname);
				lm.setAddress(address);
				lm.setPhone(phone);
				Libdao ld= new Libdao();
				int i=ld.addBorrower(lm);
				String str1;
				if(i==1)
				{
					str1="New borrower added successfully.";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
					
				else
				{
					if(i==2)
						str1="One person can't possess more than one card";
					else
						str1="Wrong or Duplicate(card number) values may be entered";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
			else if(str.equals("form6"))
			{
				//System.out.println("hello321");
				String card = request.getParameter("card_no");
				response.setContentType("text/html");
				LibModel lm= new LibModel();
				lm.setCard(card);
				Libdao ld= new Libdao();
				int i=ld.checkCard(lm);
				String str1;
				//System.out.println(lm.getAddress());
				if(i==1)
				{
					request.setAttribute("data", lm);
					request.getRequestDispatcher("./JSP/updateBorrower.jsp").forward(request,response);
				}
					
				else
				{
					if(i==2)
						
						str1="Wrong card number entered";
					else
						str1="Some error occured";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
			else if(str.equals("form7"))
			{
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				String card = request.getParameter("card");
				response.setContentType("text/html");
				LibModel lm= new LibModel();
				lm.setCard(card);
				lm.setFname(fname);
				lm.setLname(lname);
				lm.setAddress(address);
				lm.setPhone(phone);
				Libdao ld= new Libdao();
				int i=ld.updateBorrower(lm);
				String str1;
				if(i==1)
				{
					str1="Details updated successfully";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
					
				else
				{
					if(i==2)
						str1="Entered details are similar to an existing member";
					else
						str1="Some error occured while updating";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
			else if(str.equals("Check In History"))
			{
				response.setContentType("text/html");
				LibModel lm= new LibModel();
				Libdao ld= new Libdao();
				int i=ld.checkinHistory2(lm);
				String str1;
				if(i==1)
				{
					request.setAttribute("data", lm);
					request.getRequestDispatcher("./JSP/checkinHistory.jsp").forward(request,response);
				}
					
				else
				{
					if(i==2)
						str1="No check in history";
					else
						str1="Some error occured";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
			else if(str.equals("Check Out History"))
			{
				response.setContentType("text/html");
				LibModel lm= new LibModel();
				Libdao ld= new Libdao();
				int i=ld.checkoutHistory2(lm);
				String str1;
				if(i==1)
				{
					request.setAttribute("data", lm);
					request.getRequestDispatcher("./JSP/checkoutHistory.jsp").forward(request,response);
				}
					
				else
				{
					if(i==2)
						str1="No check out history";
					else
						str1="Some error occured";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
			else if(str.equals("form9"))
			{
				String bid= request.getParameter("book_id");
				String tit= request.getParameter("title");
				String author=request.getParameter("author_name"); 
				response.setContentType("text/html");
				LibModel lm= new LibModel();
				Libdao ld= new Libdao();
				int i=ld.bookDetails(lm,bid,tit,author);
				String str1;
				if(i==1)
				{
					request.setAttribute("data", lm);
					request.getRequestDispatcher("./JSP/bookDetails.jsp").forward(request,response);
				}
					
				else
				{
					if(i==2)
						str1="No book found for the given value(s)";
					else
						str1="Some error occured";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
			else if(str.equals("form10"))
			{
				//System.out.println("hello123");
				String card= request.getParameter("card_no");
				String name=request.getParameter("borrower_name");
				response.setContentType("text/html");
				LibModel lm = new LibModel();
				Libdao ld= new Libdao();
				int i=ld.borrowerDetails(lm, card, name);
				String str1;
				if(i==1)
				{
					System.out.println("i=1");
					request.setAttribute("data", lm);
					request.getRequestDispatcher("./JSP/borrowerDetails.jsp").forward(request,response);
				}
					
				else
				{
					System.out.println("i=2");
					if(i==2)
						str1="No record found for given value(s)";
					else
						str1="Some error occured.";
					request.setAttribute("st",str1);
					request.getRequestDispatcher("./JSP/message.jsp").forward(request,response);
				}
				
			}
		}
		
		

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}

	}

