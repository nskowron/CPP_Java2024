#include <unit_tests.hpp>
#include <prime_numbers.hpp>
#include <converter_lib.hpp>

#include <cassert>

void UnitTests::TestAll()
{
    TestPrimeNumbers();
    TestConverter();
}

void UnitTests::TestPrimeNumbers()
{
    {
        PrimeNumbers(2);
        PrimeNumbers(23);
        PrimeNumbers(65973512);
    }

    {
        PrimeNumbers PM(87620545);
        assert(PM.number(0) == 2);
        assert(PM.number(4) == 11);
    }

    {
        PrimeNumbers PM(100);
        assert(PM.number(0) == 2);
        assert(PM.number(7) == 19);
        assert(PM.number(24) == 97);

        try
        {
            PM.number(25);

            assert(false);
        }
        catch(const std::exception& e)
        {
            assert(true);
        }
    }

    {
        PrimeNumbers PM(53);
        assert(PM.number(15) == 53);

        try
        {
            PM.number(16);

            assert(false);
        }
        catch(const std::exception& e)
        {
            assert(true);
        }
        try
        {
            PM.number(-1);

            assert(false);
        }
        catch(const std::exception& e)
        {
            assert(true);
        }
    }

    try
    {
        PrimeNumbers(1);

        assert(false);
    }
    catch(const std::exception& e)
    {
        assert(true);
    }
    
    try
    {
        PrimeNumbers(0);

        assert(false);
    }
    catch(const std::exception& e)
    {
        assert(true);
    }
}

void UnitTests::TestConverter()
{
    {
        assert(ConverterLIB::ConvertStringTo<std::size_t>("0") == 0);
    }
}
