#include <IO.hpp>

#include <iostream>

void IO::setOutputLine(const std::string& line)
{
    std::cout << line << std::endl;
}

std::string IO::getInputLine()
{
    std::cout << "> " << std::endl;

    std::string line;
    std::getline(std::cin, line);
    return line;
}