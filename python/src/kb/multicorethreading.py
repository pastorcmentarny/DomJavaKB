import multiprocessing
import random
import time


def hard_worker(name: str) -> None:
    print(f'Worker {name} started.')
    work_time = random.choice(range(1, 8))
    time.sleep(work_time)
    print(f'{name} took {work_time} seconds to complete.')


if __name__ == '__main__':
    processes = []
    for i in range(6):
        process = multiprocessing.Process(target=hard_worker, args=(f'server_{i}',))
        processes.append(process)
        process.start()

    for proc in processes:
        proc.join()



