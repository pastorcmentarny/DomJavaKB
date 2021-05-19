import unittest

import pyperclip

from src.tools.chinese.today import chinese_diary_generator


class TodayInChineseTests(unittest.TestCase):

    def test_if_tool_works_with_current_config(self):
        for index in range(1, 10):
            # given

            print(f'Re-run chinese diary generator no.{index}')
            # when
            chinese_diary_generator.main()
            result = pyperclip.paste()

            # debug
            print(result)

            # then no crash happen
            self.assertIsNotNone(pyperclip.paste())
