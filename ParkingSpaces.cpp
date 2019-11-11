#include <iostream>
#include <cstdlib>
#include <fstream>

using namespace std;

const int PARKING_SPACES = 50, LIST_NUM = 3;
	
void fill1(ifstream & fin,
		  int iarray[PARKING_SPACES],
		  string sarray[PARKING_SPACES])
{
	int spot = 0, status = 0;
	string name = "";
	
	while(fin >> status >> name >> spot)
	{
		iarray[spot - 1] = status;
		sarray[spot - 1] = name;
	}
	
	for(int count = 0; count < PARKING_SPACES; count++)
	{
		if(sarray[count] == "")
			iarray[count] = -1; 
	}
}

void fill2(ifstream & fin,
		  int iarray[PARKING_SPACES],
		  string sarray[PARKING_SPACES])
{
	int count = 0;
	
	while(fin >> iarray[count] >> sarray[count])
		count++;
}

void remove(int iarray[LIST_NUM][PARKING_SPACES],
		    string sarray[LIST_NUM][PARKING_SPACES])
{
	bool replaced = false;
	int c2 = 0;
	
	for(int c1 = 0; c1 < PARKING_SPACES; c1++)
	{
		replaced = false;
		c2 = 0;
		
		while(!replaced and c2 < PARKING_SPACES)
		{
			if(iarray[1][c2] == iarray[0][c1] and sarray[1][c2] == sarray[0][c1])
			{
				iarray[0][c1] = -1;
				sarray[0][c1] = "";
				replaced = true;
			}
			
			c2++;
		}
	} 
}

int parking_empty(int iarray[PARKING_SPACES])
{
	for(int count = 0; count < PARKING_SPACES; count++)
		if(iarray[count] == -1)
			return count;
	return -1;
}

void add(int iarray[LIST_NUM][PARKING_SPACES],
		 string sarray[LIST_NUM][PARKING_SPACES])
{
	bool replaced = false;
	int empty = -1, count = 0;
	
	do
	{
		empty = parking_empty(iarray[0]);
		
		if(empty != -1)
		{	
			if(empty < 25)
			{
				replaced = false;
				
				count = 0;
				while(!replaced and count < PARKING_SPACES)
				{
					if(iarray[2][count] == 1)
					{
						iarray[0][empty] = iarray[2][count];
						sarray[0][empty] = sarray[2][count];
						
						iarray[2][count] = -1;
						sarray[2][count] = "";
						replaced = true;
					}
					count++;
				}
				
				count = 0;
				while(!replaced and count < PARKING_SPACES)
				{
					if(iarray[2][count] == 0)
					{
						iarray[0][empty] = iarray[2][count];
						sarray[0][empty] = sarray[2][count];
						
						iarray[2][count] = -1;
						sarray[2][count] = "";
						replaced = true;
					}
					count++;
				}
			}
			else
			{
				replaced = false;
				
				count = 0;
				while(!replaced and count < PARKING_SPACES)
				{
					if(iarray[2][count] != -1)
					{
						iarray[0][empty] = iarray[2][count];
						sarray[0][empty] = sarray[2][count];
						
						iarray[2][count] = -1;
						sarray[2][count] = "";
						replaced = true;
					}
					count++;
				}
			}
		}
	}while(empty != -1);
}

void writeTo(ofstream & fout, 
			 int iarray[LIST_NUM][PARKING_SPACES],
		 	 string sarray[LIST_NUM][PARKING_SPACES])
{
	for(int count = 0; count < PARKING_SPACES; count++)
		fout << iarray[count] << sarray[count] << endl;
}

int main()
{
	ifstream fin1("parking_current.txt");
	ifstream fin2("parking_remove.txt");
	ifstream fin3("parking_add.txt");
	ofstream fout("parking_lot");
	
	if(!fin1 and !fin2 and !fin3)
	{
		cout << "There are missing input files...";
		system("PAUSE");
		return EXIT_SUCCESS;
	}
	
	int parking_status[LIST_NUM][PARKING_SPACES] = {0};
	string parking_name[LIST_NUM][PARKING_SPACES];

	fill1(fin1, parking_status[0], parking_name[0]);
	fill2(fin2, parking_status[1], parking_name[1]);
	fill2(fin3, parking_status[2], parking_name[2]);
	
	remove(parking_status, parking_name);
	add(parking_status, parking_name);
	
	for(int count = 0; count < PARKING_SPACES; count++)
		cout << parking_status[0][count] << " " << parking_name[0][count] << endl;
		
	fin1.close();
	fin2.close();
	fin3.close();
	fout.close();
	
	system("PAUSE");
	return EXIT_SUCCESS;
}

/*
1 Manezes_Alfred
1 Tuncel_Levent
1 Pritzker_Mark
1 Gryguc_Andrew
1 Fluid_Newtonian
1 McKinnon_David
1 Jeremy_Pavan
1 Yodelay_he_who
0 Hmeidan_Amer
0 Paik_Chad
1 Davison_Dan
1 Bedi_Sanjeev
0 Tan_Mark
0 Roller_Anika
0 Starratt_Kathryn
0 Belisle_Matt
0 Wang_Willian
0 Samlalsingh_Ryan
0 Malloch_Jeremy
0 Yuan_Jacky
1 McKillop_Bob
0 Ratiu_Timea
0 Sheng_Stephen
0 Kim_Leo
1 Davidson_George
0 Lung_Ian
-1
0 Huot_Isabella
0 Lau_Amanda
1 Xie_Wei-Chau
0 Mills_Joel
-1
-1
-1
0 Jasmine_Princess
-1
-1
0 Barakat_Abdullah
-1
0 Hamza_Muhammad
0 Zheng_Tim
-1
-1
-1
-1
1 Hulls_Carol
0 Yousufzay_Namoos
-1
0 Lau_Darren
-1
*/
