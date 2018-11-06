import time

print('Press ENTER to begin.\n\t Afterwards, press ENTER to "click" the stopwatch.\n\tPress CTRL+c to quit')

input()
print('Start .. ')
lastTime = startTime
lap_number = 1
carryOn = True

try:
    while carryOn:
        s = input()
        if s == 'X':
            carryOn = False
        lapTime = round(time.time() - lastTime, 2)
        totalTime = round(time.time() - startTime, 2)
        print('Lap #%s: %s (%s)' % (lap_number, totalTime, lapTime), end='')
        lap_number += 1
        lastTime = time.time()
except KeyboardInterrupt:
    print("Game\n\tOver")
