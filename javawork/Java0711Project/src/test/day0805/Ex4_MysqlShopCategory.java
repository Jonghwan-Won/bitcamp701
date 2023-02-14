package test.day0805;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbConnect;

public class Ex4_MysqlShopCategory {

	DbConnect db=new DbConnect();
	
	public void categoryAllView()
	{
		String sql="select upper(category) category,count(*) count,format(avg(price),0) avg,format(max(price),0) max,format(min(price),0) min from shop group by category order by 1";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			System.out.println("\t** Shop 의 상품 분석 **");
			System.out.println();
			System.out.println("카테고리\t상품갯수\t평균단가\t최고가격\t최저가격");
			System.out.println("------------------------------------------------");
			
			int total=0;	//총 상품 갯수
			
			while(rs.next()) {
					String category=rs.getString("category");
//					String count=rs.getString("count");	//단순 출력 용도면 String해도 무방
					int count=rs.getInt("count");	// count를 활용해 total을 구하려면 int로
					total+=count;
					String avg=rs.getString("avg");
					String max=rs.getString("max");
					String min=rs.getString("min");

//					System.out.println(category+"\t"+count+"\t"+avg+"\t"+max+"\t"+min);
					System.out.printf("%10s%5d%10s%10s%10s\n",category,count,avg,max,min);

			}
			System.out.println();
			System.out.println("총 상품 갯수 : "+total+"개");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex4_MysqlShopCategory ex=new Ex4_MysqlShopCategory();
		ex.categoryAllView();
	}

}
