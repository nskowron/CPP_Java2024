#include <iostream>
#include <stdexcept>
#include <string>
#include <stdlib.h>


size_t newton_symbol(const unsigned long long n, const unsigned long long k)
{
    std::size_t result = 1;
    for(std::size_t i = 1; i <= k; ++i)
    {
        result *= n - k + i;
        result /= i;
    }

    return result;
}

unsigned long long convert(const char* str)
{
    char* endptr;
    unsigned long long result = strtoull(str, &endptr, 10);

    if (*endptr != '\0') 
    {
        std::cerr << "Conversion error: not a valid number\n";
        return 0;
    }
    else
    {
        return result;
    }
}

int main(const int argr, const char* const argv[]) // ilosc argumentów, tablica charów tych argumentów
{
    if(argr <= 1)
    {
        std::cout<<"Usage: ./main <Number_of_Row> <Row element i>"<<std::endl;
        return 0;
    }
    
    std::cout<<newton_symbol(convert(argv[1]),convert(argv[2]));
}