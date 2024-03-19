#include<sieve.hpp>

#include <stdlib.h> 
#include <vector>


    
std::vector<size_t> Sieve::primes_sieve(const size_t n) noexcept(false)
{
    if(n<2)
    {
        //wstaw error
        return;
    }

    bool prime[n+1];

    for(size_t p = 2; p*p < n; p++)
    {
        if(prime[p])
        {
            for(size_t i = p*p; i < n; i += p)
            {
                prime[i] = false;
            }
        }
    }

    std::vector<size_t>primes;

    for(size_t j = 2; j <= n; j++)
    {
        if(prime[j])
        {
            primes.push_back(j); 
        }
    }

    return primes;
}
