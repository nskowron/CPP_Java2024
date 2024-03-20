#ifndef PASCAL_HPP
#define PASCAL_HPP

#include <vector>

class Pascal
{
private:
    std::vector<size_t> row;

public:
    Pascal() = delete;
    Pascal(const long int n);

    size_t operator[](const long int n);
    void display();

};

#endif