#include <iostream>

int main() {
    char ch1, ch2, ch3;

    // Prompt user for input
    std::cout << "Enter a character: ";
    std::cin >> ch1;

    // Check character type
    std::cout << "Character type: ";
    (isupper(ch1)) ? std::cout << "Uppercase" :
    (islower(ch1)) ? std::cout << "Lowercase" :
    (isdigit(ch1)) ? std::cout << "Digit" :
                    std::cout << "Other";
    std::cout << std::endl;

    // Assign and print ch2
    ch2 = 81;
    std::cout << "Decimal: " << int(ch2) << std::endl;
    std::cout << "Octal: " << std::oct << int(ch2) << std::endl;
    std::cout << "Hexadecimal: " << std::hex << int(ch2) << std::endl;
    std::cout << "Character: " << ch2 << std::endl;

    // Assign and print ch3
    ch3 = tolower(ch2);
    std::cout << "Decimal: " << int(ch3) << std::endl;
    std::cout << "Octal: " << std::oct << int(ch3) << std::endl;
    std::cout << "Hexadecimal: " << std::hex << int(ch3) << std::endl;
    std::cout << "Character: " << ch3 << std::endl;

    return 0;
}
