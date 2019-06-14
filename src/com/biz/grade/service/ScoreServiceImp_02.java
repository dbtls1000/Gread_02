package com.biz.grade.service;

import java.util.Random;
import java.util.Scanner;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_02 implements ScoreService {

	ScoreVO[] scArray;
	Random rnd;
	Scanner scan;

	/*
	 * 생성자가 매개변수를 달리해서 중복되어 만들어지고 있다 이렇게되면 생성자에서 실행할 코드들이 같은코드가 반복되는 불편한 상황이 된다.
	 * 
	 * 매개변수가 없는 생성자에서 매개변수가 있는 생성자를 호출할 수 있는 방법이 있으면 좋겠다.
	 */
	public ScoreServiceImp_02() {
		// TODO Auto-generated constructor stub
//		scArray = new ScoreVO[10];
//		rnd = new Random();
//		scan = new Scanner(System.in);
		// 나 자신에게 10이란 값을 전달하는 생성자를 호출하라
		// 매개변수가 있는 생성자를 호출하는 코드
		this(10);
	}

	public ScoreServiceImp_02(int arrLen) {
		scArray = new ScoreVO[arrLen];
		for(int i = 0 ; i <scArray.length; i++) {
			scArray[i] = new ScoreVO();
		}
		rnd = new Random();
		scan = new Scanner(System.in);
	}

	/*
	 * 키보드에서 성적을 입력받아서 scArray추가 --END 문자열을 입력받으면 입력종료
	 */
	@Override
	public boolean inputScore(int number) throws NumberFormatException {
		// TODO Auto-generated method stub
		ScoreVO vo = new ScoreVO();

		System.out.print("국어점수 (종료 : --END) >");
		String strKor = scan.nextLine();
		if (strKor.equals("--END")) {
			System.out.println("게임을 종료합니다");
			return true;
		}
		int intKor = Integer.valueOf(strKor);
		System.out.print("영어점수 >");
		String strEng = scan.nextLine();
		int intEng = Integer.valueOf(strEng);
		System.out.print("수학점수 >");
		String strMath = scan.nextLine();
		int intMath = Integer.valueOf(strMath);

		scArray[number] = new ScoreVO();
		scArray[number].setKor(intKor);
		scArray[number].setEng(intEng);
		scArray[number].setMath(intMath);

		return false;
	}

	@Override
	public void total() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rank() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewList() {
		// TODO Auto-generated method stub
		System.out.println("빅데이터반 성적표");
		System.out.println("===============================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t석차");
		for (ScoreVO vo : scArray) {
			System.out.print(vo.getNumber() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMath() + "\t");
			System.out.print(vo.getTotal() + "\t");
			System.out.print(vo.getAvg() + "\t");
			System.out.print(vo.getRank() + "\n");

		}
	}

	@Override
	public int deptAvg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deptAvgView() {
		// TODO Auto-generated method stub

	}

}
