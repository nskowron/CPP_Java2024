#include <newton.hpp>

#include <stdlib.h> 
#include <vector>
#include <stdexcept>
#include <string>

#include <utils.hpp>

size_t Newton::newton_symbol(const long int n, const long int k) noexcept(false)
{
    Validate::is_left_more_than_right(n, k, LOC());

    size_t result = 1;
    for(size_t i = 1; i <= k; ++i)
    {
        result *= n - k + i;
        result /= i;
    }

    return result;
}

std::vector<size_t> Newton::row(const long int n)
{
    Validate::is_left_more_than_right(n, 0, LOC());
    
    std::vector<size_t>full_row;

    for(size_t k = 0; k <=n; k++)
    {
        full_row.push_back(newton_symbol(n, k));
    }

    return full_row;
}