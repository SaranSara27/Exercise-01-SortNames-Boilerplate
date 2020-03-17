package com.stackroute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Complete the code below as given in the problem.md file
public class Exercise01StudentNameSort {
	public static String[] sortStudents(String[] studentNames, int[] percentage) {
		List<Integer> temp= new ArrayList<>();
		for(Integer i :percentage)
			temp.add(i);
		Arrays.sort(percentage);
		List<Integer> storingindex= new ArrayList<>();
		List<String> finalNameList= new ArrayList<>();
		for(Integer val : percentage) {
			for(int i=0; i<temp.size(); i++) {
				if(val ==temp.get(i)) {
					if(storingindex.contains(i)) {
						continue;
					}
					else {
						storingindex.add(i);
						finalNameList.add(studentNames[i]);
					}
					break;
				}
			}
		}
		String[] output= new String[finalNameList.size()];
		return finalNameList.toArray(output);
	}
	
	//Do not print anything other than what's expected/asked in problem
	public static void main(String[] args) {
		//Use Scanner to get input from console
		Scanner scanner= new Scanner(System.in);
		String studentDetails=scanner.nextLine();
		String[] input=studentDetails.split(";");
		String[] studentNames= new String[input.length];
		int[] percentage= new int[input.length];
		for(int i=0;i<=input.length-1;i++) {
			String[] temp=input[i].split(":");
			studentNames[i]=temp[0];
			percentage[i]=Integer.parseInt(temp[1]);
		}
		String[] output = sortStudents(studentNames,percentage);
		System.out.println(Arrays.toString(output));
		
	}
}