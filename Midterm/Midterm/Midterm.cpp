/*
Question 2a) is within the class; each part is explained in the method
Question 2b) 
1. List is empty.
    a) List: NULL, start: 1, finish: 3
        cout: Broken
2. List is not empty with VALID indices from the start.
    a) LIST: [[1], [2], [4]], start: 1, finish: 2
        cout: [[1], [6]]
    b) LIST: [[1], [2], [4]], start: 1, finish: 9, finish is out of bounds
        cout: [[1], [6]]
    c) LIST: [[1], [2], [4]], start: 1, finish: 1
        cout: [[1], [2], [4]]
3. List is not empty with VALID indices, from the starting in the middle.
    a) LIST: [[1], [3], [9], [10], [11]], start: 3, finish: 4 
        cout: [[1], [3], [9], [21]]
    b) LIST: [[1], [3], [9], [10], [11]], start: 3, finish: 9
        cout: [[1], [3], [9], [21]]
    c) LIST: [[1], [3], [9], [10], [11]], start: 2, finish: 3
        cout: [[1], [3], [19], [11]
4. List is not empty, with INVALID indices: start is not within size. //Assuming unsigned does not allow negatives
    a) LIST: [[1], [3], [9], [10], [11]], start: 12, finish: 14
        cout: [[1], [3], [9], [10], [11]
    b) LIST: [[1], [3], [9], [10], [11]], start: 5, finish: 7
        cout: [[1], [3], [9], [10], [11]
5. List is not empty, with INVALID indices: start is beyond finish.
    a) LIST: [[1], [3], [9], [10], [11]], start: 3, finish: 1
        cout: [[1], [3], [9], [10], [11]]

Other possible classes: start == finish
*/

#include <iostream>
#include <vector>
using namespace std;

// PURPOSE: Models a data item in a container
class Node {
    int data; Node* next;
public:
    // CONSTRUCTORS
    Node() : data(0), next(nullptr) {}
    Node(int new_data) : data(new_data), next(nullptr) {}

    friend class LinkedList;
};

// PURPOSE: Models a singly linked list container
class LinkedList {
    Node* first; unsigned int size;
public:
    // CONSTRUCTORS
    LinkedList() : first(nullptr), size(0) {}
    // PURPOSE: Simple getters and setters	
    int get_size() {
        return size;
    }
    // PURPOSE: Inserts a data value at the end of the linked list
    bool push_back(int data) {
        if (!first) { // base case: empty list
            first = new Node(data); // set first to 						
                                    // point to the new node
                                    // set next = NULL 
                                    // in the constructor

        }
        else { // general case: non-empty list
            Node* end = first; // init end ptr
            while (end->next) // iterate until NULL
                end = end->next;
            end->next = new Node(data); // insert at the end
                                           // set next = NULL 
                                           // in the constructor
        }

        ++size; // update size
        return true; // return true
    }

    // PURPOSE: Removes the last item from a linked list
    bool pop_back() {
        if (!first) { // base case: empty list
            return false; // nothing to do

        }
        else if (!first->next) { // base case: list with one node
            delete first;
            first = nullptr;

        }
        else { // general case: a list with more than one node
            Node* end = first; // init end pointer
            while (end->next->next) // iterate until the second last node
                end = end->next;
            delete end->next; // free memory for the last node
            end->next = nullptr;	// set the second-last to point to NULL	 
        }

        --size; // update size
        return true; // return true
    }

    // PURPOSE: Prints linked list contents
    void print() {
        cout << "("; // print the header data
        Node* end = first; // initialize end pointer
        while (end) { // iterate until NULL
            cout << "[" << end->data << "]"; // print node
            end = end->next;
            if (end) // print -> symbol between nodes
                cout << "->";
        }
        cout << ")\n"; // print the footer data
    }

    //------------------------------------------------------------------------------------//
    // PURPOSE: Collapses nodes from the starting until ending positions
    // For all collapsed nodes, it adds their values into the node at start position
    bool collapse_nodes(unsigned int start, unsigned int finish) {
        //Case 1&2: LinkedList is empty OR start is not valid
        if (size == 0 || start >= size || start > finish) return false;

        //PART 1: Iterate to the start index
        unsigned int index = 0;
        Node* current = first;
        while (current && index++ < start) {
            current = current->next;
        }

        //PART 2: Get the sum of the following values
        int running_sum = 0;
        Node* start_Node = current;
        while (current && index++ <= finish + 1) {
            running_sum += current->data;
            current = current->next;
        }
        Node* continue_Node = current;

        //PART 3: Set the saved node value to the running and cut off the rest
        if (start_Node) { //Technically, it cannot be a nullptr because of the first two cases 
            start_Node->data = running_sum; 
            start_Node->next = continue_Node;
        }

        current = nullptr;
        start_Node = nullptr;

        return true;
    } 
};

void test_scenarioX(vector<int> caseX, unsigned int start, unsigned int finish) {
    LinkedList list; // create a new list

    for (int index = 2; index < caseX.size(); index++) {
        list.push_back(caseX[index]);
    }
    list.print();

    // TODO: insert test scenarios below
    list.collapse_nodes(start, finish); // collapses nodes from index = 1 until index = 3
    list.print();
}

void test_scenarios() {
    vector<vector<int> > testcases{ //{},
                                    {1, 2, 1, 2, 4},
                                    {1,9,1,2,4},
                                    {1,1,1,2,4},
                                    {3,4,1,3,9,10,11},
                                    {3,9,1,3,9,10,11},
                                    {2,3,1,3,9,10,11},
                                    {12,14,1,3,9,10,11},
                                    {5,7,1,3,9,10,11},
                                    {3,1,1,3,9,10,11}
    };

    for (int index = 0; index < testcases.size(); index++) {
        cout << "Scenario " << index << ": **collapse (" << testcases[index][0] << ", " << testcases[index][1] << ")**" << endl;
        test_scenarioX(testcases[index], (unsigned) testcases[index][0], (unsigned) testcases[index][1]);
        cout << endl;
    }
}

int main() {
    test_scenarios();
}
