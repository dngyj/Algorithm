import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.math.BigInteger;

import java.util.Arrays;

import java.util.Collections;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException { 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n= Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int sum=0;

		int ctnu=0;

		int reply=st.countTokens();

		for (int i=0; i<reply; i++) { //★st.countTokens()를 for문의 값으로 넣어주면, 이 데이터는 변하는 데이터라 for문이 제대로 작동 안함

			if (st.nextToken().equals("0")) {

				ctnu=0;

			}

			else {

				ctnu+=1;

				sum+=ctnu;

			}

			//System.out.println(ctnu);

		}

		System.out.println(sum);

		

    }

		

}