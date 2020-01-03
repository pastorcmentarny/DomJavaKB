alias caa = commit -a --amend -C HEAD Which will take all uncommitted and un-staged changes currently in the working directory and add them to the previous commit, amending it before pushing the change up. I use this all the time.
Cleanup merged branches
bclean = "!f() { git branch --merged ${1-master} | grep -v " ${1-master}$" | xargs -r git branch -d; }; f"
The above will remove local branches that have already been merged to master by default, but you can pass a different one if you need to

https://www.atlassian.com/git/tutorials/merging-vs-rebasing