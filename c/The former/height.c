#include <stdio.h>
#include <math.h>
int main(void)
{
    int i, n;
    int repeat, ri;
    double distance, height; 

    scanf("%d", &repeat);
    for(ri = 1; ri <= repeat; ri++){
        scanf("%lf%d", &height, &n);
        distance=height;
        if(n==1){
        	height=height/2;
           printf("distance = %.1f, height = %.1f\n", distance, height);
        	continue;}
        for(i=2;i<=n;i++){
        	distance=distance+2*height/(pow(2,i-1));
        	}
        	height=height/(pow(2,n));
      	printf("distance = %.1f, height = %.1f\n", distance, height);
   }
}