#include <iostream>
#include <vector>

using namespace std;

void sneaky_swapping1(int a, int& b) {
	b = a;
}

void sneaky_swapping2(int** e, int** f) {
	int* temp = *e;
	*e = *f;
	*f = temp;
}

void sneaky_swapping3(int** c, int* d) {
	c = &d;
}

void update_vector_values(vector<int>* data) {
	int i = 3;
	*(data->begin() + i++) = 1232; // data->begin() is a pointer to the first element in the vector
	*(data->begin() + ++i) = 3212; // (data->begin() + index) points to the element at index location
}

int main() {
	int i1 = 1212, i2 = 4224, i3 = 5665;
	int* ip1 = &i2, * ip2 = new int(2525), * ip3 = new int(4747);
	vector<int>* ip4 = new vector<int>(20, 1919);

	sneaky_swapping1(i1, i2);
	cout << i1 << " " << i2 << endl; 		// [Question1]

	sneaky_swapping2(&ip1, &ip2);
	cout << *ip1 << " " << *ip2 << endl; 	// [Question2]

	sneaky_swapping3(&ip3, ip2);
	cout << *ip2 << " " << *ip3 << endl;	// [Question3]

	update_vector_values(ip4);			// [Question4]
	cout << ip4->at(4) << endl;

	for (auto element : *ip4)
		cout << element << " ";

	//delete ip1;							// [Question5]
	//delete ip2;
	//delete ip3;
	//delete ip4;

	//ip2 = NULL;
/*	cout << ip2 << endl;
	cout << *ip2 << endl;	*/				// [Question6]
}