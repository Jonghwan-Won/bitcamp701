package test.day0713;

public class Ex1While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1~5까지 출력-while문을 이용해서
				int n=0;
				System.out.println("** 출력 1 **");
				while(n<5)
				{
					System.out.println(++n);
				}
				System.out.println("** 출력 2 **");
				n=0;
				while(true)
				{
					System.out.println(++n);
					if(n==5)
						break;
				}
				
				n=0;
				System.out.println("** 출력 3 - 1~10 사이의 숫자중 짝수만 출력 **");
				while(n<10)
				{
					++n;
					if(n%2==1)
						continue;//더이상 수행하지 않고 조건식으로 이동
					System.out.printf("%3d",n);
				}
				
				n=0;
				System.out.println("\n** 출력 4 - 1~10 사이의 숫자중 짝수만 출력 **");
				while(true)
				{
					if(++n%2==0)
						System.out.printf("%3d",n);
					if(n==10)
						break;
				}
			}

		}
