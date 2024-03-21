#include <testrun.hpp>

#include <cassert>
#include <stdexcept>

#include <primes.hpp>
#include <convert.hpp>

void TestRun::run_all()
{
    void run_convert();
    void run_primes();
}

void TestRun::run_convert()
{
    {
    assert(Convert::string_to<long int>("1") == 1);
    assert(Convert::string_to<long int>("0") == 0);
    assert(Convert::string_to<long int>("19129") == 19129);
    assert(Convert::string_to<long int>("-12") == -12);
    assert(Convert::string_to<long int>("-34383") == -34383);
    assert(Convert::string_to<long int>("3388") == 3388);
    }

    try
    {
        Convert::string_to<long int>("dupa");

        assert(false); //gdyby się nie wywaliło - to tu się wywali
    }
    catch (const std::invalid_argument& e)
    {
        assert(true);
    }

    try
    {
        Convert::string_to<long int>("-dup10a");

        assert(false); //gdyby się nie wywaliło - to tu się wywali
    }
    catch (const std::invalid_argument& e)
    {
        assert(true);
    }

}

void TestRun::run_primes()
{
    {
    Primes test_primes(4);

    assert(test_primes[0] == 2);
    assert(test_primes[1] == 3);
    assert(test_primes[2] == 5);
    assert(test_primes[3] == 7);
    assert(test_primes[4] == 11);
    assert(test_primes[5] == 13);

    }
    
    try 
    {
        Primes test_primes(15);

        test_primes[16];

        assert(false);
    }
    catch (const std::invalid_argument& c)
    {
        assert(true);
    }

    try 
    {
        Primes test_pascal(15);

        test_pascal[-16];

        assert(false);
    }
    catch (const std::invalid_argument& c)
    {
        assert(true);
    }
}
