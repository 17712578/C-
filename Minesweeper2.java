import java.util.*;
import java.io.*;

	public class minesweeper2
	{
		private int nrow;
		private int ncol;
		private int mines;
		private char[][] dArr;

		
		public minesweeper2 (int r , int c, int m) //Constructor
		{
			nrow = r;
			ncol = c;
			mines = m;
			dArr = new char[r][c];
		}
		
		private void customsweeper2 (int r , int c, int m) //Constructor
		{
			nrow = r;
			ncol = c;
			mines = m;
			dArr = new char[r][c];
		}
		public void boardsize ()
		{
			System.out.println("Enter number of rows");
			Scanner sr = new Scanner(System.in);
			int r = sr.nextInt();
			System.out.println("Enter number of columns");
			Scanner sc = new Scanner(System.in);
			int c = sc.nextInt();
			System.out.println("Enter number of mines");
			Scanner sm = new Scanner(System.in);
			int m = sm.nextInt();
			customsweeper2(r,c,m);
			play();
		}
		
		public void menu () 
		{
			System.out.println("1. New Game");
			System.out.println("2. Highsores");
			System.out.println("3. Quit");
			Scanner sc = new Scanner(System.in);
			int optionsel = sc.nextInt();
			
			switch (optionsel){
			case 1: 
				System.out.println("Chose your options");
				boardsize();
				break;
			case 2:
				System.out.println("Shaun : 1000 points");
				break;
			case 3:
				System.out.println("Game ended");
				break;
			}
			
		}
		

		public void play()
		{
			
			for (int i=0;i<mines;i++)		// Ten mines for now
				{
					int xcor = (int )(Math.random() * nrow + 0.5); //generating a x coordinate 
					int ycor = (int )(Math.random() * ncol + 0.5); //generating a y coordinate 
						
						if (dArr[xcor][ycor] == 'm') // if a mine is already in that place
							{
								i--;	
							}
						else
							{
							dArr[xcor][ycor] = 'm';		//mine is not already in this spot, place mine	
							}
				}	 
				 SetNumbers();
				 cursor();
		}
			
			
		public void printboard(int x, int y)
		{
			System.out.println();	
			for (int a=0;a<nrow;a++)		// Printing the board now everything is in place
				{
					for (int s=0;s<ncol;s++)
					{
						if (a == x && s == y)
						{
							System.out.print("(");
							System.out.print(dArr[a][s]);
							System.out.print(")");
							if(s<ncol)
							{
								s++;
								System.out.print(dArr[a][s]);
							}
						}
						else
						{
						System.out.print(" ");		
						System.out.print(dArr[a][s]);
						}
					}
					System.out.println();		// space the board out
				}
				cursor2(x,y);	
		}
		
		public void cursor ()
		{	
			int x =1 ;
			int y =1 ;
			printboard(x, y);
		}
			public void cursor2 (int q, int w)
			{	
				Scanner s= new Scanner(System.in);
				char typesel = s.next().charAt(0);
				
				if(typesel == 's')
				{
					q = q + 1;
				}
				else if (typesel == 'w')
				{
					q = q - 1;
				}
				else if (typesel == 'd')
				{
					w = w + 1;
				}					
				else if (typesel == 'a')
				{
					w = w - 1;
				}
			printboard(q, w);
			}
		
		private void SetNumbers()
		{
			//set numbers
			for(int i=0; i<nrow; i++)		// rows, 
			{
				for(int j=0; j<ncol; j++)	//columns, so it scan left to right and then down the rows
				{
					for(int ii=Math.max(0,i-1); ii<=Math.min(nrow-1,i+1); ii++)		//i is the row reference point from the other 'for' loop
					{																//Math.max and Math.min contain the scan within the size of the table
						for(int jj=Math.max(0,j-1); jj<=Math.min(ncol-1,j+1); jj++)	//j is the column reference point from the other 'for' loop, these loops really are not required for the first cycle
						{
							if ((dArr[i][j] == 'm') && (dArr[ii][jj] != 'm'))
							{	
								if(dArr[ii][jj] == 0)
									dArr[ii][jj] = '1';
								else
								 dArr[ii][jj]++;
							}	 
						}
					}
				
				}
			}

		}
	}

  