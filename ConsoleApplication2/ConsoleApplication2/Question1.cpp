//TEST CASES BELOW!!!!

#include <iostream>
#include <vector>

using namespace std;

// PURPOSE: Models a data item in a container
class Node { // do not change the class into a struct
	unsigned int data; // represents the data itself
public:
	// TODO: implement required methods to make the Node class function
	Node(unsigned int new_data) : data(new_data) {}

	void print() {
		cout << "Node data: " << data << endl;
	}

	unsigned int get_data() {
		return data;
	}
};

// PURPOSE: Transfers Nodes that fit specified criteria from source to target
vector<Node> transfer_selected_nodes(const vector<Node>& source) { // do not change the signature
	vector<Node> target;
	// TODO: implement the steps specified in the question
	bool full = false;

	/*
	First Step: we want to iterate through the source vector. The easiest way is through a for loop.

	Second Step: Algorithm (Check condition is always false at the beginning)
		**data is a variable to store the Node data so that the function does not have to be called over and over**
		1) Check if 37000 < data < 57000.
		2) Get the last two digits. Modding the data by 100 removes the all digits beyond the last two.
		   If the remainder of the last two digits divided by 11 is 0, that represenative num is divisble by 11.
		3) Get the third digit. Modding by 10^n removes all the digits beyond the last n digits. (data % 1000)
								Dividing by 10^n removes the last n digits. (data / 100)
		   If the third digit is 2, that element can be pushed onto the vector.

	Third Step: Back to the size condition. The boolean variable full checks if the vector is of size 3 and breaks the loop.

	The general strategy is that with every condition passed, the data is allowed through another layer, until it passes all
	conditions and is pushed onto the vector.
	*/
	for (auto element : source) {
		full = target.size() >= 3; //Check size condition
		if (full) break;

		int data = element.get_data();
		if (data > 37000 && data < 57000) { //Check Step 1 of algorithm
			int num = 0;

			num = data % 100; //Get the last two digits

			if (num % 11 == 0) { //Check Step 2 of algorithm
				num = data % 1000 / 100; //Get the third last digit

				if (num == 2) { //Check Step 3 of algorithm 
					target.push_back(data); //Push onto vector if the data meets all requirements
				}
			}
		}
	}
	return target;
}

// PURPOSE: Runs the test scenarios that test the designed function
void test_transfer_selected_nodes() {
	// create a test vector
	vector<Node> test_values1 = { Node(48211), Node(52201), Node(56144), Node(73277), Node(49011), Node(45210) };

	// process the test vector using the designed function
	vector<Node> test_result = transfer_selected_nodes(test_values1);

	// output the resulting values
	for (auto element : test_result)
		element.print();

	// TODO: add two more test scenarios following the structure given above
}

//int main() {
//	// invoke the test scenarios
//	test_transfer_selected_nodes();
//}

/*
Case 1: 48211, 52233, 56244 
Objective: Check if the algorithms works
Output:
Node data: 48211
Node data: 52233
Node data: 56244

Case 2: 48211, 52201, 56144, 73277, 49011, 45210
Objective: Check if the algorithm works with either none, one, two or all conditions wrong
Output: 
Node data: 48211

Case 3: 48211, 52233, 56244, 73277, 49211, 45211
Objective: Check if size obstruction works; it should print out the same as Case 1
Output:
Node data: 48211
Node data: 52233
Node data: 56244
*/