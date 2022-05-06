package com.techelevator;

public class DecimalToBinary {

	public static void main(String[] args) {

		for(int ix = 0; ix < args.length; ix++) {
			String binary = " ";
			int decimal = Integer.parseInt(args[ix]);
			for(;decimal>0; decimal /= 2) {
				binary += (decimal % 2);
			}
			System.out.print(args[ix] + "in binary is" + binary);
		}


	}

}
