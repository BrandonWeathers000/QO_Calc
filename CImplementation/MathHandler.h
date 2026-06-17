#ifndef MATHHANDLER_H

#define MATHHANDLER_H
#define MAX_SIZE 1000

typedef struct {
    double items[MAX_SIZE];
    int front;
    int rear;
} Queue;

// Start of data structures 
void initializeQueue(Queue *q);
bool isEmpty(Queue *q);
bool isFull(Queue *q);
void enqueue(Queue *q, double value);
void dequeue(Queue *q);
double peek(Queue *q);
void printQueue(Queue *q);
// End of data structures

double addQueue(Queue *q, double result);
double subtractQueue(Queue *q, double result);
double multiplyQueue(Queue *q, double result);
double divideQueue(Queue *q, double result);
double expoQueueRightToLeft(Queue *q);
double logQueue(Queue *q, double result);

#endif
