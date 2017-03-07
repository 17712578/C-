#include <iostream>
#include <stdio.h>      /* printf, scanf, puts, NULL */
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <algorithm>    // std::max
using namespace std;

class minesweeper2
{	 
	private:
		int nrow;
		int ncol;
		int mines;
		char **dArr;
		 
	public:
	
	minesweeper2(int r, int c, int m) //Constructor
	{
		nrow = r;
        ncol = c;
		mines = m;

        dArr = new char *[r]; // allocate memory for row pointers
        dArr[0] = new char [r*c]; // allocte memory for 1D array of all board elements
        for(int i=0; i<r; ++i) // link the row pointer to the correct elements in 1D array
            dArr[i] = dArr[0]+c*i;

        for(int i=0; i<r; ++i)
            for(int j=0; j<c; ++j)
                dArr[i][j]=0; 

	}
	
	~minesweeper2() 
    {
        // this will be the default destructor.
        // it will be automaticaly called when the Game2048 object goes out of scope in a function
        delete [] dArr[0];
        delete [] dArr;
    }
	
	void SetNumbers()
		{
			
			for(int i=0; i<nrow; i++)		// rows, 
			{
				for(int j=0; j<ncol; j++)	//columns, so it scan left to right and then down the rows
				{
					for(int ii=max(0,i-1); ii<=min(nrow-1,i+1); ii++)		//i is the row reference point from the other 'for' loop
					{																//Math.max and Math.min contain the scan within the size of the table
						for(int jj=max(0,j-1); jj<=min(ncol-1,j+1); jj++)	//j is the column reference point from the other 'for' loop, these loops really are not required for the first cycle
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
		
		void randomnumber()
		{	
		for (int i=0;i<mines;i++)		// Ten mines for now
			{
				srand (time(NULL));
				int xcor = rand() % nrow; //generating a x coordinate 
				int ycor = rand() % ncol; //generating a y coordinate 
					
				if (dArr[xcor][ycor] == 'm') // if a mine is already in that place
					{
						i--;	
					}
				else
					{
					dArr[xcor][ycor] = 'm';		//mine is not already in this spot, place mine	
					}
			}	 
		}
		
		void cursor ()
		{	
			int x =1 ;
			int y =1 ;
			BoardPrint(x, y);
		}
		
		void cursor2 (int q, int w)
			{	
				char typesel;
				cin >> typesel;
								
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
			BoardPrint(q, w);
			}
	
	
	
	void BoardPrint(int x, int y)
    {
		
        for(int i=0; i<nrow; ++i)
        {
            for(int j=0; j<ncol; ++j)
            {	  
			  if(i == x && j == y)
				{
					cout << "("; 
					cout << dArr[i][j];
					cout << ")";
					if(j<ncol)
					{
						j++;
						cout << dArr[i][j];
					}
				}
			else
				{
				cout << " ";		
				cout << dArr[i][j];
				}
            }
            cout << endl;
        }
        cout << endl;
		cursor2(x,y);
    }
};
	
	int main()
	{
		cout << "Welcome to Minesweeper \n";
		
		int rows; 
		cout << "Enter number of rows: ";
		cin >> rows;
		
		int columns;
		cout << "Enter number of columns: ";
		cin >> columns;
		
		int mines;
		cout << "Enter number of mines: ";
		cin >> mines;
		
		minesweeper2 *myGame = new minesweeper2(rows,columns,mines);
		myGame->randomnumber();
		myGame->SetNumbers();
		myGame->cursor();
		
		
    }
		
	

  