import unittest

from src.tools.lotto.tools import swap_column_in_lotto_draws


class MyTestCase(unittest.TestCase):
    def test_check_if_default_settings_are_set(self):
        print('If you fail this test set default value in swap_column_in_lotto_draws file')
        self.assertNotEqual(swap_column_in_lotto_draws.column_from,-1)
        self.assertNotEqual(swap_column_in_lotto_draws.column_from,-1)
        self.assertNotEqual(swap_column_in_lotto_draws.column_from,-1)




if __name__ == '__main__':
    unittest.main()
