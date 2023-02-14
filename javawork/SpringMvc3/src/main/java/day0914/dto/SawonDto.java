package day0914.dto;

public class SawonDto {
	private String name;
	private String buseo;
	private int age;
	private String ipsaday;
	
	//통으로 읽어올거라서 생성자는 필요없음 -> getter and setters 만 진행
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBuseo() {
		return buseo;
	}
	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIpsaday() {
		return ipsaday;
	}
	public void setIpsaday(String ipsaday) {
		this.ipsaday = ipsaday;
	}
	
}
