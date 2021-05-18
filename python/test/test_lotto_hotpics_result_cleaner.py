import unittest

from src.tools.lotto.hotpics import lotto_hotpics_result_cleaner


class MyTestCase(unittest.TestCase):
    def test_lotto_result_cleaner(self):
        input_data = """     A (Pick 2) -
        11 39 

    B (Pick 1) -
        11 

    C (Pick 1) -
        39 """

        output = """;0;(2);11;39;
;0;(1);11;
;0;(1);39;"""
        result = lotto_hotpics_result_cleaner.clean_result(input_data)

        self.assertEqual(output, result)


if __name__ == '__main__':
    unittest.main()
