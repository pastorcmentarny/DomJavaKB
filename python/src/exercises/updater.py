import subprocess

rollbacked = False
is_app_up = True
updated = False
current_commit = "99a808c7"


def is_app_down():
    return not is_app_up


def is_not_rolledback():
    return not rollbacked


def get_commit_id_from_github():
    # #js-repo-pjax-container > div.container-lg.clearfix.new-discussion-timeline.experiment-repo-nav.px-3 > div > div.commits-listing.commits-listing-padded.js-navigation-container.js-active-navigation-container > ol:nth-child(2) > li.commit.commits-list-item.js-commits-list-item.table-list-item.js-navigation-item.js-details-container.Details.js-socket-channel.js-updatable-content.navigation-focus > div.commit-links-cell.table-list-cell > div.commit-links-group.BtnGroup > a
    pass


def get_commit_id():
    p = subprocess.Popen("git rev-parse --short HEAD", stdout=subprocess.PIPE, shell=True)
    result, _ = p.communicate()
    result = result.decode("utf-8")
    print(result)


def flags(title: str):
    line = '=' * 16
    print('\n\n{}:\n{}'.format(title, line))

    print('app: {}'.format(is_app_up))
    print('rollbacked: {}'.format(rollbacked))
    print('updated: {}'.format(updated))
    print(line)


def rollback():
    global rollbacked
    print('App is down after update. Rollback change')
    # delete src
    # copy from backup to src
    rollbacked = True
    # run app


def is_update_available() -> bool:
    print('checking if update available')
    return get_commit_id() != current_commit


def download():
    print('downloading last version of project')


def update():
    print('updating project')


def updater():
    print('running updater..')
    if rollbacked and is_app_down():
        print('GobshiteHappens: Updater broke app completely.HELP!')
        return
    if is_not_rolledback() and is_app_down():
        rollback()
        return
    download()
    if is_update_available():
        print('update is available')

    else:
        print('app is up to date')
    print('Done. Bye!')


if __name__ == '__main__':
    flags('ON START')
    updater()
    flags('RESULT')
