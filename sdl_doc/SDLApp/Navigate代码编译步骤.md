# 在ubuntu 上编译库  
1. 到代码目录下
<code>
cd ~/work/code/android/testForSDL
</code>
2. 确保链接存在
<code>cd /home/sangjun/work/code/android/testForSDL/libraries/navi/build/project/nutshell  
ls -al
</code>  
如果没有链接，则  
<code>
ln -s ../../../data/ data  
ln -s ../../../src/protofiles/ navi  
ln -s ../../../src/ src  
</code>
3. 执行build  
<code>
./build.sh 
</code>
4. 设置环境  
<code>
cd /home/sangjun/work/code/android/testForSDL  
.  libraries/navi/build/project/cmake/setenv.sh
</code>
5. 编译  
<code>
make install-navi
</code>
6. 打包so库，并发送到window开发环境下
<code>
cd /home/sangjun/work/code/android/testForSDL/packages/88map_android/NaviDevLib/libs/armeabi/  
tar -cf so.tar *
</code>

# 在windows上安装so.  
解压so.tar
放到 工程NaviDevLib的 libs/armeabi 目录下
