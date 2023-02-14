package bit.data.dto;

import java.sql.Timestamp;

import lombok.Data;


/*
@Setter
@Getter
@ToString
@Data	-	setter 와 getter 와 tostring 3개 모두 적용
@NoArgsConstructor	- 기본 생성자
@AllArgsConstructor	 - 모든 파라미터 받는 생성자
*/

@Data
public class BoardDto {

	private int num;
	private int readcount;
	private int likes;
	private int regroup;
	private int restep;
	private int relevel;
	private String id;
	private String name;
	private String subject;
	private String content;
	private String photo;
	private Timestamp writeday;
	
	private int acount;	//댓글 갯수 boardlist 표기 용도
	
//	public int getNum() {
//		return num;
//	}
//	public void setNum(int num) {
//		this.num = num;
//	}
//	public int getReadcount() {
//		return readcount;
//	}
//	public void setReadcount(int readcount) {
//		this.readcount = readcount;
//	}
//	public int getLikes() {
//		return likes;
//	}
//	public void setLikes(int likes) {
//		this.likes = likes;
//	}
//	public int getRegroup() {
//		return regroup;
//	}
//	public void setRegroup(int regroup) {
//		this.regroup = regroup;
//	}
//	public int getRestep() {
//		return restep;
//	}
//	public void setRestep(int restep) {
//		this.restep = restep;
//	}
//	public int getRelevel() {
//		return relevel;
//	}
//	public void setRelevel(int relevel) {
//		this.relevel = relevel;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getSubject() {
//		return subject;
//	}
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getPhoto() {
//		return photo;
//	}
//	public void setPhoto(String photo) {
//		this.photo = photo;
//	}
//	public Timestamp getWriteday() {
//		return writeday;
//	}
//	public void setWriteday(Timestamp writeday) {
//		this.writeday = writeday;
//	}
	
}
