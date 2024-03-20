#include <utils.hpp>

#include <stdexcept>
#include <string>
#include <type_traits>

void Validate::is_left_more_than_right(long int left, long int right) noexcept(false)
{
    if(left < right)
    {
        throw std::out_of_range(LOC() + "Left: " + std::to_string(left) + " is less than right: " + std::to_string(right));
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