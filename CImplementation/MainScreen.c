#include<stdbool.h>
#include<stdio.h>
#include<math.h>
#include "MathHandler.h"

void acceptInput(Queue *q){
    double userInput = NAN;
    printf("Input: ");
    scanf("%lf", &userInput);
    printf("\n");

    enqueue(q, userInput);
}

int main() {
    Queue mainQueue;
    initializeQueue(&mainQueue);

    while(1) {
        printQueue(&mainQueue);
        acceptInput(&mainQueue);
    }

    /* enqueue(&mainQueue, addQueue(&mainQueue, peek(&mainQueue))); */
    /* enqueue(&mainQueue, subtractQueue(&mainQueue, peek(&mainQueue))); */
    /* enqueue(&mainQueue, multiplyQueue(&mainQueue, peek(&mainQueue))); */
    /* enqueue(&mainQueue, divideQueue(&mainQueue, peek(&mainQueue))); */
    /* enqueue(&mainQueue, expoQueueRightToLeft(&mainQueue)); */
    /* enqueue(&mainQueue, logQueue(&mainQueue, peek(&mainQueue))); */

    return 0;
}
