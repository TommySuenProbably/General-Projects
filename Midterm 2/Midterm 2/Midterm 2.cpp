/*
Question 3a) See the code below and comments (It looks a bit cluttered, but it explains each step
Question 3b)
1. Value is negative with 555 and 888 -> -67888814256255519
    cout: -142562
2. Value is negative with only 555 -> -6781425625556251
    cout: -678142562
3. Value is negative with no conditions -> -87127856231
    cout: 0
4. Value is 0
    cout: 0
5. Value is positive with only 555 -> 12877891238555521
    cout: 128778912385
*/

#include <iostream>

long long int find_specified_sequence(long long int val, int fives, int eights) {
    //Case 1: Negative values, call the recursive function on the positive and return the negative of that
    if (val < 0)
        return -1 * find_specified_sequence(-1 * val, 0, 0);
    //Case 2: Input value is 0
    //Base Case: When the value has been cut down to 0, return +0
    if (val == 0)
        return 0;
    
    long long int digit = val % 10; //Variable to hold the value
    
    //This occurs after 555 is detected
    //The code below no longer matters
    if (fives >= 3) {
        //'fives' acts as the counter for the powers of following digits past 555
        //Each additional digit is multiplied for a power of 10, with counter of 5 - 3(the start count)

        //If the digit is 8,...
        if (digit == 8) {
            if (eights == 2) //If the 'eights' counter has found three in a row
                return -88 * pow(10, fives - 3 - 2); //Subtract the previous additions for the last two digits

            //Else, send a copy reduced by the last digit, increment eights, and return the call plus the digit
            return find_specified_sequence(val / 10, fives + 1, eights + 1) + digit * pow(10, fives - 3);
        }

        //If the digit is not 8,
        //Send a copy reduced by the last digit, set eights to 0, and return the call plus the digit
        return find_specified_sequence(val / 10, fives + 1, 0) + digit * pow(10, fives-3);
    }

    //If the digit is five, send a copy reduced by the last digit, keep track of the occurrences of '5'
    if(digit == 5)
        return find_specified_sequence(val / 10, fives+1, 0);

    //Else, send a copy reduced by the last digit, set both counters to 0, and continue on
    return find_specified_sequence(val / 10, 0, 0);
}

long long int find_specified_sequence(long long int val) {
    return find_specified_sequence(val, 0, 0);
}

int main()
{
    std::cout << "Expected: -142562" << std::endl;
    std::cout << "Actual: " << find_specified_sequence(-6788881425625551) << std::endl << std::endl;

    std::cout << "Expected: -678142562" << std::endl;
    std::cout << "Actual: " << find_specified_sequence(-6781425625556251) << std::endl << std::endl;

    std::cout << "Expected: 0" << std::endl;
    std::cout << "Actual: " << find_specified_sequence(-87127856231) << std::endl << std::endl;

    std::cout << "Expected: 0" << std::endl;
    std::cout << "Actual: " << find_specified_sequence(0) << std::endl << std::endl;

    std::cout << "Expected: 128778912385" << std::endl;
    std::cout << "Actual: " << find_specified_sequence(12877891238555521) << std::endl << std::endl;
    
    system("PAUSE");
    return EXIT_SUCCESS;
}

