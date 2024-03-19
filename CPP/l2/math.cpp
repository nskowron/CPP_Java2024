#include <stdlib.h> 
#include <vector>
#include <iostream>

typedef class Math
{
public:
    
    static size_t factorial(const size_t n)
    {
        if(n<0)
        {
            //wstaw error
            return;
        }
        else if (n==0||n==1)
        {
            return 1;
        }
        
        size_t result = 1;

        for(size_t i = 2; i <= n; i++)
        {
            result = result*i;
        }

        return result;
    }

    static size_t newton_symbol(size_t n, size_t k)
    {
        if(k>n)
        {
            //wstaw error
            return;
        }
        return (factorial(n)/(factorial(k)*factorial(n-k)));
    }

    static std::vector<size_t> primes_sieve(size_t n)
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

}math;