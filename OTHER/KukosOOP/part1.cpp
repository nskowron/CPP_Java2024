//kierunek z x grup po y osob

#include <vector>
#include <iostream>

class Student
{
public:
    int age;
};

class Group
{
public:
    std::vector<Student> students;
};

class Field
{
public:
    std::vector<Group> groups;
};

// wektory tutorial

int main()
{
    std::vector<int> vec {1,2,3,4,5,6,7,8,9,10};
    int x = vec.at(5);
    vec[5] = 199;
    int y = vec[5];

    //for (int i = 0; i<10; i++)
    //{
    //    vec.push_back(i);
    //}

    std::cout<< "Size: " << vec.size() << std::endl;
    std::cout<< "X = "<< x << std::endl;
    std::cout<< "Y = "<< y << std::endl;  

    //for(auto& x : vec) // zeby zmienic musi być "&" - referencja
    //{
    //    x = x*2;
    //}

    for(const auto& x : vec) //przekaz tylko wskaznik (wgle to ja for w pythonie jest)
    {
        std::cout<< x << std::endl;
    }



    return 0;
}