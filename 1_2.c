# include <stdio.h>
# include <string.h>
# include <stdlib.h>

// declare functions
void Reverse(char* Array);

int main(void)
{
	char InputArray[] = "diegozeng";
	Reverse(InputArray);
	printf("After reverse: %s\n", InputArray);
	return 0;	
}

void Reverse(char* Array)
{
	if (!Array)
	{
		printf("Error!\n");
		exit(-1);
	}
	char* first = Array;
	char* last = first + strlen(Array)-1;
	char mid;
	while (first < last)
	{
		mid = first[0]; // mid = *first;
		first[0] = last[0]; // *first = *last;
		last[0] = mid; //*last = mid; 
		first++;
		last--;
	}
}
