#include <prime_numbers.hpp>
// #include <unit_tests.hpp>
#include <converter_lib.hpp>

#include <vector>
#include <iostream>

int main(const int argc, const char* const argv[])
{
    ConverterLIB::func();
    if(argc > 1)
    {
        std::size_t n = ConverterLIB::ConvertStringTo<std::size_t>(std::string(argv[1]));
        PrimeNumbers PM(n);

        for(unsigned int i = 2; i < argc; ++i)
        {
            std::cout << argv[i] << " - ";
            try
            {
                int m = ConverterLIB::ConvertStringTo<int>(std::string(argv[i]));
                std::cout << PM.number(m) << '\n';
            }
            catch(const std::out_of_range& e)
            {
                std::cout << "wrong range\n";
            }
            catch(const std::invalid_argument& e)
            {
                std::cout << "invalid data\n";
            }
        }
    }

    return 0;
}
