package io.zerotomastery.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PasswordPhilosophyPartOne {

	public static void main(String[] args) {
		int lowest = 0;
		int highest = 0;
		int counter = 0;
		int numberOfValidPasswords = 0;
		char letter = ' ';
		int num;

		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\io\\zerotomastery\\day2\\input.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				
				// find lowest limit
				
				num = Character.getNumericValue(line.charAt(0));
				lowest = num;
				if (String.valueOf(line.charAt(1)).equals("-")) {
					lowest = num;
				} else {
					num = Character.getNumericValue(line.charAt(1));
					lowest = (lowest * 10) + num;
				}
				
				// find highest limit
				
				for (int i = 0; i <= 5; i++) {
					if (String.valueOf(line.charAt(i)).equals("-")) {
						num = Character.getNumericValue(line.charAt(i + 1));
						highest = num;
						break;
					}
				}
				for (int i = 0; i <= 5; i++) {
					if (String.valueOf(line.charAt(i)).equals(" ") && !String.valueOf(line.charAt(i - 2)).equals("-")) {
						num = Character.getNumericValue(line.charAt(i - 1));
						highest = (highest * 10) + num;
						break;
					}
				}

				// find letter

				for (int i = 0; i <= 6; i++) {
					if (String.valueOf(line.charAt(i)).equals(" ")) {
						letter = line.charAt(i + 1);
						break;
					}
				}

				// find number of valid passwords
				
				for (int i = 0; i < line.length(); i++) {
					counter = 0;
					if (String.valueOf(line.charAt(i)).equals(":")) {
						for (int j = i; j < line.length(); j++) {
							if (Character.compare(letter, line.charAt(j)) == 0) {
								counter++;

							}
						}
						if (counter >= lowest && counter <= highest) {
							numberOfValidPasswords++;

						}
					}

				}

			}
			br.close();

			System.out.println("Number Of Valid Passwords =  " + numberOfValidPasswords);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}

	}

}
