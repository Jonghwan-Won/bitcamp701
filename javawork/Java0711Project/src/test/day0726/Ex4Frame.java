package test.day0726;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex4Frame extends JFrame{

	public Ex4Frame() {
		
		super("Hello");	//타이틀, 제목
		
		this.setLocation(500, 100);	//시작좌표
		this.setSize(300,300);	//프레임의 너비, 높이
		//메서드 호출
		this.initDesign();
		this.setVisible(true);	//false는 안보이게됨	예시)닫기버튼 눌렀을때 false로 바뀌며 안보이게 됨.. 실제로 닫히지않음
		
		
		//종료 이벤트
		this.addWindowListener(new WindowAdapter() {	
			//원래는 정식 클래스를 만들어서 implements 등등 작업이 필요하지만
			//이벤트를 직접 구현 : 이런 형태가 익명 내부 클래스
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex4Frame.this, "종료합니다");	//부모클래스(Ex4Frame)의 this를 가져옴
				System.exit(0);
				super.windowClosing(e);	//이건 자동으로 생성된거
			}
		});
	}
	
	private void initDesign() {		//this.initDesign(); 를 위에 입력하고 오류선택 > create Method 하면 자동 생김
		// TODO Auto-generated method stub
		//기본 레이아웃 설정 없애기
		this.setLayout(null);
		JButton btn1=new JButton("빨강색");
		btn1.setBounds(20, 20, 80, 30);	// x좌표 y좌표 width height
		//프레임에 추가
		this.add(btn1);
		//버튼 이벤트 - 익명 내부 클래스 형태로 이벤트 설정
		btn1.addActionListener(new ActionListener() {	
			//Listener로 끝나는 애들은 interface임
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ex4Frame.this.getContentPane().setBackground(Color.red);
				//그냥 this하면 내부에 해당되고, JFame의 배경을 바꾸기때문에 부모 클래스.this를 해야됨
				//Color.xxx -> final static 형태임, RGB값이 다 들어가있음
			}
		});	
		
		JButton btn2=new JButton("노랑색");
		btn2.setBounds(110, 20, 80, 30);	// x좌표 y좌표 width height
		//프레임에 추가
		this.add(btn2);
		//버튼 이벤트 - 익명 내부 클래스 형태로 이벤트 설정
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ex4Frame.this.getContentPane().setBackground(Color.yellow);
				//그냥 this하면 내부에 해당되고, JFame의 배경을 바꾸기때문에 부모 클래스.this를 해야됨
				//Color.xxx -> final static 형태임, RGB값이 다 들어가있음
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4Frame ex=new Ex4Frame();	//생성

	}

}
