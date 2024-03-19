#include <primes.hpp>

#include <vector>

#include <sieve.hpp>

Primes::Primes(const size_t n)
: primes(Sieve::primes_sieve(n))
{

}

const size_t Primes::get_prime(const size_t n)
{
    if(n > primes.size())
    {
        //walnij error
        return;
    }

    return primes[n];
}