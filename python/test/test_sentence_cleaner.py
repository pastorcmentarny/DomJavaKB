import unittest
from src.tools.text import sentence_cleaner

class SentenceClenaerTestCase(unittest.TestCase):
    def test_clean_sentence_acceptance_text(self):
        # given
        example_with_all_problems = "dominik likes  beer very  very  very much !!!!"
        expected_result = "Dominik likes beer very much!"

        # when
        result = sentence_cleaner.clean_sentence(example_with_all_problems)

        # debug
        print(result)

        # then
        self.assertEqual(expected_result, result)