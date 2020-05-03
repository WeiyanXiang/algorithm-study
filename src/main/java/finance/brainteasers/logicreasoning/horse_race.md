25 horses, each runs at constant speed that's different from others.
Since the track only has 5 lanes, eachr ace can have at most 5 horses.
if you need to find 3 fastest horses, what's minimum number of races needed?

Idea:
number 1 to 25
[5] races to let each run once and pick top 3 of each round
15 left now
[3] races to let each run once and pick top 3 of each round
9 left now
[2] races to let each run once and pick top 3 of each round
6 left now
[1] race to run the 5 of 6, pick top 3 
[1] race to run the 3 + the 1 left, pick top 3

therefore 5+3+2+1+1 = 12 races

to rethink where can improve:
1   2   3   4   5
6   7   8   9   10
11  12  13  14  15
16  17  18  19  20
21  22  23  25  25
run [5] races and 1,6,11,16 and 21 are fastest of each round

run [1] race on these 5 horses and assum top 3 are:
6   11  16 
now it's possible 7 and 8 can be faster or not faster than 11, 12 and 13,
therefore
race [1] race among 7  8   11  12  13 and pick top 2
the top 3 will be 6  and top 2 of above

Total 5+1+1 = 7 races needed

Solution:

