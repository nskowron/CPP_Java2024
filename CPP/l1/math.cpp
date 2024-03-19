#include <stdlib.h> 

typedef class Math
{
    public:
    
    static size_t factorial(const size_t n)
    {
        if(n<0)
        {
            //wstaw error
            return;
        }
        else if (n==0||n==1)
        {
            return 1;
        }
        
        size_t result = 1;

        for(size_t i = 2; i <= n; i++)
        {
            result = result*i;
        }

        return result;
    }

    static size_t newton_symbol(size_t n, size_t k)
    {
        if(k>n)
        {
            //wstaw error
            return;
        }
        return (factorial(n)/(factorial(k)*factorial(n-k)));
    }

}math;