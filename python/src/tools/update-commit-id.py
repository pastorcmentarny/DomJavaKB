import subprocess


def set_commit_id():
    p = subprocess.Popen("git rev-parse --short HEAD > ../../commit-id", stdout=subprocess.PIPE, shell=True)
    result, _ = p.communicate()
    result = result.decode("utf-8")
    print(result)


if __name__ == '__main__':
    set_commit_id()
