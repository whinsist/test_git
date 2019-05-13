package com.test.git;

/**
 * @author Hong.Wu
 * @date: 17:48 2019/05/13

git log --pretty=oneline

共提交了4次 回到test reset第2次提交
git reset 7530d8c
（git reset 后面的多次修改都会显示在这个文件上）
（如果又不想reset了 可以先在idead的local change中revert文件 然后重新拉取远程文件git pull origin master）


git reset --hard 7530d8c
(加了hard会直接回到版本,提交执行用命令git push -f origin master(这样会取消其他人的提交 谨用)
默认mixed会把后面后面修改放入缓冲中 确认后在push)



返回第4次提交
git reflog
git reset de3f46a
git push -f origin master
 *
 */
public class Test1GitRest {
    public static void main(String[] args) {
        System.out.println("11111111111111111");
        System.out.println("2222222222222222");
        System.out.println("3333333333");
        System.out.println("4444444444");

    }
}
