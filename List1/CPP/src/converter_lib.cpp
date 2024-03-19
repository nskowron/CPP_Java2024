#include <converter_lib.hpp>
#include <utils.hpp>

#include <string>
#include <sstream>

template std::size_t ConverterLIB::ConvertStringTo<std::size_t>(const std::string&);
template int ConverterLIB::ConvertStringTo<int>(const std::string&);

template <typename T>
T ConverterLIB::ConvertStringTo(const std::string& s)
{
    T result;
    std::stringstream ss(s);

    ss >> result;

    if(ss.fail())
    {
        throw std::invalid_argument(LOG_LOC() + "couldn't convert " + s + " to " + typeid(T).name());
    }

    return result;
}
