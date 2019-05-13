#创建项目
1、新建远程仓库 Repositories - New （不选任何初始化信息）
2、用idea创建maven项目 增加.gitignore文件，
    git init
    git add .      #增加所有的到缓冲区
    git status
    git commit -m "初始化项目"
    git remote -v #无值
    #注意.git要存在yx_ssm下面  git remote add并没有真正提交到远程仓库上
    git remote add origin https://github.com/whinsist/yx_ssm 
    git remote -v #有值
    git push origin master   #把master分支推送到origin上去，再刷新网页存在