package com.biz.grade.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileWriter_02 {
	public static void main(String[] args) {
		String scoreFile = "src/com/biz/grade/data/Score_02.txt";

		FileWriter fileWriter;
		PrintWriter printWriter;
		Random rnd = new Random();

		try {
			fileWriter = new FileWriter(scoreFile);
			printWriter = new PrintWriter(fileWriter);
			for(int i = 0 ; i < 100 ; i++) {
				int intNum = i+1;
				int intKor = rnd.nextInt(50)+51;
				int intEng= rnd.nextInt(50)+51;
				int intMath= rnd.nextInt(50)+51;
				
				// 학번:국어:영어:수학 형식으로 나타냄
				printWriter.printf("%d:%d:%d:%d\n",intNum,intKor,intEng,intMath);
				
			}
			printWriter.flush();
			printWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("알수없는 이유로 파일 생성 불가");
		}

	}
}
