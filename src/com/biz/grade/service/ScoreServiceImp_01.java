package com.biz.grade.service;

import java.util.Random;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_01 implements ScoreService {

	ScoreVO[] scArray;
	Random rnd ;

	public ScoreServiceImp_01() {
		// TODO Auto-generated constructor stub
		scArray = new ScoreVO[10];
		rnd = new Random();
	}

	public ScoreServiceImp_01(int arrLen) {
		scArray = new ScoreVO[arrLen];
		rnd = new Random();
	}

	@Override
	public boolean inputScore(int number) throws NumberFormatException {
		// 난수를 만들어서 3개의 성적을 생성
		// 1번 방법 vo를 생성하고 값을 set후 배열의 number번째에 대입
		ScoreVO vo = new ScoreVO();
		
		int intKor = rnd.nextInt(50)+51;
		int intEng= rnd.nextInt(50)+51;
		int intMath= rnd.nextInt(50)+51;
		vo.setNumber(number+1);
		vo.setKor(intKor);
		vo.setEng(intEng);
		vo.setMath(intMath);
		
		scArray[number] = vo;
		
		// 2번방법 number번째 배열을 초기화하고 각 요소를 set
		scArray[number] = new ScoreVO();
		scArray[number].setNumber(number+1);
		scArray[number].setKor(intKor);
		scArray[number].setEng(intEng);
		scArray[number].setMath(intMath);
				
		return false;
	}

	public void total() {
		// TODO Auto-generated method stub
		for(ScoreVO vo : scArray) {
			int total = vo.getKor();
			total += vo.getEng();
			total += vo.getMath();
			
			vo.setTotal(total);
			vo.setAvg(total/3);
		}
	}

	public void rank() {
		// TODO Auto-generated method stub
		// 총점을 기준으로 내림차순 정렬 
		// rank 값을 대입해준다.
		for(int i = 0 ; i < scArray.length; i++) {
			for (int j = i + 1  ; j < scArray.length ; j++) {
				if(scArray[i].getTotal() < scArray[j].getTotal() ) {
					ScoreVO _score = scArray[i];
					scArray[i] = scArray[j];
					scArray[j] = _score;
					
				}
			}
		}
		for(int i = 0 ; i < scArray.length ; i++) {
			scArray[i].setRank(i+1);
		}
		
	}

	public void viewList() {
		// TODO Auto-generated method stub
		System.out.println("빅데이터반 성적표");
		System.out.println("===============================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t석차");
		for(ScoreVO vo : scArray) {
			System.out.print(vo.getNumber()+"\t");
			System.out.print(vo.getKor()+"\t");
			System.out.print(vo.getEng()+"\t");
			System.out.print(vo.getMath()+"\t");
			System.out.print(vo.getTotal()+"\t");
			System.out.print(vo.getAvg()+"\t");
			System.out.print(vo.getRank()+"\n");
			
			
			
		}
	}

	public int deptAvg() {
		// TODO Auto-generated method stub
		int dept = 0;
		int deptAvg = 0;
		int num = scArray.length;
		for(ScoreVO vo : scArray) {
			dept += vo.getAvg();
			
		}
		deptAvg = dept / num;
		return deptAvg;
		
	}

	public void deptAvgView() {
		// TODO Auto-generated method stub

	}

}
