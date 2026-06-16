/*
    Author: Brandon Weathers
    Date last modified: 6/16/2026
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
    if (isFull(q)) {
        printf("Queue is full\n");
        return;
    }
    q->items[q->rear] = value;
    q->rear++;
}

void dequeue(Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return;
    }
    q->front++;
}

double peek(Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return NAN; // Return some default value or handle
                   // error differently
    }
    return q->items[q->front + 1];
}

void printQueue(Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return;
    }

    printf("┌─────────────────┐\n");
    printf("│  Queue (master) │\n");
    printf("├─────────────────┤\n");

    for (int i = q->front + 1; i < q->rear; i++) {
        printf("│%-17.2f│\n", q->items[i]);
    }
}
// End of data structures

double addQueue(Queue *q, double result) {
    dequeue(q);

    if(isEmpty(q)) {
        return result;
    }

    return addQueue(q, result + peek(q));
}

double subtractQueue(Queue *q, double result) {
    dequeue(q);

    if(isEmpty(q)) {
        return result;
    }

    return subtractQueue(q, result - peek(q));
}

double multiplyQueue(Queue *q, double result) {
    dequeue(q);

    if(isEmpty(q)) {
        return result;
    }

    return multiplyQueue(q, result * peek(q));
}

double divideQueue(Queue *q, double result) {
    dequeue(q);

    if(isEmpty(q)) {
        return result;
    }

    return divideQueue(q, result / peek(q));
}

double expoQueueRightToLeft(Queue *q) {
    double base = peek(q);
    dequeue(q);
    if(base == 1.0) {
        return 1;
    }else if(base == 0.0) {
        return NAN;
    }

    double expo = peek(q);
    dequeue(q);

    while(!isEmpty(q)) {
        expo *= peek(q);
        dequeue(q);
    }

    return powf(base, expo);
}

double logQueue(Queue *q, double result) {
    dequeue(q);

    if(isEmpty(q)) {
        return result;
    }

    return logQueue(q, log(peek(q)) / log(result));
}

int main() {
    Queue mainQueue;
    initializeQueue(&mainQueue);

    enqueue(&mainQueue, 2.0);
    enqueue(&mainQueue, 3.0);
    enqueue(&mainQueue, 4.0);
    enqueue(&mainQueue, 5.0);
    enqueue(&mainQueue, 6.0);
    enqueue(&mainQueue, 7.0);
    enqueue(&mainQueue, 8.0);
    enqueue(&mainQueue, 9.0);
    enqueue(&mainQueue, 10.0);

    printQueue(&mainQueue);

    enqueue(&mainQueue, addQueue(&mainQueue, peek(&mainQueue)));
    /* enqueue(&mainQueue, subtractQueue(&mainQueue, peek(&mainQueue))); */
    /* enqueue(&mainQueue, multiplyQueue(&mainQueue, peek(&mainQueue))); */
    /* enqueue(&mainQueue, divideQueue(&mainQueue, peek(&mainQueue))); */
    /* enqueue(&mainQueue, expoQueueRightToLeft(&mainQueue)); */
    /* enqueue(&mainQueue, logQueue(&mainQueue, peek(&mainQueue))); */

    printf("\n");
    printQueue(&mainQueue);

    return 0;
}
