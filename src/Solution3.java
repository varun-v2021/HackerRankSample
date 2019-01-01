import java.util.*;

class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		if(t >= 0 && t <= 500){
			for (int n = 0; n < t; n++) {
			    long N = sc.nextInt();
				long M = sc.nextInt();
				long i = sc.nextInt();
				long j = sc.nextInt();
				if ((j >= 1 && j <= 9999999) && (i >= 1 && i <= 9999999)
				&& (M >= 2 && M <= 10000000)
		    		&& (N >= 2 && N <= 10000000)) {
					getMaxDragons(N, M, i, j);
				}else{
				    System.out.println(0);
				}
			}
	}
	}

	public static void getMaxDragons(long N, long M, long i, long j) {

		long noOfDragons = 0;

		if (i  > N || j > M) {
            noOfDragons = 0;
		}else if((i + j) > (N + M)){
		    noOfDragons = 0;
		}else {
			N = i;
			M = j;
			noOfDragons = (N+1) * (M+1);
		}
		System.out.println(noOfDragons);
	}
}
