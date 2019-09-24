Backend Engineering Assignment
A pawn can move on 10x10 chequerboard horizontally, vertically and diagonally by these rules:
1) 3 tiles moving North (N), West (W), South (S) and East (E)
2) 2 tiles moving NE, SE, SW and NW
3) Moves are only allowed if the ending tile exists on the board
4) Starting from initial position, the pawn can visit each cell only once
On the following picture, you can see the initial position in black, the legal next positions in dark grey
and the illegal ones in red.

Solution using Warnsdorff's Algorithm
The problem is solved using H C Warnsdorff's technique which does the following:

1. Start from any tile and mark it as visited.
2. To decide next tile in path, look at all possible unmarked tiles based on moving rules.
3. Rank each possibility by the number of next moves from that tile.
4. Move to any tile with the lowest rank.
5. Add chosen tile to knight's tour path (i.e marked) and repeat the process from last chosen tile.

Compile
sbt compile

Run Solution
sbt run

Run Test cases
sbt test