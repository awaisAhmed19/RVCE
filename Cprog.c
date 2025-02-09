#include <stdio.h>


int main(){
  char a='S';
  int b=10;
  long lb=1093888;
  double db=10.2333;
  char *p=&a;
  int *pb=&b;
  long *plb=&lb;
  double *pdb=&db;
   
  int size=sizeof (int); 
  printf("%p is %c \n",p,*p);
  printf("%p is %d\n",pb,*pb);
  printf("%p is %ld\n",plb,*plb);
  printf("%p is %lf\n",pdb,*pdb);
  printf(" size of int %d\n",size);
  printf(" size of pointer %d\n",sizeof *p);
  
  struct std{
    char name[10];
    int roll;
    float marks;

  }s;

  int high,low=0,array=0;
    
  clock_t start = clock();
    
  clock_t end = clock();
  float seconds = (float)(end - start) / CLOCKS_PER
  
  union item{
    int x;
    float y;
    char ch;
  };

  int arr[]={10,20,40,50,200};
  int asize=sizeof (arr)/sizeof(int);

  for (int i=0;i<asize;i++){
    printf("%d ,",*(arri));
  }
  


  return 0;
  
}
