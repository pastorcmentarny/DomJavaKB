import unittest

from src.kb.collections_global_functions import run_example_filter, run_example_map


class MyTestCase(unittest.TestCase):
    def test_filter_acceptance_test(self):
        # given
        expected_result = ['a very long string']

        # when
        result = run_example_filter()

        # then
        self.assertEqual(result, expected_result)

    def test_map_acceptance_test(self):
        # given
        expected_result = ['tin', 'a v', 'med']

        # when
        result = run_example_map()

        # then
        self.assertEqual(result, expected_result)


if __name__ == '__main__':
    unittest.main()
