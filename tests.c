/*
+----------------------------------------------------------
*
* @authors: 风之凌殇 <1054073896@qq.com>
* @FILE NAME:	 TM_FILENAME
* @version:	 v1.0
* @Time: 		 2015-07-20 16:01:23
* @Description: 1计算分数精确值（10分）
题目内容：
由于计算机内部表达方式的限制，浮点运算都有精度问题，为了得到高精度的计算结果，就需要自己设计实现方法。
(0,1)之间的任何浮点数都可以表达为两个正整数的商，为了表达这样两个数的商，可以将相除的结果存放在一维数组中，数组的每个元素存放一位十进制数字。即商的第一位存放在第一个元素中，第二位存放在第二个元素中，以此类推，就可以用数组来表达一个高精度的除法结果了。
如16/19的结果0.8421052631...就可以依次存放8、4、2、1、0、5、2、6、3、1...在数组中。
而除法的过程，则可以模仿人工列竖式做除法的方式，先将被除数乘以10，得到一位商以后，将余数乘以10作为下一轮计算的被除数：
   160/19->8余8
   80/19->4余4
   ...
当某次余数为0时，则表明除尽。
现在，请写一个程序，输入一个分数，计算出它的小数形式。无论是否可以除尽，输出最多小数点后200位。

输入格式:
形如
   a/b
的两个数，其中10<=a<b<100。

输出格式：
形如
   0.xxxxxxxxx
的小数，小数点后最多200位。输出结束的时候要带着回车换行。

输入样例：
16/19

输出样例：
0.84210526315789473684210526315789473684210526315789473684210526315789473684210526315789473684210526315789473684210526315789473684210526315789473684210526315789473684210526315789473684210526315789473684

时间限制：500ms内存限制：32000kb
*
+----------------------------------------------------------
*/
#include <stdio.h>
#include <stdlib.h>
int main() {
	// count用于计数，模拟人工计算过程，并利用数组来寄存计算结果
	int count = 0, a, b, remainder = -1, quotient[200];
	scanf("%d%d", &a, &b);
	if (a >= b) {
		printf("%d.", a / b);
		a = a % b;
	}
	else
		printf("0.");
	a = 10 * a;
	while (remainder != 0 && count < 200) {
		remainder = a % b;
		quotient[count++] = a / b;
		a = 10 * remainder;
	}
	for (int i = 0; i < count; i++) {
		printf("%d", quotient[i]);
	}
	
	printf("\n\n\n");
	system("pause");
	return 0;
}