package Model;

import java.util.ArrayList;

public class LibModel 
{
	private String book_id;
	public ArrayList<String> branch_id= new ArrayList<String>();
	public ArrayList<Integer> no_copies= new ArrayList<Integer>();
	public ArrayList<Integer> available= new ArrayList<Integer>();
	private int brid;
	private String card;
	public ArrayList<String> book_ids= new ArrayList<String>();
	public ArrayList<String> book_titles= new ArrayList<String>();
	public ArrayList<String> names= new ArrayList<String>();
	public ArrayList<String> addresses= new ArrayList<String>();
	public ArrayList<String> phones= new ArrayList<String>();
	public ArrayList<String> cards= new ArrayList<String>();
	public ArrayList<String> date_out= new ArrayList<String>();
	public ArrayList<String> due_date= new ArrayList<String>();
	private String fname;
	private String lname;
	private String address;
	private String phone;
	
	
	
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public int getBrid() {
		return brid;
	}
	public void setBrid(int brid) {
		this.brid = brid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
