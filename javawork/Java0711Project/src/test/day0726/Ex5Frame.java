
// 해당 예제는 swing 때문이아닌 익명 내부 클래스가 이런식으로 자주쓰인다는걸 보여주기 위한 예제임

package test.day0726;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex5Frame extends JFrame{
	//버튼 배열
	JButton []btn=new JButton[6];	//단순 할당임, 생성이 아닌 메모리 할당 : 초기값 null
	//버튼에 들어갈 라벨
	String []title= {"빨강","파랑","연핑크","진핑크","초록","오렌지"};
	//실제 적용될 색상
	Color []colors= {Color.red, Color.blue, Color.pink, Color.magenta, Color.green, Color.orange};
	
	// title, colors 모두 멤버변수(..?)
	
	public Ex5Frame() {
		super("색변경");
		this.setBounds(400,100,400,400);
		this.initDesign();
		
		//윈도우 종료 이벤트를 갖고있는 메서드 : 단순 종료 (로직을 추가하고싶으면 Ex4 종료 이벤트처럼
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	private void initDesign() {
		// TODO Auto-generated method stub

		//기본 레이아웃 제거
		this.setLayout(null);
		//반복문을 이용하여 버튼 생성해서 붙이기
		int y=20;
		for(int i=0;i<btn.length;i++)
		{
			btn[i]=new JButton(title[i]);
			
			//버튼의 글자색이 해당색으로 나타나도록 해보자
			btn[i].setForeground(colors[i]);
			
			//위치 및 사이즈 설정
			btn[i].setBounds(20,y,80,40);
			y+=45;
			
			//프레임에 추가
			this.add(btn[i]);
			final int idx=i;
			
			//버튼 이벤트 (for문 안에서 줘야함)
			btn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//해당 버튼 색상으로 윈도우 색상 변경(배경색)
					Ex5Frame.this.getContentPane().setBackground(colors[idx]);
					// color[i] -> i 변수는 사용할 수 없어서 final 상수로 int idx 추가함
				}
			});
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5Frame ex=new Ex5Frame();
		
	}

}
