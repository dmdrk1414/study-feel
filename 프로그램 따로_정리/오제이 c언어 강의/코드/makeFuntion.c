#include <stdio.h>
#include <string.h>

char *strcpy(char *dest, const char *src);
size_t strlen(const char *s);

int main()
{
    char str[20] = "!!!!!";
    char str_c[20] = "u";

    /* printf("str_number : %ld\n", strlen(str));
    printf("str_c_number : %ld\n", strlen(str_c));

    printf("str_c : %s\n", str_c);
    strcpy(str_c, str);
    printf("str_c_late : %s\n", str_c);*/

    printf("%d\n", strcmp(str, str_c));
}

size_t strlen(const char *s)
{
    int counter = 0;

    if (s != NULL)
    {
        for (int i = 0;; i++)
        {
            if (*(s + i) == 0)
            {
                break;
            }
            else
            {
                counter++;
            }
        }
    }
    else
    {
        return -1;
    }

    return counter;
}

char *strcpy(char *dest, const char *src)
{
    /*for (int i = 0; i < strlen(src); i++)
    {
        *(dest + i) = *(src + i);
    }*/

    /*for (int i = 0; *src != 0; i++)
    {
        *dest++ = *src++;
    }*/

    while (*src != 0)
    {
        *dest++ = *src++;
    }
}
