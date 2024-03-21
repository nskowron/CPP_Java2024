#include <iostream>
#include <stdexcept>
#include <string>
#include <stdlib.h>

#include <primes.hpp>
#include <convert.hpp>
#include <utils.hpp>


int main(const int argr, const char* const argv[]) // ilosc argumentów, tablica charów tych argumentów
{
    if(argr <= 1)
    {
        std::cout<<"Usage: ./main <Primes_Smaller_Than> <arg 1> <arg 2> <arg 3> ...."<<std::endl;
        return 0;
    }
    
    else if(argr > 1)
    {   
        int n = Convert::string_to<size_t>(std::string(argv[1]));
        if(n < 1)
        {
            std::cerr<<LOC()<<" Invalid Range "<<std::endl;
            return 0;
        }
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

        std::cout<<std::endl;
        primeLIST.display();
    }

}