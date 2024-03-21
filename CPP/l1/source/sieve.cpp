#include <sieve.hpp>

#include <stdlib.h> 
#include <vector>
#include <stdexcept>
#include <string>

#include <utils.hpp>
    
std::vector<long int> Sieve::primes_sieve(const long int n) noexcept(false)
{
    if(n<2)
    {
        throw std::invalid_argument(LOC() + "got " + std::to_string(n) + " which is less that 2");
    }

    std::vector<bool> prime(n+1, true);

    for(unsigned long p = 2; p*p < n; p++)
    {
        if(prime[p])
        {
            for(size_t i = p*p; i < n; i += p)
            {
                prime[i] = false;
            }
        }
    }

    std::vector<long int>primes;

    for(unsigned long j = 2; j < n; j++)
    {
        if(prime[j])
        {
            primes.push_back(j); 
        }
    }

    return primes;
}
