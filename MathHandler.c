/*
    AUTHOR: Brandon Weathers
    DATE LAST MODIFIED: 6/14/2026
*/

#include<stdbool.h>
#include<stdio.h>
#define MAX_SIZE 1000

typedef struct {
    double items[MAX_SIZE];
    int front;
    int rear;
} Queue;

void initializeQueue(Queue *q) {
    q->front = -1;
    q->rear = 0;
}

bool isEmpty(Queue *q) {
    return (q->front == q->rear - 1);
}

bool isFull(Queue *q) {
    return (q->rear == MAX_SIZE);
}

void enqueue(Queue *q, double value) {
    if (isFull(q))
    {
        printf("Queue is full\n");
        return;
    }
    q->items[q->rear] = value;
    q->rear++;
}

void dequeue(Queue *q) {
    if (isEmpty(q))
    {
        printf("Queue is empty\n");
        return;
    }
    q->front++;
}

// Function to get the element at the front of the queue
double peek(Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return -1; // return some default value or handle
                   // error differently
    }
    return q->items[q->front + 1];
}

void printQueue(Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return;
    }

    for (int i = q->front + 1; i < q->rear; i++) {
        printf("%.2f\n", q->items[i]);
    }
}

// Set result = 0.0 when calling
void addQueue(Queue *q, double result) {
    if(isEmpty(q)) {
        enqueue(q, result);
    }else {
        result += peek(q);
        dequeue(q);

        addQueue(q, result);
    }
}

void subtractQueue(Queue *q, double result) {
    printf("The current result is: %f\n", result);
    dequeue(q);

    if(isEmpty(q)) {
        enqueue(q, result);
    }else {
        result = result - peek(q);
        subtractQueue(q, result);
    }
}

double main() {
    Queue mainQueue;
    initializeQueue(&mainQueue);

    enqueue(&mainQueue, 1.0);
    enqueue(&mainQueue, 2.0);
    enqueue(&mainQueue, 3.0);
    /* addQueue(&mainQueue, 0.0); */
    subtractQueue(&mainQueue, peek(&mainQueue));

    printQueue(&mainQueue);

    return 0;
}
