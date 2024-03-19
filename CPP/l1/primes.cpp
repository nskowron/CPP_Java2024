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

const size_t Primes::operator[](const size_t n)
{
    if(n > primes.size() || n < 0)
    {
        throw std::invalid_argument(LOC() + "got " + std::to_string(n) + " which is over the size of the generated primes vector");
    }

    return primes[n];
}