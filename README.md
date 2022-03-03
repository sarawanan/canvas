#Canvas drawing (command line program)
####To Run the program:

```
java -jar canvas.jar
```
- Canvas

```
Command: C w h --Creates a new canvas of width w and height h.

Enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
```
- Line
```
Command: L x1 y1 x2 y2 -- Create a new line from (x1,y1) to (x2,y2). Currently only
horizontal or vertical lines are supported. Horizontal and vertical lines
will be drawn using the 'x' character

Enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

Enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------
```
- Rectangle
```
Command: R x1 y1 x2 y2  --Create a new rectangle, whose upper left corner is (x1,y1) and
lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
using the 'x' character.

Enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------
```
- Fill
```
Command: B x y c  --Fill the entire area connected to (x,y) with "colour" c. The
behavior of this is the same as that of the "bucket fill" tool in paint
programs.

Enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------
```
- Quit
```
Command: Q  -- Quit the program.

Enter command: Q
```
