import unittest

from tools.chinese.today import file_loader


class MyTestCase(unittest.TestCase):
    def test_if_config_is_loaded(self):
        # when
        cfg = file_loader.config()

        # then
        self.assertEqual(len(cfg.keys()), 19)
