import unittest

from src.tools.lotto.thunderball import number_generator

WITHOUT_THUNDERBALL = False


class MyTestCase(unittest.TestCase):
    def test_thunderball_generate_numbers(self):
        print(number_generator.get_result_description(number_generator.get_draw_result(5)))
        print(number_generator.get_result_description(number_generator.get_draw_result(5, WITHOUT_THUNDERBALL)))
        print(number_generator.get_result_description(number_generator.get_draw_result(4)))
        print(number_generator.get_result_description(number_generator.get_draw_result(4, WITHOUT_THUNDERBALL)))
        print(number_generator.get_result_description(number_generator.get_draw_result(3)))
        print(number_generator.get_result_description(number_generator.get_draw_result(3, WITHOUT_THUNDERBALL)))
        print(number_generator.get_result_description(number_generator.get_draw_result(2)))
        print(number_generator.get_result_description(number_generator.get_draw_result(1)))
        print(number_generator.get_result_description(number_generator.get_draw_result(0)))
        print(number_generator.get_result_description(number_generator.get_draw_result(0, WITHOUT_THUNDERBALL)))
        self.assertEqual(True, False)

