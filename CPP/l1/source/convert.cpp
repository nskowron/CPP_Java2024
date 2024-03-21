#include <convert.hpp>

#include <string>
#include <sstream>
#include <stdexcept>
#include <string>

#include <utils.hpp>

template size_t Convert::string_to(const std::string& s);
template long int Convert::string_to(const std::string& s);
template <typename T>
T Convert::string_to(const std::string& s)
{
    T result;

    std::stringstream ss(s);

    ss >> result;

    if(ss.fail())
    {
        throw std::invalid_argument(LOC() + "unable to convert string:  " + s + " to " /*+ typeid(T).name()*/ + "desired data-type");
    }

    return result;
}