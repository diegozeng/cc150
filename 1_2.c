/*
 * 1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.
 *
 * 思路：申明两个指针，分别指向字符串首尾地址，每一次循环后：首指针和尾指针分别后移和前移一位；一个reverse函数，替换两指针对应的数值.
 * 特殊情况: 考虑了空指针.
 */

# include <stdio.h>
# include <string.h>
# include <stdlib.h>

// declare functions
void Reverse(char* );

int main(void)
{
	char InputArray[] = "diegozeng";
	Reverse(InputArray); // 存放的是字符数组第一位元素的地址
	printf("After reverse: %s\n", InputArray);
	return 0;	
}

void Reverse(char* pArray)
{
	if (pArray == NULL)
	{
		printf("Error!\n");
		exit(-1);
	}

//	if (!Array)
//	{
//		return;	
//	}

	char* first = pArray;
	char* last = first + strlen(pArray)-1; //复习strlen的用法
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
