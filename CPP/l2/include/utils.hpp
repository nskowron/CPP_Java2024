#ifndef UTILS_HPP
#define UTILS_HPP

#include <string>
#define LOC() std::string(__FILE__) + ":" + std::to_string(__LINE__) + " [ " + std::string(__func__) + " ] "

class Validate
{
    Validate() = delete;
    ~Validate() = delete;

public:
    static void is_left_more_than_right(long int left, long int right, std::string loc) noexcept(false); // nie wiem jak dodać " & " jeszcze
};

#endif