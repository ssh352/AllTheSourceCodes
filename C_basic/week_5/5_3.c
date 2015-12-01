/*
+----------------------------------------------------------
*
* @authors: 风之凌殇 <1054073896@qq.com>
* @FILE NAME :5_3.c
* @version： v1.0
* @Time: 2015-07-19 20:16:56
* @Description:
*1逆序的三位数（5分）
题目内容：
程序每次读入一个正三位数，然后输出逆序的数字。注意，当输入的数字含有结尾的0时，输出不应带有前导的0。比如输入700，输出应该是7。

输入格式:
每个测试是一个3位的正整数。

输出格式：
输出逆序的数。

输入样例：
123

输出样例：
321
时间限制：500ms内存限制：32000k
+----------------------------------------------------------
*/
#include <stdio.h>
#include <stdlib.h>
int revert(int x);
int main() {
	int n;
	scanf("%d", &n);
	printf("%d\n", revert(n));

	system("pause");
	return 0;
}
int revert(int x) {
	int rev = 0;
	while (x > 0) {
		rev = rev * 10 + x % 10;
		x /= 10;
	}
	return rev;
}