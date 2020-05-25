5 pirates looted 100 coins. they agree to divide the loot:
most senior will propose a distribution and all inc himself will vote, 
    if > 50% (3 pirates in this case) -> accept
    if not, most senior will fed to shark and process starts over with next most senior pirate etc
the process repeated until a plan is approved. Assume all pirates are rational: they want to stay alive first and to get
as much gold as possible second. also they want to have fewer pirates on the boat if given a choice between otehrwise equal 
outcomes. 

How will the gold conis be divided in the end?

100

start: 
assume pirate 1 - 5, more senior to least senior
pirate 1 -> 100 
add pirate 2 -> 2 gets 100 as he get himself vote for 50%
add pirate 3 -> 3 gives 1 one coin so 3->99 and 1->1
add pirate 4 -> 4 gives 2 one coin so 4-> 99 and 2->1
add pirate 5 -> 5 gives 3 and 1 each one coin so 5->98, 3->1, 1->1
otherwise the pirate who gets one coin wont get anything.

Review:
Above is wrong. I should build up the case from 1 and increment to 5 pirates, in order to find the pattern.

Solution:
![alt text](screwy_pirates_1.PNG "Solution")

So now to extract:
p1 - p2: junior to senior

2p:
p1 - 0
p2 - 100 

3p: give p1 1 coin otherwise p1 got nothing if p3 gets killed and p2 gets to his turn.
p1 - 1
p2 - 0
p3 - 99

4p:
p1 - 0
p2 - 1
p3 - 0
p4 - 99

5p: this is the [final answer]
p1 - 1 (otherwise got to 4p p1 got nothing, so he will vote up)
p2 - 0
p3 - 1
p4 - 0
p5 - 98

