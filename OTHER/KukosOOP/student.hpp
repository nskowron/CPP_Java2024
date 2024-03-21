#ifndef STUDENT_HPP
#define STUDENT_HPP

#include <string>
#include <exception>

class Student
{
private:
    unsigned age; 
    std::string name; 
    bool is_active; 

public:
    Student() = delete;
    Student(const unsigned age, const std::string& name); 
    Student(const unsigned age);

    ~Student(); 

    unsigned get_age() const; 
    void set_age(const unsigned age);
    const std::string& get_name() const; 
};

#endif 