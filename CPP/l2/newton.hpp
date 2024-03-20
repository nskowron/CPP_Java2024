#ifndef NEWTON_HPP
#define NEWTON_HPP

#include <vector>

class Newton
{
private:
    static size_t newton_symbol(const long int n, const long int k) noexcept(false);

public:
    
    Newton() = delete;
    static std::vector<size_t> row(const long int n);
};

#endif