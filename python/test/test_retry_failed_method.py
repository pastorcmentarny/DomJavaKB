import unittest

from src.kb.exceptions import WhoopsException
from src.kb.retry_failed_method import retry_example


class RetryTestCase(unittest.TestCase):
    def test_retry(self):
        # expect
        self.assertRaises(WhoopsException, retry_example)
