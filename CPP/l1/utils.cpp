#include <utils.hpp>

#include <stdexcept>
#include <string>
#include <type_traits>

void Validate::is_less_than(long int target, long int input) noexcept(false)
{
    if(target < input)
    {
        throw std::out_of_range(LOC() + "Provided entry: " + std::to_string(input) + " is more than expected:  " + std::to_string(target));
    }
}

void Validate::is_more_than(long int target, long int input) noexcept(false)
{
    if(target > input)
    {
        throw std::out_of_range(LOC() + "Provided entry: " + std::to_string(input) + " is less than expected:  " + std::to_string(target));
    }
}

void Validate::is_from_interval(long int int_begin, long int int_end, long int input) noexcept(false)
{
    if(int_end < input || int_begin > input)
    {
        throw std::out_of_range(LOC() + "Provided entry: " + std::to_string(input) + " is out of allowed space " + std::to_string(int_begin) + " - " + std::to_string(int_end));
    }
}


template <typename source, typename target>
void Validate::conversion_possible_to() noexcept(false)
{
    if(!std::is_convertible<source, target>::value)
    {
        throw std::invalid_argument(LOC() + "Provided variable could not be converted to the desired type");
    }
}