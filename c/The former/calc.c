#include <stdio.h>    /*���*/
int main(void)
{
    char operator;
    int operand1, operand2;
    int repeat, ri;
    int f(int operand1,int operand2,char operator);

    scanf("%d", &repeat);
    for(ri = 1; ri <= repeat; ri++){
        scanf("%d", &operand1);
        while((operator = getchar())!='='){
        	scanf("%d",&operand2);
        	operand1=f(operand1,operand2,operator);
        	}
        
        printf("%d\n", operand1);
   }
}
     int f(int operand1,int operand2,char operator){
     	int result;
     	switch (operator)
     	{
     		case '+':
     			result=operand1+operand2; 
     		break;
     		case '-':
     			result=operand1-operand2; 
     		break;
     		case '*':
     			result=operand1*operand2; 
     		break;
     		case '/':
     			result=operand1/operand2; 
     		break;
     		default:;
     	}
     	return result;
     	}