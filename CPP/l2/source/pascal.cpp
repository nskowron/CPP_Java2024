#include <pascal.hpp>

#include <stdlib.h> 
#include <vector>
#include <iostream>

#include <utils.hpp>
#include <newton.hpp>


Pascal::Pascal(const long int n)
:row(Newton::row(n))
{
}

size_t Pascal::operator[](const long int n)
{
    Validate::is_left_more_than_right(row.size(), n, LOC());
    Validate::is_left_more_than_right(n, 0, LOC());

    return row[n];
}

void Pascal::display()
{
    std::cout<<"Full row: ";
    for(size_t i = 0; i < row.size(); i++)
    {
        std::cout<< row[i] << " ";
    }
}
    


