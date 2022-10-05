#include <stdio.h>

int swap(int *a, int *b);

int main()
{
    char str[100];
    char *pstr = str;

    scanf("%s", str);

    while (*pstr)
    {
        putchar(*pstr++);
    }
    fflush(stdin);

    scanf("%s", str);
    while (*pstr)
    {
        putchar(*pstr++);
    }

    return 1;
}

int swap(int *a, int *b)
{
    int c;
    c = *a;
    *a = *b;
    *b = c;
}
