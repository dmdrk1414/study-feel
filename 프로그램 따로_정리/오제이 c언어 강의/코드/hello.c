#include <stdio.h>

int main()
{
    int a;
    int *pa;
    int **ppa;

    a = 3;
    printf("a = %d\n", a);
    printf("&a = %d\n", &a);

    printf("\n");

    pa = &a;

    printf("pa =  %u\n", pa);
    *pa = 5;
    printf("*pa = %d\n", *pa);
    printf("&pa = %u\n", &pa);
    printf("a = %d\n", a);

    ppa = &pa;
    printf("\n");
    printf("*ppa =  %u\n", *ppa);
    printf("**ppa = %u\n", **ppa);
    printf("&ppa = %u\n", &ppa);

    printf("\n");
    **ppa = 8;
    printf("**ppa = %u\n", **ppa);
    printf("a = %d\n", a);

    return 1;
}
