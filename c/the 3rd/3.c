//������գ���Ҫ�ı�����������йص���䡣
//����һ��������repeat (0<repeat<10)����repeat���������㣺
//����1 ��ʵ��x�������� n(n<=50)�����㲢��� x �� n ����(����2λС��)������������pow�������ݡ�
//�������ʾ������������˵��
//����
//2       (repeat=2)
//1.5 2   (x=1.5,n=2)
//2 7     (x=2,n=7)
//���
//2.25
//128.00


#include <stdio.h>
int main(void)
{
    int i, n;
    int repeat, ri;
    double mypow, x;

    scanf("%d", &repeat);
    for(ri = 1; ri <= repeat; ri++){
        scanf("%lf%d", &x, &n);
        mypow=1;
        for(i=1;i<=n;i++){
        	mypow=mypow*x;
        	}
/*---------*/
        printf("%.2f\n", mypow);
   }
}