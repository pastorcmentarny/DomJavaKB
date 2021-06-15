import unittest

from src.kb import randoms


class PythonKbRandomsAcceptanceTests(unittest.TestCase):
    def test_get_message_return_different_message_after_many_calls(self):
        # given results
        results = []
        # when
        for _ in range(0, 100):
            results.append(randoms.get_random_message())

        # verify that were 100 messages
        self.assertEqual(len(results), 100)

        results = set(results)

        # verify that was less than 100 unique messages
        self.assertLess(len(results), 100)

        # debug
        print(results)
        print(f'size of result in set is:{len(results)}')

        # then
        self.assertGreater(len(results), 1)


if __name__ == '__main__':
    unittest.main()
