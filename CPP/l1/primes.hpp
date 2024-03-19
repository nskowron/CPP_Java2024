#ifndef PRIMES_HPP
#define PRIMES_HPP

#include <vector>

class Primes
{
private:
    std::vector<size_t> primes;

public:
    Primes() = delete;
    Primes(const size_t n);
    const size_t get_prime(const size_t n);
};

#endif