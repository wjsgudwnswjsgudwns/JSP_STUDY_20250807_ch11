package dto;

public class BoardDto {
	
	private String btitle;
	private String bwriter;
	private String bdate;
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(String btitle, String bwriter, String bdate) {
		super();
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bdate = bdate;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
	
}