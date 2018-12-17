import random

messages = [
    'Minor delays due to an earlier signal failure .',
    'Reduced service due to strike action.',
    'Minor delays while we fix a signal failure in the Wembley Park area.',
    'Severe delays due to a signal failure at Baker Street.',
    'NO SERVICE between Rickmansworth - Chesham ...while we fix a signal failure..',
    'Service suspended due icy weather.']

print(messages[random.randint(0, len(messages) - 1)])
