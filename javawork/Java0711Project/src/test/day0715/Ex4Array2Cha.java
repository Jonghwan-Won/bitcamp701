package test.day0715;

public class Ex4Array2Cha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [][]str= {
				{"빨강","노랑"},
				{"장미꽃","안개꽃","다알리아"},
				{"강호동","이영자","유재석","하하"}
		};
		
		System.out.println("행갯수:"+str.length);
		System.out.println("0번행 열갯수:"+str[0].length);
		System.out.println("1번행 열갯수:"+str[1].length);
		System.out.println("2번행 열갯수:"+str[2].length);
		
		for(int i=0;i<str.length;i++)
		{
			for(int j=0;j<str[i].length;j++)
			{
				System.out.println(str[i][j]+"\t");
			}
			System.out.println();
			
		}
				
	}	
}
