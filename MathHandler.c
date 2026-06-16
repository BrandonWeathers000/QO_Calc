/*
    Author: Brandon Weathers
    Date last modified: 6/14/2026
    I want to rewrite all of these function so that they return a value
    rather than manipulate the queue (and return void).
*/

#include<stdbool.h>
#include<stdio.h>
#include<math.h>
#define MAX_SIZE 1000

// Start of data structures
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
        printf("%.3f\n", q->items[i]);
    }
}

// End of data structures

void addQueue(Queue *q, double result) {
    dequeue(q);

    if(isEmpty(q)) {
        enqueue(q, result);
    }else {
        result += peek(q);
        addQueue(q, result);
    }
}

void subtractQueue(Queue *q, double result) {
    dequeue(q);

    if(isEmpty(q)) {
        enqueue(q, result);
    }else {
        result -= peek(q);
        subtractQueue(q, result);
    }
}

void multiplyQueue(Queue *q, double result) {
    dequeue(q);

    if(isEmpty(q)) {
        enqueue(q, result);
    }else {
        result *= peek(q);
        multiplyQueue(q, result);
    }
}

void divideQueue(Queue *q, double result) {
    dequeue(q);

    if(isEmpty(q)) {
        enqueue(q, result);
    }else {
        result /= peek(q);
        divideQueue(q, result);
    }
}

/* double expoQueueLeftToRight(Queue *q, double result, double expo) { */
/*     dequeue(q); */

/*     if (!isEmpty(q)) { */
/*         return peek(q) * expoQueueLeftToRight(q, result, expo); */
/*     } else { */
/*         return powf(result, expo); */
/*     } */
/* } */

double main() {
    Queue mainQueue;
    initializeQueue(&mainQueue);

    enqueue(&mainQueue, 2.0);
    enqueue(&mainQueue, 3.0);
    enqueue(&mainQueue, 4.0);
    /* addQueue(&mainQueue, peek(&mainQueue)); */
    /* subtractQueue(&mainQueue, peek(&mainQueue)); */
    /* multiplyQueue(&mainQueue, peek(&mainQueue)); */
    /* divideQueue(&mainQueue, peek(&mainQueue)); */

    /* enqueue(&mainQueue, expoQueueLeftToRight(&mainQueue, peek(&mainQueue), 0.0)); */

    printQueue(&mainQueue);

    return 0;
}
