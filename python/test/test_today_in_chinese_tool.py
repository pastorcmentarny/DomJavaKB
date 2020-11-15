import unittest

import pyperclip

from src.tools.chinese.today import application_runner


class TodayInChineseTests(unittest.TestCase):
    def test_if_tool_works_with_current_config(self):
        # when
        application_runner.main()
        result = pyperclip.paste()

        # debug
        print(result)

        # then no crash happen
        self.assertIsNotNone(pyperclip.paste())
