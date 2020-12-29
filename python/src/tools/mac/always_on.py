import time

import pyautogui as pyautogui

"""
A tool to press button to prevent mac go to sleep.
(I use during day time only and I am too lazy to change settings)
It requires pyautogui (pip install pyautogui)
"""

if __name__ == '__main__':
    counter = 1
    while True:
        print(counter)
        pyautogui.press('f16')  # swap to different key if causes issue
        time.sleep(15)
        counter += 1
