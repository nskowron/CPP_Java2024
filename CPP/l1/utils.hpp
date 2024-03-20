#ifndef UTILS_HPP
#define UTILS_HPP

#include <string>
#define LOC() std::string(__FILE__) + ":" + std::to_string(__LINE__) + " [ " + std::string(__func__) + " ] "

class Validate
{
    Validate() = delete;
    ~Validate() = delete;

public:
    static void is_less_than(long int target, long int input) noexcept(false);
    static void is_more_than(long int target, long int input) noexcept(false);
    static void is_from_interval(long int begin, long int end, long int input) noexcept(false);

    template <typename source, typename target>
    static void conversion_possible_to() noexcept(false);
};

#endif