#include <stdio.h>
#include <string.h>

int main()
{
    int n, x, y, i;
    char a[100];

    scanf("%d", &n);
    getchar();
    scanf("%[^\n]s", a);

    x = 1;
    y = 1;

    for (i = 0; i < strlen(a); i++)
    {
        if (a[i] != 0)
        {
            if (a[i] == 'R')
            {
                y = y + 1;
                if (y > n)
                {
                    y = y - 1;
                }
            }
            else if (a[i] == 'U')
            {
                x = x - 1;
                if (x < 1)
                {
                    x = x + 1;
                }
            }
            else if (a[i] == 'D')
            {
                x = x + 1;
                if (x > n)
                {
                    x = x - 1;
                }
            }
            else if (a[i] == 'L')
            {
                y = y - 1;
                if (y < 1)
                {
                    y = y + 1;
                }
            }
            else
            {
                printf("");
            }
        }
        else
        {
            break;
        }
    }

    printf("%d %d", x, y);
}