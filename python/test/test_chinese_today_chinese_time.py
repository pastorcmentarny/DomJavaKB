import unittest

from tools.chinese.today import chinese_time


class ChineseTimeTests(unittest.TestCase):
    def test_get_time_in_chinese_for_11_59(self):
        # given
        expected_result = '十一点五十九'

        # when
        result = chinese_time.get_time_in_chinese_for(11, 59)

        # then
        self.assertEqual(expected_result, result)

    def test_get_time_in_chinese_for_quarter_past(self):
        # given
        expected_result = '一点一刻'

        # when
        result = chinese_time.get_time_in_chinese_for(1, 15)

        # then
        self.assertEqual(expected_result, result)

    def test_get_time_in_chinese_for_half_past(self):
        # given
        expected_result = '二点半'

        # when
        result = chinese_time.get_time_in_chinese_for(2, 30)

        # then
        self.assertEqual(expected_result, result)

    def test_get_time_in_chinese_for_quarter_to(self):
        # given
        expected_result = '三点三刻'

        # when
        result = chinese_time.get_time_in_chinese_for(3, 45)

        # then
        self.assertEqual(expected_result, result)
