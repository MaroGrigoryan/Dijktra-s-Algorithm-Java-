
public class Dij {
	
	int minDistance(int dist[], boolean sptSet[])
	{
	   int min = 99, min_index0 = 6;
	  
	   for (int v = 0; v < dist.length; v++)
	     if (sptSet[v] == false && dist[v] <= min){
	         min = dist[v]; min_index0 = v;}
	  
	   return min_index0;
	}
	int[] shortest(int[][] matrix){
		int n = matrix.length;
		int[] weighted = new int[n];
		boolean[] is_visited = new boolean[n];
		for(int v=0; v<n;v++){
			weighted[v] = matrix[0][v]; 
			is_visited[v] =false;
		}
		is_visited[0] = true;
		int min_index = 0;
		for(int i =1;i<n;i++){
			
			min_index = minDistance(weighted,is_visited);
			is_visited[min_index] = true;
			for(int x=0; x<n;x++)
					if(!is_visited[x] && weighted[x]>weighted[min_index]+matrix[min_index][x])
						weighted[x]=weighted[min_index]+matrix[min_index][x];
		}
		return weighted;
	}
		
		
		

	public static void main(String[] args) {
		int[][] newmatrix = new int[5][5];
		newmatrix[0][0] = 0;
		newmatrix[1][0] = 99;
		newmatrix[2][0] = 99;
		newmatrix[3][0] = 99;
		newmatrix[4][0] = 99;
		newmatrix[0][1] = 8;
		newmatrix[1][1] = 99;
		newmatrix[2][1] = 2;
		newmatrix[3][1] = 99;
		newmatrix[4][1] = 99;
		newmatrix[0][2] = 99;
		newmatrix[1][2] = 1;
		newmatrix[2][2] = 99;
		newmatrix[3][2] = 2;
		newmatrix[4][2] = 1;
		newmatrix[0][3] = 9;
		newmatrix[1][3] = 99;
		newmatrix[2][3] = 3;
		newmatrix[3][3] = 99;
		newmatrix[4][3] = 99;
		newmatrix[0][4] = 4;
		newmatrix[1][4] = 99;
		newmatrix[2][4] = 99;
		newmatrix[3][4] = 7;
		newmatrix[4][4] = 99;
		int[] current;
		Dij shortpath = new Dij();
		current = shortpath.shortest(newmatrix);
		for(int i =0;i<current.length;i++)
			System.out.print(current[i]+"  ");
		
		
	}

}
