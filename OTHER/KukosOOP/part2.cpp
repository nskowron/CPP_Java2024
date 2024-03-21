//Template na dodawanie typów


template <typename T>
T add (const T a, const T b)
{
    return a + b;
}

int main()
{
    auto x = add<int>(1,2);
    auto y = add<double>(1.0, 2.0);
    return 0;
}