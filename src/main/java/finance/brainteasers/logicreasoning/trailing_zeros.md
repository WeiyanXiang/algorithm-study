How many trailing zeros are there in 100! (factorial of 100) ?

i.e. 1*2*3* ... * 100

Idea:
start from 1:
1 = 1
1*2=2
1*2*3=6
1*2*3*4=24
1*2*3*4*5=120
*6=720
*7=5040

so it looks 5 and 10 will resulting trailing 0s, as there are 10 times 5 and 11 times 10 (100 is 2 zeros)
so there are 21 zeros.

verdict: not 100% correct!
11 zeors + 10 times 5 + additional 5s (25,50,75,100)


Solution:
each pair of 2 and 5 will give a trailing zero.
if we perform prime number decomposition on all numbers in 100!, the frequency of 2 will far out (half of 100 numbers)
so we look at number of 5, there are 20 nums that divisible by 5: i.e. 5, 10, 15, 20 ... 100
among 20 nums, 4 are 5^2: 25, 50, 75 and 100, 

so 24 zeros
