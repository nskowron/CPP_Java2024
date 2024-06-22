#ifndef IO_HPP
#define IO_HPP

#include <string>

class IO
{
public:
    IO() = delete;
    ~IO() = default;

    static void setOutputLine(std::string);
    static std::string getInputLine();
};

#endif