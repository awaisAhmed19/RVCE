#include <stdio.h>

struct minmax{
  int min;
  int max;
};

struct minmax findMinMax(int arr[],int n){
  struct minmax mm;

  mm.min=arr[0]; //making initialization of the struct member min
  mm.max=arr[0]; //making initialization of the struct member max
  
  /*
   *i=0 arr[0]<mm.min 
        arr[0]==mm.min return false;
        
        arr[0]<mm.max
        arr[0]==mm.max return false;

   i=1  arr[1]<mm.min
        1<100 return true;
        mm.min=1;

        
   * */


  for (int i=0;i<n;i++){

    if(arr[i]<mm.min){
      mm.min=arr[i];
    }else if(arr[i]>mm.max){
      mm.max=arr[i];
    }
  }

  return mm;
}
int main(){
  int arr[]={100,1,2,56,43,67,43,3,10,11};

  struct minmax mm=findMinMax(arr,sizeof(arr)/sizeof(int));
  printf("min= %d, max=%d",mm.min,mm.max);

  return 0;
}
