#include <primes.hpp>

#include <vector>
#include <stdexcept>
#include <stdlib.h>
#include <string>

#include <sieve.hpp>
#include <utils.hpp>


Primes::Primes(const size_t n)
: primes(Sieve::primes_sieve(n))
{
}

size_t Primes::operator[](const size_t n)
{
    if(n > primes.size())
    {
        throw std::invalid_argument(LOC() + "got " + std::to_string(n) + " which is over the size of the generated primes vector");
    }

    return primes[n];
}