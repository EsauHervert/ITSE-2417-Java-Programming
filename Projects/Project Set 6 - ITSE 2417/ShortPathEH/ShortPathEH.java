// Esau Hervert
// ITSE 2417
// Project Set 6 - Program 1
// Options: None
// References: https://www.youtube.com/watch?v=0OQjzWthrOY - Breadth-First Search 
// http://www.inf.ed.ac.uk/teaching/courses/cs2/LectureNotes/CS2Bh/ADS/ads11.pdf - Shortest Path	

import java.io.File; // To read the file.
import java.io.IOException; // In case there is an error.
import java.util.LinkedList; // For the Queue.
import java.util.Queue; // For the Queue.
import java.util.Scanner; // To scan things.
import java.util.Vector; // For using vectors.

public class ShortPathEH {
	
	public static void main(String[] args)
	{
		
		int start = 0; // Starting vertices.
		int end = 0; // Ending vertices.
		String dir; // Holds the address.
		int node = 0; // nodes of the graph.
		int value = 0; // Index value.
		boolean flag = true; // For the direction of the graph.
		
		//Taking in the location of the file.
		System.out.print("\nEnter the file name: ");
		
		Scanner d = new Scanner(System.in);
		dir = d.nextLine();
		
		// Getting the vertices from the user.
		System.out.print("\nEnter the first vertices: ");
		start = d.nextInt();
		
		System.out.print("\nEnter the second vertices: ");
		end = d.nextInt();
		
		//Close the input scanner.
		d.close();

		//This change will allow java to actually find the correct location since having "\" causes issues.
		dir.replace("\\", "/");
		
		//This will make sure that the file is found. If not, it will lead to a IOException.
		try{
			Scanner input = new Scanner(new File(dir));
			
			node = Character.getNumericValue(input.nextLine().charAt(0)); // Number of Games.
			
			System.out.print("\nThe number of vertices is " + node);
			System.out.println("\n");
			
			int[] Row = new int[6]; // Rows of the Matrix.
			
			int[][] Matrix = new int[6][6]; // Adjacent Matrix.
			
			String[] ST = new String[6]; // Individual lines of the file.
			for (int i = 0; i < 6; i++)
			{
				ST[i] = input.nextLine(); // Read the lines one by one.
				
				// Initialize the row to 0.
				for (int l = 0; l < 6; l++)
				{
					Row[l] = 0;
				}
				
				// Take the values and assign the correct value in the matrix.
				for (int j = 1; j < ST[i].length(); j++)
				{
					if (ST[i].charAt(j) != ' ')
					{
						value = Character.getNumericValue(ST[i].charAt(j));
						Row[value] = 1;
					}
				}
				
				// Set the row values in the matrix.
				for (int k = 0; k < 6; k++)
				{
					Matrix[i][k] = Row[k];
				}
			}
			
			// Display the vertex.
			for (int i = 0; i < 6; i++)
			{
				System.out.print("Vertex " + i + ": ");

				for (int j = 0; j < 6; j++)
				{
					if (Matrix[i][j] == 1)
						System.out.print("(" + i + ", " + j + ") "); 
				}
				
				System.out.println();

			}
			
			//**********************************************************************************************************
			// Breath-First Search with the shortest path finder.
			int[] visited = {0,0,0,0,0,0};
			int[] distance = {-1, -1, -1, -1, -1, -1};
			
			Queue<Integer> Q = new LinkedList<Integer>(); // Queue where the paths will be tested.
			
			// Since my program does not like working with the list backwards, I will make all paths go forward and adjust the results with the flag.
			if (start > end)
			{
				// Swapping values.
				int c = end;
				end = start;
				start = c;
				flag = false;
			}
			
			// Here is the algorithm.
			Q.add(start);	
			visited[start] = 1;
			distance[start] = 0;
			int[] path = {-1,-1,-1,-1,-1,-1};

			while (Q.size() != 0) // While there is still a path to be take.
			{
				node = Q.remove();
				
				for (int i = 0; i < visited.length; i++)
				{
					if(Matrix[node][i] == 1 && visited[i] == 0)
					{
						distance[i] = distance[node] + 1;
						path[i] = node;
						visited[i] = 1;
						Q.add(i);
					}
				}
				
				if (node == end) // If we reach our endpoint, we end the program regarless of whether the queue is still not empty.
				{
					path[end] = node;
					break;
				}
				
			}
			
			System.out.println();

			Vector<Integer> Path = new Vector<>(); // Path vector so that we can adjust the path if it is backwards.
			
			int l = 0;
			for (int i = 0; i < path.length; i++)
			{
			    if (Matrix[start][end] == 1) // For the case if the two values are right next to each other.
			    {
			    	Path.addElement(start);
			    	Path.addElement(end);
			    	i = path.length;
			    }
				else if (i == end) // End point of our path.
				{
					Path.addElement(i);
					i = path.length;
				}
				else if(distance[i] == l)
				{
					Path.addElement(i);
					l++;
				}
			}
			
			System.out.print("The path is ");
			
				for (int  i = 0; i < Path.size(); i++)
				{
					if (flag) // Fowards.
						System.out.print(Path.elementAt(i) + " ");
					else // Backwards.
						System.out.print(Path.elementAt(Path.size() - 1 - i) + " ");
				}
			System.out.println();

			input.close(); // Close the scanner.
		}
		catch (IOException e)
		{
			System.out.println("File is not Found."); // In case of error.
		}
	}
	
	
}