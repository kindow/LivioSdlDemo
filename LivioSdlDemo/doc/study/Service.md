Service :
Service��һ�����ں�̨��ʱ�����еģ�û���û������Ӧ�����. 
��ĳ��Ӧ������service�Ժ󣬼�ʹ�û��л�������Ӧ�ã���service�����ں�̨��������. 
�������Ҳ���԰�service������ͨѶ����ִ�н��̼�ͨѶ.

�ص�������£�
1. ��̨����
2. ���ͨѶ�����̼�ͨѶ

Service������ʹ�÷�ʽ��
1. started
 startService(), ���ַ�ʽ������service���ں�̨�������У���ʹ����������������١�
 ��Ȼ���������Ĳ�������ˣ�����������ֹͣ��
 
2. Bound
 bindService(), ���ַ�ʽ������service��������ȡ���ڰ�������������û��������������������������unbind���ˣ���
 ���ᱻ���٣�
 
 Ҫע����ǣ�ʵ��ʹ�÷�ʽ���ܣ��߼��С�
 
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
 	
 	
