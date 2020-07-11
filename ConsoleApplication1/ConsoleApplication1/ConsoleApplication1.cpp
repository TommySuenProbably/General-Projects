#include <iostream>
#include <vector>
#include <string>

void print_array(const std::vector<int>& v) {
    std::cout << "[";
    for (int i = 0; i < v.size(); i++) {
        std::cout << v[i];
        if (i != v.size() - 1)
            std::cout << ", ";
    }
    std::cout << "]" << std::endl;
}

void print_array(const std::vector<int>& v, bool in) {
    std::string word = "";
    word = (in ? "Input" : "output");

    std::cout << word << ": ";
    print_array(v);
}

//class Solution {
//public:
//    bool isMonotonic(std::vector<int>& A);
//};
//
//bool Solution::isMonotonic(std::vector<int>& A) {
//    bool monotonic = false;
//
//    for (int i = 0; i < A.size() - 1; i++) //It should run until one less than the greatest index
//        monotonic = (A[i] <= A[i + 1]);
//    return monotonic;
//}
//
//void answer_one() {
//    std::vector<std::vector<int>> sets = { {1,2,2,3},
//                                {6,5,4,4},
//                                {1,3,2},
//                                {1,2,4,5},
//                                {1,1,1} };
//    Solution s;
//
//    std::cout << std::boolalpha; //Set all boolean outputs as true/false
//
//    for (auto element : sets) {
//        std::cout << "Output: " << "[";
//        for (int i = 0; i < element.size(); i++) {
//            std::cout << element[i];
//            if (i != element.size() - 1)
//                std::cout << ", ";
//        }
//        std::cout << "]" << std::endl;
//
//        std::cout << "Input: " << s.isMonotonic(element) << std::endl << std::endl;
//    }
//}

class Solution {
public:
    void rotate(std::vector<int>& nums, int k) {
        //I was going to move the back and front pointers, but I cannot override how the vector is read
        int size = static_cast<int>(nums.size());

        if (size <= 1) return;

        k -= (k / size) * size; //Truncated count will eliminate loops
        if (k == 0) return;

        std::vector<int> copy(nums);
        if (k > size / 2) { //If k is greater than half the size of the array, then it should rotate left
            k = size - k;

            std::vector<int> holder(k);
            for (int i = 0; i < k; i++)
                holder[i] = nums[i];

            for (int i = 0; i < size - k; i++) //Shift the remaining back
                nums[i] = copy[i + k];

            for (int i = size - k; i < size; i++) //Fill the empty spot at the back
                nums[i] = holder[i - (k + 1)];

            holder.clear();
            holder.shrink_to_fit();
        }
        else { //Rotate right
            std::vector<int> holder(k);
            for (int i = size - k; i < size; i++)
                holder[i - (size - k)] = nums[i];

            for (int i = k; i < size; i++) //Shift the remaining forward
                nums[i] = copy[i - k];

            for (int i = 0; i < k; i++) //Fill the empty spot at the front
                nums[i] = holder[i];

            holder.clear();
            holder.shrink_to_fit();
        }
        copy.clear();
        copy.shrink_to_fit();
    }
};

int main() {
    std::vector<std::vector<int>> sets = { {1,2,2,3},
                                            {6,5,4,4},
                                            {1,3,2},
                                            {1,2,4,5},
                                            {1,1,1} };
    Solution s;

    for (auto element : sets) {
        print_array(element, true);

        s.rotate(element, 2);

        print_array(element, false);
    }
    system("PAUSE");
    return EXIT_SUCCESS;
}