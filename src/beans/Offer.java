package beans;


public class Offer {
	private int cpid;
	private String ean;
	private String internalref;
	private int pid;
	private String productPath;
	private int sid;


	
	public Offer(){
		
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getProductPath() {
		return productPath;
	}

	public void setProductPath(String productPath) {
		this.productPath = productPath;
	}





	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCpid() {
		return cpid;
	}

	public void setCpid(int cpid) {
		this.cpid = cpid;
	}





	private String sku;

	public String getInternalref() {
		return internalref;
	}

	public void setInternalref(String internalref) {
		this.internalref = internalref;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String toString(){
		return  ">"+ this.getClass()+ " matched "+this.getCpid() + " ean "+ this.getEan()+ " internalref "+this.getInternalref()+ " pid "+this.getPid();
	}
	
}
