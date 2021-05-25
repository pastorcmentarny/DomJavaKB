import unittest

from src.tools.chinese.today import activities


class MyTestCase(unittest.TestCase):
    def test_add_breakfast_return_something(self):
        # given
        diary = {'diet': False}

        # when
        result = activities.add_breakfast(diary)

        # debug
        print(result)

        # then
        self.assertIsNotNone(result)
        self.assertGreaterEqual(len(result), 2)

    def test_add_breakfast_on_diet_return_coffee_message(self):
        # given
        diary = {'diet': True}

        # when
        result = activities.add_breakfast(diary)

        # debug
        print(result)

        # then
        self.assertEqual(result, '我没有吃了早饭但是我喝了咖啡。\n')
        self.assertGreaterEqual(len(result), 15)


if __name__ == '__main__':
    unittest.main()
