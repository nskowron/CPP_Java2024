#include <iostream>
#include <stdexcept>
#include <string>
#include <stdlib.h>

#include <primes.hpp>
#include <convert.hpp>


int main(const int argr, const char* const argv[]) // ilosc argumentów, tablica charów tych argumentów
{
    if(argr > 1)
    {
        size_t n = Convert::string_to<size_t>(std::string(argv[1]));
        Primes primeLIST(n);

        for(unsigned i = 2; i < argr; i++)
        {
            try
            {
                size_t m = Convert::string_to<size_t>(std::string(argv[i]));
                std::cout<<primeLIST[m-1]<< " is the prime for input: " << argv[i]<<std::endl;
            }
            catch(const std::invalid_argument& e)
            {
                std::cerr<<e.what()<<std::endl;
            }
        }

        primeLIST.display();
    }

}