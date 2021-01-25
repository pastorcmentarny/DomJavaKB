import unittest

from src.tools.lotto.thunderball import thunderball_result_cleaner


class MyTestCase(unittest.TestCase):


    def test_lotto_result_cleaner(self):
        input = """     A
        06 14 16 22 29 
        05 

    B
        02 11 12 19 23 
        14 

    C
        05 09 13 27 32 
        03 
     A
        06 07 12 14 31 
        07 

    B
        06 11 14 16 39 
        01 """

        output = """;06;14;16;22;29;05;0;
;02;11;12;19;23;14;0;
;05;09;13;27;32;03;0;
;06;07;12;14;31;07;0;
;06;11;14;16;39;01;0;"""
        result = thunderball_result_cleaner.clean_result(input)

        self.assertEqual(output, result)

    def test_lotto_result_cleaner_2(self):
        input_2 = """     A
        06 07 12 14 31
        07

    B
        06 11 14 16 39
        01

    C
        02 05 11 27 31
        03"""

        output = """;06;07;12;14;31;07;0;
;06;11;14;16;39;01;0;
;02;05;11;27;31;03;0;"""
        result = thunderball_result_cleaner.clean_result(input_2)

        self.assertEqual(output, result)


if __name__ == '__main__':
    unittest.main()
