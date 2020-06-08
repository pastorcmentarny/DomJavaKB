import unittest

from utils import collection_utils


class CollectionUtilsCaseTest(unittest.TestCase):
    def test_split_string_to_list_of_single_digit_acceptance_test(self):
        # given
        digit_as_string = '0777770'
        expected_result = [0, 7, 7, 7, 7, 7, 0]

        # when
        result = collection_utils.split_string_to_list_of_single_digit(digit_as_string)

        # then
        self.assertEqual(result, expected_result)

    def test_convert_list_of_string_to_list_of_integer(self):
        # given
        example = ['1', '2', '3', '3', '1', 'lol']
        expected_result = [1, 2, 3, 3, 1]

        # when
        result = collection_utils.convert_list_of_string_to_list_of_integer(example)

        # then
        self.assertEqual(result, expected_result)
