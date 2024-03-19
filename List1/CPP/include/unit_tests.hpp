#ifndef UNIT_TESTS_HPP
#define UNIT_TESTS_HPP

class UnitTests
{
public:
    UnitTests() = delete;
    ~UnitTests() = delete;

    //static void TestPrimeNumbersException(std::size_t n) noexcept(false);
    static void TestPrimeNumbers() noexcept(false);
    static void TestAll() noexcept(false);
};

#endif
