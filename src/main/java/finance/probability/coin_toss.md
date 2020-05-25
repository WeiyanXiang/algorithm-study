-You toss a fair coin 400 times. 
What's the probability that you get at least 220 heads? 
Round your answer to the nearest per cent.

Solution:
https://www.glassdoor.fr/Entretien/Suppose-you-toss-a-fair-coin-400-times-What-is-the-probability-that-you-get-at-least-220-heads-Round-your-answer-to-the-QTN_224604.htm

This is a central limit theorem question. The trick is to view each toss as a random variable that returns 1 if a head
 is tossed and 0 if a tail is tossed. Then each such random variable has expected value 1/2 and variance 1/4. So your Z-variable (for using the central limit theorem) will be:

(220-200)/(sqrt(400*(1/4))) = 20/10 = 2

So we've reduced the question to asking what's the probability that Z takes a value bigger than 2. Recall that on the 
standard normal, the probability that z takes values between -2 and 2 is about 95%, so the probability that it takes
 values less than 2 is about 97.5% (it's actually more like 97.7% but just estimating). So the probability that we are 
 bigger than 2 is a little less than 2.5%, which after rounding to the nearest percent gives us 2%.
