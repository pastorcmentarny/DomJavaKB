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


    def test_select_random_number_from_first_two_most_played_game_acceptance_test(self):
        # given
        dict_key_as_number_game_played= {
            8: [41],
            7: [4, 46],
            6: [9, 11, 27],
            5: [2, 24, 45],
            4: [8, 22, 34, 43],
            3: [35, 36],
            2: [26, 47],
            0: [48]
        }
        expected_valid_numbers = [9, 11, 27,2, 24, 45,8, 22, 34, 43]

        # when
        result = lotto_utils.select_random_number_from_two_highest_len_of_played_game(dict_key_as_number_game_played)

        # then
        self.assertEqual(len(result),2)
        self.assertIn(result[0],expected_valid_numbers)
        self.assertIn(result[1],expected_valid_numbers)


if __name__ == '__main__':
    unittest.main()
