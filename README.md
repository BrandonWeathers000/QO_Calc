# QO_Calc
This is a calculator based on the queue data structure.

This application is currently under heavy development. It it not currently fit for use.
Updates will be posted about when version 1.0 will be released. Thank you for your patience.

**Please refer to the pdf documentation about use of the calculator.**

## Dependencies
1. JavaFX
2. gcc

## Important Info
There is a TUI and GUI version of the same app.
They currently DON'T have the same features. Although, I plan to keep them as similar as possible.

The GUI version (written in Java) slower to compile and startup, but it has every features that is currently available.

On the other hand, TUI version (written in C) is faster, but lacks some advanced features. It is also important to note that the terminal version does **not** at all use non-standard libraries, like the Java version does with JavaFX.

## How to Run (Commander Scripts)
1. To run the Java version, enter jcom -r
2. To compile the Java version, enter jcom -c
3. To compile and run the Java version, enter jcom -cr

1. To run the C version, enter ccom -r
2. To compile the C version, enter ccom -c
3. To compile and run the C version, enter ccom -cr

## Development Roadmap
1. Migration to the BigDecimal class (Java)
2. Additional functions
    1. Statistics
        1. Factorials
        2. Combination
        3. permutations
    2. Trig functions
        1. Sine
        2. Cosine
        3. Tangent
        4. Arcsine
        5. Arccosine
        6. Arctangent
        7. Hyperbolic sine
        8. Hyperbolic cosine
        9. Hyperbolic tangent
    3. Special exponentiation (e^x, 10^x, etc)
4. Constants (pi, e, and phi)
5. Clipboard interaction
    1. Pasting lists into queues
3. Support for additional queues
