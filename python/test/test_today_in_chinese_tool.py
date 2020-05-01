import unittest

import pyperclip

from tools.chinese.today import application_runner


class TodayInChineseTests(unittest.TestCase):
    def test_something(self):
        # when
        application_runner.main()
        result = pyperclip.paste()

        # debug
        print(result)

        # then no crash happen
        self.assertIsNotNone(pyperclip.paste())
