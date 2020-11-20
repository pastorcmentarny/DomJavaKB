import unittest

from src.tools.lotto.utils import lotto_utils


class MyTestCase(unittest.TestCase):
    def test_sort_with_key_as_number_game_played_acceptance_list(self):
        # given
        number_count_in_draws = {
            41: 8,
            4: 7,
            46: 7,
            9: 6,
            11: 6,
            14: 6,
            27: 6,
            2: 5,
            24: 5,
            39: 5,
            45: 5,
            8: 4,
            22: 4,
            34: 4,
            43: 4,
            49: 4,
            35: 3,
            36: 3,
            26: 2,
            47: 2,
            48: 0
        }
        expected_result = {
            8: [41],
            7: [4, 46],
            6: [9, 11, 14, 27],
            5: [2, 24, 39, 45],
            4: [8, 22, 34, 43, 49],
            3: [35, 36],
            2: [26, 47],
            0: [48]
        }

        # when
        result = lotto_utils.sort_with_key_as_number_game_played(number_count_in_draws)

        # then
        self.assertEqual(expected_result,result)


if __name__ == '__main__':
    unittest.main()
