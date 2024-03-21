#ifndef PRIMES_HPP
#define PRIMES_HPP

#include <vector>

class Primes
{
private:
    std::vector<long int> primes;

public:
    Primes() = delete;
    Primes(const long int n) noexcept(false);
    long int operator[](const long int n) noexcept(false);
    void display();

};

#endif