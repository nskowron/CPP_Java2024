#include <convert.hpp>

#include <string>
#include <sstream>
#include <stdexcept>
#include <string>

#include <utils.hpp>

template <typename T>
T Convert::string_to(const std::string& s)
{
    T result;

    std::stringstream ss(s);

    ss >> result;

    if(ss.fail())
    {
        throw std::invalid_argument(LOC() + "unable to convert " + s + typeid(T).name());
    }

    return result;
}