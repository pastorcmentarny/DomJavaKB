import unittest

import sys

sys.path.insert(0, '../../../../src/tools/chinese/today')
import engine


class TestEngine(unittest.TestCase):

    def test_get_year_in_chinese(self):
        self.assertEqual(engine.get_year_in_chinese(), '2019')

    def test_get_chinese_number_for_0(self):
        self.assertEqual(engine.get_distance_from_steps(0), '0')


if __name__ == '__main__':
    unittest.main()
