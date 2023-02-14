package test.day0714;

public class Ex12ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// compareTo를 활용한 String 정렬

		String[] names= {"손미나","황신혜","강남길","나훈아","이영자","나훈자"};

		System.out.println("이름의 오름차순으로 정렬");
		for(int i=0;i<names.length-1;i++)
		{
			for(int j=i+1;j<names.length;j++)
			{
				if(names[i].compareTo(names[j])>0)
				{
					//거꾸로 정렬되어있을경우 두 값을 바꾼다
					String temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}
			}
		}

//		for(int i=0;i<names.length;i++)
//			System.out.println(names[i]);
		for(String s:names)
			System.out.println(s);

	}

}
