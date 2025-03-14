#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
  int data;
  struct Node* prev;
  struct Node* next;
}Node;

void insertHead(Node** head, int num){
  Node* newNode=(Node* )malloc(sizeof Node);
  newNode->data=num;
  newNode->prev=NULL;
  newNode->next=*head;
  if(*head!=NULL) (*head)->prev=newNode;

  *head=newNode;
}

void mulitply(Node** head,num){
  Node* head= *temp;
  int carry=0;

  while(temp){
    int prod=(temp->data * num)+carry;
    temp->data=prod%10;
    carry=prod/10;
    if(temp->next==NULL&&carry==0){
      while(carry>0){
        insertHead(head,carry%10);
        carry=carry/10;
      }
    }
    temp=temp->next;
  }
}

int main(){

}
