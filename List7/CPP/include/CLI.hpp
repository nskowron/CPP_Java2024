#ifndef CLI_HPP
#define CLI_HPP

//#include <BST.hpp>

#include <functional>
#include <string>

template <typename T>
class CLI
{
private:
    //BST tree;
    std::function<T(const std::string&)> parse;

public:
    CLI(std::function<T(const std::string&)> parser) : parse(parser) {}

    void run();
};

#endif