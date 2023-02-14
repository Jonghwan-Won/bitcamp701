package file.util;

import java.util.Calendar;

public class ChangeName {

	//생성안해도되게 static으로
	//fileName을 받으면 변경된 fileName(String) 으로 반환
	public static String getChangeFileName(String fileName)
	{
		// .의 위치 구하기
		int dotLoc=fileName.indexOf('.');
//		System.out.println(dotLoc);	// 맨앞 0부터 시작했을때 .의 위치구하기
		
		String fname=fileName.substring(0,dotLoc);	
		String ext=fileName.substring(dotLoc);
//		System.out.println(fname);	//파일명 분리
//		System.out.println(ext);	//확장자 분리
		
		//오리지널 파일 네임이 아닌 (같은 파일명은 덮어써지므로)
		//날짜를 구해서 년월일시분초+천분의1.jpg 이런 타입의 파일명 변경하기
		Calendar cal=Calendar.getInstance();
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH);
		int d=cal.get(Calendar.DATE);
		int hh=cal.get(Calendar.HOUR);
		int mm=cal.get(Calendar.MINUTE);
		int ss=cal.get(Calendar.SECOND);
		int ms=cal.get(Calendar.MILLISECOND);
		
//		System.out.println(m+","+d+","+hh+","+mm+","+ss+","+ms);	//중간 확인
		
		//숫자계산을 막기위해 맨 앞은 ""로 문자열 처리
		fileName=""+y+(m<10?"0"+m:m)+(d<10?"0"+d:d)+(hh<10?"0"+hh:hh)+(mm<10?"0"+mm:mm)+(ss<10?"0"+ss:ss)+ms+ext;
		
		return fileName;
	}
}
