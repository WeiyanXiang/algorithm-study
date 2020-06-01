A sultan has captured 50 wise men.
he has a glass standing bottom down. every min he randomly calls 
1 of wise men to choose: upside down, bottom down or do nothing.
wise men are called randomly, possibly for an infinite number of times.
when someone correctly states that all wise men have already been called to the sultan at least once, everyone goes free.
Otherwise all put to death.
wise men are allowed to communicate only once before they get imprisoned into separate rooms (1 per room).
Design a strategy that lets wise men go free.


Idea:
glass can be used to pass msg among 50 ppl.
initially:
u 
p1: n
p2: u
p3: n
...
p50: 

if infinite number of callings, then normal distribution would be:
1/50 each person, 
no idea..

Solution:
1 spokesman unique + 49 others are symmetric
so for the 49, they flip glass upside down the first time that he sees the glass bottom down. Does nothing if already 
upside down or already flipped once. for spokesman, he flip the glass bottom down if its upside down and he should do 
nothing if the glass already bottom down. After he does the 49th flip, which means all the other 49 men have been called.
(because the 49 only flip only once if applicable) he can declare that all wise men have been called.
 
