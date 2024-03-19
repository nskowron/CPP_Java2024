#ifndef SIEVE_HPP
#define SIEVE_HPP

#include<exception>
#include<vector>

class Sieve
{
public:

    static std::vector<size_t> primes_sieve(const size_t n) noexcept(false);

};


#endif