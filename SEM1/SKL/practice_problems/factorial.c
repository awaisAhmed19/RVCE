
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* prev;
    struct Node* next;
} Node;

void insertAtHead(Node** head, int value) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = value;
    newNode->prev = NULL;
    newNode->next = *head;
    if (*head != NULL) (*head)->prev = newNode;
    *head = newNode;
}

void multiply(Node** head, int num) {
    Node* temp = *head;
    int carry = 0;

    while (temp) {
        int prod = (temp->data * num) + carry;
        temp->data = prod % 10;  
        carry = prod / 10;  
        if (temp->next == NULL) break;  
        temp = temp->next;
    }

    while (carry > 0) {
        Node* newNode = (Node*)malloc(sizeof(Node));
        newNode->data = carry % 10;
        newNode->next = NULL;
        newNode->prev = temp;
        temp->next = newNode;
        temp = newNode;
        carry /= 10;
    }
}



void printFactorial(Node* head) {
    if (head == NULL) return;

    while (head->next) {
        head = head->next;
    }

    while (head) {
        printf("%d", head->data);
        head = head->prev;
    }
    printf("\n");
}


void factorial(int n) {
    Node* head = NULL;
    insertAtHead(&head, 1);  

    for (int i = 2; i <= n; i++) {
        multiply(&head, i);
    }
    printFactorial(head);
}

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);
    printf("Factorial of %d is: ", num);
    factorial(num);
    return 0;
}
