import unittest

from src.tools.lotto.euromillions import euromillions_result_cleaner


class MyTestCase(unittest.TestCase):

    def test_euromillions_result_cleaner(self):
        input = """     A
        08 11 19 23 31 
        02 08 
     B
        01 03 08 31 50 
        05 08 """

        output = """;08;11;19;23;31;02;08;0;
;01;03;08;31;50;05;08;0;"""
        result = euromillions_result_cleaner.clean_result(input)

        self.assertEqual(output, result)


if __name__ == '__main__':
    unittest.main()
