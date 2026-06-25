#include <ctype.h>
#include <string.h>
#include <math.h>
#include <regex.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include "MathHandler.h"

int main() {
    Queue mainQueue;
    initializeQueue(&mainQueue);

    while(1) {
        printQueue(&mainQueue);

        char input[100];
        char *endptr;
        double value;

        fgets(input, sizeof(input), stdin);

        value = strtod(input, &endptr);

        if(*endptr == '+') {
            enqueue(&mainQueue, addQueue(&mainQueue, peek(&mainQueue)));
        } else if(*endptr == '-') {
            enqueue(&mainQueue, subtractQueue(&mainQueue, peek(&mainQueue)));
        } else if(*endptr == '*') {
            enqueue(&mainQueue, multiplyQueue(&mainQueue, peek(&mainQueue)));
        } else if(*endptr == '/') {
            enqueue(&mainQueue, divideQueue(&mainQueue, peek(&mainQueue)));
        } else if (*endptr == '\n' || *endptr == '\0') {
            enqueue(&mainQueue, value);
        } else {
            printf("Please enter valid input\n");
        }

    }

    return 0;
}
