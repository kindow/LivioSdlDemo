### pre(windows下)  
1. 增加密钥  
<code>
ssh-add ~/.ssh/suntec
</code>  
2. config配置指定user  
<code>
vi ~/.ssh/config  
内容:  
user sangjun
</code>
 
### 代码获取  
1. 创建一个空目录  
2. 获取仓库  
<code>git clone  ssh://igerrit.storm:29418/Src/14Model/iAutoPlatform/JA158/packages
/Apps/SDLApps
</code>
3. 获取代码  
<code>
git checkout -b SDLPOC origin/SDLPOC/master
</code>
4. 增加代码   
<code>git add .  
git status  
git commit -a -m 'init apps'
</code>
5. 提交更改到开发库中  
<code>
git push origin SDLPOC:SDLPOC/master
</code>



