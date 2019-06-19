package transaction_details;

public class transaction_details_pojo {

	  private String transaction_id;
	  private int account_no;
	  private String transaction_date;
	  private String mode_of_transaction;
	  private String transaction_type;
	  private int transaction_amount;
	  private String transaction_remarks;
	  private String receiver_account_no;

	  public String getTransaction_id() 
	  {
		return transaction_id;
	  }
	  public void setTransaction_id(String transaction_id)
	  {
		this.transaction_id = transaction_id;
	  }
	  public int getAccount_no() 
	  {
		return account_no;
	  }
	public void setAccount_no(int account_no) 
	  {
		this.account_no = account_no;
	  }
	public String getTransaction_date() 
	  {
		return transaction_date;
	  }
	public void setTransaction_date(String transaction_date) 
	  {
		this.transaction_date = transaction_date;
	  }
	public String getMode_of_transaction() 
	  {
		return mode_of_transaction;
	  }
	public void setMode_of_transaction(String mode_of_transaction) 
	  {
		this.mode_of_transaction = mode_of_transaction;
	  }
	public String getTransaction_type() 
	  {
		return transaction_type;
	  }
	public void setTransaction_type(String transaction_type) 
	  {
		this.transaction_type = transaction_type;
	  }
	public int getTransaction_amount() 
	  {
		return transaction_amount;
	  }
	public void setTransaction_amount(int transaction_amount) 
	  {
		this.transaction_amount = transaction_amount;
	  }
	public String getTransaction_remarks() 
	  {
		return transaction_remarks;
	  }
	public void setTransaction_remarks(String transaction_remarks) 
	  {
		this.transaction_remarks = transaction_remarks;
	  }
	public String getReceiver_account_no() 
	  {
		return receiver_account_no;
	  }
	public void setReceiver_account_no(String receiver_account_no) 
	  {
		this.receiver_account_no = receiver_account_no;
	  }
}
