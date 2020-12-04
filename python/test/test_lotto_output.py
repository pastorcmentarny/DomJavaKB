import sys

import io
import unittest
import unittest.mock

from src.tools.lotto.utils import output


class MyTestCase(unittest.TestCase):

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_debug_mode_warning_shows_for_debug_is_true(self, mock_stdout):
        # given
        expected_result = """------
WARNING!
------

You are running this with debug mode so it will produce lots of extra logs!
Disable for normal usage
------"""
        # when
        output.debug_mode_warning(True)

        # then
        self.assertEqual(expected_result, mock_stdout.getvalue().strip())


    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_debug_mode_warning_shows_for_debug_is_false(self, mock_stdout):
        # given
        expected_result = """"""
        # when
        output.debug_mode_warning(False)

        # then
        self.assertEqual(expected_result, mock_stdout.getvalue().strip())
