import unittest

from src.tools.lotto.lotto import lotto_result_cleaner


class MyTestCase(unittest.TestCase):
    def test_lotto_result_cleaner(self):
        input_data = """     A
        06 11 32 35 39 44
     A
        02 08 32 35 41 44
     A
        08 09 11 17 34 43

    B
        20 23 25 38 42 46"""

        output = """;0;06;11;32;35;39;44
;0;02;08;32;35;41;44
;0;08;09;11;17;34;43
;0;20;23;25;38;42;46"""
        result = lotto_result_cleaner.clean_result(input_data)

        self.assertEqual(output, result)


if __name__ == '__main__':
    unittest.main()
