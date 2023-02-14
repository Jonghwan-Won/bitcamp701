package test.day0714;

public class Ex10Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] kor= {89,100,78,90,77};
		int[] eng= {100,90,76,89,67};
		int[] tot=new int[5];
		int[] rank=new int[5];
		
		// 총점 구하기
		for(int i=0;i<kor.length;i++)
		{
			tot[i]=kor[i]+eng[i];
		}

		// 등수 구하기
		for(int i=0;i<tot.length;i++)
		{
			rank[i]=1; // i번째 사람의 첫 등수는 1등
			
			for(int j=0;j<tot.length;j++)
			{
				if(tot[i]<tot[j]) //i번째 사람의 점수 < j번째 사람의 점수 이면 i 점수의 rank를 증가 (같으면 패스)
					rank[i]++;
								
			}
		}
		
		
		// 출력
		System.out.println("번호\t국어\t영어\t총점\t등수");
		System.out.println("--------------------------------------");
		for(int i=0;i<kor.length;i++)
		{
			System.out.println(i+1+"\t"+kor[i]+"\t"+eng[i]+"\t"+tot[i]+"\t"+rank[i]+"\t");
		}
		
		
		

	}

}
