#ifndef SHAPE_HPP
#define SHAPE_HPP

#include <string>

class Shape
{
public:
    virtual double Area();
    virtual double Circumference();
    virtual std::string Name();
};

#endif