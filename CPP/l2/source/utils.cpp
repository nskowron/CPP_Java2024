#include <utils.hpp>

#include <stdexcept>
#include <string>

void Validate::is_left_more_than_right(long int left, long int right, std::string loc) noexcept(false) // nie wiem jak dodać " & " jeszcze
{
    if(left < right)
    {
        throw std::out_of_range(loc + std::to_string(left) + " < " + std::to_string(right));
    }
}
