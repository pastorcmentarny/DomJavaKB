from unittest import TestCase

from src.tools import print_all_builtins


class Test(TestCase):
    def test_get_python_builtins_count(self):
        # given
        expected_result = 73

        # when
        result = print_all_builtins.get_builtins_count_list()

        # debug
        print(result)

        # then
        self.assertEqual(expected_result, result)

    def test_get_python_builtins_list(self):
        # given
        expect_result = ['abs', 'all', 'any', 'ascii', 'bin', 'bool', 'breakpoint', 'bytearray', 'bytes', 'callable',
                         'chr', 'classmethod', 'compile', 'complex', 'copyright', 'credits', 'delattr', 'dict', 'dir',
                         'divmod', 'enumerate', 'eval', 'exec', 'exit', 'filter', 'float', 'format', 'frozenset',
                         'getattr', 'globals', 'hasattr', 'hash', 'help', 'hex', 'id', 'input', 'int', 'isinstance',
                         'issubclass', 'iter', 'len', 'license', 'list', 'locals', 'map', 'max', 'memoryview', 'min',
                         'next', 'object', 'oct', 'open', 'ord', 'pow', 'print', 'property', 'quit', 'range', 'repr',
                         'reversed', 'round', 'set', 'setattr', 'slice', 'sorted', 'staticmethod', 'str', 'sum',
                         'super', 'tuple', 'type', 'vars', 'zip']
        # when
        result = print_all_builtins.get_builtins_count_list()

        # debug
        print(result)

        # then
        self.assertEqual(expect_result,result)
