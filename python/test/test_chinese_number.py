import unittest

from tools.chinese.today import chinese_number


class TestChineseNumber(unittest.TestCase):

    def test_get_chinese_number_for_0(self):
        self.assertEqual(chinese_number.get_chinese_number_for(0), '零')

    def test_get_chinese_number_for_1(self):
        self.assertEqual(chinese_number.get_chinese_number_for(1), '一')

    def test_get_chinese_number_for_9(self):
        self.assertEqual(chinese_number.get_chinese_number_for(9), '九')

    def test_get_chinese_number_for_10(self):
        self.assertEqual(chinese_number.get_chinese_number_for(10), '十')

    def test_get_chinese_number_for_11(self):
        self.assertEqual(chinese_number.get_chinese_number_for(11), '十一')

    def test_get_chinese_number_for_99(self):
        self.assertEqual(chinese_number.get_chinese_number_for(99), '九十九')

    def test_get_chinese_number_for_100(self):
        self.assertEqual(chinese_number.get_chinese_number_for(100), '一百')

    def test_get_chinese_number_for_101(self):
        self.assertEqual(chinese_number.get_chinese_number_for(101), '一百零一')

    def test_get_chinese_number_for_111(self):
        self.assertEqual(chinese_number.get_chinese_number_for(111), '一百十一')

    def test_get_chinese_number_for_123(self):
        self.assertEqual(chinese_number.get_chinese_number_for(123), '一百二十三')

    def test_get_chinese_number_for_999(self):
        self.assertEqual(chinese_number.get_chinese_number_for(999), '九百九十九')

    def test_get_chinese_number_for_1000(self):
        self.assertEqual(chinese_number.get_chinese_number_for(1000), '一千')

    def test_get_chinese_number_for_1001(self):
        self.assertEqual(chinese_number.get_chinese_number_for(1001), '一千一')

    def test_get_chinese_number_for_1011(self):
        self.assertEqual(chinese_number.get_chinese_number_for(1011), '一千十一')

    def test_get_chinese_number_for_1111(self):
        self.assertEqual(chinese_number.get_chinese_number_for(1111), '一千一百十一')

    def test_get_chinese_number_for_9999(self):
        self.assertEqual(chinese_number.get_chinese_number_for(9999), '九千九百九十九')

    def test_get_chinese_number_for_10000(self):
        self.assertEqual(chinese_number.get_chinese_number_for(10000), '10000 number is not supported')

    def test_should_return_zero_in_chinese(self):
        self.assertEqual(chinese_number.get_chinese_number(0), '零')

    def test_should_return_invalid_number_passed_in_chinese(self):
        self.assertEqual(chinese_number.get_chinese_number(24412), 'Invalid number passed!')


if __name__ == '__main__':
    unittest.main()
