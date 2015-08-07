Service :
Service是一个能在后台长时间运行的，没有用户界面的应用组件. 
当某个应用启动service以后，即使用户切换到其他应用，该service还能在后台继续运行. 
其他组件也可以绑定service来互相通讯甚至执行进程间通讯.

特点概括如下：
1. 后台运行
2. 组件通讯，进程间通讯

Service有两种使用方式：
1. started
 startService(), 这种方式启动的service能在后台无限运行，即使启动它的组件被销毁。
 当然如果它本身的操作完成了，则它会自行停止．
 
2. Bound
 bindService(), 这种方式启动的service生命周期取决于绑定它的组件，如果没有组件绑定它（绑定它的所有组件都unbind）了，则
 它会被销毁．
 
 要注意的是，实际使用方式可能２者兼有。
 
 180
service's lifecycle: 
 entire lifetime: 
 	begin with onCreate() 
 	end with onDestroy()
 active lifetime:
 	begins with onStartCommand()/onBind()
 	end with :
 	1.case started:  the same time that the entire lifetime ends
 	2.case bind: ends when onUnbind() returns.
 	
 	
