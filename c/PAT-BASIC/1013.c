#include <stdio.h>
#include <math.h>
int prime( int n ){
	int i, limit;
	limit = (int) sqrt(n) + 1;
	for(i = 2; i < limit; i++)
	if(!(n % i))
		return 0;
	return 1;
	}
int main(){
   int m, n, i, pri[10000], number[110000],count = 0, multi;
   scanf("%d%d",&m, &n);

   for(i = 0; i < 110000 ; i++)
   number[i] = i ;

   for(i = 2; count < n ; i++)//������õ�ɸѡ�����ķ�����֮ǰ������ͬ
       if(number[i] && prime( number[i] )){
       	pri[count ++ ] = i;
       	multi = 2;
       	while(multi * i < 110000){
       	number[ multi * i ] = 0;
       	multi ++;
      }
       	}

   count = 0;
   for(i = m - 1; i < n; i++){
   	printf("%d",pri[i]);
   	if(++count % 10 && i < n - 1)
   		printf(" ");
   	else
   		printf("\n");
   	}


}