#include <prime_numbers.hpp>
#include <converter_lib.hpp>

#include <vector>
#include <iostream>
#include <cassert>

int main(const int argc, const char* const argv[])
{
    if(argc < 2)
    {
        std::cerr << "Not enough arguments\n";
        return 1;
    }

    PrimeNumbers* PM;

    try
    {
        int n = ConverterLIB::ConvertStringTo<int>(std::string(argv[1]));
        PM = new PrimeNumbers(n);
    }
    catch(const std::exception& e)
    {
        std::cout << argv[1] << " - " << e.what() << '\n';
        return 1;
    }

    for(unsigned int i = 2; i < argc; ++i)
    {
        std::cout << argv[i] << " - ";
        try
        {
            int m = ConverterLIB::ConvertStringTo<int>(std::string(argv[i]));
            std::cout << PM->number(m) << '\n';
        }
        catch(const std::exception& e)
        {
            std::cout << e.what() << '\n';
        }
    }

    delete PM;

    return 0;
}
