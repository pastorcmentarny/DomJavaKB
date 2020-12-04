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
        self.assertEqual(expected_result, result)

    def test_select_random_number_from_first_two_most_played_game_acceptance_test(self):
        # given
        dict_key_as_number_game_played = {
            8: [41],
            7: [4, 46],
            6: [9, 11, 27],
            5: [2, 24, 45],
            4: [8, 22, 34, 43],
            3: [35, 36],
            2: [26, 47],
            0: [48]
        }
        expected_valid_numbers_for_first = [8, 22, 34, 43]
        expected_valid_numbers_for_second = [9, 11, 27, 2, 24, 45]

        # when
        result = lotto_utils.select_random_number_from_two_highest_len_of_played_game(dict_key_as_number_game_played)

        # then
        self.assertEqual(len(result), 2)
        self.assertIn(result[0], expected_valid_numbers_for_first)
        self.assertIn(result[1], expected_valid_numbers_for_second)

        # debug
        print(result)

    def test_select_random_number_from_first_two_most_played_game_should_pick_up_one_number_from_four_and_one_from_three(
            self):
        # given
        dict_key_as_number_game_played = {
            8: [41],
            7: [4, 46],
            5: [2, 24, 45],
            4: [8, 22, 34, 43],
            3: [35, 36],
            2: [26, 47],
            0: [48]
        }
        expected_valid_numbers_for_first = [8, 22, 34, 43]
        expected_valid_numbers_for_second = [2, 24, 45]

        # when
        result = lotto_utils.select_random_number_from_two_highest_len_of_played_game(dict_key_as_number_game_played)

        # then
        self.assertEqual(len(result), 2)
        self.assertIn(result[0], expected_valid_numbers_for_first)
        self.assertIn(result[1], expected_valid_numbers_for_second)

        # debug
        print(result)

    def test_select_random_number_from_first_two_most_played_game_should_pick_up_two_number_from_four(
            self):
        # given
        dict_key_as_number_game_played = {
            8: [41],
            7: [4, 46],
            5: [2, 24, 45],
            4: [8, 22, 34, 43],
            3: [11, 27, 35, 36],
            2: [26, 47],
            0: [48]
        }
        expected_valid_numbers_for_first = [8, 22, 34, 43, 11, 27, 35, 36]

        # when
        result = lotto_utils.select_random_number_from_two_highest_len_of_played_game(dict_key_as_number_game_played)

        # then
        self.assertEqual(len(result), 2)
        self.assertIn(result[0], expected_valid_numbers_for_first)
        self.assertIn(result[1], expected_valid_numbers_for_first)

        # debug
        print(result)

    def test_count_pairs_acceptance_test(self):
        # given
        pairs = [(4, 12), (8, 9), (8, 12), (5, 7), (2, 6), (1, 10), (5, 12), (1, 2), (6, 7), (3, 9), (3, 12), (3, 12),
                 (3, 4), (3, 6), (1, 10), (5, 8), (9, 11), (3, 9), (11, 12), (1, 7), (1, 6), (1, 7), (6, 8), (9, 12),
                 (9, 12), (4, 7), (8, 11), (7, 9), (8, 10), (3, 5), (5, 12), (4, 12), (3, 9), (6, 11), (5, 8), (2, 5),
                 (2, 7), (4, 12), (2, 4), (7, 9), (9, 10), (2, 7), (8, 10), (3, 6), (2, 10), (5, 11), (1, 8), (3, 11),
                 (2, 10), (4, 8), (2, 8)]
        expected_result = {(1, 2): 1,
                           (1, 6): 1,
                           (1, 7): 2,
                           (1, 8): 1,
                           (1, 10): 2,
                           (2, 4): 1,
                           (2, 5): 1,
                           (2, 6): 1,
                           (2, 7): 2,
                           (2, 8): 1,
                           (2, 10): 2,
                           (3, 4): 1,
                           (3, 5): 1,
                           (3, 6): 2,
                           (3, 9): 3,
                           (3, 11): 1,
                           (3, 12): 2,
                           (4, 7): 1,
                           (4, 8): 1,
                           (4, 12): 3,
                           (5, 7): 1,
                           (5, 8): 2,
                           (5, 11): 1,
                           (5, 12): 2,
                           (6, 7): 1,
                           (6, 8): 1,
                           (6, 11): 1,
                           (7, 9): 2,
                           (8, 9): 1,
                           (8, 10): 2,
                           (8, 11): 1,
                           (8, 12): 1,
                           (9, 10): 1,
                           (9, 11): 1,
                           (9, 12): 2,
                           (11, 12): 1}
        # when
        result = lotto_utils.count_pairs(pairs)
        counter = 0
        for item in result:
            counter += int(result[item])
        print(f'size{counter}')
        # then
        self.assertEquals(result, expected_result)
        self.assertEquals(len(pairs), counter)
