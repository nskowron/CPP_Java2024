#include <vector>
#include <iostream>
#include <string>
#include <exception>

#define LOG_LOC() std::string(__FILE__) + ":" + std::to_string(__LINE__) + " [" + std::string(__func__) + "] "

class Student
{
private:
    unsigned age; // GET, SET
    std::string name; // GET
    bool is_active; // METADATA

public:
    Student() = delete;
    Student(const unsigned age, const std::string& name) // pamiętaj o referencji
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

    Student(const unsigned age)
    : Student(age, "Unknown")
    {
        std::cout<<"Student created only with age "<< age <<std::endl;
    }

    ~Student() // destruktor!
    {
        std::cout<<"student destroyed"<<std::endl;
    }

    int get_age() const // daje znać że nie zmieniam danych klasy
    {   
        if(is_active == false)
        {
            std::cout<<"student is not active"<<std::endl;
            return 0;
        }

        return age;
    }

    void set_age(const unsigned age)
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

    const std::string& get_name() const //stały string przez referencje
    {
        if(is_active == false)
        {
            std::cout<<"student is not active"<<std::endl;
            return name; // bo inaczej sie pierdoli - kukowksi
        }
        return name;
    }
};


int main()
{
    try //exception handling
    {
        Student dupa(15);
    }
    catch(const std::invalid_argument& e)
    {
        std::cerr<<e.what()<<std::endl;  // e.what zwraca co tam wpisaliśmy w exception (linijka 22)  
    }
    
    Student kobyla(55);
    Student kukowski(18,"Kukowski");

    std::cout<<kobyla.get_age()<<" "<<kobyla.get_name()<<std::endl;
    std::cout<<kukowski.get_age()<<" "<<kukowski.get_name()<<std::endl;

    return 0;
}