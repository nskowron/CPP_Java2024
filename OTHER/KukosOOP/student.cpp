#include <student.hpp>

#include <exception>
#include <iostream>

#include <utils.hpp>



Student::Student(const unsigned age, const std::string& name) // pamiętaj o referencji
: age(age), name(name), is_active(true) // lista init (ten pierwszy to "this")
{
    if (age <19)
    {
        std::cout<<"Student is too young"<<std::endl;
        is_active = false;
        throw std::invalid_argument(LOG_LOC() + "Age should be > 18, age: " + std::to_string(age));
    }
    std::cout<<"Student created with age "<< age <<" and name "<< name <<std::endl;
}

Student::Student(const unsigned age)
: Student(age, "Unknown")
{
    std::cout<<"Student created only with age "<< age <<std::endl;
}

Student::~Student() // destruktor!
{
    std::cout<<"student destroyed"<<std::endl;
}

//najpierw co zwraca potem skąd jest

unsigned Student::get_age() const // daje znać że nie zmieniam danych klasy
{   
    if(is_active == false)
    {
        std::cout<<"student is not active"<<std::endl;
        return 0;
    }

    return age;
}

void Student::set_age(const unsigned age)
{
    if(is_active == false)
    {
        std::cout<<"student is not active"<<std::endl;
        return;
    }

    if(age == this->age)
    {
        std::cout<<"age is the same"<<std::endl;
    }

    this->age = age;
}

const std::string& Student::get_name() const //stały string przez referencje
{
    if(is_active == false)
    {
        std::cout<<"student is not active"<<std::endl;
        return name; // bo inaczej sie pierdoli - kukowksi
    }
    return name;
}
