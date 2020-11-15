import unittest
from unittest.mock import Mock

from src.tools.chinese.today import application_utils, sentence


class ChineseTodaySentenceTests(unittest.TestCase):
    def test_add_wear(self):
        # given
        expected_result = '我穿白色Ť恤和灰色跑长裤。\n'

        # when
        result = sentence.add_wear('白色', '灰色', 'Ť恤', '跑长裤')

        # then
        self.assertEqual(expected_result, result)

    def test_steps(self):
        # given
        expected_result = '我走了0步相当于0.0公里左右。\n'

        # when
        result = sentence.steps(0)

        # then
        self.assertEqual(expected_result, result)

    def test_add_weather_sentence_with_one_description(self):
        # given
        expected_result = '伦敦的天气好.这是晴朗。\n今天气温是13°C。\n'
        weather = '13°C'
        application_utils.get_temp_from_internet = Mock(return_value=weather)
        # when
        result = sentence.add_weather_sentence('晴朗', '', '好')

        # then
        self.assertEqual(expected_result, result)

    def test_add_weather_sentence_with_two_descriptions(self):
        # given
        expected_result = '伦敦的天气好.这是晴朗和雨。\n今天气温是13°C。\n'
        weather = '13°C'
        application_utils.get_temp_from_internet = Mock(return_value=weather)
        # when
        result = sentence.add_weather_sentence('晴朗', '雨', '好')

        # then
        self.assertEqual(expected_result, result)
