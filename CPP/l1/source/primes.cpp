#include <primes.hpp>

#include <vector>
#include <stdexcept>
#include <stdlib.h>
#include <string>
#include <iostream>

#include <sieve.hpp>
#include <utils.hpp>


Primes::Primes(const long int n)
: primes(Sieve::primes_sieve(n))
{
}

long int Primes::operator[](const long int n) noexcept(false)
{
    if(n > primes.size())
    {
        throw std::invalid_argument(LOC() + "got " + std::to_string(n) + " which is over the size of the generated primes vector");
    }

    if(n < 0)
    {
        throw std::invalid_argument(LOC() + "got " + std::to_string(n) + " which is less than 0");
    }

    return primes[n];
}

void Primes::display()
{
    std::cout<<"Full list: ";
    for(unsigned long i = 0; i < primes.size(); i++)
    {
        std::cout<< primes[i] << " ";
    }
}