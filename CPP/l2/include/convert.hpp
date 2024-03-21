#ifndef CONVERT_HPP
#define CONVERT_HPP

#include <string>

class Convert
{
public:
    Convert() = delete;

    template <typename T>
    static T string_to(const std::string& s) noexcept(false);
};

#endif