import sys

import io
import unittest
import unittest.mock

from src.utils import ui_utils


class MyTestCase(unittest.TestCase):

    # tag-test-print
    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_output(self, mock_stdout):
        # given
        text = 'test'
        expected_result = '------test------'

        # when
        ui_utils.title(text)

        # then
        self.assertEqual(expected_result, mock_stdout.getvalue().strip())
