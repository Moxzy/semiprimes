package semiprimes;

import java.util.Arrays;

public class Semiprimes {
	public static int[] removeDuplicates(int[] A){
		if(A.length <2) {
			return A;
		}
		int j = 1;
		int i = 2;
		
		while (i < A.length) {
			if(A[i] == A[j]) {
				i++;
			}else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		int [] B = Arrays.copyOf(A,  j + 1);
		
		return B;
	}
	public static void main(String[] args) {
		int i = 0;
		int num = 0;
		int primes[] = new int[25];
		int p = 0;
		for(i = 1; i<100; i++) {
			int counter = 0;
			for(num = i; num>=1; num--) {
				if(i%num == 0) {
					counter = counter + 1;
				}
			}
			if(counter == 2) {
				primes[p] = i;
				p++;
			}
		}
		for(int x = 0; x<25;x++) {
			if(primes[x] > 0) {
				System.out.print(primes[x] + " ");
			}
		}
		System.out.println(" ");
		
		int semiprimes[] = new int[625];
		int count = 0;
		for(int y = 0; y<primes.length; y++) {
			for(int z = 0; z<primes.length; z++) {
				semiprimes[count] = primes[y]*primes[z];
				count++;
			}
		}
		//System.out.println(count);
		//for(int g=0; g<semiprimes.length;g++) {
			//System.out.println(semiprimes[g]);
		//}
		
		Arrays.sort(semiprimes);
		//System.out.println(semiprimes.length);
		semiprimes = removeDuplicates(semiprimes);
		//System.out.print(semiprimes.length);
		//for(int s1 = 0; s1<semiprimes.length; s1++) {
			//System.out.println(semiprimes[s1]);
		//}
		for(int q = 0; q<semiprimes.length-1; q++) {
			if((semiprimes[q+1] - semiprimes[q] == 1) && (semiprimes[q+2] - semiprimes[q+1] == 1)){
				System.out.println(semiprimes[q] + ", " + semiprimes[q+1] + ", " + semiprimes[q+2]);
			}
		}
	}
}
